package com.exam.community.dao;

import java.util.List;

import com.exam.community.Repeat;
import com.exam.community.Reply;

public interface IRepeatDao {
	List<Repeat> repeatRead(int index);
	void repeatInsert(Repeat repeat);
	void repeatDelete(int index);
	
	
	
	List<Reply> replyRead(int index);
	List<Reply> replyReadAboutRepeat(int index);
	void replyInsert(Reply reply);
	void replyDelete(int index);
}
