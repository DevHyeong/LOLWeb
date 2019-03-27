package com.exam.community.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.exam.community.Repeat;
import com.exam.community.Reply;


@Repository
public class RepeatDao implements IRepeatDao{
	
	
	@Inject
	private SqlSession sqlsession;
	
	private String namespace = "com.exam.community.repeatMapper";
	
	@Override
	public List<Repeat> repeatRead(int index) {
		// TODO Auto-generated method stub
		
		return sqlsession.selectList(namespace+".repeatRead",index);
	}

	@Override
	public void repeatInsert(Repeat repeat) {
		// TODO Auto-generated method stub
		sqlsession.insert(namespace +".repeatInsert",repeat);
	}

	@Override
	public List<Reply> replyRead(int index) {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".replyRead",index);
	}

	@Override
	public void replyInsert(Reply reply) {
		// TODO Auto-generated method stub
		System.out.println("dao" + reply.getContent());
		sqlsession.insert(namespace + ".replyInsert",reply);
	}

	@Override
	public List<Reply> replyReadAboutRepeat(int index) {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace + ".replyReadAboutRepeat",index);
	}

	@Override
	public void repeatDelete(int index) {
		// TODO Auto-generated method stub
		sqlsession.delete(namespace + ".repeatDelete",index);
	}

	@Override
	public void replyDelete(int index) {
		// TODO Auto-generated method stub
		sqlsession.delete(namespace+".replyDelete",index);
	}
	
	
	
	
	
	
}
