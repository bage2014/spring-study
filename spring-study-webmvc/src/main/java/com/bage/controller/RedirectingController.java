package com.bage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirecting")
public class RedirectingController {
	
	@PostMapping("/files/{path}")
	public String upload() {
	        // ...
		// 默认 ： The forward: prefix
	        return "redirect:files/{path}";
	}
}
