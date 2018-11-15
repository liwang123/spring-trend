package com.thingtrust.trend.domain.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 查询条件example类
 *
 * @author wangli
 * @date 2018-11-14
 */
public class TezosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TezosExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(final String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(final boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(final Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        final Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        final Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        final Criteria criteria = new Criteria();
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
            criteria = new ArrayList<>();
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

        protected void addCriterion(final String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(final String condition, final Object value, final String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(final String condition, final Object value1, final Object value2, final String property) {
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

        public Criteria andIdEqualTo(final Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(final Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(final List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(final List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(final Integer value1, final Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(final Integer value1, final Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(final Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(final Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(final Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(final Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andCycleIsNull() {
            addCriterion("cycle is null");
            return (Criteria) this;
        }

        public Criteria andCycleIsNotNull() {
            addCriterion("cycle is not null");
            return (Criteria) this;
        }

        public Criteria andCycleEqualTo(final Integer value) {
            addCriterion("cycle =", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotEqualTo(final Integer value) {
            addCriterion("cycle <>", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleIn(final List<Integer> values) {
            addCriterion("cycle in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotIn(final List<Integer> values) {
            addCriterion("cycle not in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleBetween(final Integer value1, final Integer value2) {
            addCriterion("cycle between", value1, value2, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotBetween(final Integer value1, final Integer value2) {
            addCriterion("cycle not between", value1, value2, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThan(final Integer value) {
            addCriterion("cycle >", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThanOrEqualTo(final Integer value) {
            addCriterion("cycle >=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThan(final Integer value) {
            addCriterion("cycle <", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThanOrEqualTo(final Integer value) {
            addCriterion("cycle <=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andDelegatorAddressIsNull() {
            addCriterion("delegator_address is null");
            return (Criteria) this;
        }

        public Criteria andDelegatorAddressIsNotNull() {
            addCriterion("delegator_address is not null");
            return (Criteria) this;
        }

        public Criteria andDelegatorAddressEqualTo(final String value) {
            addCriterion("delegator_address =", value, "delegatorAddress");
            return (Criteria) this;
        }

        public Criteria andDelegatorAddressNotEqualTo(final String value) {
            addCriterion("delegator_address <>", value, "delegatorAddress");
            return (Criteria) this;
        }

        public Criteria andDelegatorAddressIn(final List<String> values) {
            addCriterion("delegator_address in", values, "delegatorAddress");
            return (Criteria) this;
        }

        public Criteria andDelegatorAddressNotIn(final List<String> values) {
            addCriterion("delegator_address not in", values, "delegatorAddress");
            return (Criteria) this;
        }

        public Criteria andDelegatorAddressBetween(final String value1, final String value2) {
            addCriterion("delegator_address between", value1, value2, "delegatorAddress");
            return (Criteria) this;
        }

        public Criteria andDelegatorAddressNotBetween(final String value1, final String value2) {
            addCriterion("delegator_address not between", value1, value2, "delegatorAddress");
            return (Criteria) this;
        }


        public Criteria andDelegatorAddressLike(final String value) {
            addCriterion("delegator_address like", value, "delegatorAddress");
            return (Criteria) this;
        }

        public Criteria andDelegatorAddressNotLike(final String value) {
            addCriterion("delegator_address not like", value, "delegatorAddress");
            return (Criteria) this;
        }

        public Criteria andDelegatedBalanceIsNull() {
            addCriterion("delegated_balance is null");
            return (Criteria) this;
        }

        public Criteria andDelegatedBalanceIsNotNull() {
            addCriterion("delegated_balance is not null");
            return (Criteria) this;
        }

        public Criteria andDelegatedBalanceEqualTo(final BigDecimal value) {
            addCriterion("delegated_balance =", value, "delegatedBalance");
            return (Criteria) this;
        }

        public Criteria andDelegatedBalanceNotEqualTo(final BigDecimal value) {
            addCriterion("delegated_balance <>", value, "delegatedBalance");
            return (Criteria) this;
        }

        public Criteria andDelegatedBalanceIn(final List<BigDecimal> values) {
            addCriterion("delegated_balance in", values, "delegatedBalance");
            return (Criteria) this;
        }

        public Criteria andDelegatedBalanceNotIn(final List<BigDecimal> values) {
            addCriterion("delegated_balance not in", values, "delegatedBalance");
            return (Criteria) this;
        }

        public Criteria andDelegatedBalanceBetween(final BigDecimal value1, final BigDecimal value2) {
            addCriterion("delegated_balance between", value1, value2, "delegatedBalance");
            return (Criteria) this;
        }

        public Criteria andDelegatedBalanceNotBetween(final BigDecimal value1, final BigDecimal value2) {
            addCriterion("delegated_balance not between", value1, value2, "delegatedBalance");
            return (Criteria) this;
        }

        public Criteria andDelegatedBalanceGreaterThan(final BigDecimal value) {
            addCriterion("delegated_balance >", value, "delegatedBalance");
            return (Criteria) this;
        }

        public Criteria andDelegatedBalanceGreaterThanOrEqualTo(final BigDecimal value) {
            addCriterion("delegated_balance >=", value, "delegatedBalance");
            return (Criteria) this;
        }

        public Criteria andDelegatedBalanceLessThan(final BigDecimal value) {
            addCriterion("delegated_balance <", value, "delegatedBalance");
            return (Criteria) this;
        }

        public Criteria andDelegatedBalanceLessThanOrEqualTo(final BigDecimal value) {
            addCriterion("delegated_balance <=", value, "delegatedBalance");
            return (Criteria) this;
        }

        public Criteria andRewardIsNull() {
            addCriterion("reward is null");
            return (Criteria) this;
        }

        public Criteria andRewardIsNotNull() {
            addCriterion("reward is not null");
            return (Criteria) this;
        }

        public Criteria andRewardEqualTo(final BigDecimal value) {
            addCriterion("reward =", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotEqualTo(final BigDecimal value) {
            addCriterion("reward <>", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardIn(final List<BigDecimal> values) {
            addCriterion("reward in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotIn(final List<BigDecimal> values) {
            addCriterion("reward not in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardBetween(final BigDecimal value1, final BigDecimal value2) {
            addCriterion("reward between", value1, value2, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotBetween(final BigDecimal value1, final BigDecimal value2) {
            addCriterion("reward not between", value1, value2, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThan(final BigDecimal value) {
            addCriterion("reward >", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThanOrEqualTo(final BigDecimal value) {
            addCriterion("reward >=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThan(final BigDecimal value) {
            addCriterion("reward <", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThanOrEqualTo(final BigDecimal value) {
            addCriterion("reward <=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRevenueIsNull() {
            addCriterion("revenue is null");
            return (Criteria) this;
        }

        public Criteria andRevenueIsNotNull() {
            addCriterion("revenue is not null");
            return (Criteria) this;
        }

        public Criteria andRevenueEqualTo(final BigDecimal value) {
            addCriterion("revenue =", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotEqualTo(final BigDecimal value) {
            addCriterion("revenue <>", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueIn(final List<BigDecimal> values) {
            addCriterion("revenue in", values, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotIn(final List<BigDecimal> values) {
            addCriterion("revenue not in", values, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueBetween(final BigDecimal value1, final BigDecimal value2) {
            addCriterion("revenue between", value1, value2, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotBetween(final BigDecimal value1, final BigDecimal value2) {
            addCriterion("revenue not between", value1, value2, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueGreaterThan(final BigDecimal value) {
            addCriterion("revenue >", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueGreaterThanOrEqualTo(final BigDecimal value) {
            addCriterion("revenue >=", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueLessThan(final BigDecimal value) {
            addCriterion("revenue <", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueLessThanOrEqualTo(final BigDecimal value) {
            addCriterion("revenue <=", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(final Integer value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(final Integer value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(final List<Integer> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(final List<Integer> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(final Integer value1, final Integer value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(final Integer value1, final Integer value2) {
            addCriterion("fee not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(final Integer value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(final Integer value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(final Integer value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(final Integer value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andPayInIsNull() {
            addCriterion("pay_in is null");
            return (Criteria) this;
        }

        public Criteria andPayInIsNotNull() {
            addCriterion("pay_in is not null");
            return (Criteria) this;
        }

        public Criteria andPayInEqualTo(final BigDecimal value) {
            addCriterion("pay_in =", value, "payIn");
            return (Criteria) this;
        }

        public Criteria andPayInNotEqualTo(final BigDecimal value) {
            addCriterion("pay_in <>", value, "payIn");
            return (Criteria) this;
        }

        public Criteria andPayInIn(final List<BigDecimal> values) {
            addCriterion("pay_in in", values, "payIn");
            return (Criteria) this;
        }

        public Criteria andPayInNotIn(final List<BigDecimal> values) {
            addCriterion("pay_in not in", values, "payIn");
            return (Criteria) this;
        }

        public Criteria andPayInBetween(final BigDecimal value1, final BigDecimal value2) {
            addCriterion("pay_in between", value1, value2, "payIn");
            return (Criteria) this;
        }

        public Criteria andPayInNotBetween(final BigDecimal value1, final BigDecimal value2) {
            addCriterion("pay_in not between", value1, value2, "payIn");
            return (Criteria) this;
        }

        public Criteria andPayInGreaterThan(final BigDecimal value) {
            addCriterion("pay_in >", value, "payIn");
            return (Criteria) this;
        }

        public Criteria andPayInGreaterThanOrEqualTo(final BigDecimal value) {
            addCriterion("pay_in >=", value, "payIn");
            return (Criteria) this;
        }

        public Criteria andPayInLessThan(final BigDecimal value) {
            addCriterion("pay_in <", value, "payIn");
            return (Criteria) this;
        }

        public Criteria andPayInLessThanOrEqualTo(final BigDecimal value) {
            addCriterion("pay_in <=", value, "payIn");
            return (Criteria) this;
        }

        public Criteria andPayOutIsNull() {
            addCriterion("pay_out is null");
            return (Criteria) this;
        }

        public Criteria andPayOutIsNotNull() {
            addCriterion("pay_out is not null");
            return (Criteria) this;
        }

        public Criteria andPayOutEqualTo(final BigDecimal value) {
            addCriterion("pay_out =", value, "payOut");
            return (Criteria) this;
        }

        public Criteria andPayOutNotEqualTo(final BigDecimal value) {
            addCriterion("pay_out <>", value, "payOut");
            return (Criteria) this;
        }

        public Criteria andPayOutIn(final List<BigDecimal> values) {
            addCriterion("pay_out in", values, "payOut");
            return (Criteria) this;
        }

        public Criteria andPayOutNotIn(final List<BigDecimal> values) {
            addCriterion("pay_out not in", values, "payOut");
            return (Criteria) this;
        }

        public Criteria andPayOutBetween(final BigDecimal value1, final BigDecimal value2) {
            addCriterion("pay_out between", value1, value2, "payOut");
            return (Criteria) this;
        }

        public Criteria andPayOutNotBetween(final BigDecimal value1, final BigDecimal value2) {
            addCriterion("pay_out not between", value1, value2, "payOut");
            return (Criteria) this;
        }

        public Criteria andPayOutGreaterThan(final BigDecimal value) {
            addCriterion("pay_out >", value, "payOut");
            return (Criteria) this;
        }

        public Criteria andPayOutGreaterThanOrEqualTo(final BigDecimal value) {
            addCriterion("pay_out >=", value, "payOut");
            return (Criteria) this;
        }

        public Criteria andPayOutLessThan(final BigDecimal value) {
            addCriterion("pay_out <", value, "payOut");
            return (Criteria) this;
        }

        public Criteria andPayOutLessThanOrEqualTo(final BigDecimal value) {
            addCriterion("pay_out <=", value, "payOut");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(final Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(final Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(final List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(final List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(final Integer value1, final Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(final Integer value1, final Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(final Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(final Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(final Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(final Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(final Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(final Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(final List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(final List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(final Date value1, final Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(final Date value1, final Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(final Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(final Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(final Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(final Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(final Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(final Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(final List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(final List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(final Date value1, final Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(final Date value1, final Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(final Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(final Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(final Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(final Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(final Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(final Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(final List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(final List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(final Date value1, final Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(final Date value1, final Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(final Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(final Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(final Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(final Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
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
        private final String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private final String typeHandler;

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

        protected Criterion(final String condition) {
            super();
            this.condition = condition;
            typeHandler = null;
            noValue = true;
        }

        protected Criterion(final String condition, final Object value, final String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                listValue = true;
            } else {
                singleValue = true;
            }
        }

        protected Criterion(final String condition, final Object value) {
            this(condition, value, null);
        }

        protected Criterion(final String condition, final Object value, final Object secondValue, final String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            betweenValue = true;
        }

        protected Criterion(final String condition, final Object value, final Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}