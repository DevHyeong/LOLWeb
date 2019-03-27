package com.exam.community.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.exam.Riot.champ.ChampInfo;

@Repository
public class lolDao implements IlolDao{
	
	
	private String namespace="com.exam.community.lolMapper";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void InsertChampInfo(ChampInfo champ) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".insertChampInfo",champ);
	}

	@Override
	public ChampInfo ReadChampInfo(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".ReadChampInfo", map);
	}
	
	
	
	
	

}
