package cq.anbu.modules.baseinfo.controller;

import com.google.common.collect.Maps;
import cq.anbu.common.annotation.SysLog;
import cq.anbu.common.utils.PageUtils;
import cq.anbu.common.utils.Query;
import cq.anbu.common.utils.R;
import cq.anbu.modules.baseinfo.entity.VehicleEntity;
import cq.anbu.modules.baseinfo.service.VehicleService;
import cq.anbu.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 车辆信息表
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-18 18:47:04
 */
@RestController
@RequestMapping("/baseinfo/vehicle")
public class VehicleController extends AbstractController {
    @Autowired
    private VehicleService vehicleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("baseinfo:vehicle:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<VehicleEntity> vehicleList = vehicleService.queryList(query);
        int total = vehicleService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(vehicleList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 下拉框
     */
    @RequestMapping("/list/select")
    @RequiresPermissions("baseinfo:vehicle:list:select")
    public R select() {
        return R.ok().put("select", vehicleService.queryList(Maps.newHashMap()));
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("baseinfo:vehicle:info")
    public R info(@PathVariable("id") Long id) {
        VehicleEntity vehicle = vehicleService.queryObject(id);

        return R.ok().put("vehicle", vehicle);
    }

    /**
     * 保存
     */
    @SysLog("保存车辆信息")
    @RequestMapping("/save")
    @RequiresPermissions("baseinfo:vehicle:save")
    public R save(@RequestBody VehicleEntity vehicle) {
        vehicleService.save(vehicle);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改车辆信息")
    @RequestMapping("/update")
    @RequiresPermissions("baseinfo:vehicle:update")
    public R update(@RequestBody VehicleEntity vehicle) {
        vehicle.setUpdateAt(new Date());
        vehicle.setUpdateBy(getUser().getUsername());
        vehicleService.update(vehicle);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除车辆信息")
    @RequestMapping("/delete")
    @RequiresPermissions("baseinfo:vehicle:delete")
    public R delete(@RequestBody Long[] ids) {
        vehicleService.deleteBatch(ids);

        return R.ok();
    }

}
