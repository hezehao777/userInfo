package com.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.userManage.infoUser.entity.InfoUser;
import com.userManage.infoUser.service.InfoUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml" })
@Service("testUserService")
public class TestUserService {
	private static final Logger LOGGER = Logger
			.getLogger(TestUserService.class);
	@Autowired
	private InfoUserService userService;

	
	@Test
	public void testQueryById1() {
		//InfoUser infoUser = userService.getUserById(1);
		//LOGGER.info(JSON.toJSON(infoUser));
	}

	@Test
	public void testQueryAll() {
	}

	@Test
	public void testInsert() {
		//InfoUser userInfo = new InfoUser();
		//userInfo.setUserName("xiaoming");
		//userInfo.setMobile("18721171151");
		//int result = userService.insert(userInfo);
		//System.out.println(result);
	}
	
	
}
