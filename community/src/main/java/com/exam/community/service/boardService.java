package com.exam.community.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.community.Board;
import com.exam.community.dao.boardDao;


@Service
public class boardService implements IboardService {
	
	@Autowired
	boardDao dao;
	
	
	
	
	@Override
	public List<Board> boardList(String sort) {
		// TODO Auto-generated method stub
		
		
		
		if(sort == null) { //최신순
			
			return dao.boardList();
			
		}else if(sort.equals("popular")) {
			
			return dao.boardLoveList();
			
		}else if(sort.equals("lookup")) {
			
			return dao.boardViewList();
		}else { // 페이지없음
			return null;
		}
		
		
		
	}




	@Override
	public void boardCreate(Board board) {
		// TODO Auto-generated method stub
		
		String dTime = date();
		
		board.setDate(dTime);
		board.setView_count(0);
		
		
		
		dao.boardCreate(board);
	}
	@Override
	public Board boardRead(int index) {
		// TODO Auto-generated method stub
		return dao.boardRead(index);
	}




	@Override
	public List<Board> boardFind(String target, String content) {
		// TODO Auto-generated method stub
		
		if(target.equals("title")) {
			return dao.boardtitleList(content);
		}else {
			return dao.boarduseridList(content);
		}
		
		
		
	}




	@Override
	public void boardvote(Map<Object,Object> obj) {
		// TODO Auto-generated method stub
		//active = 1 click on
		// active = 0 click off
		String vote = obj.get("vote").toString();
		int check = Integer.parseInt(obj.get("check").toString());
		int index = Integer.parseInt(obj.get("index").toString());
		int count = Integer.parseInt(obj.get("count").toString());
		String userid = obj.get("userid").toString();
		
		
		Map<String, Object> map = new HashMap();
		map.put("index", index);
		map.put("userid", userid);
		map.put("count", 1);
		
		if(vote.equals("thumb_up") && count == 1) {
			map.put("vote", 1);
			dao.boardvoteUp(map);
			if(check == 1) {
				map.put("count", -1);
				dao.boardvoteDown(map);
				
			}
			
			
		}else if(vote.equals("thumb_up") && count == 0){
			map.put("vote", 0); // 각 user정보에 담을 데이터
			map.put("count", -1);
			dao.boardvoteUp(map);
			
		}else if(vote.equals("thumb_down") && count == 1) {
			map.put("vote", -1);
			dao.boardvoteDown(map);
			if(check == 1) {
				map.put("count", -1);
				dao.boardvoteUp(map);
				
			}
			
		}else {
			map.put("vote", 0);
			map.put("count", -1);
			dao.boardvoteDown(map);
		}
		
		dao.userVoteInfoInsert(map);
	}




	@Override
	public int uservoteInfo(Map map) {
		// TODO Auto-generated method stub
		return dao.userVoteInfoRead(map);
		
		
		
		
	}




	@Override
	public void boardCreateImage(Board board,String image) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap();
		
		
		map.put("userid", board.getUserid());
		map.put("board_idx", board.getIdx());
		
		System.out.println("서비스들어옴");
		
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(image);
			JSONObject json = (JSONObject)obj;
			Iterator<String> iterator = json.keySet().iterator();
			
			while(iterator.hasNext()) {
				String key = iterator.next();
				
				map.put("image_url",json.get(key).toString());
				dao.boardCreateImage(map);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}




	@Override
	public void boardUpdate(Board board,String path,String image) {
		// TODO Auto-generated method stub
		
		String time = date()+"(수정됨)";
		board.setDate(time);
		
		
		dao.boardUpdate(board);
		Map<String,Object> map = new HashMap();
		
		
		
		map.put("userid", board.getUserid());
		map.put("board_idx", board.getIdx());
		
		// db테이블에 저장된 url정보.
		List<String> Resources = dao.ReadImageResource(map);
		List<Integer> index = new ArrayList<>();
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(image);
			JSONObject json = (JSONObject)obj;
			Iterator<String> iterator = json.keySet().iterator();
			boolean check = false;
			
			while(iterator.hasNext()) {
				String key = iterator.next();
				
				String url = json.get(key).toString();
				// 수정된 이미지 파일의 url 정보들
				
				System.out.println("url" + url);
				
				
				for(int i=0; i<Resources.size(); i++) {
					System.out.println("save url" + Resources.get(i).toString());
					
					if(url.equals(Resources.get(i).toString())) {
						check = true;
						index.add(i);
					}
				}
				if(!check) { // if check == false;
					map.put("image_url",url);
					dao.boardCreateImage(map);
				}
				
			}
			
			
			for(int i=0; i<Resources.size(); i++) {
				// 인덱스값이 index배열에 없을경우 삭제
				check = false;
				for(int j=0; j<index.size(); j++) {
					if(Integer.parseInt(index.get(j).toString()) == i) {
						check = true;
					}
					
				}
				if(!check) {
					String filepath = path+Resources.get(i).toString();
					File file = new File(filepath);
					if( file.exists() ){
						if(file.delete()){
							System.out.println("파일삭제 성공");
							map.put("image_url", Resources.get(i).toString());
							dao.boardDeleteImage(map);
				        }else{
				        	System.out.println("파일삭제 실패");
				        }
					}else{
						System.out.println("파일이 존재하지 않습니다.");
				    }
				}
				
				
				
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}




	@Override
	public void boardDeleteImage(Board board) {
		// TODO Auto-generated method stub
		
	}

	public String date() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		Date currentTime = new Date();
		String dTime = formatter.format(currentTime);
		return dTime;
	}




	@Override
	public void boardViewUpdate(int index) {
		// TODO Auto-generated method stub
		
		
		
		dao.boardViewUpdate(index);
	}
	
	
	
	
	
	
}
