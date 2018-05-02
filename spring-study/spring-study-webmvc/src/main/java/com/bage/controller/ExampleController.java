package com.bage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bage.domain.User;

@Controller
@RequestMapping("/example")
public class ExampleController {

	@RequestMapping("/user")
	@ResponseBody
	public String getUser() {
		return new User("eric", "7!jd#h23").toString();
	}

	@RequestMapping
	public String examplePage() {
		return "index";
	}
}
