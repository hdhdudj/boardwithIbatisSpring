package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.Member;

public interface MemberService {

	public Map<String, Object> login(Map<String, Object> param);

	public Member getOne(long id);

}