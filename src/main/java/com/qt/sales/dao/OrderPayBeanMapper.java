package com.qt.sales.dao;

import com.qt.sales.model.OrderPayBean;
import com.qt.sales.model.OrderPayBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderPayBeanMapper {
    int countByExample(OrderPayBeanExample example);

    int deleteByExample(OrderPayBeanExample example);

    int deleteByPrimaryKey(String orderPayId);

    int insert(OrderPayBean record);

    int insertSelective(OrderPayBean record);

    List<OrderPayBean> selectByExample(OrderPayBeanExample example);

    OrderPayBean selectByPrimaryKey(String orderPayId);

    int updateByExampleSelective(@Param("record") OrderPayBean record, @Param("example") OrderPayBeanExample example);

    int updateByExample(@Param("record") OrderPayBean record, @Param("example") OrderPayBeanExample example);

    int updateByPrimaryKeySelective(OrderPayBean record);

    int updateByPrimaryKey(OrderPayBean record);
}