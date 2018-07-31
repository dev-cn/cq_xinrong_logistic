package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.BoZeEntity;

import java.util.List;
import java.util.Map;

/**
 * 博泽账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
public interface BoZeService {
	
	BoZeEntity queryObject(Long id);
	
	List<BoZeEntity> queryList(Map<String, Object> map);

	BoZeEntity queryObjectByTrackingNo(String trackingNo);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BoZeEntity boZe);
	
	void update(BoZeEntity boZe);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
