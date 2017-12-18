package com.bage.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Controller
@RequestMapping("resource")
public class ResourceController {
	
	@RequestMapping("properties")
	@ResponseBody
	public String hello(HttpServletRequest request){
		ServletContext sc = request.getSession().getServletContext(); 
		ApplicationContext cnt = WebApplicationContextUtils.getWebApplicationContext(sc );
		return cnt.getEnvironment().getProperty("jdbc.url") + "," + cnt.getBean("xmlBeanForImport");
	}
	
}
