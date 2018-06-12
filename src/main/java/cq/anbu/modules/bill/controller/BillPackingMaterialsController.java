package cq.anbu.modules.bill.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cq.anbu.modules.bill.entity.BillPackingMaterialsEntity;
import cq.anbu.modules.bill.service.BillPackingMaterialsService;
import cq.anbu.common.utils.PageUtils;
import cq.anbu.common.utils.Query;
import cq.anbu.common.utils.R;




/**
 * 包材表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-06-12 09:49:45
 */
@RestController
@RequestMapping("/bill/billpackingmaterials")
public class BillPackingMaterialsController {
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
	
}
