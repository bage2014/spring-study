package com.bage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RedirectingController {
	
	@PostMapping("/files/{path}")
	public String upload() {
	        // ...
		// 默认 ： The forward: prefix
	        return "redirect:files/{path}";
	}
}
