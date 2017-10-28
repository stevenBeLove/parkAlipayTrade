package com.qt.sales.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PaymerchantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaymerchantExample() {
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

        public Criteria andMerchantidIsNull() {
            addCriterion("MERCHANTID is null");
            return (Criteria) this;
        }

        public Criteria andMerchantidIsNotNull() {
            addCriterion("MERCHANTID is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantidEqualTo(String value) {
            addCriterion("MERCHANTID =", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidNotEqualTo(String value) {
            addCriterion("MERCHANTID <>", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidGreaterThan(String value) {
            addCriterion("MERCHANTID >", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANTID >=", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidLessThan(String value) {
            addCriterion("MERCHANTID <", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidLessThanOrEqualTo(String value) {
            addCriterion("MERCHANTID <=", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidLike(String value) {
            addCriterion("MERCHANTID like", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidNotLike(String value) {
            addCriterion("MERCHANTID not like", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidIn(List<String> values) {
            addCriterion("MERCHANTID in", values, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidNotIn(List<String> values) {
            addCriterion("MERCHANTID not in", values, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidBetween(String value1, String value2) {
            addCriterion("MERCHANTID between", value1, value2, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidNotBetween(String value1, String value2) {
            addCriterion("MERCHANTID not between", value1, value2, "merchantid");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("APP_ID is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("APP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("APP_ID =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("APP_ID <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("APP_ID >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("APP_ID >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("APP_ID <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("APP_ID <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("APP_ID like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("APP_ID not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("APP_ID in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("APP_ID not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("APP_ID between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("APP_ID not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenIsNull() {
            addCriterion("APP_AUTH_TOKEN is null");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenIsNotNull() {
            addCriterion("APP_AUTH_TOKEN is not null");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenEqualTo(String value) {
            addCriterion("APP_AUTH_TOKEN =", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenNotEqualTo(String value) {
            addCriterion("APP_AUTH_TOKEN <>", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenGreaterThan(String value) {
            addCriterion("APP_AUTH_TOKEN >", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenGreaterThanOrEqualTo(String value) {
            addCriterion("APP_AUTH_TOKEN >=", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenLessThan(String value) {
            addCriterion("APP_AUTH_TOKEN <", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenLessThanOrEqualTo(String value) {
            addCriterion("APP_AUTH_TOKEN <=", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenLike(String value) {
            addCriterion("APP_AUTH_TOKEN like", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenNotLike(String value) {
            addCriterion("APP_AUTH_TOKEN not like", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenIn(List<String> values) {
            addCriterion("APP_AUTH_TOKEN in", values, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenNotIn(List<String> values) {
            addCriterion("APP_AUTH_TOKEN not in", values, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenBetween(String value1, String value2) {
            addCriterion("APP_AUTH_TOKEN between", value1, value2, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenNotBetween(String value1, String value2) {
            addCriterion("APP_AUTH_TOKEN not between", value1, value2, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAuthAppIdIsNull() {
            addCriterion("AUTH_APP_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuthAppIdIsNotNull() {
            addCriterion("AUTH_APP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuthAppIdEqualTo(String value) {
            addCriterion("AUTH_APP_ID =", value, "authAppId");
            return (Criteria) this;
        }

        public Criteria andAuthAppIdNotEqualTo(String value) {
            addCriterion("AUTH_APP_ID <>", value, "authAppId");
            return (Criteria) this;
        }

        public Criteria andAuthAppIdGreaterThan(String value) {
            addCriterion("AUTH_APP_ID >", value, "authAppId");
            return (Criteria) this;
        }

        public Criteria andAuthAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("AUTH_APP_ID >=", value, "authAppId");
            return (Criteria) this;
        }

        public Criteria andAuthAppIdLessThan(String value) {
            addCriterion("AUTH_APP_ID <", value, "authAppId");
            return (Criteria) this;
        }

        public Criteria andAuthAppIdLessThanOrEqualTo(String value) {
            addCriterion("AUTH_APP_ID <=", value, "authAppId");
            return (Criteria) this;
        }

        public Criteria andAuthAppIdLike(String value) {
            addCriterion("AUTH_APP_ID like", value, "authAppId");
            return (Criteria) this;
        }

        public Criteria andAuthAppIdNotLike(String value) {
            addCriterion("AUTH_APP_ID not like", value, "authAppId");
            return (Criteria) this;
        }

        public Criteria andAuthAppIdIn(List<String> values) {
            addCriterion("AUTH_APP_ID in", values, "authAppId");
            return (Criteria) this;
        }

        public Criteria andAuthAppIdNotIn(List<String> values) {
            addCriterion("AUTH_APP_ID not in", values, "authAppId");
            return (Criteria) this;
        }

        public Criteria andAuthAppIdBetween(String value1, String value2) {
            addCriterion("AUTH_APP_ID between", value1, value2, "authAppId");
            return (Criteria) this;
        }

        public Criteria andAuthAppIdNotBetween(String value1, String value2) {
            addCriterion("AUTH_APP_ID not between", value1, value2, "authAppId");
            return (Criteria) this;
        }

        public Criteria andExpiresInIsNull() {
            addCriterion("EXPIRES_IN is null");
            return (Criteria) this;
        }

        public Criteria andExpiresInIsNotNull() {
            addCriterion("EXPIRES_IN is not null");
            return (Criteria) this;
        }

        public Criteria andExpiresInEqualTo(BigDecimal value) {
            addCriterion("EXPIRES_IN =", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInNotEqualTo(BigDecimal value) {
            addCriterion("EXPIRES_IN <>", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInGreaterThan(BigDecimal value) {
            addCriterion("EXPIRES_IN >", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EXPIRES_IN >=", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInLessThan(BigDecimal value) {
            addCriterion("EXPIRES_IN <", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EXPIRES_IN <=", value, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInIn(List<BigDecimal> values) {
            addCriterion("EXPIRES_IN in", values, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInNotIn(List<BigDecimal> values) {
            addCriterion("EXPIRES_IN not in", values, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXPIRES_IN between", value1, value2, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andExpiresInNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXPIRES_IN not between", value1, value2, "expiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInIsNull() {
            addCriterion("RE_EXPIRES_IN is null");
            return (Criteria) this;
        }

        public Criteria andReExpiresInIsNotNull() {
            addCriterion("RE_EXPIRES_IN is not null");
            return (Criteria) this;
        }

        public Criteria andReExpiresInEqualTo(BigDecimal value) {
            addCriterion("RE_EXPIRES_IN =", value, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInNotEqualTo(BigDecimal value) {
            addCriterion("RE_EXPIRES_IN <>", value, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInGreaterThan(BigDecimal value) {
            addCriterion("RE_EXPIRES_IN >", value, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RE_EXPIRES_IN >=", value, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInLessThan(BigDecimal value) {
            addCriterion("RE_EXPIRES_IN <", value, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RE_EXPIRES_IN <=", value, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInIn(List<BigDecimal> values) {
            addCriterion("RE_EXPIRES_IN in", values, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInNotIn(List<BigDecimal> values) {
            addCriterion("RE_EXPIRES_IN not in", values, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RE_EXPIRES_IN between", value1, value2, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andReExpiresInNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RE_EXPIRES_IN not between", value1, value2, "reExpiresIn");
            return (Criteria) this;
        }

        public Criteria andRedirectUriIsNull() {
            addCriterion("REDIRECT_URI is null");
            return (Criteria) this;
        }

        public Criteria andRedirectUriIsNotNull() {
            addCriterion("REDIRECT_URI is not null");
            return (Criteria) this;
        }

        public Criteria andRedirectUriEqualTo(String value) {
            addCriterion("REDIRECT_URI =", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriNotEqualTo(String value) {
            addCriterion("REDIRECT_URI <>", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriGreaterThan(String value) {
            addCriterion("REDIRECT_URI >", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriGreaterThanOrEqualTo(String value) {
            addCriterion("REDIRECT_URI >=", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriLessThan(String value) {
            addCriterion("REDIRECT_URI <", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriLessThanOrEqualTo(String value) {
            addCriterion("REDIRECT_URI <=", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriLike(String value) {
            addCriterion("REDIRECT_URI like", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriNotLike(String value) {
            addCriterion("REDIRECT_URI not like", value, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriIn(List<String> values) {
            addCriterion("REDIRECT_URI in", values, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriNotIn(List<String> values) {
            addCriterion("REDIRECT_URI not in", values, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriBetween(String value1, String value2) {
            addCriterion("REDIRECT_URI between", value1, value2, "redirectUri");
            return (Criteria) this;
        }

        public Criteria andRedirectUriNotBetween(String value1, String value2) {
            addCriterion("REDIRECT_URI not between", value1, value2, "redirectUri");
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