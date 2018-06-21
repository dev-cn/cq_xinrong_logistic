package cq.anbu.modules.bill.controller;

import cq.anbu.common.exception.RRException;
import cq.anbu.common.utils.PageUtils;
import cq.anbu.common.utils.Query;
import cq.anbu.common.utils.R;
import cq.anbu.common.utils.excel.ExcelExportUtil;
import cq.anbu.modules.bill.entity.BillEntity;
import cq.anbu.modules.bill.service.BillService;
import cq.anbu.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;


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
		bill = wrapperBaseEntity(bill);
		billService.save(bill);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("bill:bill:update")
	public R update(@RequestBody BillEntity bill){
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
	public R delete(@RequestBody Long[] ids){
		billService.deleteBatch(ids);
		
		return R.ok();
	}

	/**
	 * 导出
	 */
	@RequestMapping("/export")
	public R export(@RequestBody Long[] ids){
		List<BillEntity> billCollectEntityList = new ArrayList<>();
		for(Long id : ids){
			billCollectEntityList.add(billService.queryObject(id));
		}
		String templateFilePath = ExcelExportUtil.class.getClassLoader().getResource("excel/test.xlsx").getPath();
		System.out.println("=====");
		File file = new File("d:\\data.xlsx");
		try {
			OutputStream os = new FileOutputStream(file);
			ExcelExportUtil excel = new ExcelExportUtil();
			List<Map<Integer, Object>> datalist = new ArrayList<Map<Integer, Object>>();
			Map<Integer, Object> data = new HashMap<Integer, Object>();
			for(BillEntity entity : billCollectEntityList) {
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
			excel.writeDateList(templateFilePath, heads, datalist, 0);
			//写到输出流并移除资源
			excel.writeAndClose(templateFilePath, os);
			os.flush();
			os.close();
		} catch (Exception e) {
			throw new RRException(e.getMessage());
		}
		return R.ok();
	}
}
