/** 
 * 包名: package com.qt.sales.service; <br/> 
 * 添加时间: 2016年10月19日 下午6:57:29 <br/> 
 */
package com.qt.sales.service;

import java.util.List;
import java.util.Map;

import com.qt.sales.model.Customer;
import com.qt.sales.model.CustomerExample;

/** 
 * 类名: CustomerService <br/> 
 * 作用：TODO(用户Service)<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2016年10月19日 下午6:57:29 <br/> 
 * 版本： JDK 1.6 sales 1.0
 */
public interface CustomerService {

    /**
     * @param example 用户
     * @return 查询用户列表
     * @throws Exception 异常
     */
    public List<Customer> selectByExample(CustomerExample example)throws Exception;
   
    /**
     * @param example 用户
     * @return 查询用户数
     * @throws Exception 异常
     */
    public int countByExample(CustomerExample example)throws Exception;
    
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
     * 【方法名】    : (根据客户Id查询客户). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月2日 上午11:11:34 .<br/>
     * 【参数】： .<br/>
     * @param customer Customer
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
    
    
    /**
     * 
     * 【方法名】    : (根据id查询列表). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月24日 上午11:59:26 .<br/>
     * 【参数】： .<br/>
     * @param customerid String
     * @return 客户列表
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public List<Customer> selectCustoemrByPrimaryKeyResult(String customerid)throws Exception;
}

