package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.XinSiLuEntity;

import java.util.List;
import java.util.Map;

/**
 * 新思路账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
public interface XinSiLuService extends BaseBillService<XinSiLuEntity>{
	
	XinSiLuEntity queryObject(Long id);
	
	List<XinSiLuEntity> queryList(Map<String, Object> map);

	XinSiLuEntity queryObjectByTrackingNo(String trackingNo);
	
	int queryTotal(Map<String, Object> map);
	
	void save(XinSiLuEntity xinSiLu);
	
	void update(XinSiLuEntity xinSiLu);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
