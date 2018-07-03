package cq.anbu.modules.bill.controller;

import com.google.common.collect.Lists;
import cq.anbu.common.utils.IOUtils;
import cq.anbu.common.utils.PageUtils;
import cq.anbu.common.utils.Query;
import cq.anbu.common.utils.R;
import cq.anbu.common.utils.excel.ExcelUtils;
import cq.anbu.modules.bill.entity.BillCollectEntity;
import cq.anbu.modules.bill.service.BillCollectService;
import cq.anbu.modules.sys.controller.AbstractController;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
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
public class BillCollectController extends AbstractController {
    @Autowired
    private BillCollectService billCollectService;
    @Value("${excel.billCollect.excelName}")
    private String billCollectExcelName;
    @Value("${excel.billCollect.templatePath}")
    private String billCollectTemplatePath;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bill:billcollect:list")
    public R list(@RequestParam Map<String, Object> params) {
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
    public R info(@PathVariable("id") Long id) {
        BillCollectEntity billCollect = billCollectService.queryObject(id);

        return R.ok().put("billCollect", billCollect);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bill:billcollect:save")
    public R save(@RequestBody BillCollectEntity billCollect) {
        billCollectService.save(billCollect);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bill:billcollect:update")
    public R update(@RequestBody BillCollectEntity billCollect) {
        billCollectService.update(billCollect);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bill:billcollect:delete")
    public R delete(@RequestBody Long[] ids) {
        billCollectService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 导出
     *
     * @param request
     * @param response
     */

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public String downloadByPoiBaseView(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<BillCollectEntity> list = this.getBillCollectEntityList(request.getParameter("ids"));
        List<Map<String, String>> listMap = ExcelUtils.getJavaBeanAttrAndValue(list);
        map.put("billCollectMap", listMap);
        Workbook workbook = ExcelUtils.getWorkbookSingleSheet(billCollectTemplatePath, map);
        if (workbook == null) {
            return "fail";
        }
        String fileName = ExcelUtils.getExcelName(billCollectExcelName);
        IOUtils.writeExcel(response, workbook, fileName);
        return "success";
    }

    private List<BillCollectEntity> getBillCollectEntityList(String ids) {
        String[] idsArray = ids.split(",", -1);
        List<BillCollectEntity> list = Lists.newArrayList();
        for (String id : idsArray) {
            BillCollectEntity billCollectEntity = billCollectService.queryObject(Long.parseLong(id));
            list.add(billCollectEntity);
        }
        return list;
    }

}
