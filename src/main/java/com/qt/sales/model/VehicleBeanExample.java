package com.qt.sales.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehicleBeanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VehicleBeanExample() {
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

        public Criteria andVehicleIdIsNull() {
            addCriterion("VEHICLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIsNotNull() {
            addCriterion("VEHICLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleIdEqualTo(String value) {
            addCriterion("VEHICLE_ID =", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotEqualTo(String value) {
            addCriterion("VEHICLE_ID <>", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdGreaterThan(String value) {
            addCriterion("VEHICLE_ID >", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdGreaterThanOrEqualTo(String value) {
            addCriterion("VEHICLE_ID >=", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdLessThan(String value) {
            addCriterion("VEHICLE_ID <", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdLessThanOrEqualTo(String value) {
            addCriterion("VEHICLE_ID <=", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdLike(String value) {
            addCriterion("VEHICLE_ID like", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotLike(String value) {
            addCriterion("VEHICLE_ID not like", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIn(List<String> values) {
            addCriterion("VEHICLE_ID in", values, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotIn(List<String> values) {
            addCriterion("VEHICLE_ID not in", values, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdBetween(String value1, String value2) {
            addCriterion("VEHICLE_ID between", value1, value2, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotBetween(String value1, String value2) {
            addCriterion("VEHICLE_ID not between", value1, value2, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNull() {
            addCriterion("CAR_ID is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("CAR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(String value) {
            addCriterion("CAR_ID =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(String value) {
            addCriterion("CAR_ID <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(String value) {
            addCriterion("CAR_ID >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(String value) {
            addCriterion("CAR_ID >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(String value) {
            addCriterion("CAR_ID <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(String value) {
            addCriterion("CAR_ID <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLike(String value) {
            addCriterion("CAR_ID like", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotLike(String value) {
            addCriterion("CAR_ID not like", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<String> values) {
            addCriterion("CAR_ID in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<String> values) {
            addCriterion("CAR_ID not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(String value1, String value2) {
            addCriterion("CAR_ID between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(String value1, String value2) {
            addCriterion("CAR_ID not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNull() {
            addCriterion("CAR_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNotNull() {
            addCriterion("CAR_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumberEqualTo(String value) {
            addCriterion("CAR_NUMBER =", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotEqualTo(String value) {
            addCriterion("CAR_NUMBER <>", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThan(String value) {
            addCriterion("CAR_NUMBER >", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThanOrEqualTo(String value) {
            addCriterion("CAR_NUMBER >=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThan(String value) {
            addCriterion("CAR_NUMBER <", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThanOrEqualTo(String value) {
            addCriterion("CAR_NUMBER <=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLike(String value) {
            addCriterion("CAR_NUMBER like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotLike(String value) {
            addCriterion("CAR_NUMBER not like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberIn(List<String> values) {
            addCriterion("CAR_NUMBER in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotIn(List<String> values) {
            addCriterion("CAR_NUMBER not in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberBetween(String value1, String value2) {
            addCriterion("CAR_NUMBER between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotBetween(String value1, String value2) {
            addCriterion("CAR_NUMBER not between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andParkingIdIsNull() {
            addCriterion("PARKING_ID is null");
            return (Criteria) this;
        }

        public Criteria andParkingIdIsNotNull() {
            addCriterion("PARKING_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParkingIdEqualTo(String value) {
            addCriterion("PARKING_ID =", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdNotEqualTo(String value) {
            addCriterion("PARKING_ID <>", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdGreaterThan(String value) {
            addCriterion("PARKING_ID >", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARKING_ID >=", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdLessThan(String value) {
            addCriterion("PARKING_ID <", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdLessThanOrEqualTo(String value) {
            addCriterion("PARKING_ID <=", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdLike(String value) {
            addCriterion("PARKING_ID like", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdNotLike(String value) {
            addCriterion("PARKING_ID not like", value, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdIn(List<String> values) {
            addCriterion("PARKING_ID in", values, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdNotIn(List<String> values) {
            addCriterion("PARKING_ID not in", values, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdBetween(String value1, String value2) {
            addCriterion("PARKING_ID between", value1, value2, "parkingId");
            return (Criteria) this;
        }

        public Criteria andParkingIdNotBetween(String value1, String value2) {
            addCriterion("PARKING_ID not between", value1, value2, "parkingId");
            return (Criteria) this;
        }

        public Criteria andAuthTokenIsNull() {
            addCriterion("AUTH_TOKEN is null");
            return (Criteria) this;
        }

        public Criteria andAuthTokenIsNotNull() {
            addCriterion("AUTH_TOKEN is not null");
            return (Criteria) this;
        }

        public Criteria andAuthTokenEqualTo(String value) {
            addCriterion("AUTH_TOKEN =", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenNotEqualTo(String value) {
            addCriterion("AUTH_TOKEN <>", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenGreaterThan(String value) {
            addCriterion("AUTH_TOKEN >", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenGreaterThanOrEqualTo(String value) {
            addCriterion("AUTH_TOKEN >=", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenLessThan(String value) {
            addCriterion("AUTH_TOKEN <", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenLessThanOrEqualTo(String value) {
            addCriterion("AUTH_TOKEN <=", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenLike(String value) {
            addCriterion("AUTH_TOKEN like", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenNotLike(String value) {
            addCriterion("AUTH_TOKEN not like", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenIn(List<String> values) {
            addCriterion("AUTH_TOKEN in", values, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenNotIn(List<String> values) {
            addCriterion("AUTH_TOKEN not in", values, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenBetween(String value1, String value2) {
            addCriterion("AUTH_TOKEN between", value1, value2, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenNotBetween(String value1, String value2) {
            addCriterion("AUTH_TOKEN not between", value1, value2, "authToken");
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

        public Criteria andCreateDatetimeIsNull() {
            addCriterion("CREATE_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNotNull() {
            addCriterion("CREATE_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeEqualTo(Date value) {
            addCriterion("CREATE_DATETIME =", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotEqualTo(Date value) {
            addCriterion("CREATE_DATETIME <>", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThan(Date value) {
            addCriterion("CREATE_DATETIME >", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATETIME >=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThan(Date value) {
            addCriterion("CREATE_DATETIME <", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATETIME <=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIn(List<Date> values) {
            addCriterion("CREATE_DATETIME in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotIn(List<Date> values) {
            addCriterion("CREATE_DATETIME not in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATETIME between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATETIME not between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeIsNull() {
            addCriterion("MODIFY_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeIsNotNull() {
            addCriterion("MODIFY_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeEqualTo(Date value) {
            addCriterion("MODIFY_DATETIME =", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeNotEqualTo(Date value) {
            addCriterion("MODIFY_DATETIME <>", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeGreaterThan(Date value) {
            addCriterion("MODIFY_DATETIME >", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFY_DATETIME >=", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeLessThan(Date value) {
            addCriterion("MODIFY_DATETIME <", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFY_DATETIME <=", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeIn(List<Date> values) {
            addCriterion("MODIFY_DATETIME in", values, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeNotIn(List<Date> values) {
            addCriterion("MODIFY_DATETIME not in", values, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeBetween(Date value1, Date value2) {
            addCriterion("MODIFY_DATETIME between", value1, value2, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFY_DATETIME not between", value1, value2, "modifyDatetime");
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