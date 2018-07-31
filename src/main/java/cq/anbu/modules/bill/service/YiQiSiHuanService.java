package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.YiQiSiHuanEntity;

import java.util.List;
import java.util.Map;

/**
 * 一汽四环账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
public interface YiQiSiHuanService {
	
	YiQiSiHuanEntity queryObject(Long id);
	
	List<YiQiSiHuanEntity> queryList(Map<String, Object> map);

	YiQiSiHuanEntity queryObjectByTrackingNo(String trackingNo);
	
	int queryTotal(Map<String, Object> map);
	
	void save(YiQiSiHuanEntity yiQiSiHuan);
	
	void update(YiQiSiHuanEntity yiQiSiHuan);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
