package cq.anbu.modules.bill.controller;

import cq.anbu.common.annotation.SysLog;
import cq.anbu.common.utils.R;
import cq.anbu.modules.bill.entity.BillEntity;
import cq.anbu.modules.bill.service.BillService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class BillController extends BaseBillController<BillService,BillEntity> {

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("bill:bill:list")
    public R list(@RequestParam Map<String, Object> params) {
      return super.list(params);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("bill:bill:info")
    public R info(@PathVariable("id") Long id) {
        BillEntity bill = service.queryObject(id);
        return R.ok().put("bill", bill);
    }

    /**
     * 保存
     */
    @SysLog("保存账单")
    @RequestMapping("/save")
    @RequiresPermissions("bill:bill:save")
    public R save(@RequestBody BillEntity bill) {
        return super.save(bill);
    }

    /**
     * 修改
     */
    @SysLog("修改账单")
    @RequestMapping("/update")
    @RequiresPermissions("bill:bill:update")
    public R update(@RequestBody BillEntity bill) {
        return super.update(bill);
    }

    /**
     * 删除
     */
    @SysLog("删除账单")
    @RequestMapping("/delete")
    @RequiresPermissions("bill:bill:delete")
    public R delete(@RequestBody Long[] ids) {
        return super.delete(ids);
    }


	/*@RequestMapping(value = "/export",method = RequestMethod.GET)
    public R export(HttpServletRequest request, HttpServletResponse response){
		String ids = request.getParameter("ids");
		String[] idsArray = ids.split(",", -1);
		List<BillEntity> billCollectEntityList = new ArrayList<>();
		BillEntity billEntity;
		for(String id : idsArray){
			billEntity = billServiceImpl.queryObject(Long.parseLong(id));
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
    @SysLog("导出账单")
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void downloadByPoiBaseView(HttpServletRequest request, HttpServletResponse response) {
        super.downloadByPoiBaseView(request,response);
    }

    @SysLog("导入账单")
    @RequestMapping(value = "excelImport")
    public R excelImport(@RequestParam("file") MultipartFile multfile, HttpServletRequest request) throws Exception {
        return super.excelImport(multfile,request);
    }

}
