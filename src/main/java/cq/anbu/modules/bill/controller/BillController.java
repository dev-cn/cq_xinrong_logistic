package cq.anbu.modules.bill.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import cq.anbu.common.exception.RRException;
import cq.anbu.common.utils.PageUtils;
import cq.anbu.common.utils.Query;
import cq.anbu.common.utils.R;
import cq.anbu.common.utils.excel.ExcelUtils;
import cq.anbu.modules.bill.entity.BillEntity;
import cq.anbu.modules.bill.service.BillService;
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
 * 账单表
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-06-10 09:48:20
 */
@RestController
@RequestMapping("/bill/bill")
public class BillController extends AbstractController {
    @Autowired
    private BillService billService;
    @Value("${excel.bill.excelName}")
    private String billExcelName;
    @Value("${excel.bill.templatePath}")
    private String billTemplatePath;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bill:bill:list")
    public R list(@RequestParam Map<String, Object> params) {
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
    public R info(@PathVariable("id") Long id) {
        BillEntity bill = billService.queryObject(id);

        return R.ok().put("bill", bill);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("bill:bill:save")
    public R save(@RequestBody BillEntity bill) {
        bill = wrapperBaseEntity(bill);
        billService.save(bill);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("bill:bill:update")
    public R update(@RequestBody BillEntity bill) {
        bill.setUpdateAt(new Date());
        bill.setUpdateBy(getUser().getUsername());
        billService.update(bill);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("bill:bill:delete")
    public R delete(@RequestBody Long[] ids) {
        billService.deleteBatch(ids);

        return R.ok();
    }


	/*@RequestMapping(value = "/export",method = RequestMethod.GET)
    public R export(HttpServletRequest request, HttpServletResponse response){
		String ids = request.getParameter("ids");
		String[] idsArray = ids.split(",", -1);
		List<BillEntity> billCollectEntityList = new ArrayList<>();
		BillEntity billEntity;
		for(String id : idsArray){
			billEntity = billService.queryObject(Long.parseLong(id));
			billCollectEntityList.add(billEntity);
		}
		String templateFilePath = ExcelExportUtil.class.getClassLoader().getResource("excel/test.xlsx").getPath();
			ExcelExportUtil excel = new ExcelExportUtil();
			List<Map<Integer, Object>> datalist = new ArrayList<Map<Integer, Object>>();
			for(BillEntity entity : billCollectEntityList) {
				Map<Integer, Object> data = new HashMap<Integer, Object>();
				data.put(1,entity.getSerialNo()+"");
				data.put(2,entity.getTrackingNo()+"");
				data.put(3,entity.getDeliveryDate()+"");
				data.put(4,entity.getArrivalDate()+"");
				data.put(5,entity.getDeliveryAddr());
				data.put(6,entity.getArrivalAddr());
				data.put(7,entity.getGoodsName());
				data.put(8,entity.getLoadingModel());
				data.put(9,entity.getPalteNo()+"");
				data.put(10,entity.getTrainNo()+"");
				data.put(11,entity.getShippedQuantity()+"");
				data.put(12,entity.getWeight()+"");
				data.put(13,entity.getPrice()+"");
				data.put(14,entity.getPickUpCharge()+"");
				data.put(15,entity.getDeliveryFee()+"");
				data.put(16,entity.getTotalExpenses()+"");
				data.put(17,entity.getComment());
				datalist.add(data);
			}
			String[] heads = new String[]{"A4","B4", "C4", "D4", "E4", "F4", "G4", "H4","I4","J4","K4","L4","M4","N4","O4","P4","Q4"};
		Workbook workbook = null;
		try {
			workbook = excel.writeDateList(templateFilePath, heads, datalist, 0);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		// 判断数据
			if(workbook == null) {
				return R.error("fail");
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
			return R.ok();
	}
*/

    /**
     * 导出
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public String downloadByPoiBaseView(HttpServletRequest request, HttpServletResponse response) {
        Map<Integer, Map<String, Object>> sheetMap = Maps.newHashMap();
        Map<String, Object> map = Maps.newHashMap();
        Map<String, Object> mapOne = Maps.newHashMap();
        List<BillEntity> list = this.getBillEntityList(request.getParameter("ids"));
        List<Map<String, String>> listMap = ExcelUtils.getJavaBeanAttrAndValue(list);
        map.put("billMap", listMap);
        sheetMap.put(0, map);
        mapOne.put("billMapOne", listMap);
        sheetMap.put(1, mapOne);
        return ExcelUtils.writeManyExcel(response, billTemplatePath, billExcelName, sheetMap);
    }

    private List<BillEntity> getBillEntityList(String ids) {
        String[] idsArray = ids.split(",", -1);
        List<BillEntity> list = Lists.newArrayList();
        for (String id : idsArray) {
            BillEntity billEntity = billService.queryObject(Long.parseLong(id));
            list.add(billEntity);
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
        List<BillEntity> billEntityList = ExcelImportUtil.importExcel(excelFile, BillEntity.class, params);
        try {
            for (BillEntity bill : billEntityList) {
                if (StringUtils.isNotBlank(bill.getTrackingNo())) {
                    BillEntity entity = billService.queryObjectByTrackingNo(bill.getTrackingNo());
                    if (entity != null) {
                        return R.error("数据已存在!");
                    } else {
                        billService.save(bill);
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
