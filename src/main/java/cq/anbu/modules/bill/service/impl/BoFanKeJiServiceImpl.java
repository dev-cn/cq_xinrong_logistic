package cq.anbu.modules.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cq.anbu.modules.bill.dao.BoFanKeJiDao;
import cq.anbu.modules.bill.entity.BoFanKeJiEntity;
import cq.anbu.modules.bill.service.BoFanKeJiService;



@Service("boFanKeJiService")
public class BoFanKeJiServiceImpl implements BoFanKeJiService {
	@Autowired
	private BoFanKeJiDao boFanKeJiDao;
	
	@Override
	public BoFanKeJiEntity queryObject(Long id){
		return boFanKeJiDao.queryObject(id);
	}
	
	@Override
	public List<BoFanKeJiEntity> queryList(Map<String, Object> map){
		return boFanKeJiDao.queryList(map);
	}

    @Override
    public BoFanKeJiEntity queryObjectByTrackingNo(String trackingNo) {
        return boFanKeJiDao.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return boFanKeJiDao.queryTotal(map);
	}
	
	@Override
	public void save(BoFanKeJiEntity boFanKeJi){
		boFanKeJiDao.save(boFanKeJi);
	}
	
	@Override
	public void update(BoFanKeJiEntity boFanKeJi){
		boFanKeJiDao.update(boFanKeJi);
	}
	
	@Override
	public void delete(Long id){
		boFanKeJiDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		boFanKeJiDao.deleteBatch(ids);
	}
	
}
