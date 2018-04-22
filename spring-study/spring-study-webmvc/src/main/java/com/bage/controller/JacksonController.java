package com.bage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JacksonController {

        @GetMapping("/user")
        // @JsonView(User.WithoutPasswordView.class)
        public User getUser() {
                return new User("eric", "7!jd#h23");
        }
}

class User {

        public interface WithoutPasswordView {};
        public interface WithPasswordView extends WithoutPasswordView {};

        private String username;
        private String password;

        public User() {
        }

        public User(String username, String password) {
                this.username = username;
                this.password = password;
        }

        //@JsonView(WithoutPasswordView.class)
        public String getUsername() {
                return this.username;
        }

        //@JsonView(WithPasswordView.class)
        public String getPassword() {
                return this.password;
        }
}
