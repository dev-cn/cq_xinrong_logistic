package cq.anbu.modules.bill.controller;

import cq.anbu.common.utils.PageUtils;
import cq.anbu.common.utils.Query;
import cq.anbu.common.utils.R;
import cq.anbu.modules.bill.entity.AbParameterEntity;
import cq.anbu.modules.bill.service.AbParameterService;
import cq.anbu.modules.sys.controller.AbstractController;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 字典
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-18 13:28:53
 */
@RestController
@RequestMapping("/bill/abparameter")
public class AbParameterController extends AbstractController {
    @Autowired
    private AbParameterService abParameterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bill:abparameter:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<AbParameterEntity> abParameterList = abParameterService.queryList(query);
        int total = abParameterService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(abParameterList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("bill:abparameter:info")
    public R info(@PathVariable("id") Long id) {
        AbParameterEntity abParameter = abParameterService.queryObject(id);

        return R.ok().put("abParameter", abParameter);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bill:abparameter:save")
    public R save(@RequestBody AbParameterEntity abParameter) {
        abParameter = wrapperBaseEntity(abParameter);
        abParameterService.save(abParameter);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bill:abparameter:update")
    public R update(@RequestBody AbParameterEntity abParameter) {
        abParameter.setUpdateAt(new Date());
        abParameter.setUpdateBy(getUser().getUsername());
        abParameterService.update(abParameter);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bill:abparameter:delete")
    public R delete(@RequestBody Long[] ids) {
        abParameterService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 通过parentCode查询列表
     */
    @RequestMapping(value = "/queryParams", method = RequestMethod.POST)
    public R queryParameters(@RequestBody AbParameterEntity abParameter) {
        logger.info("parentCode:" + abParameter.getParaParentCode());
        String parentCode = abParameter.getParaParentCode();
        List<AbParameterEntity> paramList = new ArrayList<>();
        if (StringUtils.isNotEmpty(parentCode)) {
            paramList = abParameterService.queryParamList(abParameter);
        }
        return R.ok().put("paramList", paramList);
    }

}
