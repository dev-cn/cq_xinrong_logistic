package cq.anbu.modules.baseinfo.controller;

import cq.anbu.common.utils.PageUtils;
import cq.anbu.common.utils.Query;
import cq.anbu.common.utils.R;
import cq.anbu.modules.baseinfo.entity.CustomerEntity;
import cq.anbu.modules.baseinfo.service.CustomerService;
import cq.anbu.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 客户信息表
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-18 18:47:04
 */
@RestController
@RequestMapping("/baseinfo/customer")
public class CustomerController extends AbstractController {
    @Autowired
    private CustomerService customerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("baseinfo:customer:list")
    public R list(@RequestParam Map<String, Object> params) {
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
    @RequiresPermissions("baseinfo:customer:info")
    public R info(@PathVariable("id") Long id) {
        CustomerEntity customer = customerService.queryObject(id);

        return R.ok().put("customer", customer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("baseinfo:customer:save")
    public R save(@RequestBody CustomerEntity customer) {
        customer = wrapperBaseEntity(customer);
        customerService.save(customer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("baseinfo:customer:update")
    public R update(@RequestBody CustomerEntity customer) {
        customer.setUpdateAt(new Date());
        customer.setUpdateBy(getUser().getUsername());
        customerService.update(customer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("baseinfo:customer:delete")
    public R delete(@RequestBody Long[] ids) {
        customerService.deleteBatch(ids);

        return R.ok();
    }

}
