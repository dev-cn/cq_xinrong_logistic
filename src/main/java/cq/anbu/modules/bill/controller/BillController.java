package cq.anbu.modules.bill.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import cq.anbu.common.exception.RRException;
import cq.anbu.common.utils.PageUtils;
import cq.anbu.common.utils.Query;
import cq.anbu.common.utils.R;
import cq.anbu.common.utils.excel.ExcelUtils;
import cq.anbu.modules.bill.entity.BillEntity;
import cq.anbu.modules.bill.service.BillService;
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
import java.util.List;
import java.util.Map;


/**
 * 账单表
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-06-10 09:48:20
 */
@RestController
@RequestMapping("/bill/bill")
public class BillController extends AbstractController {
    @Autowired
    private BillService billService;
    @Value("${excel.bill.excelName}")
    private String billExcelName;
    @Value("${excel.bill.templatePath}")
    private String billTemplatePath;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bill:bill:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<BillEntity> billList = billService.queryList(query);
        int total = billService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(billList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("bill:bill:info")
    public R info(@PathVariable("id") Long id) {
        BillEntity bill = billService.queryObject(id);

        return R.ok().put("bill", bill);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bill:bill:save")
    public R save(@RequestBody BillEntity bill) {
        bill = wrapperBaseEntity(bill);
        billService.save(bill);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bill:bill:update")
    public R update(@RequestBody BillEntity bill) {
        bill.setUpdateAt(new Date());
        bill.setUpdateBy(getUser().getUsername());
        billService.update(bill);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bill:bill:delete")
    public R delete(@RequestBody Long[] ids) {
        billService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 导出
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public String downloadByPoiBaseView(HttpServletRequest request, HttpServletResponse response) {
        Map<Integer, Map<String, Object>> sheetMap = Maps.newHashMap();
        Map<String, Object> map = Maps.newHashMap();
        List<BillEntity> list = this.getBillEntityList(request.getParameter("ids"));
        List<Map<String, String>> listMap = ExcelUtils.getJavaBeanAttrAndValue(list);
        map.put("billMap", listMap);
        map.put("billMap1", listMap);
        sheetMap.put(0, map);
        sheetMap.put(1, map);
        return ExcelUtils.writeManyExcel(response, billTemplatePath, billExcelName, sheetMap);
    }

    private List<BillEntity> getBillEntityList(String ids) {
        String[] idsArray = ids.split(",", -1);
        List<BillEntity> list = Lists.newArrayList();
        for (String id : idsArray) {
            BillEntity billEntity = billService.queryObject(Long.parseLong(id));
            list.add(billEntity);
        }
        return list;
    }

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
        List<BillEntity> billEntityList = ExcelImportUtil.importExcel(excelFile, BillEntity.class, params);
        try {
            for (BillEntity bill : billEntityList) {
                if (StringUtils.isNotBlank(bill.getTrackingNo())) {
                    BillEntity entity = billService.queryObjectByTrackingNo(bill.getTrackingNo());
                    if (entity != null) {
                        return R.error("数据已存在!");
                    } else {
                        billService.save(bill);
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

    /**
     * 删除
     *
     * @param files
     */
    private void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
