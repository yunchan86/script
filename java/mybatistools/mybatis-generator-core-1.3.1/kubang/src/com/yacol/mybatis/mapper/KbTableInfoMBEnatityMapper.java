package com.yacol.mybatis.mapper;

import com.yacol.mybatis.beans.KbTableInfoMBEnatity;
import com.yacol.mybatis.beans.KbTableInfoMBEnatityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KbTableInfoMBEnatityMapper {
    int countByExample(KbTableInfoMBEnatityExample example);

    int deleteByExample(KbTableInfoMBEnatityExample example);

    int deleteByPrimaryKey(Long tableId);

    int insert(KbTableInfoMBEnatity record);

    int insertSelective(KbTableInfoMBEnatity record);

    List<KbTableInfoMBEnatity> selectByExampleWithBLOBs(KbTableInfoMBEnatityExample example);

    List<KbTableInfoMBEnatity> selectByExample(KbTableInfoMBEnatityExample example);

    KbTableInfoMBEnatity selectByPrimaryKey(Long tableId);

    int updateByExampleSelective(@Param("record") KbTableInfoMBEnatity record, @Param("example") KbTableInfoMBEnatityExample example);

    int updateByExampleWithBLOBs(@Param("record") KbTableInfoMBEnatity record, @Param("example") KbTableInfoMBEnatityExample example);

    int updateByExample(@Param("record") KbTableInfoMBEnatity record, @Param("example") KbTableInfoMBEnatityExample example);

    int updateByPrimaryKeySelective(KbTableInfoMBEnatity record);

    int updateByPrimaryKeyWithBLOBs(KbTableInfoMBEnatity record);

    int updateByPrimaryKey(KbTableInfoMBEnatity record);
}