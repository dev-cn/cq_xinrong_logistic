package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.XinSiLuDao;
import cq.anbu.modules.bill.entity.XinSiLuEntity;
import cq.anbu.modules.bill.service.XinSiLuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("xinSiLuService")
public class XinSiLuServiceImpl extends BaseBillServiceImpl<XinSiLuDao,XinSiLuEntity> implements XinSiLuService {

	@Override
	public XinSiLuEntity queryObject(Long id){
		return super.queryObject(id);
	}
	
	@Override
	public List<XinSiLuEntity> queryList(Map<String, Object> map){
		return super.queryList(map);
	}

    @Override
    public XinSiLuEntity queryObjectByTrackingNo(String trackingNo) {
        return super.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return super.queryTotal(map);
	}
	
	@Override
	public void save(XinSiLuEntity xinSiLu){
		super.save(xinSiLu);
	}
	
	@Override
	public void update(XinSiLuEntity xinSiLu){
		super.update(xinSiLu);
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
