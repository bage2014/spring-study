package com.bage.xml.scopes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Controller
@RequestMapping("/scope")
public class UserController {

	@RequestMapping("/loginAction")
	@ResponseBody
	public String login(HttpServletRequest request){
		ServletContext sc = request.getSession().getServletContext();   
		// 方式1
		ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);    
		// 方式2
		ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(sc);
		
		return ac1.getBean("loginAction")  + "," + ac2.getBean("loginAction");  
	}
	
	@RequestMapping("/userPreferences")
	@ResponseBody
	public String userPreferences(HttpServletRequest request){
		ServletContext sc = request.getSession().getServletContext();   
		// 方式1
		ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);    
		// 方式2
		ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(sc);
		
		return ac1.getBean("userPreferences")  + "," + ac2.getBean("userPreferences");  
	}

	@RequestMapping("/appPreferences")
	@ResponseBody
	public String appPreferences(HttpServletRequest request){
		ServletContext sc = request.getSession().getServletContext();   
		// 方式1
		ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);    
		// 方式2
		ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(sc);
		
		return ac1.getBean("appPreferences")  + "," + ac2.getBean("appPreferences");  
	}
}
