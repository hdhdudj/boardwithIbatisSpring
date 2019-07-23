package com.example.demo.dto;

import org.springframework.web.util.HtmlUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ArticleReply {
	private long id;
	private String regDate;
	private String body;
	private String writer;
	private long memberId;
	private long boardId;
	private long articleId;
	
	public String getBodyForPrint() {
		String bodyForPrint = HtmlUtils.htmlEscape(body);
		bodyForPrint = bodyForPrint.replace("\n", "<br>");

		return bodyForPrint;
	}
}
