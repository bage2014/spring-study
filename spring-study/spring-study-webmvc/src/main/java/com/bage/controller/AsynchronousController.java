package com.bage.controller;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AsynchronousController {

	@PostMapping 
	// For applications configured with a web.xml be sure to update to version 3.0:
	// Asynchronous support must be enabled on the DispatcherServlet through the <async-supported>true</async-supported>
	public Callable<String> processUpload(final MultipartFile file) {

	        return new Callable<String>() {
	                public String call() throws Exception {
	                        // ...
	                        return "someView";
	                }
	        };

	}
	
	@RequestMapping("/quotes")
	@ResponseBody
	public DeferredResult<String> quotes() {
	        DeferredResult<String> deferredResult = new DeferredResult<String>();
	        // Save the deferredResult somewhere..
	        return deferredResult;
	}

	// In some other thread...
	// deferredResult.setResult(data);
}
