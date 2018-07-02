package cq.anbu.modules.bill.controller;

import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cq.anbu.common.utils.PageUtils;
import cq.anbu.common.utils.Query;
import cq.anbu.common.utils.R;
import cq.anbu.modules.bill.entity.BillPackingMaterialsEntity;
import cq.anbu.modules.bill.service.BillPackingMaterialsService;
import cq.anbu.modules.sys.controller.AbstractController;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

import static cn.afterturn.easypoi.excel.ExcelExportUtil.exportExcel;


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
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("bill:billpackingmaterials:list")
	public R list(@RequestParam Map<String, Object> params){
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
	public R info(@PathVariable("id") Long id){
		BillPackingMaterialsEntity billPackingMaterials = billPackingMaterialsService.queryObject(id);
		
		return R.ok().put("billPackingMaterials", billPackingMaterials);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("bill:billpackingmaterials:save")
	public R save(@RequestBody BillPackingMaterialsEntity billPackingMaterials){
		billPackingMaterialsService.save(billPackingMaterials);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("bill:billpackingmaterials:update")
	public R update(@RequestBody BillPackingMaterialsEntity billPackingMaterials){
		billPackingMaterialsService.update(billPackingMaterials);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("bill:billpackingmaterials:delete")
	public R delete(@RequestBody Long[] ids){
		billPackingMaterialsService.deleteBatch(ids);
		
		return R.ok();
	}

	/**
	 * 导出
	 * @param map
	 * @param request
	 * @param response
	 */

	@RequestMapping(value="/export",method = RequestMethod.GET)
	public String downloadByPoiBaseView(HttpServletRequest request, HttpServletResponse response) {
		String ids = request.getParameter("ids");
		String[] idsArray = ids.split(",", -1);
		// 获取workbook对象
		Workbook workbook = exportSheetByTemplate(idsArray) ;
		// 判断数据
		if(workbook == null) {
			return "fail";
		}
		// 设置excel的文件名称
		String excelName = "测试excel" ;
		// 重置响应对象
		response.reset();
		// 当前日期，用于导出文件名称
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateStr = "["+excelName+"-"+sdf.format(new Date())+"]";
		// 指定下载的文件名--设置响应头
		response.setHeader("Content-Disposition", "attachment;filename=" +dateStr+".xlsx");
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 写出数据输出流到页面
		try {
			OutputStream output = response.getOutputStream();
			BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
			workbook.write(bufferedOutPut);
			bufferedOutPut.flush();
			bufferedOutPut.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/**
	 * 模版单sheet导出示例
	 * @return
	 */
	public Workbook exportSheetByTemplate(String[] idsArray){
		Map<String, Object> map = new HashMap<String, Object>();
		List<BillPackingMaterialsEntity> billPackingMaterialsList = new ArrayList<>();
		BillPackingMaterialsEntity billPackingMaterialsEntity;
		for(String id : idsArray){
			billPackingMaterialsEntity = billPackingMaterialsService.queryObject(Long.parseLong(id));
			billPackingMaterialsList.add(billPackingMaterialsEntity);
		}
		List<Map<String, String>> listMap = getJavaBeanAttrAndValue(billPackingMaterialsList);
		map.put("billPackingMaterials",listMap);
		// 设置导出配置
		// 获取导出excel指定模版
		TemplateExportParams params = new TemplateExportParams("excel/billPackingMaterials.xlsx");
		// 导出excel
		return exportExcel(params,map);
	}

	public static List<Map<String,String>> getJavaBeanAttrAndValue(List<BillPackingMaterialsEntity> clazzList){
		List<Map<String,String>> resultList = new ArrayList<>();
		for(BillPackingMaterialsEntity t : clazzList){
			Field[] declaredFields = t.getClass().getDeclaredFields();
			Field.setAccessible(declaredFields,true);
			Map<String,String> map = new HashMap<>();
			for(int i=0;i<declaredFields.length;i++){
				try {
					map.put(declaredFields[i].getName(),declaredFields[i].get(t)+"");
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			resultList.add(map);
		}
		return resultList;
	}

}
