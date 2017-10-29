/** 
 * 包名: package com.qt.sales.service.impl; <br/> 
 * 添加时间: 2017年10月29日 下午2:10:48 <br/> 
 */
package com.qt.sales.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import sun.misc.BASE64Encoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayEcoMycarParkingConfigSetRequest;
import com.alipay.api.response.AlipayEcoMycarParkingConfigSetResponse;
import com.qt.sales.common.RSConsts;
import com.qt.sales.dao.ParkBeanMapper;
import com.qt.sales.exception.QTException;
import com.qt.sales.model.ParkBean;
import com.qt.sales.model.ParkBeanExample;
import com.qt.sales.service.ParkService;

/** 
 * 类名: ParkServiceImpl <br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2017年10月29日 下午2:10:48 <br/> 
 * 版本： JDK 1.6 parkAlipayTrade 1.0
 */
@Service("parkService")
public class ParkServiceImpl implements ParkService {

    static String INTERFACE_URL = "https%3a%2f%2fwww.kangguole.com.cn%2fparkAlipayTrade%2falipayPark%2fnotify";    
    
    protected final Logger       logger = LoggerFactory.getLogger(this.getClass());  
    
    @Resource
    private ParkBeanMapper parkBeanMapper;
    
    
    @Override
    public ParkBean selectByPrimaryKey(String outParkingId){
        return parkBeanMapper.selectByPrimaryKey(outParkingId);
    }


    @Override
    public int updateByPrimaryKey(ParkBean record) {
        return parkBeanMapper.updateByPrimaryKey(record);
    }


    @Override
    public int insert(ParkBean record) {
        return parkBeanMapper.insert(record);
    }


    @Override
    public int countByExample(ParkBeanExample example) {
        // TODO Auto-generated method stub
        return parkBeanMapper.countByExample(example);
    }


    @Override
    public int deleteByExample(ParkBeanExample example) {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public int deleteByPrimaryKey(String outParkingId) {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public int insertSelective(ParkBean record) {
        // TODO Auto-generated method stub
        return parkBeanMapper.insertSelective(record);
    }


    @Override
    public List<ParkBean> selectByExample(ParkBeanExample example) {
        // TODO Auto-generated method stub
        return parkBeanMapper.selectByExample(example);
    }
    
    /**
     * 【方法名】    : (停车ISV系统配置接口). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年10月29日 下午8:16:30 .<br/>
     * 【参数】： .<br/>
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     * @throws QTException 
     */
    public boolean parkingConfigSetRequest(AlipayClient alipayClient, String outParkingId) throws QTException{
        ParkBean park = this.selectByPrimaryKey(outParkingId);
        if(StringUtils.isEmpty(park) && StringUtils.isEmpty(park.getAppAuthToken())){
            throw new QTException("未获得商家授权！请先授权");
        }
        AlipayEcoMycarParkingConfigSetRequest request = new AlipayEcoMycarParkingConfigSetRequest();
        request.setBizContent(getBizContent(park));//业务数据
        request.putOtherTextParam("app_auth_token",park.getAppAuthToken());
        AlipayEcoMycarParkingConfigSetResponse  response;
        try {
            response = alipayClient.execute(request);
            if (response.isSuccess()) {
                logger.debug("调用成功");
                return true;
            } else {
                throw new QTException(response.getBody());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            throw new QTException(e.getErrMsg());
        }
    }
    
    /**
     * 
     * 【方法名】    : (业务数据). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2017年10月29日 下午8:43:57 .<br/>
     * 【参数】： .<br/>
     * @param park
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    private String getBizContent(ParkBean park){
        JSONObject data = new JSONObject();
        data.put(RSConsts.MERCHANT_NAME, park.getMerchantName());
        data.put(RSConsts.MERCHANT_SERVICE_PHONE, park.getMerchantServicePhone());
        data.put(RSConsts.ACCOUNT_NO, park.getAccountNo());
//        data.put(RSConsts.MERCHANT_LOGO, getImageStr());
        List<JSONObject> listJson = new ArrayList<JSONObject>();
        JSONObject list = new JSONObject();
        list.put(RSConsts.INTERFACE_NAME, "alipay.eco.mycar.parking.userpage.query");
        list.put(RSConsts.INTERFACE_TYPE, "interface_page");
        list.put(RSConsts.INTERFACE_URL, INTERFACE_URL);
        listJson.add(list);
        data.put(RSConsts.INTERFACE_INFO_LIST, JSON.toJSON(listJson));
        String jsonStr = JSON.toJSONString(data);
        logger.debug(jsonStr);
        return jsonStr;
    }
    
    public static String getImageStr() {
        //待处理的本地图片
        try {
      String imgFile = "C:\\data\\logo\\27X27.png";
      InputStream in = null;
      byte[] data = null;
      //读取图片字节数组
      try {
          in = new FileInputStream(imgFile);
          data = new byte[in.available()];
          in.read(data);
          in.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
      //对字节数组Base64编码
      BASE64Encoder encoder = new BASE64Encoder();
      //返回Base64编码过的字节数组字符串
      return "data:image/png;base64,"+encoder.encode(data);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
        return "";
    }
    
}

