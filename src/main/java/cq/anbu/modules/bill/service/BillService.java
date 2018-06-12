package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.BillEntity;

import java.util.List;
import java.util.Map;

/**
 * 账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-06-10 09:48:20
 */
public interface BillService {
	
	BillEntity queryObject(Long id);
	
	List<BillEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BillEntity bill);
	
	void update(BillEntity bill);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
