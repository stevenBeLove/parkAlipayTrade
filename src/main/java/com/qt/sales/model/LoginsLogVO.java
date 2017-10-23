/** 
 * 包名: package com.qt.sales.model; <br/> 
 * 添加时间: 2016年11月7日 下午2:04:29 <br/> 
 */
package com.qt.sales.model;

/**
 * 
 * <pre>
 * 【类型】: LoginsLogVO <br/> 
 * 【作用】: 登录日志实体类 <br/>  
 * 【时间】：2016年11月7日 下午2:04:35 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public class LoginsLogVO {
    /**
     * id
     */
    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 登录时间
     */
    private String loginDate;
    /**
     * 退出时间
     */
    private String outDate;
    /**
     * 状态 登录是否成功,0失败1成功
     */
    private String status;
    
    /**
     * 页面开始
     */
    private int    start;

    /**
     * 页面结束
     */
    private int    end;
    
    /**
     * SessionId
     */
    private String sessionId;
    
    
    /**
     * 登录信息
     */
    private String loginMessage;
    
    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return start .<br/>
     */
    public int getStart() {
        return start;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月7日 下午2:42:33 <br/>
     * 参数: @param  start 设置值.  <br/>
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return end .<br/>
     */
    public int getEnd() {
        return end;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月7日 下午2:42:33 <br/>
     * 参数: @param  end 设置值.  <br/>
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return id .<br/>
     */
    public String getId() {
        return id;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月7日 下午2:09:06 <br/>
     * 参数: @param id 设置值. <br/>
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return userName .<br/>
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月7日 下午2:09:06 <br/>
     * 参数: @param userName 设置值. <br/>
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return loginDate .<br/>
     */
    public String getLoginDate() {
        return loginDate;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月7日 下午2:09:06 <br/>
     * 参数: @param loginDate 设置值. <br/>
     */
    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return outDate .<br/>
     */
    public String getOutDate() {
        return outDate;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月7日 下午2:09:06 <br/>
     * 参数: @param outDate 设置值. <br/>
     */
    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return status .<br/>
     */
    public String getStatus() {
        return status;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月7日 下午2:09:06 <br/>
     * 参数: @param status 设置值. <br/>
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return sessionId .<br/>
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月24日 下午6:43:42 <br/>
     * 参数: @param  sessionId 设置值.  <br/>
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return loginMessage .<br/>
     */
    public String getLoginMessage() {
        return loginMessage;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月24日 下午6:46:31 <br/>
     * 参数: @param  loginMessage 设置值.  <br/>
     */
    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }
    
    
}
