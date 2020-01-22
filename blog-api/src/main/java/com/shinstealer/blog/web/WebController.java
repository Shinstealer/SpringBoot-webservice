package com.shinstealer.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shinstealer.blog.dto.PostsSaveRequestDTO;
import com.shinstealer.blog.webservice.PostService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

	private PostService postService;

	@GetMapping("/")
	public String main() {
		return "main";
	}

	@GetMapping("/posts")
	public String posts() {

		return "diary/upload_post";
	}

	@PostMapping("/posts")
	public String savePosts(@RequestBody PostsSaveRequestDTO dto) {

		postService.save(dto);
		return "/";

	}

	@GetMapping("/post-list")
	public String listPosts(Model model) {
		model.addAttribute("posts",postService.findAllDesc());
		return "diary/upload_list";
	}

}
