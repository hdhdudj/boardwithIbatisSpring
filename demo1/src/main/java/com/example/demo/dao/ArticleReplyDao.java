package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.ArticleReply;

@Mapper
public interface ArticleReplyDao {
	public List<ArticleReply> getList(long articleId);

	public void doAddReply(Map<String, Object> args);
	
	public void updateReply(Map<String, Object> args);

	public void doDeleteReply(long articleReplyId);
	
	public ArticleReply getOneReply(long id);
}
