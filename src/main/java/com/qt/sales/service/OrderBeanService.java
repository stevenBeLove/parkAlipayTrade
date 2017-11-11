package com.qt.sales.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qt.sales.model.OrderBean;
import com.qt.sales.model.OrderBeanExample;

public interface OrderBeanService {
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
	     * 根据订单ID获取订单
	     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
	     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
	     * 【作者】: yinghui zhang .<br/>
	     * 【时间】： 2017年11月10日 下午2:50:05 .<br/>
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
	     * 同步订单表
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
}
