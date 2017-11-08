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
}
