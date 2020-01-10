package com.shinstealer.blog.domain;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

	@Autowired
	PostsRepository postsRepository;

	@After
	public void cleanup() {

		postsRepository.deleteAll();
	}

	@Test
	public void 게시글저장_불러오기() {
		// given
		postsRepository.save(Posts.builder()
				.title("siba")
				.content("tired")
				.author("shinstealer").build());

		// when
		List<Posts> postsList = postsRepository.findAll();

		// then
		Posts posts = postsList.get(0);
	
		assertThat(posts.getAuthor(), is("shinstealer"));
	}
}
