package com.exam.community;

public class Pagination {
	
	private int cntList = 5; // �� �������� ��µ� �Խù� �� 
	private int pageList = 5; // �� ȭ�鿡 ��µ� ������ ��
	private int totalPage; // �� ������ ��	
	private int startPage; // �� ȭ�鿡 ��µ� ù ������ ��
	private int lastPage; // �� ȭ�鿡 ��µ� ������ ������ ��
	private int curPage; // ���� ������
	private int startIndex; // �� ȭ�鿡 ��µ� �Խù��� ù��° �ε���
	private int LastIndex; // �� ȭ�鿡 ��µ� �Խù��� ������ �ε���
	
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
		if(curPage == this.lastPage) { // ���� �������� ������ �������� ��� �Խù� ���� 10���� �ƴҼ�������
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
