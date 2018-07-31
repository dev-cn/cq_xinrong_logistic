package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.SiWeiErEntity;

import java.util.List;
import java.util.Map;

/**
 * 四维尔账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
public interface SiWeiErService {
	
	SiWeiErEntity queryObject(Long id);
	
	List<SiWeiErEntity> queryList(Map<String, Object> map);

	SiWeiErEntity queryObjectByTrackingNo(String trackingNo);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SiWeiErEntity siWeiEr);
	
	void update(SiWeiErEntity siWeiEr);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
