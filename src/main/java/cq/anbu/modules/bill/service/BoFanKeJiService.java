package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.BoFanKeJiEntity;

import java.util.List;
import java.util.Map;

/**
 * 博帆科技账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
public interface BoFanKeJiService {
	
	BoFanKeJiEntity queryObject(Long id);
	
	List<BoFanKeJiEntity> queryList(Map<String, Object> map);

	BoFanKeJiEntity queryObjectByTrackingNo(String trackingNo);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BoFanKeJiEntity boFanKeJi);
	
	void update(BoFanKeJiEntity boFanKeJi);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
