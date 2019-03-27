package com.exam.community;

import java.util.Date;

public class Board {
	
	private int idx;
	private String title;
	private String userid;
	private String nickname;
	private String content_text;
	private String date;
	private int view_count;
	private int voteUp;
	private int voteDown;
	private int repeat_cnt;
	
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
	
	public int getRepeat_cnt() {
		return repeat_cnt;
	}
	public void setRepeat_cnt(int repeat_cnt) {
		this.repeat_cnt = repeat_cnt;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
	public String getContent_text() {
		return content_text;
	}
	public void setContent_text(String content_text) {
		this.content_text = content_text;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getVoteUp() {
		return voteUp;
	}
	public void setVoteUp(int voteUp) {
		this.voteUp = voteUp;
	}
	public int getVoteDown() {
		return voteDown;
	}
	public void setVoteDown(int voteDown) {
		this.voteDown = voteDown;
	}
	
	
	
	
	
	
}
