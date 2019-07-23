package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ArticleReplyDao;
import com.example.demo.dao.MemberDao;
import com.example.demo.dto.ArticleReply;
import com.example.demo.dto.Member;
import com.example.demo.util.CUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleReplyServiceImpl implements ArticleReplyService {
	@Autowired
	private ArticleReplyDao articleReplyDao;
	@Autowired
	private MemberDao memberDao;
	
	public List<ArticleReply> getList(long articleId){
		return articleReplyDao.getList(articleId);
	}

	public long addReply(Map<String, Object> args, HttpSession session) {
		long memberId = (long) session.getAttribute("loginedMemberId");
		Member member = memberDao.getOne(memberId);
		args.put("writer", member.getName());
		args.put("memberId", member.getId());
		articleReplyDao.doAddReply(args);
		
		return CUtil.getAsLong(args.get("id"));
	}

	public void updateReply(Map<String, Object> args) {
		
	}
	
	public String deleteReply(long id, HttpSession session) {
		long memberId = (long) session.getAttribute("loginedMemberId");
		ArticleReply articleReply = articleReplyDao.getOneReply(id);
		if(articleReply.getMemberId() == memberId) {
			articleReplyDao.doDeleteReply(id);
			return "<script>alert('댓글을 삭제했습니다.'); location.replace('./detail?id="+articleReply.getArticleId()+"');</script>";
		} 
		return "<script>alert('댓글을 삭제할 수 없습니다.'); history.back();</script>";
	}
}
