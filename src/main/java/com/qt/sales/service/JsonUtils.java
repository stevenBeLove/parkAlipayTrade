package com.qt.sales.service;

import com.qt.sales.utils.ResultList;


/**
 * 类说明
 *
 * @author zhangyinghui
 */
public interface JsonUtils {
    /**
     * 将结果集转换成JSON格式
     *
     * @param resultList
     * @return JSON格式字符串
     */
    public String getResultListToJson(ResultList resultList);

    /**
     * 获取对象转换为JSON格式的字符串
     *
     * @param obj 任意对象
     * @return JSON格式字符串
     */
    public String getObjToJson(Object obj);
}
