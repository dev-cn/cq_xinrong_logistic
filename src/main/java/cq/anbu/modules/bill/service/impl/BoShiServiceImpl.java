package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.BoShiDao;
import cq.anbu.modules.bill.entity.BoShiEntity;
import cq.anbu.modules.bill.service.BoShiService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("boShiService")
public class BoShiServiceImpl extends BaseBillServiceImpl<BoShiDao,BoShiEntity> implements BoShiService {

	@Override
	public BoShiEntity queryObject(Long id){
		return super.queryObject(id);
	}
	
	@Override
	public List<BoShiEntity> queryList(Map<String, Object> map){
		return super.queryList(map);
	}

    @Override
    public BoShiEntity queryObjectByTrackingNo(String trackingNo) {
        return super.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return super.queryTotal(map);
	}
	
	@Override
	public void save(BoShiEntity boShi){
		super.save(boShi);
	}
	
	@Override
	public void update(BoShiEntity boShi){
		super.update(boShi);
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
