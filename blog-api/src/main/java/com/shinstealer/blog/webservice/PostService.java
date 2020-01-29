package com.shinstealer.blog.webservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shinstealer.blog.domain.PostsRepository;
import com.shinstealer.blog.dto.PostListResponseDTO;
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
	@Transactional
    public void deletePost(Long id) {
		postsRepository.deleteById(id);
    }

	@Transactional(readOnly = true)
	public List<PostListResponseDTO> findAllDesc() {
		return postsRepository.findAllDesc().map(PostListResponseDTO::new).collect(Collectors.toList());
	}
}
