/** 
 * 包名: package com.qt.sales.model; <br/> 
 * 添加时间: 2016年10月20日 下午8:00:58 <br/> 
 */
package com.qt.sales.model;

import java.util.List;

import flexjson.JSON;

/** 
 * 类名: SelectValue <br/> 
 * 作用：TODO(简单一句话描述)<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2016年10月20日 下午8:00:58 <br/> 
 * 版本： JDK 1.6 sales 1.0
 */
public class SelectModel {

    private String message;
    
    private List<Qt1tblAgency> value;

    
    
    
    public SelectModel() {
        // TODO Auto-generated constructor stub
    }

    public SelectModel(String message, List<Qt1tblAgency> value) {
        this.message = message;
        this.value = value;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：zhangyinghui <br/>
     * 返回类型：@return message .<br/>
     */
    public String getMessage() {
        return message;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年10月24日 上午11:28:26 <br/>
     * 参数: @param  message 设置值.  <br/>
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：zhangyinghui <br/>
     * 返回类型：@return value .<br/>
     */
    @JSON(include=true)
    public List<Qt1tblAgency> getValue() {
        return value;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年10月24日 上午11:28:26 <br/>
     * 参数: @param  value 设置值.  <br/>
     */
    public void setValue(List<Qt1tblAgency> value) {
        this.value = value;
    }

    
}

