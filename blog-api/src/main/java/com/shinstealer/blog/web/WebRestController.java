package com.shinstealer.blog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shinstealer.blog.domain.PostsRepository;
import com.shinstealer.blog.dto.PostsSaveRequestDTO;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	private PostsRepository postsRepository;

	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}

	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDTO dto) {
		postsRepository.save(dto.toEntity());
	}
}
