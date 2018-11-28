package com.bage.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.AbstractController;

@ControllerAdvice
public class AdvisingController {

	// Target all Controllers annotated with @RestController
	@ControllerAdvice(annotations = RestController.class)
	public class AnnotationAdvice {}

	// Target all Controllers within specific packages
	@ControllerAdvice("org.example.controllers")
	public class BasePackageAdvice {}

	// Target all Controllers assignable to specific classes
	@ControllerAdvice(assignableTypes = {ControllerInterface.class, AbstractController.class})
	public class AssignableTypesAdvice {}
	
}
