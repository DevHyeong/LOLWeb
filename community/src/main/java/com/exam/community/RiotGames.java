package com.exam.community;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpHeaders;

import com.exam.Riot.ChampMastery;
import com.exam.Riot.CurrentGameInfo;
import com.exam.Riot.LeaguePosition;
import com.exam.Riot.Match;
import com.exam.Riot.Matchlist;
import com.exam.Riot.Summoner;
import com.exam.Riot.rank.LeagueList;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class RiotGames {
	
	private String summonersName;
	private String APIKey = "RGAPI-908fe0e2-9cdb-4b1d-aa13-5fc068121bba";
	
	
	public RiotGames() {
		
		
	}
	
	public RiotGames(String summonersName) throws UnsupportedEncodingException {
		
		this.summonersName = URLEncoder.encode(summonersName,"UTF-8");
		//System.out.println(summonersName);
	}
	
	
	public String connection(String API_url) {
		
		String json;
		HttpHeaders headers = new HttpHeaders();
		
		
		try {
			URL url = new URL(API_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			//conn.getResponseCode();
			
			//429 Check하는 코드.
			//429 Error처리코드.
			// 
			int ResponseCode = conn.getResponseCode();
			
			if(ResponseCode == 429) {
				
				String retryAfter = conn.getHeaderField("Retry-After");
				int seconds = Integer.parseInt(retryAfter);
				
				System.out.println("들어오는가" + conn.getResponseCode());
				System.out.println("RetryAfter " +seconds );
				//대기후 다시 실행
				Thread.sleep(seconds*1000);
				connection(API_url);
				
			}else if(ResponseCode == 404){
				
				return null;
				
			}else if(ResponseCode == 400){
				
				
				return "400";
				
			}else {
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
				json = in.readLine();
				return json;
				
				
				
			}
			
			
			/*Map<String,List<String>> map = conn.getHeaderFields();
			Iterator<String> iterator = map.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				if(key.equals("Retry-After")) {
					System.out.println("true:" + map.get(key));
				}
			}
			*/
			
			
			
			
			
			
			
			// 디코더 해줘야 알맞은 소호나사 이름이 뜸
			//System.out.println(json);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
		
		
	}
	
	
	
	public Summoner summoner() {
		
		
		String API_URL="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"
				+summonersName+"?api_key="+APIKey;
		try {
			String json = connection(API_URL);
			
			Summoner summoner = new ObjectMapper().readValue(json, Summoner.class);
			
			/*System.out.println(summoner.getProfileIconId());
			System.out.println(summoner.getName());
			System.out.println(summoner.getId());*/
			
			/*ObjectMapper mapper = new ObjectMapper();
			Map<String,Object> map = new HashMap<String, Object>();
			map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});*/
			
			
			
			return summoner;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<LeaguePosition> League(String summonerId) {
		
		String API_URL = "https://kr.api.riotgames.com/lol/league/v4/positions/by-summoner/"
				+summonerId+"?api_key="+APIKey;
		
		String json = connection(API_URL);
		List<LeaguePosition> position;
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			TypeFactory typeFactory = objectMapper.getTypeFactory();
			CollectionType collectionType = typeFactory.constructCollectionType(
					List.class, LeaguePosition.class);
			
			position = objectMapper.readValue(json, collectionType);
			
			
			return position;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
		
	}
	public Matchlist matchlist(String AccountId) {
		String API_URL = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/"
				+AccountId+"?api_key="+APIKey;
		
		Matchlist matchlist;
		try {
			String json = connection(API_URL);
			matchlist = new ObjectMapper().readValue(json, Matchlist.class);
			
			//System.out.println(matchlist);
			
			return matchlist;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public Match match(long GameId) {
		String API_URL="https://kr.api.riotgames.com/lol/match/v4/matches/"
				+GameId+"?api_key="+APIKey;
		
		Match match;
		try {
			String json = connection(API_URL);
			match = new ObjectMapper().readValue(json, Match.class);
			
			//System.out.println(matchlist);
			
			return match;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	public LeagueList GrandMaster() {
		
		String API_URL ="https://kr.api.riotgames.com/lol/league/v4/"
				+ "grandmasterleagues/by-queue/RANKED_SOLO_5x5"+"?api_key="+APIKey;
		
		LeagueList leagueList;
		try {
			String json = connection(API_URL);
			leagueList = new ObjectMapper().readValue(json, LeagueList.class);
			
			
			
			
			
			return leagueList;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("check : ");
		
		return null;
		
	}
	
	public Matchlist GameList(int champId,String AccountId) {
		String API_URL = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/"
				+ AccountId+"?champion="+champId+"&queue=420&season=13&api_key="+APIKey;
		
		try {
			String json = connection(API_URL);
			if(json == null) {
				
				
				return null;
			}
			
			Matchlist match = new ObjectMapper().readValue(json, Matchlist.class);
			
			
			
			
			return match;
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Matchlist GameList(String AccountId) {
		String API_URL = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/"
				+ AccountId+"?queue=420&season=13&api_key="+APIKey;
		
		try {
			String json = connection(API_URL);
			if(json == null) {
				
				
				return null;
			}
			
			Matchlist match = new ObjectMapper().readValue(json, Matchlist.class);
			
			
			
			
			return match;
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public List<ChampMastery> Champ_Mastery(String summonerId){
		String API_URL = "https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/"
				+ summonerId+"?api_key="+APIKey;
		
		
		try {
			String json = connection(API_URL);
			ObjectMapper objectMapper = new ObjectMapper();
			TypeFactory typeFactory = objectMapper.getTypeFactory();
			CollectionType collectionType = typeFactory.constructCollectionType(
					List.class, ChampMastery.class);
			
			
			List<ChampMastery> champ = objectMapper.readValue(json, collectionType);
			
			return champ;
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public LeagueList Master() {
		
		String API_URL ="https://kr.api.riotgames.com/lol/league/v4/"
				+ "masterleagues/by-queue/RANKED_SOLO_5x5"+"?api_key="+APIKey;
		
		LeagueList leagueList;
		try {
			String json = connection(API_URL);
			leagueList = new ObjectMapper().readValue(json, LeagueList.class);
			
			return leagueList;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<LeaguePosition> Ranking(String tier) {
		//tier, division, position, page
		//"DIAMOND/I/UTILITY/4"
		String division[] = {"I","II","III","IV"};
		String position[] = {"TOP","MIDDLE","BOTTOM","JUNGLE","UTILITY"};
		
		List<LeaguePosition> league = new ArrayList<>();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		int count =0;
		
		for(int i=0; i<division.length; i++) {
			for(int j=0; j<position.length; j++) {
				int p = 0;
				while(true) {
					String page = String.valueOf(p);
					String API_URL ="https://kr.api.riotgames.com/lol/league/v4/positions/RANKED_SOLO_5x5/"
							+ tier + "/"; //+ "/"+division+"/"+position+"/"+page+"?api_key="+APIKey;
					
					API_URL = API_URL + division[i] + "/" + position[j] + "/" + page + "?api_key="+APIKey;
					//List<LeaguePosition> leagueposition;
					
					try {
						String json = connection(API_URL);
						TypeFactory typeFactory = objectMapper.getTypeFactory();
						CollectionType collectionType = typeFactory.constructCollectionType(
								List.class, LeaguePosition.class);
						
						List<LeaguePosition> leagueposition = objectMapper.readValue(json, collectionType);
						
						if(leagueposition.isEmpty()) {
							break;
						}
						
						count++;
						
						league.addAll(leagueposition);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					p++;
				}
				
			}
			
		}
		
		
		
		
		return league;
		
	}
	
	
	
	
	
	public List<LeaguePosition> Ranking(String tier,String division,String position,String page) {
		//tier, division, position, page
		String API_URL ="https://kr.api.riotgames.com/lol/league/v4/positions/RANKED_SOLO_5x5/"
				+ tier + "/"+division+"/"+position+"/"+page+"?api_key="+APIKey;
		//"DIAMOND/I/UTILITY/4"
		
		List<LeaguePosition> leagueposition;
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			String json = connection(API_URL);
			TypeFactory typeFactory = objectMapper.getTypeFactory();
			CollectionType collectionType = typeFactory.constructCollectionType(
					List.class, LeaguePosition.class);
			
			leagueposition = objectMapper.readValue(json, collectionType);
			
			
			return leagueposition;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
		
	}
	
	
	public CurrentGameInfo currentgameInfo(String SummonerId) {
		String API_URL = "https://kr.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/"
				+SummonerId+"?api_key="+APIKey;
				
		CurrentGameInfo gameInfo;
		try {
			String json = connection(API_URL);
			
			if(json == "400") {
				
				
				
				return null;
			}
			
			gameInfo = new ObjectMapper().readValue(json, CurrentGameInfo.class);
			
			return gameInfo;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;		
		
		
		
		
	}

	
	
}
