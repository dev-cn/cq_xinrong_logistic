package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.BillDao;
import cq.anbu.modules.bill.entity.BillEntity;
import cq.anbu.modules.bill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("billService")
public class BillServiceImpl implements BillService {
    @Autowired
    private BillDao billDao;

    @Override
    public BillEntity queryObject(Long id) {
        return billDao.queryObject(id);
    }

    @Override
    public BillEntity queryObjectByTrackingNo(String trackingNo) {
        return billDao.queryObjectByTrackingNo(trackingNo);
    }

    @Override
    public List<BillEntity> queryList(Map<String, Object> map) {
        return billDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return billDao.queryTotal(map);
    }

    @Override
    public void save(BillEntity bill) {
        billDao.save(bill);
    }

    @Override
    public void update(BillEntity bill) {
        billDao.update(bill);
    }

    @Override
    public void delete(Long id) {
        billDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        billDao.deleteBatch(ids);
    }

}
