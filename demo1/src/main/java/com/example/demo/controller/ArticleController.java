package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.groovy.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Article;
import com.example.demo.dto.ArticleReply;
import com.example.demo.dto.Member;
import com.example.demo.service.ArticleReplyService;
import com.example.demo.service.ArticleService;
import com.example.demo.service.MemberService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleReplyService articleReplyService;
	
	@RequestMapping("article/list")
	public String showList(Model model, @RequestParam Map<String, Object> param) {
		param.put("extra__repliesCount ",true);
		List<Article> list = articleService.getList(param);
		model.addAttribute("list", list);
		return "article/list";
	}

	@RequestMapping("article/add")
	public String showAdd() {
		return "article/add";
	}
	
	@RequestMapping("article/detail")
	public String detail(@RequestParam(value="id", defaultValue = "0") int id, Model model) {
		Article article = articleService.getOne(Maps.of("id", id));
		List<ArticleReply> articleRelyList = articleReplyService.getList(id);
		model.addAttribute("article", article);
		model.addAttribute("articleRelyList", articleRelyList);
		return "article/detail";
	}
	
	@RequestMapping("article/doAdd")
	@ResponseBody
	public String doAdd(@RequestParam Map<String, Object> param, HttpSession session) {
		articleService.add(param, session);
		return "<script>alert('글을 작성했습니다.'); location.replace('./detail?id="+param.get("id")+"');</script>";
	}
	
	@RequestMapping("article/doAddReply")
	@ResponseBody
	public String doAddReply(@RequestParam Map<String, Object> param, HttpSession session) {
		articleReplyService.addReply(param, session);
		return "<script>alert('댓글을 작성했습니다.'); location.replace('./detail?id="+param.get("articleId")+"');</script>";
	}
	
	@RequestMapping("article/doDeleteReply")
	@ResponseBody
	public String doDeleteReply(long id, HttpSession session) {
		String asdf = articleReplyService.deleteReply(id, session);
		return asdf;
	}
}