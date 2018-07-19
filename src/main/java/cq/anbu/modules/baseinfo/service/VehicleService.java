package cq.anbu.modules.baseinfo.service;

import cq.anbu.modules.baseinfo.entity.VehicleEntity;

import java.util.List;
import java.util.Map;

/**
 * 车辆信息表
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-18 18:47:04
 */
public interface VehicleService {

    VehicleEntity queryObject(Long id);

    List<VehicleEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(VehicleEntity vehicle);

    void update(VehicleEntity vehicle);

    void delete(Long id);

    void deleteBatch(Long[] ids);
}
