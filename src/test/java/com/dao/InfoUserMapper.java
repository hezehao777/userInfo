package com.dao;

import com.entity.InfoUser;

public interface InfoUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InfoUser record);

    int insertSelective(InfoUser record);

    InfoUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InfoUser record);

    int updateByPrimaryKey(InfoUser record);
}