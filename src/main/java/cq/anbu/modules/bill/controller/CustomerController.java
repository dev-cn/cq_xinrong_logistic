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

import cq.anbu.modules.bill.entity.CustomerEntity;
import cq.anbu.modules.bill.service.CustomerService;
import cq.anbu.common.utils.PageUtils;
import cq.anbu.common.utils.Query;
import cq.anbu.common.utils.R;




/**
 * 客户信息表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-18 18:47:04
 */
@RestController
@RequestMapping("/bill/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("bill:customer:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CustomerEntity> customerList = customerService.queryList(query);
		int total = customerService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(customerList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("bill:customer:info")
	public R info(@PathVariable("id") Long id){
		CustomerEntity customer = customerService.queryObject(id);
		
		return R.ok().put("customer", customer);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("bill:customer:save")
	public R save(@RequestBody CustomerEntity customer){
		customerService.save(customer);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("bill:customer:update")
	public R update(@RequestBody CustomerEntity customer){
		customerService.update(customer);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("bill:customer:delete")
	public R delete(@RequestBody Long[] ids){
		customerService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
