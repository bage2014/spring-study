package com.bage.resources;

import java.net.MalformedURLException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
		Resource urlResource = new UrlResource("");
		Resource classPathResource = new ClassPathResource("");
		Resource fileSystemResource = new FileSystemResource("");
		//Resource servletContextResource = new ServletContextResource("");
		
	}
}
