package cq.anbu.modules.baseinfo.dao;

import cq.anbu.modules.baseinfo.entity.VehicleEntity;
import cq.anbu.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 车辆信息表
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-18 18:47:04
 */
@Mapper
public interface VehicleDao extends BaseDao<VehicleEntity> {

}
