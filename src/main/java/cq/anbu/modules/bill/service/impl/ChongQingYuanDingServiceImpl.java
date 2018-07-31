package cq.anbu.modules.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cq.anbu.modules.bill.dao.ChongQingYuanDingDao;
import cq.anbu.modules.bill.entity.ChongQingYuanDingEntity;
import cq.anbu.modules.bill.service.ChongQingYuanDingService;



@Service("chongQingYuanDingService")
public class ChongQingYuanDingServiceImpl implements ChongQingYuanDingService {
	@Autowired
	private ChongQingYuanDingDao chongQingYuanDingDao;
	
	@Override
	public ChongQingYuanDingEntity queryObject(Long id){
		return chongQingYuanDingDao.queryObject(id);
	}
	
	@Override
	public List<ChongQingYuanDingEntity> queryList(Map<String, Object> map){
		return chongQingYuanDingDao.queryList(map);
	}

    @Override
    public ChongQingYuanDingEntity queryObjectByTrackingNo(String trackingNo) {
        return chongQingYuanDingDao.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return chongQingYuanDingDao.queryTotal(map);
	}
	
	@Override
	public void save(ChongQingYuanDingEntity chongQingYuanDing){
		chongQingYuanDingDao.save(chongQingYuanDing);
	}
	
	@Override
	public void update(ChongQingYuanDingEntity chongQingYuanDing){
		chongQingYuanDingDao.update(chongQingYuanDing);
	}
	
	@Override
	public void delete(Long id){
		chongQingYuanDingDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		chongQingYuanDingDao.deleteBatch(ids);
	}
	
}
