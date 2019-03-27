package com.exam.community.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exam.Riot.*;
import com.exam.Riot.LeaguePosition;
import com.exam.Riot.Match;
import com.exam.Riot.Matchlist;
import com.exam.Riot.Participant;
import com.exam.Riot.Summoner;
import com.exam.Riot.TeamBans;
import com.exam.Riot.TeamStats;
import com.exam.community.RiotGames;
import com.exam.community.service.LolService;
import com.exam.community.service.lolDBService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class LolController {
	
	@Autowired
	LolService service;
	
	@Autowired
	private lolDBService mservice; // 비동기 처리.
	
	private static final Logger logger = LoggerFactory.getLogger(LolController.class);
	
	@RequestMapping(value="/")
	public ModelAndView index() {
		logger.info("index called..");
		
		ModelAndView mav = new ModelAndView();
		
		//JsonReader();
		mav.setViewName("/index");
		return mav;
		
	}
	
	
	
	
	@RequestMapping(value="/find")
	public ModelAndView find(@RequestParam("summoner") String name) throws UnsupportedEncodingException {
		
		name = name.replaceAll(" ", "");
		//name = new String(name.getBytes("8859_1"),"UTF-8");
		System.out.println(name);
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("summoner",name);
		
		//mservice.asdf(name);
		
		
		
		
		service.init(name);
		
		
		/*RiotGames riot = new RiotGames(name);
		
		
		
		Summoner summoner = riot.summoner();*/
		String url = service.getProfileImg();
	
		LeaguePosition ps = service.getTierInfo("RANKED_SOLO_5x5");
		String emblem = "_Emblem.png";
		
		
		
		if(ps!=null) {
			mav.addObject("tier_info",ps);
			mav.addObject("tier_img",service.getTierImgName(ps.getTier())+emblem);
		}else {
			mav.addObject("tier_info","unranked");
			mav.addObject("tier_img","unranked.png");
			
		}
		mav.addObject("Icon",url);
		mav.addObject("summoner",service.getSummoner());
		mav.addObject("match",service.getMethod());
		
		
			
		mav.setViewName("/find");
		
		return mav;
		
	}
	
	
	//클라이언트로부터 data(matchId)받기, 서버측에서 뿌려주는 데이터.
	
	
	
	
	@RequestMapping(value="/gameDetails",produces="application/json; charset=utf-8", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> gameDetails(@RequestBody long gameId) {
		
		
		Map<String,Object> map = new HashMap();
		
		System.out.println("GameId " + gameId);
		map.put("gameDetails", service.GameDetails(gameId));
		
		return map;
	}
	
	@RequestMapping(value="/Rank")
	public ModelAndView rank() {
		
		
		ModelAndView mav = new ModelAndView();
		
		//index = 0 (1~100)
		//index = 1 (101~200)
		//index = 2 (201~300)
		service.ranking(0);
		
		//System.out.println("ranking");
		
		mav.setViewName("/rank");
		return mav;
		
		
		
		
	}
	
	@RequestMapping(value="/gameInfo",produces="application/json; charset=utf-8",
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> CurrentgameInfo(@RequestBody String summonerId) {
		
		
		Map<String,Object> map = new HashMap();
		
		System.out.println(summonerId);
		
		
		
		CurrentGame game = service.currentgameInfo(summonerId);
		
		
		
		map.put("CurrentPlayers", game.getPlayers());
		map.put("bannedchampions", game.getChamps());
		map.put("time",game.getTime());
		
		
		
		return map;
	}
	
	
	
	
	
	
	
}
