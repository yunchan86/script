package com.yacol.mybatis.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KbTableInfoMBEnatityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KbTableInfoMBEnatityExample() {
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

        public Criteria andTableIdIsNull() {
            addCriterion("table_id is null");
            return (Criteria) this;
        }

        public Criteria andTableIdIsNotNull() {
            addCriterion("table_id is not null");
            return (Criteria) this;
        }

        public Criteria andTableIdEqualTo(Long value) {
            addCriterion("table_id =", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotEqualTo(Long value) {
            addCriterion("table_id <>", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdGreaterThan(Long value) {
            addCriterion("table_id >", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdGreaterThanOrEqualTo(Long value) {
            addCriterion("table_id >=", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdLessThan(Long value) {
            addCriterion("table_id <", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdLessThanOrEqualTo(Long value) {
            addCriterion("table_id <=", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdIn(List<Long> values) {
            addCriterion("table_id in", values, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotIn(List<Long> values) {
            addCriterion("table_id not in", values, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdBetween(Long value1, Long value2) {
            addCriterion("table_id between", value1, value2, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotBetween(Long value1, Long value2) {
            addCriterion("table_id not between", value1, value2, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableDescIsNull() {
            addCriterion("table_desc is null");
            return (Criteria) this;
        }

        public Criteria andTableDescIsNotNull() {
            addCriterion("table_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTableDescEqualTo(String value) {
            addCriterion("table_desc =", value, "tableDesc");
            return (Criteria) this;
        }

        public Criteria andTableDescNotEqualTo(String value) {
            addCriterion("table_desc <>", value, "tableDesc");
            return (Criteria) this;
        }

        public Criteria andTableDescGreaterThan(String value) {
            addCriterion("table_desc >", value, "tableDesc");
            return (Criteria) this;
        }

        public Criteria andTableDescGreaterThanOrEqualTo(String value) {
            addCriterion("table_desc >=", value, "tableDesc");
            return (Criteria) this;
        }

        public Criteria andTableDescLessThan(String value) {
            addCriterion("table_desc <", value, "tableDesc");
            return (Criteria) this;
        }

        public Criteria andTableDescLessThanOrEqualTo(String value) {
            addCriterion("table_desc <=", value, "tableDesc");
            return (Criteria) this;
        }

        public Criteria andTableDescLike(String value) {
            addCriterion("table_desc like", value, "tableDesc");
            return (Criteria) this;
        }

        public Criteria andTableDescNotLike(String value) {
            addCriterion("table_desc not like", value, "tableDesc");
            return (Criteria) this;
        }

        public Criteria andTableDescIn(List<String> values) {
            addCriterion("table_desc in", values, "tableDesc");
            return (Criteria) this;
        }

        public Criteria andTableDescNotIn(List<String> values) {
            addCriterion("table_desc not in", values, "tableDesc");
            return (Criteria) this;
        }

        public Criteria andTableDescBetween(String value1, String value2) {
            addCriterion("table_desc between", value1, value2, "tableDesc");
            return (Criteria) this;
        }

        public Criteria andTableDescNotBetween(String value1, String value2) {
            addCriterion("table_desc not between", value1, value2, "tableDesc");
            return (Criteria) this;
        }

        public Criteria andProviderIdIsNull() {
            addCriterion("provider_id is null");
            return (Criteria) this;
        }

        public Criteria andProviderIdIsNotNull() {
            addCriterion("provider_id is not null");
            return (Criteria) this;
        }

        public Criteria andProviderIdEqualTo(String value) {
            addCriterion("provider_id =", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotEqualTo(String value) {
            addCriterion("provider_id <>", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThan(String value) {
            addCriterion("provider_id >", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThanOrEqualTo(String value) {
            addCriterion("provider_id >=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThan(String value) {
            addCriterion("provider_id <", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThanOrEqualTo(String value) {
            addCriterion("provider_id <=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLike(String value) {
            addCriterion("provider_id like", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotLike(String value) {
            addCriterion("provider_id not like", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdIn(List<String> values) {
            addCriterion("provider_id in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotIn(List<String> values) {
            addCriterion("provider_id not in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdBetween(String value1, String value2) {
            addCriterion("provider_id between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotBetween(String value1, String value2) {
            addCriterion("provider_id not between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdIsNull() {
            addCriterion("campaign_id is null");
            return (Criteria) this;
        }

        public Criteria andCampaignIdIsNotNull() {
            addCriterion("campaign_id is not null");
            return (Criteria) this;
        }

        public Criteria andCampaignIdEqualTo(Long value) {
            addCriterion("campaign_id =", value, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdNotEqualTo(Long value) {
            addCriterion("campaign_id <>", value, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdGreaterThan(Long value) {
            addCriterion("campaign_id >", value, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdGreaterThanOrEqualTo(Long value) {
            addCriterion("campaign_id >=", value, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdLessThan(Long value) {
            addCriterion("campaign_id <", value, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdLessThanOrEqualTo(Long value) {
            addCriterion("campaign_id <=", value, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdIn(List<Long> values) {
            addCriterion("campaign_id in", values, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdNotIn(List<Long> values) {
            addCriterion("campaign_id not in", values, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdBetween(Long value1, Long value2) {
            addCriterion("campaign_id between", value1, value2, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdNotBetween(Long value1, Long value2) {
            addCriterion("campaign_id not between", value1, value2, "campaignId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIsNull() {
            addCriterion("originator is null");
            return (Criteria) this;
        }

        public Criteria andOriginatorIsNotNull() {
            addCriterion("originator is not null");
            return (Criteria) this;
        }

        public Criteria andOriginatorEqualTo(Long value) {
            addCriterion("originator =", value, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorNotEqualTo(Long value) {
            addCriterion("originator <>", value, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorGreaterThan(Long value) {
            addCriterion("originator >", value, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorGreaterThanOrEqualTo(Long value) {
            addCriterion("originator >=", value, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorLessThan(Long value) {
            addCriterion("originator <", value, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorLessThanOrEqualTo(Long value) {
            addCriterion("originator <=", value, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorIn(List<Long> values) {
            addCriterion("originator in", values, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorNotIn(List<Long> values) {
            addCriterion("originator not in", values, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorBetween(Long value1, Long value2) {
            addCriterion("originator between", value1, value2, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorNotBetween(Long value1, Long value2) {
            addCriterion("originator not between", value1, value2, "originator");
            return (Criteria) this;
        }

        public Criteria andOriginatorTypeIsNull() {
            addCriterion("originator_type is null");
            return (Criteria) this;
        }

        public Criteria andOriginatorTypeIsNotNull() {
            addCriterion("originator_type is not null");
            return (Criteria) this;
        }

        public Criteria andOriginatorTypeEqualTo(Byte value) {
            addCriterion("originator_type =", value, "originatorType");
            return (Criteria) this;
        }

        public Criteria andOriginatorTypeNotEqualTo(Byte value) {
            addCriterion("originator_type <>", value, "originatorType");
            return (Criteria) this;
        }

        public Criteria andOriginatorTypeGreaterThan(Byte value) {
            addCriterion("originator_type >", value, "originatorType");
            return (Criteria) this;
        }

        public Criteria andOriginatorTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("originator_type >=", value, "originatorType");
            return (Criteria) this;
        }

        public Criteria andOriginatorTypeLessThan(Byte value) {
            addCriterion("originator_type <", value, "originatorType");
            return (Criteria) this;
        }

        public Criteria andOriginatorTypeLessThanOrEqualTo(Byte value) {
            addCriterion("originator_type <=", value, "originatorType");
            return (Criteria) this;
        }

        public Criteria andOriginatorTypeIn(List<Byte> values) {
            addCriterion("originator_type in", values, "originatorType");
            return (Criteria) this;
        }

        public Criteria andOriginatorTypeNotIn(List<Byte> values) {
            addCriterion("originator_type not in", values, "originatorType");
            return (Criteria) this;
        }

        public Criteria andOriginatorTypeBetween(Byte value1, Byte value2) {
            addCriterion("originator_type between", value1, value2, "originatorType");
            return (Criteria) this;
        }

        public Criteria andOriginatorTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("originator_type not between", value1, value2, "originatorType");
            return (Criteria) this;
        }

        public Criteria andTableTypeIsNull() {
            addCriterion("table_type is null");
            return (Criteria) this;
        }

        public Criteria andTableTypeIsNotNull() {
            addCriterion("table_type is not null");
            return (Criteria) this;
        }

        public Criteria andTableTypeEqualTo(Byte value) {
            addCriterion("table_type =", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeNotEqualTo(Byte value) {
            addCriterion("table_type <>", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeGreaterThan(Byte value) {
            addCriterion("table_type >", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("table_type >=", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeLessThan(Byte value) {
            addCriterion("table_type <", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeLessThanOrEqualTo(Byte value) {
            addCriterion("table_type <=", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeIn(List<Byte> values) {
            addCriterion("table_type in", values, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeNotIn(List<Byte> values) {
            addCriterion("table_type not in", values, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeBetween(Byte value1, Byte value2) {
            addCriterion("table_type between", value1, value2, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("table_type not between", value1, value2, "tableType");
            return (Criteria) this;
        }

        public Criteria andUserLimitIsNull() {
            addCriterion("user_limit is null");
            return (Criteria) this;
        }

        public Criteria andUserLimitIsNotNull() {
            addCriterion("user_limit is not null");
            return (Criteria) this;
        }

        public Criteria andUserLimitEqualTo(Short value) {
            addCriterion("user_limit =", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitNotEqualTo(Short value) {
            addCriterion("user_limit <>", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitGreaterThan(Short value) {
            addCriterion("user_limit >", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitGreaterThanOrEqualTo(Short value) {
            addCriterion("user_limit >=", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitLessThan(Short value) {
            addCriterion("user_limit <", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitLessThanOrEqualTo(Short value) {
            addCriterion("user_limit <=", value, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitIn(List<Short> values) {
            addCriterion("user_limit in", values, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitNotIn(List<Short> values) {
            addCriterion("user_limit not in", values, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitBetween(Short value1, Short value2) {
            addCriterion("user_limit between", value1, value2, "userLimit");
            return (Criteria) this;
        }

        public Criteria andUserLimitNotBetween(Short value1, Short value2) {
            addCriterion("user_limit not between", value1, value2, "userLimit");
            return (Criteria) this;
        }

        public Criteria andCurUserNumIsNull() {
            addCriterion("cur_user_num is null");
            return (Criteria) this;
        }

        public Criteria andCurUserNumIsNotNull() {
            addCriterion("cur_user_num is not null");
            return (Criteria) this;
        }

        public Criteria andCurUserNumEqualTo(Integer value) {
            addCriterion("cur_user_num =", value, "curUserNum");
            return (Criteria) this;
        }

        public Criteria andCurUserNumNotEqualTo(Integer value) {
            addCriterion("cur_user_num <>", value, "curUserNum");
            return (Criteria) this;
        }

        public Criteria andCurUserNumGreaterThan(Integer value) {
            addCriterion("cur_user_num >", value, "curUserNum");
            return (Criteria) this;
        }

        public Criteria andCurUserNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cur_user_num >=", value, "curUserNum");
            return (Criteria) this;
        }

        public Criteria andCurUserNumLessThan(Integer value) {
            addCriterion("cur_user_num <", value, "curUserNum");
            return (Criteria) this;
        }

        public Criteria andCurUserNumLessThanOrEqualTo(Integer value) {
            addCriterion("cur_user_num <=", value, "curUserNum");
            return (Criteria) this;
        }

        public Criteria andCurUserNumIn(List<Integer> values) {
            addCriterion("cur_user_num in", values, "curUserNum");
            return (Criteria) this;
        }

        public Criteria andCurUserNumNotIn(List<Integer> values) {
            addCriterion("cur_user_num not in", values, "curUserNum");
            return (Criteria) this;
        }

        public Criteria andCurUserNumBetween(Integer value1, Integer value2) {
            addCriterion("cur_user_num between", value1, value2, "curUserNum");
            return (Criteria) this;
        }

        public Criteria andCurUserNumNotBetween(Integer value1, Integer value2) {
            addCriterion("cur_user_num not between", value1, value2, "curUserNum");
            return (Criteria) this;
        }

        public Criteria andTableLogoIsNull() {
            addCriterion("table_logo is null");
            return (Criteria) this;
        }

        public Criteria andTableLogoIsNotNull() {
            addCriterion("table_logo is not null");
            return (Criteria) this;
        }

        public Criteria andTableLogoEqualTo(String value) {
            addCriterion("table_logo =", value, "tableLogo");
            return (Criteria) this;
        }

        public Criteria andTableLogoNotEqualTo(String value) {
            addCriterion("table_logo <>", value, "tableLogo");
            return (Criteria) this;
        }

        public Criteria andTableLogoGreaterThan(String value) {
            addCriterion("table_logo >", value, "tableLogo");
            return (Criteria) this;
        }

        public Criteria andTableLogoGreaterThanOrEqualTo(String value) {
            addCriterion("table_logo >=", value, "tableLogo");
            return (Criteria) this;
        }

        public Criteria andTableLogoLessThan(String value) {
            addCriterion("table_logo <", value, "tableLogo");
            return (Criteria) this;
        }

        public Criteria andTableLogoLessThanOrEqualTo(String value) {
            addCriterion("table_logo <=", value, "tableLogo");
            return (Criteria) this;
        }

        public Criteria andTableLogoLike(String value) {
            addCriterion("table_logo like", value, "tableLogo");
            return (Criteria) this;
        }

        public Criteria andTableLogoNotLike(String value) {
            addCriterion("table_logo not like", value, "tableLogo");
            return (Criteria) this;
        }

        public Criteria andTableLogoIn(List<String> values) {
            addCriterion("table_logo in", values, "tableLogo");
            return (Criteria) this;
        }

        public Criteria andTableLogoNotIn(List<String> values) {
            addCriterion("table_logo not in", values, "tableLogo");
            return (Criteria) this;
        }

        public Criteria andTableLogoBetween(String value1, String value2) {
            addCriterion("table_logo between", value1, value2, "tableLogo");
            return (Criteria) this;
        }

        public Criteria andTableLogoNotBetween(String value1, String value2) {
            addCriterion("table_logo not between", value1, value2, "tableLogo");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Date value) {
            addCriterion("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Date value) {
            addCriterion("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Date value) {
            addCriterion("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Date value) {
            addCriterion("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Date> values) {
            addCriterion("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Date> values) {
            addCriterion("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Date value1, Date value2) {
            addCriterion("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("expire_time not between", value1, value2, "expireTime");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsStartedIsNull() {
            addCriterion("is_started is null");
            return (Criteria) this;
        }

        public Criteria andIsStartedIsNotNull() {
            addCriterion("is_started is not null");
            return (Criteria) this;
        }

        public Criteria andIsStartedEqualTo(Byte value) {
            addCriterion("is_started =", value, "isStarted");
            return (Criteria) this;
        }

        public Criteria andIsStartedNotEqualTo(Byte value) {
            addCriterion("is_started <>", value, "isStarted");
            return (Criteria) this;
        }

        public Criteria andIsStartedGreaterThan(Byte value) {
            addCriterion("is_started >", value, "isStarted");
            return (Criteria) this;
        }

        public Criteria andIsStartedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_started >=", value, "isStarted");
            return (Criteria) this;
        }

        public Criteria andIsStartedLessThan(Byte value) {
            addCriterion("is_started <", value, "isStarted");
            return (Criteria) this;
        }

        public Criteria andIsStartedLessThanOrEqualTo(Byte value) {
            addCriterion("is_started <=", value, "isStarted");
            return (Criteria) this;
        }

        public Criteria andIsStartedIn(List<Byte> values) {
            addCriterion("is_started in", values, "isStarted");
            return (Criteria) this;
        }

        public Criteria andIsStartedNotIn(List<Byte> values) {
            addCriterion("is_started not in", values, "isStarted");
            return (Criteria) this;
        }

        public Criteria andIsStartedBetween(Byte value1, Byte value2) {
            addCriterion("is_started between", value1, value2, "isStarted");
            return (Criteria) this;
        }

        public Criteria andIsStartedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_started not between", value1, value2, "isStarted");
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

        public Criteria andIsRecommendIsNull() {
            addCriterion("is_recommend is null");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIsNotNull() {
            addCriterion("is_recommend is not null");
            return (Criteria) this;
        }

        public Criteria andIsRecommendEqualTo(Byte value) {
            addCriterion("is_recommend =", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotEqualTo(Byte value) {
            addCriterion("is_recommend <>", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendGreaterThan(Byte value) {
            addCriterion("is_recommend >", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_recommend >=", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLessThan(Byte value) {
            addCriterion("is_recommend <", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLessThanOrEqualTo(Byte value) {
            addCriterion("is_recommend <=", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIn(List<Byte> values) {
            addCriterion("is_recommend in", values, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotIn(List<Byte> values) {
            addCriterion("is_recommend not in", values, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendBetween(Byte value1, Byte value2) {
            addCriterion("is_recommend between", value1, value2, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotBetween(Byte value1, Byte value2) {
            addCriterion("is_recommend not between", value1, value2, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andBonusAllotTypeIsNull() {
            addCriterion("bonus_allot_type is null");
            return (Criteria) this;
        }

        public Criteria andBonusAllotTypeIsNotNull() {
            addCriterion("bonus_allot_type is not null");
            return (Criteria) this;
        }

        public Criteria andBonusAllotTypeEqualTo(Byte value) {
            addCriterion("bonus_allot_type =", value, "bonusAllotType");
            return (Criteria) this;
        }

        public Criteria andBonusAllotTypeNotEqualTo(Byte value) {
            addCriterion("bonus_allot_type <>", value, "bonusAllotType");
            return (Criteria) this;
        }

        public Criteria andBonusAllotTypeGreaterThan(Byte value) {
            addCriterion("bonus_allot_type >", value, "bonusAllotType");
            return (Criteria) this;
        }

        public Criteria andBonusAllotTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("bonus_allot_type >=", value, "bonusAllotType");
            return (Criteria) this;
        }

        public Criteria andBonusAllotTypeLessThan(Byte value) {
            addCriterion("bonus_allot_type <", value, "bonusAllotType");
            return (Criteria) this;
        }

        public Criteria andBonusAllotTypeLessThanOrEqualTo(Byte value) {
            addCriterion("bonus_allot_type <=", value, "bonusAllotType");
            return (Criteria) this;
        }

        public Criteria andBonusAllotTypeIn(List<Byte> values) {
            addCriterion("bonus_allot_type in", values, "bonusAllotType");
            return (Criteria) this;
        }

        public Criteria andBonusAllotTypeNotIn(List<Byte> values) {
            addCriterion("bonus_allot_type not in", values, "bonusAllotType");
            return (Criteria) this;
        }

        public Criteria andBonusAllotTypeBetween(Byte value1, Byte value2) {
            addCriterion("bonus_allot_type between", value1, value2, "bonusAllotType");
            return (Criteria) this;
        }

        public Criteria andBonusAllotTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("bonus_allot_type not between", value1, value2, "bonusAllotType");
            return (Criteria) this;
        }

        public Criteria andIsPublicIsNull() {
            addCriterion("is_public is null");
            return (Criteria) this;
        }

        public Criteria andIsPublicIsNotNull() {
            addCriterion("is_public is not null");
            return (Criteria) this;
        }

        public Criteria andIsPublicEqualTo(Boolean value) {
            addCriterion("is_public =", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicNotEqualTo(Boolean value) {
            addCriterion("is_public <>", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicGreaterThan(Boolean value) {
            addCriterion("is_public >", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_public >=", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicLessThan(Boolean value) {
            addCriterion("is_public <", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicLessThanOrEqualTo(Boolean value) {
            addCriterion("is_public <=", value, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicIn(List<Boolean> values) {
            addCriterion("is_public in", values, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicNotIn(List<Boolean> values) {
            addCriterion("is_public not in", values, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicBetween(Boolean value1, Boolean value2) {
            addCriterion("is_public between", value1, value2, "isPublic");
            return (Criteria) this;
        }

        public Criteria andIsPublicNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_public not between", value1, value2, "isPublic");
            return (Criteria) this;
        }

        public Criteria andDrawTimeIsNull() {
            addCriterion("draw_time is null");
            return (Criteria) this;
        }

        public Criteria andDrawTimeIsNotNull() {
            addCriterion("draw_time is not null");
            return (Criteria) this;
        }

        public Criteria andDrawTimeEqualTo(Date value) {
            addCriterion("draw_time =", value, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeNotEqualTo(Date value) {
            addCriterion("draw_time <>", value, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeGreaterThan(Date value) {
            addCriterion("draw_time >", value, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("draw_time >=", value, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeLessThan(Date value) {
            addCriterion("draw_time <", value, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeLessThanOrEqualTo(Date value) {
            addCriterion("draw_time <=", value, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeIn(List<Date> values) {
            addCriterion("draw_time in", values, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeNotIn(List<Date> values) {
            addCriterion("draw_time not in", values, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeBetween(Date value1, Date value2) {
            addCriterion("draw_time between", value1, value2, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeNotBetween(Date value1, Date value2) {
            addCriterion("draw_time not between", value1, value2, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawStartTimeIsNull() {
            addCriterion("draw_start_time is null");
            return (Criteria) this;
        }

        public Criteria andDrawStartTimeIsNotNull() {
            addCriterion("draw_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andDrawStartTimeEqualTo(Date value) {
            addCriterion("draw_start_time =", value, "drawStartTime");
            return (Criteria) this;
        }

        public Criteria andDrawStartTimeNotEqualTo(Date value) {
            addCriterion("draw_start_time <>", value, "drawStartTime");
            return (Criteria) this;
        }

        public Criteria andDrawStartTimeGreaterThan(Date value) {
            addCriterion("draw_start_time >", value, "drawStartTime");
            return (Criteria) this;
        }

        public Criteria andDrawStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("draw_start_time >=", value, "drawStartTime");
            return (Criteria) this;
        }

        public Criteria andDrawStartTimeLessThan(Date value) {
            addCriterion("draw_start_time <", value, "drawStartTime");
            return (Criteria) this;
        }

        public Criteria andDrawStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("draw_start_time <=", value, "drawStartTime");
            return (Criteria) this;
        }

        public Criteria andDrawStartTimeIn(List<Date> values) {
            addCriterion("draw_start_time in", values, "drawStartTime");
            return (Criteria) this;
        }

        public Criteria andDrawStartTimeNotIn(List<Date> values) {
            addCriterion("draw_start_time not in", values, "drawStartTime");
            return (Criteria) this;
        }

        public Criteria andDrawStartTimeBetween(Date value1, Date value2) {
            addCriterion("draw_start_time between", value1, value2, "drawStartTime");
            return (Criteria) this;
        }

        public Criteria andDrawStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("draw_start_time not between", value1, value2, "drawStartTime");
            return (Criteria) this;
        }

        public Criteria andDrawEndTimeIsNull() {
            addCriterion("draw_end_time is null");
            return (Criteria) this;
        }

        public Criteria andDrawEndTimeIsNotNull() {
            addCriterion("draw_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andDrawEndTimeEqualTo(Date value) {
            addCriterion("draw_end_time =", value, "drawEndTime");
            return (Criteria) this;
        }

        public Criteria andDrawEndTimeNotEqualTo(Date value) {
            addCriterion("draw_end_time <>", value, "drawEndTime");
            return (Criteria) this;
        }

        public Criteria andDrawEndTimeGreaterThan(Date value) {
            addCriterion("draw_end_time >", value, "drawEndTime");
            return (Criteria) this;
        }

        public Criteria andDrawEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("draw_end_time >=", value, "drawEndTime");
            return (Criteria) this;
        }

        public Criteria andDrawEndTimeLessThan(Date value) {
            addCriterion("draw_end_time <", value, "drawEndTime");
            return (Criteria) this;
        }

        public Criteria andDrawEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("draw_end_time <=", value, "drawEndTime");
            return (Criteria) this;
        }

        public Criteria andDrawEndTimeIn(List<Date> values) {
            addCriterion("draw_end_time in", values, "drawEndTime");
            return (Criteria) this;
        }

        public Criteria andDrawEndTimeNotIn(List<Date> values) {
            addCriterion("draw_end_time not in", values, "drawEndTime");
            return (Criteria) this;
        }

        public Criteria andDrawEndTimeBetween(Date value1, Date value2) {
            addCriterion("draw_end_time between", value1, value2, "drawEndTime");
            return (Criteria) this;
        }

        public Criteria andDrawEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("draw_end_time not between", value1, value2, "drawEndTime");
            return (Criteria) this;
        }

        public Criteria andDrawStatusIsNull() {
            addCriterion("draw_status is null");
            return (Criteria) this;
        }

        public Criteria andDrawStatusIsNotNull() {
            addCriterion("draw_status is not null");
            return (Criteria) this;
        }

        public Criteria andDrawStatusEqualTo(Boolean value) {
            addCriterion("draw_status =", value, "drawStatus");
            return (Criteria) this;
        }

        public Criteria andDrawStatusNotEqualTo(Boolean value) {
            addCriterion("draw_status <>", value, "drawStatus");
            return (Criteria) this;
        }

        public Criteria andDrawStatusGreaterThan(Boolean value) {
            addCriterion("draw_status >", value, "drawStatus");
            return (Criteria) this;
        }

        public Criteria andDrawStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("draw_status >=", value, "drawStatus");
            return (Criteria) this;
        }

        public Criteria andDrawStatusLessThan(Boolean value) {
            addCriterion("draw_status <", value, "drawStatus");
            return (Criteria) this;
        }

        public Criteria andDrawStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("draw_status <=", value, "drawStatus");
            return (Criteria) this;
        }

        public Criteria andDrawStatusIn(List<Boolean> values) {
            addCriterion("draw_status in", values, "drawStatus");
            return (Criteria) this;
        }

        public Criteria andDrawStatusNotIn(List<Boolean> values) {
            addCriterion("draw_status not in", values, "drawStatus");
            return (Criteria) this;
        }

        public Criteria andDrawStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("draw_status between", value1, value2, "drawStatus");
            return (Criteria) this;
        }

        public Criteria andDrawStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("draw_status not between", value1, value2, "drawStatus");
            return (Criteria) this;
        }

        public Criteria andTotalDrawAmtIsNull() {
            addCriterion("total_draw_amt is null");
            return (Criteria) this;
        }

        public Criteria andTotalDrawAmtIsNotNull() {
            addCriterion("total_draw_amt is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDrawAmtEqualTo(Integer value) {
            addCriterion("total_draw_amt =", value, "totalDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalDrawAmtNotEqualTo(Integer value) {
            addCriterion("total_draw_amt <>", value, "totalDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalDrawAmtGreaterThan(Integer value) {
            addCriterion("total_draw_amt >", value, "totalDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalDrawAmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_draw_amt >=", value, "totalDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalDrawAmtLessThan(Integer value) {
            addCriterion("total_draw_amt <", value, "totalDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalDrawAmtLessThanOrEqualTo(Integer value) {
            addCriterion("total_draw_amt <=", value, "totalDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalDrawAmtIn(List<Integer> values) {
            addCriterion("total_draw_amt in", values, "totalDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalDrawAmtNotIn(List<Integer> values) {
            addCriterion("total_draw_amt not in", values, "totalDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalDrawAmtBetween(Integer value1, Integer value2) {
            addCriterion("total_draw_amt between", value1, value2, "totalDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalDrawAmtNotBetween(Integer value1, Integer value2) {
            addCriterion("total_draw_amt not between", value1, value2, "totalDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTakeDrawAmtIsNull() {
            addCriterion("total_take_draw_amt is null");
            return (Criteria) this;
        }

        public Criteria andTotalTakeDrawAmtIsNotNull() {
            addCriterion("total_take_draw_amt is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTakeDrawAmtEqualTo(Integer value) {
            addCriterion("total_take_draw_amt =", value, "totalTakeDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTakeDrawAmtNotEqualTo(Integer value) {
            addCriterion("total_take_draw_amt <>", value, "totalTakeDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTakeDrawAmtGreaterThan(Integer value) {
            addCriterion("total_take_draw_amt >", value, "totalTakeDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTakeDrawAmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_take_draw_amt >=", value, "totalTakeDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTakeDrawAmtLessThan(Integer value) {
            addCriterion("total_take_draw_amt <", value, "totalTakeDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTakeDrawAmtLessThanOrEqualTo(Integer value) {
            addCriterion("total_take_draw_amt <=", value, "totalTakeDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTakeDrawAmtIn(List<Integer> values) {
            addCriterion("total_take_draw_amt in", values, "totalTakeDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTakeDrawAmtNotIn(List<Integer> values) {
            addCriterion("total_take_draw_amt not in", values, "totalTakeDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTakeDrawAmtBetween(Integer value1, Integer value2) {
            addCriterion("total_take_draw_amt between", value1, value2, "totalTakeDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalTakeDrawAmtNotBetween(Integer value1, Integer value2) {
            addCriterion("total_take_draw_amt not between", value1, value2, "totalTakeDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalRemainDrawAmtIsNull() {
            addCriterion("total_remain_draw_amt is null");
            return (Criteria) this;
        }

        public Criteria andTotalRemainDrawAmtIsNotNull() {
            addCriterion("total_remain_draw_amt is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRemainDrawAmtEqualTo(Integer value) {
            addCriterion("total_remain_draw_amt =", value, "totalRemainDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalRemainDrawAmtNotEqualTo(Integer value) {
            addCriterion("total_remain_draw_amt <>", value, "totalRemainDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalRemainDrawAmtGreaterThan(Integer value) {
            addCriterion("total_remain_draw_amt >", value, "totalRemainDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalRemainDrawAmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_remain_draw_amt >=", value, "totalRemainDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalRemainDrawAmtLessThan(Integer value) {
            addCriterion("total_remain_draw_amt <", value, "totalRemainDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalRemainDrawAmtLessThanOrEqualTo(Integer value) {
            addCriterion("total_remain_draw_amt <=", value, "totalRemainDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalRemainDrawAmtIn(List<Integer> values) {
            addCriterion("total_remain_draw_amt in", values, "totalRemainDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalRemainDrawAmtNotIn(List<Integer> values) {
            addCriterion("total_remain_draw_amt not in", values, "totalRemainDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalRemainDrawAmtBetween(Integer value1, Integer value2) {
            addCriterion("total_remain_draw_amt between", value1, value2, "totalRemainDrawAmt");
            return (Criteria) this;
        }

        public Criteria andTotalRemainDrawAmtNotBetween(Integer value1, Integer value2) {
            addCriterion("total_remain_draw_amt not between", value1, value2, "totalRemainDrawAmt");
            return (Criteria) this;
        }

        public Criteria andConsumeUserNumIsNull() {
            addCriterion("consume_user_num is null");
            return (Criteria) this;
        }

        public Criteria andConsumeUserNumIsNotNull() {
            addCriterion("consume_user_num is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeUserNumEqualTo(Integer value) {
            addCriterion("consume_user_num =", value, "consumeUserNum");
            return (Criteria) this;
        }

        public Criteria andConsumeUserNumNotEqualTo(Integer value) {
            addCriterion("consume_user_num <>", value, "consumeUserNum");
            return (Criteria) this;
        }

        public Criteria andConsumeUserNumGreaterThan(Integer value) {
            addCriterion("consume_user_num >", value, "consumeUserNum");
            return (Criteria) this;
        }

        public Criteria andConsumeUserNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("consume_user_num >=", value, "consumeUserNum");
            return (Criteria) this;
        }

        public Criteria andConsumeUserNumLessThan(Integer value) {
            addCriterion("consume_user_num <", value, "consumeUserNum");
            return (Criteria) this;
        }

        public Criteria andConsumeUserNumLessThanOrEqualTo(Integer value) {
            addCriterion("consume_user_num <=", value, "consumeUserNum");
            return (Criteria) this;
        }

        public Criteria andConsumeUserNumIn(List<Integer> values) {
            addCriterion("consume_user_num in", values, "consumeUserNum");
            return (Criteria) this;
        }

        public Criteria andConsumeUserNumNotIn(List<Integer> values) {
            addCriterion("consume_user_num not in", values, "consumeUserNum");
            return (Criteria) this;
        }

        public Criteria andConsumeUserNumBetween(Integer value1, Integer value2) {
            addCriterion("consume_user_num between", value1, value2, "consumeUserNum");
            return (Criteria) this;
        }

        public Criteria andConsumeUserNumNotBetween(Integer value1, Integer value2) {
            addCriterion("consume_user_num not between", value1, value2, "consumeUserNum");
            return (Criteria) this;
        }

        public Criteria andTakeDrawUserNumIsNull() {
            addCriterion("take_draw_user_num is null");
            return (Criteria) this;
        }

        public Criteria andTakeDrawUserNumIsNotNull() {
            addCriterion("take_draw_user_num is not null");
            return (Criteria) this;
        }

        public Criteria andTakeDrawUserNumEqualTo(Integer value) {
            addCriterion("take_draw_user_num =", value, "takeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andTakeDrawUserNumNotEqualTo(Integer value) {
            addCriterion("take_draw_user_num <>", value, "takeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andTakeDrawUserNumGreaterThan(Integer value) {
            addCriterion("take_draw_user_num >", value, "takeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andTakeDrawUserNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("take_draw_user_num >=", value, "takeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andTakeDrawUserNumLessThan(Integer value) {
            addCriterion("take_draw_user_num <", value, "takeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andTakeDrawUserNumLessThanOrEqualTo(Integer value) {
            addCriterion("take_draw_user_num <=", value, "takeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andTakeDrawUserNumIn(List<Integer> values) {
            addCriterion("take_draw_user_num in", values, "takeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andTakeDrawUserNumNotIn(List<Integer> values) {
            addCriterion("take_draw_user_num not in", values, "takeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andTakeDrawUserNumBetween(Integer value1, Integer value2) {
            addCriterion("take_draw_user_num between", value1, value2, "takeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andTakeDrawUserNumNotBetween(Integer value1, Integer value2) {
            addCriterion("take_draw_user_num not between", value1, value2, "takeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andUntakeDrawUserNumIsNull() {
            addCriterion("untake_draw_user_num is null");
            return (Criteria) this;
        }

        public Criteria andUntakeDrawUserNumIsNotNull() {
            addCriterion("untake_draw_user_num is not null");
            return (Criteria) this;
        }

        public Criteria andUntakeDrawUserNumEqualTo(Integer value) {
            addCriterion("untake_draw_user_num =", value, "untakeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andUntakeDrawUserNumNotEqualTo(Integer value) {
            addCriterion("untake_draw_user_num <>", value, "untakeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andUntakeDrawUserNumGreaterThan(Integer value) {
            addCriterion("untake_draw_user_num >", value, "untakeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andUntakeDrawUserNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("untake_draw_user_num >=", value, "untakeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andUntakeDrawUserNumLessThan(Integer value) {
            addCriterion("untake_draw_user_num <", value, "untakeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andUntakeDrawUserNumLessThanOrEqualTo(Integer value) {
            addCriterion("untake_draw_user_num <=", value, "untakeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andUntakeDrawUserNumIn(List<Integer> values) {
            addCriterion("untake_draw_user_num in", values, "untakeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andUntakeDrawUserNumNotIn(List<Integer> values) {
            addCriterion("untake_draw_user_num not in", values, "untakeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andUntakeDrawUserNumBetween(Integer value1, Integer value2) {
            addCriterion("untake_draw_user_num between", value1, value2, "untakeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andUntakeDrawUserNumNotBetween(Integer value1, Integer value2) {
            addCriterion("untake_draw_user_num not between", value1, value2, "untakeDrawUserNum");
            return (Criteria) this;
        }

        public Criteria andFakeConsumeSumIsNull() {
            addCriterion("fake_Consume_sum is null");
            return (Criteria) this;
        }

        public Criteria andFakeConsumeSumIsNotNull() {
            addCriterion("fake_Consume_sum is not null");
            return (Criteria) this;
        }

        public Criteria andFakeConsumeSumEqualTo(Integer value) {
            addCriterion("fake_Consume_sum =", value, "fakeConsumeSum");
            return (Criteria) this;
        }

        public Criteria andFakeConsumeSumNotEqualTo(Integer value) {
            addCriterion("fake_Consume_sum <>", value, "fakeConsumeSum");
            return (Criteria) this;
        }

        public Criteria andFakeConsumeSumGreaterThan(Integer value) {
            addCriterion("fake_Consume_sum >", value, "fakeConsumeSum");
            return (Criteria) this;
        }

        public Criteria andFakeConsumeSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("fake_Consume_sum >=", value, "fakeConsumeSum");
            return (Criteria) this;
        }

        public Criteria andFakeConsumeSumLessThan(Integer value) {
            addCriterion("fake_Consume_sum <", value, "fakeConsumeSum");
            return (Criteria) this;
        }

        public Criteria andFakeConsumeSumLessThanOrEqualTo(Integer value) {
            addCriterion("fake_Consume_sum <=", value, "fakeConsumeSum");
            return (Criteria) this;
        }

        public Criteria andFakeConsumeSumIn(List<Integer> values) {
            addCriterion("fake_Consume_sum in", values, "fakeConsumeSum");
            return (Criteria) this;
        }

        public Criteria andFakeConsumeSumNotIn(List<Integer> values) {
            addCriterion("fake_Consume_sum not in", values, "fakeConsumeSum");
            return (Criteria) this;
        }

        public Criteria andFakeConsumeSumBetween(Integer value1, Integer value2) {
            addCriterion("fake_Consume_sum between", value1, value2, "fakeConsumeSum");
            return (Criteria) this;
        }

        public Criteria andFakeConsumeSumNotBetween(Integer value1, Integer value2) {
            addCriterion("fake_Consume_sum not between", value1, value2, "fakeConsumeSum");
            return (Criteria) this;
        }

        public Criteria andIsUserOptIsNull() {
            addCriterion("is_user_opt is null");
            return (Criteria) this;
        }

        public Criteria andIsUserOptIsNotNull() {
            addCriterion("is_user_opt is not null");
            return (Criteria) this;
        }

        public Criteria andIsUserOptEqualTo(Boolean value) {
            addCriterion("is_user_opt =", value, "isUserOpt");
            return (Criteria) this;
        }

        public Criteria andIsUserOptNotEqualTo(Boolean value) {
            addCriterion("is_user_opt <>", value, "isUserOpt");
            return (Criteria) this;
        }

        public Criteria andIsUserOptGreaterThan(Boolean value) {
            addCriterion("is_user_opt >", value, "isUserOpt");
            return (Criteria) this;
        }

        public Criteria andIsUserOptGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_user_opt >=", value, "isUserOpt");
            return (Criteria) this;
        }

        public Criteria andIsUserOptLessThan(Boolean value) {
            addCriterion("is_user_opt <", value, "isUserOpt");
            return (Criteria) this;
        }

        public Criteria andIsUserOptLessThanOrEqualTo(Boolean value) {
            addCriterion("is_user_opt <=", value, "isUserOpt");
            return (Criteria) this;
        }

        public Criteria andIsUserOptIn(List<Boolean> values) {
            addCriterion("is_user_opt in", values, "isUserOpt");
            return (Criteria) this;
        }

        public Criteria andIsUserOptNotIn(List<Boolean> values) {
            addCriterion("is_user_opt not in", values, "isUserOpt");
            return (Criteria) this;
        }

        public Criteria andIsUserOptBetween(Boolean value1, Boolean value2) {
            addCriterion("is_user_opt between", value1, value2, "isUserOpt");
            return (Criteria) this;
        }

        public Criteria andIsUserOptNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_user_opt not between", value1, value2, "isUserOpt");
            return (Criteria) this;
        }

        public Criteria andConsumeLimitIsNull() {
            addCriterion("consume_limit is null");
            return (Criteria) this;
        }

        public Criteria andConsumeLimitIsNotNull() {
            addCriterion("consume_limit is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeLimitEqualTo(Integer value) {
            addCriterion("consume_limit =", value, "consumeLimit");
            return (Criteria) this;
        }

        public Criteria andConsumeLimitNotEqualTo(Integer value) {
            addCriterion("consume_limit <>", value, "consumeLimit");
            return (Criteria) this;
        }

        public Criteria andConsumeLimitGreaterThan(Integer value) {
            addCriterion("consume_limit >", value, "consumeLimit");
            return (Criteria) this;
        }

        public Criteria andConsumeLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("consume_limit >=", value, "consumeLimit");
            return (Criteria) this;
        }

        public Criteria andConsumeLimitLessThan(Integer value) {
            addCriterion("consume_limit <", value, "consumeLimit");
            return (Criteria) this;
        }

        public Criteria andConsumeLimitLessThanOrEqualTo(Integer value) {
            addCriterion("consume_limit <=", value, "consumeLimit");
            return (Criteria) this;
        }

        public Criteria andConsumeLimitIn(List<Integer> values) {
            addCriterion("consume_limit in", values, "consumeLimit");
            return (Criteria) this;
        }

        public Criteria andConsumeLimitNotIn(List<Integer> values) {
            addCriterion("consume_limit not in", values, "consumeLimit");
            return (Criteria) this;
        }

        public Criteria andConsumeLimitBetween(Integer value1, Integer value2) {
            addCriterion("consume_limit between", value1, value2, "consumeLimit");
            return (Criteria) this;
        }

        public Criteria andConsumeLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("consume_limit not between", value1, value2, "consumeLimit");
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