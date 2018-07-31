package cq.anbu.modules.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cq.anbu.modules.bill.dao.MinTeDao;
import cq.anbu.modules.bill.entity.MinTeEntity;
import cq.anbu.modules.bill.service.MinTeService;



@Service("minTeService")
public class MinTeServiceImpl implements MinTeService {
	@Autowired
	private MinTeDao minTeDao;
	
	@Override
	public MinTeEntity queryObject(Long id){
		return minTeDao.queryObject(id);
	}
	
	@Override
	public List<MinTeEntity> queryList(Map<String, Object> map){
		return minTeDao.queryList(map);
	}

    @Override
    public MinTeEntity queryObjectByTrackingNo(String trackingNo) {
        return minTeDao.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return minTeDao.queryTotal(map);
	}
	
	@Override
	public void save(MinTeEntity minTe){
		minTeDao.save(minTe);
	}
	
	@Override
	public void update(MinTeEntity minTe){
		minTeDao.update(minTe);
	}
	
	@Override
	public void delete(Long id){
		minTeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		minTeDao.deleteBatch(ids);
	}
	
}
