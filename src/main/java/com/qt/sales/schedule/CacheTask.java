package com.qt.sales.schedule;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.qt.sales.model.ParkBean;
import com.qt.sales.model.ParkBeanExample;
import com.qt.sales.service.ParkService;


/**
 * 
 * 类名: CacheTask <br/>
 * 创建者: zhangyinghui. <br/>
 * 添加时间: 2016年7月27日 下午1:22:58 <br/>
 * 版本：
 * 
 * @since JDK 1.6 chart 1.0
 */

@Component
public class CacheTask {

	protected final Logger       logger = LoggerFactory.getLogger(this.getClass()); 

	@Autowired
	public ParkService parkService;

	//每天上午04:10触发
	@Scheduled(cron = "0 10 04 * * ?")
	public void generateCacheDate() {
	    ParkBeanExample example = new ParkBeanExample();
      ParkBeanExample.Criteria cr = example.createCriteria();
	    List<ParkBean> parks =  parkService.selectAllParkBean(example);
	    if(parks!=null && parks.size()>0){
	        for (ParkBean parkBean : parks) {
	            if("1".equals(parkBean.getStatus())){
	                String expireId = parkBean.getExpiresIn();//过期时间
	                
	            }
	        }
	    }
	  
//	    parkService.updateRefreshAppToken(outParkingId);
	}


}
