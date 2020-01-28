package com.shinstealer.blog.xss;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class XssReqController {

	@PostMapping("/xss")
	public String xss(@RequestBody XssReqDto dto) {

		log.info("ReqDTO =", dto);
		return dto.getContent();
	}
}
