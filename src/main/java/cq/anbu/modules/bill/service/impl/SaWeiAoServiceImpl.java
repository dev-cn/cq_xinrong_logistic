package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.SaWeiAoDao;
import cq.anbu.modules.bill.entity.SaWeiAoEntity;
import cq.anbu.modules.bill.service.SaWeiAoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("saWeiAoService")
public class SaWeiAoServiceImpl extends BaseBillServiceImpl<SaWeiAoDao,SaWeiAoEntity> implements SaWeiAoService {

	@Override
	public SaWeiAoEntity queryObject(Long id){
		return super.queryObject(id);
	}
	
	@Override
	public List<SaWeiAoEntity> queryList(Map<String, Object> map){
		return super.queryList(map);
	}

    @Override
    public SaWeiAoEntity queryObjectByTrackingNo(String trackingNo) {
        return super.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return super.queryTotal(map);
	}
	
	@Override
	public void save(SaWeiAoEntity saWeiAo){
		super.save(saWeiAo);
	}
	
	@Override
	public void update(SaWeiAoEntity saWeiAo){
		super.update(saWeiAo);
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
