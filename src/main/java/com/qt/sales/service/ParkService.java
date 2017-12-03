/** 
 * 包名: package com.qt.sales.service; <br/> 
 * 添加时间: 2017年10月29日 下午2:09:27 <br/> 
 */
package com.qt.sales.service;

import java.util.List;

import com.qt.sales.exception.QTException;
import com.qt.sales.model.ParkBean;
import com.qt.sales.model.ParkBeanExample;
import com.qt.sales.model.VehicleBean;

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
    
    public boolean parkingConfigSetRequest(String outParkingId) throws Exception;
    
    int updateByPrimaryKeySelective(ParkBean record);
    
    /**
     * 【方法名】    : (创建停车场). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年11月4日 下午9:38:52 .<br/>
     * 【参数】： .<br/>
     * @param outParkingId
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public String parkingCreate(String outParkingId);
    
    //修改停车场信息
    public String parkinglotinfoUpdate(String outParkingId);
    
    /**
     * 【注意】: (驶入车辆).<br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年11月2日 下午5:23:41 .<br/>
     * 【参数】： .<br/>
     * @param park
     * @param carNumber
     * @param carType
     * @param carColor
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public String enterinfoSyncEnter(ParkBean park,String order_trade,String carNumber, String in_time,
    		String carType,String carColor,String agreementStatus,String billingType, String carNumberColor,String lane);
    
    /**
     * 【方法名】    : (车辆驶出). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年11月2日 下午5:24:00 .<br/>
     * 【参数】： .<br/>
     * @param parkingId
     * @param carNumber
     * @param inTime
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public String ecoMycarParkingExitinfoSync(ParkBean park,String carNumber,String out_time);
    
    /**
     * 
     * 【方法名】    : (车牌查询). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年11月4日 下午2:50:35 .<br/>
     * 【参数】： .<br/>
     * @param bean
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public String ecoMycarParkingVehicleQuery(VehicleBean bean);
    
    /**
     * 【方法名】    : (订单同步). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年11月4日 下午2:53:16 .<br/>
     * 【参数】： .<br/>
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public String ecoMycarParkingOrderSyn();
    /**
     * 【方法名】    : (加载全部停车场数据). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年11月4日 下午8:15:46 .<br/>
     * 【参数】： .<br/>
     * @param example
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    List<ParkBean> selectAllParkBean(ParkBeanExample example);
    
    /**
     * 根据ParkingID查找停车场
     * @param parkingId
     * @return
     */
    public ParkBean selectByPrimaryParkingId(String parkingId);
}

