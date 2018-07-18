package cq.anbu.modules.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cq.anbu.modules.bill.dao.CustomerDao;
import cq.anbu.modules.bill.entity.CustomerEntity;
import cq.anbu.modules.bill.service.CustomerService;



@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public CustomerEntity queryObject(Long id){
		return customerDao.queryObject(id);
	}
	
	@Override
	public List<CustomerEntity> queryList(Map<String, Object> map){
		return customerDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return customerDao.queryTotal(map);
	}
	
	@Override
	public void save(CustomerEntity customer){
		customerDao.save(customer);
	}
	
	@Override
	public void update(CustomerEntity customer){
		customerDao.update(customer);
	}
	
	@Override
	public void delete(Long id){
		customerDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		customerDao.deleteBatch(ids);
	}
	
}
