package com.shinstealer.blog.redis;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest1 {

	@Autowired
	PointRedisRepository repository;

	@After
	public void tearDown() throws Exception {
		repository.deleteAll();
	}

	@Test
	public void basic_search() {
		// given
		String id = "coolldd";
		LocalDateTime refreshTime = LocalDateTime.of(2020, 01, 27, 0, 0);
		Point point = Point.builder()
				.id(id)
				.amount(1000L)
				.refreshTime(refreshTime).build();

		// when
		repository.save(point);

		// then
		Point savedPoint = repository.findById(id).get();
		assertThat(savedPoint.getAmount()).isEqualTo(1000L);
		assertThat(savedPoint.getRefreshTime()).isEqualTo(refreshTime);
	}

}
