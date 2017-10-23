package com.qt.sales.model;

import java.util.ArrayList;
import java.util.List;

public class Qt1tblAgencyExample {
    
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    private int start;
    
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
     * 创建时间：2016年10月24日 上午11:30:01 <br/>
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
     * 创建时间：2016年10月24日 上午11:30:01 <br/>
     * 参数: @param  end 设置值.  <br/>
     */
    public void setEnd(int end) {
        this.end = end;
    }

    public Qt1tblAgencyExample() {
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

        public Criteria andSystemidIsNull() {
            addCriterion("SYSTEMID is null");
            return (Criteria) this;
        }

        public Criteria andSystemidIsNotNull() {
            addCriterion("SYSTEMID is not null");
            return (Criteria) this;
        }

        public Criteria andSystemidEqualTo(String value) {
            addCriterion("SYSTEMID =", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidNotEqualTo(String value) {
            addCriterion("SYSTEMID <>", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidGreaterThan(String value) {
            addCriterion("SYSTEMID >", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidGreaterThanOrEqualTo(String value) {
            addCriterion("SYSTEMID >=", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidLessThan(String value) {
            addCriterion("SYSTEMID <", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidLessThanOrEqualTo(String value) {
            addCriterion("SYSTEMID <=", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidLike(String value) {
            addCriterion("SYSTEMID like", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidNotLike(String value) {
            addCriterion("SYSTEMID not like", value, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidIn(List<String> values) {
            addCriterion("SYSTEMID in", values, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidNotIn(List<String> values) {
            addCriterion("SYSTEMID not in", values, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidBetween(String value1, String value2) {
            addCriterion("SYSTEMID between", value1, value2, "systemid");
            return (Criteria) this;
        }

        public Criteria andSystemidNotBetween(String value1, String value2) {
            addCriterion("SYSTEMID not between", value1, value2, "systemid");
            return (Criteria) this;
        }

        public Criteria andContactsnameIsNull() {
            addCriterion("CONTACTSNAME is null");
            return (Criteria) this;
        }

        public Criteria andContactsnameIsNotNull() {
            addCriterion("CONTACTSNAME is not null");
            return (Criteria) this;
        }

        public Criteria andContactsnameEqualTo(String value) {
            addCriterion("CONTACTSNAME =", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameNotEqualTo(String value) {
            addCriterion("CONTACTSNAME <>", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameGreaterThan(String value) {
            addCriterion("CONTACTSNAME >", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACTSNAME >=", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameLessThan(String value) {
            addCriterion("CONTACTSNAME <", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameLessThanOrEqualTo(String value) {
            addCriterion("CONTACTSNAME <=", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameLike(String value) {
            addCriterion("CONTACTSNAME like", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameNotLike(String value) {
            addCriterion("CONTACTSNAME not like", value, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameIn(List<String> values) {
            addCriterion("CONTACTSNAME in", values, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameNotIn(List<String> values) {
            addCriterion("CONTACTSNAME not in", values, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameBetween(String value1, String value2) {
            addCriterion("CONTACTSNAME between", value1, value2, "contactsname");
            return (Criteria) this;
        }

        public Criteria andContactsnameNotBetween(String value1, String value2) {
            addCriterion("CONTACTSNAME not between", value1, value2, "contactsname");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNull() {
            addCriterion("COMPANYNAME is null");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNotNull() {
            addCriterion("COMPANYNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompanynameEqualTo(String value) {
            addCriterion("COMPANYNAME =", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotEqualTo(String value) {
            addCriterion("COMPANYNAME <>", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThan(String value) {
            addCriterion("COMPANYNAME >", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANYNAME >=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThan(String value) {
            addCriterion("COMPANYNAME <", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThanOrEqualTo(String value) {
            addCriterion("COMPANYNAME <=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLike(String value) {
            addCriterion("COMPANYNAME like", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotLike(String value) {
            addCriterion("COMPANYNAME not like", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameIn(List<String> values) {
            addCriterion("COMPANYNAME in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotIn(List<String> values) {
            addCriterion("COMPANYNAME not in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameBetween(String value1, String value2) {
            addCriterion("COMPANYNAME between", value1, value2, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotBetween(String value1, String value2) {
            addCriterion("COMPANYNAME not between", value1, value2, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanyphoneIsNull() {
            addCriterion("COMPANYPHONE is null");
            return (Criteria) this;
        }

        public Criteria andCompanyphoneIsNotNull() {
            addCriterion("COMPANYPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyphoneEqualTo(String value) {
            addCriterion("COMPANYPHONE =", value, "companyphone");
            return (Criteria) this;
        }

        public Criteria andCompanyphoneNotEqualTo(String value) {
            addCriterion("COMPANYPHONE <>", value, "companyphone");
            return (Criteria) this;
        }

        public Criteria andCompanyphoneGreaterThan(String value) {
            addCriterion("COMPANYPHONE >", value, "companyphone");
            return (Criteria) this;
        }

        public Criteria andCompanyphoneGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANYPHONE >=", value, "companyphone");
            return (Criteria) this;
        }

        public Criteria andCompanyphoneLessThan(String value) {
            addCriterion("COMPANYPHONE <", value, "companyphone");
            return (Criteria) this;
        }

        public Criteria andCompanyphoneLessThanOrEqualTo(String value) {
            addCriterion("COMPANYPHONE <=", value, "companyphone");
            return (Criteria) this;
        }

        public Criteria andCompanyphoneLike(String value) {
            addCriterion("COMPANYPHONE like", value, "companyphone");
            return (Criteria) this;
        }

        public Criteria andCompanyphoneNotLike(String value) {
            addCriterion("COMPANYPHONE not like", value, "companyphone");
            return (Criteria) this;
        }

        public Criteria andCompanyphoneIn(List<String> values) {
            addCriterion("COMPANYPHONE in", values, "companyphone");
            return (Criteria) this;
        }

        public Criteria andCompanyphoneNotIn(List<String> values) {
            addCriterion("COMPANYPHONE not in", values, "companyphone");
            return (Criteria) this;
        }

        public Criteria andCompanyphoneBetween(String value1, String value2) {
            addCriterion("COMPANYPHONE between", value1, value2, "companyphone");
            return (Criteria) this;
        }

        public Criteria andCompanyphoneNotBetween(String value1, String value2) {
            addCriterion("COMPANYPHONE not between", value1, value2, "companyphone");
            return (Criteria) this;
        }

        public Criteria andCompanyemailIsNull() {
            addCriterion("COMPANYEMAIL is null");
            return (Criteria) this;
        }

        public Criteria andCompanyemailIsNotNull() {
            addCriterion("COMPANYEMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyemailEqualTo(String value) {
            addCriterion("COMPANYEMAIL =", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailNotEqualTo(String value) {
            addCriterion("COMPANYEMAIL <>", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailGreaterThan(String value) {
            addCriterion("COMPANYEMAIL >", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANYEMAIL >=", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailLessThan(String value) {
            addCriterion("COMPANYEMAIL <", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailLessThanOrEqualTo(String value) {
            addCriterion("COMPANYEMAIL <=", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailLike(String value) {
            addCriterion("COMPANYEMAIL like", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailNotLike(String value) {
            addCriterion("COMPANYEMAIL not like", value, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailIn(List<String> values) {
            addCriterion("COMPANYEMAIL in", values, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailNotIn(List<String> values) {
            addCriterion("COMPANYEMAIL not in", values, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailBetween(String value1, String value2) {
            addCriterion("COMPANYEMAIL between", value1, value2, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyemailNotBetween(String value1, String value2) {
            addCriterion("COMPANYEMAIL not between", value1, value2, "companyemail");
            return (Criteria) this;
        }

        public Criteria andCompanyaddrIsNull() {
            addCriterion("COMPANYADDR is null");
            return (Criteria) this;
        }

        public Criteria andCompanyaddrIsNotNull() {
            addCriterion("COMPANYADDR is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyaddrEqualTo(String value) {
            addCriterion("COMPANYADDR =", value, "companyaddr");
            return (Criteria) this;
        }

        public Criteria andCompanyaddrNotEqualTo(String value) {
            addCriterion("COMPANYADDR <>", value, "companyaddr");
            return (Criteria) this;
        }

        public Criteria andCompanyaddrGreaterThan(String value) {
            addCriterion("COMPANYADDR >", value, "companyaddr");
            return (Criteria) this;
        }

        public Criteria andCompanyaddrGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANYADDR >=", value, "companyaddr");
            return (Criteria) this;
        }

        public Criteria andCompanyaddrLessThan(String value) {
            addCriterion("COMPANYADDR <", value, "companyaddr");
            return (Criteria) this;
        }

        public Criteria andCompanyaddrLessThanOrEqualTo(String value) {
            addCriterion("COMPANYADDR <=", value, "companyaddr");
            return (Criteria) this;
        }

        public Criteria andCompanyaddrLike(String value) {
            addCriterion("COMPANYADDR like", value, "companyaddr");
            return (Criteria) this;
        }

        public Criteria andCompanyaddrNotLike(String value) {
            addCriterion("COMPANYADDR not like", value, "companyaddr");
            return (Criteria) this;
        }

        public Criteria andCompanyaddrIn(List<String> values) {
            addCriterion("COMPANYADDR in", values, "companyaddr");
            return (Criteria) this;
        }

        public Criteria andCompanyaddrNotIn(List<String> values) {
            addCriterion("COMPANYADDR not in", values, "companyaddr");
            return (Criteria) this;
        }

        public Criteria andCompanyaddrBetween(String value1, String value2) {
            addCriterion("COMPANYADDR between", value1, value2, "companyaddr");
            return (Criteria) this;
        }

        public Criteria andCompanyaddrNotBetween(String value1, String value2) {
            addCriterion("COMPANYADDR not between", value1, value2, "companyaddr");
            return (Criteria) this;
        }

        public Criteria andCertificatesIsNull() {
            addCriterion("CERTIFICATES is null");
            return (Criteria) this;
        }

        public Criteria andCertificatesIsNotNull() {
            addCriterion("CERTIFICATES is not null");
            return (Criteria) this;
        }

        public Criteria andCertificatesEqualTo(String value) {
            addCriterion("CERTIFICATES =", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesNotEqualTo(String value) {
            addCriterion("CERTIFICATES <>", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesGreaterThan(String value) {
            addCriterion("CERTIFICATES >", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesGreaterThanOrEqualTo(String value) {
            addCriterion("CERTIFICATES >=", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesLessThan(String value) {
            addCriterion("CERTIFICATES <", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesLessThanOrEqualTo(String value) {
            addCriterion("CERTIFICATES <=", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesLike(String value) {
            addCriterion("CERTIFICATES like", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesNotLike(String value) {
            addCriterion("CERTIFICATES not like", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesIn(List<String> values) {
            addCriterion("CERTIFICATES in", values, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesNotIn(List<String> values) {
            addCriterion("CERTIFICATES not in", values, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesBetween(String value1, String value2) {
            addCriterion("CERTIFICATES between", value1, value2, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesNotBetween(String value1, String value2) {
            addCriterion("CERTIFICATES not between", value1, value2, "certificates");
            return (Criteria) this;
        }

        public Criteria andLegalInfoIsNull() {
            addCriterion("LEGAL_INFO is null");
            return (Criteria) this;
        }

        public Criteria andLegalInfoIsNotNull() {
            addCriterion("LEGAL_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andLegalInfoEqualTo(String value) {
            addCriterion("LEGAL_INFO =", value, "legalInfo");
            return (Criteria) this;
        }

        public Criteria andLegalInfoNotEqualTo(String value) {
            addCriterion("LEGAL_INFO <>", value, "legalInfo");
            return (Criteria) this;
        }

        public Criteria andLegalInfoGreaterThan(String value) {
            addCriterion("LEGAL_INFO >", value, "legalInfo");
            return (Criteria) this;
        }

        public Criteria andLegalInfoGreaterThanOrEqualTo(String value) {
            addCriterion("LEGAL_INFO >=", value, "legalInfo");
            return (Criteria) this;
        }

        public Criteria andLegalInfoLessThan(String value) {
            addCriterion("LEGAL_INFO <", value, "legalInfo");
            return (Criteria) this;
        }

        public Criteria andLegalInfoLessThanOrEqualTo(String value) {
            addCriterion("LEGAL_INFO <=", value, "legalInfo");
            return (Criteria) this;
        }

        public Criteria andLegalInfoLike(String value) {
            addCriterion("LEGAL_INFO like", value, "legalInfo");
            return (Criteria) this;
        }

        public Criteria andLegalInfoNotLike(String value) {
            addCriterion("LEGAL_INFO not like", value, "legalInfo");
            return (Criteria) this;
        }

        public Criteria andLegalInfoIn(List<String> values) {
            addCriterion("LEGAL_INFO in", values, "legalInfo");
            return (Criteria) this;
        }

        public Criteria andLegalInfoNotIn(List<String> values) {
            addCriterion("LEGAL_INFO not in", values, "legalInfo");
            return (Criteria) this;
        }

        public Criteria andLegalInfoBetween(String value1, String value2) {
            addCriterion("LEGAL_INFO between", value1, value2, "legalInfo");
            return (Criteria) this;
        }

        public Criteria andLegalInfoNotBetween(String value1, String value2) {
            addCriterion("LEGAL_INFO not between", value1, value2, "legalInfo");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeIsNull() {
            addCriterion("ORGANIZATIONCODE is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeIsNotNull() {
            addCriterion("ORGANIZATIONCODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeEqualTo(String value) {
            addCriterion("ORGANIZATIONCODE =", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeNotEqualTo(String value) {
            addCriterion("ORGANIZATIONCODE <>", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeGreaterThan(String value) {
            addCriterion("ORGANIZATIONCODE >", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORGANIZATIONCODE >=", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeLessThan(String value) {
            addCriterion("ORGANIZATIONCODE <", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeLessThanOrEqualTo(String value) {
            addCriterion("ORGANIZATIONCODE <=", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeLike(String value) {
            addCriterion("ORGANIZATIONCODE like", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeNotLike(String value) {
            addCriterion("ORGANIZATIONCODE not like", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeIn(List<String> values) {
            addCriterion("ORGANIZATIONCODE in", values, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeNotIn(List<String> values) {
            addCriterion("ORGANIZATIONCODE not in", values, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeBetween(String value1, String value2) {
            addCriterion("ORGANIZATIONCODE between", value1, value2, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeNotBetween(String value1, String value2) {
            addCriterion("ORGANIZATIONCODE not between", value1, value2, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andAgreementcodeIsNull() {
            addCriterion("AGREEMENTCODE is null");
            return (Criteria) this;
        }

        public Criteria andAgreementcodeIsNotNull() {
            addCriterion("AGREEMENTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementcodeEqualTo(String value) {
            addCriterion("AGREEMENTCODE =", value, "agreementcode");
            return (Criteria) this;
        }

        public Criteria andAgreementcodeNotEqualTo(String value) {
            addCriterion("AGREEMENTCODE <>", value, "agreementcode");
            return (Criteria) this;
        }

        public Criteria andAgreementcodeGreaterThan(String value) {
            addCriterion("AGREEMENTCODE >", value, "agreementcode");
            return (Criteria) this;
        }

        public Criteria andAgreementcodeGreaterThanOrEqualTo(String value) {
            addCriterion("AGREEMENTCODE >=", value, "agreementcode");
            return (Criteria) this;
        }

        public Criteria andAgreementcodeLessThan(String value) {
            addCriterion("AGREEMENTCODE <", value, "agreementcode");
            return (Criteria) this;
        }

        public Criteria andAgreementcodeLessThanOrEqualTo(String value) {
            addCriterion("AGREEMENTCODE <=", value, "agreementcode");
            return (Criteria) this;
        }

        public Criteria andAgreementcodeLike(String value) {
            addCriterion("AGREEMENTCODE like", value, "agreementcode");
            return (Criteria) this;
        }

        public Criteria andAgreementcodeNotLike(String value) {
            addCriterion("AGREEMENTCODE not like", value, "agreementcode");
            return (Criteria) this;
        }

        public Criteria andAgreementcodeIn(List<String> values) {
            addCriterion("AGREEMENTCODE in", values, "agreementcode");
            return (Criteria) this;
        }

        public Criteria andAgreementcodeNotIn(List<String> values) {
            addCriterion("AGREEMENTCODE not in", values, "agreementcode");
            return (Criteria) this;
        }

        public Criteria andAgreementcodeBetween(String value1, String value2) {
            addCriterion("AGREEMENTCODE between", value1, value2, "agreementcode");
            return (Criteria) this;
        }

        public Criteria andAgreementcodeNotBetween(String value1, String value2) {
            addCriterion("AGREEMENTCODE not between", value1, value2, "agreementcode");
            return (Criteria) this;
        }

        public Criteria andProvinceidIsNull() {
            addCriterion("PROVINCEID is null");
            return (Criteria) this;
        }

        public Criteria andProvinceidIsNotNull() {
            addCriterion("PROVINCEID is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceidEqualTo(String value) {
            addCriterion("PROVINCEID =", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidNotEqualTo(String value) {
            addCriterion("PROVINCEID <>", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidGreaterThan(String value) {
            addCriterion("PROVINCEID >", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCEID >=", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidLessThan(String value) {
            addCriterion("PROVINCEID <", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidLessThanOrEqualTo(String value) {
            addCriterion("PROVINCEID <=", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidLike(String value) {
            addCriterion("PROVINCEID like", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidNotLike(String value) {
            addCriterion("PROVINCEID not like", value, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidIn(List<String> values) {
            addCriterion("PROVINCEID in", values, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidNotIn(List<String> values) {
            addCriterion("PROVINCEID not in", values, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidBetween(String value1, String value2) {
            addCriterion("PROVINCEID between", value1, value2, "provinceid");
            return (Criteria) this;
        }

        public Criteria andProvinceidNotBetween(String value1, String value2) {
            addCriterion("PROVINCEID not between", value1, value2, "provinceid");
            return (Criteria) this;
        }

        public Criteria andCityidIsNull() {
            addCriterion("CITYID is null");
            return (Criteria) this;
        }

        public Criteria andCityidIsNotNull() {
            addCriterion("CITYID is not null");
            return (Criteria) this;
        }

        public Criteria andCityidEqualTo(String value) {
            addCriterion("CITYID =", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotEqualTo(String value) {
            addCriterion("CITYID <>", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThan(String value) {
            addCriterion("CITYID >", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThanOrEqualTo(String value) {
            addCriterion("CITYID >=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThan(String value) {
            addCriterion("CITYID <", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThanOrEqualTo(String value) {
            addCriterion("CITYID <=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLike(String value) {
            addCriterion("CITYID like", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotLike(String value) {
            addCriterion("CITYID not like", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidIn(List<String> values) {
            addCriterion("CITYID in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotIn(List<String> values) {
            addCriterion("CITYID not in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidBetween(String value1, String value2) {
            addCriterion("CITYID between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotBetween(String value1, String value2) {
            addCriterion("CITYID not between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andOnlinechannelIsNull() {
            addCriterion("ONLINECHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andOnlinechannelIsNotNull() {
            addCriterion("ONLINECHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andOnlinechannelEqualTo(String value) {
            addCriterion("ONLINECHANNEL =", value, "onlinechannel");
            return (Criteria) this;
        }

        public Criteria andOnlinechannelNotEqualTo(String value) {
            addCriterion("ONLINECHANNEL <>", value, "onlinechannel");
            return (Criteria) this;
        }

        public Criteria andOnlinechannelGreaterThan(String value) {
            addCriterion("ONLINECHANNEL >", value, "onlinechannel");
            return (Criteria) this;
        }

        public Criteria andOnlinechannelGreaterThanOrEqualTo(String value) {
            addCriterion("ONLINECHANNEL >=", value, "onlinechannel");
            return (Criteria) this;
        }

        public Criteria andOnlinechannelLessThan(String value) {
            addCriterion("ONLINECHANNEL <", value, "onlinechannel");
            return (Criteria) this;
        }

        public Criteria andOnlinechannelLessThanOrEqualTo(String value) {
            addCriterion("ONLINECHANNEL <=", value, "onlinechannel");
            return (Criteria) this;
        }

        public Criteria andOnlinechannelLike(String value) {
            addCriterion("ONLINECHANNEL like", value, "onlinechannel");
            return (Criteria) this;
        }

        public Criteria andOnlinechannelNotLike(String value) {
            addCriterion("ONLINECHANNEL not like", value, "onlinechannel");
            return (Criteria) this;
        }

        public Criteria andOnlinechannelIn(List<String> values) {
            addCriterion("ONLINECHANNEL in", values, "onlinechannel");
            return (Criteria) this;
        }

        public Criteria andOnlinechannelNotIn(List<String> values) {
            addCriterion("ONLINECHANNEL not in", values, "onlinechannel");
            return (Criteria) this;
        }

        public Criteria andOnlinechannelBetween(String value1, String value2) {
            addCriterion("ONLINECHANNEL between", value1, value2, "onlinechannel");
            return (Criteria) this;
        }

        public Criteria andOnlinechannelNotBetween(String value1, String value2) {
            addCriterion("ONLINECHANNEL not between", value1, value2, "onlinechannel");
            return (Criteria) this;
        }

        public Criteria andVestagencyIsNull() {
            addCriterion("VESTAGENCY is null");
            return (Criteria) this;
        }

        public Criteria andVestagencyIsNotNull() {
            addCriterion("VESTAGENCY is not null");
            return (Criteria) this;
        }

        public Criteria andVestagencyEqualTo(String value) {
            addCriterion("VESTAGENCY =", value, "vestagency");
            return (Criteria) this;
        }

        public Criteria andVestagencyNotEqualTo(String value) {
            addCriterion("VESTAGENCY <>", value, "vestagency");
            return (Criteria) this;
        }

        public Criteria andVestagencyGreaterThan(String value) {
            addCriterion("VESTAGENCY >", value, "vestagency");
            return (Criteria) this;
        }

        public Criteria andVestagencyGreaterThanOrEqualTo(String value) {
            addCriterion("VESTAGENCY >=", value, "vestagency");
            return (Criteria) this;
        }

        public Criteria andVestagencyLessThan(String value) {
            addCriterion("VESTAGENCY <", value, "vestagency");
            return (Criteria) this;
        }

        public Criteria andVestagencyLessThanOrEqualTo(String value) {
            addCriterion("VESTAGENCY <=", value, "vestagency");
            return (Criteria) this;
        }

        public Criteria andVestagencyLike(String value) {
            addCriterion("VESTAGENCY like", value, "vestagency");
            return (Criteria) this;
        }

        public Criteria andVestagencyNotLike(String value) {
            addCriterion("VESTAGENCY not like", value, "vestagency");
            return (Criteria) this;
        }

        public Criteria andVestagencyIn(List<String> values) {
            addCriterion("VESTAGENCY in", values, "vestagency");
            return (Criteria) this;
        }

        public Criteria andVestagencyNotIn(List<String> values) {
            addCriterion("VESTAGENCY not in", values, "vestagency");
            return (Criteria) this;
        }

        public Criteria andVestagencyBetween(String value1, String value2) {
            addCriterion("VESTAGENCY between", value1, value2, "vestagency");
            return (Criteria) this;
        }

        public Criteria andVestagencyNotBetween(String value1, String value2) {
            addCriterion("VESTAGENCY not between", value1, value2, "vestagency");
            return (Criteria) this;
        }

        public Criteria andAgencyStatusIsNull() {
            addCriterion("AGENCY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAgencyStatusIsNotNull() {
            addCriterion("AGENCY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyStatusEqualTo(String value) {
            addCriterion("AGENCY_STATUS =", value, "agencyStatus");
            return (Criteria) this;
        }

        public Criteria andAgencyStatusNotEqualTo(String value) {
            addCriterion("AGENCY_STATUS <>", value, "agencyStatus");
            return (Criteria) this;
        }

        public Criteria andAgencyStatusGreaterThan(String value) {
            addCriterion("AGENCY_STATUS >", value, "agencyStatus");
            return (Criteria) this;
        }

        public Criteria andAgencyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("AGENCY_STATUS >=", value, "agencyStatus");
            return (Criteria) this;
        }

        public Criteria andAgencyStatusLessThan(String value) {
            addCriterion("AGENCY_STATUS <", value, "agencyStatus");
            return (Criteria) this;
        }

        public Criteria andAgencyStatusLessThanOrEqualTo(String value) {
            addCriterion("AGENCY_STATUS <=", value, "agencyStatus");
            return (Criteria) this;
        }

        public Criteria andAgencyStatusLike(String value) {
            addCriterion("AGENCY_STATUS like", value, "agencyStatus");
            return (Criteria) this;
        }

        public Criteria andAgencyStatusNotLike(String value) {
            addCriterion("AGENCY_STATUS not like", value, "agencyStatus");
            return (Criteria) this;
        }

        public Criteria andAgencyStatusIn(List<String> values) {
            addCriterion("AGENCY_STATUS in", values, "agencyStatus");
            return (Criteria) this;
        }

        public Criteria andAgencyStatusNotIn(List<String> values) {
            addCriterion("AGENCY_STATUS not in", values, "agencyStatus");
            return (Criteria) this;
        }

        public Criteria andAgencyStatusBetween(String value1, String value2) {
            addCriterion("AGENCY_STATUS between", value1, value2, "agencyStatus");
            return (Criteria) this;
        }

        public Criteria andAgencyStatusNotBetween(String value1, String value2) {
            addCriterion("AGENCY_STATUS not between", value1, value2, "agencyStatus");
            return (Criteria) this;
        }

        public Criteria andAccountbankIsNull() {
            addCriterion("ACCOUNTBANK is null");
            return (Criteria) this;
        }

        public Criteria andAccountbankIsNotNull() {
            addCriterion("ACCOUNTBANK is not null");
            return (Criteria) this;
        }

        public Criteria andAccountbankEqualTo(String value) {
            addCriterion("ACCOUNTBANK =", value, "accountbank");
            return (Criteria) this;
        }

        public Criteria andAccountbankNotEqualTo(String value) {
            addCriterion("ACCOUNTBANK <>", value, "accountbank");
            return (Criteria) this;
        }

        public Criteria andAccountbankGreaterThan(String value) {
            addCriterion("ACCOUNTBANK >", value, "accountbank");
            return (Criteria) this;
        }

        public Criteria andAccountbankGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNTBANK >=", value, "accountbank");
            return (Criteria) this;
        }

        public Criteria andAccountbankLessThan(String value) {
            addCriterion("ACCOUNTBANK <", value, "accountbank");
            return (Criteria) this;
        }

        public Criteria andAccountbankLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNTBANK <=", value, "accountbank");
            return (Criteria) this;
        }

        public Criteria andAccountbankLike(String value) {
            addCriterion("ACCOUNTBANK like", value, "accountbank");
            return (Criteria) this;
        }

        public Criteria andAccountbankNotLike(String value) {
            addCriterion("ACCOUNTBANK not like", value, "accountbank");
            return (Criteria) this;
        }

        public Criteria andAccountbankIn(List<String> values) {
            addCriterion("ACCOUNTBANK in", values, "accountbank");
            return (Criteria) this;
        }

        public Criteria andAccountbankNotIn(List<String> values) {
            addCriterion("ACCOUNTBANK not in", values, "accountbank");
            return (Criteria) this;
        }

        public Criteria andAccountbankBetween(String value1, String value2) {
            addCriterion("ACCOUNTBANK between", value1, value2, "accountbank");
            return (Criteria) this;
        }

        public Criteria andAccountbankNotBetween(String value1, String value2) {
            addCriterion("ACCOUNTBANK not between", value1, value2, "accountbank");
            return (Criteria) this;
        }

        public Criteria andBankidIsNull() {
            addCriterion("BANKID is null");
            return (Criteria) this;
        }

        public Criteria andBankidIsNotNull() {
            addCriterion("BANKID is not null");
            return (Criteria) this;
        }

        public Criteria andBankidEqualTo(String value) {
            addCriterion("BANKID =", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotEqualTo(String value) {
            addCriterion("BANKID <>", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidGreaterThan(String value) {
            addCriterion("BANKID >", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidGreaterThanOrEqualTo(String value) {
            addCriterion("BANKID >=", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLessThan(String value) {
            addCriterion("BANKID <", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLessThanOrEqualTo(String value) {
            addCriterion("BANKID <=", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLike(String value) {
            addCriterion("BANKID like", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotLike(String value) {
            addCriterion("BANKID not like", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidIn(List<String> values) {
            addCriterion("BANKID in", values, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotIn(List<String> values) {
            addCriterion("BANKID not in", values, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidBetween(String value1, String value2) {
            addCriterion("BANKID between", value1, value2, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotBetween(String value1, String value2) {
            addCriterion("BANKID not between", value1, value2, "bankid");
            return (Criteria) this;
        }

        public Criteria andAccountnameIsNull() {
            addCriterion("ACCOUNTNAME is null");
            return (Criteria) this;
        }

        public Criteria andAccountnameIsNotNull() {
            addCriterion("ACCOUNTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andAccountnameEqualTo(String value) {
            addCriterion("ACCOUNTNAME =", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameNotEqualTo(String value) {
            addCriterion("ACCOUNTNAME <>", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameGreaterThan(String value) {
            addCriterion("ACCOUNTNAME >", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNTNAME >=", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameLessThan(String value) {
            addCriterion("ACCOUNTNAME <", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNTNAME <=", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameLike(String value) {
            addCriterion("ACCOUNTNAME like", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameNotLike(String value) {
            addCriterion("ACCOUNTNAME not like", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameIn(List<String> values) {
            addCriterion("ACCOUNTNAME in", values, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameNotIn(List<String> values) {
            addCriterion("ACCOUNTNAME not in", values, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameBetween(String value1, String value2) {
            addCriterion("ACCOUNTNAME between", value1, value2, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameNotBetween(String value1, String value2) {
            addCriterion("ACCOUNTNAME not between", value1, value2, "accountname");
            return (Criteria) this;
        }

        public Criteria andBankcodeIsNull() {
            addCriterion("BANKCODE is null");
            return (Criteria) this;
        }

        public Criteria andBankcodeIsNotNull() {
            addCriterion("BANKCODE is not null");
            return (Criteria) this;
        }

        public Criteria andBankcodeEqualTo(String value) {
            addCriterion("BANKCODE =", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeNotEqualTo(String value) {
            addCriterion("BANKCODE <>", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeGreaterThan(String value) {
            addCriterion("BANKCODE >", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeGreaterThanOrEqualTo(String value) {
            addCriterion("BANKCODE >=", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeLessThan(String value) {
            addCriterion("BANKCODE <", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeLessThanOrEqualTo(String value) {
            addCriterion("BANKCODE <=", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeLike(String value) {
            addCriterion("BANKCODE like", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeNotLike(String value) {
            addCriterion("BANKCODE not like", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeIn(List<String> values) {
            addCriterion("BANKCODE in", values, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeNotIn(List<String> values) {
            addCriterion("BANKCODE not in", values, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeBetween(String value1, String value2) {
            addCriterion("BANKCODE between", value1, value2, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeNotBetween(String value1, String value2) {
            addCriterion("BANKCODE not between", value1, value2, "bankcode");
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

        public Criteria andAgencydescIsNull() {
            addCriterion("AGENCYDESC is null");
            return (Criteria) this;
        }

        public Criteria andAgencydescIsNotNull() {
            addCriterion("AGENCYDESC is not null");
            return (Criteria) this;
        }

        public Criteria andAgencydescEqualTo(String value) {
            addCriterion("AGENCYDESC =", value, "agencydesc");
            return (Criteria) this;
        }

        public Criteria andAgencydescNotEqualTo(String value) {
            addCriterion("AGENCYDESC <>", value, "agencydesc");
            return (Criteria) this;
        }

        public Criteria andAgencydescGreaterThan(String value) {
            addCriterion("AGENCYDESC >", value, "agencydesc");
            return (Criteria) this;
        }

        public Criteria andAgencydescGreaterThanOrEqualTo(String value) {
            addCriterion("AGENCYDESC >=", value, "agencydesc");
            return (Criteria) this;
        }

        public Criteria andAgencydescLessThan(String value) {
            addCriterion("AGENCYDESC <", value, "agencydesc");
            return (Criteria) this;
        }

        public Criteria andAgencydescLessThanOrEqualTo(String value) {
            addCriterion("AGENCYDESC <=", value, "agencydesc");
            return (Criteria) this;
        }

        public Criteria andAgencydescLike(String value) {
            addCriterion("AGENCYDESC like", value, "agencydesc");
            return (Criteria) this;
        }

        public Criteria andAgencydescNotLike(String value) {
            addCriterion("AGENCYDESC not like", value, "agencydesc");
            return (Criteria) this;
        }

        public Criteria andAgencydescIn(List<String> values) {
            addCriterion("AGENCYDESC in", values, "agencydesc");
            return (Criteria) this;
        }

        public Criteria andAgencydescNotIn(List<String> values) {
            addCriterion("AGENCYDESC not in", values, "agencydesc");
            return (Criteria) this;
        }

        public Criteria andAgencydescBetween(String value1, String value2) {
            addCriterion("AGENCYDESC between", value1, value2, "agencydesc");
            return (Criteria) this;
        }

        public Criteria andAgencydescNotBetween(String value1, String value2) {
            addCriterion("AGENCYDESC not between", value1, value2, "agencydesc");
            return (Criteria) this;
        }

        public Criteria andCompanybriefnameIsNull() {
            addCriterion("COMPANYBRIEFNAME is null");
            return (Criteria) this;
        }

        public Criteria andCompanybriefnameIsNotNull() {
            addCriterion("COMPANYBRIEFNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompanybriefnameEqualTo(String value) {
            addCriterion("COMPANYBRIEFNAME =", value, "companybriefname");
            return (Criteria) this;
        }

        public Criteria andCompanybriefnameNotEqualTo(String value) {
            addCriterion("COMPANYBRIEFNAME <>", value, "companybriefname");
            return (Criteria) this;
        }

        public Criteria andCompanybriefnameGreaterThan(String value) {
            addCriterion("COMPANYBRIEFNAME >", value, "companybriefname");
            return (Criteria) this;
        }

        public Criteria andCompanybriefnameGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANYBRIEFNAME >=", value, "companybriefname");
            return (Criteria) this;
        }

        public Criteria andCompanybriefnameLessThan(String value) {
            addCriterion("COMPANYBRIEFNAME <", value, "companybriefname");
            return (Criteria) this;
        }

        public Criteria andCompanybriefnameLessThanOrEqualTo(String value) {
            addCriterion("COMPANYBRIEFNAME <=", value, "companybriefname");
            return (Criteria) this;
        }

        public Criteria andCompanybriefnameLike(String value) {
            addCriterion("COMPANYBRIEFNAME like", value, "companybriefname");
            return (Criteria) this;
        }

        public Criteria andCompanybriefnameNotLike(String value) {
            addCriterion("COMPANYBRIEFNAME not like", value, "companybriefname");
            return (Criteria) this;
        }

        public Criteria andCompanybriefnameIn(List<String> values) {
            addCriterion("COMPANYBRIEFNAME in", values, "companybriefname");
            return (Criteria) this;
        }

        public Criteria andCompanybriefnameNotIn(List<String> values) {
            addCriterion("COMPANYBRIEFNAME not in", values, "companybriefname");
            return (Criteria) this;
        }

        public Criteria andCompanybriefnameBetween(String value1, String value2) {
            addCriterion("COMPANYBRIEFNAME between", value1, value2, "companybriefname");
            return (Criteria) this;
        }

        public Criteria andCompanybriefnameNotBetween(String value1, String value2) {
            addCriterion("COMPANYBRIEFNAME not between", value1, value2, "companybriefname");
            return (Criteria) this;
        }

        public Criteria andVestbrandIsNull() {
            addCriterion("VESTBRAND is null");
            return (Criteria) this;
        }

        public Criteria andVestbrandIsNotNull() {
            addCriterion("VESTBRAND is not null");
            return (Criteria) this;
        }

        public Criteria andVestbrandEqualTo(String value) {
            addCriterion("VESTBRAND =", value, "vestbrand");
            return (Criteria) this;
        }

        public Criteria andVestbrandNotEqualTo(String value) {
            addCriterion("VESTBRAND <>", value, "vestbrand");
            return (Criteria) this;
        }

        public Criteria andVestbrandGreaterThan(String value) {
            addCriterion("VESTBRAND >", value, "vestbrand");
            return (Criteria) this;
        }

        public Criteria andVestbrandGreaterThanOrEqualTo(String value) {
            addCriterion("VESTBRAND >=", value, "vestbrand");
            return (Criteria) this;
        }

        public Criteria andVestbrandLessThan(String value) {
            addCriterion("VESTBRAND <", value, "vestbrand");
            return (Criteria) this;
        }

        public Criteria andVestbrandLessThanOrEqualTo(String value) {
            addCriterion("VESTBRAND <=", value, "vestbrand");
            return (Criteria) this;
        }

        public Criteria andVestbrandLike(String value) {
            addCriterion("VESTBRAND like", value, "vestbrand");
            return (Criteria) this;
        }

        public Criteria andVestbrandNotLike(String value) {
            addCriterion("VESTBRAND not like", value, "vestbrand");
            return (Criteria) this;
        }

        public Criteria andVestbrandIn(List<String> values) {
            addCriterion("VESTBRAND in", values, "vestbrand");
            return (Criteria) this;
        }

        public Criteria andVestbrandNotIn(List<String> values) {
            addCriterion("VESTBRAND not in", values, "vestbrand");
            return (Criteria) this;
        }

        public Criteria andVestbrandBetween(String value1, String value2) {
            addCriterion("VESTBRAND between", value1, value2, "vestbrand");
            return (Criteria) this;
        }

        public Criteria andVestbrandNotBetween(String value1, String value2) {
            addCriterion("VESTBRAND not between", value1, value2, "vestbrand");
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