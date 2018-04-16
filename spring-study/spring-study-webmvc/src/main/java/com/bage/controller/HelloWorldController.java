package com.bage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // To enable autodetection of such annotated controllers, you add component scanning to your configuration
public class HelloWorldController {

        @RequestMapping("/helloWorld")
        public String helloWorld(Model model) {
                model.addAttribute("message", "Hello World!");
                return "helloWorld";
        }
}
