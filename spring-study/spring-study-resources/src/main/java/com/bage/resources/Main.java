package com.bage.resources;

import java.net.MalformedURLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
		Resource urlResource = new UrlResource("");
		Resource classPathResource = new ClassPathResource("");
		Resource fileSystemResource = new FileSystemResource("");
		//Resource servletContextResource = new ServletContextResource("");
		// InputStreamResource
		//2.3.6. ByteArrayResource
		
		// 2.4. The ResourceLoader
		ResourceLoader resourceLoader;
		ApplicationContext ctx = new ClassPathXmlApplicationContext();
		
		Resource template = ctx.getResource("classpath:some/resource/path/myTemplate.txt");
		template = ctx.getResource("file:///some/resource/path/myTemplate.txt");
		template = ctx.getResource("http://myhost.com/resource/path/myTemplate.txt");
	
	
	}
}
