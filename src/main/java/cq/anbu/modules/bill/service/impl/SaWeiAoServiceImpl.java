package cq.anbu.modules.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cq.anbu.modules.bill.dao.SaWeiAoDao;
import cq.anbu.modules.bill.entity.SaWeiAoEntity;
import cq.anbu.modules.bill.service.SaWeiAoService;



@Service("saWeiAoService")
public class SaWeiAoServiceImpl implements SaWeiAoService {
	@Autowired
	private SaWeiAoDao saWeiAoDao;
	
	@Override
	public SaWeiAoEntity queryObject(Long id){
		return saWeiAoDao.queryObject(id);
	}
	
	@Override
	public List<SaWeiAoEntity> queryList(Map<String, Object> map){
		return saWeiAoDao.queryList(map);
	}

    @Override
    public SaWeiAoEntity queryObjectByTrackingNo(String trackingNo) {
        return saWeiAoDao.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return saWeiAoDao.queryTotal(map);
	}
	
	@Override
	public void save(SaWeiAoEntity saWeiAo){
		saWeiAoDao.save(saWeiAo);
	}
	
	@Override
	public void update(SaWeiAoEntity saWeiAo){
		saWeiAoDao.update(saWeiAo);
	}
	
	@Override
	public void delete(Long id){
		saWeiAoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		saWeiAoDao.deleteBatch(ids);
	}
	
}
