package com.yacol.mybatis.mapper;

import com.yacol.mybatis.beans.OrderBatchIdMBEntityKey;

public interface OrderBatchIdMBEntityMapper {
    int deleteByPrimaryKey(OrderBatchIdMBEntityKey key);

    int insert(OrderBatchIdMBEntityKey record);

    int insertSelective(OrderBatchIdMBEntityKey record);
}