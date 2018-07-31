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
import cq.anbu.modules.bill.entity.YanFengEntity;
import cq.anbu.modules.bill.service.YanFengService;
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
 * 延锋账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
@RestController
@RequestMapping("/bill/yanfeng")
public class YanFengController extends AbstractController{
	@Autowired
	private YanFengService yanFengService;
    @Value("${excel.bill.excelName}")
    private String billExcelName;
    @Value("${excel.bill.templatePath}")
    private String billTemplatePath;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("bill:yanfeng:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<YanFengEntity> yanFengList = yanFengService.queryList(query);
		int total = yanFengService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(yanFengList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("bill:yanfeng:info")
	public R info(@PathVariable("id") Long id){
		YanFengEntity yanFeng = yanFengService.queryObject(id);
		
		return R.ok().put("yanFeng", yanFeng);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("bill:yanfeng:save")
	public R save(@RequestBody YanFengEntity yanFeng){
		yanFeng = wrapperBaseEntity(yanFeng);
		yanFengService.save(yanFeng);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("bill:yanfeng:update")
	public R update(@RequestBody YanFengEntity yanFeng){
        yanFeng.setUpdateAt(new Date());
        yanFeng.setUpdateBy(getUser().getUsername());
		yanFengService.update(yanFeng);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("bill:yanfeng:delete")
	public R delete(@RequestBody Long[] ids){
		yanFengService.deleteBatch(ids);
		
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
        List<YanFengEntity> list = this.getYanFengEntityList(request.getParameter("ids"));
        List<Map<String, String>> listMap = ExcelUtils.getJavaBeanAttrAndValue(BeanUtils.nullToBlankList(list));
        map.put("yanFengMap",listMap);
//        目前只需单sheet导出
        ExcelUtils.writeSingleExcel(response,billTemplatePath,billExcelName,map);
    }

    private List<YanFengEntity> getYanFengEntityList(String ids) {
        String[] idsArray = ids.split(",", -1);
        List<YanFengEntity> list = Lists.newArrayList();
        for (String id : idsArray) {
            YanFengEntity yanFengEntity = yanFengService.queryObject(Long.parseLong(id));
            list.add(yanFengEntity);
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
        List<YanFengEntity> yanFengEntityList = ExcelImportUtil.importExcel(excelFile, YanFengEntity.class, params);
        try {
            for (YanFengEntity yanFeng : yanFengEntityList) {
                if (StringUtils.isNotBlank(yanFeng.getTrackingNo())) {
                    YanFengEntity entity = yanFengService.queryObjectByTrackingNo(yanFeng.getTrackingNo());
                    if (entity != null) {
                        return R.error("数据已存在!");
                    } else {
                        yanFengService.save(yanFeng);
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
