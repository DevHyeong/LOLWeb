package com.exam.community.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.community.Repeat;
import com.exam.community.Reply;
import com.exam.community.dao.RepeatDao;
import com.exam.community.dao.boardDao;

@Service
public class RepeatService implements IRepeatService{
	
	@Autowired
	RepeatDao dao;
	
	@Autowired
	boardDao BoardDao;
	
	
	
	@Override
	public List<Repeat> RepeatRead(int index) {
		// TODO Auto-generated method stub
		
		return dao.repeatRead(index);
		
	}



	@Override
	public void repeatInsert(Repeat repeat) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		Date currentTime = new Date();
		String dTime = formatter.format(currentTime);
		Map map = new HashMap();
		
		map.put("count", 1);
		map.put("idx",repeat.getBoard_idx());
		
		repeat.setDate(dTime);
		
		dao.repeatInsert(repeat);
		BoardDao.boardRepeatUpdate(map);
	}



	@Override
	public void ReplyInsert(Reply reply) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		Date currentTime = new Date();
		String dTime = formatter.format(currentTime);
		
		Map map = new HashMap();
		
		map.put("count", 1);
		map.put("idx",reply.getBoard_idx());
		
		reply.setDate(dTime);
		dao.replyInsert(reply);
		BoardDao.boardRepeatUpdate(map);
	}



	@Override
	public List<Reply> replyRead(int index) {
		// TODO Auto-generated method stub
		return dao.replyRead(index);
	}



	@Override
	public void repeatUpdate(Repeat repeat) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void repeatDelete(Repeat repeat) {
		// TODO Auto-generated method stub
		List<Reply> reply = dao.replyReadAboutRepeat(repeat.getIdx());
		Map map = new HashMap();
		
		int cnt = (reply.size()+1)*-1;
		map.put("count", cnt);
		map.put("idx", repeat.getBoard_idx());
		
		dao.repeatDelete(repeat.getIdx());
		BoardDao.boardRepeatUpdate(map);
		
	}



	@Override
	public void ReplyUpdate(Reply reply) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void ReplyDelete(Reply reply) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		
		
		map.put("count", -1);
		map.put("idx", reply.getBoard_idx());
		
		
		BoardDao.boardRepeatUpdate(map);
		dao.replyDelete(reply.getIdx());
	}
	
	
	
	
	
	
	

}
