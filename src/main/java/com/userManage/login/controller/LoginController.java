package com.userManage.login.controller;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.BaseController;
import com.userManage.infoUser.service.InfoUserService;
import com.web.imgCode.RandomImageGenerator;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	private static Logger logger = Logger.getLogger(LoginController.class);  
	@Autowired
	private InfoUserService userService;
	
	private ByteArrayInputStream inputStream;
	
	@RequestMapping("/loginMethod")
	public String login(ModelMap modelMap){
		request.setAttribute("aaa", "bbb");
		return "/login";
	}
	/**
	 * 
	 * <p>@Title: validNumGenerate</p>
	 * <p>@Description:获取图片验证码</p>
	 * <p>@anthor:hezh</p>
	 * <p>@version:</p>
	 * <p>@data:2016年3月11日下午3:55:45</p>
	 * @throws Exception
	 */
	@RequestMapping("/validNum")
	public void validNumGenerate() throws Exception {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		
		RandomImageGenerator scc = RandomImageGenerator.getInstance();
		this.setInputStream(scc.getImage());
		System.out.println("validNumGenerate="+scc.getStr());
		request.getSession().setAttribute("random", scc.getStr());
		ServletOutputStream sos = response.getOutputStream();
		sos.write(scc.getImages());
		sos.flush();
		sos.close();
	}
	
	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}
}