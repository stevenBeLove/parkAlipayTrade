/**
 *  <pre>	
 *  Project Name:PayUserServer .</br>
 *  File: Payamountcontrol.java .</br>
 *  Package Name:com.imobpay.base.entity .</br>
 *  Date      Author       Changes .</br>
 *  20160614 050650 <br/>   Lance.Wu     Create  .</br>
 *  Description: .</br>
 *  Copyright 2014-2015 YINGXIANG FINANCE Services Co.,Ltd. All rights reserved..</br>
 *  <pre>	
 */
package com.qt.sales.dao.base;

import java.util.List;

/**
 * 
 * ClassName: BaseDao <br/> 
 * date: 2016年6月21日 上午10:54:35 <br/> 
 * 
 * @author madman
 * @param  <T> 泛型对象
 * @version @param <T>  泛型对象
 * @since JDK 1.6 PayUserServer 1.0
 */
public interface BaseDao<T> {

    /**
     * insert:(添加操作). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param bean
     *            添加对像 <br/>
     * @since JDK 1.6 1.0 <br/>
     */
    public int insert(T bean);

    /**
     * update:(修改操作). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param bean
     *            修改对像 <br/>
     * @since JDK 1.6 1.0 <br/>
     */
    public void update(T bean);

    /**
     * delete:(删除操作). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param bean
     *            删除对像 <br/>
     * @since JDK 1.6 1.0 <br/>
     */
    public void delete(T bean);

    /**
     * delete:(查询操作). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param bean
     *            查询对像 <br/>
     * @return Payamountcontrol <br/>
     * @since JDK 1.6 1.0 <br/>
     */
    public T selectById(T bean);

    /**
     * delete:(分页查询操作). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param bean
     *            查询对像 <br/>
     * @return List<Payamountcontrol> <br/>
     * @since JDK 1.6 1.0 <br/>
     */
    public List<T> list(T bean);

    /**
     * delete:(分页查询个数操作). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param bean
     *            查询对像 <br/>
     * @return Integer <br/>
     * @since JDK 1.6 1.0 <br/>
     */
    public Integer listCount(T bean);

}