package cq.anbu.modules.sys.dao;

import cq.anbu.modules.sys.entity.SysUserTokenEntity;
import cq.anbu.modules.sys.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户Token
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:07
 */
@Mapper
public interface SysUserTokenDao extends BaseDao<SysUserTokenEntity> {

    SysUserTokenEntity queryByUserId(Long userId);

    SysUserTokenEntity queryByToken(String token);

}
