package cq.xinrong.modules.bill.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cq.xinrong.modules.bill.entity.BillEntity;
import cq.xinrong.modules.bill.service.BillService;
import cq.xinrong.common.utils.PageUtils;
import cq.xinrong.common.utils.Query;
import cq.xinrong.common.utils.R;




/**
 * 账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-06-10 09:48:20
 */
@RestController
@RequestMapping("/bill/bill")
public class BillController {
	@Autowired
	private BillService billService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("bill:bill:list")
	public R list(@RequestParam Map<String, Object> params){
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
	public R info(@PathVariable("id") Long id){
		BillEntity bill = billService.queryObject(id);
		
		return R.ok().put("bill", bill);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("bill:bill:save")
	public R save(@RequestBody BillEntity bill){
		billService.save(bill);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("bill:bill:update")
	public R update(@RequestBody BillEntity bill){
		billService.update(bill);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("bill:bill:delete")
	public R delete(@RequestBody Long[] ids){
		billService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
