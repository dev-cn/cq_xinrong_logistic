package cq.anbu.modules.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cq.anbu.modules.bill.dao.SiWeiErDao;
import cq.anbu.modules.bill.entity.SiWeiErEntity;
import cq.anbu.modules.bill.service.SiWeiErService;



@Service("siWeiErService")
public class SiWeiErServiceImpl implements SiWeiErService {
	@Autowired
	private SiWeiErDao siWeiErDao;
	
	@Override
	public SiWeiErEntity queryObject(Long id){
		return siWeiErDao.queryObject(id);
	}
	
	@Override
	public List<SiWeiErEntity> queryList(Map<String, Object> map){
		return siWeiErDao.queryList(map);
	}

    @Override
    public SiWeiErEntity queryObjectByTrackingNo(String trackingNo) {
        return siWeiErDao.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return siWeiErDao.queryTotal(map);
	}
	
	@Override
	public void save(SiWeiErEntity siWeiEr){
		siWeiErDao.save(siWeiEr);
	}
	
	@Override
	public void update(SiWeiErEntity siWeiEr){
		siWeiErDao.update(siWeiEr);
	}
	
	@Override
	public void delete(Long id){
		siWeiErDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		siWeiErDao.deleteBatch(ids);
	}
	
}
