package cq.anbu.modules.baseinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cq.anbu.modules.baseinfo.dao.AbParameterDao;
import cq.anbu.modules.baseinfo.entity.AbParameterEntity;
import cq.anbu.modules.baseinfo.service.AbParameterService;


@Service("abParameterService")
public class AbParameterServiceImpl implements AbParameterService {
    @Autowired
    private AbParameterDao abParameterDao;

    @Override
    public AbParameterEntity queryObject(Long id) {
        return abParameterDao.queryObject(id);
    }

    @Override
    public List<AbParameterEntity> queryList(Map<String, Object> map) {
        return abParameterDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return abParameterDao.queryTotal(map);
    }

    @Override
    public void save(AbParameterEntity abParameter) {
        abParameterDao.save(abParameter);
    }

    @Override
    public void update(AbParameterEntity abParameter) {
        abParameterDao.update(abParameter);
    }

    @Override
    public void delete(Long id) {
        abParameterDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        abParameterDao.deleteBatch(ids);
    }

    @Override
    public List<AbParameterEntity> queryParamList(AbParameterEntity abParameter) {
        return abParameterDao.queryParamList(abParameter);
    }

}
