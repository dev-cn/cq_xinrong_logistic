package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.ShangHaiMingFangEntity;

import java.util.List;
import java.util.Map;

/**
 * 上海明芳账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
public interface ShangHaiMingFangService {
	
	ShangHaiMingFangEntity queryObject(Long id);
	
	List<ShangHaiMingFangEntity> queryList(Map<String, Object> map);

	ShangHaiMingFangEntity queryObjectByTrackingNo(String trackingNo);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ShangHaiMingFangEntity shangHaiMingFang);
	
	void update(ShangHaiMingFangEntity shangHaiMingFang);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
