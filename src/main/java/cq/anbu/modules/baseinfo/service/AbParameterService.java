package cq.anbu.modules.baseinfo.service;

import cq.anbu.modules.baseinfo.entity.AbParameterEntity;

import java.util.List;
import java.util.Map;

/**
 * 字典
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-18 13:28:53
 */
public interface AbParameterService {

    AbParameterEntity queryObject(Long id);

    List<AbParameterEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(AbParameterEntity abParameter);

    void update(AbParameterEntity abParameter);

    void delete(Long id);

    void deleteBatch(Long[] ids);

    List<AbParameterEntity> queryParamList(AbParameterEntity abParameter);
}
