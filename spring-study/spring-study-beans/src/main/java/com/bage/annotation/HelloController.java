package com.bage.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	SayHello hello;

	@RequestMapping("/sayHello")
	public String sayHello() {
		System.out.println(hello.sayHello("jjjj"));
		return "example";
	}

}
