package cq.anbu.modules.bill.controller;

import cq.anbu.common.utils.PageUtils;
import cq.anbu.common.utils.Query;
import cq.anbu.common.utils.R;
import cq.anbu.modules.bill.entity.BillCollectEntity;
import cq.anbu.modules.bill.service.BillCollectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class BillCollectController {
	@Autowired
	private BillCollectService billCollectService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("bill:billcollect:list")
	public R list(@RequestParam Map<String, Object> params){
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
	public R info(@PathVariable("id") Long id){
		BillCollectEntity billCollect = billCollectService.queryObject(id);
		
		return R.ok().put("billCollect", billCollect);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("bill:billcollect:save")
	public R save(@RequestBody BillCollectEntity billCollect){
		billCollectService.save(billCollect);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("bill:billcollect:update")
	public R update(@RequestBody BillCollectEntity billCollect){
		billCollectService.update(billCollect);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("bill:billcollect:delete")
	public R delete(@RequestBody Long[] ids){
		billCollectService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
