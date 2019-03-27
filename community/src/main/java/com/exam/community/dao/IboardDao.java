package com.exam.community.dao;

import java.util.List;
import java.util.Map;

import com.exam.community.Board;
import com.exam.community.Vote;
import com.exam.community.member;

public interface IboardDao {
	
	List<Board> boardList(); // 게시판 리스트 출력(최신순)
	List<Board> boardViewList(); // 정렬 : 조회수 순대로 게시판 출력
	List<Board> boardLoveList(); // 정렬 : 추천수 순대로 게시판 출력
	void boardCreate(Board board); // 게시판 만들기
	Board boardRead(int index); // 해당 게시판 정보 출력
	List<Board> boardtitleList(String content); // 게시판 제목 기준으로 검색
	List<Board> boarduseridList(String content); // 게시판 아이디 기준으로 검색
	
	void boardvoteUp(Map map); // 추천수 Up
	void boardvoteDown(Map map); // 추천수 Down
	
	void userVoteInfoInsert(Map map); // 해당 유저의 추천 정보 기입 
	int userVoteInfoRead(Map map); // 해당 유저마다 게시판 추천정보 읽어오기
	
	void boardCreateImage(Map map); //
	void boardDeleteImage(Map map); //
	List<String> ReadImageResource(Map map);
	
	
	void boardUpdate(Board board); // 게시판 수정
	void boardViewUpdate(int index); // 게시판 조회 Up
	void boardRepeatUpdate(Map map); // 게시판 댓글수
	
	
}
