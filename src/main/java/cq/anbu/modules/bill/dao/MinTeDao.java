package cq.anbu.modules.bill.dao;

import cq.anbu.modules.bill.entity.MinTeEntity;
import cq.anbu.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 敏特账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
@Mapper
public interface MinTeDao extends BaseDao<MinTeEntity> {
    MinTeEntity queryObjectByTrackingNo(String trackingNo);
}
