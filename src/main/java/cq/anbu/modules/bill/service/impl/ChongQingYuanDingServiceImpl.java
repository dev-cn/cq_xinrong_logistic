package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.ChongQingYuanDingDao;
import cq.anbu.modules.bill.entity.ChongQingYuanDingEntity;
import cq.anbu.modules.bill.service.ChongQingYuanDingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("chongQingYuanDingService")
public class ChongQingYuanDingServiceImpl extends BaseBillServiceImpl<ChongQingYuanDingDao,ChongQingYuanDingEntity>
		implements ChongQingYuanDingService {

	@Override
	public ChongQingYuanDingEntity queryObject(Long id){
		return super.queryObject(id);
	}
	
	@Override
	public List<ChongQingYuanDingEntity> queryList(Map<String, Object> map){
		return super.queryList(map);
	}

    @Override
    public ChongQingYuanDingEntity queryObjectByTrackingNo(String trackingNo) {
        return super.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return super.queryTotal(map);
	}
	
	@Override
	public void save(ChongQingYuanDingEntity chongQingYuanDing){
		super.save(chongQingYuanDing);
	}
	
	@Override
	public void update(ChongQingYuanDingEntity chongQingYuanDing){
		super.update(chongQingYuanDing);
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
