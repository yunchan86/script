package com.yacol.mybatis.beans;

public class OrderBatchIdMBEntityKey {
    private Long orderBatchId;

    private String serverId;

    public Long getOrderBatchId() {
        return orderBatchId;
    }

    public void setOrderBatchId(Long orderBatchId) {
        this.orderBatchId = orderBatchId;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId == null ? null : serverId.trim();
    }
}