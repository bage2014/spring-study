package com.bage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bage.domain.User;

@RequestMapping("/jackson")
@RestController
public class JacksonController {

        @GetMapping("/user")
        // @JsonView(User.WithoutPasswordView.class)
        public User getUser() {
                return new User("eric", "7!jd#h23");
        }
        
        @GetMapping("/userStr")
        // @JsonView(User.WithoutPasswordView.class)
        public String userStr() {
                return new User("eric", "7!jd#h23").toString();
        }
}