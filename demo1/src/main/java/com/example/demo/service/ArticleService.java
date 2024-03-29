package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.example.demo.dto.Article;

@Component
public interface ArticleService {
	public List<Article> getList(Map<String, Object> args);

	public Article getOne(Map<String, Object> args);

	public long add(Map<String, Object> args, HttpSession session);

	public void update(Map<String, Object> args);
	
	public String delete(long id, HttpSession session);
}