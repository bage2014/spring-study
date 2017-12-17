package com.bage.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Controller
@RequestMapping("application")
public class ApplicationContextController {

	@RequestMapping("context")
	@ResponseBody
	public String hello(HttpServletRequest request){
		StringBuffer result = new StringBuffer();
		ServletContext sc = request.getSession().getServletContext();   
		// 方式1
		ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);    
		// 方式2
		ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(sc);
		result.append("WebApplicationContextUtils.getRequiredWebApplicationContext(ServletContext):" + ac1 + "\n");
		result.append("WebApplicationContextUtils.getWebApplicationContext(ServletContext):" + ac2 + "\n");
		// 需要配置 org.springframework.web.context.ContextLoaderListener
		
		return result.toString();
	}
	
}
