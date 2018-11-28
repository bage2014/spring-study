package com.bage.controller;

import java.awt.print.Book;
import java.util.concurrent.TimeUnit;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cache")
public class CacheController {

	@GetMapping("/book/{id}")
	public ResponseEntity<Book> showBook(@PathVariable Long id) {
			// 暂时注释掉
	        Book book = null;//findBook(id);
	        String version = null;//book.getVersion();

	        return ResponseEntity
	                                .ok()
	                                .cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS))
	                                .eTag(version) // lastModified is also available
	                                .body(book);
	}
}
