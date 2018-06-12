package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.BillPackingMaterialsEntity;

import java.util.List;
import java.util.Map;

/**
 * 包材表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-06-12 09:49:45
 */
public interface BillPackingMaterialsService {
	
	BillPackingMaterialsEntity queryObject(Long id);
	
	List<BillPackingMaterialsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BillPackingMaterialsEntity billPackingMaterials);
	
	void update(BillPackingMaterialsEntity billPackingMaterials);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
