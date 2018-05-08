package com.wuwaikeji.luyou.persistence;

import com.wuwaikeji.luyou.domain.UserRelations;
import com.wuwaikeji.luyou.domain.UserRelationsKey;

public interface UserRelationsMapper {
    int deleteByPrimaryKey(UserRelationsKey key);

    int insert(UserRelations record);

    int insertSelective(UserRelations record);

    UserRelations selectByPrimaryKey(UserRelationsKey key);

    int updateByPrimaryKeySelective(UserRelations record);

    int updateByPrimaryKey(UserRelations record);
}