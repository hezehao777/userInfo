package com.userManage.infoUser.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.userManage.infoUser.entity.InfoUser;
import com.userManage.infoUser.service.InfoUserService;

@Controller
@RequestMapping("/user")
public class InfoUserController {
	private static Logger logger = Logger.getLogger(InfoUserController.class);  
	@Autowired
	private InfoUserService userService;
	String info="";
	@RequestMapping("/showInfo/{userId}")
	public String showUserInfo(ModelMap modelMap, @PathVariable int userId){
		logger.debug("123456");
		logger.info("qweqwe");
		logger.warn("!!!!!");
		InfoUser infoUser = userService.getUserById(userId);
		modelMap.addAttribute("userInfo", infoUser);
		return "/user/showInfo";
	}
	
	@RequestMapping("/showAllInfo")
	public String showAllInfo(ModelMap modelMap){
		List<InfoUser> infoUser = userService.getAll();
		modelMap.addAttribute("userInfo", infoUser);
		return "/user/showInfo";
	}
	
}