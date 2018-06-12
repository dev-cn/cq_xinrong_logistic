package cq.anbu.modules.bill.dao;

import cq.anbu.modules.bill.entity.BillCollectEntity;
import cq.anbu.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 运费汇总表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-06-10 09:48:20
 */
@Mapper
public interface BillCollectDao extends BaseDao<BillCollectEntity> {
	
}
