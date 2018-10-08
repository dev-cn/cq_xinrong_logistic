package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.YanFengEntity;

import java.util.List;
import java.util.Map;

/**
 * 延锋账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
public interface YanFengService extends BaseBillService<YanFengEntity>{
	
	YanFengEntity queryObject(Long id);
	
	List<YanFengEntity> queryList(Map<String, Object> map);

	YanFengEntity queryObjectByTrackingNo(String trackingNo);
	
	int queryTotal(Map<String, Object> map);
	
	void save(YanFengEntity yanFeng);
	
	void update(YanFengEntity yanFeng);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
