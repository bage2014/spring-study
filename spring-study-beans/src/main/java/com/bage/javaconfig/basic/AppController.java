package com.bage.javaconfig.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class AppController {

	@RequestMapping("/index")
	public String index(){
		System.out.println("AppController.app is work... ");
		return "index";
	}
	
}
