package com.ytj.mybatisgenerator.model;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNull() {
            addCriterion("company_code is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNotNull() {
            addCriterion("company_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeEqualTo(String value) {
            addCriterion("company_code =", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotEqualTo(String value) {
            addCriterion("company_code <>", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThan(String value) {
            addCriterion("company_code >", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("company_code >=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThan(String value) {
            addCriterion("company_code <", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("company_code <=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLike(String value) {
            addCriterion("company_code like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotLike(String value) {
            addCriterion("company_code not like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIn(List<String> values) {
            addCriterion("company_code in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotIn(List<String> values) {
            addCriterion("company_code not in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeBetween(String value1, String value2) {
            addCriterion("company_code between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("company_code not between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andOrderContactIsNull() {
            addCriterion("order_contact is null");
            return (Criteria) this;
        }

        public Criteria andOrderContactIsNotNull() {
            addCriterion("order_contact is not null");
            return (Criteria) this;
        }

        public Criteria andOrderContactEqualTo(String value) {
            addCriterion("order_contact =", value, "orderContact");
            return (Criteria) this;
        }

        public Criteria andOrderContactNotEqualTo(String value) {
            addCriterion("order_contact <>", value, "orderContact");
            return (Criteria) this;
        }

        public Criteria andOrderContactGreaterThan(String value) {
            addCriterion("order_contact >", value, "orderContact");
            return (Criteria) this;
        }

        public Criteria andOrderContactGreaterThanOrEqualTo(String value) {
            addCriterion("order_contact >=", value, "orderContact");
            return (Criteria) this;
        }

        public Criteria andOrderContactLessThan(String value) {
            addCriterion("order_contact <", value, "orderContact");
            return (Criteria) this;
        }

        public Criteria andOrderContactLessThanOrEqualTo(String value) {
            addCriterion("order_contact <=", value, "orderContact");
            return (Criteria) this;
        }

        public Criteria andOrderContactLike(String value) {
            addCriterion("order_contact like", value, "orderContact");
            return (Criteria) this;
        }

        public Criteria andOrderContactNotLike(String value) {
            addCriterion("order_contact not like", value, "orderContact");
            return (Criteria) this;
        }

        public Criteria andOrderContactIn(List<String> values) {
            addCriterion("order_contact in", values, "orderContact");
            return (Criteria) this;
        }

        public Criteria andOrderContactNotIn(List<String> values) {
            addCriterion("order_contact not in", values, "orderContact");
            return (Criteria) this;
        }

        public Criteria andOrderContactBetween(String value1, String value2) {
            addCriterion("order_contact between", value1, value2, "orderContact");
            return (Criteria) this;
        }

        public Criteria andOrderContactNotBetween(String value1, String value2) {
            addCriterion("order_contact not between", value1, value2, "orderContact");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andOrderContactNumberIsNull() {
            addCriterion("order_contact_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderContactNumberIsNotNull() {
            addCriterion("order_contact_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderContactNumberEqualTo(String value) {
            addCriterion("order_contact_number =", value, "orderContactNumber");
            return (Criteria) this;
        }

        public Criteria andOrderContactNumberNotEqualTo(String value) {
            addCriterion("order_contact_number <>", value, "orderContactNumber");
            return (Criteria) this;
        }

        public Criteria andOrderContactNumberGreaterThan(String value) {
            addCriterion("order_contact_number >", value, "orderContactNumber");
            return (Criteria) this;
        }

        public Criteria andOrderContactNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_contact_number >=", value, "orderContactNumber");
            return (Criteria) this;
        }

        public Criteria andOrderContactNumberLessThan(String value) {
            addCriterion("order_contact_number <", value, "orderContactNumber");
            return (Criteria) this;
        }

        public Criteria andOrderContactNumberLessThanOrEqualTo(String value) {
            addCriterion("order_contact_number <=", value, "orderContactNumber");
            return (Criteria) this;
        }

        public Criteria andOrderContactNumberLike(String value) {
            addCriterion("order_contact_number like", value, "orderContactNumber");
            return (Criteria) this;
        }

        public Criteria andOrderContactNumberNotLike(String value) {
            addCriterion("order_contact_number not like", value, "orderContactNumber");
            return (Criteria) this;
        }

        public Criteria andOrderContactNumberIn(List<String> values) {
            addCriterion("order_contact_number in", values, "orderContactNumber");
            return (Criteria) this;
        }

        public Criteria andOrderContactNumberNotIn(List<String> values) {
            addCriterion("order_contact_number not in", values, "orderContactNumber");
            return (Criteria) this;
        }

        public Criteria andOrderContactNumberBetween(String value1, String value2) {
            addCriterion("order_contact_number between", value1, value2, "orderContactNumber");
            return (Criteria) this;
        }

        public Criteria andOrderContactNumberNotBetween(String value1, String value2) {
            addCriterion("order_contact_number not between", value1, value2, "orderContactNumber");
            return (Criteria) this;
        }

        public Criteria andOrderConsigneeAddressIsNull() {
            addCriterion("order_consignee_address is null");
            return (Criteria) this;
        }

        public Criteria andOrderConsigneeAddressIsNotNull() {
            addCriterion("order_consignee_address is not null");
            return (Criteria) this;
        }

        public Criteria andOrderConsigneeAddressEqualTo(String value) {
            addCriterion("order_consignee_address =", value, "orderConsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderConsigneeAddressNotEqualTo(String value) {
            addCriterion("order_consignee_address <>", value, "orderConsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderConsigneeAddressGreaterThan(String value) {
            addCriterion("order_consignee_address >", value, "orderConsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderConsigneeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("order_consignee_address >=", value, "orderConsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderConsigneeAddressLessThan(String value) {
            addCriterion("order_consignee_address <", value, "orderConsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderConsigneeAddressLessThanOrEqualTo(String value) {
            addCriterion("order_consignee_address <=", value, "orderConsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderConsigneeAddressLike(String value) {
            addCriterion("order_consignee_address like", value, "orderConsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderConsigneeAddressNotLike(String value) {
            addCriterion("order_consignee_address not like", value, "orderConsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderConsigneeAddressIn(List<String> values) {
            addCriterion("order_consignee_address in", values, "orderConsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderConsigneeAddressNotIn(List<String> values) {
            addCriterion("order_consignee_address not in", values, "orderConsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderConsigneeAddressBetween(String value1, String value2) {
            addCriterion("order_consignee_address between", value1, value2, "orderConsigneeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderConsigneeAddressNotBetween(String value1, String value2) {
            addCriterion("order_consignee_address not between", value1, value2, "orderConsigneeAddress");
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