package com.qt.sales.dao;

import com.qt.sales.model.OrderBean;
import com.qt.sales.model.OrderBeanExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderBeanMapper {
    int countByExample(OrderBeanExample example);

    int deleteByExample(OrderBeanExample example);

    int deleteByPrimaryKey(String orderNo);

    int insert(OrderBean record);

    int insertSelective(OrderBean record);

    List<OrderBean> selectByExample(OrderBeanExample example);

    OrderBean selectByPrimaryKey(String orderNo);

    int updateByExampleSelective(@Param("record") OrderBean record, @Param("example") OrderBeanExample example);

    int updateByExample(@Param("record") OrderBean record, @Param("example") OrderBeanExample example);

    int updateByPrimaryKeySelective(OrderBean record);

    int updateByPrimaryKey(OrderBean record);
    /**
     *查询已经支付的金额
     * @param outOrderNo
     * @return
     */
    String queryPaidMoneyWithOrderNo(String outOrderNo);
    
    /**
     * 临时订单表已经支付的金额
     * @param orderTrade
     * @return
     */
    String queryTempPaidWithOrderTrade(String orderTrade);
    /**
     * 【注意】: (根据订单ID获取订单).<br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年11月10日 下午2:49:21 .<br/>
     * 【参数】： .<br/>
     * @param orderNo
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    OrderBean selectByOrderNo(String orderNo);
    /**
     * 记录订单表
     * @param record
     * @return
     */
    int insertFromOrder(OrderBean record);
    /**
     * 更新订单
     * @param record
     * @return
     */
    int updateOrderPayByOrderNo(OrderBean record);
    
    /**
     * 
     * 【方法名】    : (退单接口). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年11月15日 下午2:30:34 .<br/>
     * 【参数】： .<br/>
     * @param orderNo
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public OrderBean selectPayOrderByOrderNo(String orderNo);
    
    /**
     * 删除订单
     * @param orderTrade
     * @return
     */
    int deleteWithOrderTrade(String orderTrade);
}