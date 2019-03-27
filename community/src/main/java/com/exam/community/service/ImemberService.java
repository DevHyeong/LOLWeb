package com.exam.community.service;

import com.exam.community.member;

public interface ImemberService {
	void memberJoin(member member);
	int idCheck(String userID);
	int NicknameCheck(String name);
	member memberLogin(member member);
	
}
