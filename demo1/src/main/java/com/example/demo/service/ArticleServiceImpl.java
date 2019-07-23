package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ArticleDao;
import com.example.demo.dao.ArticleReplyDao;
import com.example.demo.dao.MemberDao;
import com.example.demo.dto.Article;
import com.example.demo.dto.ArticleReply;
import com.example.demo.dto.Member;
import com.example.demo.util.CUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private MemberDao memberDao;

	public List<Article> getList(Map<String, Object> args) {
		if (args.containsKey("extra__repliesCount") && (boolean) args.get("extra__repliesCount") == true) {
			args.put("leftJoin__articleReply", true);
			args.put("groupBy__id", true);
		}

		return articleDao.getList(args);
	}

	public Article getOne(Map<String, Object> args) {
		return articleDao.getOne(args);
	}

	public long add(Map<String, Object> args, HttpSession session) {
		long memberId = (long)session.getAttribute("loginedMemberId");
		Member member = memberDao.getOne(memberId);
		args.put("memberId", member.getId());
		args.put("writer", member.getName());
		articleDao.add(args);

		return CUtil.getAsLong(args.get("id"));
	}

	public void update(Map<String, Object> args) {
		articleDao.update(args);
	}
	
	public void delete(long id) {
		
	}
}