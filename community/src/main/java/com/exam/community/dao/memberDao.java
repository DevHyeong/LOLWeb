package com.exam.community.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.exam.community.member;


@Repository
public class memberDao implements ImemberDao{
	
	@Inject
	private SqlSession sqlsession;
	
	private String namespace = "com.exam.community.memberMapper";
	
	@Override
	public void memberJoin(member member) {
		// TODO Auto-generated method stub
		sqlsession.insert(namespace+".memberJoin",member);
	}

	@Override
	public int idCheck(String userID) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace+".idCheck",userID);
	}

	@Override
	public int NicknameCheck(String name) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace+".NicknameCheck",name);
	}

	@Override
	public member memberLogin(String userid) {
		// TODO Auto-generated method stub
		System.out.println("dao"+userid);
		return sqlsession.selectOne(namespace+".login",userid);
	}

}
