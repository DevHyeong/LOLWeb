package com.exam.community.service;

import java.util.List;
import java.util.Map;

import com.exam.community.Board;

public interface IboardService {
	
	List<Board> boardList(String sort);
	void boardCreate(Board board);
	Board boardRead(int index);
	List<Board> boardFind(String target, String content);
	void boardvote(Map<Object,Object> obj);
	int uservoteInfo(Map map);
	
	void boardCreateImage(Board board,String image);
	void boardDeleteImage(Board board);
	
	void boardUpdate(Board board,String path,String image);
	void boardViewUpdate(int index);
	
	
}
