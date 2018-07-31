package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.MinTeEntity;

import java.util.List;
import java.util.Map;

/**
 * 敏特账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
public interface MinTeService {
	
	MinTeEntity queryObject(Long id);
	
	List<MinTeEntity> queryList(Map<String, Object> map);

	MinTeEntity queryObjectByTrackingNo(String trackingNo);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MinTeEntity minTe);
	
	void update(MinTeEntity minTe);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
