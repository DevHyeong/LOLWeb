package com.exam.community.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.exam.community.Board;
import com.exam.community.Vote;
import com.exam.community.member;


@Repository
public class boardDao implements IboardDao {
	
	private String namespace="com.exam.community.boardMapper";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public List<Board> boardList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".boardlist");
	}

	@Override
	public void boardCreate(Board board) {
		// TODO Auto-generated method stub
		
		//에러처리 어떻게?
		sqlSession.insert(namespace+".boardCreate",board);
		
	}

	@Override
	public Board boardRead(int index) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".boardRead", index);
	}

	@Override
	public List<Board> boardViewList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".boardViewlist");
	}

	@Override
	public List<Board> boardLoveList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".boardLoveList");
	}

	@Override
	public List<Board> boardtitleList(String content) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".boardSearchTitle",content);
	}

	@Override
	public List<Board> boarduseridList(String content) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".boardSearchUserid",content);
	}

	@Override
	public void boardvoteUp(Map map) {
		// TODO Auto-generated method stub
		
		sqlSession.update(namespace+".boardVoteUp",map);
		
	}

	@Override
	public void boardvoteDown(Map map) {
		// TODO Auto-generated method stub
		
		sqlSession.update(namespace+".boardVoteDown",map);
		
	}

	@Override
	public void userVoteInfoInsert(Map map) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".userVoteInfoInsert",map);
	}

	@Override
	public int userVoteInfoRead(Map map) {
		// TODO Auto-generated method stub
		Integer result = sqlSession.selectOne(namespace+".userVoteInfoRead",map);
		
		if(result == null) {
			return 0;
		}
		return result;
	}

	@Override
	public void boardCreateImage(Map map) {
		// TODO Auto-generated method stub
		sqlSession.selectOne(namespace + ".insertImage",map);
	}

	@Override
	public void boardUpdate(Board board) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".boardUpdate",board);
	}

	@Override
	public void boardDeleteImage(Map map) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".deleteImage",map);
	}

	@Override
	public List<String> ReadImageResource(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".ReadImageResource",map);
	}

	@Override
	public void boardViewUpdate(int index) {
		sqlSession.update(namespace+".boardView",index);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void boardRepeatUpdate(Map map) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".boardRepeatUpdate",map);
	}
	
	
	
	

	
	
}
