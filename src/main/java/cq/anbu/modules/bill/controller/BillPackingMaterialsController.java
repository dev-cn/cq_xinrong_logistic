package cq.anbu.modules.bill.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.google.common.collect.Lists;
import cq.anbu.common.exception.RRException;
import cq.anbu.common.utils.PageUtils;
import cq.anbu.common.utils.Query;
import cq.anbu.common.utils.R;
import cq.anbu.common.utils.excel.ExcelUtils;
import cq.anbu.modules.bill.entity.BillPackingMaterialsEntity;
import cq.anbu.modules.bill.service.BillPackingMaterialsService;
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
 * 包材表
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-06-12 09:49:45
 */
@RestController
@RequestMapping("/bill/billpackingmaterials")
public class BillPackingMaterialsController extends AbstractController {
    @Autowired
    private BillPackingMaterialsService billPackingMaterialsService;
    @Value("${excel.billPackingMaterials.excelName}")
    private String billPackingMaterialsExcelName;
    @Value("${excel.billPackingMaterials.templatePath}")
    private String billPackingMaterialsTemplatePath;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bill:billpackingmaterials:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<BillPackingMaterialsEntity> billPackingMaterialsList = billPackingMaterialsService.queryList(query);
        int total = billPackingMaterialsService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(billPackingMaterialsList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("bill:billpackingmaterials:info")
    public R info(@PathVariable("id") Long id) {
        BillPackingMaterialsEntity billPackingMaterials = billPackingMaterialsService.queryObject(id);
        return R.ok().put("billPackingMaterials", billPackingMaterials);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bill:billpackingmaterials:save")
    public R save(@RequestBody BillPackingMaterialsEntity billPackingMaterials) {
        billPackingMaterials = wrapperBaseEntity(billPackingMaterials);
        billPackingMaterialsService.save(billPackingMaterials);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bill:billpackingmaterials:update")
    public R update(@RequestBody BillPackingMaterialsEntity billPackingMaterials) {
        billPackingMaterials.setUpdateAt(new Date());
        billPackingMaterials.setUpdateBy(getUser().getUsername());
        billPackingMaterialsService.update(billPackingMaterials);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bill:billpackingmaterials:delete")
    public R delete(@RequestBody Long[] ids) {
        billPackingMaterialsService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 导出
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void downloadByPoiBaseView(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<BillPackingMaterialsEntity> list = this.getBillPackingMaterialsEntityList(request.getParameter("ids"));
        map.put("billPackingMaterials", ExcelUtils.getJavaBeanAttrAndValue(list));
         ExcelUtils.writeSingleExcel(response, billPackingMaterialsTemplatePath, billPackingMaterialsExcelName, map);
    }

    private List<BillPackingMaterialsEntity> getBillPackingMaterialsEntityList(String ids) {
        String[] idsArray = ids.split(",", -1);
        List<BillPackingMaterialsEntity> list = Lists.newArrayList();
        for (String id : idsArray) {
            BillPackingMaterialsEntity billPackingMaterialsEntity = billPackingMaterialsService.queryObject(Long.parseLong(id));
            list.add(billPackingMaterialsEntity);
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
        List<BillPackingMaterialsEntity> billEntityList = ExcelImportUtil.importExcel(excelFile, BillPackingMaterialsEntity.class, params);
        try {
            for (BillPackingMaterialsEntity billCollectMaterials : billEntityList) {
                if (StringUtils.isNotBlank(billCollectMaterials.getTranspotNo())) {
                    BillPackingMaterialsEntity entity = billPackingMaterialsService.queryObjectByTranspotNo(billCollectMaterials.getTranspotNo());
                    if (entity != null) {
                        return R.error("数据已存在!");
                    } else {
                        billPackingMaterialsService.save(billCollectMaterials);
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
