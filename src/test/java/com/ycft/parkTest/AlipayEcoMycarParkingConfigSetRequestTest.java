/** 
 * 包名: package AlipayParkTest; <br/> 
 * 添加时间: 2017年10月14日 下午10:03:01 <br/> 
 */
package com.ycft.parkTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayEcoMycarParkingConfigSetRequest;
import com.alipay.api.response.AlipayEcoMycarParkingConfigSetResponse;

import sun.misc.BASE64Encoder;

/**
 * 
 * <pre>
 * 【类型】: AlipayEcoMycarParkingConfigSetRequestTest <br/> 
 * 【作用】:设置停车场信息. <br/>  
 * 【时间】：2017年10月25日 上午11:56:26 <br/> 
 * 【作者】：yinghui zhang <br/> 
 * </pre>
 */
public class AlipayEcoMycarParkingConfigSetRequestTest {

	static String APP_ID = "2017051107201228";
    static String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCicpLsrV4OKwfPZfe7mkT1tWlWA82+41PqHqe802YFqVmzWZNJF0TtRd2FdL8TSagPOidQOOhmrSSTaT+fD5ywpjoKf4qhKKNt5vWHS1n6fU8/P3EcBzD1Eo4PTCMiRtULtkUaM7vPQF59O8TnFmslLRTr44eJbz7HH+amekZOTN6c7mdee+cjpbre/NNwAbldYsPmou2WMNCAD86om9PU69mX2NK9OVZbwLrXxbaozvXaSpXuiQN2CeIz1R6fb3KIYXg0kKmb2ZodPRrIQ7Dl9SD1jVNpIX48YvI/bDaDHdnm/ozmjsL3pEdYDdKITcYEY1MrEipC5qQBITvk9ZMjAgMBAAECggEAB+ULkOcICCY9Ne4dsQdZTJupZ929dQZ1QI6G1l1ruuC1FEtJJic0WVeo4WCAHL7apQrNeE+bs8m8WlGmHuPSWJ9reLEkGprv/lpYGmAmGk9Wt5sssxECZxakwsePeY35sp0EFLbo7LSTIwDxm81yHZdoSeJ/5sT6RxEc04BjxFBSNvd/niBiSb8y+CXZre1BnV7zlvWOkQ9elTpPIxtU/HmrON7AM1iIGIdDfNEC8rxAdiXD42C2mxZ/v49lIx17JO5Kc+7UL5vkE6SzoQD9f4mlCg21Pi9kS9/KqbMywp1XF0U4UWLKzjeANVFoqUqsf4Pnhs5XcM0JGQbHlrhquQKBgQDUOKBU27CXLeP279IHLMO9FTYVeI28KLLIdWezfoUZFaFY/aspdlUtfkJUF5bKUMLpztvbEWvFFJAAzJgB2ecc4Uhzk5bGxvAaTnff8qb4qG+kDsO6+sP2lZkmxaikwl1vP2WXi7slaDIfAf3vjTA/nV3CubEwKGUB5JDang3g1QKBgQDD9Wh4IyVNDlAiq6pKEfnxdgYvHtHLim7ecFeKDQj6QqeFyI7UwMOSUJB8H981WKyLKynDiG3c5lSZTPGptiGDCFGSjmLtzuCu3ZPbSkT9ABojd2fVXYP93UbRYk4aFkOyD3/p+RRiPdbBTsdO3uBLeJeGa0fhLN/XzFuadwzgFwKBgFol372MQNxHSyH3R5Fyq4cjfoDqX9LAuwk6Dh4KLYG1VX+W6eFH+fDERGqyRoSUf+ePzoalRNFH5c/hGOUYafszm3I1DIRNt2qFUJiZ2+GesyXOe8hug1W4wIDez7+FLOl31bDlU08VjszrLLJYmFk9gLmZ5bGeRyHhtMKZBy4tAoGAVWPFCETYZkGMbe88H1bCAZQakcHuTbGfKlLt8nxHozYUZdnFU7REBKgSreP9kfN4DJTceBYlOZMs3jiHPhrdc4nWcfSV62awxcJMQcyVT2ISAc5wcqtzbtZTm74opnl5OkhCxyQA2+ZyhH3dn+LC/mAoNyzcf6TcTd8BM8gY1jUCgYAQoUNFELLfM5w8J+OLmv0ZcRusmtflgb+W9QEqW+P+j++699fWPacCC1SDOe2+wulew/+xWYJn3j2Awhs3oUVpZmmbPwtNToNGac8z9cje/TaQ3WchNcMZPSfFQAQQB6rIQKcv24rilRUZCByU1DcX60q8xgzBzHgEfz8qCDoukA==";
    static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1GtK+8COV9VGgof1WtHItVRMiflrrK4owPFIbsxuEi+6X2HNmk0urZuTe+gagLMA9hXOmVnol2hrZ9wNS+22If5vs87wtncv0L97yqj8zqrMR/DsxtMKgd7a2bWs+W686espHVW1bxYwrcAB9bTvZfhpNOVbSc9nifOMTzoQYoa9i5ErWH2ObDSh3IrzypJuIAMwuOWzwEzZdBXu1tCgSZWQHbldXrT8dvNnnhEUuT/lMqV+uLTIPT/Cue/3x1hUb9BByG3oPTj/FazL2e19tfi89gyzMLXBdiMS+RiUVhafuxQk487FOxFBqwp5gFpNS7LGJ31khJlJKEWGsmCtSwIDAQAB";
    static String sign_type = "RSA2";
    static String APP_AUTH_TOKEN = "201710BBb26773c515324b6fb642004cab7d1X63";
    static String interface_url = "https%3a%2f%2fwww.kangguole.com.cn%2fparkAlipayTrade%2falipayPark%2fnotify";    
    // 支付宝沙箱网关
    static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
    
    // 编码格式
    static String charset = "UTF-8";
    public static void main(String[] args) {
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl, APP_ID, APP_PRIVATE_KEY, "json", charset, 
                ALIPAY_PUBLIC_KEY, sign_type);
        AlipayEcoMycarParkingConfigSetRequest request = new AlipayEcoMycarParkingConfigSetRequest();
        request.setBizContent(getBizContent());//业务数据
        AlipayEcoMycarParkingConfigSetResponse  response;
        try {
            response = alipayClient.execute(request);
            if (response.isSuccess()) {
                System.out.println("---"+response.getBody());
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
    public static String getBizContent(){
        JSONObject data = new JSONObject();
        data.put("merchant_name", "云停风驰");
        data.put("merchant_service_phone", "400-820-8979");
        data.put("account_no", "648852187@qq.com");
        data.put("merchant_logo", getImageStr());
        List<JSONObject> listJson = new ArrayList<JSONObject>();
        JSONObject list = new JSONObject();
        list.put("interface_name", "alipay.eco.mycar.parking.userpage.query");
        list.put("interface_type", "interface_page");
        list.put("interface_url", interface_url);
        listJson.add(list);
        data.put("interface_info_list", JSON.toJSON(listJson));
        String jsonStr = JSON.toJSONString(data);
        System.out.println(jsonStr);
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
