package cq.anbu.modules.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cq.anbu.modules.bill.dao.XinSiLuDao;
import cq.anbu.modules.bill.entity.XinSiLuEntity;
import cq.anbu.modules.bill.service.XinSiLuService;



@Service("xinSiLuService")
public class XinSiLuServiceImpl implements XinSiLuService {
	@Autowired
	private XinSiLuDao xinSiLuDao;
	
	@Override
	public XinSiLuEntity queryObject(Long id){
		return xinSiLuDao.queryObject(id);
	}
	
	@Override
	public List<XinSiLuEntity> queryList(Map<String, Object> map){
		return xinSiLuDao.queryList(map);
	}

    @Override
    public XinSiLuEntity queryObjectByTrackingNo(String trackingNo) {
        return xinSiLuDao.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return xinSiLuDao.queryTotal(map);
	}
	
	@Override
	public void save(XinSiLuEntity xinSiLu){
		xinSiLuDao.save(xinSiLu);
	}
	
	@Override
	public void update(XinSiLuEntity xinSiLu){
		xinSiLuDao.update(xinSiLu);
	}
	
	@Override
	public void delete(Long id){
		xinSiLuDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		xinSiLuDao.deleteBatch(ids);
	}
	
}
