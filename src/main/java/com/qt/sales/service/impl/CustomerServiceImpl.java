/** 
 * 包名: package com.qt.sales.service.impl; <br/> 
 * 添加时间: 2016年10月19日 下午7:07:05 <br/> 
 */
package com.qt.sales.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qt.sales.dao.CustomerMapper;
import com.qt.sales.model.Customer;
import com.qt.sales.model.CustomerExample;
import com.qt.sales.service.CustomerService;

/** 
 * 类名: CustomerServiceImpl <br/> 
 * 作用：TODO(用户业务实现类)<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2016年10月19日 下午7:07:05 <br/> 
 * 版本： JDK 1.6 sales 1.0
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    /**
     * Dao层接口
     */
    @Resource
    private CustomerMapper customerMapper;
    
    @Override
    public List<Customer> selectByExample(CustomerExample example) throws Exception {
        return customerMapper.selectByExample(example);
    }

    @Override
    public int countByExample(CustomerExample example) throws Exception {
        return customerMapper.countByExample(example);
    }

    @Override
    public List<Customer> selectByCustomerExample(Map<String, Object> map) throws Exception {
        return customerMapper.selectByCustomerExample(map);
    }

    @Override
    public int countByCustomerExample(Map<String, Object> map) throws Exception {
        return customerMapper.countByCustomerExample(map);
    }

    @Override
    public Customer selectCustoemrByPrimaryKey(Customer customer) throws Exception {
        return customerMapper.selectCustoemrByPrimaryKey(customer);
    }

    @Override
    public Customer selectCustoemrByPrimaryKeyById(String customerId) throws Exception {
        return customerMapper.selectCustoemrByPrimaryKeyById(customerId);
    }
    
    @Override
    public List<Customer> selectCustoemrByPrimaryKeyResult(String customerid) throws Exception {
        return customerMapper.selectCustoemrByPrimaryKeyResult(customerid);
    }

}

