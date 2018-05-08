package com.wuwaikeji.luyou.domain;

import java.util.Date;

public class UserRelations extends UserRelationsKey {
    private Boolean isBlacklist;

    private String tag;

    private String label;

    private String source;

    private Date linkTime;

    private Date applyTime;

    public Boolean getIsBlacklist() {
        return isBlacklist;
    }

    public void setIsBlacklist(Boolean isBlacklist) {
        this.isBlacklist = isBlacklist;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Date getLinkTime() {
        return linkTime;
    }

    public void setLinkTime(Date linkTime) {
        this.linkTime = linkTime;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }
}