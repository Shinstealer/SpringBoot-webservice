package com.shinstealer.blog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}

	
}
