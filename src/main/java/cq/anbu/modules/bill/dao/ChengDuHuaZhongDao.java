package cq.anbu.modules.bill.dao;

import cq.anbu.modules.bill.entity.ChengDuHuaZhongEntity;
import cq.anbu.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 成都华众账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-28 15:58:00
 */
@Mapper
public interface ChengDuHuaZhongDao extends BaseDao<ChengDuHuaZhongEntity> {
    ChengDuHuaZhongEntity queryObjectByTrackingNo(String trackingNo);
}
