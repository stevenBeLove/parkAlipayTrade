package com.qt.sales.service.impl;

import org.springframework.stereotype.Service;

import com.qt.sales.service.JsonUtils;
import com.qt.sales.utils.ResultList;

import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;

/**
 * 类说明 处理各种对象转换成JSON格式字符串
 *
 * @author zhangyinghui
 */
@Service("jsonUtils")
public class JsonUtilsBean implements JsonUtils {
    
    /**请在类路劲sysParams.properties文件下的dateFields下增加相应的属性字段以“，”隔开，例如：createTime,modifyTime*/
    private static String[] DATEFIELDARRAY = null;

    /**
     * 
     */
    private static final DateTransformer DATETRANSFORMER = new DateTransformer("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取对象转换为JSON格式的字符串
     *
     * @param obj
     *            任意对象
     * @return JSON格式字符串
     */
    public String getObjToJson(Object obj) {
        loadFields();
        JSONSerializer serializer = new JSONSerializer().exclude("class", "valueObj");
        if (obj == null) {
            return "";
        }
        serializer = serializer.transform(DATETRANSFORMER, DATEFIELDARRAY);
        return serializer.serialize(obj).replaceAll("null", "\"\"").replaceAll(" 00:00:00", "").replaceAll(" 23:59:59", "");
    }

    /**
     * 
     * TODO 将结果集转换成JSON格式 . 
     * @see com.qt.sales.service.JsonUtils#getResultListToJson(com.qt.sales.utils.ResultList)
     * @param resultList 结果集
     * @return string
     */
    public String getResultListToJson(ResultList resultList) {
        StringBuffer sb = new StringBuffer();
        if (resultList != null) {
            sb.append("{\"total\":").append(resultList.getTotal()).append(",\"rows\":").append(getObjToJson(resultList.getRows())).append("}");
        }
        return sb.toString();
    }

    /**
     * 
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月19日 下午5:35:17 .<br/>
     * 【参数】： .<br/> .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: yinghui zhang 修改描述：创建新新件 .<br/>
     * <p/>
     */
    private static void loadFields() {
        if (DATEFIELDARRAY == null) {
            String value = "createdate";
            DATEFIELDARRAY = value.split(",");
        }
    }
}
