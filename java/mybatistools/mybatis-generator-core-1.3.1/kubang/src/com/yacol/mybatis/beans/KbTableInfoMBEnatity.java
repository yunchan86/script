package com.yacol.mybatis.beans;

import java.util.Date;

public class KbTableInfoMBEnatity {
    private Long tableId;

    private String tableDesc;

    private String providerId;

    private Long campaignId;

    private Long originator;

    private Byte originatorType;

    private Byte tableType;

    private Short userLimit;

    private Integer curUserNum;

    private String tableLogo;

    private Date createTime;

    private Date startTime;

    private Date expireTime;

    private Byte status;

    private Byte isStarted;

    private String password;

    private Byte isRecommend;

    private Byte bonusAllotType;

    private Boolean isPublic;

    private Date drawTime;

    private Date drawStartTime;

    private Date drawEndTime;

    private Boolean drawStatus;

    private Integer totalDrawAmt;

    private Integer totalTakeDrawAmt;

    private Integer totalRemainDrawAmt;

    private Integer consumeUserNum;

    private Integer takeDrawUserNum;

    private Integer untakeDrawUserNum;

    private Integer fakeConsumeSum;

    private Boolean isUserOpt;

    private Integer consumeLimit;

    private String userList;

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public String getTableDesc() {
        return tableDesc;
    }

    public void setTableDesc(String tableDesc) {
        this.tableDesc = tableDesc == null ? null : tableDesc.trim();
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId == null ? null : providerId.trim();
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public Long getOriginator() {
        return originator;
    }

    public void setOriginator(Long originator) {
        this.originator = originator;
    }

    public Byte getOriginatorType() {
        return originatorType;
    }

    public void setOriginatorType(Byte originatorType) {
        this.originatorType = originatorType;
    }

    public Byte getTableType() {
        return tableType;
    }

    public void setTableType(Byte tableType) {
        this.tableType = tableType;
    }

    public Short getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(Short userLimit) {
        this.userLimit = userLimit;
    }

    public Integer getCurUserNum() {
        return curUserNum;
    }

    public void setCurUserNum(Integer curUserNum) {
        this.curUserNum = curUserNum;
    }

    public String getTableLogo() {
        return tableLogo;
    }

    public void setTableLogo(String tableLogo) {
        this.tableLogo = tableLogo == null ? null : tableLogo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getIsStarted() {
        return isStarted;
    }

    public void setIsStarted(Byte isStarted) {
        this.isStarted = isStarted;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Byte isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Byte getBonusAllotType() {
        return bonusAllotType;
    }

    public void setBonusAllotType(Byte bonusAllotType) {
        this.bonusAllotType = bonusAllotType;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Date getDrawTime() {
        return drawTime;
    }

    public void setDrawTime(Date drawTime) {
        this.drawTime = drawTime;
    }

    public Date getDrawStartTime() {
        return drawStartTime;
    }

    public void setDrawStartTime(Date drawStartTime) {
        this.drawStartTime = drawStartTime;
    }

    public Date getDrawEndTime() {
        return drawEndTime;
    }

    public void setDrawEndTime(Date drawEndTime) {
        this.drawEndTime = drawEndTime;
    }

    public Boolean getDrawStatus() {
        return drawStatus;
    }

    public void setDrawStatus(Boolean drawStatus) {
        this.drawStatus = drawStatus;
    }

    public Integer getTotalDrawAmt() {
        return totalDrawAmt;
    }

    public void setTotalDrawAmt(Integer totalDrawAmt) {
        this.totalDrawAmt = totalDrawAmt;
    }

    public Integer getTotalTakeDrawAmt() {
        return totalTakeDrawAmt;
    }

    public void setTotalTakeDrawAmt(Integer totalTakeDrawAmt) {
        this.totalTakeDrawAmt = totalTakeDrawAmt;
    }

    public Integer getTotalRemainDrawAmt() {
        return totalRemainDrawAmt;
    }

    public void setTotalRemainDrawAmt(Integer totalRemainDrawAmt) {
        this.totalRemainDrawAmt = totalRemainDrawAmt;
    }

    public Integer getConsumeUserNum() {
        return consumeUserNum;
    }

    public void setConsumeUserNum(Integer consumeUserNum) {
        this.consumeUserNum = consumeUserNum;
    }

    public Integer getTakeDrawUserNum() {
        return takeDrawUserNum;
    }

    public void setTakeDrawUserNum(Integer takeDrawUserNum) {
        this.takeDrawUserNum = takeDrawUserNum;
    }

    public Integer getUntakeDrawUserNum() {
        return untakeDrawUserNum;
    }

    public void setUntakeDrawUserNum(Integer untakeDrawUserNum) {
        this.untakeDrawUserNum = untakeDrawUserNum;
    }

    public Integer getFakeConsumeSum() {
        return fakeConsumeSum;
    }

    public void setFakeConsumeSum(Integer fakeConsumeSum) {
        this.fakeConsumeSum = fakeConsumeSum;
    }

    public Boolean getIsUserOpt() {
        return isUserOpt;
    }

    public void setIsUserOpt(Boolean isUserOpt) {
        this.isUserOpt = isUserOpt;
    }

    public Integer getConsumeLimit() {
        return consumeLimit;
    }

    public void setConsumeLimit(Integer consumeLimit) {
        this.consumeLimit = consumeLimit;
    }

    public String getUserList() {
        return userList;
    }

    public void setUserList(String userList) {
        this.userList = userList == null ? null : userList.trim();
    }
}