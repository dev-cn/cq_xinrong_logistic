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
import cq.anbu.modules.bill.entity.SiWeiErEntity;
import cq.anbu.modules.bill.service.SiWeiErService;
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
 * 四维尔账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
@RestController
@RequestMapping("/bill/siweier")
public class SiWeiErController extends AbstractController{
	@Autowired
	private SiWeiErService siWeiErService;
    @Value("${excel.bill.excelName}")
    private String billExcelName;
    @Value("${excel.bill.templatePath}")
    private String billTemplatePath;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("bill:siweier:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SiWeiErEntity> siWeiErList = siWeiErService.queryList(query);
		int total = siWeiErService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(siWeiErList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("bill:siweier:info")
	public R info(@PathVariable("id") Long id){
		SiWeiErEntity siWeiEr = siWeiErService.queryObject(id);
		
		return R.ok().put("siWeiEr", siWeiEr);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("bill:siweier:save")
	public R save(@RequestBody SiWeiErEntity siWeiEr){
		siWeiEr = wrapperBaseEntity(siWeiEr);
		siWeiErService.save(siWeiEr);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("bill:siweier:update")
	public R update(@RequestBody SiWeiErEntity siWeiEr){
        siWeiEr.setUpdateAt(new Date());
        siWeiEr.setUpdateBy(getUser().getUsername());
		siWeiErService.update(siWeiEr);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("bill:siweier:delete")
	public R delete(@RequestBody Long[] ids){
		siWeiErService.deleteBatch(ids);
		
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
        List<SiWeiErEntity> list = this.getSiWeiErEntityList(request.getParameter("ids"));
        List<Map<String, String>> listMap = ExcelUtils.getJavaBeanAttrAndValue(BeanUtils.nullToBlankList(list));
        map.put("siWeiErMap",listMap);
//        目前只需单sheet导出
        ExcelUtils.writeSingleExcel(response,billTemplatePath,billExcelName,map);
    }

    private List<SiWeiErEntity> getSiWeiErEntityList(String ids) {
        String[] idsArray = ids.split(",", -1);
        List<SiWeiErEntity> list = Lists.newArrayList();
        for (String id : idsArray) {
            SiWeiErEntity siWeiErEntity = siWeiErService.queryObject(Long.parseLong(id));
            list.add(siWeiErEntity);
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
        List<SiWeiErEntity> siWeiErEntityList = ExcelImportUtil.importExcel(excelFile, SiWeiErEntity.class, params);
        try {
            for (SiWeiErEntity siWeiEr : siWeiErEntityList) {
                if (StringUtils.isNotBlank(siWeiEr.getTrackingNo())) {
                    SiWeiErEntity entity = siWeiErService.queryObjectByTrackingNo(siWeiEr.getTrackingNo());
                    if (entity != null) {
                        return R.error("数据已存在!");
                    } else {
                        siWeiErService.save(siWeiEr);
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
