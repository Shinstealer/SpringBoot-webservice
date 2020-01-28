package com.shinstealer.blog.xss;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class XssReqDto {

	private String content;

	public XssReqDto(String content) {
		this.content = content;
	}
}
