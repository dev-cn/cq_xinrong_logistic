package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.BaseBillEntity;

import java.util.List;
import java.util.Map;

public interface BaseBillService<E extends BaseBillEntity> {
    E queryObject(Long id);

    List<E> queryList(Map<String, Object> map);

    E queryObjectByTrackingNo(String trackingNo);

    int queryTotal(Map<String, Object> map);

    void save(E entity);

    void update(E entity);

    void delete(Long id);

    void deleteBatch(Long[] ids);
}
