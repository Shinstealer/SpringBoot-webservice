package com.shinstealer.blog.xss;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shinstealer.blog.utils.HtmlCharacterEscapes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ConditionalOnProperty(name = "test.type", havingValue = "2")
public class WebMvcConfig2 implements WebMvcConfigurer{

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		log.info(">>>>>>>>>>>>>>>>>>> [WebMvcConfig2]");
		converters.add(htmlEscapingConverter());
	}

	private HttpMessageConverter<?> htmlEscapingConverter() {

		ObjectMapper mapper = new ObjectMapper();
		mapper.getFactory().setCharacterEscapes(new HtmlCharacterEscapes());

		return new MappingJackson2HttpMessageConverter(mapper);
	}
}
