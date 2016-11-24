package cn.sirbox.model;

import java.util.ArrayList;
import java.util.List;

public class MatchsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MatchsExample() {
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

        public Criteria andMatchTimeIsNull() {
            addCriterion("match_time is null");
            return (Criteria) this;
        }

        public Criteria andMatchTimeIsNotNull() {
            addCriterion("match_time is not null");
            return (Criteria) this;
        }

        public Criteria andMatchTimeEqualTo(String value) {
            addCriterion("match_time =", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeNotEqualTo(String value) {
            addCriterion("match_time <>", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeGreaterThan(String value) {
            addCriterion("match_time >", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeGreaterThanOrEqualTo(String value) {
            addCriterion("match_time >=", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeLessThan(String value) {
            addCriterion("match_time <", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeLessThanOrEqualTo(String value) {
            addCriterion("match_time <=", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeLike(String value) {
            addCriterion("match_time like", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeNotLike(String value) {
            addCriterion("match_time not like", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeIn(List<String> values) {
            addCriterion("match_time in", values, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeNotIn(List<String> values) {
            addCriterion("match_time not in", values, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeBetween(String value1, String value2) {
            addCriterion("match_time between", value1, value2, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeNotBetween(String value1, String value2) {
            addCriterion("match_time not between", value1, value2, "matchTime");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andMatchDegreeIsNull() {
            addCriterion("match_degree is null");
            return (Criteria) this;
        }

        public Criteria andMatchDegreeIsNotNull() {
            addCriterion("match_degree is not null");
            return (Criteria) this;
        }

        public Criteria andMatchDegreeEqualTo(String value) {
            addCriterion("match_degree =", value, "matchDegree");
            return (Criteria) this;
        }

        public Criteria andMatchDegreeNotEqualTo(String value) {
            addCriterion("match_degree <>", value, "matchDegree");
            return (Criteria) this;
        }

        public Criteria andMatchDegreeGreaterThan(String value) {
            addCriterion("match_degree >", value, "matchDegree");
            return (Criteria) this;
        }

        public Criteria andMatchDegreeGreaterThanOrEqualTo(String value) {
            addCriterion("match_degree >=", value, "matchDegree");
            return (Criteria) this;
        }

        public Criteria andMatchDegreeLessThan(String value) {
            addCriterion("match_degree <", value, "matchDegree");
            return (Criteria) this;
        }

        public Criteria andMatchDegreeLessThanOrEqualTo(String value) {
            addCriterion("match_degree <=", value, "matchDegree");
            return (Criteria) this;
        }

        public Criteria andMatchDegreeLike(String value) {
            addCriterion("match_degree like", value, "matchDegree");
            return (Criteria) this;
        }

        public Criteria andMatchDegreeNotLike(String value) {
            addCriterion("match_degree not like", value, "matchDegree");
            return (Criteria) this;
        }

        public Criteria andMatchDegreeIn(List<String> values) {
            addCriterion("match_degree in", values, "matchDegree");
            return (Criteria) this;
        }

        public Criteria andMatchDegreeNotIn(List<String> values) {
            addCriterion("match_degree not in", values, "matchDegree");
            return (Criteria) this;
        }

        public Criteria andMatchDegreeBetween(String value1, String value2) {
            addCriterion("match_degree between", value1, value2, "matchDegree");
            return (Criteria) this;
        }

        public Criteria andMatchDegreeNotBetween(String value1, String value2) {
            addCriterion("match_degree not between", value1, value2, "matchDegree");
            return (Criteria) this;
        }

        public Criteria andCooperationModeIsNull() {
            addCriterion("cooperation_mode is null");
            return (Criteria) this;
        }

        public Criteria andCooperationModeIsNotNull() {
            addCriterion("cooperation_mode is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationModeEqualTo(Integer value) {
            addCriterion("cooperation_mode =", value, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeNotEqualTo(Integer value) {
            addCriterion("cooperation_mode <>", value, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeGreaterThan(Integer value) {
            addCriterion("cooperation_mode >", value, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cooperation_mode >=", value, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeLessThan(Integer value) {
            addCriterion("cooperation_mode <", value, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeLessThanOrEqualTo(Integer value) {
            addCriterion("cooperation_mode <=", value, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeIn(List<Integer> values) {
            addCriterion("cooperation_mode in", values, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeNotIn(List<Integer> values) {
            addCriterion("cooperation_mode not in", values, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeBetween(Integer value1, Integer value2) {
            addCriterion("cooperation_mode between", value1, value2, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andCooperationModeNotBetween(Integer value1, Integer value2) {
            addCriterion("cooperation_mode not between", value1, value2, "cooperationMode");
            return (Criteria) this;
        }

        public Criteria andProjectBusinessIsNull() {
            addCriterion("project_business is null");
            return (Criteria) this;
        }

        public Criteria andProjectBusinessIsNotNull() {
            addCriterion("project_business is not null");
            return (Criteria) this;
        }

        public Criteria andProjectBusinessEqualTo(String value) {
            addCriterion("project_business =", value, "projectBusiness");
            return (Criteria) this;
        }

        public Criteria andProjectBusinessNotEqualTo(String value) {
            addCriterion("project_business <>", value, "projectBusiness");
            return (Criteria) this;
        }

        public Criteria andProjectBusinessGreaterThan(String value) {
            addCriterion("project_business >", value, "projectBusiness");
            return (Criteria) this;
        }

        public Criteria andProjectBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("project_business >=", value, "projectBusiness");
            return (Criteria) this;
        }

        public Criteria andProjectBusinessLessThan(String value) {
            addCriterion("project_business <", value, "projectBusiness");
            return (Criteria) this;
        }

        public Criteria andProjectBusinessLessThanOrEqualTo(String value) {
            addCriterion("project_business <=", value, "projectBusiness");
            return (Criteria) this;
        }

        public Criteria andProjectBusinessLike(String value) {
            addCriterion("project_business like", value, "projectBusiness");
            return (Criteria) this;
        }

        public Criteria andProjectBusinessNotLike(String value) {
            addCriterion("project_business not like", value, "projectBusiness");
            return (Criteria) this;
        }

        public Criteria andProjectBusinessIn(List<String> values) {
            addCriterion("project_business in", values, "projectBusiness");
            return (Criteria) this;
        }

        public Criteria andProjectBusinessNotIn(List<String> values) {
            addCriterion("project_business not in", values, "projectBusiness");
            return (Criteria) this;
        }

        public Criteria andProjectBusinessBetween(String value1, String value2) {
            addCriterion("project_business between", value1, value2, "projectBusiness");
            return (Criteria) this;
        }

        public Criteria andProjectBusinessNotBetween(String value1, String value2) {
            addCriterion("project_business not between", value1, value2, "projectBusiness");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIsNull() {
            addCriterion("project_area is null");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIsNotNull() {
            addCriterion("project_area is not null");
            return (Criteria) this;
        }

        public Criteria andProjectAreaEqualTo(String value) {
            addCriterion("project_area =", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaNotEqualTo(String value) {
            addCriterion("project_area <>", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaGreaterThan(String value) {
            addCriterion("project_area >", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaGreaterThanOrEqualTo(String value) {
            addCriterion("project_area >=", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaLessThan(String value) {
            addCriterion("project_area <", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaLessThanOrEqualTo(String value) {
            addCriterion("project_area <=", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaLike(String value) {
            addCriterion("project_area like", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaNotLike(String value) {
            addCriterion("project_area not like", value, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIn(List<String> values) {
            addCriterion("project_area in", values, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaNotIn(List<String> values) {
            addCriterion("project_area not in", values, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaBetween(String value1, String value2) {
            addCriterion("project_area between", value1, value2, "projectArea");
            return (Criteria) this;
        }

        public Criteria andProjectAreaNotBetween(String value1, String value2) {
            addCriterion("project_area not between", value1, value2, "projectArea");
            return (Criteria) this;
        }

        public Criteria andFundBudgetIsNull() {
            addCriterion("fund_budget is null");
            return (Criteria) this;
        }

        public Criteria andFundBudgetIsNotNull() {
            addCriterion("fund_budget is not null");
            return (Criteria) this;
        }

        public Criteria andFundBudgetEqualTo(String value) {
            addCriterion("fund_budget =", value, "fundBudget");
            return (Criteria) this;
        }

        public Criteria andFundBudgetNotEqualTo(String value) {
            addCriterion("fund_budget <>", value, "fundBudget");
            return (Criteria) this;
        }

        public Criteria andFundBudgetGreaterThan(String value) {
            addCriterion("fund_budget >", value, "fundBudget");
            return (Criteria) this;
        }

        public Criteria andFundBudgetGreaterThanOrEqualTo(String value) {
            addCriterion("fund_budget >=", value, "fundBudget");
            return (Criteria) this;
        }

        public Criteria andFundBudgetLessThan(String value) {
            addCriterion("fund_budget <", value, "fundBudget");
            return (Criteria) this;
        }

        public Criteria andFundBudgetLessThanOrEqualTo(String value) {
            addCriterion("fund_budget <=", value, "fundBudget");
            return (Criteria) this;
        }

        public Criteria andFundBudgetLike(String value) {
            addCriterion("fund_budget like", value, "fundBudget");
            return (Criteria) this;
        }

        public Criteria andFundBudgetNotLike(String value) {
            addCriterion("fund_budget not like", value, "fundBudget");
            return (Criteria) this;
        }

        public Criteria andFundBudgetIn(List<String> values) {
            addCriterion("fund_budget in", values, "fundBudget");
            return (Criteria) this;
        }

        public Criteria andFundBudgetNotIn(List<String> values) {
            addCriterion("fund_budget not in", values, "fundBudget");
            return (Criteria) this;
        }

        public Criteria andFundBudgetBetween(String value1, String value2) {
            addCriterion("fund_budget between", value1, value2, "fundBudget");
            return (Criteria) this;
        }

        public Criteria andFundBudgetNotBetween(String value1, String value2) {
            addCriterion("fund_budget not between", value1, value2, "fundBudget");
            return (Criteria) this;
        }

        public Criteria andProjectUnitIsNull() {
            addCriterion("project_unit is null");
            return (Criteria) this;
        }

        public Criteria andProjectUnitIsNotNull() {
            addCriterion("project_unit is not null");
            return (Criteria) this;
        }

        public Criteria andProjectUnitEqualTo(String value) {
            addCriterion("project_unit =", value, "projectUnit");
            return (Criteria) this;
        }

        public Criteria andProjectUnitNotEqualTo(String value) {
            addCriterion("project_unit <>", value, "projectUnit");
            return (Criteria) this;
        }

        public Criteria andProjectUnitGreaterThan(String value) {
            addCriterion("project_unit >", value, "projectUnit");
            return (Criteria) this;
        }

        public Criteria andProjectUnitGreaterThanOrEqualTo(String value) {
            addCriterion("project_unit >=", value, "projectUnit");
            return (Criteria) this;
        }

        public Criteria andProjectUnitLessThan(String value) {
            addCriterion("project_unit <", value, "projectUnit");
            return (Criteria) this;
        }

        public Criteria andProjectUnitLessThanOrEqualTo(String value) {
            addCriterion("project_unit <=", value, "projectUnit");
            return (Criteria) this;
        }

        public Criteria andProjectUnitLike(String value) {
            addCriterion("project_unit like", value, "projectUnit");
            return (Criteria) this;
        }

        public Criteria andProjectUnitNotLike(String value) {
            addCriterion("project_unit not like", value, "projectUnit");
            return (Criteria) this;
        }

        public Criteria andProjectUnitIn(List<String> values) {
            addCriterion("project_unit in", values, "projectUnit");
            return (Criteria) this;
        }

        public Criteria andProjectUnitNotIn(List<String> values) {
            addCriterion("project_unit not in", values, "projectUnit");
            return (Criteria) this;
        }

        public Criteria andProjectUnitBetween(String value1, String value2) {
            addCriterion("project_unit between", value1, value2, "projectUnit");
            return (Criteria) this;
        }

        public Criteria andProjectUnitNotBetween(String value1, String value2) {
            addCriterion("project_unit not between", value1, value2, "projectUnit");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNull() {
            addCriterion("linkman is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("linkman is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("linkman =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("linkman <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("linkman >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("linkman >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("linkman <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("linkman <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("linkman like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("linkman not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("linkman in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("linkman not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("linkman between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("linkman not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(Integer value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(Integer value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(Integer value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(Integer value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(Integer value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<Integer> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<Integer> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(Integer value1, Integer value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(Integer value1, Integer value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andFaxNumberIsNull() {
            addCriterion("fax_number is null");
            return (Criteria) this;
        }

        public Criteria andFaxNumberIsNotNull() {
            addCriterion("fax_number is not null");
            return (Criteria) this;
        }

        public Criteria andFaxNumberEqualTo(String value) {
            addCriterion("fax_number =", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberNotEqualTo(String value) {
            addCriterion("fax_number <>", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberGreaterThan(String value) {
            addCriterion("fax_number >", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberGreaterThanOrEqualTo(String value) {
            addCriterion("fax_number >=", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberLessThan(String value) {
            addCriterion("fax_number <", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberLessThanOrEqualTo(String value) {
            addCriterion("fax_number <=", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberLike(String value) {
            addCriterion("fax_number like", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberNotLike(String value) {
            addCriterion("fax_number not like", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberIn(List<String> values) {
            addCriterion("fax_number in", values, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberNotIn(List<String> values) {
            addCriterion("fax_number not in", values, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberBetween(String value1, String value2) {
            addCriterion("fax_number between", value1, value2, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberNotBetween(String value1, String value2) {
            addCriterion("fax_number not between", value1, value2, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andIssueTimeIsNull() {
            addCriterion("issue_time is null");
            return (Criteria) this;
        }

        public Criteria andIssueTimeIsNotNull() {
            addCriterion("issue_time is not null");
            return (Criteria) this;
        }

        public Criteria andIssueTimeEqualTo(String value) {
            addCriterion("issue_time =", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotEqualTo(String value) {
            addCriterion("issue_time <>", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeGreaterThan(String value) {
            addCriterion("issue_time >", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeGreaterThanOrEqualTo(String value) {
            addCriterion("issue_time >=", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeLessThan(String value) {
            addCriterion("issue_time <", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeLessThanOrEqualTo(String value) {
            addCriterion("issue_time <=", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeLike(String value) {
            addCriterion("issue_time like", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotLike(String value) {
            addCriterion("issue_time not like", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeIn(List<String> values) {
            addCriterion("issue_time in", values, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotIn(List<String> values) {
            addCriterion("issue_time not in", values, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeBetween(String value1, String value2) {
            addCriterion("issue_time between", value1, value2, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotBetween(String value1, String value2) {
            addCriterion("issue_time not between", value1, value2, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssuerIsNull() {
            addCriterion("issuer is null");
            return (Criteria) this;
        }

        public Criteria andIssuerIsNotNull() {
            addCriterion("issuer is not null");
            return (Criteria) this;
        }

        public Criteria andIssuerEqualTo(String value) {
            addCriterion("issuer =", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerNotEqualTo(String value) {
            addCriterion("issuer <>", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerGreaterThan(String value) {
            addCriterion("issuer >", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerGreaterThanOrEqualTo(String value) {
            addCriterion("issuer >=", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerLessThan(String value) {
            addCriterion("issuer <", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerLessThanOrEqualTo(String value) {
            addCriterion("issuer <=", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerLike(String value) {
            addCriterion("issuer like", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerNotLike(String value) {
            addCriterion("issuer not like", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerIn(List<String> values) {
            addCriterion("issuer in", values, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerNotIn(List<String> values) {
            addCriterion("issuer not in", values, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerBetween(String value1, String value2) {
            addCriterion("issuer between", value1, value2, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerNotBetween(String value1, String value2) {
            addCriterion("issuer not between", value1, value2, "issuer");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andProjectFinancingModeIsNull() {
            addCriterion("project_financing_mode is null");
            return (Criteria) this;
        }

        public Criteria andProjectFinancingModeIsNotNull() {
            addCriterion("project_financing_mode is not null");
            return (Criteria) this;
        }

        public Criteria andProjectFinancingModeEqualTo(String value) {
            addCriterion("project_financing_mode =", value, "projectFinancingMode");
            return (Criteria) this;
        }

        public Criteria andProjectFinancingModeNotEqualTo(String value) {
            addCriterion("project_financing_mode <>", value, "projectFinancingMode");
            return (Criteria) this;
        }

        public Criteria andProjectFinancingModeGreaterThan(String value) {
            addCriterion("project_financing_mode >", value, "projectFinancingMode");
            return (Criteria) this;
        }

        public Criteria andProjectFinancingModeGreaterThanOrEqualTo(String value) {
            addCriterion("project_financing_mode >=", value, "projectFinancingMode");
            return (Criteria) this;
        }

        public Criteria andProjectFinancingModeLessThan(String value) {
            addCriterion("project_financing_mode <", value, "projectFinancingMode");
            return (Criteria) this;
        }

        public Criteria andProjectFinancingModeLessThanOrEqualTo(String value) {
            addCriterion("project_financing_mode <=", value, "projectFinancingMode");
            return (Criteria) this;
        }

        public Criteria andProjectFinancingModeLike(String value) {
            addCriterion("project_financing_mode like", value, "projectFinancingMode");
            return (Criteria) this;
        }

        public Criteria andProjectFinancingModeNotLike(String value) {
            addCriterion("project_financing_mode not like", value, "projectFinancingMode");
            return (Criteria) this;
        }

        public Criteria andProjectFinancingModeIn(List<String> values) {
            addCriterion("project_financing_mode in", values, "projectFinancingMode");
            return (Criteria) this;
        }

        public Criteria andProjectFinancingModeNotIn(List<String> values) {
            addCriterion("project_financing_mode not in", values, "projectFinancingMode");
            return (Criteria) this;
        }

        public Criteria andProjectFinancingModeBetween(String value1, String value2) {
            addCriterion("project_financing_mode between", value1, value2, "projectFinancingMode");
            return (Criteria) this;
        }

        public Criteria andProjectFinancingModeNotBetween(String value1, String value2) {
            addCriterion("project_financing_mode not between", value1, value2, "projectFinancingMode");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }
        
        public Criteria andMoneyIsNull() {
            addCriterion("Money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("Money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(String value) {
            addCriterion("Money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(String value) {
            addCriterion("Money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(String value) {
            addCriterion("Money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("Money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(String value) {
            addCriterion("Money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(String value) {
            addCriterion("Money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLike(String value) {
            addCriterion("Money like", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotLike(String value) {
            addCriterion("Money not like", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<String> values) {
            addCriterion("Money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<String> values) {
            addCriterion("Money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(String value1, String value2) {
            addCriterion("Money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(String value1, String value2) {
            addCriterion("Money not between", value1, value2, "money");
            return (Criteria) this;
        }
        
        public Criteria andDetailAddressIsNull() {
            addCriterion("detail_address is null");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIsNotNull() {
            addCriterion("detail_address is not null");
            return (Criteria) this;
        }

        public Criteria andDetailAddressEqualTo(String value) {
            addCriterion("detail_address =", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotEqualTo(String value) {
            addCriterion("detail_address <>", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThan(String value) {
            addCriterion("detail_address >", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detail_address >=", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThan(String value) {
            addCriterion("detail_address <", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThanOrEqualTo(String value) {
            addCriterion("detail_address <=", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLike(String value) {
            addCriterion("detail_address like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotLike(String value) {
            addCriterion("detail_address not like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIn(List<String> values) {
            addCriterion("detail_address in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotIn(List<String> values) {
            addCriterion("detail_address not in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressBetween(String value1, String value2) {
            addCriterion("detail_address between", value1, value2, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotBetween(String value1, String value2) {
            addCriterion("detail_address not between", value1, value2, "detailAddress");
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