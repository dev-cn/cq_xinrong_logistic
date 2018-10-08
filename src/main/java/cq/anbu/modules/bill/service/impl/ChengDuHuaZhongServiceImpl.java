package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.ChengDuHuaZhongDao;
import cq.anbu.modules.bill.entity.ChengDuHuaZhongEntity;
import cq.anbu.modules.bill.service.ChengDuHuaZhongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("chengDuHuaZhongService")
public class ChengDuHuaZhongServiceImpl extends BaseBillServiceImpl<ChengDuHuaZhongDao,ChengDuHuaZhongEntity>
		implements ChengDuHuaZhongService {

	@Override
	public ChengDuHuaZhongEntity queryObject(Long id){
		return super.queryObject(id);
	}
	
	@Override
	public List<ChengDuHuaZhongEntity> queryList(Map<String, Object> map){
		return super.queryList(map);
	}

    @Override
    public ChengDuHuaZhongEntity queryObjectByTrackingNo(String trackingNo) {
        return super.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return super.queryTotal(map);
	}
	
	@Override
	public void save(ChengDuHuaZhongEntity chengDuHuaZhong){
		super.save(chengDuHuaZhong);
	}
	
	@Override
	public void update(ChengDuHuaZhongEntity chengDuHuaZhong){
		super.update(chengDuHuaZhong);
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
