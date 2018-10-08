package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.YiQiSiHuanDao;
import cq.anbu.modules.bill.entity.YiQiSiHuanEntity;
import cq.anbu.modules.bill.service.YiQiSiHuanService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("yiQiSiHuanService")
public class YiQiSiHuanServiceImpl extends BaseBillServiceImpl<YiQiSiHuanDao,YiQiSiHuanEntity> implements YiQiSiHuanService {

	@Override
	public YiQiSiHuanEntity queryObject(Long id){
		return super.queryObject(id);
	}
	
	@Override
	public List<YiQiSiHuanEntity> queryList(Map<String, Object> map){
		return super.queryList(map);
	}

    @Override
    public YiQiSiHuanEntity queryObjectByTrackingNo(String trackingNo) {
        return super.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return super.queryTotal(map);
	}
	
	@Override
	public void save(YiQiSiHuanEntity yiQiSiHuan){
		super.save(yiQiSiHuan);
	}
	
	@Override
	public void update(YiQiSiHuanEntity yiQiSiHuan){
		super.update(yiQiSiHuan);
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
