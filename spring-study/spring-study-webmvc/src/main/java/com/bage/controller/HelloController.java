package com.bage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/sayHello")
	public String sayHello(String text){
		System.out.println(text);
		return "example";
	}
	
}
