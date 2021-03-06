package com.huawei.model;

import java.util.ArrayList;
import java.util.List;

public class BrandInfoExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
	public BrandInfoExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
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

		public Criteria andBrandNameIsNull() {
			addCriterion("brand_name is null");
			return (Criteria) this;
		}

		public Criteria andBrandNameIsNotNull() {
			addCriterion("brand_name is not null");
			return (Criteria) this;
		}

		public Criteria andBrandNameEqualTo(String value) {
			addCriterion("brand_name =", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameNotEqualTo(String value) {
			addCriterion("brand_name <>", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameGreaterThan(String value) {
			addCriterion("brand_name >", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
			addCriterion("brand_name >=", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameLessThan(String value) {
			addCriterion("brand_name <", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameLessThanOrEqualTo(String value) {
			addCriterion("brand_name <=", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameLike(String value) {
			addCriterion("brand_name like", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameNotLike(String value) {
			addCriterion("brand_name not like", value, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameIn(List<String> values) {
			addCriterion("brand_name in", values, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameNotIn(List<String> values) {
			addCriterion("brand_name not in", values, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameBetween(String value1, String value2) {
			addCriterion("brand_name between", value1, value2, "brandName");
			return (Criteria) this;
		}

		public Criteria andBrandNameNotBetween(String value1, String value2) {
			addCriterion("brand_name not between", value1, value2, "brandName");
			return (Criteria) this;
		}

		public Criteria andCompanyIsNull() {
			addCriterion("company is null");
			return (Criteria) this;
		}

		public Criteria andCompanyIsNotNull() {
			addCriterion("company is not null");
			return (Criteria) this;
		}

		public Criteria andCompanyEqualTo(String value) {
			addCriterion("company =", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyNotEqualTo(String value) {
			addCriterion("company <>", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyGreaterThan(String value) {
			addCriterion("company >", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyGreaterThanOrEqualTo(String value) {
			addCriterion("company >=", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyLessThan(String value) {
			addCriterion("company <", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyLessThanOrEqualTo(String value) {
			addCriterion("company <=", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyLike(String value) {
			addCriterion("company like", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyNotLike(String value) {
			addCriterion("company not like", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyIn(List<String> values) {
			addCriterion("company in", values, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyNotIn(List<String> values) {
			addCriterion("company not in", values, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyBetween(String value1, String value2) {
			addCriterion("company between", value1, value2, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyNotBetween(String value1, String value2) {
			addCriterion("company not between", value1, value2, "company");
			return (Criteria) this;
		}

		public Criteria andContactIsNull() {
			addCriterion("contact is null");
			return (Criteria) this;
		}

		public Criteria andContactIsNotNull() {
			addCriterion("contact is not null");
			return (Criteria) this;
		}

		public Criteria andContactEqualTo(String value) {
			addCriterion("contact =", value, "contact");
			return (Criteria) this;
		}

		public Criteria andContactNotEqualTo(String value) {
			addCriterion("contact <>", value, "contact");
			return (Criteria) this;
		}

		public Criteria andContactGreaterThan(String value) {
			addCriterion("contact >", value, "contact");
			return (Criteria) this;
		}

		public Criteria andContactGreaterThanOrEqualTo(String value) {
			addCriterion("contact >=", value, "contact");
			return (Criteria) this;
		}

		public Criteria andContactLessThan(String value) {
			addCriterion("contact <", value, "contact");
			return (Criteria) this;
		}

		public Criteria andContactLessThanOrEqualTo(String value) {
			addCriterion("contact <=", value, "contact");
			return (Criteria) this;
		}

		public Criteria andContactLike(String value) {
			addCriterion("contact like", value, "contact");
			return (Criteria) this;
		}

		public Criteria andContactNotLike(String value) {
			addCriterion("contact not like", value, "contact");
			return (Criteria) this;
		}

		public Criteria andContactIn(List<String> values) {
			addCriterion("contact in", values, "contact");
			return (Criteria) this;
		}

		public Criteria andContactNotIn(List<String> values) {
			addCriterion("contact not in", values, "contact");
			return (Criteria) this;
		}

		public Criteria andContactBetween(String value1, String value2) {
			addCriterion("contact between", value1, value2, "contact");
			return (Criteria) this;
		}

		public Criteria andContactNotBetween(String value1, String value2) {
			addCriterion("contact not between", value1, value2, "contact");
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

		public Criteria andTelIsNull() {
			addCriterion("tel is null");
			return (Criteria) this;
		}

		public Criteria andTelIsNotNull() {
			addCriterion("tel is not null");
			return (Criteria) this;
		}

		public Criteria andTelEqualTo(String value) {
			addCriterion("tel =", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelNotEqualTo(String value) {
			addCriterion("tel <>", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelGreaterThan(String value) {
			addCriterion("tel >", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelGreaterThanOrEqualTo(String value) {
			addCriterion("tel >=", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelLessThan(String value) {
			addCriterion("tel <", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelLessThanOrEqualTo(String value) {
			addCriterion("tel <=", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelLike(String value) {
			addCriterion("tel like", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelNotLike(String value) {
			addCriterion("tel not like", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelIn(List<String> values) {
			addCriterion("tel in", values, "tel");
			return (Criteria) this;
		}

		public Criteria andTelNotIn(List<String> values) {
			addCriterion("tel not in", values, "tel");
			return (Criteria) this;
		}

		public Criteria andTelBetween(String value1, String value2) {
			addCriterion("tel between", value1, value2, "tel");
			return (Criteria) this;
		}

		public Criteria andTelNotBetween(String value1, String value2) {
			addCriterion("tel not between", value1, value2, "tel");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("remark is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andFlagIsNull() {
			addCriterion("flag is null");
			return (Criteria) this;
		}

		public Criteria andFlagIsNotNull() {
			addCriterion("flag is not null");
			return (Criteria) this;
		}

		public Criteria andFlagEqualTo(Boolean value) {
			addCriterion("flag =", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagNotEqualTo(Boolean value) {
			addCriterion("flag <>", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagGreaterThan(Boolean value) {
			addCriterion("flag >", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("flag >=", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagLessThan(Boolean value) {
			addCriterion("flag <", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("flag <=", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagIn(List<Boolean> values) {
			addCriterion("flag in", values, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagNotIn(List<Boolean> values) {
			addCriterion("flag not in", values, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("flag between", value1, value2, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("flag not between", value1, value2, "flag");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_brand_info
	 * @mbg.generated  Thu May 10 22:30:05 CST 2018
	 */
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_brand_info
     *
     * @mbg.generated do_not_delete_during_merge Sun Mar 18 20:53:47 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}