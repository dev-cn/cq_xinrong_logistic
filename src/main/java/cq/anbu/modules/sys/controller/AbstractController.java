package cq.anbu.modules.sys.controller;

import cq.anbu.common.base.BaseEntity;
import cq.anbu.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Controller公共组件
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月9日 下午9:42:26
 */
public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUserEntity getUser() {
        return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getUserId() {
        return getUser().getUserId();
    }

    public <T extends BaseEntity> T wrapperBaseEntity(T baseEntity) {
        baseEntity.setCreateAt(new Date());
        baseEntity.setCreateBy(getUser().getUsername());
        baseEntity.setUpdateAt(new Date());
        baseEntity.setUpdateBy(getUser().getUsername());
        baseEntity.setIsDelete(0);
        return baseEntity;
    }
}
