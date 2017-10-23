package com.qt.sales.model;

import com.qt.sales.common.NumberFormat;

/**
 * 
 * <pre>
 * 【类型】: FansCustomerJnls <br/> 
 * 【作用】: 交易记录实体类. <br/>  
 * 【时间】：2016年11月7日 上午10:11:18 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public class FansCustomerJnls {
    /**
     * 分润id
     */
    private String frid;
    /**
     * 服务编码
     */
    private String servcode;
    /**
     * 交易日期
     */
    private String localdate;
    
    /**
     * 开始交易日期
     */
    private String localBeginDate;
    /**
     * 结束交易日期
     */
    private String localEndDate;
    /**
     * 交易时间
     */
    private String localtime;
    /**
     * 交易号
     */
    private String locallogno;
    /**
     * 交易终端号
     */
    private String termid;
    /**
     * 用户PSAM卡号
     */
    private String psamid;
    /**
     * 商户类型
     */
    private String merchantid;
    /**
     * 产品ID
     */
    private String productid;
    /**
     * 产品类型编码
     */
    private String businessType;
    /**
     * 产品类型编码
     */
    private String businessName;
    /**
     * 客户ID
     */
    private String customerid;
    /**
     * 客户
     */
    private String customerName;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 代理商ID
     */
    private String agencyId;
    /**
     * 代理商名称
     */
    private String agencyName;
    /**
     * 交易金额
     */
    private String amount;
    /**
     * 上级编号
     */
    private String parentCustomerid;
    /**
     * 上级名称
     */
    private String parentcustomername;
    /**
     * 上级手机号
     */
    private String parentuserid;
    /**
     * 上级分佣比例，万分之几
     */
    private String parentRate;
    /**
     * 上级分润费用
     */
    private String parentProfit;
    /**
     * 二级编号
     */
    private String twoCustomerid;
    /**
     * 二级名称
     */
    private String twocustomername;
    /**
     * 二级手机号
     */
    private String twouserid;
    /**
     * 二级分佣比例，万分之几
     */
    private String twoRate;
    /**
     * 二级分润费用
     */
    private String twoProfit;
    /**
     * 顶级编号
     */
    private String topCustomerid;
    /**
     * 顶级名称
     */
    private String topcustomername;
    /**
     * 顶级手机号
     */
    private String topuserid;
    /**
     * 顶级分佣比例，万分之几
     */
    private String topRate;
    /**
     * 顶级分润费用
     */
    private String topProfit;
    /**
     * 交易状态00 成功 TK退款 01失败
     */
    private String status;
    /**
     * 计算日期
     */
    private String caldate;
    /**
     * 计算时间
     */
    private String caltime;
    /**
     * 是否结算（位图）000: 初始状态111: 全成功222:失败333:入账处理中444:不可结算。211:上级分润入账失败，以此类推
     */
    private String isClearing;
    /**
     * 页面起始页参数
     */
    private int    start;
    /**
     * 页面终止页参数
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
     * 创建时间：2016年11月14日 下午4:33:28 <br/>
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
     * 创建时间：2016年11月14日 下午4:31:24 <br/>
     * 参数: @param  localEndDate 设置值.  <br/>
     */
    public void setLocalEndDate(String localEndDate) {
        this.localEndDate = localEndDate;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：fuyu <br/>
     * 返回类型：@return customerName .<br/>
     */
    public String getCustomerName() {
        return customerName;
    }
    /**
     * 创建人：fuyu <br/>
     * 创建时间：2016年11月11日 上午10:09:15 <br/>
     * 参数: @param  customerName 设置值.  <br/>
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
     * 创建时间：2016年11月11日 上午9:39:20 <br/>
     * 参数: @param  businessName 设置值.  <br/>
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return frid .<br/>
     */
    public String getFrid() {
        return frid;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  frid 设置值.  <br/>
     */
    public void setFrid(String frid) {
        this.frid = frid;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return servcode .<br/>
     */
    public String getServcode() {
        return servcode;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  servcode 设置值.  <br/>
     */
    public void setServcode(String servcode) {
        this.servcode = servcode;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return localdate .<br/>
     */
    public String getLocaldate() {
        return localdate;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  localdate 设置值.  <br/>
     */
    public void setLocaldate(String localdate) {
        this.localdate = localdate;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return localtime .<br/>
     */
    public String getLocaltime() {
        return localtime;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  localtime 设置值.  <br/>
     */
    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return locallogno .<br/>
     */
    public String getLocallogno() {
        return locallogno;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  locallogno 设置值.  <br/>
     */
    public void setLocallogno(String locallogno) {
        this.locallogno = locallogno;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return termid .<br/>
     */
    public String getTermid() {
        return termid;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  termid 设置值.  <br/>
     */
    public void setTermid(String termid) {
        this.termid = termid;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return psamid .<br/>
     */
    public String getPsamid() {
        return psamid;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  psamid 设置值.  <br/>
     */
    public void setPsamid(String psamid) {
        this.psamid = psamid;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return merchantid .<br/>
     */
    public String getMerchantid() {
        return merchantid;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  merchantid 设置值.  <br/>
     */
    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return productid .<br/>
     */
    public String getProductid() {
        return productid;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  productid 设置值.  <br/>
     */
    public void setProductid(String productid) {
        this.productid = productid;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return businessType .<br/>
     */
    public String getBusinessType() {
        return businessType;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  businessType 设置值.  <br/>
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
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
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  customerid 设置值.  <br/>
     */
    public void setCustomerid(String customerid) {
        this.customerid = customerid;
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
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
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
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
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
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  agencyName 设置值.  <br/>
     */
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return amount .<br/>
     */
    public String getAmount() {
        return NumberFormat.parseNumberFormat(amount);
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  amount 设置值.  <br/>
     */
    public void setAmount(String amount) {
        this.amount = amount;
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
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  parentCustomerid 设置值.  <br/>
     */
    public void setParentCustomerid(String parentCustomerid) {
        this.parentCustomerid = parentCustomerid;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return parentcustomername .<br/>
     */
    public String getParentcustomername() {
        return parentcustomername;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  parentcustomername 设置值.  <br/>
     */
    public void setParentcustomername(String parentcustomername) {
        this.parentcustomername = parentcustomername;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return parentuserid .<br/>
     */
    public String getParentuserid() {
        return parentuserid;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  parentuserid 设置值.  <br/>
     */
    public void setParentuserid(String parentuserid) {
        this.parentuserid = parentuserid;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return parentRate .<br/>
     */
    public String getParentRate() {
        return parentRate;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  parentRate 设置值.  <br/>
     */
    public void setParentRate(String parentRate) {
        this.parentRate = parentRate;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return parentProfit .<br/>
     */
    public String getParentProfit() {
        return NumberFormat.parseNumberFormat(parentProfit);
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  parentProfit 设置值.  <br/>
     */
    public void setParentProfit(String parentProfit) {
        this.parentProfit = parentProfit;
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
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  twoCustomerid 设置值.  <br/>
     */
    public void setTwoCustomerid(String twoCustomerid) {
        this.twoCustomerid = twoCustomerid;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return twocustomername .<br/>
     */
    public String getTwocustomername() {
        return twocustomername;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  twocustomername 设置值.  <br/>
     */
    public void setTwocustomername(String twocustomername) {
        this.twocustomername = twocustomername;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return twouserid .<br/>
     */
    public String getTwouserid() {
        return twouserid;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  twouserid 设置值.  <br/>
     */
    public void setTwouserid(String twouserid) {
        this.twouserid = twouserid;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return twoRate .<br/>
     */
    public String getTwoRate() {
        return twoRate;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  twoRate 设置值.  <br/>
     */
    public void setTwoRate(String twoRate) {
        this.twoRate = twoRate;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return twoProfit .<br/>
     */
    public String getTwoProfit() {
        return NumberFormat.parseNumberFormat(twoProfit);
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  twoProfit 设置值.  <br/>
     */
    public void setTwoProfit(String twoProfit) {
        this.twoProfit = twoProfit;
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
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  topCustomerid 设置值.  <br/>
     */
    public void setTopCustomerid(String topCustomerid) {
        this.topCustomerid = topCustomerid;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return topcustomername .<br/>
     */
    public String getTopcustomername() {
        return topcustomername;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  topcustomername 设置值.  <br/>
     */
    public void setTopcustomername(String topcustomername) {
        this.topcustomername = topcustomername;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return topuserid .<br/>
     */
    public String getTopuserid() {
        return topuserid;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  topuserid 设置值.  <br/>
     */
    public void setTopuserid(String topuserid) {
        this.topuserid = topuserid;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return topRate .<br/>
     */
    public String getTopRate() {
        return topRate;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  topRate 设置值.  <br/>
     */
    public void setTopRate(String topRate) {
        this.topRate = topRate;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return topProfit .<br/>
     */
    public String getTopProfit() {
        return NumberFormat.parseNumberFormat(topProfit);
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  topProfit 设置值.  <br/>
     */
    public void setTopProfit(String topProfit) {
        this.topProfit = topProfit;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return status .<br/>
     */
    public String getStatus() {
        return status;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  status 设置值.  <br/>
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return caldate .<br/>
     */
    public String getCaldate() {
        return caldate;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  caldate 设置值.  <br/>
     */
    public void setCaldate(String caldate) {
        this.caldate = caldate;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return caltime .<br/>
     */
    public String getCaltime() {
        return caltime;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  caltime 设置值.  <br/>
     */
    public void setCaltime(String caltime) {
        this.caltime = caltime;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return isClearing .<br/>
     */
    public String getIsClearing() {
        return isClearing;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  isClearing 设置值.  <br/>
     */
    public void setIsClearing(String isClearing) {
        this.isClearing = isClearing;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return start .<br/>
     */
    public int getStart() {
        return start;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  start 设置值.  <br/>
     */
    public void setStart(int start) {
        this.start = start;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return end .<br/>
     */
    public int getEnd() {
        return end;
    }
    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午7:28:27 <br/>
     * 参数: @param  end 设置值.  <br/>
     */
    public void setEnd(int end) {
        this.end = end;
    }

}