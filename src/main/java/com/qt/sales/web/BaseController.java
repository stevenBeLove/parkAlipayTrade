package com.qt.sales.web;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.qt.sales.service.JsonUtils;
import com.qt.sales.utils.LogPay;
import com.qt.sales.utils.ResultList;

public class BaseController {

    protected static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    protected JsonUtils jsonUtils;

    /**
     * 把结果集数据返回前台(分页)
     * 
     * @param resultList
     *            封装了分页后结果
     * @throws Exception
     *             由异常拦截器截获处理
     */
    protected String resultToJson(ResultList resultList) throws Exception {
        return jsonUtils.getResultListToJson(resultList);
    }

    /**
     * 把Object转换成JSON格式返回前台数据
     * 
     * @param obj
     *            需要转换单个对象
     * @throws Exception
     *             由异常拦截器截获处理
     */
    protected String objectToJson(Object obj) throws Exception {
        StringBuffer sb = new StringBuffer("{\"data\":");
        sb.append(jsonUtils.getObjToJson(obj)).append(",\"success\":true}");
        return sb.toString();
    }

    /**
     * 对象转json格式
     * 
     * @param obj 对象
     * @return json
     * @throws Exception 异常
     */
    protected String objectPaseJson(Object obj) throws Exception {
        return jsonUtils.getObjToJson(obj);
    }

    /**
     * 向前台打印输出对象
     * 
     * @param obj obj
     * @param response response
     * @throws Exception 异常
     */
    public void outPrint(Object obj, HttpServletResponse response) throws Exception {
        PrintWriter out = getOutPrint(response);
        try {
            if (out != null) {
                out.print(obj);
            }
        } catch (Exception e) {
            LogPay.error("输出流关闭异常！");
            throw e;
        } finally {
            if (out != null) {
                out.flush();
                out.close();
                out = null;
            }
        }
    }

    /**
     * 获取response输出流
     * @param response response
     * @return 响应输出流
     * @throws Exception 异常
     */
    private PrintWriter getOutPrint(HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        return response.getWriter();
    }

}
