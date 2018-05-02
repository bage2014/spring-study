package com.bage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bage.domain.User;

@RequestMapping("/modelmap")
public class ModelMapController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

            List<String> cartItems = null;// get a List of CartItem objects
            User user = null;// get the User doing the shopping

            ModelAndView mav = new ModelAndView("displayShoppingCart"); // <-- the logical view name

            mav.addObject(cartItems); // <-- look ma, no name, just the object
            mav.addObject(user); // <-- and again ma!

            return mav;
    }
}
