package com.shinstealer.blog.webservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shinstealer.blog.domain.Posts;
import com.shinstealer.blog.domain.PostsRepository;
import com.shinstealer.blog.dto.PostsSaveRequestDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

	@Autowired
	private PostService postService;

	@Autowired
	private PostsRepository postsRepository;

	@After
	public void cleanUp() {
		postsRepository.deleteAll();
	}

	@Test
	public void saveDataInPostsTable() {
		PostsSaveRequestDTO dto = PostsSaveRequestDTO.builder()
				.author("shinstealer")
				.content("test")
				.title("test title")
				.build();

		postService.save(dto);

		Posts posts = postsRepository.findAll().get(0);
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
		assertThat(posts.getContent()).isEqualTo(dto.getContent());
		assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
	}

}
