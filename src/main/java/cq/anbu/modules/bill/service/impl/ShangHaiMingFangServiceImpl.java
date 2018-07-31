package cq.anbu.modules.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cq.anbu.modules.bill.dao.ShangHaiMingFangDao;
import cq.anbu.modules.bill.entity.ShangHaiMingFangEntity;
import cq.anbu.modules.bill.service.ShangHaiMingFangService;



@Service("shangHaiMingFangService")
public class ShangHaiMingFangServiceImpl implements ShangHaiMingFangService {
	@Autowired
	private ShangHaiMingFangDao shangHaiMingFangDao;
	
	@Override
	public ShangHaiMingFangEntity queryObject(Long id){
		return shangHaiMingFangDao.queryObject(id);
	}
	
	@Override
	public List<ShangHaiMingFangEntity> queryList(Map<String, Object> map){
		return shangHaiMingFangDao.queryList(map);
	}

    @Override
    public ShangHaiMingFangEntity queryObjectByTrackingNo(String trackingNo) {
        return shangHaiMingFangDao.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return shangHaiMingFangDao.queryTotal(map);
	}
	
	@Override
	public void save(ShangHaiMingFangEntity shangHaiMingFang){
		shangHaiMingFangDao.save(shangHaiMingFang);
	}
	
	@Override
	public void update(ShangHaiMingFangEntity shangHaiMingFang){
		shangHaiMingFangDao.update(shangHaiMingFang);
	}
	
	@Override
	public void delete(Long id){
		shangHaiMingFangDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		shangHaiMingFangDao.deleteBatch(ids);
	}
	
}
