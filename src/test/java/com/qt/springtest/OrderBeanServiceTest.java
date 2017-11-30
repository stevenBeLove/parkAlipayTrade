/** 
 * 包名: package com.qt.test; <br/> 
 * 添加时间: 2017年10月29日 下午2:28:54 <br/> 
 */
package com.qt.springtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qt.sales.exception.QTException;
import com.qt.sales.model.OrderBean;
import com.qt.sales.model.OrderBeanExample;
import com.qt.sales.model.ParkBean;
import com.qt.sales.model.VehicleBean;
import com.qt.sales.service.OrderBeanService;
import com.qt.sales.service.ParkService;
import com.qt.sales.utils.DateUtil;

/** 
 * 类名: ParkServiceTest <br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2017年10月29日 下午2:28:54 <br/> 
 * 版本： JDK 1.6 parkAlipayTrade 1.0
 */
public class OrderBeanServiceTest {

    OrderBeanService orderBeanService;
    
    @Before
    public void getTaskByUser() {
        ApplicationContext app = new ClassPathXmlApplicationContext("shiroConfig/applicationContext.xml");
        orderBeanService = (OrderBeanService) app.getBean("orderBeanService");
    }
    

    @Test
    public void testOrder(){
        //创建订单
        OrderBeanExample example = new OrderBeanExample();
        OrderBeanExample.Criteria cr = example.createCriteria();
        cr.andCarNumberEqualTo("沪A18S8");
        cr.andParkingIdEqualTo("100002010101");
        cr.andOrderStatusEqualTo("0");
        List<OrderBean> orderList = orderBeanService.selectByExample(example);
        for (OrderBean orderBean : orderList) {
            System.out.println(orderBean.getCardNumber());
        }
    }
    
    
    @Test
    public void test11(){
    	OrderBeanExample example = new OrderBeanExample();
        OrderBeanExample.Criteria cr = example.createCriteria();
        cr.andCarNumberEqualTo("沪C8H9K3");
        cr.andOutParkingIdEqualTo("10002");
        List<OrderBean> orderList = orderBeanService.selectByExample(example);
        OrderBean orderBean = orderList.get(0);
        // 驶出时间
        String out_time = DateUtil.getCurrDate(DateUtil.STANDDATEFORMAT);
    	// 更新车辆驶出订单
        orderBean.setOutTime(out_time);
        // 更新订单
        orderBeanService.updateOrderPayByOrderNo(orderBean);
    	
    }
    
    @Test
    public void orderupdate(){
        Map<String, String> params = new HashMap<String, String>();
        params.put("biz_content", "{\"update_time\":\"2017-11-29 23:53:33\",\"agreement_status\":\"1\",\"car_number\":\"沪A6B521\"}");
        try {
            orderBeanService.updateAgreementNotify(params);
        } catch (QTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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

