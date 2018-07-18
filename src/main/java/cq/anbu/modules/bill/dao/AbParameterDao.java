package cq.anbu.modules.bill.dao;

import cq.anbu.modules.bill.entity.AbParameterEntity;
import cq.anbu.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 字典
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-18 13:28:53
 */
@Mapper
public interface AbParameterDao extends BaseDao<AbParameterEntity> {

    List<AbParameterEntity> queryParamList(AbParameterEntity abParameter);
}
