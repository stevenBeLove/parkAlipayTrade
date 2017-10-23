package com.qt.sales.model;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * <pre>
 * 【类型】: BusinessTypeExample <br/> 
 * 【作用】: 业务类型条件类. <br/>  
 * 【时间】：2016年10月27日 下午5:35:07 <br/> 
 * 【作者】：yinghui zhang <br/> 
 * </pre>
 */
public class BusinessTypeExample {
    /**
     * 排序字段
     */
    protected String orderByClause;

    /**
     * 去重复
     */
    protected boolean distinct;

    /**
     * 动态条件列表
     */
    protected List<Criteria> oredCriteria;

    
    
    public BusinessTypeExample() {
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

        public Criteria andBusinessNameIsNull() {
            addCriterion("BUSINESS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIsNotNull() {
            addCriterion("BUSINESS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessNameEqualTo(String value) {
            addCriterion("BUSINESS_NAME =", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotEqualTo(String value) {
            addCriterion("BUSINESS_NAME <>", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameGreaterThan(String value) {
            addCriterion("BUSINESS_NAME >", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_NAME >=", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLessThan(String value) {
            addCriterion("BUSINESS_NAME <", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_NAME <=", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLike(String value) {
            addCriterion("BUSINESS_NAME like", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotLike(String value) {
            addCriterion("BUSINESS_NAME not like", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIn(List<String> values) {
            addCriterion("BUSINESS_NAME in", values, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotIn(List<String> values) {
            addCriterion("BUSINESS_NAME not in", values, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameBetween(String value1, String value2) {
            addCriterion("BUSINESS_NAME between", value1, value2, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_NAME not between", value1, value2, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessDescIsNull() {
            addCriterion("BUSINESS_DESC is null");
            return (Criteria) this;
        }

        public Criteria andBusinessDescIsNotNull() {
            addCriterion("BUSINESS_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessDescEqualTo(String value) {
            addCriterion("BUSINESS_DESC =", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescNotEqualTo(String value) {
            addCriterion("BUSINESS_DESC <>", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescGreaterThan(String value) {
            addCriterion("BUSINESS_DESC >", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_DESC >=", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescLessThan(String value) {
            addCriterion("BUSINESS_DESC <", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_DESC <=", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescLike(String value) {
            addCriterion("BUSINESS_DESC like", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescNotLike(String value) {
            addCriterion("BUSINESS_DESC not like", value, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescIn(List<String> values) {
            addCriterion("BUSINESS_DESC in", values, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescNotIn(List<String> values) {
            addCriterion("BUSINESS_DESC not in", values, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescBetween(String value1, String value2) {
            addCriterion("BUSINESS_DESC between", value1, value2, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessDescNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_DESC not between", value1, value2, "businessDesc");
            return (Criteria) this;
        }

        public Criteria andBusinessScenarioIsNull() {
            addCriterion("BUSINESS_SCENARIO is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScenarioIsNotNull() {
            addCriterion("BUSINESS_SCENARIO is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScenarioEqualTo(String value) {
            addCriterion("BUSINESS_SCENARIO =", value, "businessScenario");
            return (Criteria) this;
        }

        public Criteria andBusinessScenarioNotEqualTo(String value) {
            addCriterion("BUSINESS_SCENARIO <>", value, "businessScenario");
            return (Criteria) this;
        }

        public Criteria andBusinessScenarioGreaterThan(String value) {
            addCriterion("BUSINESS_SCENARIO >", value, "businessScenario");
            return (Criteria) this;
        }

        public Criteria andBusinessScenarioGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_SCENARIO >=", value, "businessScenario");
            return (Criteria) this;
        }

        public Criteria andBusinessScenarioLessThan(String value) {
            addCriterion("BUSINESS_SCENARIO <", value, "businessScenario");
            return (Criteria) this;
        }

        public Criteria andBusinessScenarioLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_SCENARIO <=", value, "businessScenario");
            return (Criteria) this;
        }

        public Criteria andBusinessScenarioLike(String value) {
            addCriterion("BUSINESS_SCENARIO like", value, "businessScenario");
            return (Criteria) this;
        }

        public Criteria andBusinessScenarioNotLike(String value) {
            addCriterion("BUSINESS_SCENARIO not like", value, "businessScenario");
            return (Criteria) this;
        }

        public Criteria andBusinessScenarioIn(List<String> values) {
            addCriterion("BUSINESS_SCENARIO in", values, "businessScenario");
            return (Criteria) this;
        }

        public Criteria andBusinessScenarioNotIn(List<String> values) {
            addCriterion("BUSINESS_SCENARIO not in", values, "businessScenario");
            return (Criteria) this;
        }

        public Criteria andBusinessScenarioBetween(String value1, String value2) {
            addCriterion("BUSINESS_SCENARIO between", value1, value2, "businessScenario");
            return (Criteria) this;
        }

        public Criteria andBusinessScenarioNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_SCENARIO not between", value1, value2, "businessScenario");
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