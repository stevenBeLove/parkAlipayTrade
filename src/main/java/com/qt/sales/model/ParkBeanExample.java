package com.qt.sales.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkBeanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    private int start;
    
    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return start .<br/>
     */
    public int getStart() {
        return start;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2017年10月29日 下午4:58:02 <br/>
     * 参数: @param  start 设置值.  <br/>
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return end .<br/>
     */
    public int getEnd() {
        return end;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2017年10月29日 下午4:58:02 <br/>
     * 参数: @param  end 设置值.  <br/>
     */
    public void setEnd(int end) {
        this.end = end;
    }

    private int end;
    

    public ParkBeanExample() {
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

        public Criteria andMerchantNameIsNull() {
            addCriterion("MERCHANT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNotNull() {
            addCriterion("MERCHANT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameEqualTo(String value) {
            addCriterion("MERCHANT_NAME =", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotEqualTo(String value) {
            addCriterion("MERCHANT_NAME <>", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThan(String value) {
            addCriterion("MERCHANT_NAME >", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NAME >=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThan(String value) {
            addCriterion("MERCHANT_NAME <", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NAME <=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLike(String value) {
            addCriterion("MERCHANT_NAME like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotLike(String value) {
            addCriterion("MERCHANT_NAME not like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIn(List<String> values) {
            addCriterion("MERCHANT_NAME in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotIn(List<String> values) {
            addCriterion("MERCHANT_NAME not in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameBetween(String value1, String value2) {
            addCriterion("MERCHANT_NAME between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_NAME not between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantServicePhoneIsNull() {
            addCriterion("MERCHANT_SERVICE_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andMerchantServicePhoneIsNotNull() {
            addCriterion("MERCHANT_SERVICE_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantServicePhoneEqualTo(String value) {
            addCriterion("MERCHANT_SERVICE_PHONE =", value, "merchantServicePhone");
            return (Criteria) this;
        }

        public Criteria andMerchantServicePhoneNotEqualTo(String value) {
            addCriterion("MERCHANT_SERVICE_PHONE <>", value, "merchantServicePhone");
            return (Criteria) this;
        }

        public Criteria andMerchantServicePhoneGreaterThan(String value) {
            addCriterion("MERCHANT_SERVICE_PHONE >", value, "merchantServicePhone");
            return (Criteria) this;
        }

        public Criteria andMerchantServicePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_SERVICE_PHONE >=", value, "merchantServicePhone");
            return (Criteria) this;
        }

        public Criteria andMerchantServicePhoneLessThan(String value) {
            addCriterion("MERCHANT_SERVICE_PHONE <", value, "merchantServicePhone");
            return (Criteria) this;
        }

        public Criteria andMerchantServicePhoneLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_SERVICE_PHONE <=", value, "merchantServicePhone");
            return (Criteria) this;
        }

        public Criteria andMerchantServicePhoneLike(String value) {
            addCriterion("MERCHANT_SERVICE_PHONE like", value, "merchantServicePhone");
            return (Criteria) this;
        }

        public Criteria andMerchantServicePhoneNotLike(String value) {
            addCriterion("MERCHANT_SERVICE_PHONE not like", value, "merchantServicePhone");
            return (Criteria) this;
        }

        public Criteria andMerchantServicePhoneIn(List<String> values) {
            addCriterion("MERCHANT_SERVICE_PHONE in", values, "merchantServicePhone");
            return (Criteria) this;
        }

        public Criteria andMerchantServicePhoneNotIn(List<String> values) {
            addCriterion("MERCHANT_SERVICE_PHONE not in", values, "merchantServicePhone");
            return (Criteria) this;
        }

        public Criteria andMerchantServicePhoneBetween(String value1, String value2) {
            addCriterion("MERCHANT_SERVICE_PHONE between", value1, value2, "merchantServicePhone");
            return (Criteria) this;
        }

        public Criteria andMerchantServicePhoneNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_SERVICE_PHONE not between", value1, value2, "merchantServicePhone");
            return (Criteria) this;
        }

        public Criteria andAccountNoIsNull() {
            addCriterion("ACCOUNT_NO is null");
            return (Criteria) this;
        }

        public Criteria andAccountNoIsNotNull() {
            addCriterion("ACCOUNT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNoEqualTo(String value) {
            addCriterion("ACCOUNT_NO =", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotEqualTo(String value) {
            addCriterion("ACCOUNT_NO <>", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThan(String value) {
            addCriterion("ACCOUNT_NO >", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_NO >=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThan(String value) {
            addCriterion("ACCOUNT_NO <", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_NO <=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLike(String value) {
            addCriterion("ACCOUNT_NO like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotLike(String value) {
            addCriterion("ACCOUNT_NO not like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoIn(List<String> values) {
            addCriterion("ACCOUNT_NO in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotIn(List<String> values) {
            addCriterion("ACCOUNT_NO not in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoBetween(String value1, String value2) {
            addCriterion("ACCOUNT_NO between", value1, value2, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_NO not between", value1, value2, "accountNo");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("CITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("CITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(String value) {
            addCriterion("CITY_ID =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(String value) {
            addCriterion("CITY_ID <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(String value) {
            addCriterion("CITY_ID >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_ID >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(String value) {
            addCriterion("CITY_ID <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(String value) {
            addCriterion("CITY_ID <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLike(String value) {
            addCriterion("CITY_ID like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotLike(String value) {
            addCriterion("CITY_ID not like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<String> values) {
            addCriterion("CITY_ID in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<String> values) {
            addCriterion("CITY_ID not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(String value1, String value2) {
            addCriterion("CITY_ID between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(String value1, String value2) {
            addCriterion("CITY_ID not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIsNull() {
            addCriterion("EQUIPMENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIsNotNull() {
            addCriterion("EQUIPMENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameEqualTo(String value) {
            addCriterion("EQUIPMENT_NAME =", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotEqualTo(String value) {
            addCriterion("EQUIPMENT_NAME <>", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThan(String value) {
            addCriterion("EQUIPMENT_NAME >", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("EQUIPMENT_NAME >=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThan(String value) {
            addCriterion("EQUIPMENT_NAME <", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThanOrEqualTo(String value) {
            addCriterion("EQUIPMENT_NAME <=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLike(String value) {
            addCriterion("EQUIPMENT_NAME like", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotLike(String value) {
            addCriterion("EQUIPMENT_NAME not like", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIn(List<String> values) {
            addCriterion("EQUIPMENT_NAME in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotIn(List<String> values) {
            addCriterion("EQUIPMENT_NAME not in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameBetween(String value1, String value2) {
            addCriterion("EQUIPMENT_NAME between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotBetween(String value1, String value2) {
            addCriterion("EQUIPMENT_NAME not between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andParkingAddressIsNull() {
            addCriterion("PARKING_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andParkingAddressIsNotNull() {
            addCriterion("PARKING_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andParkingAddressEqualTo(String value) {
            addCriterion("PARKING_ADDRESS =", value, "parkingAddress");
            return (Criteria) this;
        }

        public Criteria andParkingAddressNotEqualTo(String value) {
            addCriterion("PARKING_ADDRESS <>", value, "parkingAddress");
            return (Criteria) this;
        }

        public Criteria andParkingAddressGreaterThan(String value) {
            addCriterion("PARKING_ADDRESS >", value, "parkingAddress");
            return (Criteria) this;
        }

        public Criteria andParkingAddressGreaterThanOrEqualTo(String value) {
            addCriterion("PARKING_ADDRESS >=", value, "parkingAddress");
            return (Criteria) this;
        }

        public Criteria andParkingAddressLessThan(String value) {
            addCriterion("PARKING_ADDRESS <", value, "parkingAddress");
            return (Criteria) this;
        }

        public Criteria andParkingAddressLessThanOrEqualTo(String value) {
            addCriterion("PARKING_ADDRESS <=", value, "parkingAddress");
            return (Criteria) this;
        }

        public Criteria andParkingAddressLike(String value) {
            addCriterion("PARKING_ADDRESS like", value, "parkingAddress");
            return (Criteria) this;
        }

        public Criteria andParkingAddressNotLike(String value) {
            addCriterion("PARKING_ADDRESS not like", value, "parkingAddress");
            return (Criteria) this;
        }

        public Criteria andParkingAddressIn(List<String> values) {
            addCriterion("PARKING_ADDRESS in", values, "parkingAddress");
            return (Criteria) this;
        }

        public Criteria andParkingAddressNotIn(List<String> values) {
            addCriterion("PARKING_ADDRESS not in", values, "parkingAddress");
            return (Criteria) this;
        }

        public Criteria andParkingAddressBetween(String value1, String value2) {
            addCriterion("PARKING_ADDRESS between", value1, value2, "parkingAddress");
            return (Criteria) this;
        }

        public Criteria andParkingAddressNotBetween(String value1, String value2) {
            addCriterion("PARKING_ADDRESS not between", value1, value2, "parkingAddress");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("LONGITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("LONGITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("LONGITUDE =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("LONGITUDE <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("LONGITUDE >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LONGITUDE >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("LONGITUDE <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("LONGITUDE <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("LONGITUDE like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("LONGITUDE not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("LONGITUDE in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("LONGITUDE not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("LONGITUDE between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("LONGITUDE not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("LATITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("LATITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("LATITUDE =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("LATITUDE <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("LATITUDE >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LATITUDE >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("LATITUDE <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("LATITUDE <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("LATITUDE like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("LATITUDE not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("LATITUDE in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("LATITUDE not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("LATITUDE between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("LATITUDE not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andParkingStartTimeIsNull() {
            addCriterion("PARKING_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andParkingStartTimeIsNotNull() {
            addCriterion("PARKING_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andParkingStartTimeEqualTo(String value) {
            addCriterion("PARKING_START_TIME =", value, "parkingStartTime");
            return (Criteria) this;
        }

        public Criteria andParkingStartTimeNotEqualTo(String value) {
            addCriterion("PARKING_START_TIME <>", value, "parkingStartTime");
            return (Criteria) this;
        }

        public Criteria andParkingStartTimeGreaterThan(String value) {
            addCriterion("PARKING_START_TIME >", value, "parkingStartTime");
            return (Criteria) this;
        }

        public Criteria andParkingStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("PARKING_START_TIME >=", value, "parkingStartTime");
            return (Criteria) this;
        }

        public Criteria andParkingStartTimeLessThan(String value) {
            addCriterion("PARKING_START_TIME <", value, "parkingStartTime");
            return (Criteria) this;
        }

        public Criteria andParkingStartTimeLessThanOrEqualTo(String value) {
            addCriterion("PARKING_START_TIME <=", value, "parkingStartTime");
            return (Criteria) this;
        }

        public Criteria andParkingStartTimeLike(String value) {
            addCriterion("PARKING_START_TIME like", value, "parkingStartTime");
            return (Criteria) this;
        }

        public Criteria andParkingStartTimeNotLike(String value) {
            addCriterion("PARKING_START_TIME not like", value, "parkingStartTime");
            return (Criteria) this;
        }

        public Criteria andParkingStartTimeIn(List<String> values) {
            addCriterion("PARKING_START_TIME in", values, "parkingStartTime");
            return (Criteria) this;
        }

        public Criteria andParkingStartTimeNotIn(List<String> values) {
            addCriterion("PARKING_START_TIME not in", values, "parkingStartTime");
            return (Criteria) this;
        }

        public Criteria andParkingStartTimeBetween(String value1, String value2) {
            addCriterion("PARKING_START_TIME between", value1, value2, "parkingStartTime");
            return (Criteria) this;
        }

        public Criteria andParkingStartTimeNotBetween(String value1, String value2) {
            addCriterion("PARKING_START_TIME not between", value1, value2, "parkingStartTime");
            return (Criteria) this;
        }

        public Criteria andParkingEndTimeIsNull() {
            addCriterion("PARKING_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andParkingEndTimeIsNotNull() {
            addCriterion("PARKING_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andParkingEndTimeEqualTo(String value) {
            addCriterion("PARKING_END_TIME =", value, "parkingEndTime");
            return (Criteria) this;
        }

        public Criteria andParkingEndTimeNotEqualTo(String value) {
            addCriterion("PARKING_END_TIME <>", value, "parkingEndTime");
            return (Criteria) this;
        }

        public Criteria andParkingEndTimeGreaterThan(String value) {
            addCriterion("PARKING_END_TIME >", value, "parkingEndTime");
            return (Criteria) this;
        }

        public Criteria andParkingEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("PARKING_END_TIME >=", value, "parkingEndTime");
            return (Criteria) this;
        }

        public Criteria andParkingEndTimeLessThan(String value) {
            addCriterion("PARKING_END_TIME <", value, "parkingEndTime");
            return (Criteria) this;
        }

        public Criteria andParkingEndTimeLessThanOrEqualTo(String value) {
            addCriterion("PARKING_END_TIME <=", value, "parkingEndTime");
            return (Criteria) this;
        }

        public Criteria andParkingEndTimeLike(String value) {
            addCriterion("PARKING_END_TIME like", value, "parkingEndTime");
            return (Criteria) this;
        }

        public Criteria andParkingEndTimeNotLike(String value) {
            addCriterion("PARKING_END_TIME not like", value, "parkingEndTime");
            return (Criteria) this;
        }

        public Criteria andParkingEndTimeIn(List<String> values) {
            addCriterion("PARKING_END_TIME in", values, "parkingEndTime");
            return (Criteria) this;
        }

        public Criteria andParkingEndTimeNotIn(List<String> values) {
            addCriterion("PARKING_END_TIME not in", values, "parkingEndTime");
            return (Criteria) this;
        }

        public Criteria andParkingEndTimeBetween(String value1, String value2) {
            addCriterion("PARKING_END_TIME between", value1, value2, "parkingEndTime");
            return (Criteria) this;
        }

        public Criteria andParkingEndTimeNotBetween(String value1, String value2) {
            addCriterion("PARKING_END_TIME not between", value1, value2, "parkingEndTime");
            return (Criteria) this;
        }

        public Criteria andParkingNumberIsNull() {
            addCriterion("PARKING_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andParkingNumberIsNotNull() {
            addCriterion("PARKING_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andParkingNumberEqualTo(String value) {
            addCriterion("PARKING_NUMBER =", value, "parkingNumber");
            return (Criteria) this;
        }

        public Criteria andParkingNumberNotEqualTo(String value) {
            addCriterion("PARKING_NUMBER <>", value, "parkingNumber");
            return (Criteria) this;
        }

        public Criteria andParkingNumberGreaterThan(String value) {
            addCriterion("PARKING_NUMBER >", value, "parkingNumber");
            return (Criteria) this;
        }

        public Criteria andParkingNumberGreaterThanOrEqualTo(String value) {
            addCriterion("PARKING_NUMBER >=", value, "parkingNumber");
            return (Criteria) this;
        }

        public Criteria andParkingNumberLessThan(String value) {
            addCriterion("PARKING_NUMBER <", value, "parkingNumber");
            return (Criteria) this;
        }

        public Criteria andParkingNumberLessThanOrEqualTo(String value) {
            addCriterion("PARKING_NUMBER <=", value, "parkingNumber");
            return (Criteria) this;
        }

        public Criteria andParkingNumberLike(String value) {
            addCriterion("PARKING_NUMBER like", value, "parkingNumber");
            return (Criteria) this;
        }

        public Criteria andParkingNumberNotLike(String value) {
            addCriterion("PARKING_NUMBER not like", value, "parkingNumber");
            return (Criteria) this;
        }

        public Criteria andParkingNumberIn(List<String> values) {
            addCriterion("PARKING_NUMBER in", values, "parkingNumber");
            return (Criteria) this;
        }

        public Criteria andParkingNumberNotIn(List<String> values) {
            addCriterion("PARKING_NUMBER not in", values, "parkingNumber");
            return (Criteria) this;
        }

        public Criteria andParkingNumberBetween(String value1, String value2) {
            addCriterion("PARKING_NUMBER between", value1, value2, "parkingNumber");
            return (Criteria) this;
        }

        public Criteria andParkingNumberNotBetween(String value1, String value2) {
            addCriterion("PARKING_NUMBER not between", value1, value2, "parkingNumber");
            return (Criteria) this;
        }

        public Criteria andParkingLotTypeIsNull() {
            addCriterion("PARKING_LOT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andParkingLotTypeIsNotNull() {
            addCriterion("PARKING_LOT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andParkingLotTypeEqualTo(String value) {
            addCriterion("PARKING_LOT_TYPE =", value, "parkingLotType");
            return (Criteria) this;
        }

        public Criteria andParkingLotTypeNotEqualTo(String value) {
            addCriterion("PARKING_LOT_TYPE <>", value, "parkingLotType");
            return (Criteria) this;
        }

        public Criteria andParkingLotTypeGreaterThan(String value) {
            addCriterion("PARKING_LOT_TYPE >", value, "parkingLotType");
            return (Criteria) this;
        }

        public Criteria andParkingLotTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PARKING_LOT_TYPE >=", value, "parkingLotType");
            return (Criteria) this;
        }

        public Criteria andParkingLotTypeLessThan(String value) {
            addCriterion("PARKING_LOT_TYPE <", value, "parkingLotType");
            return (Criteria) this;
        }

        public Criteria andParkingLotTypeLessThanOrEqualTo(String value) {
            addCriterion("PARKING_LOT_TYPE <=", value, "parkingLotType");
            return (Criteria) this;
        }

        public Criteria andParkingLotTypeLike(String value) {
            addCriterion("PARKING_LOT_TYPE like", value, "parkingLotType");
            return (Criteria) this;
        }

        public Criteria andParkingLotTypeNotLike(String value) {
            addCriterion("PARKING_LOT_TYPE not like", value, "parkingLotType");
            return (Criteria) this;
        }

        public Criteria andParkingLotTypeIn(List<String> values) {
            addCriterion("PARKING_LOT_TYPE in", values, "parkingLotType");
            return (Criteria) this;
        }

        public Criteria andParkingLotTypeNotIn(List<String> values) {
            addCriterion("PARKING_LOT_TYPE not in", values, "parkingLotType");
            return (Criteria) this;
        }

        public Criteria andParkingLotTypeBetween(String value1, String value2) {
            addCriterion("PARKING_LOT_TYPE between", value1, value2, "parkingLotType");
            return (Criteria) this;
        }

        public Criteria andParkingLotTypeNotBetween(String value1, String value2) {
            addCriterion("PARKING_LOT_TYPE not between", value1, value2, "parkingLotType");
            return (Criteria) this;
        }

        public Criteria andParkingTypeIsNull() {
            addCriterion("PARKING_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andParkingTypeIsNotNull() {
            addCriterion("PARKING_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andParkingTypeEqualTo(String value) {
            addCriterion("PARKING_TYPE =", value, "parkingType");
            return (Criteria) this;
        }

        public Criteria andParkingTypeNotEqualTo(String value) {
            addCriterion("PARKING_TYPE <>", value, "parkingType");
            return (Criteria) this;
        }

        public Criteria andParkingTypeGreaterThan(String value) {
            addCriterion("PARKING_TYPE >", value, "parkingType");
            return (Criteria) this;
        }

        public Criteria andParkingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PARKING_TYPE >=", value, "parkingType");
            return (Criteria) this;
        }

        public Criteria andParkingTypeLessThan(String value) {
            addCriterion("PARKING_TYPE <", value, "parkingType");
            return (Criteria) this;
        }

        public Criteria andParkingTypeLessThanOrEqualTo(String value) {
            addCriterion("PARKING_TYPE <=", value, "parkingType");
            return (Criteria) this;
        }

        public Criteria andParkingTypeLike(String value) {
            addCriterion("PARKING_TYPE like", value, "parkingType");
            return (Criteria) this;
        }

        public Criteria andParkingTypeNotLike(String value) {
            addCriterion("PARKING_TYPE not like", value, "parkingType");
            return (Criteria) this;
        }

        public Criteria andParkingTypeIn(List<String> values) {
            addCriterion("PARKING_TYPE in", values, "parkingType");
            return (Criteria) this;
        }

        public Criteria andParkingTypeNotIn(List<String> values) {
            addCriterion("PARKING_TYPE not in", values, "parkingType");
            return (Criteria) this;
        }

        public Criteria andParkingTypeBetween(String value1, String value2) {
            addCriterion("PARKING_TYPE between", value1, value2, "parkingType");
            return (Criteria) this;
        }

        public Criteria andParkingTypeNotBetween(String value1, String value2) {
            addCriterion("PARKING_TYPE not between", value1, value2, "parkingType");
            return (Criteria) this;
        }

        public Criteria andPaymentModeIsNull() {
            addCriterion("PAYMENT_MODE is null");
            return (Criteria) this;
        }

        public Criteria andPaymentModeIsNotNull() {
            addCriterion("PAYMENT_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentModeEqualTo(String value) {
            addCriterion("PAYMENT_MODE =", value, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeNotEqualTo(String value) {
            addCriterion("PAYMENT_MODE <>", value, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeGreaterThan(String value) {
            addCriterion("PAYMENT_MODE >", value, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_MODE >=", value, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeLessThan(String value) {
            addCriterion("PAYMENT_MODE <", value, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_MODE <=", value, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeLike(String value) {
            addCriterion("PAYMENT_MODE like", value, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeNotLike(String value) {
            addCriterion("PAYMENT_MODE not like", value, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeIn(List<String> values) {
            addCriterion("PAYMENT_MODE in", values, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeNotIn(List<String> values) {
            addCriterion("PAYMENT_MODE not in", values, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeBetween(String value1, String value2) {
            addCriterion("PAYMENT_MODE between", value1, value2, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPaymentModeNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_MODE not between", value1, value2, "paymentMode");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("PAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("PAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("PAY_TYPE =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("PAY_TYPE <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("PAY_TYPE >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_TYPE >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("PAY_TYPE <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("PAY_TYPE <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("PAY_TYPE like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("PAY_TYPE not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("PAY_TYPE in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("PAY_TYPE not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("PAY_TYPE between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("PAY_TYPE not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andShopingmallIdIsNull() {
            addCriterion("SHOPINGMALL_ID is null");
            return (Criteria) this;
        }

        public Criteria andShopingmallIdIsNotNull() {
            addCriterion("SHOPINGMALL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShopingmallIdEqualTo(String value) {
            addCriterion("SHOPINGMALL_ID =", value, "shopingmallId");
            return (Criteria) this;
        }

        public Criteria andShopingmallIdNotEqualTo(String value) {
            addCriterion("SHOPINGMALL_ID <>", value, "shopingmallId");
            return (Criteria) this;
        }

        public Criteria andShopingmallIdGreaterThan(String value) {
            addCriterion("SHOPINGMALL_ID >", value, "shopingmallId");
            return (Criteria) this;
        }

        public Criteria andShopingmallIdGreaterThanOrEqualTo(String value) {
            addCriterion("SHOPINGMALL_ID >=", value, "shopingmallId");
            return (Criteria) this;
        }

        public Criteria andShopingmallIdLessThan(String value) {
            addCriterion("SHOPINGMALL_ID <", value, "shopingmallId");
            return (Criteria) this;
        }

        public Criteria andShopingmallIdLessThanOrEqualTo(String value) {
            addCriterion("SHOPINGMALL_ID <=", value, "shopingmallId");
            return (Criteria) this;
        }

        public Criteria andShopingmallIdLike(String value) {
            addCriterion("SHOPINGMALL_ID like", value, "shopingmallId");
            return (Criteria) this;
        }

        public Criteria andShopingmallIdNotLike(String value) {
            addCriterion("SHOPINGMALL_ID not like", value, "shopingmallId");
            return (Criteria) this;
        }

        public Criteria andShopingmallIdIn(List<String> values) {
            addCriterion("SHOPINGMALL_ID in", values, "shopingmallId");
            return (Criteria) this;
        }

        public Criteria andShopingmallIdNotIn(List<String> values) {
            addCriterion("SHOPINGMALL_ID not in", values, "shopingmallId");
            return (Criteria) this;
        }

        public Criteria andShopingmallIdBetween(String value1, String value2) {
            addCriterion("SHOPINGMALL_ID between", value1, value2, "shopingmallId");
            return (Criteria) this;
        }

        public Criteria andShopingmallIdNotBetween(String value1, String value2) {
            addCriterion("SHOPINGMALL_ID not between", value1, value2, "shopingmallId");
            return (Criteria) this;
        }

        public Criteria andParkingFeeDescriptionIsNull() {
            addCriterion("PARKING_FEE_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andParkingFeeDescriptionIsNotNull() {
            addCriterion("PARKING_FEE_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andParkingFeeDescriptionEqualTo(String value) {
            addCriterion("PARKING_FEE_DESCRIPTION =", value, "parkingFeeDescription");
            return (Criteria) this;
        }

        public Criteria andParkingFeeDescriptionNotEqualTo(String value) {
            addCriterion("PARKING_FEE_DESCRIPTION <>", value, "parkingFeeDescription");
            return (Criteria) this;
        }

        public Criteria andParkingFeeDescriptionGreaterThan(String value) {
            addCriterion("PARKING_FEE_DESCRIPTION >", value, "parkingFeeDescription");
            return (Criteria) this;
        }

        public Criteria andParkingFeeDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("PARKING_FEE_DESCRIPTION >=", value, "parkingFeeDescription");
            return (Criteria) this;
        }

        public Criteria andParkingFeeDescriptionLessThan(String value) {
            addCriterion("PARKING_FEE_DESCRIPTION <", value, "parkingFeeDescription");
            return (Criteria) this;
        }

        public Criteria andParkingFeeDescriptionLessThanOrEqualTo(String value) {
            addCriterion("PARKING_FEE_DESCRIPTION <=", value, "parkingFeeDescription");
            return (Criteria) this;
        }

        public Criteria andParkingFeeDescriptionLike(String value) {
            addCriterion("PARKING_FEE_DESCRIPTION like", value, "parkingFeeDescription");
            return (Criteria) this;
        }

        public Criteria andParkingFeeDescriptionNotLike(String value) {
            addCriterion("PARKING_FEE_DESCRIPTION not like", value, "parkingFeeDescription");
            return (Criteria) this;
        }

        public Criteria andParkingFeeDescriptionIn(List<String> values) {
            addCriterion("PARKING_FEE_DESCRIPTION in", values, "parkingFeeDescription");
            return (Criteria) this;
        }

        public Criteria andParkingFeeDescriptionNotIn(List<String> values) {
            addCriterion("PARKING_FEE_DESCRIPTION not in", values, "parkingFeeDescription");
            return (Criteria) this;
        }

        public Criteria andParkingFeeDescriptionBetween(String value1, String value2) {
            addCriterion("PARKING_FEE_DESCRIPTION between", value1, value2, "parkingFeeDescription");
            return (Criteria) this;
        }

        public Criteria andParkingFeeDescriptionNotBetween(String value1, String value2) {
            addCriterion("PARKING_FEE_DESCRIPTION not between", value1, value2, "parkingFeeDescription");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("CONTACT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("CONTACT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("CONTACT_NAME =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("CONTACT_NAME <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("CONTACT_NAME >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_NAME >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("CONTACT_NAME <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_NAME <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("CONTACT_NAME like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("CONTACT_NAME not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("CONTACT_NAME in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("CONTACT_NAME not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("CONTACT_NAME between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("CONTACT_NAME not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactMobileIsNull() {
            addCriterion("CONTACT_MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andContactMobileIsNotNull() {
            addCriterion("CONTACT_MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andContactMobileEqualTo(String value) {
            addCriterion("CONTACT_MOBILE =", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotEqualTo(String value) {
            addCriterion("CONTACT_MOBILE <>", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileGreaterThan(String value) {
            addCriterion("CONTACT_MOBILE >", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_MOBILE >=", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLessThan(String value) {
            addCriterion("CONTACT_MOBILE <", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_MOBILE <=", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileLike(String value) {
            addCriterion("CONTACT_MOBILE like", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotLike(String value) {
            addCriterion("CONTACT_MOBILE not like", value, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileIn(List<String> values) {
            addCriterion("CONTACT_MOBILE in", values, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotIn(List<String> values) {
            addCriterion("CONTACT_MOBILE not in", values, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileBetween(String value1, String value2) {
            addCriterion("CONTACT_MOBILE between", value1, value2, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactMobileNotBetween(String value1, String value2) {
            addCriterion("CONTACT_MOBILE not between", value1, value2, "contactMobile");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNull() {
            addCriterion("CONTACT_TEL is null");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNotNull() {
            addCriterion("CONTACT_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andContactTelEqualTo(String value) {
            addCriterion("CONTACT_TEL =", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotEqualTo(String value) {
            addCriterion("CONTACT_TEL <>", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThan(String value) {
            addCriterion("CONTACT_TEL >", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_TEL >=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThan(String value) {
            addCriterion("CONTACT_TEL <", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_TEL <=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLike(String value) {
            addCriterion("CONTACT_TEL like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotLike(String value) {
            addCriterion("CONTACT_TEL not like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelIn(List<String> values) {
            addCriterion("CONTACT_TEL in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotIn(List<String> values) {
            addCriterion("CONTACT_TEL not in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelBetween(String value1, String value2) {
            addCriterion("CONTACT_TEL between", value1, value2, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotBetween(String value1, String value2) {
            addCriterion("CONTACT_TEL not between", value1, value2, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactEmaliIsNull() {
            addCriterion("CONTACT_EMALI is null");
            return (Criteria) this;
        }

        public Criteria andContactEmaliIsNotNull() {
            addCriterion("CONTACT_EMALI is not null");
            return (Criteria) this;
        }

        public Criteria andContactEmaliEqualTo(String value) {
            addCriterion("CONTACT_EMALI =", value, "contactEmali");
            return (Criteria) this;
        }

        public Criteria andContactEmaliNotEqualTo(String value) {
            addCriterion("CONTACT_EMALI <>", value, "contactEmali");
            return (Criteria) this;
        }

        public Criteria andContactEmaliGreaterThan(String value) {
            addCriterion("CONTACT_EMALI >", value, "contactEmali");
            return (Criteria) this;
        }

        public Criteria andContactEmaliGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_EMALI >=", value, "contactEmali");
            return (Criteria) this;
        }

        public Criteria andContactEmaliLessThan(String value) {
            addCriterion("CONTACT_EMALI <", value, "contactEmali");
            return (Criteria) this;
        }

        public Criteria andContactEmaliLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_EMALI <=", value, "contactEmali");
            return (Criteria) this;
        }

        public Criteria andContactEmaliLike(String value) {
            addCriterion("CONTACT_EMALI like", value, "contactEmali");
            return (Criteria) this;
        }

        public Criteria andContactEmaliNotLike(String value) {
            addCriterion("CONTACT_EMALI not like", value, "contactEmali");
            return (Criteria) this;
        }

        public Criteria andContactEmaliIn(List<String> values) {
            addCriterion("CONTACT_EMALI in", values, "contactEmali");
            return (Criteria) this;
        }

        public Criteria andContactEmaliNotIn(List<String> values) {
            addCriterion("CONTACT_EMALI not in", values, "contactEmali");
            return (Criteria) this;
        }

        public Criteria andContactEmaliBetween(String value1, String value2) {
            addCriterion("CONTACT_EMALI between", value1, value2, "contactEmali");
            return (Criteria) this;
        }

        public Criteria andContactEmaliNotBetween(String value1, String value2) {
            addCriterion("CONTACT_EMALI not between", value1, value2, "contactEmali");
            return (Criteria) this;
        }

        public Criteria andContactWeixinIsNull() {
            addCriterion("CONTACT_WEIXIN is null");
            return (Criteria) this;
        }

        public Criteria andContactWeixinIsNotNull() {
            addCriterion("CONTACT_WEIXIN is not null");
            return (Criteria) this;
        }

        public Criteria andContactWeixinEqualTo(String value) {
            addCriterion("CONTACT_WEIXIN =", value, "contactWeixin");
            return (Criteria) this;
        }

        public Criteria andContactWeixinNotEqualTo(String value) {
            addCriterion("CONTACT_WEIXIN <>", value, "contactWeixin");
            return (Criteria) this;
        }

        public Criteria andContactWeixinGreaterThan(String value) {
            addCriterion("CONTACT_WEIXIN >", value, "contactWeixin");
            return (Criteria) this;
        }

        public Criteria andContactWeixinGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_WEIXIN >=", value, "contactWeixin");
            return (Criteria) this;
        }

        public Criteria andContactWeixinLessThan(String value) {
            addCriterion("CONTACT_WEIXIN <", value, "contactWeixin");
            return (Criteria) this;
        }

        public Criteria andContactWeixinLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_WEIXIN <=", value, "contactWeixin");
            return (Criteria) this;
        }

        public Criteria andContactWeixinLike(String value) {
            addCriterion("CONTACT_WEIXIN like", value, "contactWeixin");
            return (Criteria) this;
        }

        public Criteria andContactWeixinNotLike(String value) {
            addCriterion("CONTACT_WEIXIN not like", value, "contactWeixin");
            return (Criteria) this;
        }

        public Criteria andContactWeixinIn(List<String> values) {
            addCriterion("CONTACT_WEIXIN in", values, "contactWeixin");
            return (Criteria) this;
        }

        public Criteria andContactWeixinNotIn(List<String> values) {
            addCriterion("CONTACT_WEIXIN not in", values, "contactWeixin");
            return (Criteria) this;
        }

        public Criteria andContactWeixinBetween(String value1, String value2) {
            addCriterion("CONTACT_WEIXIN between", value1, value2, "contactWeixin");
            return (Criteria) this;
        }

        public Criteria andContactWeixinNotBetween(String value1, String value2) {
            addCriterion("CONTACT_WEIXIN not between", value1, value2, "contactWeixin");
            return (Criteria) this;
        }

        public Criteria andContactAlipayIsNull() {
            addCriterion("CONTACT_ALIPAY is null");
            return (Criteria) this;
        }

        public Criteria andContactAlipayIsNotNull() {
            addCriterion("CONTACT_ALIPAY is not null");
            return (Criteria) this;
        }

        public Criteria andContactAlipayEqualTo(String value) {
            addCriterion("CONTACT_ALIPAY =", value, "contactAlipay");
            return (Criteria) this;
        }

        public Criteria andContactAlipayNotEqualTo(String value) {
            addCriterion("CONTACT_ALIPAY <>", value, "contactAlipay");
            return (Criteria) this;
        }

        public Criteria andContactAlipayGreaterThan(String value) {
            addCriterion("CONTACT_ALIPAY >", value, "contactAlipay");
            return (Criteria) this;
        }

        public Criteria andContactAlipayGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_ALIPAY >=", value, "contactAlipay");
            return (Criteria) this;
        }

        public Criteria andContactAlipayLessThan(String value) {
            addCriterion("CONTACT_ALIPAY <", value, "contactAlipay");
            return (Criteria) this;
        }

        public Criteria andContactAlipayLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_ALIPAY <=", value, "contactAlipay");
            return (Criteria) this;
        }

        public Criteria andContactAlipayLike(String value) {
            addCriterion("CONTACT_ALIPAY like", value, "contactAlipay");
            return (Criteria) this;
        }

        public Criteria andContactAlipayNotLike(String value) {
            addCriterion("CONTACT_ALIPAY not like", value, "contactAlipay");
            return (Criteria) this;
        }

        public Criteria andContactAlipayIn(List<String> values) {
            addCriterion("CONTACT_ALIPAY in", values, "contactAlipay");
            return (Criteria) this;
        }

        public Criteria andContactAlipayNotIn(List<String> values) {
            addCriterion("CONTACT_ALIPAY not in", values, "contactAlipay");
            return (Criteria) this;
        }

        public Criteria andContactAlipayBetween(String value1, String value2) {
            addCriterion("CONTACT_ALIPAY between", value1, value2, "contactAlipay");
            return (Criteria) this;
        }

        public Criteria andContactAlipayNotBetween(String value1, String value2) {
            addCriterion("CONTACT_ALIPAY not between", value1, value2, "contactAlipay");
            return (Criteria) this;
        }

        public Criteria andParkingNameIsNull() {
            addCriterion("PARKING_NAME is null");
            return (Criteria) this;
        }

        public Criteria andParkingNameIsNotNull() {
            addCriterion("PARKING_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andParkingNameEqualTo(String value) {
            addCriterion("PARKING_NAME =", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameNotEqualTo(String value) {
            addCriterion("PARKING_NAME <>", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameGreaterThan(String value) {
            addCriterion("PARKING_NAME >", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameGreaterThanOrEqualTo(String value) {
            addCriterion("PARKING_NAME >=", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameLessThan(String value) {
            addCriterion("PARKING_NAME <", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameLessThanOrEqualTo(String value) {
            addCriterion("PARKING_NAME <=", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameLike(String value) {
            addCriterion("PARKING_NAME like", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameNotLike(String value) {
            addCriterion("PARKING_NAME not like", value, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameIn(List<String> values) {
            addCriterion("PARKING_NAME in", values, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameNotIn(List<String> values) {
            addCriterion("PARKING_NAME not in", values, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameBetween(String value1, String value2) {
            addCriterion("PARKING_NAME between", value1, value2, "parkingName");
            return (Criteria) this;
        }

        public Criteria andParkingNameNotBetween(String value1, String value2) {
            addCriterion("PARKING_NAME not between", value1, value2, "parkingName");
            return (Criteria) this;
        }

        public Criteria andTimeOutIsNull() {
            addCriterion("TIME_OUT is null");
            return (Criteria) this;
        }

        public Criteria andTimeOutIsNotNull() {
            addCriterion("TIME_OUT is not null");
            return (Criteria) this;
        }

        public Criteria andTimeOutEqualTo(String value) {
            addCriterion("TIME_OUT =", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutNotEqualTo(String value) {
            addCriterion("TIME_OUT <>", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutGreaterThan(String value) {
            addCriterion("TIME_OUT >", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutGreaterThanOrEqualTo(String value) {
            addCriterion("TIME_OUT >=", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutLessThan(String value) {
            addCriterion("TIME_OUT <", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutLessThanOrEqualTo(String value) {
            addCriterion("TIME_OUT <=", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutLike(String value) {
            addCriterion("TIME_OUT like", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutNotLike(String value) {
            addCriterion("TIME_OUT not like", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutIn(List<String> values) {
            addCriterion("TIME_OUT in", values, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutNotIn(List<String> values) {
            addCriterion("TIME_OUT not in", values, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutBetween(String value1, String value2) {
            addCriterion("TIME_OUT between", value1, value2, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutNotBetween(String value1, String value2) {
            addCriterion("TIME_OUT not between", value1, value2, "timeOut");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIsNull() {
            addCriterion("CREATE_USERID is null");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIsNotNull() {
            addCriterion("CREATE_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUseridEqualTo(String value) {
            addCriterion("CREATE_USERID =", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotEqualTo(String value) {
            addCriterion("CREATE_USERID <>", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridGreaterThan(String value) {
            addCriterion("CREATE_USERID >", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USERID >=", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridLessThan(String value) {
            addCriterion("CREATE_USERID <", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USERID <=", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridLike(String value) {
            addCriterion("CREATE_USERID like", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotLike(String value) {
            addCriterion("CREATE_USERID not like", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIn(List<String> values) {
            addCriterion("CREATE_USERID in", values, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotIn(List<String> values) {
            addCriterion("CREATE_USERID not in", values, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridBetween(String value1, String value2) {
            addCriterion("CREATE_USERID between", value1, value2, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotBetween(String value1, String value2) {
            addCriterion("CREATE_USERID not between", value1, value2, "createUserid");
            return (Criteria) this;
        }

        public Criteria andModifyUseridIsNull() {
            addCriterion("MODIFY_USERID is null");
            return (Criteria) this;
        }

        public Criteria andModifyUseridIsNotNull() {
            addCriterion("MODIFY_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUseridEqualTo(String value) {
            addCriterion("MODIFY_USERID =", value, "modifyUserid");
            return (Criteria) this;
        }

        public Criteria andModifyUseridNotEqualTo(String value) {
            addCriterion("MODIFY_USERID <>", value, "modifyUserid");
            return (Criteria) this;
        }

        public Criteria andModifyUseridGreaterThan(String value) {
            addCriterion("MODIFY_USERID >", value, "modifyUserid");
            return (Criteria) this;
        }

        public Criteria andModifyUseridGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFY_USERID >=", value, "modifyUserid");
            return (Criteria) this;
        }

        public Criteria andModifyUseridLessThan(String value) {
            addCriterion("MODIFY_USERID <", value, "modifyUserid");
            return (Criteria) this;
        }

        public Criteria andModifyUseridLessThanOrEqualTo(String value) {
            addCriterion("MODIFY_USERID <=", value, "modifyUserid");
            return (Criteria) this;
        }

        public Criteria andModifyUseridLike(String value) {
            addCriterion("MODIFY_USERID like", value, "modifyUserid");
            return (Criteria) this;
        }

        public Criteria andModifyUseridNotLike(String value) {
            addCriterion("MODIFY_USERID not like", value, "modifyUserid");
            return (Criteria) this;
        }

        public Criteria andModifyUseridIn(List<String> values) {
            addCriterion("MODIFY_USERID in", values, "modifyUserid");
            return (Criteria) this;
        }

        public Criteria andModifyUseridNotIn(List<String> values) {
            addCriterion("MODIFY_USERID not in", values, "modifyUserid");
            return (Criteria) this;
        }

        public Criteria andModifyUseridBetween(String value1, String value2) {
            addCriterion("MODIFY_USERID between", value1, value2, "modifyUserid");
            return (Criteria) this;
        }

        public Criteria andModifyUseridNotBetween(String value1, String value2) {
            addCriterion("MODIFY_USERID not between", value1, value2, "modifyUserid");
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