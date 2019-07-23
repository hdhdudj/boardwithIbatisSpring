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
	
	public String delete(long id, HttpSession session) {
		long memberId = (long) session.getAttribute("loginedMemberId");
		Article article = articleDao.getOneById(id);
		if(article.getMemberId() == memberId) {
			articleDao.delete(id);
			return "<script>alert('글이 삭제되었습니다.'); location.replace('./list');</script>";
		}
		return "<script>alert('글을 삭제할 수 없습니다.'); location.replace('./detail?id="+article.getId()+"');</script>";
	}
}