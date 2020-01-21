package com.shinstealer.blog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shinstealer.blog.dto.PostsSaveRequestDTO;
import com.shinstealer.blog.webservice.PostService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	private PostService postService;

	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}

	@PostMapping("/posts")
	public Long savePosts(@RequestBody PostsSaveRequestDTO dto) {
		return postService.save(dto);
	}
}
