package com.qt.sales.model;

import com.qt.sales.common.NumberFormat;

/**
 * 
 * <pre>
 * 【类型】: PersonalCommissionVO <br/> 
 * 【作用】: 个人返佣实体类. <br/>  
 * 【时间】：2016年11月7日 上午11:03:10 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
public class PersonalCommissionVO {
    /**
     * 日期
     */
    private String localDate;
    
    /**
     * 开始日期
     */
    private String localBeginDate;
    
    /**
     * 结束日期
     */
    private String localEndDate;

    /**
     * 客户编号
     */
    private String customerId;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 当月佣金 ,单位：元
     */
    private String monthAmount;

    /**
     * 应发金额
     */
    private String fdAmount;

    /**
     * 手续费
     */
    private String fdRealFee;

    /**
     * 实发金额
     */
    private String sfAmount;

    /**
     * 发送形式
     */
    private String sendType;

    /**
     * 发送日期
     */
    private String fsOrigDate;

    /**
     * 状态
     */
    private String status;

    /**
     * 分销商ID
     */
    private String agencyId;

    /**
     * 分销商名称
     */
    private String agencyName;

    /**
     * 
     */
    private int    start;

    /**
     * 
     */
    private int    end;

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
     * 创建时间：2016年11月14日 下午4:44:39 <br/>
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
     * 创建时间：2016年11月14日 下午4:44:39 <br/>
     * 参数: @param  localEndDate 设置值.  <br/>
     */
    public void setLocalEndDate(String localEndDate) {
        this.localEndDate = localEndDate;
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
     * 创建时间：上午11:10:00.<br/>
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
     * 创建时间：上午11:10:00.<br/>
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
     * 创建时间：上午11:10:00.<br/>
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
     * 创建时间：上午11:10:00.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setEnd(int end) {
        this.end = end;
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
     * 创建时间：上午10:46:24.<br/>
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
     * 创建时间：上午10:46:24.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
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
     * 创建时间：上午10:46:24.<br/>
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
     * 创建时间：上午10:46:24.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    /**
     * 方法名： getFdAmount.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:34:49.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getFdAmount() {
        return NumberFormat.parseYuanFormat(fdAmount);
    }

    /**
     * 方法名： setFdAmount.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param fdAmount 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:34:49.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setFdAmount(String fdAmount) {
        this.fdAmount = fdAmount;
    }

    /**
     * 方法名： getFdRealFee.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:34:49.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getFdRealFee() {
        return NumberFormat.parseYuanFormat(fdRealFee);
    }

    /**
     * 方法名： setFdRealFee.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param fdRealFee 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:34:49.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setFdRealFee(String fdRealFee) {
        this.fdRealFee = fdRealFee;
    }

    /**
     * 方法名： getSfAmount.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:34:49.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getSfAmount() {
        return NumberFormat.parseYuanFormat(sfAmount);
    }

    /**
     * 方法名： setSfAmount.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param sfAmount 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:34:49.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setSfAmount(String sfAmount) {
        this.sfAmount = sfAmount;
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
     * 创建时间：上午10:33:43.<br/>
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
     * 创建时间：上午10:33:43.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    /**
     * 方法名： getCustomerId.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:33:43.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 方法名： setCustomerId.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param customerId 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:33:43.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * 方法名： getCustomerName.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:33:43.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 方法名： setCustomerName.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param customerName 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:33:43.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 方法名： getMobile.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:33:43.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 方法名： setMobile.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param mobile 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:33:43.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 方法名： getMonthAmount.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:33:43.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getMonthAmount() {
        return NumberFormat.parseNumberFormat(monthAmount);
    }

    /**
     * 方法名： setMonthAmount.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param monthAmount 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:33:43.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setMonthAmount(String monthAmount) {
        this.monthAmount = monthAmount;
    }

    /**
     * 方法名： getSendType.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:33:43.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getSendType() {
        return sendType;
    }

    /**
     * 方法名： setSendType.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param sendType 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:33:43.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    /**
     * 方法名： getFsOrigDate.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:33:43.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getFsOrigDate() {
        return fsOrigDate;
    }

    /**
     * 方法名： setFsOrigDate.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param fsOrigDate 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:33:43.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setFsOrigDate(String fsOrigDate) {
        this.fsOrigDate = fsOrigDate;
    }

    /**
     * 方法名： getStatus.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:33:43.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public String getStatus() {
        return status;
    }

    /**
     * 方法名： setStatus.<br/>
     * 适用条件:TODO(简单描述).<br/>
     * 执行流程:TODO(简单描述).<br/>
     * 注意事项:TODO(简单描述).<br/>
     * 方法作用:TODO(简单描述).<br/>
     *
     * 参数： @param status 设置值
     *
     * 创建者：Fuyu.<br/>
     * 创建日期：2016年11月2日.<br/>
     * 创建时间：上午10:33:43.<br/>
     * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
     */
    public void setStatus(String status) {
        this.status = status;
    }

}