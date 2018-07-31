package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.ChengDuHuaZhongEntity;

import java.util.List;
import java.util.Map;

/**
 * 成都华众账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
public interface ChengDuHuaZhongService {
	
	ChengDuHuaZhongEntity queryObject(Long id);
	
	List<ChengDuHuaZhongEntity> queryList(Map<String, Object> map);

	ChengDuHuaZhongEntity queryObjectByTrackingNo(String trackingNo);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ChengDuHuaZhongEntity chengDuHuaZhong);
	
	void update(ChengDuHuaZhongEntity chengDuHuaZhong);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
