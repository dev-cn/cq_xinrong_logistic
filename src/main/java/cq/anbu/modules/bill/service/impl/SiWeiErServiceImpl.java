package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.SiWeiErDao;
import cq.anbu.modules.bill.entity.SiWeiErEntity;
import cq.anbu.modules.bill.service.SiWeiErService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("siWeiErService")
public class SiWeiErServiceImpl extends BaseBillServiceImpl<SiWeiErDao,SiWeiErEntity> implements SiWeiErService {

	@Override
	public SiWeiErEntity queryObject(Long id){
		return super.queryObject(id);
	}
	
	@Override
	public List<SiWeiErEntity> queryList(Map<String, Object> map){
		return super.queryList(map);
	}

    @Override
    public SiWeiErEntity queryObjectByTrackingNo(String trackingNo) {
        return super.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return super.queryTotal(map);
	}
	
	@Override
	public void save(SiWeiErEntity siWeiEr){
		super.save(siWeiEr);
	}
	
	@Override
	public void update(SiWeiErEntity siWeiEr){
		super.update(siWeiEr);
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
