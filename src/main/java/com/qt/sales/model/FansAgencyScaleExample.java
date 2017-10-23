package com.qt.sales.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <pre>
 * 【类型】: FansAgencyScaleExample <br/> 
 * 【作用】: TODO ADD FUNCTION. <br/>  
 * 【时间】：2016年11月2日 下午2:09:15 <br/> 
 * 【作者】：yinghui zhang <br/> 
 * </pre>
 */
public class FansAgencyScaleExample {
    /**
     * 排序
     */
    protected String orderByClause;

    /**
     * 去重复
     */
    protected boolean distinct;

    /**
     * 条件列表
     */
    protected List<Criteria> oredCriteria;

    public FansAgencyScaleExample() {
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

        public Criteria andMycostIsNull() {
            addCriterion("MYCOST is null");
            return (Criteria) this;
        }

        public Criteria andMycostIsNotNull() {
            addCriterion("MYCOST is not null");
            return (Criteria) this;
        }

        public Criteria andMycostEqualTo(Long value) {
            addCriterion("MYCOST =", value, "mycost");
            return (Criteria) this;
        }

        public Criteria andMycostNotEqualTo(Long value) {
            addCriterion("MYCOST <>", value, "mycost");
            return (Criteria) this;
        }

        public Criteria andMycostGreaterThan(Long value) {
            addCriterion("MYCOST >", value, "mycost");
            return (Criteria) this;
        }

        public Criteria andMycostGreaterThanOrEqualTo(Long value) {
            addCriterion("MYCOST >=", value, "mycost");
            return (Criteria) this;
        }

        public Criteria andMycostLessThan(Long value) {
            addCriterion("MYCOST <", value, "mycost");
            return (Criteria) this;
        }

        public Criteria andMycostLessThanOrEqualTo(Long value) {
            addCriterion("MYCOST <=", value, "mycost");
            return (Criteria) this;
        }

        public Criteria andMycostIn(List<Long> values) {
            addCriterion("MYCOST in", values, "mycost");
            return (Criteria) this;
        }

        public Criteria andMycostNotIn(List<Long> values) {
            addCriterion("MYCOST not in", values, "mycost");
            return (Criteria) this;
        }

        public Criteria andMycostBetween(Long value1, Long value2) {
            addCriterion("MYCOST between", value1, value2, "mycost");
            return (Criteria) this;
        }

        public Criteria andMycostNotBetween(Long value1, Long value2) {
            addCriterion("MYCOST not between", value1, value2, "mycost");
            return (Criteria) this;
        }

        public Criteria andFinalRateIsNull() {
            addCriterion("FINAL_RATE is null");
            return (Criteria) this;
        }

        public Criteria andFinalRateIsNotNull() {
            addCriterion("FINAL_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andFinalRateEqualTo(Long value) {
            addCriterion("FINAL_RATE =", value, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateNotEqualTo(Long value) {
            addCriterion("FINAL_RATE <>", value, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateGreaterThan(Long value) {
            addCriterion("FINAL_RATE >", value, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateGreaterThanOrEqualTo(Long value) {
            addCriterion("FINAL_RATE >=", value, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateLessThan(Long value) {
            addCriterion("FINAL_RATE <", value, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateLessThanOrEqualTo(Long value) {
            addCriterion("FINAL_RATE <=", value, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateIn(List<Long> values) {
            addCriterion("FINAL_RATE in", values, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateNotIn(List<Long> values) {
            addCriterion("FINAL_RATE not in", values, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateBetween(Long value1, Long value2) {
            addCriterion("FINAL_RATE between", value1, value2, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateNotBetween(Long value1, Long value2) {
            addCriterion("FINAL_RATE not between", value1, value2, "finalRate");
            return (Criteria) this;
        }

        public Criteria andSecondRateIsNull() {
            addCriterion("SECOND_RATE is null");
            return (Criteria) this;
        }

        public Criteria andSecondRateIsNotNull() {
            addCriterion("SECOND_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andSecondRateEqualTo(Long value) {
            addCriterion("SECOND_RATE =", value, "secondRate");
            return (Criteria) this;
        }

        public Criteria andSecondRateNotEqualTo(Long value) {
            addCriterion("SECOND_RATE <>", value, "secondRate");
            return (Criteria) this;
        }

        public Criteria andSecondRateGreaterThan(Long value) {
            addCriterion("SECOND_RATE >", value, "secondRate");
            return (Criteria) this;
        }

        public Criteria andSecondRateGreaterThanOrEqualTo(Long value) {
            addCriterion("SECOND_RATE >=", value, "secondRate");
            return (Criteria) this;
        }

        public Criteria andSecondRateLessThan(Long value) {
            addCriterion("SECOND_RATE <", value, "secondRate");
            return (Criteria) this;
        }

        public Criteria andSecondRateLessThanOrEqualTo(Long value) {
            addCriterion("SECOND_RATE <=", value, "secondRate");
            return (Criteria) this;
        }

        public Criteria andSecondRateIn(List<Long> values) {
            addCriterion("SECOND_RATE in", values, "secondRate");
            return (Criteria) this;
        }

        public Criteria andSecondRateNotIn(List<Long> values) {
            addCriterion("SECOND_RATE not in", values, "secondRate");
            return (Criteria) this;
        }

        public Criteria andSecondRateBetween(Long value1, Long value2) {
            addCriterion("SECOND_RATE between", value1, value2, "secondRate");
            return (Criteria) this;
        }

        public Criteria andSecondRateNotBetween(Long value1, Long value2) {
            addCriterion("SECOND_RATE not between", value1, value2, "secondRate");
            return (Criteria) this;
        }

        public Criteria andNextRateIsNull() {
            addCriterion("NEXT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andNextRateIsNotNull() {
            addCriterion("NEXT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andNextRateEqualTo(Long value) {
            addCriterion("NEXT_RATE =", value, "nextRate");
            return (Criteria) this;
        }

        public Criteria andNextRateNotEqualTo(Long value) {
            addCriterion("NEXT_RATE <>", value, "nextRate");
            return (Criteria) this;
        }

        public Criteria andNextRateGreaterThan(Long value) {
            addCriterion("NEXT_RATE >", value, "nextRate");
            return (Criteria) this;
        }

        public Criteria andNextRateGreaterThanOrEqualTo(Long value) {
            addCriterion("NEXT_RATE >=", value, "nextRate");
            return (Criteria) this;
        }

        public Criteria andNextRateLessThan(Long value) {
            addCriterion("NEXT_RATE <", value, "nextRate");
            return (Criteria) this;
        }

        public Criteria andNextRateLessThanOrEqualTo(Long value) {
            addCriterion("NEXT_RATE <=", value, "nextRate");
            return (Criteria) this;
        }

        public Criteria andNextRateIn(List<Long> values) {
            addCriterion("NEXT_RATE in", values, "nextRate");
            return (Criteria) this;
        }

        public Criteria andNextRateNotIn(List<Long> values) {
            addCriterion("NEXT_RATE not in", values, "nextRate");
            return (Criteria) this;
        }

        public Criteria andNextRateBetween(Long value1, Long value2) {
            addCriterion("NEXT_RATE between", value1, value2, "nextRate");
            return (Criteria) this;
        }

        public Criteria andNextRateNotBetween(Long value1, Long value2) {
            addCriterion("NEXT_RATE not between", value1, value2, "nextRate");
            return (Criteria) this;
        }

        public Criteria andBegindateIsNull() {
            addCriterion("BEGINDATE is null");
            return (Criteria) this;
        }

        public Criteria andBegindateIsNotNull() {
            addCriterion("BEGINDATE is not null");
            return (Criteria) this;
        }

        public Criteria andBegindateEqualTo(String value) {
            addCriterion("BEGINDATE =", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotEqualTo(String value) {
            addCriterion("BEGINDATE <>", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThan(String value) {
            addCriterion("BEGINDATE >", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThanOrEqualTo(String value) {
            addCriterion("BEGINDATE >=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThan(String value) {
            addCriterion("BEGINDATE <", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThanOrEqualTo(String value) {
            addCriterion("BEGINDATE <=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLike(String value) {
            addCriterion("BEGINDATE like", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotLike(String value) {
            addCriterion("BEGINDATE not like", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateIn(List<String> values) {
            addCriterion("BEGINDATE in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotIn(List<String> values) {
            addCriterion("BEGINDATE not in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateBetween(String value1, String value2) {
            addCriterion("BEGINDATE between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotBetween(String value1, String value2) {
            addCriterion("BEGINDATE not between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("ENDDATE is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("ENDDATE is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(String value) {
            addCriterion("ENDDATE =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(String value) {
            addCriterion("ENDDATE <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(String value) {
            addCriterion("ENDDATE >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(String value) {
            addCriterion("ENDDATE >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(String value) {
            addCriterion("ENDDATE <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(String value) {
            addCriterion("ENDDATE <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLike(String value) {
            addCriterion("ENDDATE like", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotLike(String value) {
            addCriterion("ENDDATE not like", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<String> values) {
            addCriterion("ENDDATE in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<String> values) {
            addCriterion("ENDDATE not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(String value1, String value2) {
            addCriterion("ENDDATE between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(String value1, String value2) {
            addCriterion("ENDDATE not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("BUSINESS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("BUSINESS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(String value) {
            addCriterion("BUSINESS_TYPE =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(String value) {
            addCriterion("BUSINESS_TYPE <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(String value) {
            addCriterion("BUSINESS_TYPE >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(String value) {
            addCriterion("BUSINESS_TYPE <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLike(String value) {
            addCriterion("BUSINESS_TYPE like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotLike(String value) {
            addCriterion("BUSINESS_TYPE not like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<String> values) {
            addCriterion("BUSINESS_TYPE in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<String> values) {
            addCriterion("BUSINESS_TYPE not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE not between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("USERID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("USERID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("USERID not between", value1, value2, "userid");
            return (Criteria) this;
        }
        
        public Criteria andAuditstatusIsNull() {
            addCriterion("AUDITSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIsNotNull() {
            addCriterion("AUDITSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAuditstatusEqualTo(String value) {
            addCriterion("AUDITSTATUS =", value, "auditstatus");
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