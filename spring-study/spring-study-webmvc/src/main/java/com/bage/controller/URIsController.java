package com.bage.controller;

import java.net.URI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/hotels/{hotel}")
public class URIsController {

        @GetMapping("/bookings/{booking}")
        public String getBooking(@PathVariable Long booking) {

        	// ...
        	return "";
        }
        
        public void uri(){
        	UriComponents uriComponents = MvcUriComponentsBuilder
        	        .fromMethodName(URIsController.class, "getBooking", 21).buildAndExpand(42);

        	URI uri = uriComponents.encode().toUri();
        	System.out.println(uri);
        }
        
        public void urion(){
        	//UriComponents uriComponents = MvcUriComponentsBuilder
        	//        .fromMethodCall(on(URIsController.class).getBooking(21)).buildAndExpand(42);

        	//URI uri = uriComponents.encode().toUri();
        	
        	
        }
        
        public void dervletUri(){
        	UriComponentsBuilder base = ServletUriComponentsBuilder.fromCurrentContextPath().path("/en");
        	MvcUriComponentsBuilder builder = MvcUriComponentsBuilder.relativeTo(base);
        	// builder.withMethodCall(on(URIsController.class).getBooking(21)).buildAndExpand(42);

        	// URI uri = uriComponents.encode().toUri();
        }
        
}
