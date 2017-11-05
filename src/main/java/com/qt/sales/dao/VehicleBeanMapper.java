package com.qt.sales.dao;

import com.qt.sales.model.VehicleBean;
import com.qt.sales.model.VehicleBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehicleBeanMapper {
    int countByExample(VehicleBeanExample example);

    int deleteByExample(VehicleBeanExample example);

    int deleteByPrimaryKey(String vehicleId);

    int insert(VehicleBean record);

    int insertSelective(VehicleBean record);

    List<VehicleBean> selectByExample(VehicleBeanExample example);

    VehicleBean selectByPrimaryKey(String vehicleId);

    int updateByExampleSelective(@Param("record") VehicleBean record, @Param("example") VehicleBeanExample example);

    int updateByExample(@Param("record") VehicleBean record, @Param("example") VehicleBeanExample example);

    int updateByPrimaryKeySelective(VehicleBean record);

    int updateByPrimaryKey(VehicleBean record);
}