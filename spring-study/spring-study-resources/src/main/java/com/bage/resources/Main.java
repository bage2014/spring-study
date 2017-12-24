package com.bage.resources;

import java.net.MalformedURLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;

public class Main {
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws MalformedURLException {
		
		Resource urlResource = new UrlResource("");
		Resource classPathResource = new ClassPathResource("");
		Resource fileSystemResource = new FileSystemResource("");
		//Resource servletContextResource = new ServletContextResource("");
		// InputStreamResource
		//2.3.6. ByteArrayResource
		
		// 2.4. The ResourceLoader
		ResourceLoader resourceLoader;
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext();
		
		Resource template = ctx.getResource("classpath:some/resource/path/myTemplate.txt");
		template = ctx.getResource("file:///some/resource/path/myTemplate.txt");
		template = ctx.getResource("http://myhost.com/resource/path/myTemplate.txt");
	
		//2.6. Resources as dependencies
		// <property name="template" value="classpath:some/resource/path/myTemplate.txt">
	
		//
		ctx = new ClassPathXmlApplicationContext("conf/appContext.xml");
		ctx = new FileSystemXmlApplicationContext("conf/appContext.xml");
		//ctx = new ClassPathXmlApplicationContext(new String[] {"services.xml", "daos.xml"}, MessengerService.class);
		//  /WEB-INF/*-context.xml
		//  com/mycompany/**/applicationContext.xml
		//  file:C:/some/path/*-context.xml
		//  classpath:com/mycompany/**/applicationContext.xml
		
	
	}
}
