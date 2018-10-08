package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.YanFengDao;
import cq.anbu.modules.bill.entity.YanFengEntity;
import cq.anbu.modules.bill.service.YanFengService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("yanFengService")
public class YanFengServiceImpl extends BaseBillServiceImpl<YanFengDao,YanFengEntity> implements YanFengService {

	@Override
	public YanFengEntity queryObject(Long id){
		return super.queryObject(id);
	}
	
	@Override
	public List<YanFengEntity> queryList(Map<String, Object> map){
		return super.queryList(map);
	}

    @Override
    public YanFengEntity queryObjectByTrackingNo(String trackingNo) {
        return super.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return super.queryTotal(map);
	}
	
	@Override
	public void save(YanFengEntity yanFeng){
		super.save(yanFeng);
	}
	
	@Override
	public void update(YanFengEntity yanFeng){
		super.update(yanFeng);
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
