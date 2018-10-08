package cq.anbu.modules.bill.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import cq.anbu.common.exception.RRException;
import cq.anbu.common.utils.PageUtils;
import cq.anbu.common.utils.Query;
import cq.anbu.common.utils.R;
import cq.anbu.common.utils.common.BeanUtils;
import cq.anbu.common.utils.excel.ExcelUtils;
import cq.anbu.modules.bill.entity.BaseBillEntity;
import cq.anbu.modules.bill.service.BaseBillService;
import cq.anbu.modules.sys.controller.AbstractController;
import cq.anbu.modules.sys.oauth2.TokenGenerator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class BaseBillController<S extends BaseBillService,E extends BaseBillEntity> extends AbstractController {
    @Autowired
    protected S service;
    @Value("${excel.bill.excelName}")
    private String billExcelName;
    @Value("${excel.bill.templatePath}")
    private String billTemplatePath;

    /**
     * 列表
     */
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<E> queryList = service.queryList(query);
        int total = service.queryTotal(query);
        PageUtils pageUtil = new PageUtils(queryList, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }

 /*   public E info(@PathVariable("id") Long id) {
        return (E) service.queryObject(id);
    }*/

    /**
     * 保存
     */
    public R save(@RequestBody E entity){
        service.save(wrapperBaseEntity(entity));
        return R.ok();
    }

    /**
     * 修改
     */
    public R update(@RequestBody E entity){
        entity.setUpdateAt(new Date());
        entity.setUpdateBy(getUser().getUsername());
        service.update(entity);
        return R.ok();
    }

    /**
     * 删除
     */
    public R delete(@RequestBody Long[] ids){
        service.deleteBatch(ids);
        return R.ok();
    }


    /**
     * 导出
     *
     * @param request
     * @param response
     */
    public void downloadByPoiBaseView(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = Maps.newHashMap();
        List<E> list = this.getEntityList(request.getParameter("ids"));
        List<Map<String, String>> listMap = ExcelUtils.getJavaBeanAttrAndValue(BeanUtils.nullToBlankList(list));
        map.put("billMap",listMap);
//        目前只需单sheet导出
        ExcelUtils.writeSingleExcel(response,billTemplatePath,billExcelName,map);
    }

    private List<E> getEntityList(String ids) {
        String[] idsArray = ids.split(",", -1);
        List<E> list = Lists.newArrayList();
        for (String id : idsArray) {
            E entity = (E) service.queryObject(Long.parseLong(id));
            list.add(entity);
        }
        return list;
    }

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
        List<E> entityList = ExcelImportUtil.importExcel(excelFile, BaseBillEntity.class, params);
        try {
            for (E billEntity : entityList) {
                if (StringUtils.isBlank(billEntity.getTrackingNo())) {
                    billEntity.setTrackingNo(UUID.randomUUID()+"");
                }
                E entity = (E) service.queryObjectByTrackingNo(billEntity.getTrackingNo());
                if (entity != null) {
                    return R.error("数据已存在!");
                } else {
                    service.save(billEntity);
                }
            }
        } finally {
            //程序结束时，删除临时文件
            deleteFile(excelFile);
        }
        return R.ok();
    }
}
