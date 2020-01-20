package com.shinstealer.blog.webservice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shinstealer.blog.domain.PostsRepository;
import com.shinstealer.blog.dto.PostsSaveRequestDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostService {

	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDTO dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
}
