package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.BoFanKeJiDao;
import cq.anbu.modules.bill.entity.BoFanKeJiEntity;
import cq.anbu.modules.bill.service.BoFanKeJiService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("boFanKeJiService")
public class BoFanKeJiServiceImpl extends BaseBillServiceImpl<BoFanKeJiDao,BoFanKeJiEntity> implements BoFanKeJiService {

	@Override
	public BoFanKeJiEntity queryObject(Long id){
		return super.queryObject(id);
	}
	
	@Override
	public List<BoFanKeJiEntity> queryList(Map<String, Object> map){
		return super.queryList(map);
	}

    @Override
    public BoFanKeJiEntity queryObjectByTrackingNo(String trackingNo) {
        return super.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return super.queryTotal(map);
	}
	
	@Override
	public void save(BoFanKeJiEntity boFanKeJi){
		super.save(boFanKeJi);
	}
	
	@Override
	public void update(BoFanKeJiEntity boFanKeJi){
		super.update(boFanKeJi);
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
