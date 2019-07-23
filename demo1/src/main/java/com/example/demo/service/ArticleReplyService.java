package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ArticleReply;


@Component
public interface ArticleReplyService {
	public List<ArticleReply> getList(long articleId);

	public long addReply(Map<String, Object> args, HttpSession session);

	public void updateReply(Map<String, Object> args);
	
	public String deleteReply(long id, HttpSession session);
}
