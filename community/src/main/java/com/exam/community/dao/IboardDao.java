package com.exam.community.dao;

import java.util.List;
import java.util.Map;

import com.exam.community.Board;
import com.exam.community.Vote;
import com.exam.community.member;

public interface IboardDao {
	
	List<Board> boardList(); // �Խ��� ����Ʈ ���(�ֽż�)
	List<Board> boardViewList(); // ���� : ��ȸ�� ����� �Խ��� ���
	List<Board> boardLoveList(); // ���� : ��õ�� ����� �Խ��� ���
	void boardCreate(Board board); // �Խ��� �����
	Board boardRead(int index); // �ش� �Խ��� ���� ���
	List<Board> boardtitleList(String content); // �Խ��� ���� �������� �˻�
	List<Board> boarduseridList(String content); // �Խ��� ���̵� �������� �˻�
	
	void boardvoteUp(Map map); // ��õ�� Up
	void boardvoteDown(Map map); // ��õ�� Down
	
	void userVoteInfoInsert(Map map); // �ش� ������ ��õ ���� ���� 
	int userVoteInfoRead(Map map); // �ش� �������� �Խ��� ��õ���� �о����
	
	void boardCreateImage(Map map); //
	void boardDeleteImage(Map map); //
	List<String> ReadImageResource(Map map);
	
	
	void boardUpdate(Board board); // �Խ��� ����
	void boardViewUpdate(int index); // �Խ��� ��ȸ Up
	void boardRepeatUpdate(Map map); // �Խ��� ��ۼ�
	
	
}
