package cq.anbu.modules.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cq.anbu.modules.bill.dao.YiQiSiHuanDao;
import cq.anbu.modules.bill.entity.YiQiSiHuanEntity;
import cq.anbu.modules.bill.service.YiQiSiHuanService;



@Service("yiQiSiHuanService")
public class YiQiSiHuanServiceImpl implements YiQiSiHuanService {
	@Autowired
	private YiQiSiHuanDao yiQiSiHuanDao;
	
	@Override
	public YiQiSiHuanEntity queryObject(Long id){
		return yiQiSiHuanDao.queryObject(id);
	}
	
	@Override
	public List<YiQiSiHuanEntity> queryList(Map<String, Object> map){
		return yiQiSiHuanDao.queryList(map);
	}

    @Override
    public YiQiSiHuanEntity queryObjectByTrackingNo(String trackingNo) {
        return yiQiSiHuanDao.queryObjectByTrackingNo(trackingNo);
    }

	@Override
	public int queryTotal(Map<String, Object> map){
		return yiQiSiHuanDao.queryTotal(map);
	}
	
	@Override
	public void save(YiQiSiHuanEntity yiQiSiHuan){
		yiQiSiHuanDao.save(yiQiSiHuan);
	}
	
	@Override
	public void update(YiQiSiHuanEntity yiQiSiHuan){
		yiQiSiHuanDao.update(yiQiSiHuan);
	}
	
	@Override
	public void delete(Long id){
		yiQiSiHuanDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		yiQiSiHuanDao.deleteBatch(ids);
	}
	
}
