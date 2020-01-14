package com.shinstealer.blog.dto;

import com.shinstealer.blog.domain.Posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PostsSaveRequestDTO {

	private String title;
	private String content;
	private String author;

	public Posts toEntity() {
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}
}
