/** 
 * 包名: package com.qt.sales.model; <br/> 
 * 添加时间: 2016年11月2日 上午9:35:57 <br/> 
 */
package com.qt.sales.model;

import com.qt.sales.common.NumberFormat;

/**
 * 
 * <pre>
 * 【类型】: InstitutionsFenRunIssueVO <br/> 
 * 【作用】:机构分润实体类. <br/>  
 * 【时间】：2016年11月7日 上午11:27:08 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
public class InstitutionsFenRunIssueVO {
    
    /**
     * 分佣月份
     */
    private String localDate;

    /**
     * 机构名称
     */
    private String agencyName;

    /**
     * 机构ID
     */
    private String agencyId;

    /**
     * 当月分润
     */
    private String monthProfit;
    /**
     * 交易流水
     */
    private String localLogno;
    /**
     * 可分润机构编号
     */
    private String superAgencyId;
    /**
     * 可分润机构名称
     */
    private String superAgencyName;
    /**
     * 交易类型编码
     */
    private String businessType;
    /**
     * 交易类型名称
     */
    private String businessName;
    /**
     * 交易人编码
     */
    private String customerid;
    /**
     * 交易人姓名
     */
    private String customername;
    
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 交易金额
     */
    private String amount;
    /**
     * 交易费率
     */
    private String rate;
    
    /**
     * 开始交易日期
     */
    private String localBeginDate;
    /**
     * 结束交易日期
     */
    private String localEndDate;
    
    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return mobile .<br/>
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月15日 下午7:01:52 <br/>
     * 参数: @param  mobile 设置值.  <br/>
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return localBeginDate .<br/>
     */
    public String getLocalBeginDate() {
        return localBeginDate;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月15日 下午6:56:48 <br/>
     * 参数: @param  localBeginDate 设置值.  <br/>
     */
    public void setLocalBeginDate(String localBeginDate) {
        this.localBeginDate = localBeginDate;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return localEndDate .<br/>
     */
    public String getLocalEndDate() {
        return localEndDate;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月15日 下午6:56:48 <br/>
     * 参数: @param  localEndDate 设置值.  <br/>
     */
    public void setLocalEndDate(String localEndDate) {
        this.localEndDate = localEndDate;
    }

    /**
     * 页面开始
     */
    private int    start;

    /**
     * 页面结束
     */
    private int    end;
    
    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return localLogno .<br/>
     */
    public String getLocalLogno() {
        return localLogno;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月15日 下午6:48:36 <br/>
     * 参数: @param  localLogno 设置值.  <br/>
     */
    public void setLocalLogno(String localLogno) {
        this.localLogno = localLogno;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return superAgencyId .<br/>
     */
    public String getSuperAgencyId() {
        return superAgencyId;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月15日 下午6:48:36 <br/>
     * 参数: @param  superAgencyId 设置值.  <br/>
     */
    public void setSuperAgencyId(String superAgencyId) {
        this.superAgencyId = superAgencyId;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return superAgencyName .<br/>
     */
    public String getSuperAgencyName() {
        return superAgencyName;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月15日 下午6:48:36 <br/>
     * 参数: @param  superAgencyName 设置值.  <br/>
     */
    public void setSuperAgencyName(String superAgencyName) {
        this.superAgencyName = superAgencyName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return businessType .<br/>
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月15日 下午6:48:36 <br/>
     * 参数: @param  businessType 设置值.  <br/>
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return businessName .<br/>
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月15日 下午6:48:36 <br/>
     * 参数: @param  businessName 设置值.  <br/>
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return customerid .<br/>
     */
    public String getCustomerid() {
        return customerid;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月15日 下午6:48:36 <br/>
     * 参数: @param  customerid 设置值.  <br/>
     */
    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return customername .<br/>
     */
    public String getCustomername() {
        return customername;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月15日 下午6:48:36 <br/>
     * 参数: @param  customername 设置值.  <br/>
     */
    public void setCustomername(String customername) {
        this.customername = customername;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return amount .<br/>
     */
    public String getAmount() {
        return NumberFormat.parseNumberFormat(amount);
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月15日 下午6:48:36 <br/>
     * 参数: @param  amount 设置值.  <br/>
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return rate .<br/>
     */
    public String getRate() {
        return rate;
    }

    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月15日 下午6:48:36 <br/>
     * 参数: @param  rate 设置值.  <br/>
     */
    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     * 方法名： getStart.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：下午2:48:47.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public int getStart() {
        return start;
    }

    /**
     * 方法名： setStart.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param start 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：下午2:48:47.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 方法名： getEnd.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：下午2:48:47.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public int getEnd() {
        return end;
    }

    /**
     * 方法名： setEnd.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param end 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：下午2:48:47.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * 方法名： getLocalDate.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午9:43:40.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getLocalDate() {
        return localDate;
    }

    /**
     * 方法名： setLocalDate.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param localDate 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午9:43:40.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    /**
     * 方法名： getAgencyName.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午9:43:40.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getAgencyName() {
        return agencyName;
    }

    /**
     * 方法名： setAgencyName.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param agencyName 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午9:43:40.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    /**
     * 方法名： getAgencyId.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午9:43:40.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getAgencyId() {
        return agencyId;
    }

    /**
     * 方法名： setAgencyId.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param agencyId 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午9:43:40.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * 方法名： getMonthProfit.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午9:43:40.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getMonthProfit() {
        return NumberFormat.parseNumberFormat(monthProfit);
    }

    /**
     * 方法名： setMonthProfit.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param monthProfit 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午9:43:40.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setMonthProfit(String monthProfit) {
        this.monthProfit = monthProfit;
    }

}
