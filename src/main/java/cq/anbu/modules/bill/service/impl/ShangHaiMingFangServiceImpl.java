package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.ShangHaiMingFangDao;
import cq.anbu.modules.bill.entity.ShangHaiMingFangEntity;
import cq.anbu.modules.bill.service.ShangHaiMingFangService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("shangHaiMingFangService")
public class ShangHaiMingFangServiceImpl extends BaseBillServiceImpl<ShangHaiMingFangDao,ShangHaiMingFangEntity>
		implements ShangHaiMingFangService {

	@Override
	public ShangHaiMingFangEntity queryObject(Long id){
		return super.queryObject(id);
	}
	
	@Override
	public List<ShangHaiMingFangEntity> queryList(Map<String, Object> map){
		return super.queryList(map);
	}

    @Override
    public ShangHaiMingFangEntity queryObjectByTrackingNo(String trackingNo) {
        return super.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return super.queryTotal(map);
	}
	
	@Override
	public void save(ShangHaiMingFangEntity shangHaiMingFang){
		super.save(shangHaiMingFang);
	}
	
	@Override
	public void update(ShangHaiMingFangEntity shangHaiMingFang){
		super.update(shangHaiMingFang);
	}
	
	@Override
	public void delete(Long id){
		super.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		super.deleteBatch(ids);
	}
	
}
