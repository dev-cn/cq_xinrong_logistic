package cq.anbu.modules.bill.dao;

import cq.anbu.modules.bill.entity.ChongQingYuanDingEntity;
import cq.anbu.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 重庆远鼎账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
@Mapper
public interface ChongQingYuanDingDao extends BaseDao<ChongQingYuanDingEntity> {
    ChongQingYuanDingEntity queryObjectByTrackingNo(String trackingNo);
}
