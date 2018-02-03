package com.qt.sales.dao;

import java.util.List;

import com.qt.sales.model.ParkLicense;
import com.qt.sales.model.ParkLicenseExample;

public interface ParkLicenseMapper {
    int countByExample(ParkLicenseExample example);

    int deleteByExample(ParkLicenseExample example);

    int insert(ParkLicense record);

    int insertSelective(ParkLicense record);

    List<ParkLicense> selectByExample(ParkLicenseExample example);
}