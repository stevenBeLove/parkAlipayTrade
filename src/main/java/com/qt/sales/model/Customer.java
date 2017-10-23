package com.qt.sales.model;

/**
 * 
 * <pre>
 * 【类型】: Customer <br/> 
 * 【时间】：2016年11月1日 下午2:13:25 <br/> 
 * 【作者】：yinghui zhang <br/> 
 * </pre>
 */
public class Customer {
    /**
     * 客户ID
     */
    private String customerid;
    
    /**
     * 客户名
     */
    private String customerName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 分销商ID
     */
    private String agencyId;

    /**
     * 分销商名称
     */
    private String agencyName;

    /**
     * 注册日期
     */
    private String customerregdate;

    /**
     * 上级推荐人ID
     */
    private String parentCustomerid;

    /**
     * 上级推荐人手机号码
     */
    private String parentMobile;

    /**
     * 二级推荐人ID
     */
    private String twoCustomerid;

    /**
     * 二级推荐人手机号
     */
    private String twoMobile;

    /**
     * 顶级推荐人ID
     */
    private String topCustomerid;

    /**
     * 顶级推荐人号码
     */
    private String topMobile;
    
    /**
     * 终端编号
     */
    private String payTerminalId;

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return customerid .<br/>
     */
    public String getCustomerid() {
        return customerid;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 下午7:05:58 <br/>
     * 参数: @param  customerid 设置值.  <br/>
     */
    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return customerName .<br/>
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 下午7:05:58 <br/>
     * 参数: @param  customerName 设置值.  <br/>
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return mobile .<br/>
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 下午7:05:58 <br/>
     * 参数: @param  mobile 设置值.  <br/>
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return agencyId .<br/>
     */
    public String getAgencyId() {
        return agencyId;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 下午7:05:58 <br/>
     * 参数: @param  agencyId 设置值.  <br/>
     */
    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return agencyName .<br/>
     */
    public String getAgencyName() {
        return agencyName;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 下午7:05:58 <br/>
     * 参数: @param  agencyName 设置值.  <br/>
     */
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return customerregdate .<br/>
     */
    public String getCustomerregdate() {
        return customerregdate;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 下午7:05:58 <br/>
     * 参数: @param  customerregdate 设置值.  <br/>
     */
    public void setCustomerregdate(String customerregdate) {
        this.customerregdate = customerregdate;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return parentCustomerid .<br/>
     */
    public String getParentCustomerid() {
        return parentCustomerid;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 下午7:05:58 <br/>
     * 参数: @param  parentCustomerid 设置值.  <br/>
     */
    public void setParentCustomerid(String parentCustomerid) {
        this.parentCustomerid = parentCustomerid;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return parentMobile .<br/>
     */
    public String getParentMobile() {
        return parentMobile;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 下午7:05:58 <br/>
     * 参数: @param  parentMobile 设置值.  <br/>
     */
    public void setParentMobile(String parentMobile) {
        this.parentMobile = parentMobile;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return twoCustomerid .<br/>
     */
    public String getTwoCustomerid() {
        return twoCustomerid;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 下午7:05:58 <br/>
     * 参数: @param  twoCustomerid 设置值.  <br/>
     */
    public void setTwoCustomerid(String twoCustomerid) {
        this.twoCustomerid = twoCustomerid;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return twoMobile .<br/>
     */
    public String getTwoMobile() {
        return twoMobile;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 下午7:05:58 <br/>
     * 参数: @param  twoMobile 设置值.  <br/>
     */
    public void setTwoMobile(String twoMobile) {
        this.twoMobile = twoMobile;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return topCustomerid .<br/>
     */
    public String getTopCustomerid() {
        return topCustomerid;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 下午7:05:58 <br/>
     * 参数: @param  topCustomerid 设置值.  <br/>
     */
    public void setTopCustomerid(String topCustomerid) {
        this.topCustomerid = topCustomerid;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return topMobile .<br/>
     */
    public String getTopMobile() {
        return topMobile;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 下午7:05:58 <br/>
     * 参数: @param  topMobile 设置值.  <br/>
     */
    public void setTopMobile(String topMobile) {
        this.topMobile = topMobile;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return payTerminalId .<br/>
     */
    public String getPayTerminalId() {
        return payTerminalId;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月1日 下午7:05:58 <br/>
     * 参数: @param  payTerminalId 设置值.  <br/>
     */
    public void setPayTerminalId(String payTerminalId) {
        this.payTerminalId = payTerminalId;
    }

    
   
    
    
}