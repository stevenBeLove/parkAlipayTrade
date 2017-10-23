/** 
 * 包名: package com.qt.sales.model; <br/> 
 * 添加时间: 2016年10月24日 下午5:00:20 <br/> 
 */
package com.qt.sales.model;

import java.util.List;

import flexjson.JSON;

/** 
 * 类名: SelectFansAgencyModel <br/> 
 * 作用：TODO(简单一句话描述)<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2016年10月24日 下午5:00:20 <br/> 
 * 版本： JDK 1.6 sales 1.0
 */
public class SelectFansAgency {

    private String message;
    
    private List<FansAgency> value;
    
    

    public SelectFansAgency() {
    }

    public SelectFansAgency(String message, List<FansAgency> value) {
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
     * 创建时间：2016年10月24日 下午5:01:32 <br/>
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
    public List<FansAgency> getValue() {
        return value;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年10月24日 下午5:01:32 <br/>
     * 参数: @param  value 设置值.  <br/>
     */
    public void setValue(List<FansAgency> value) {
        this.value = value;
    }
    
    
    
    
    
}

