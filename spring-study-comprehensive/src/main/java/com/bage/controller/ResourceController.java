package com.bage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bage.domain.HsqldbDataSource;

@Controller
@RequestMapping("resource")
public class ResourceController {
	
	@Autowired
	private HsqldbDataSource hsqldbDataSource;
	
	@Autowired
	private Environment environment;
	
	@Value("${jdbc.url}")
	private String url ;
	
	@RequestMapping("properties")
	@ResponseBody
	public String properties(HttpServletRequest request){
		return url;
	}

	@RequestMapping("environment")
	@ResponseBody
	public String environment(HttpServletRequest request){
		return environment.getProperty("jdbc.url", "defaultValue");
	}
	
	@RequestMapping("hsqldbDataSource")
	@ResponseBody
	public String hsqldbDataSource(HttpServletRequest request){
		return hsqldbDataSource + "";
	}
	
}
