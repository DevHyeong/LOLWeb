package com.exam.community.dao;

import com.exam.community.member;

public interface ImemberDao {
	void memberJoin(member member);
	int idCheck(String userID);
	int NicknameCheck(String name);
	member memberLogin(String userid);
}
