package com.qt.sales.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qt.sales.model.ParkBean;
import com.qt.sales.model.ParkBeanExample;

public interface ParkBeanMapper {
    
    int countByExample(ParkBeanExample example);

    int deleteByExample(ParkBeanExample example);

    int deleteByPrimaryKey(String outParkingId);

    int insert(ParkBean record);

    int insertSelective(ParkBean record);

    List<ParkBean> selectByExample(ParkBeanExample example);

    ParkBean selectByPrimaryKey(String outParkingId);

    int updateByExampleSelective(@Param("record") ParkBean record, @Param("example") ParkBeanExample example);

    int updateByExample(@Param("record") ParkBean record, @Param("example") ParkBeanExample example);

    int updateByPrimaryKeySelective(ParkBean record);

    int updateByPrimaryKey(ParkBean record);
    
    List<ParkBean> selectAllParkBean(ParkBeanExample example);
}