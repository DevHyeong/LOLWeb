package com.exam.community.service;

import java.util.List;

import com.exam.community.Repeat;
import com.exam.community.Reply;

public interface IRepeatService {
	List<Repeat> RepeatRead(int index);
	void repeatInsert(Repeat repeat);
	void repeatUpdate(Repeat repeat);
	void repeatDelete(Repeat repeat);
	
	void ReplyInsert(Reply reply);
	void ReplyUpdate(Reply reply);
	void ReplyDelete(Reply reply);
	
	List<Reply> replyRead(int index);
	
	
}
