package com.exam.community;

public class Reply {
	
	private int idx;
	private String userid;
	private String nickname;
	private String date;
	private String content;
	private int board_idx;
	private int repeat_idx;
	private int pointer; // 답글에 대한 답글 처리일 경우 value = Reply의 index값, 댓글에 대한 답글일시 value = 0; 
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public int getRepeat_idx() {
		return repeat_idx;
	}
	public void setRepeat_idx(int repeat_idx) {
		this.repeat_idx = repeat_idx;
	}
	public int getPointer() {
		return pointer;
	}
	public void setPointer(int pointer) {
		this.pointer = pointer;
	}
	
	
	
	
	
	
}
