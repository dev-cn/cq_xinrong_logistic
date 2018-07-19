package cq.anbu.modules.baseinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cq.anbu.modules.baseinfo.dao.VehicleDao;
import cq.anbu.modules.baseinfo.entity.VehicleEntity;
import cq.anbu.modules.baseinfo.service.VehicleService;


@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleDao vehicleDao;

    @Override
    public VehicleEntity queryObject(Long id) {
        return vehicleDao.queryObject(id);
    }

    @Override
    public List<VehicleEntity> queryList(Map<String, Object> map) {
        return vehicleDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return vehicleDao.queryTotal(map);
    }

    @Override
    public void save(VehicleEntity vehicle) {
        vehicleDao.save(vehicle);
    }

    @Override
    public void update(VehicleEntity vehicle) {
        vehicleDao.update(vehicle);
    }

    @Override
    public void delete(Long id) {
        vehicleDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        vehicleDao.deleteBatch(ids);
    }

}
