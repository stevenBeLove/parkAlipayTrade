package com.qt.sales.model;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * <pre>
 * 【类型】: AnnouncementExample <br/> 
 * 【作用】: 系统公告 <br/>  
 * 【时间】：2016年11月7日 上午9:54:49 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
public class AnnouncementExample {
    /**
     * 封装排序方法
     */
    protected String orderByClause;
    /**
     * 封装查询唯一值方法
     */
    protected boolean distinct;
    /**
     * 封装List集合方法
     */
    protected List<Criteria> oredCriteria;
    /**
     * 封装页面起始页
     */
    private int start;
    /**
     * 封装页面终止页
     */
    private int end;
    
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
	 * 创建日期：2016年10月27日.<br/>
	 * 创建时间：下午4:52:29.<br/>
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
	 * 创建日期：2016年10月27日.<br/>
	 * 创建时间：下午4:52:29.<br/>
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
	 * 创建日期：2016年10月27日.<br/>
	 * 创建时间：下午4:52:29.<br/>
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
	 * 创建日期：2016年10月27日.<br/>
	 * 创建时间：下午4:52:29.<br/>
	 * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
	 */
	public void setEnd(int end) {
		this.end = end;
	}

	/** 
	 * 方法名： setOredCriteria.<br/>
	 * 适用条件:TODO(简单描述).<br/> 
	 * 执行流程:TODO(简单描述).<br/> 
	 * 注意事项:TODO(简单描述).<br/>
	 * 方法作用:TODO(简单描述).<br/>
	 *
	 * 参数： @param oredCriteria 设置值
	 *
	 * 创建者：Fuyu.<br/>
	 * 创建日期：2016年10月27日.<br/>
	 * 创建时间：下午4:52:29.<br/>
	 * 其它内容： JDK 1.6 SalesPlatform 1.0.<br/>
	 */
	public void setOredCriteria(List<Criteria> oredCriteria) {
		this.oredCriteria = oredCriteria;
	}

	public AnnouncementExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIsNull() {
            addCriterion("NOTICE_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIsNotNull() {
            addCriterion("NOTICE_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeContentEqualTo(String value) {
            addCriterion("NOTICE_CONTENT =", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotEqualTo(String value) {
            addCriterion("NOTICE_CONTENT <>", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentGreaterThan(String value) {
            addCriterion("NOTICE_CONTENT >", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentGreaterThanOrEqualTo(String value) {
            addCriterion("NOTICE_CONTENT >=", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLessThan(String value) {
            addCriterion("NOTICE_CONTENT <", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLessThanOrEqualTo(String value) {
            addCriterion("NOTICE_CONTENT <=", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLike(String value) {
            addCriterion("NOTICE_CONTENT like", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotLike(String value) {
            addCriterion("NOTICE_CONTENT not like", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIn(List<String> values) {
            addCriterion("NOTICE_CONTENT in", values, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotIn(List<String> values) {
            addCriterion("NOTICE_CONTENT not in", values, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentBetween(String value1, String value2) {
            addCriterion("NOTICE_CONTENT between", value1, value2, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotBetween(String value1, String value2) {
            addCriterion("NOTICE_CONTENT not between", value1, value2, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andEffectTimeIsNull() {
            addCriterion("EFFECT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEffectTimeIsNotNull() {
            addCriterion("EFFECT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEffectTimeEqualTo(String value) {
            addCriterion("EFFECT_TIME =", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeNotEqualTo(String value) {
            addCriterion("EFFECT_TIME <>", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeGreaterThan(String value) {
            addCriterion("EFFECT_TIME >", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeGreaterThanOrEqualTo(String value) {
            addCriterion("EFFECT_TIME >=", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeLessThan(String value) {
            addCriterion("EFFECT_TIME <", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeLessThanOrEqualTo(String value) {
            addCriterion("EFFECT_TIME <=", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeLike(String value) {
            addCriterion("EFFECT_TIME like", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeNotLike(String value) {
            addCriterion("EFFECT_TIME not like", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeIn(List<String> values) {
            addCriterion("EFFECT_TIME in", values, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeNotIn(List<String> values) {
            addCriterion("EFFECT_TIME not in", values, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeBetween(String value1, String value2) {
            addCriterion("EFFECT_TIME between", value1, value2, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeNotBetween(String value1, String value2) {
            addCriterion("EFFECT_TIME not between", value1, value2, "effectTime");
            return (Criteria) this;
        }

        public Criteria andDisabledTimeIsNull() {
            addCriterion("DISABLED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDisabledTimeIsNotNull() {
            addCriterion("DISABLED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDisabledTimeEqualTo(String value) {
            addCriterion("DISABLED_TIME =", value, "disabledTime");
            return (Criteria) this;
        }

        public Criteria andDisabledTimeNotEqualTo(String value) {
            addCriterion("DISABLED_TIME <>", value, "disabledTime");
            return (Criteria) this;
        }

        public Criteria andDisabledTimeGreaterThan(String value) {
            addCriterion("DISABLED_TIME >", value, "disabledTime");
            return (Criteria) this;
        }

        public Criteria andDisabledTimeGreaterThanOrEqualTo(String value) {
            addCriterion("DISABLED_TIME >=", value, "disabledTime");
            return (Criteria) this;
        }

        public Criteria andDisabledTimeLessThan(String value) {
            addCriterion("DISABLED_TIME <", value, "disabledTime");
            return (Criteria) this;
        }

        public Criteria andDisabledTimeLessThanOrEqualTo(String value) {
            addCriterion("DISABLED_TIME <=", value, "disabledTime");
            return (Criteria) this;
        }

        public Criteria andDisabledTimeLike(String value) {
            addCriterion("DISABLED_TIME like", value, "disabledTime");
            return (Criteria) this;
        }

        public Criteria andDisabledTimeNotLike(String value) {
            addCriterion("DISABLED_TIME not like", value, "disabledTime");
            return (Criteria) this;
        }

        public Criteria andDisabledTimeIn(List<String> values) {
            addCriterion("DISABLED_TIME in", values, "disabledTime");
            return (Criteria) this;
        }

        public Criteria andDisabledTimeNotIn(List<String> values) {
            addCriterion("DISABLED_TIME not in", values, "disabledTime");
            return (Criteria) this;
        }

        public Criteria andDisabledTimeBetween(String value1, String value2) {
            addCriterion("DISABLED_TIME between", value1, value2, "disabledTime");
            return (Criteria) this;
        }

        public Criteria andDisabledTimeNotBetween(String value1, String value2) {
            addCriterion("DISABLED_TIME not between", value1, value2, "disabledTime");
            return (Criteria) this;
        }

        public Criteria andAppuserIsNull() {
            addCriterion("APPUSER is null");
            return (Criteria) this;
        }

        public Criteria andAppuserIsNotNull() {
            addCriterion("APPUSER is not null");
            return (Criteria) this;
        }

        public Criteria andAppuserEqualTo(String value) {
            addCriterion("APPUSER =", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserNotEqualTo(String value) {
            addCriterion("APPUSER <>", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserGreaterThan(String value) {
            addCriterion("APPUSER >", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserGreaterThanOrEqualTo(String value) {
            addCriterion("APPUSER >=", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserLessThan(String value) {
            addCriterion("APPUSER <", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserLessThanOrEqualTo(String value) {
            addCriterion("APPUSER <=", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserLike(String value) {
            addCriterion("APPUSER like", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserNotLike(String value) {
            addCriterion("APPUSER not like", value, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserIn(List<String> values) {
            addCriterion("APPUSER in", values, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserNotIn(List<String> values) {
            addCriterion("APPUSER not in", values, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserBetween(String value1, String value2) {
            addCriterion("APPUSER between", value1, value2, "appuser");
            return (Criteria) this;
        }

        public Criteria andAppuserNotBetween(String value1, String value2) {
            addCriterion("APPUSER not between", value1, value2, "appuser");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateidIsNull() {
            addCriterion("CREATEID is null");
            return (Criteria) this;
        }

        public Criteria andCreateidIsNotNull() {
            addCriterion("CREATEID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateidEqualTo(String value) {
            addCriterion("CREATEID =", value, "createid");
            return (Criteria) this;
        }

        public Criteria andCreateidNotEqualTo(String value) {
            addCriterion("CREATEID <>", value, "createid");
            return (Criteria) this;
        }

        public Criteria andCreateidGreaterThan(String value) {
            addCriterion("CREATEID >", value, "createid");
            return (Criteria) this;
        }

        public Criteria andCreateidGreaterThanOrEqualTo(String value) {
            addCriterion("CREATEID >=", value, "createid");
            return (Criteria) this;
        }

        public Criteria andCreateidLessThan(String value) {
            addCriterion("CREATEID <", value, "createid");
            return (Criteria) this;
        }

        public Criteria andCreateidLessThanOrEqualTo(String value) {
            addCriterion("CREATEID <=", value, "createid");
            return (Criteria) this;
        }

        public Criteria andCreateidLike(String value) {
            addCriterion("CREATEID like", value, "createid");
            return (Criteria) this;
        }

        public Criteria andCreateidNotLike(String value) {
            addCriterion("CREATEID not like", value, "createid");
            return (Criteria) this;
        }

        public Criteria andCreateidIn(List<String> values) {
            addCriterion("CREATEID in", values, "createid");
            return (Criteria) this;
        }

        public Criteria andCreateidNotIn(List<String> values) {
            addCriterion("CREATEID not in", values, "createid");
            return (Criteria) this;
        }

        public Criteria andCreateidBetween(String value1, String value2) {
            addCriterion("CREATEID between", value1, value2, "createid");
            return (Criteria) this;
        }

        public Criteria andCreateidNotBetween(String value1, String value2) {
            addCriterion("CREATEID not between", value1, value2, "createid");
            return (Criteria) this;
        }

        public Criteria andCreatedtIsNull() {
            addCriterion("CREATEDT is null");
            return (Criteria) this;
        }

        public Criteria andCreatedtIsNotNull() {
            addCriterion("CREATEDT is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedtEqualTo(String value) {
            addCriterion("CREATEDT =", value, "createdt");
            return (Criteria) this;
        }

        public Criteria andCreatedtNotEqualTo(String value) {
            addCriterion("CREATEDT <>", value, "createdt");
            return (Criteria) this;
        }

        public Criteria andCreatedtGreaterThan(String value) {
            addCriterion("CREATEDT >", value, "createdt");
            return (Criteria) this;
        }

        public Criteria andCreatedtGreaterThanOrEqualTo(String value) {
            addCriterion("CREATEDT >=", value, "createdt");
            return (Criteria) this;
        }

        public Criteria andCreatedtLessThan(String value) {
            addCriterion("CREATEDT <", value, "createdt");
            return (Criteria) this;
        }

        public Criteria andCreatedtLessThanOrEqualTo(String value) {
            addCriterion("CREATEDT <=", value, "createdt");
            return (Criteria) this;
        }

        public Criteria andCreatedtLike(String value) {
            addCriterion("CREATEDT like", value, "createdt");
            return (Criteria) this;
        }

        public Criteria andCreatedtNotLike(String value) {
            addCriterion("CREATEDT not like", value, "createdt");
            return (Criteria) this;
        }

        public Criteria andCreatedtIn(List<String> values) {
            addCriterion("CREATEDT in", values, "createdt");
            return (Criteria) this;
        }

        public Criteria andCreatedtNotIn(List<String> values) {
            addCriterion("CREATEDT not in", values, "createdt");
            return (Criteria) this;
        }

        public Criteria andCreatedtBetween(String value1, String value2) {
            addCriterion("CREATEDT between", value1, value2, "createdt");
            return (Criteria) this;
        }

        public Criteria andCreatedtNotBetween(String value1, String value2) {
            addCriterion("CREATEDT not between", value1, value2, "createdt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}