package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.groovy.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.dto.Member;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao mdo;

	@Override
	public Map<String, Object> login(Map<String, Object> param) {
		Member loginedMember = (Member) mdo.getMatchedOne(param);

		String msg = null;
		String resultCode = null;

		long loginedMemberId = 0;

		if (loginedMember == null) {
			resultCode = "F-1";
			msg = "일치하는 회원이 없습니다.";

			return Maps.of("resultCode", resultCode, "msg", msg);
		}

		loginedMemberId = loginedMember.getId();

		resultCode = "S-1";
		msg = "로그인 되었습니다.";

		return Maps.of("resultCode", resultCode, "msg", msg, "loginedMemberId", loginedMemberId);
	}

	@Override
	public Member getOne(long loginedMemberId) {
		return mdo.getOne(loginedMemberId);
	}

}