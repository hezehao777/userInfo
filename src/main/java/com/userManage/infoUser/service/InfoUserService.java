package com.userManage.infoUser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userManage.infoUser.dao.InfoUserMapper;
import com.userManage.infoUser.entity.InfoUser;
@Service("userService")
@Transactional
public class InfoUserService{

	@Autowired
	private InfoUserMapper userInfoMapper;

	public InfoUser getUserById(int id) {
		return userInfoMapper.selectByPrimaryKey(id);
	}
	
	
	public List<InfoUser> getAll(){
		return userInfoMapper.selectAll();
	}


	public int insert(InfoUser userInfo) {
		
		int result = userInfoMapper.insert(userInfo);
		
		System.out.println(result);
		return result;
	}

}
