/** 
 * 包名: package com.qt.sales.service; <br/> 
 * 添加时间: 2017年10月29日 下午2:09:27 <br/> 
 */
package com.qt.sales.service;

import java.util.List;

import com.alipay.api.AlipayClient;
import com.qt.sales.exception.QTException;
import com.qt.sales.model.ParkBean;
import com.qt.sales.model.ParkBeanExample;

/** 
 * 类名: ParkService <br/> 
 * 作用：停车场管理接口<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2017年10月29日 下午2:09:27 <br/> 
 * 版本： JDK 1.6 parkAlipayTrade 1.0
 */
public interface ParkService {

    public ParkBean selectByPrimaryKey(String outParkingId);
    
    public int updateByPrimaryKey(ParkBean record);
    
    public int insert(ParkBean record);
    
    int countByExample(ParkBeanExample example);

    int deleteByExample(ParkBeanExample example);

    int deleteByPrimaryKey(String outParkingId);

    int insertSelective(ParkBean record);

    List<ParkBean> selectByExample(ParkBeanExample example);
    
    public boolean parkingConfigSetRequest(String outParkingId) throws QTException;
    
    int updateByPrimaryKeySelective(ParkBean record);
    
    //创建停车场
    public String parkingCreate(String outParkingId);
    
    //修改停车场信息
    public String parkinglotinfoUpdate(String outParkingId);
    
    
}

