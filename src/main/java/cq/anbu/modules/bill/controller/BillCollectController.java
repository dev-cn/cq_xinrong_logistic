package cq.anbu.modules.bill.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.google.common.collect.Lists;
import cq.anbu.common.annotation.SysLog;
import cq.anbu.common.exception.RRException;
import cq.anbu.common.utils.PageUtils;
import cq.anbu.common.utils.Query;
import cq.anbu.common.utils.R;
import cq.anbu.common.utils.excel.ExcelUtils;
import cq.anbu.modules.bill.entity.BillCollectEntity;
import cq.anbu.modules.bill.service.BillCollectService;
import cq.anbu.modules.sys.controller.AbstractController;
import cq.anbu.modules.sys.oauth2.TokenGenerator;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 运费汇总表
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-06-10 09:48:20
 */
@RestController
@RequestMapping("/bill/billcollect")
public class BillCollectController extends AbstractController {
    @Autowired
    private BillCollectService billCollectService;
    @Value("${excel.billCollect.excelName}")
    private String billCollectExcelName;
    @Value("${excel.billCollect.templatePath}")
    private String billCollectTemplatePath;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bill:billcollect:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<BillCollectEntity> billCollectList = billCollectService.queryList(query);
        int total = billCollectService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(billCollectList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("bill:billcollect:info")
    public R info(@PathVariable("id") Long id) {
        BillCollectEntity billCollect = billCollectService.queryObject(id);

        return R.ok().put("billCollect", billCollect);
    }

    /**
     * 保存
     */
    @SysLog("保存汇总")
    @RequestMapping("/save")
    @RequiresPermissions("bill:billcollect:save")
    public R save(@RequestBody BillCollectEntity billCollect) {
        billCollect = wrapperBaseEntity(billCollect);
        billCollectService.save(billCollect);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改汇总")
    @RequestMapping("/update")
    @RequiresPermissions("bill:billcollect:update")
    public R update(@RequestBody BillCollectEntity billCollect) {
        billCollect.setUpdateAt(new Date());
        billCollect.setUpdateBy(getUser().getUsername());
        billCollectService.update(billCollect);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除汇总")
    @RequestMapping("/delete")
    @RequiresPermissions("bill:billcollect:delete")
    public R delete(@RequestBody Long[] ids) {
        billCollectService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 导出
     *
     * @param request
     * @param response
     */
    @SysLog("导出汇总")
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void downloadByPoiBaseView(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<BillCollectEntity> list = this.getBillCollectEntityList(request.getParameter("ids"));
        List<Map<String, String>> listMap = ExcelUtils.getJavaBeanAttrAndValue(list);
        map.put("billCollectMap", listMap);
        ExcelUtils.writeSingleExcel(response, billCollectTemplatePath, billCollectExcelName, map);
    }

    private List<BillCollectEntity> getBillCollectEntityList(String ids) {
        String[] idsArray = ids.split(",", -1);
        List<BillCollectEntity> list = Lists.newArrayList();
        for (String id : idsArray) {
            BillCollectEntity billCollectEntity = billCollectService.queryObject(Long.parseLong(id));
            list.add(billCollectEntity);
        }
        return list;
    }

    /**
     * 导入
     *
     * @param multfile
     * @param request
     * @return
     * @throws Exception
     */
    @SysLog("导入汇总")
    @RequestMapping(value = "excelImport")
    public R excelImport(@RequestParam("file") MultipartFile multfile, HttpServletRequest request) throws Exception {
        if (multfile.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        // 获取文件名
        String fileName = multfile.getOriginalFilename();
        // 获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        // 用uuid作为文件名，防止生成的临时文件重复
        final File excelFile = File.createTempFile(TokenGenerator.generateValue(), prefix);
        // MultipartFile to File
        multfile.transferTo(excelFile);
        //设置导入参数
        ImportParams params = new ImportParams();
        params.setTitleRows(2);
        params.setHeadRows(1);
        List<BillCollectEntity> billEntityList = ExcelImportUtil.importExcel(excelFile, BillCollectEntity.class, params);
        try {
            for (BillCollectEntity billCollect : billEntityList) {
                if (StringUtils.isNotBlank(billCollect.getTranspotNo())) {
                    BillCollectEntity entity = billCollectService.queryObjectByTranspotNo(billCollect.getTranspotNo());
                    if (entity != null) {
                        return R.error("数据已存在!");
                    } else {
                        billCollectService.save(billCollect);
                    }
                } else {
                    return R.error("导入的数据中运单号不存在,请检查数据是否正确");
                }
            }
        } finally {
            //程序结束时，删除临时文件
            deleteFile(excelFile);
        }
        return R.ok();
    }

}
