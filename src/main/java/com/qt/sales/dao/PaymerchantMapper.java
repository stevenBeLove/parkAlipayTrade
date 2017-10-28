package com.qt.sales.dao;

import java.util.List;

import com.qt.sales.model.Paymerchant;
import com.qt.sales.model.PaymerchantExample;

public interface PaymerchantMapper {
    int countByExample(PaymerchantExample example);

    int deleteByExample(PaymerchantExample example);

    int deleteByPrimaryKey(String merchantid);

    int insert(Paymerchant record);

    int insertSelective(Paymerchant record);

    List<Paymerchant> selectByExample(PaymerchantExample example);

    Paymerchant selectByPrimaryKey(String merchantid);

    int updateByPrimaryKeySelective(Paymerchant record);

    int updateByPrimaryKey(Paymerchant record);
}