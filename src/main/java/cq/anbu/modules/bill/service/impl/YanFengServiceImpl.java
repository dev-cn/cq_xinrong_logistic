package cq.anbu.modules.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cq.anbu.modules.bill.dao.YanFengDao;
import cq.anbu.modules.bill.entity.YanFengEntity;
import cq.anbu.modules.bill.service.YanFengService;



@Service("yanFengService")
public class YanFengServiceImpl implements YanFengService {
	@Autowired
	private YanFengDao yanFengDao;
	
	@Override
	public YanFengEntity queryObject(Long id){
		return yanFengDao.queryObject(id);
	}
	
	@Override
	public List<YanFengEntity> queryList(Map<String, Object> map){
		return yanFengDao.queryList(map);
	}

    @Override
    public YanFengEntity queryObjectByTrackingNo(String trackingNo) {
        return yanFengDao.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return yanFengDao.queryTotal(map);
	}
	
	@Override
	public void save(YanFengEntity yanFeng){
		yanFengDao.save(yanFeng);
	}
	
	@Override
	public void update(YanFengEntity yanFeng){
		yanFengDao.update(yanFeng);
	}
	
	@Override
	public void delete(Long id){
		yanFengDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		yanFengDao.deleteBatch(ids);
	}
	
}
