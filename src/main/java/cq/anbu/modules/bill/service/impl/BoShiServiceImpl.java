package cq.anbu.modules.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cq.anbu.modules.bill.dao.BoShiDao;
import cq.anbu.modules.bill.entity.BoShiEntity;
import cq.anbu.modules.bill.service.BoShiService;



@Service("boShiService")
public class BoShiServiceImpl implements BoShiService {
	@Autowired
	private BoShiDao boShiDao;
	
	@Override
	public BoShiEntity queryObject(Long id){
		return boShiDao.queryObject(id);
	}
	
	@Override
	public List<BoShiEntity> queryList(Map<String, Object> map){
		return boShiDao.queryList(map);
	}

    @Override
    public BoShiEntity queryObjectByTrackingNo(String trackingNo) {
        return boShiDao.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return boShiDao.queryTotal(map);
	}
	
	@Override
	public void save(BoShiEntity boShi){
		boShiDao.save(boShi);
	}
	
	@Override
	public void update(BoShiEntity boShi){
		boShiDao.update(boShi);
	}
	
	@Override
	public void delete(Long id){
		boShiDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		boShiDao.deleteBatch(ids);
	}
	
}
