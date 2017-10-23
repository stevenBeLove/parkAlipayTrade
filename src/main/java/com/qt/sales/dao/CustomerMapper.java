package com.qt.sales.dao;

import java.util.List;
import java.util.Map;

import com.qt.sales.model.Customer;
import com.qt.sales.model.CustomerExample;
/**
 * 
 * <pre>
 * 【类型】: CustomerMapper <br/> 
 * 【作用】: Customer Dao类. <br/>  
 * 【时间】：2016年11月1日 下午1:59:43 <br/> 
 * 【作者】：yinghui zhang <br/> 
 * </pre>
 */
public interface CustomerMapper {
    /**
     * 
     * 【方法名】    : (查询符合条件的数量). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月1日 下午2:00:06 .<br/>
     * 【参数】： .<br/>
     * @param example CustomerExample
     * @throws Exception Exception
     * @return int.<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public int countByExample(CustomerExample example)throws Exception;


    /**
     * 
     * 【方法名】    : (查询符合条件的集合). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月1日 下午2:01:30 .<br/>
     * 【参数】： .<br/>
     * @param example CustomerExample
     * @return List<Customer> 
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public List<Customer> selectByExample(CustomerExample example)throws Exception;
    
    /**
     * 
     * 【方法名】    : (根据条件查询客户列表). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月1日 下午6:06:36 .<br/>
     * 【参数】： .<br/>
     * @param map Map<String, Object>
     * @return List<Customer>
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public List<Customer> selectByCustomerExample(Map<String, Object> map)throws Exception;
    
    /**
     * 
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月1日 下午7:05:02 .<br/>
     * 【参数】： .<br/>
     * @param map Map<String, Object>
     * @return int
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public int countByCustomerExample(Map<String, Object> map)throws Exception;

    /**
     * 
     * 【方法名】    : (根据主键查询Customer). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月1日 下午2:02:36 .<br/>
     * 【参数】： .<br/>
     * @param customerid String
     * @return Customer
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public Customer selectByPrimaryKey(String customerid)throws Exception;
    
    /**
     * 
     * 【方法名】    : (根据客户Id查询客户). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月2日 上午11:11:34 .<br/>
     * 【参数】： .<br/>
     * @param customer Customer对象
     * @return Customer 
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public Customer selectCustoemrByPrimaryKey(Customer customer)throws Exception;
    
    /**
     * 
     * 【方法名】    : (根据id查询列表). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月24日 上午11:59:26 .<br/>
     * 【参数】： .<br/>
     * @param customerid 客户Id
     * @return 客户列表
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public List<Customer> selectCustoemrByPrimaryKeyResult(String customerid)throws Exception;
    
    /**
     * 
     * 【方法名】    : (根据客户Id查询客户). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月2日 上午11:11:34 .<br/>
     * 【参数】： .<br/>
     * @param customerId 客户Id
     * @return Customer
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public Customer selectCustoemrByPrimaryKeyById(String customerId)throws Exception;

}