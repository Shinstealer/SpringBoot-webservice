package com.shinstealer.blog.xss;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shinstealer.blog.utils.HtmlCharacterEscapes;

import lombok.extern.slf4j.Slf4j;

//각각의 테스트가 독립적으로 실행되기 위해 Config 클래스들은 모두 @ConditionalOnProperty 를 선언해서 사용합니다.
@Slf4j
@Configuration
@EnableWebMvc
@ConditionalOnProperty(name = "test.type", havingValue = "1")
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		log.info(">>>>>>>>>>>>>>>>>>> [WebMvcConfig1]");
		converters.add(htmlEscapingConverter());
	}

	private HttpMessageConverter<?> htmlEscapingConverter() {

		ObjectMapper mapper = new ObjectMapper();
		mapper.getFactory().setCharacterEscapes(new HtmlCharacterEscapes());

		return new MappingJackson2HttpMessageConverter(mapper);
	}

}
