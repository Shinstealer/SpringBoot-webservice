package com.shinstealer.blog.xss;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shinstealer.blog.utils.HtmlCharacterEscapes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
@ConditionalOnProperty(name = "test.type", havingValue = "3")
public class WebMvcConfig3 {

	@Bean
	public MappingJackson2HttpMessageConverter jsonEscapesConverter() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.getFactory().setCharacterEscapes(new HtmlCharacterEscapes());

		return new MappingJackson2HttpMessageConverter(mapper);
	}

}
