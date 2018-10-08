package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.BoZeDao;
import cq.anbu.modules.bill.entity.BoZeEntity;
import cq.anbu.modules.bill.service.BoZeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("boZeService")
public class BoZeServiceImpl extends BaseBillServiceImpl<BoZeDao,BoZeEntity> implements BoZeService {

	@Override
	public BoZeEntity queryObject(Long id){
		return super.queryObject(id);
	}
	
	@Override
	public List<BoZeEntity> queryList(Map<String, Object> map){
		return super.queryList(map);
	}

    @Override
    public BoZeEntity queryObjectByTrackingNo(String trackingNo) {
        return super.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return super.queryTotal(map);
	}
	
	@Override
	public void save(BoZeEntity boZe){
		super.save(boZe);
	}
	
	@Override
	public void update(BoZeEntity boZe){
		super.update(boZe);
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
