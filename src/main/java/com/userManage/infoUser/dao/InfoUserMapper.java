package com.userManage.infoUser.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.userManage.infoUser.entity.InfoUser;
@Repository
public interface  InfoUserMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(InfoUser record);

    int insertSelective(InfoUser record);

    InfoUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InfoUser record);

    int updateByPrimaryKey(InfoUser record);
    List<InfoUser> selectAll();
}