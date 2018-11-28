package com.bage.controller;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Controller
@RequestMapping("/streaming")
public class StreamingController {
	
	@RequestMapping("/download")
	public StreamingResponseBody handle() {
	        return new StreamingResponseBody() {
	                public void writeTo(OutputStream outputStream) throws IOException {
	                        // write...
	                }
	        };
	}
}
