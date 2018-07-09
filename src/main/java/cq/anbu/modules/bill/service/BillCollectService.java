package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.BillCollectEntity;

import java.util.List;
import java.util.Map;

/**
 * 运费汇总表
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-06-10 09:48:20
 */
public interface BillCollectService {

    BillCollectEntity queryObject(Long id);

    BillCollectEntity queryObjectByTranspotNo(String transpotNo);

    List<BillCollectEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(BillCollectEntity billCollect);

    void update(BillCollectEntity billCollect);

    void delete(Long id);

    void deleteBatch(Long[] ids);
}
