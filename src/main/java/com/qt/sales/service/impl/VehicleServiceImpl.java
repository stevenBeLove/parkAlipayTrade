/** 
 * 包名: package com.qt.sales.service.impl; <br/> 
 * 添加时间: 2017年11月4日 下午8:52:44 <br/> 
 */
package com.qt.sales.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qt.sales.dao.VehicleBeanMapper;
import com.qt.sales.model.VehicleBean;
import com.qt.sales.service.VehicleService;

/** 
 * 类名: VehicleServiceImpl <br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2017年11月4日 下午8:52:44 <br/> 
 * 版本： JDK 1.6 parkAlipayTrade 1.0
 */
@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {

    @Resource
    private VehicleBeanMapper vehicleBeanMapper;
    
    @Override
    public int insert(VehicleBean record) {
        // TODO Auto-generated method stub
        return vehicleBeanMapper.insert(record);
    }

}

