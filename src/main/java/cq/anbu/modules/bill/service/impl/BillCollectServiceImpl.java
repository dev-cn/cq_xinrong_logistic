package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.BillCollectDao;
import cq.anbu.modules.bill.entity.BillCollectEntity;
import cq.anbu.modules.bill.service.BillCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("billCollectService")
public class BillCollectServiceImpl implements BillCollectService {
    @Autowired
    private BillCollectDao billCollectDao;

    @Override
    public BillCollectEntity queryObject(Long id) {
        return billCollectDao.queryObject(id);
    }

    @Override
    public List<BillCollectEntity> queryList(Map<String, Object> map) {
        return billCollectDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return billCollectDao.queryTotal(map);
    }

    @Override
    public void save(BillCollectEntity billCollect) {
        billCollectDao.save(billCollect);
    }

    @Override
    public void update(BillCollectEntity billCollect) {
        billCollectDao.update(billCollect);
    }

    @Override
    public void delete(Long id) {
        billCollectDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        billCollectDao.deleteBatch(ids);
    }

}
