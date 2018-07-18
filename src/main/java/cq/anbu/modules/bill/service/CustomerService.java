package cq.anbu.modules.bill.service;

import cq.anbu.modules.bill.entity.CustomerEntity;

import java.util.List;
import java.util.Map;

/**
 * 客户信息表
 *
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-07-18 18:47:04
 */
public interface CustomerService {

    CustomerEntity queryObject(Long id);

    List<CustomerEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(CustomerEntity customer);

    void update(CustomerEntity customer);

    void delete(Long id);

    void deleteBatch(Long[] ids);
}
