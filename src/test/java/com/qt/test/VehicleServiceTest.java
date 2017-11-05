/** 
 * 包名: package com.qt.test; <br/> 
 * 添加时间: 2017年11月4日 下午8:48:29 <br/> 
 */
package com.qt.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qt.sales.model.VehicleBean;
import com.qt.sales.service.ParkService;
import com.qt.sales.service.VehicleService;
import com.qt.sales.utils.DateUtil;

/** 
 * 类名: VehicleServiceTest <br/> 
 * 作用：TODO(简单一句话描述)<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2017年11月4日 下午8:48:29 <br/> 
 * 版本： JDK 1.6 parkAlipayTrade 1.0
 */
public class VehicleServiceTest {
    
    VehicleService vehicleService;
    
   // @Before
    public void getTaskByUser() {
        ApplicationContext app = new ClassPathXmlApplicationContext("shiroConfig/applicationContext.xml");
        vehicleService = (VehicleService) app.getBean("vehicleService");
    }
    
    @Test
    public void testInsert(){
        VehicleBean bean = new VehicleBean();
        bean.setCarId("1710141555540010040463200036");
        bean.setParkingId("PI1508920124535365768");
        bean.setCarNumber("沪A6B521");
        bean.setAuthToken("ecopingBfad68f023e834cbeb01efc8424112X63");
        bean.setUserId("2088102170404632");
        vehicleService.insert(bean);
        
    }
    
    public static Map<String,Object> parkingStore = new HashMap<String,Object>();
    
    @Test
    public void testStore(){
        Random random = new Random();
        System.out.println(DateUtil.getCurrDateAndTime()+random.nextInt(1000));
    }
}

