package cq.anbu.modules.bill.service.impl;

import cq.anbu.modules.bill.dao.BillPackingMaterialsDao;
import cq.anbu.modules.bill.entity.BillPackingMaterialsEntity;
import cq.anbu.modules.bill.service.BillPackingMaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("billPackingMaterialsService")
public class BillPackingMaterialsServiceImpl implements BillPackingMaterialsService {
    @Autowired
    private BillPackingMaterialsDao billPackingMaterialsDao;

    @Override
    public BillPackingMaterialsEntity queryObject(Long id) {
        return billPackingMaterialsDao.queryObject(id);
    }

    @Override
    public BillPackingMaterialsEntity queryObjectByTranspotNo(String transpotNo) {
        return billPackingMaterialsDao.queryObjectByTranspotNo(transpotNo);
    }

    @Override
    public List<BillPackingMaterialsEntity> queryList(Map<String, Object> map) {
        return billPackingMaterialsDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return billPackingMaterialsDao.queryTotal(map);
    }

    @Override
    public void save(BillPackingMaterialsEntity billPackingMaterials) {
        billPackingMaterialsDao.save(billPackingMaterials);
    }

    @Override
    public void update(BillPackingMaterialsEntity billPackingMaterials) {
        billPackingMaterialsDao.update(billPackingMaterials);
    }

    @Override
    public void delete(Long id) {
        billPackingMaterialsDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        billPackingMaterialsDao.deleteBatch(ids);
    }

}
