package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.ChongQingYuanDingEntity;

import java.util.List;
import java.util.Map;

/**
 * 重庆远鼎账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
public interface ChongQingYuanDingService {
	
	ChongQingYuanDingEntity queryObject(Long id);
	
	List<ChongQingYuanDingEntity> queryList(Map<String, Object> map);

	ChongQingYuanDingEntity queryObjectByTrackingNo(String trackingNo);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ChongQingYuanDingEntity chongQingYuanDing);
	
	void update(ChongQingYuanDingEntity chongQingYuanDing);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
