package cq.anbu.modules.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cq.anbu.modules.bill.dao.BoZeDao;
import cq.anbu.modules.bill.entity.BoZeEntity;
import cq.anbu.modules.bill.service.BoZeService;



@Service("boZeService")
public class BoZeServiceImpl implements BoZeService {
	@Autowired
	private BoZeDao boZeDao;
	
	@Override
	public BoZeEntity queryObject(Long id){
		return boZeDao.queryObject(id);
	}
	
	@Override
	public List<BoZeEntity> queryList(Map<String, Object> map){
		return boZeDao.queryList(map);
	}

    @Override
    public BoZeEntity queryObjectByTrackingNo(String trackingNo) {
        return boZeDao.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return boZeDao.queryTotal(map);
	}
	
	@Override
	public void save(BoZeEntity boZe){
		boZeDao.save(boZe);
	}
	
	@Override
	public void update(BoZeEntity boZe){
		boZeDao.update(boZe);
	}
	
	@Override
	public void delete(Long id){
		boZeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		boZeDao.deleteBatch(ids);
	}
	
}
