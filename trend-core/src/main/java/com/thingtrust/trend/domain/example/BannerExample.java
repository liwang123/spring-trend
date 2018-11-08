package com.thingtrust.trend.domain.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  查询条件example类
 * @author wangli
 * @date 2018-10-10
 */
public class BannerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BannerExample() {
        oredCriteria = new ArrayList<>();
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
            return (Criteria)this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria)this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria)this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria)this;
        }
		
				public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria)this;
        }
				
			        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria)this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria)this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria)this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria)this;
        }
		
				
				public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria)this;
        }
			        public Criteria andDescribeIsNull() {
            addCriterion("describe is null");
            return (Criteria)this;
        }

        public Criteria andDescribeIsNotNull() {
            addCriterion("describe is not null");
            return (Criteria)this;
        }

        public Criteria andDescribeEqualTo(String value) {
            addCriterion("describe =", value, "describe");
            return (Criteria)this;
        }

        public Criteria andDescribeNotEqualTo(String value) {
            addCriterion("describe <>", value, "describe");
            return (Criteria)this;
        }

        public Criteria andDescribeIn(List<String> values) {
            addCriterion("describe in", values, "describe");
            return (Criteria)this;
        }

        public Criteria andDescribeNotIn(List<String> values) {
            addCriterion("describe not in", values, "describe");
            return (Criteria)this;
        }

        public Criteria andDescribeBetween(String value1, String value2) {
            addCriterion("describe between", value1, value2, "describe");
            return (Criteria)this;
        }

        public Criteria andDescribeNotBetween(String value1, String value2) {
            addCriterion("describe not between", value1, value2, "describe");
            return (Criteria)this;
        }
		
				
				public Criteria andDescribeLike(String value) {
            addCriterion("describe like", value, "describe");
            return (Criteria)this;
        }

        public Criteria andDescribeNotLike(String value) {
            addCriterion("describe not like", value, "describe");
            return (Criteria)this;
        }
			        public Criteria andDelegateAddressIsNull() {
            addCriterion("delegate_address is null");
            return (Criteria)this;
        }

        public Criteria andDelegateAddressIsNotNull() {
            addCriterion("delegate_address is not null");
            return (Criteria)this;
        }

        public Criteria andDelegateAddressEqualTo(String value) {
            addCriterion("delegate_address =", value, "delegateAddress");
            return (Criteria)this;
        }

        public Criteria andDelegateAddressNotEqualTo(String value) {
            addCriterion("delegate_address <>", value, "delegateAddress");
            return (Criteria)this;
        }

        public Criteria andDelegateAddressIn(List<String> values) {
            addCriterion("delegate_address in", values, "delegateAddress");
            return (Criteria)this;
        }

        public Criteria andDelegateAddressNotIn(List<String> values) {
            addCriterion("delegate_address not in", values, "delegateAddress");
            return (Criteria)this;
        }

        public Criteria andDelegateAddressBetween(String value1, String value2) {
            addCriterion("delegate_address between", value1, value2, "delegateAddress");
            return (Criteria)this;
        }

        public Criteria andDelegateAddressNotBetween(String value1, String value2) {
            addCriterion("delegate_address not between", value1, value2, "delegateAddress");
            return (Criteria)this;
        }
		
				
				public Criteria andDelegateAddressLike(String value) {
            addCriterion("delegate_address like", value, "delegateAddress");
            return (Criteria)this;
        }

        public Criteria andDelegateAddressNotLike(String value) {
            addCriterion("delegate_address not like", value, "delegateAddress");
            return (Criteria)this;
        }
			        public Criteria andStakBondIsNull() {
            addCriterion("stak_bond is null");
            return (Criteria)this;
        }

        public Criteria andStakBondIsNotNull() {
            addCriterion("stak_bond is not null");
            return (Criteria)this;
        }

        public Criteria andStakBondEqualTo(String value) {
            addCriterion("stak_bond =", value, "stakBond");
            return (Criteria)this;
        }

        public Criteria andStakBondNotEqualTo(String value) {
            addCriterion("stak_bond <>", value, "stakBond");
            return (Criteria)this;
        }

        public Criteria andStakBondIn(List<String> values) {
            addCriterion("stak_bond in", values, "stakBond");
            return (Criteria)this;
        }

        public Criteria andStakBondNotIn(List<String> values) {
            addCriterion("stak_bond not in", values, "stakBond");
            return (Criteria)this;
        }

        public Criteria andStakBondBetween(String value1, String value2) {
            addCriterion("stak_bond between", value1, value2, "stakBond");
            return (Criteria)this;
        }

        public Criteria andStakBondNotBetween(String value1, String value2) {
            addCriterion("stak_bond not between", value1, value2, "stakBond");
            return (Criteria)this;
        }
		
				
				public Criteria andStakBondLike(String value) {
            addCriterion("stak_bond like", value, "stakBond");
            return (Criteria)this;
        }

        public Criteria andStakBondNotLike(String value) {
            addCriterion("stak_bond not like", value, "stakBond");
            return (Criteria)this;
        }
			        public Criteria andDelegateBalanceIsNull() {
            addCriterion("delegate_balance is null");
            return (Criteria)this;
        }

        public Criteria andDelegateBalanceIsNotNull() {
            addCriterion("delegate_balance is not null");
            return (Criteria)this;
        }

        public Criteria andDelegateBalanceEqualTo(String value) {
            addCriterion("delegate_balance =", value, "delegateBalance");
            return (Criteria)this;
        }

        public Criteria andDelegateBalanceNotEqualTo(String value) {
            addCriterion("delegate_balance <>", value, "delegateBalance");
            return (Criteria)this;
        }

        public Criteria andDelegateBalanceIn(List<String> values) {
            addCriterion("delegate_balance in", values, "delegateBalance");
            return (Criteria)this;
        }

        public Criteria andDelegateBalanceNotIn(List<String> values) {
            addCriterion("delegate_balance not in", values, "delegateBalance");
            return (Criteria)this;
        }

        public Criteria andDelegateBalanceBetween(String value1, String value2) {
            addCriterion("delegate_balance between", value1, value2, "delegateBalance");
            return (Criteria)this;
        }

        public Criteria andDelegateBalanceNotBetween(String value1, String value2) {
            addCriterion("delegate_balance not between", value1, value2, "delegateBalance");
            return (Criteria)this;
        }
		
				
				public Criteria andDelegateBalanceLike(String value) {
            addCriterion("delegate_balance like", value, "delegateBalance");
            return (Criteria)this;
        }

        public Criteria andDelegateBalanceNotLike(String value) {
            addCriterion("delegate_balance not like", value, "delegateBalance");
            return (Criteria)this;
        }
			        public Criteria andCapacityIsNull() {
            addCriterion("capacity is null");
            return (Criteria)this;
        }

        public Criteria andCapacityIsNotNull() {
            addCriterion("capacity is not null");
            return (Criteria)this;
        }

        public Criteria andCapacityEqualTo(String value) {
            addCriterion("capacity =", value, "capacity");
            return (Criteria)this;
        }

        public Criteria andCapacityNotEqualTo(String value) {
            addCriterion("capacity <>", value, "capacity");
            return (Criteria)this;
        }

        public Criteria andCapacityIn(List<String> values) {
            addCriterion("capacity in", values, "capacity");
            return (Criteria)this;
        }

        public Criteria andCapacityNotIn(List<String> values) {
            addCriterion("capacity not in", values, "capacity");
            return (Criteria)this;
        }

        public Criteria andCapacityBetween(String value1, String value2) {
            addCriterion("capacity between", value1, value2, "capacity");
            return (Criteria)this;
        }

        public Criteria andCapacityNotBetween(String value1, String value2) {
            addCriterion("capacity not between", value1, value2, "capacity");
            return (Criteria)this;
        }
		
				
				public Criteria andCapacityLike(String value) {
            addCriterion("capacity like", value, "capacity");
            return (Criteria)this;
        }

        public Criteria andCapacityNotLike(String value) {
            addCriterion("capacity not like", value, "capacity");
            return (Criteria)this;
        }
			        public Criteria andComputerImageIsNull() {
            addCriterion("computer_image is null");
            return (Criteria)this;
        }

        public Criteria andComputerImageIsNotNull() {
            addCriterion("computer_image is not null");
            return (Criteria)this;
        }

        public Criteria andComputerImageEqualTo(String value) {
            addCriterion("computer_image =", value, "computerImage");
            return (Criteria)this;
        }

        public Criteria andComputerImageNotEqualTo(String value) {
            addCriterion("computer_image <>", value, "computerImage");
            return (Criteria)this;
        }

        public Criteria andComputerImageIn(List<String> values) {
            addCriterion("computer_image in", values, "computerImage");
            return (Criteria)this;
        }

        public Criteria andComputerImageNotIn(List<String> values) {
            addCriterion("computer_image not in", values, "computerImage");
            return (Criteria)this;
        }

        public Criteria andComputerImageBetween(String value1, String value2) {
            addCriterion("computer_image between", value1, value2, "computerImage");
            return (Criteria)this;
        }

        public Criteria andComputerImageNotBetween(String value1, String value2) {
            addCriterion("computer_image not between", value1, value2, "computerImage");
            return (Criteria)this;
        }
		
				
				public Criteria andComputerImageLike(String value) {
            addCriterion("computer_image like", value, "computerImage");
            return (Criteria)this;
        }

        public Criteria andComputerImageNotLike(String value) {
            addCriterion("computer_image not like", value, "computerImage");
            return (Criteria)this;
        }
			        public Criteria andPhoneImageIsNull() {
            addCriterion("phone_image is null");
            return (Criteria)this;
        }

        public Criteria andPhoneImageIsNotNull() {
            addCriterion("phone_image is not null");
            return (Criteria)this;
        }

        public Criteria andPhoneImageEqualTo(String value) {
            addCriterion("phone_image =", value, "phoneImage");
            return (Criteria)this;
        }

        public Criteria andPhoneImageNotEqualTo(String value) {
            addCriterion("phone_image <>", value, "phoneImage");
            return (Criteria)this;
        }

        public Criteria andPhoneImageIn(List<String> values) {
            addCriterion("phone_image in", values, "phoneImage");
            return (Criteria)this;
        }

        public Criteria andPhoneImageNotIn(List<String> values) {
            addCriterion("phone_image not in", values, "phoneImage");
            return (Criteria)this;
        }

        public Criteria andPhoneImageBetween(String value1, String value2) {
            addCriterion("phone_image between", value1, value2, "phoneImage");
            return (Criteria)this;
        }

        public Criteria andPhoneImageNotBetween(String value1, String value2) {
            addCriterion("phone_image not between", value1, value2, "phoneImage");
            return (Criteria)this;
        }
		
				
				public Criteria andPhoneImageLike(String value) {
            addCriterion("phone_image like", value, "phoneImage");
            return (Criteria)this;
        }

        public Criteria andPhoneImageNotLike(String value) {
            addCriterion("phone_image not like", value, "phoneImage");
            return (Criteria)this;
        }
			        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria)this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria)this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria)this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria)this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria)this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria)this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria)this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria)this;
        }
		
				public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria)this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria)this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria)this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria)this;
        }
				
			        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria)this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria)this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria)this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria)this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria)this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria)this;
        }
		
				public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria)this;
        }
				
			        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria)this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria)this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria)this;
        }
		
				public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria)this;
        }
				
			        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria)this;
        }
		
				public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria)this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria)this;
        }
				
			    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andFieldLike(final String fieldName, final String keyword) {
            addCriterion(fieldName + " like ", keyword, fieldName);
            return this;
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