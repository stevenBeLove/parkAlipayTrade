/** 
 * 包名: package com.qt.test; <br/> 
 * 添加时间: 2017年10月29日 下午2:28:54 <br/> 
 */
package com.qt.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qt.sales.model.ParkBean;
import com.qt.sales.service.ParkService;

/** 
 * 类名: ParkServiceTest <br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2017年10月29日 下午2:28:54 <br/> 
 * 版本： JDK 1.6 parkAlipayTrade 1.0
 */
public class ParkServiceTest {

    ParkService parkService;
    
    @Before
    public void getTaskByUser() {
        ApplicationContext app = new ClassPathXmlApplicationContext("shiroConfig/applicationContext.xml");
        parkService = (ParkService) app.getBean("parkService");
    }
    
    @Test
    public void insertPark(){
        ParkBean record = new ParkBean();
        record.setMerchantName("上海果元停车场");
        record.setMerchantServicePhone("021-25413215");
        record.setAccountNo("kftmke1407@sandbox.com");
        parkService.insert(record);
    }
    
    public static String getBizContent(){
        JSONObject data = new JSONObject();
        data.put("merchant_name", "上海果元停车场");
        data.put("merchant_service_phone", "021-25413215");
        data.put("account_no", "qcxdac2965@sandbox.com");
//        data.put("merchant_logo", getImageStr());
        List<JSONObject> listJson = new ArrayList<JSONObject>();
        JSONObject list = new JSONObject();
        list.put("interface_name", "alipay.eco.mycar.parking.userpage.query");
        list.put("interface_type", "interface_page");
        list.put("interface_url", "");
        listJson.add(list);
        data.put("interface_info_list", JSON.toJSON(listJson));
        String jsonStr = JSON.toJSONString(data);
        System.out.println(jsonStr);
        return jsonStr;
    }
}

