package com.qt.sales.model;

/**
 * 
 * <pre>
 * 【类型】: Announcement <br/> 
 * 【作用】: 公告实体类. <br/>  
 * 【时间】：2016年11月7日 上午9:51:59 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
public class Announcement {
    /**
     * id
     */
    private String id;
    /**
     * 标题
     */
    private String title;
    /*
     * 截取标题
     */
    private String titleSub;
    /**
     * 内容
     */
    private String noticeContent;
    /**
     * 截取内容
     */
    private String noticeContentSub;
    /**
     * 生效时间
     */
    private String effectTime;
    /**
     * 失效时间
     */
    private String disabledTime;
    /**
     * APP用户
     */
    private String appuser;
    /**
     * 状态
     */
    private String status;
    /**
     * 创建人
     */
    private String createid;
    /**
     * 创建日期
     */
    private String createdt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public String getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(String effectTime) {
        this.effectTime = effectTime == null ? null : effectTime.trim();
    }

    public String getDisabledTime() {
        return disabledTime;
    }

    public void setDisabledTime(String disabledTime) {
        this.disabledTime = disabledTime == null ? null : disabledTime.trim();
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser == null ? null : appuser.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreateid() {
        return createid;
    }

    public void setCreateid(String createid) {
        this.createid = createid == null ? null : createid.trim();
    }

    public String getCreatedt() {
        return createdt;
    }

    public void setCreatedt(String createdt) {
        this.createdt = createdt == null ? null : createdt.trim();
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return titleSub .<br/>
     */
    public String getTitleSub() {
        return titleSub;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月15日 下午6:07:28 <br/>
     * 参数: @param  titleSub 设置值.  <br/>
     */
    public void setTitleSub(String titleSub) {
        this.titleSub = titleSub;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return noticeContentSub .<br/>
     */
    public String getNoticeContentSub() {
        return noticeContentSub;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月15日 下午6:07:28 <br/>
     * 参数: @param  noticeContentSub 设置值.  <br/>
     */
    public void setNoticeContentSub(String noticeContentSub) {
        this.noticeContentSub = noticeContentSub;
    }

}