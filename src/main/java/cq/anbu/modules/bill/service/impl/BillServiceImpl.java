package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.BillDao;
import cq.anbu.modules.bill.entity.BillEntity;
import cq.anbu.modules.bill.service.BillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("billService")
public class BillServiceImpl extends BaseBillServiceImpl<BillDao,BillEntity> implements BillService {

    @Override
    public BillEntity queryObject(Long id) {
        return super.queryObject(id);
    }

    @Override
    public BillEntity queryObjectByTrackingNo(String trackingNo) {
        return super.queryObjectByTrackingNo(trackingNo);
    }

    @Override
    public List<BillEntity> queryList(Map<String, Object> map) {
        return super.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return super.queryTotal(map);
    }

    @Override
    public void save(BillEntity bill) {
        super.save(bill);
    }

    @Override
    public void update(BillEntity bill) {
        super.update(bill);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        super.deleteBatch(ids);
    }

}
