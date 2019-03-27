package com.exam.community;

public class Pagination {
	
	private int cntList = 5; // 한 페이지에 출력될 게시물 수 
	private int pageList = 5; // 한 화면에 출력될 페이지 수
	private int totalPage; // 총 페이지 수	
	private int startPage; // 한 화면에 출력될 첫 페이지 값
	private int lastPage; // 한 화면에 출력될 마지막 페이지 값
	private int curPage; // 현재 페이지
	private int startIndex; // 한 화면에 출력될 게시물의 첫번째 인덱스
	private int LastIndex; // 한 화면에 출력될 게시물의 마지막 인덱스
	
	public Pagination(int totalList, int curPage) {
		
		this.totalPage = totalList / this.cntList; // 
		if(totalList % this.cntList !=0) {
			this.totalPage = this.totalPage + 1;
		}
		
		
		this.startPage = curPage / this.pageList + 1;
		this.lastPage = curPage / this.pageList + 5;
		if(this.totalPage < this.lastPage) {
			this.lastPage = this.totalPage;
		
		}
		this.startIndex = curPage * this.cntList - this.cntList;
		this.LastIndex = curPage * this.cntList;
		if(curPage == this.lastPage) { // 현재 페이지가 마지막 페이지일 경우 게시물 수가 10개가 아닐수도있음
			LastIndex = totalList;
		}
		this.curPage = curPage;
	}

	public int getCntList() {
		return cntList;
	}

	public void setCntList(int cntList) {
		this.cntList = cntList;
	}

	public int getPageList() {
		return pageList;
	}

	public void setPageList(int pageList) {
		this.pageList = pageList;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getLastIndex() {
		return LastIndex;
	}

	public void setLastIndex(int lastIndex) {
		LastIndex = lastIndex;
	}
	
	
	
	

}
