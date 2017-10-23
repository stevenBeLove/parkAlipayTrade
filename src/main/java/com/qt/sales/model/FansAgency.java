package com.qt.sales.model;


/**
 * 
 * <pre>
 * 【类型】: FansAgency <br/> 
 * 【作用】: TODO ADD FUNCTION. <br/>  
 * 【时间】：2016年10月21日 下午3:31:35 <br/> 
 * 【作者】：yinghui zhang <br/> 
 * </pre>
 */
public class FansAgency {
    /**
     * 分销商ID
     */
    private String agencyId;

    /**
     * 系统编号
     */
    private String systemid;
    
    /**
     * 来源系统名称
     */
    private String systemName;

    /**
     * 分销商名称
     */
    private String agencyName;

    /**
     * 结算人姓名
     */
    private String name;

    /**
     * 结算人手机号
     */
    private String mobile;

    /**
     * 开户银行
     */
    private String bankname;

    /**
     * 银行卡号
     */
    private String accountno;
    /**
     * 上级分销商ID
     */
    private String parentId;

    /**
     * 上级分销商名称
     */
    private String parentName;

    /**
     * 特殊分销商标识
     */
    private String isspecial;

    /**
     * 层级
     */
    private String layer;
    /**
     * 三级分销审批状态 00:审核通过 01：待审核 02：待配置参数 03：审核驳回
     */
    private String status;

    /**
     * 审核不通过原因
     */
    private String remark;
    
    /**
     * 用户Id
     */
    private String userid;
    
    /**
     * 用户姓名
     */
    private String username;

    /**
     * 创建日期
     */
    private String datetime;
    
    /**
     * 分佣参数是否设置
     */
    private String scale;
    
    /**
     * 法人信息
     */
    private String legalInfo;
    
    /**
     * 身份证号
     */
    private String idCardNum;
    
    



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
     * 创建时间：2016年11月3日 下午4:19:07 <br/>
     * 参数: @param  agencyId 设置值.  <br/>
     */
    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return systemid .<br/>
     */
    public String getSystemid() {
        return systemid;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月3日 下午4:19:07 <br/>
     * 参数: @param  systemid 设置值.  <br/>
     */
    public void setSystemid(String systemid) {
        this.systemid = systemid;
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
     * 创建时间：2016年11月3日 下午4:19:07 <br/>
     * 参数: @param  agencyName 设置值.  <br/>
     */
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return name .<br/>
     */
    public String getName() {
        return name;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月3日 下午4:19:07 <br/>
     * 参数: @param  name 设置值.  <br/>
     */
    public void setName(String name) {
        this.name = name;
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
     * 创建时间：2016年11月3日 下午4:19:07 <br/>
     * 参数: @param  mobile 设置值.  <br/>
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return bankname .<br/>
     */
    public String getBankname() {
        return bankname;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月3日 下午4:19:07 <br/>
     * 参数: @param  bankname 设置值.  <br/>
     */
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return accountno .<br/>
     */
    public String getAccountno() {
        return accountno;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月3日 下午4:19:07 <br/>
     * 参数: @param  accountno 设置值.  <br/>
     */
    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return parentId .<br/>
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月3日 下午4:19:07 <br/>
     * 参数: @param  parentId 设置值.  <br/>
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return parentName .<br/>
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月3日 下午4:19:07 <br/>
     * 参数: @param  parentName 设置值.  <br/>
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return isspecial .<br/>
     */
    public String getIsspecial() {
        return isspecial;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月3日 下午4:19:07 <br/>
     * 参数: @param  isspecial 设置值.  <br/>
     */
    public void setIsspecial(String isspecial) {
        this.isspecial = isspecial;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return layer .<br/>
     */
    public String getLayer() {
        return layer;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月3日 下午4:19:07 <br/>
     * 参数: @param  layer 设置值.  <br/>
     */
    public void setLayer(String layer) {
        this.layer = layer;
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
     * 创建时间：2016年11月3日 下午4:19:07 <br/>
     * 参数: @param  status 设置值.  <br/>
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return remark .<br/>
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月3日 下午4:19:07 <br/>
     * 参数: @param  remark 设置值.  <br/>
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
     * 创建时间：2016年10月25日 上午10:58:33 <br/>
     * 参数: @param  userid 设置值.  <br/>
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：zhangyinghui <br/>
     * 返回类型：@return datetime .<br/>
     */
    public String getDatetime() {
        return datetime;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年10月25日 上午10:58:33 <br/>
     * 参数: @param  datetime 设置值.  <br/>
     */
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：zhangyinghui <br/>
     * 返回类型：@return scale .<br/>
     */
    public String getScale() {
        return scale;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年10月25日 下午2:41:45 <br/>
     * 参数: @param  scale 设置值.  <br/>
     */
    public void setScale(String scale) {
        this.scale = scale;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：zhangyinghui <br/>
     * 返回类型：@return username .<br/>
     */
    public String getUsername() {
        return username;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年10月25日 下午4:07:27 <br/>
     * 参数: @param  username 设置值.  <br/>
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：zhangyinghui <br/>
     * 返回类型：@return legalInfo .<br/>
     */
    public String getLegalInfo() {
        return legalInfo;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年10月26日 上午10:01:08 <br/>
     * 参数: @param  legalInfo 设置值.  <br/>
     */
    public void setLegalInfo(String legalInfo) {
        this.legalInfo = legalInfo;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return idCardNum .<br/>
     */
    public String getIdCardNum() {
        return idCardNum;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月3日 下午4:18:24 <br/>
     * 参数: @param  idCardNum 设置值.  <br/>
     */
    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return systemName .<br/>
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月8日 下午2:11:04 <br/>
     * 参数: @param  systemName 设置值.  <br/>
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    
    
}