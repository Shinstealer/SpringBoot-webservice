package com.shinstealer.blog.xss;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "test.type=1")
public class XssTest0 {

	@Autowired
	TestRestTemplate temp;

	@Test
	public void change_tag() {
		String content = "<li>content</li>";
		String expected = "&lt;li&gt;content&lt;/li&gt;";
		ResponseEntity<XssReqDto> response = temp.postForEntity("/xss", new XssReqDto(content), XssReqDto.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getContent()).isEqualTo(expected);
	}

}
