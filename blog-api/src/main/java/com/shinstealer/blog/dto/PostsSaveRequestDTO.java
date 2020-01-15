package com.shinstealer.blog.dto;

import com.shinstealer.blog.domain.Posts;

import lombok.Getter;

@Getter
public class PostsSaveRequestDTO {

	private String title;
	private String content;
	private String author;

	public Posts toEntity() {
		return Posts.builder().title(title).content(content).author(author).build();
	}
}
