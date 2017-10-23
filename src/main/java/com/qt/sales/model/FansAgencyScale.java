package com.qt.sales.model;

import java.text.ParseException;

import com.qt.sales.utils.DateUtil;
import com.qt.sales.utils.LogPay;

/**
 * 
 * <pre>
 * 【类型】: 分销商经营模式分润费率<br/> 
 * 【作用】: TODO ADD FUNCTION. <br/>  
 * 【时间】：2016年10月26日 下午12:15:23 <br/> 
 * 【作者】：yinghui zhang <br/> 
 * </pre>
 */
public class FansAgencyScale {
    
    /**
     * 主键Id
     */
    private String id;
    /**
     * 机构Id
     */
    private String agencyId;
    /**
     * 我的成本
     */
    private Long mycost;
    /**
     * 上三级分佣 (顶级)
     */
    private Long finalRate;
    /**
     * 上二级分佣(二级)
     */
    private Long secondRate;
    /**
     * 上一级分佣(父级)
     */
    private Long nextRate;
    /**
     * 生效日期
     */
    private String begindate;
    /**
     * 结束日期
     */
    private String enddate;
    /**
     * 交易类型
     */
    private String businessType;
    
    /**
     * 产品归类信息名称
     */
    private String businessName;
    
    /**
     * 创建人Id
     */
    private String userid;
    
    /**
     * 创建人名称
     */
    private String userNames;
    
    /**
     * 创建时间
     */
    private String datetime;
    
    
    /**
     * 页面添加
     */
    private boolean pageAdd;
    
    /**
     * 是否有效
     */
    private boolean status;
    
    /**
     * 审核状态
     */
    private String auditStatus;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId == null ? null : agencyId.trim();
    }

    public Long getMycost() {
        return mycost;
    }

    public void setMycost(Long mycost) {
        this.mycost = mycost;
    }

    public Long getFinalRate() {
        return finalRate;
    }

    public void setFinalRate(Long finalRate) {
        this.finalRate = finalRate;
    }

    public Long getSecondRate() {
        return secondRate;
    }

    public void setSecondRate(Long secondRate) {
        this.secondRate = secondRate;
    }

    public Long getNextRate() {
        return nextRate;
    }

    public void setNextRate(Long nextRate) {
        this.nextRate = nextRate;
    }

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate == null ? null : begindate.trim();
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate == null ? null : enddate.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：zhangyinghui <br/>
     * 返回类型：@return userid .<br/>
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年10月26日 下午1:33:29 <br/>
     * 参数: @param  userid 设置值.  <br/>
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return datetime .<br/>
     */
    public String getDatetime() {
        return datetime;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年10月28日 上午9:51:53 <br/>
     * 参数: @param  datetime 设置值.  <br/>
     */
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
    
    
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return businessName .<br/>
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年10月28日 下午4:33:08 <br/>
     * 参数: @param  businessName 设置值.  <br/>
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    


    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return userNames .<br/>
     */
    public String getUserNames() {
        return userNames;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年10月28日 下午4:56:12 <br/>
     * 参数: @param  userNames 设置值.  <br/>
     */
    public void setUserNames(String userNames) {
        this.userNames = userNames;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return pageAdd .<br/>
     */
    public boolean isPageAdd() {
        return pageAdd;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年10月28日 下午5:55:25 <br/>
     * 参数: @param  pageAdd 设置值.  <br/>
     */
    public void setPageAdd(boolean pageAdd) {
        this.pageAdd = pageAdd;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return status .<br/>
     */
    public boolean isStatus() {
        try {
            return DateUtil.compareBefore(this.getBegindate());
        } catch (ParseException e) {
            e.printStackTrace();
            LogPay.error(e.getMessage(), e);
            return false;
        }
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月10日 下午2:14:12 <br/>
     * 参数: @param  status 设置值.  <br/>
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return auditStatus .<br/>
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月15日 上午10:53:44 <br/>
     * 参数: @param  auditStatus 设置值.  <br/>
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    
    
}