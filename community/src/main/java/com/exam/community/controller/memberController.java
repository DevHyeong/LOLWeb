package com.exam.community.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exam.community.member;
import com.exam.community.service.MemberAuthenticationProvider;
import com.exam.community.service.memberService;

@Controller

public class memberController {
	
	@Autowired
	memberService service;
	
	@RequestMapping("/login")
	public String memberLogin(HttpServletRequest request,HttpSession session
			,Model model) throws UnsupportedEncodingException {
		
		if(session.getAttribute("user") !=null) {
			return "redirect:/";
		}
		
		
		String referrer = request.getHeader("Referer");
		String address = "https://localhost:8443";
		String join = address+"/join";
		String loginError = address+"/login?error";
		if(referrer !=null) {
			if(referrer.equals(join) || referrer.equals(loginError)) {
				System.out.println("들어옴");
				referrer = null;
				
				
			}
		}
		//if(referrer)
		request.getSession().setAttribute("prevPage", referrer);
		
		String clientId = "vTN_NsjFCziZCQWHhy5h";//애플리케이션 클라이언트 아이디값";
	    String redirectURI = URLEncoder.encode("https://localhost:8443/navercallback", "UTF-8");
	    SecureRandom random = new SecureRandom();
	    String state = new BigInteger(130, random).toString();
	    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
	    apiURL += "&client_id=" + clientId;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&state=" + state;
	    session.setAttribute("state", state);
		
		model.addAttribute("apiURL",apiURL);
		
		
		
		return "/member/login";
	}
	
	@RequestMapping("/join")
	public String memberJoin(HttpSession session) {
		if(session.getAttribute("user") !=null) {
			return "redirect:/";
		}
		
		
		return "/member/join";
	}
	
	@RequestMapping(value="/auth", method=RequestMethod.POST)
	public void loginAction(Model model, member member, HttpSession session) {
		//member user = service.memberLogin(member);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Authentication result = new MemberAuthenticationProvider().authenticate(auth);
		
		
		//이밑의 코드는 실행이 안됨. xml설정파일에서 조건값에 따라 실행하기 떄문,
		
		
		
	}
	
	@RequestMapping(value="/joinAction",method=RequestMethod.POST)
	String JoinAction(member member) {
		
		service.memberJoin(member);
		
		return "redirect:/login";
		
	}
	
	
	
	
	@RequestMapping(value="/idcheck", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String userid){//HttpServletRequest request){
		System.out.println("들어오는지 체크");
	//String userid = request.getParameter("userID");
	
		int count =0;
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		count = service.idCheck(userid);
		
		
		
		map.put("cnt", count);
		
		return map;
		
	
	}
	@RequestMapping(value="/NicknameCheck", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> Nicknamecheck(@RequestBody String userid){//HttpServletRequest request){
		System.out.println("들어오는지 체크");
	//String userid = request.getParameter("userID");
	
		int count =0;
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		count = service.NicknameCheck(userid);
		
		
		
		map.put("cnt", count);
		
		return map;
		
		
	}
	
	@RequestMapping(value="/naverlogin",method=RequestMethod.GET)
	public String naverlogin() {
		return "/naver/login";
	}
	
	@RequestMapping(value="/navercallback",method=RequestMethod.GET)
	public String loginPOSTNaver(HttpSession session,
			HttpServletRequest request) throws UnsupportedEncodingException{
		String clientId = "vTN_NsjFCziZCQWHhy5h";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "3y9WzXLvhR";//애플리케이션 클라이언트 시크릿값";
	    String code = request.getParameter("code");
	    String state = request.getParameter("state");
	    String redirectURI = URLEncoder.encode("https://localhost:8443/navercallback", "UTF-8");
	    String apiURL;
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;
	    String access_token = "";
	    String refresh_token = "";
	    
	    try {
	      URL url = new URL(apiURL);
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("GET");
	      int responseCode = con.getResponseCode();
	      BufferedReader br;
	      System.out.print("responseCode="+responseCode);
	      if(responseCode==200) { // 정상 호출
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      } else {  // 에러 발생
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	      }
	      String inputLine;
	      StringBuffer res = new StringBuffer();
	      while ((inputLine = br.readLine()) != null) {
	        res.append(inputLine);
	      }
	      br.close();
	      if(responseCode==200) {
	        System.out.println(res.toString());
	        request.setAttribute("userInfo", res.toString());
	        return "forward:naverloginSuccess";
	      }
	    } catch (Exception e) {
	      System.out.println(e);
	    }
		
		
	    return "/naver/callback";
	}
	@RequestMapping(value="/naverloginSuccess",method=RequestMethod.GET)
	public String naverloginSuccess(HttpServletRequest request,HttpSession session) throws ParseException {
		
		String info = (String)request.getAttribute("userInfo");
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(info);
		
		
		String token = json.get("access_token").toString();// 네이버 로그인 접근 토큰;
		session.setAttribute("token", token);
		
		
        String header = "Bearer " + token; // Bearer 다음에 공백 추가
        try {
            String apiURL = "https://openapi.naver.com/v1/nid/me";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", header);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println("success " + response.toString());
           
    		JSONObject result = (JSONObject) parser.parse(response.toString());
    		JSONObject userInfo = (JSONObject)result.get("response");
    		
    		String id = userInfo.get("id").toString();
    		String nickname = userInfo.get("nickname").toString();
    		String name = userInfo.get("name").toString();
    		//String birthday = userInfo.get("birthday").toString();
    		
    		
    		member user = new member();
    		
    		user.setType("naver");
    		
    		
    		user.setUserid(id);
    		user.setUsername(name);
    		user.setNickname(nickname);
    		
    		user.setPassword("null");
    		user.setMobile("null");
    		//phonenumber
    		//
    		if(service.idCheck(id)<=0) {
    			service.memberJoin(user);
        		
    			
    		}
    		session.setAttribute("user", user);
    		
    		
    		/*System.out.println(nickname);
    		System.out.println(name);
    		*/
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
		
		
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/naverlogout")
	public String naverLogout(HttpSession session) throws UnsupportedEncodingException {
		
		String grant_type="delete";
		String client_id ="vTN_NsjFCziZCQWHhy5h";
		String client_secret = "3y9WzXLvhR";
		String token=(String)session.getAttribute("token");
		String access_token =URLEncoder.encode(token,"UTF-8");
		String service_provider="NAVER";
		
		String apiURL = "https://nid.naver.com/oauth2.0/token";
		apiURL += "?grant_type=" + grant_type;
		apiURL += "&client_id=" + client_id;
		apiURL += "&client_secret=" + client_secret;
		apiURL += "&access_token=" + access_token;
		apiURL += "&service_provider=" + service_provider;
		
		
		try {
			URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
			if(responseCode == 200) {
				System.out.println("logout Success");
				session.invalidate();
			}else {
				System.out.println("fail" + responseCode);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return "redirect:/";
	}
	
	
	
	
	
	
}
