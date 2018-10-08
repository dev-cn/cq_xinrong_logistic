package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.entity.BaseBillEntity;
import cq.anbu.modules.bill.service.BaseBillService;
import cq.anbu.modules.sys.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public abstract class BaseBillServiceImpl<D extends BaseDao,E extends BaseBillEntity> implements BaseBillService<E> {
    @Autowired
    protected D dao;


    @Override
    public E queryObject(Long id) {
        return (E) dao.queryObject(id);
    }

    @Override
    public List<E> queryList(Map<String, Object> map) {
        return dao.queryList(map);
    }

    @Override
    public E queryObjectByTrackingNo(String trackingNo) {
        return (E) dao.queryObjectByTrackingNo(trackingNo);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return dao.queryTotal();
    }

    @Override
    public void save(E entity) {
        dao.save(entity);
    }

    @Override
    public void update(E entity) {
        dao.update(entity);
    }

    @Override
    public void delete(Long id) {
        dao.update(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        dao.deleteBatch(ids);
    }
}
