/** 
 * 包名: package com.qt.sales.model; <br/> 
 * 添加时间: 2016年11月3日 上午9:48:40 <br/> 
 */
package com.qt.sales.model;
/**
 * 
 * 类名: TerminalManagementVO <br/> 
 * 作用：TODO(简单一句话描述)<br/> 
 * 方法：TODO(简单描述方法)<br/> 
 * 创建者: Fuyu. <br/> 
 * 添加时间: 2016年11月3日 上午9:48:51 <br/> 
 * 版本： 
 * @since JDK 1.6 SalesPlatform 1.0
 */
public class TerminalManagementVO {

    /**
     * 机构编号
     */
    private String agencyId;
    
    /**
     * 机构名称
     */
    private String agencyName;
    
    /**
     * 终端编码
     */
    private String termId;
    
    /**
     * 终端产权
     */
    private String termEquity;
    
    /**
     * 终端状态
     */
    private String termState;
    
    /**
     * 是否是临时客户,0:不是 1:是
     */
    private String tempUser;
    
    /**
     * 客户编号
     */
    private String customerId;
    
    /**
     * 客户姓名
     */
    private String customerName;
    
    /**
     * 客户手机号
     */
    private String mobile;
    
    /**
     * 省
     */
    private String province;
    
    /**
     * 市
     */
    private String city;
    
    /**
     * 区
     */
    private String county;
    
    /**
     * 详细地址
     */
    private String address;
    
    /**
     * 是否绑定PSAM卡,0：未绑定 1：绑定
     */
    private String havePsam;
    
    /**
     * PSAM卡号
     */
    private String psamId;
    
    /**
     * 终端下发时间
     */
    private String giveDate;
    
    /**
     * 终端是否激活,0:尚未激活 1:已经激活
     */
    private String termActivation;
    
    /**
     * 激活时间
     */
    private String openDate;
    /**
     * 创建人
     */
    private String createId;
    /**
     * 创建时间
     */
    private String createdt;
    
    /**
     * 解绑日期
     */
    private String unbuildDate;
    /**
     * 订货人姓名
     */
    private String  orderName;
    /**
     * 订货人手机号
     */
    private String orderMobile;
    /**
     * 解绑人
     */
    private String unbuildId;
    
    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return unbuildId .<br/>
     */
    public String getUnbuildId() {
        return unbuildId;
    }
    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月14日 上午10:39:17 <br/>
     * 参数: @param  unbuildId 设置值.  <br/>
     */
    public void setUnbuildId(String unbuildId) {
        this.unbuildId = unbuildId;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return orderName .<br/>
     */
    public String getOrderName() {
        return orderName;
    }
    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月7日 下午4:38:32 <br/>
     * 参数: @param  orderName 设置值.  <br/>
     */
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return orderMobile .<br/>
     */
    public String getOrderMobile() {
        return orderMobile;
    }
    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月7日 下午4:38:32 <br/>
     * 参数: @param  orderMobile 设置值.  <br/>
     */
    public void setOrderMobile(String orderMobile) {
        this.orderMobile = orderMobile;
    }
    public String getTempUser() {
        return tempUser;
    }
    public void setTempUser(String tempUser) {
        this.tempUser = tempUser;
    }
    public String getTermState() {
        return termState;
    }
    public void setTermState(String termState) {
        this.termState = termState;
    }
    /**
     * 页面开始
     */
    private int    start;

    /**
     * 页面结束
     */
    private int    end;
    
    public String getTermEquity() {
        return termEquity;
    }
    public void setTermEquity(String termEquity) {
        this.termEquity = termEquity;
    }
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }
    public String getOpenDate() {
        return openDate;
    }
    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }
    public String getAgencyId() {
        return agencyId;
    }
    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }
    public String getAgencyName() {
        return agencyName;
    }
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }
    public String getTermId() {
        return termId;
    }
    public void setTermId(String termId) {
        this.termId = termId;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCounty() {
        return county;
    }
    public void setCounty(String county) {
        this.county = county;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getGiveDate() {
        return giveDate;
    }
    public void setGiveDate(String giveDate) {
        this.giveDate = giveDate;
    }
    public String getTermActivation() {
        return termActivation;
    }
    public void setTermActivation(String termActivation) {
        this.termActivation = termActivation;
    }
    public String getCreateId() {
        return createId;
    }
    public void setCreateId(String createId) {
        this.createId = createId;
    }
    public String getCreatedt() {
        return createdt;
    }
    public void setCreatedt(String createdt) {
        this.createdt = createdt;
    }
    public String getHavePsam() {
        return havePsam;
    }
    public void setHavePsam(String havePsam) {
        this.havePsam = havePsam;
    }
    public String getPsamId() {
        return psamId;
    }
    public void setPsamId(String psamId) {
        this.psamId = psamId;
    }
    public String getUnbuildDate() {
        return unbuildDate;
    }
    public void setUnbuildDate(String unbuildDate) {
        this.unbuildDate = unbuildDate;
    }
}

