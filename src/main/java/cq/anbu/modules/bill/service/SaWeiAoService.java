package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.SaWeiAoEntity;

import java.util.List;
import java.util.Map;

/**
 * 萨维奥账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
public interface SaWeiAoService {
	
	SaWeiAoEntity queryObject(Long id);
	
	List<SaWeiAoEntity> queryList(Map<String, Object> map);

	SaWeiAoEntity queryObjectByTrackingNo(String trackingNo);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SaWeiAoEntity saWeiAo);
	
	void update(SaWeiAoEntity saWeiAo);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
