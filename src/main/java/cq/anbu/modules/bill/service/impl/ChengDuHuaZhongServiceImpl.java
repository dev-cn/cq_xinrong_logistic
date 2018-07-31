package cq.anbu.modules.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cq.anbu.modules.bill.dao.ChengDuHuaZhongDao;
import cq.anbu.modules.bill.entity.ChengDuHuaZhongEntity;
import cq.anbu.modules.bill.service.ChengDuHuaZhongService;



@Service("chengDuHuaZhongService")
public class ChengDuHuaZhongServiceImpl implements ChengDuHuaZhongService {
	@Autowired
	private ChengDuHuaZhongDao chengDuHuaZhongDao;
	
	@Override
	public ChengDuHuaZhongEntity queryObject(Long id){
		return chengDuHuaZhongDao.queryObject(id);
	}
	
	@Override
	public List<ChengDuHuaZhongEntity> queryList(Map<String, Object> map){
		return chengDuHuaZhongDao.queryList(map);
	}

    @Override
    public ChengDuHuaZhongEntity queryObjectByTrackingNo(String trackingNo) {
        return chengDuHuaZhongDao.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return chengDuHuaZhongDao.queryTotal(map);
	}
	
	@Override
	public void save(ChengDuHuaZhongEntity chengDuHuaZhong){
		chengDuHuaZhongDao.save(chengDuHuaZhong);
	}
	
	@Override
	public void update(ChengDuHuaZhongEntity chengDuHuaZhong){
		chengDuHuaZhongDao.update(chengDuHuaZhong);
	}
	
	@Override
	public void delete(Long id){
		chengDuHuaZhongDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		chengDuHuaZhongDao.deleteBatch(ids);
	}
	
}
