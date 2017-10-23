package com.qt.sales.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <pre>
 * 【类型】: CustomerExample <br/> 
 * 【作用】: TODO ADD FUNCTION. <br/>  
 * 【时间】：2016年11月1日 下午6:13:25 <br/> 
 * 【作者】：yinghui zhang <br/> 
 * </pre>
 */
public class CustomerExample {
    /**
     * 排序
     */
    protected String orderByClause;

    /**
     * 去重复
     */
    protected boolean distinct;
    
    /**
     * 开始条数
     */
    private int start;
    
    /**
     * 结束条数
     */
    private int end;
    

    /**
     * 描述：获取属性值.<br/>
     * 创建人：zhangyinghui <br/>
     * 返回类型：@return start .<br/>
     */
    public int getStart() {
        return start;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年10月20日 下午7:40:12 <br/>
     * 参数: @param  start 设置值.  <br/>
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：zhangyinghui <br/>
     * 返回类型：@return end .<br/>
     */
    public int getEnd() {
        return end;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年10月20日 下午7:40:12 <br/>
     * 参数: @param  end 设置值.  <br/>
     */
    public void setEnd(int end) {
        this.end = end;
    }

    protected List<Criteria> oredCriteria;

    public CustomerExample() {
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

        public Criteria andCustomeridIsNull() {
            addCriterion("CUSTOMERID is null");
            return (Criteria) this;
        }

        public Criteria andCustomeridIsNotNull() {
            addCriterion("CUSTOMERID is not null");
            return (Criteria) this;
        }

        public Criteria andCustomeridEqualTo(String value) {
            addCriterion("CUSTOMERID =", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotEqualTo(String value) {
            addCriterion("CUSTOMERID <>", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridGreaterThan(String value) {
            addCriterion("CUSTOMERID >", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOMERID >=", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridLessThan(String value) {
            addCriterion("CUSTOMERID <", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridLessThanOrEqualTo(String value) {
            addCriterion("CUSTOMERID <=", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridLike(String value) {
            addCriterion("CUSTOMERID like", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotLike(String value) {
            addCriterion("CUSTOMERID not like", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridIn(List<String> values) {
            addCriterion("CUSTOMERID in", values, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotIn(List<String> values) {
            addCriterion("CUSTOMERID not in", values, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridBetween(String value1, String value2) {
            addCriterion("CUSTOMERID between", value1, value2, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotBetween(String value1, String value2) {
            addCriterion("CUSTOMERID not between", value1, value2, "customerid");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andAgencyIdIsNull() {
            addCriterion("AGENCY_ID is null");
            return (Criteria) this;
        }

        public Criteria andAgencyIdIsNotNull() {
            addCriterion("AGENCY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyIdEqualTo(String value) {
            addCriterion("AGENCY_ID =", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdNotEqualTo(String value) {
            addCriterion("AGENCY_ID <>", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdGreaterThan(String value) {
            addCriterion("AGENCY_ID >", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdGreaterThanOrEqualTo(String value) {
            addCriterion("AGENCY_ID >=", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdLessThan(String value) {
            addCriterion("AGENCY_ID <", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdLessThanOrEqualTo(String value) {
            addCriterion("AGENCY_ID <=", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdLike(String value) {
            addCriterion("AGENCY_ID like", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdNotLike(String value) {
            addCriterion("AGENCY_ID not like", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdIn(List<String> values) {
            addCriterion("AGENCY_ID in", values, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdNotIn(List<String> values) {
            addCriterion("AGENCY_ID not in", values, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdBetween(String value1, String value2) {
            addCriterion("AGENCY_ID between", value1, value2, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdNotBetween(String value1, String value2) {
            addCriterion("AGENCY_ID not between", value1, value2, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyNameIsNull() {
            addCriterion("AGENCY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAgencyNameIsNotNull() {
            addCriterion("AGENCY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyNameEqualTo(String value) {
            addCriterion("AGENCY_NAME =", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameNotEqualTo(String value) {
            addCriterion("AGENCY_NAME <>", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameGreaterThan(String value) {
            addCriterion("AGENCY_NAME >", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameGreaterThanOrEqualTo(String value) {
            addCriterion("AGENCY_NAME >=", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameLessThan(String value) {
            addCriterion("AGENCY_NAME <", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameLessThanOrEqualTo(String value) {
            addCriterion("AGENCY_NAME <=", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameLike(String value) {
            addCriterion("AGENCY_NAME like", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameNotLike(String value) {
            addCriterion("AGENCY_NAME not like", value, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameIn(List<String> values) {
            addCriterion("AGENCY_NAME in", values, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameNotIn(List<String> values) {
            addCriterion("AGENCY_NAME not in", values, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameBetween(String value1, String value2) {
            addCriterion("AGENCY_NAME between", value1, value2, "agencyName");
            return (Criteria) this;
        }

        public Criteria andAgencyNameNotBetween(String value1, String value2) {
            addCriterion("AGENCY_NAME not between", value1, value2, "agencyName");
            return (Criteria) this;
        }

        public Criteria andCustomerregdateIsNull() {
            addCriterion("CUSTOMERREGDATE is null");
            return (Criteria) this;
        }

        public Criteria andCustomerregdateIsNotNull() {
            addCriterion("CUSTOMERREGDATE is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerregdateEqualTo(String value) {
            addCriterion("CUSTOMERREGDATE =", value, "customerregdate");
            return (Criteria) this;
        }

        public Criteria andCustomerregdateNotEqualTo(String value) {
            addCriterion("CUSTOMERREGDATE <>", value, "customerregdate");
            return (Criteria) this;
        }

        public Criteria andCustomerregdateGreaterThan(String value) {
            addCriterion("CUSTOMERREGDATE >", value, "customerregdate");
            return (Criteria) this;
        }

        public Criteria andCustomerregdateGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOMERREGDATE >=", value, "customerregdate");
            return (Criteria) this;
        }

        public Criteria andCustomerregdateLessThan(String value) {
            addCriterion("CUSTOMERREGDATE <", value, "customerregdate");
            return (Criteria) this;
        }

        public Criteria andCustomerregdateLessThanOrEqualTo(String value) {
            addCriterion("CUSTOMERREGDATE <=", value, "customerregdate");
            return (Criteria) this;
        }

        public Criteria andCustomerregdateLike(String value) {
            addCriterion("CUSTOMERREGDATE like", value, "customerregdate");
            return (Criteria) this;
        }

        public Criteria andCustomerregdateNotLike(String value) {
            addCriterion("CUSTOMERREGDATE not like", value, "customerregdate");
            return (Criteria) this;
        }

        public Criteria andCustomerregdateIn(List<String> values) {
            addCriterion("CUSTOMERREGDATE in", values, "customerregdate");
            return (Criteria) this;
        }

        public Criteria andCustomerregdateNotIn(List<String> values) {
            addCriterion("CUSTOMERREGDATE not in", values, "customerregdate");
            return (Criteria) this;
        }

        public Criteria andCustomerregdateBetween(String value1, String value2) {
            addCriterion("CUSTOMERREGDATE between", value1, value2, "customerregdate");
            return (Criteria) this;
        }

        public Criteria andCustomerregdateNotBetween(String value1, String value2) {
            addCriterion("CUSTOMERREGDATE not between", value1, value2, "customerregdate");
            return (Criteria) this;
        }

        public Criteria andParentCustomeridIsNull() {
            addCriterion("PARENT_CUSTOMERID is null");
            return (Criteria) this;
        }

        public Criteria andParentCustomeridIsNotNull() {
            addCriterion("PARENT_CUSTOMERID is not null");
            return (Criteria) this;
        }

        public Criteria andParentCustomeridEqualTo(String value) {
            addCriterion("PARENT_CUSTOMERID =", value, "parentCustomerid");
            return (Criteria) this;
        }

        public Criteria andParentCustomeridNotEqualTo(String value) {
            addCriterion("PARENT_CUSTOMERID <>", value, "parentCustomerid");
            return (Criteria) this;
        }

        public Criteria andParentCustomeridGreaterThan(String value) {
            addCriterion("PARENT_CUSTOMERID >", value, "parentCustomerid");
            return (Criteria) this;
        }

        public Criteria andParentCustomeridGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_CUSTOMERID >=", value, "parentCustomerid");
            return (Criteria) this;
        }

        public Criteria andParentCustomeridLessThan(String value) {
            addCriterion("PARENT_CUSTOMERID <", value, "parentCustomerid");
            return (Criteria) this;
        }

        public Criteria andParentCustomeridLessThanOrEqualTo(String value) {
            addCriterion("PARENT_CUSTOMERID <=", value, "parentCustomerid");
            return (Criteria) this;
        }

        public Criteria andParentCustomeridLike(String value) {
            addCriterion("PARENT_CUSTOMERID like", value, "parentCustomerid");
            return (Criteria) this;
        }

        public Criteria andParentCustomeridNotLike(String value) {
            addCriterion("PARENT_CUSTOMERID not like", value, "parentCustomerid");
            return (Criteria) this;
        }

        public Criteria andParentCustomeridIn(List<String> values) {
            addCriterion("PARENT_CUSTOMERID in", values, "parentCustomerid");
            return (Criteria) this;
        }

        public Criteria andParentCustomeridNotIn(List<String> values) {
            addCriterion("PARENT_CUSTOMERID not in", values, "parentCustomerid");
            return (Criteria) this;
        }

        public Criteria andParentCustomeridBetween(String value1, String value2) {
            addCriterion("PARENT_CUSTOMERID between", value1, value2, "parentCustomerid");
            return (Criteria) this;
        }

        public Criteria andParentCustomeridNotBetween(String value1, String value2) {
            addCriterion("PARENT_CUSTOMERID not between", value1, value2, "parentCustomerid");
            return (Criteria) this;
        }

        public Criteria andParentMobileIsNull() {
            addCriterion("PARENT_MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andParentMobileIsNotNull() {
            addCriterion("PARENT_MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andParentMobileEqualTo(String value) {
            addCriterion("PARENT_MOBILE =", value, "parentMobile");
            return (Criteria) this;
        }

        public Criteria andParentMobileNotEqualTo(String value) {
            addCriterion("PARENT_MOBILE <>", value, "parentMobile");
            return (Criteria) this;
        }

        public Criteria andParentMobileGreaterThan(String value) {
            addCriterion("PARENT_MOBILE >", value, "parentMobile");
            return (Criteria) this;
        }

        public Criteria andParentMobileGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_MOBILE >=", value, "parentMobile");
            return (Criteria) this;
        }

        public Criteria andParentMobileLessThan(String value) {
            addCriterion("PARENT_MOBILE <", value, "parentMobile");
            return (Criteria) this;
        }

        public Criteria andParentMobileLessThanOrEqualTo(String value) {
            addCriterion("PARENT_MOBILE <=", value, "parentMobile");
            return (Criteria) this;
        }

        public Criteria andParentMobileLike(String value) {
            addCriterion("PARENT_MOBILE like", value, "parentMobile");
            return (Criteria) this;
        }

        public Criteria andParentMobileNotLike(String value) {
            addCriterion("PARENT_MOBILE not like", value, "parentMobile");
            return (Criteria) this;
        }

        public Criteria andParentMobileIn(List<String> values) {
            addCriterion("PARENT_MOBILE in", values, "parentMobile");
            return (Criteria) this;
        }

        public Criteria andParentMobileNotIn(List<String> values) {
            addCriterion("PARENT_MOBILE not in", values, "parentMobile");
            return (Criteria) this;
        }

        public Criteria andParentMobileBetween(String value1, String value2) {
            addCriterion("PARENT_MOBILE between", value1, value2, "parentMobile");
            return (Criteria) this;
        }

        public Criteria andParentMobileNotBetween(String value1, String value2) {
            addCriterion("PARENT_MOBILE not between", value1, value2, "parentMobile");
            return (Criteria) this;
        }

        public Criteria andTwoCustomeridIsNull() {
            addCriterion("TWO_CUSTOMERID is null");
            return (Criteria) this;
        }

        public Criteria andTwoCustomeridIsNotNull() {
            addCriterion("TWO_CUSTOMERID is not null");
            return (Criteria) this;
        }

        public Criteria andTwoCustomeridEqualTo(String value) {
            addCriterion("TWO_CUSTOMERID =", value, "twoCustomerid");
            return (Criteria) this;
        }

        public Criteria andTwoCustomeridNotEqualTo(String value) {
            addCriterion("TWO_CUSTOMERID <>", value, "twoCustomerid");
            return (Criteria) this;
        }

        public Criteria andTwoCustomeridGreaterThan(String value) {
            addCriterion("TWO_CUSTOMERID >", value, "twoCustomerid");
            return (Criteria) this;
        }

        public Criteria andTwoCustomeridGreaterThanOrEqualTo(String value) {
            addCriterion("TWO_CUSTOMERID >=", value, "twoCustomerid");
            return (Criteria) this;
        }

        public Criteria andTwoCustomeridLessThan(String value) {
            addCriterion("TWO_CUSTOMERID <", value, "twoCustomerid");
            return (Criteria) this;
        }

        public Criteria andTwoCustomeridLessThanOrEqualTo(String value) {
            addCriterion("TWO_CUSTOMERID <=", value, "twoCustomerid");
            return (Criteria) this;
        }

        public Criteria andTwoCustomeridLike(String value) {
            addCriterion("TWO_CUSTOMERID like", value, "twoCustomerid");
            return (Criteria) this;
        }

        public Criteria andTwoCustomeridNotLike(String value) {
            addCriterion("TWO_CUSTOMERID not like", value, "twoCustomerid");
            return (Criteria) this;
        }

        public Criteria andTwoCustomeridIn(List<String> values) {
            addCriterion("TWO_CUSTOMERID in", values, "twoCustomerid");
            return (Criteria) this;
        }

        public Criteria andTwoCustomeridNotIn(List<String> values) {
            addCriterion("TWO_CUSTOMERID not in", values, "twoCustomerid");
            return (Criteria) this;
        }

        public Criteria andTwoCustomeridBetween(String value1, String value2) {
            addCriterion("TWO_CUSTOMERID between", value1, value2, "twoCustomerid");
            return (Criteria) this;
        }

        public Criteria andTwoCustomeridNotBetween(String value1, String value2) {
            addCriterion("TWO_CUSTOMERID not between", value1, value2, "twoCustomerid");
            return (Criteria) this;
        }

        public Criteria andTwoMobileIsNull() {
            addCriterion("TWO_MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andTwoMobileIsNotNull() {
            addCriterion("TWO_MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andTwoMobileEqualTo(String value) {
            addCriterion("TWO_MOBILE =", value, "twoMobile");
            return (Criteria) this;
        }

        public Criteria andTwoMobileNotEqualTo(String value) {
            addCriterion("TWO_MOBILE <>", value, "twoMobile");
            return (Criteria) this;
        }

        public Criteria andTwoMobileGreaterThan(String value) {
            addCriterion("TWO_MOBILE >", value, "twoMobile");
            return (Criteria) this;
        }

        public Criteria andTwoMobileGreaterThanOrEqualTo(String value) {
            addCriterion("TWO_MOBILE >=", value, "twoMobile");
            return (Criteria) this;
        }

        public Criteria andTwoMobileLessThan(String value) {
            addCriterion("TWO_MOBILE <", value, "twoMobile");
            return (Criteria) this;
        }

        public Criteria andTwoMobileLessThanOrEqualTo(String value) {
            addCriterion("TWO_MOBILE <=", value, "twoMobile");
            return (Criteria) this;
        }

        public Criteria andTwoMobileLike(String value) {
            addCriterion("TWO_MOBILE like", value, "twoMobile");
            return (Criteria) this;
        }

        public Criteria andTwoMobileNotLike(String value) {
            addCriterion("TWO_MOBILE not like", value, "twoMobile");
            return (Criteria) this;
        }

        public Criteria andTwoMobileIn(List<String> values) {
            addCriterion("TWO_MOBILE in", values, "twoMobile");
            return (Criteria) this;
        }

        public Criteria andTwoMobileNotIn(List<String> values) {
            addCriterion("TWO_MOBILE not in", values, "twoMobile");
            return (Criteria) this;
        }

        public Criteria andTwoMobileBetween(String value1, String value2) {
            addCriterion("TWO_MOBILE between", value1, value2, "twoMobile");
            return (Criteria) this;
        }

        public Criteria andTwoMobileNotBetween(String value1, String value2) {
            addCriterion("TWO_MOBILE not between", value1, value2, "twoMobile");
            return (Criteria) this;
        }

        public Criteria andTopCustomeridIsNull() {
            addCriterion("TOP_CUSTOMERID is null");
            return (Criteria) this;
        }

        public Criteria andTopCustomeridIsNotNull() {
            addCriterion("TOP_CUSTOMERID is not null");
            return (Criteria) this;
        }

        public Criteria andTopCustomeridEqualTo(String value) {
            addCriterion("TOP_CUSTOMERID =", value, "topCustomerid");
            return (Criteria) this;
        }

        public Criteria andTopCustomeridNotEqualTo(String value) {
            addCriterion("TOP_CUSTOMERID <>", value, "topCustomerid");
            return (Criteria) this;
        }

        public Criteria andTopCustomeridGreaterThan(String value) {
            addCriterion("TOP_CUSTOMERID >", value, "topCustomerid");
            return (Criteria) this;
        }

        public Criteria andTopCustomeridGreaterThanOrEqualTo(String value) {
            addCriterion("TOP_CUSTOMERID >=", value, "topCustomerid");
            return (Criteria) this;
        }

        public Criteria andTopCustomeridLessThan(String value) {
            addCriterion("TOP_CUSTOMERID <", value, "topCustomerid");
            return (Criteria) this;
        }

        public Criteria andTopCustomeridLessThanOrEqualTo(String value) {
            addCriterion("TOP_CUSTOMERID <=", value, "topCustomerid");
            return (Criteria) this;
        }

        public Criteria andTopCustomeridLike(String value) {
            addCriterion("TOP_CUSTOMERID like", value, "topCustomerid");
            return (Criteria) this;
        }

        public Criteria andTopCustomeridNotLike(String value) {
            addCriterion("TOP_CUSTOMERID not like", value, "topCustomerid");
            return (Criteria) this;
        }

        public Criteria andTopCustomeridIn(List<String> values) {
            addCriterion("TOP_CUSTOMERID in", values, "topCustomerid");
            return (Criteria) this;
        }

        public Criteria andTopCustomeridNotIn(List<String> values) {
            addCriterion("TOP_CUSTOMERID not in", values, "topCustomerid");
            return (Criteria) this;
        }

        public Criteria andTopCustomeridBetween(String value1, String value2) {
            addCriterion("TOP_CUSTOMERID between", value1, value2, "topCustomerid");
            return (Criteria) this;
        }

        public Criteria andTopCustomeridNotBetween(String value1, String value2) {
            addCriterion("TOP_CUSTOMERID not between", value1, value2, "topCustomerid");
            return (Criteria) this;
        }

        public Criteria andTopMobileIsNull() {
            addCriterion("TOP_MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andTopMobileIsNotNull() {
            addCriterion("TOP_MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andTopMobileEqualTo(String value) {
            addCriterion("TOP_MOBILE =", value, "topMobile");
            return (Criteria) this;
        }

        public Criteria andTopMobileNotEqualTo(String value) {
            addCriterion("TOP_MOBILE <>", value, "topMobile");
            return (Criteria) this;
        }

        public Criteria andTopMobileGreaterThan(String value) {
            addCriterion("TOP_MOBILE >", value, "topMobile");
            return (Criteria) this;
        }

        public Criteria andTopMobileGreaterThanOrEqualTo(String value) {
            addCriterion("TOP_MOBILE >=", value, "topMobile");
            return (Criteria) this;
        }

        public Criteria andTopMobileLessThan(String value) {
            addCriterion("TOP_MOBILE <", value, "topMobile");
            return (Criteria) this;
        }

        public Criteria andTopMobileLessThanOrEqualTo(String value) {
            addCriterion("TOP_MOBILE <=", value, "topMobile");
            return (Criteria) this;
        }

        public Criteria andTopMobileLike(String value) {
            addCriterion("TOP_MOBILE like", value, "topMobile");
            return (Criteria) this;
        }

        public Criteria andTopMobileNotLike(String value) {
            addCriterion("TOP_MOBILE not like", value, "topMobile");
            return (Criteria) this;
        }

        public Criteria andTopMobileIn(List<String> values) {
            addCriterion("TOP_MOBILE in", values, "topMobile");
            return (Criteria) this;
        }

        public Criteria andTopMobileNotIn(List<String> values) {
            addCriterion("TOP_MOBILE not in", values, "topMobile");
            return (Criteria) this;
        }

        public Criteria andTopMobileBetween(String value1, String value2) {
            addCriterion("TOP_MOBILE between", value1, value2, "topMobile");
            return (Criteria) this;
        }

        public Criteria andTopMobileNotBetween(String value1, String value2) {
            addCriterion("TOP_MOBILE not between", value1, value2, "topMobile");
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