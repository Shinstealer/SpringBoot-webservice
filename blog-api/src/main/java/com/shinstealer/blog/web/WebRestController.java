package com.shinstealer.blog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shinstealer.blog.domain.PostsRepository;
import com.shinstealer.blog.dto.PostsSaveRequestDTO;

@RestController
public class WebRestController {

	private PostsRepository postsRepository;

	public WebRestController(PostsRepository postsRepository) {
		this.postsRepository = postsRepository;
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}

	@GetMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDTO dto) {
		postsRepository.save(dto.toEntity());
	}
}
