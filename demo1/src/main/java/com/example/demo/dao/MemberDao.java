package com.example.demo.dao;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Member;

@Mapper
public interface MemberDao {

	public Member getMatchedOne(Map<String, Object> param);

	public Member getOne(long loginedMemberId);

}