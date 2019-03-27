package com.exam.community.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.exam.Riot.Time;
import com.exam.community.Board;
import com.exam.community.FileUtils;
import com.exam.community.Pagination;
import com.exam.community.Photo;
import com.exam.community.Repeat;
import com.exam.community.Reply;
import com.exam.community.member;
import com.exam.community.service.RepeatService;
import com.exam.community.service.boardService;


@Controller
public class BoardController {
	
	@Autowired
	boardService service;
	
	@Autowired
	RepeatService repeatService;
	
	
	@RequestMapping("/community")
	public String BoardList(@RequestParam(value="sort",required=false) String sort, 
			@RequestParam(value="page",defaultValue="1") int curPage,Model model) {
		
		
		
		/*if(!(sort == null || sort.equals("popular") || sort.equals("lookup"))){
			Syste
			return "/alaram/communitySort";
		}
		*/
		
		List<Board> board = service.boardList(sort);
		
		
		if(board.size() == 0) {
			System.out.println("빈칸");
			model.addAttribute("board",board);
			
		}else {
			Pagination page = new Pagination(board.size(),curPage);
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
			Date currentTime = new Date();
			String dTime = formatter.format(currentTime);
			
			System.out.println(dTime);
			
			for(int i=page.getStartIndex(); i<page.getLastIndex(); i++) {
				String date = board.get(i).getDate();
				String[] mdate = date.split(" ");
				if(dTime.equals(mdate[0])) {
					String time = mdate[1].substring(0, 5);
					
					board.get(i).setDate(time);
				}else {
					
					board.get(i).setDate(mdate[0]);
				}
				
				
			}
			
			
			
			
			model.addAttribute("page",page);
			model.addAttribute("board",board);
		}
		
		// 최신,인기,조회순이 아닌 다른 값이 들어올경우 예외처리.
		
		return "/community/community";
	}
	
	@RequestMapping("/community/find")
	public String Boardfind(@RequestParam("target") String target,
			@RequestParam("content") String content,Model model) {
		
		
		
		
		List<Board> board = service.boardFind(target, content);
		
		
		
		model.addAttribute("board",board);
		model.addAttribute("target",target);
		model.addAttribute("content",content);
		
		// 최신,인기,조회순이 아닌 다른 값이 들어올경우 예외처리.
		
		return "/community/find";
	}
	
	
	
	@RequestMapping("/community/{index}")
	public String BoardInfo(@PathVariable("index") int idx, 
			
			Model model,HttpServletRequest request) {
		
		Board board = service.boardRead(idx);
		List<Repeat> repeat = repeatService.RepeatRead(idx);
		List<Reply> reply = repeatService.replyRead(idx);
		//Map<String,Integer> map = new HashMap<String,Integer>();
		
		HttpSession session = request.getSession();
		
		
		//세션을 통해 조회수 클릭 중복 방지
		if(session.getAttribute("board_idx")!=null) {
			
			List<Integer> list = (List<Integer>)session.getAttribute("board_idx");
			//조회수 클릭된 게시판 index 값.
			
			boolean check = false;
			
			for(int i=0; i<list.size(); i++) {
				int board_idx = Integer.parseInt(list.get(i).toString());
				if(board_idx == idx) {
					check = true;
				}
				
			}
			if(check == false) {
				
				list.add(idx);
				session.removeAttribute("board_idx");
				session.setAttribute("board_idx", list);
				//조회수 증가
				service.boardViewUpdate(idx);
			}
			
			
		}else { 
			List<Integer> list = new ArrayList<>();
 			list.add(idx);
			session.setAttribute("board_idx", list);
			// 조회수 증가
			service.boardViewUpdate(idx);
			
		}
		
		
		if(session.getAttribute("user")!=null) {
			Map<String,Object> map = new HashMap<String,Object>();
			member member = (member)session.getAttribute("user");
			map.put("index", idx);
			map.put("userid", member.getUserid());
			int vote = service.uservoteInfo(map);
			
		
			model.addAttribute("vote",vote);
		
			
			
		}
		
	
		/*for(int i=0; i<reply.size(); i++) {
			Reply info = reply.get(i);
			
			if(info.getPointer() !=0) {
				for(int j=0; j<reply.size(); j++) {
					
					if(reply.get(j).getIdx() == info.getPointer()) {
						map.put(String.valueOf(info.getPointer()), j);
						break;
					}
				}
			}
		}
		System.out.println( "test" + map.get("6"));*/
		
		
		
		model.addAttribute("board",board);
		model.addAttribute("repeat",repeat);
		model.addAttribute("reply",reply);
		model.addAttribute("count",repeat.size() + reply.size());
		//model.addAttribute("index",map);
		
		return "/info";
	}
	
	/*@RequestMapping(value="/")
	public ModelAndView BoardSort(@RequestParam ) {
		ModelAndView mav = new ModelAndView();
		
		
		
		mav.setViewName("/index");
		return mav;
	}
	*/
	
	@RequestMapping("/write")
	public String BoardCreate() {
		
		
		
		return "/write";
	}
	
	
	@RequestMapping("/community/update/{index}")
	public String BoardUpdate(@PathVariable("index") int idx,
			HttpServletRequest request,Model model) {
		
		HttpSession session = request.getSession();
		member user = (member)session.getAttribute("user");
		Board board = service.boardRead(idx);
	
		
		if(user !=null) {
			if(!user.getUserid().equals(board.getUserid())) {
				return "/alaram/alert";
				
			}else {
				model.addAttribute("board",board);
				
				return "/update";
				
			}
			
		}else {
			return "/alaram/alert";
		}
		
		
		
	}
	@RequestMapping(value="/update", method= RequestMethod.POST)
	public String BoardUpdate(Board board,HttpServletRequest request) {
		
		//하나의 서비스로 통합을 해야하는건지(service단에서 여러개의 dao처리)
		//아니면 
		String FilePath = request.getSession().getServletContext().getRealPath("/");
	       
		
		
		
		String image = request.getParameter("image");
		if(!image.isEmpty()) {
			service.boardUpdate(board,FilePath,image);
			
		}
		
		
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/insert", method= RequestMethod.POST)
	public String BoardInsert(HttpServletRequest request,Board board) {
		
		
		//목표 : 업로드한 이미지 경로 가져오기 (여러개일경우)
		service.boardCreate(board);
		String image = request.getParameter("image");
		if(!image.isEmpty()) {
			service.boardCreateImage(board,image);
			
		}
		
		return "redirect:/community";
	}
	
	
	@RequestMapping(value="/cancel")
	public String BoardCancel() {
		
		
		
		
		return "";
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value="/writeRepeat",
			method=RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> writeRepeat(@RequestBody Repeat repeat){//HttpServletRequest request){
		
	
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		repeatService.repeatInsert(repeat);
		
		
		
		
		map.put("success", "success");
		
		return map;
		
	
	}
	
	@RequestMapping(value="/writeReply",
			method=RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> writeReply(@RequestBody Reply reply){//HttpServletRequest request){
		
	
		Map<Object, Object> map = new HashMap<Object, Object>();
		
	
		
		repeatService.ReplyInsert(reply);
		
		
		
		
		map.put("success", "success");
		
		return map;
		
	
	}
	@RequestMapping("/multiplePhotoUpload")
	public void multiplePhotoUpload(HttpServletRequest request,HttpServletResponse response){
	    
		
		FileUtils fileUtils = new FileUtils();
		
		String path = fileUtils.fileUpload(request,response);
		String file_directory = request.getSession().getServletContext().getRealPath("/");
		
		// form 제출시(/insert) 등록된 사진의 경로를 가져오는 방법.
		// 
		// 
		System.out.println("test" + path);
		
		
		
	}



	
	
	
	
	
	
	
	
	@RequestMapping(value="/vote",
			method=RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> vote(@RequestBody Map<Object,Object> obj,
			HttpServletRequest request){//HttpServletRequest request){
		
		HttpSession session = request.getSession();
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		if(session != null) {
			
			service.boardvote(obj);
			
			//System.out.println("vote" + vote);
			
			
		}
	
		
		
		
	
		return map;
		
	
	}
	
	
	@RequestMapping(value="/loginCheck")
	public void loginCheck(){//HttpServletRequest request){
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
