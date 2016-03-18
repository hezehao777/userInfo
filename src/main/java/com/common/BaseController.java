package com.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	
	/**
	 * 初始化 request response 参数的 方法;
	 * 
	 * @param request
	 * @param response
	 */
	@ModelAttribute
	public void init(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
}
