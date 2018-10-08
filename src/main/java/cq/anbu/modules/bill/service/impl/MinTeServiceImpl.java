package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.MinTeDao;
import cq.anbu.modules.bill.entity.MinTeEntity;
import cq.anbu.modules.bill.service.MinTeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("minTeService")
public class MinTeServiceImpl extends BaseBillServiceImpl<MinTeDao,MinTeEntity> implements MinTeService {

	@Override
	public MinTeEntity queryObject(Long id){
		return super.queryObject(id);
	}
	
	@Override
	public List<MinTeEntity> queryList(Map<String, Object> map){
		return super.queryList(map);
	}

    @Override
    public MinTeEntity queryObjectByTrackingNo(String trackingNo) {
        return super.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return super.queryTotal(map);
	}
	
	@Override
	public void save(MinTeEntity minTe){
		super.save(minTe);
	}
	
	@Override
	public void update(MinTeEntity minTe){
		super.update(minTe);
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
