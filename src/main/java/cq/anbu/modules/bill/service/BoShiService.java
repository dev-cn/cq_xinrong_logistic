package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.BoShiEntity;

import java.util.List;
import java.util.Map;

/**
 * 博世账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
public interface BoShiService {
	
	BoShiEntity queryObject(Long id);
	
	List<BoShiEntity> queryList(Map<String, Object> map);

	BoShiEntity queryObjectByTrackingNo(String trackingNo);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BoShiEntity boShi);
	
	void update(BoShiEntity boShi);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
