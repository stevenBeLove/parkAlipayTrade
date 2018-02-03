package com.qt.sales.model;

import java.util.ArrayList;
import java.util.List;

public class ParkLicenseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkLicenseExample() {
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

        public Criteria andOutParkingIdIsNull() {
            addCriterion("OUT_PARKING_ID is null");
            return (Criteria) this;
        }

        public Criteria andOutParkingIdIsNotNull() {
            addCriterion("OUT_PARKING_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOutParkingIdEqualTo(String value) {
            addCriterion("OUT_PARKING_ID =", value, "outParkingId");
            return (Criteria) this;
        }

        public Criteria andOutParkingIdNotEqualTo(String value) {
            addCriterion("OUT_PARKING_ID <>", value, "outParkingId");
            return (Criteria) this;
        }

        public Criteria andOutParkingIdGreaterThan(String value) {
            addCriterion("OUT_PARKING_ID >", value, "outParkingId");
            return (Criteria) this;
        }

        public Criteria andOutParkingIdGreaterThanOrEqualTo(String value) {
            addCriterion("OUT_PARKING_ID >=", value, "outParkingId");
            return (Criteria) this;
        }

        public Criteria andOutParkingIdLessThan(String value) {
            addCriterion("OUT_PARKING_ID <", value, "outParkingId");
            return (Criteria) this;
        }

        public Criteria andOutParkingIdLessThanOrEqualTo(String value) {
            addCriterion("OUT_PARKING_ID <=", value, "outParkingId");
            return (Criteria) this;
        }

        public Criteria andOutParkingIdLike(String value) {
            addCriterion("OUT_PARKING_ID like", value, "outParkingId");
            return (Criteria) this;
        }

        public Criteria andOutParkingIdNotLike(String value) {
            addCriterion("OUT_PARKING_ID not like", value, "outParkingId");
            return (Criteria) this;
        }

        public Criteria andOutParkingIdIn(List<String> values) {
            addCriterion("OUT_PARKING_ID in", values, "outParkingId");
            return (Criteria) this;
        }

        public Criteria andOutParkingIdNotIn(List<String> values) {
            addCriterion("OUT_PARKING_ID not in", values, "outParkingId");
            return (Criteria) this;
        }

        public Criteria andOutParkingIdBetween(String value1, String value2) {
            addCriterion("OUT_PARKING_ID between", value1, value2, "outParkingId");
            return (Criteria) this;
        }

        public Criteria andOutParkingIdNotBetween(String value1, String value2) {
            addCriterion("OUT_PARKING_ID not between", value1, value2, "outParkingId");
            return (Criteria) this;
        }

        public Criteria andParkMacIsNull() {
            addCriterion("PARK_MAC is null");
            return (Criteria) this;
        }

        public Criteria andParkMacIsNotNull() {
            addCriterion("PARK_MAC is not null");
            return (Criteria) this;
        }

        public Criteria andParkMacEqualTo(String value) {
            addCriterion("PARK_MAC =", value, "parkMac");
            return (Criteria) this;
        }

        public Criteria andParkMacNotEqualTo(String value) {
            addCriterion("PARK_MAC <>", value, "parkMac");
            return (Criteria) this;
        }

        public Criteria andParkMacGreaterThan(String value) {
            addCriterion("PARK_MAC >", value, "parkMac");
            return (Criteria) this;
        }

        public Criteria andParkMacGreaterThanOrEqualTo(String value) {
            addCriterion("PARK_MAC >=", value, "parkMac");
            return (Criteria) this;
        }

        public Criteria andParkMacLessThan(String value) {
            addCriterion("PARK_MAC <", value, "parkMac");
            return (Criteria) this;
        }

        public Criteria andParkMacLessThanOrEqualTo(String value) {
            addCriterion("PARK_MAC <=", value, "parkMac");
            return (Criteria) this;
        }

        public Criteria andParkMacLike(String value) {
            addCriterion("PARK_MAC like", value, "parkMac");
            return (Criteria) this;
        }

        public Criteria andParkMacNotLike(String value) {
            addCriterion("PARK_MAC not like", value, "parkMac");
            return (Criteria) this;
        }

        public Criteria andParkMacIn(List<String> values) {
            addCriterion("PARK_MAC in", values, "parkMac");
            return (Criteria) this;
        }

        public Criteria andParkMacNotIn(List<String> values) {
            addCriterion("PARK_MAC not in", values, "parkMac");
            return (Criteria) this;
        }

        public Criteria andParkMacBetween(String value1, String value2) {
            addCriterion("PARK_MAC between", value1, value2, "parkMac");
            return (Criteria) this;
        }

        public Criteria andParkMacNotBetween(String value1, String value2) {
            addCriterion("PARK_MAC not between", value1, value2, "parkMac");
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