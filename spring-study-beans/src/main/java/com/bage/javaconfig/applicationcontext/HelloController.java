package com.bage.javaconfig.applicationcontext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello(HttpServletRequest request){
		ServletContext sc = request.getSession().getServletContext();   
		// 方式1
		ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);    
		// 方式2
		ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(sc);
		
		return ac1.getBean("template") + ",,," + ac2.getBean("templateSrc");
	}
}
