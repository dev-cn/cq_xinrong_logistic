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
import cq.anbu.modules.bill.entity.MinTeEntity;
import cq.anbu.modules.bill.entity.SaWeiAoEntity;
import cq.anbu.modules.bill.service.SaWeiAoService;
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
import java.util.UUID;


/**
 * 萨维奥账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
@RestController
@RequestMapping("/bill/saweiao")
public class SaWeiAoController extends AbstractController{
	@Autowired
	private SaWeiAoService saWeiAoService;
    @Value("${excel.bill.excelName}")
    private String billExcelName;
    @Value("${excel.bill.templatePath}")
    private String billTemplatePath;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("bill:saweiao:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SaWeiAoEntity> saWeiAoList = saWeiAoService.queryList(query);
		int total = saWeiAoService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(saWeiAoList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("bill:saweiao:info")
	public R info(@PathVariable("id") Long id){
		SaWeiAoEntity saWeiAo = saWeiAoService.queryObject(id);
		
		return R.ok().put("saWeiAo", saWeiAo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("bill:saweiao:save")
	public R save(@RequestBody SaWeiAoEntity saWeiAo){
		saWeiAo = wrapperBaseEntity(saWeiAo);
		saWeiAoService.save(saWeiAo);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("bill:saweiao:update")
	public R update(@RequestBody SaWeiAoEntity saWeiAo){
        saWeiAo.setUpdateAt(new Date());
        saWeiAo.setUpdateBy(getUser().getUsername());
		saWeiAoService.update(saWeiAo);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("bill:saweiao:delete")
	public R delete(@RequestBody Long[] ids){
		saWeiAoService.deleteBatch(ids);
		
		return R.ok();
	}


    /**
     * 导出
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void downloadByPoiBaseView(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = Maps.newHashMap();
        List<SaWeiAoEntity> list = this.getSaWeiAoEntityList(request.getParameter("ids"));
        List<Map<String, String>> listMap = ExcelUtils.getJavaBeanAttrAndValue(BeanUtils.nullToBlankList(list));
        map.put("billMap",listMap);
//        目前只需单sheet导出
        ExcelUtils.writeSingleExcel(response,billTemplatePath,billExcelName,map);
    }

    private List<SaWeiAoEntity> getSaWeiAoEntityList(String ids) {
        String[] idsArray = ids.split(",", -1);
        List<SaWeiAoEntity> list = Lists.newArrayList();
        for (String id : idsArray) {
            SaWeiAoEntity saWeiAoEntity = saWeiAoService.queryObject(Long.parseLong(id));
            list.add(saWeiAoEntity);
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
        List<SaWeiAoEntity> saWeiAoEntityList = ExcelImportUtil.importExcel(excelFile, SaWeiAoEntity.class, params);
        try {
            for (SaWeiAoEntity saWeiAo : saWeiAoEntityList) {
                if (StringUtils.isBlank(saWeiAo.getTrackingNo())) {
                    saWeiAo.setTrackingNo(UUID.randomUUID()+"");
                }
                SaWeiAoEntity entity = saWeiAoService.queryObjectByTrackingNo(saWeiAo.getTrackingNo());
                if (entity != null) {
                    return R.error("数据已存在!");
                } else {
                    saWeiAoService.save(saWeiAo);
                }
            }
        } finally {
            //程序结束时，删除临时文件
            deleteFile(excelFile);
        }
        return R.ok();
    }
	
}
