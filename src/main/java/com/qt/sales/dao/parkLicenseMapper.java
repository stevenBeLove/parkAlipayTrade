package com.qt.sales.dao;

import java.util.List;

import com.qt.sales.model.parkLicense;
import com.qt.sales.model.parkLicenseExample;

public interface parkLicenseMapper {
    int countByExample(parkLicenseExample example);

    int deleteByExample(parkLicenseExample example);

    int insert(parkLicense record);

    int insertSelective(parkLicense record);

    List<parkLicense> selectByExample(parkLicenseExample example);

}