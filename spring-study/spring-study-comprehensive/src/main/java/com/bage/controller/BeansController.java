package com.bage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bage.domain.AutowiredBean;
import com.bage.domain.JavaConfigBean;
import com.bage.domain.XMLBean;

@Controller
@RequestMapping("beans")
public class BeansController {

	@Autowired
	private JavaConfigBean javaConfigBean;
	
	@Autowired
	private AutowiredBean autowiredBean;

	@Autowired
	private XMLBean xmlBean;
	
	@RequestMapping("bean")
	@ResponseBody
	public String hello(){
		StringBuffer result = new StringBuffer();
		result.append("javaConfigBean:" + javaConfigBean + "\n");
		result.append("autowiredBean:" + autowiredBean + "\n");
		result.append("xmlBean:" + xmlBean + "\n");
		return result.toString();
	}
	
}
