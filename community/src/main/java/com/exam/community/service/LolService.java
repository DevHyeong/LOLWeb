package com.exam.community.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.Riot.*;
import com.exam.Riot.LeaguePosition;
import com.exam.Riot.Match;
import com.exam.Riot.Matchlist;
import com.exam.Riot.Summoner;
import com.exam.Riot.champ.Champ;
import com.exam.Riot.champ.ChampInfo;
import com.exam.Riot.item.Item;
import com.exam.Riot.rank.LeagueItem;
import com.exam.Riot.rank.LeagueList;
import com.exam.Riot.rank.Rank;
import com.exam.Riot.rune.RuneReforged;
import com.exam.Riot.rune.RuneValues;
import com.exam.Riot.rune.Runes;
import com.exam.Riot.spell.Spell;
import com.exam.community.RiotGames;
import com.exam.community.dao.lolDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

@Service
public class LolService implements ILolService{
	
	
	private RiotGames riot;
	private Summoner summoner;
	private List<LeaguePosition> position;
	private Matchlist matchlist;
	private Match match;
	
	private List<Champ> champData =  championInfo();
	private List<RuneReforged> runeData = runesReforged();
	private List<Spell> spellData = spellInfo();
	private List<Item> ItemData = ItemInfo();
	
	
	@Autowired
	lolDBService mservice;
	
	
	@Autowired
	lolDao dao;
	
	
	
	@Override
	public void init(String name) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		riot = new RiotGames(name);
		summoner = riot.summoner();
		System.out.println("gameId" + summoner.getId());
		
		position = riot.League(summoner.getId());
		matchlist = riot.matchlist(summoner.getAccountId());
		runesReforged();
		
	}
	
	@Override
	public String getTierImgName(String tier) {
		// TODO Auto-generated method stub
		
		//String tier = position.getTier();
		String str = tier.substring(1, tier.length());
		str = str.toLowerCase();
		
		return tier.substring(0,1)+str;
		
		
		
	}




	@Override
	public LeaguePosition getTierInfo(String rank) {
		// TODO Auto-generated method stub
		//System.out.println(position.get(0).getLeagueName());
		//RANKED_SOLO_5x5 RANKED_FLEX_SR
		for(int i=0; i<position.size(); i++) {
			if(position.get(i).getQueueType().equals(rank)) {
				
				double average = ((double)position.get(i).getWins()*100)/(double)(position.get(i).getWins()+position.get(i).getLosses());
				//System.out.println(average);
				position.get(i).setAverage(Math.round(average*100)/100.0);
				//position.get(i).setTier_img(getTierImgName(position.get(i)));
				
				return position.get(i);
				
			}
			
		}
		
		return null;
	}




	@Override
	public String getProfileImg() {
		// TODO Auto-generated method stub
		
		String url = "http://ddragon.leagueoflegends.com/cdn/9.1.1/img/profileicon/"+
				summoner.getProfileIconId()+".png";
		
		return url;
	}

	@Override
	public Summoner getSummoner() {
		// TODO Auto-generated method stub
		return summoner;
	}

	@Override
	public List<Game> getMethod() {
		// TODO Auto-generated method stub
		
		List<Game> gamelist = new ArrayList<>();
		
		
		
		for(int i =0; i<20; i++) { // 최근 20게임
			Game game = new Game();
			
			
			Players[] players = new Players[10];
			/*List<String> summonerName = new ArrayList<>();
			List<Champ> championId = new ArrayList<>();
			List<String> line = new ArrayList<>();
			List<Integer> teamId = new ArrayList<>();*/
			
			MatchReference fs = matchlist.getMatches().get(i);
			
			Match match = riot.match(fs.getGameId());
			
			
			
			game.setGameCreation(TimeStamp(fs.getTimestamp()));
			
			
			
			
			game.setGameTime(convertTime(match.getGameDuration()));
			
			game.setGameId(match.getGameId());
			
			game.setGameMode(isCheckedQueue(match.getQueueId()));
			
			
			match.getTeams().get(0).getWin(); // value = Fail,Win
			match.getTeams().get(0).getTeamId(); // value = 100,200 검색아이디 팀이 어디소속인지 알아야함.
			
			
			int BlueKill =0; // value = 100
			int RedKill = 0; // value = 200
			for(int j=0; j<match.getParticipantIdentities().size(); j++) {
				ParticipantIdentity pi = match.getParticipantIdentities().get(j);
				Participant participant = match.getParticipants().get(j);
				
				
				if(participant.getTeamId() == 100) {
					BlueKill = BlueKill + participant.getStats().getKills();
					
				}else {
					RedKill = RedKill + participant.getStats().getKills();
					
				}
				
				
				if(summoner.getName().equals(pi.getPlayer().getSummonerName())){
					
					
					Champ champ = SearchChamp(champData,participant.getChampionId());
					
					
					
					game.setKills(participant.getStats().getKills());
					game.setDeaths(participant.getStats().getDeaths());
					game.setAssists(participant.getStats().getAssists());
					
					int sum = game.getKills()+game.getAssists();
					double ratio = (double)sum/game.getDeaths();
					game.setRatio(String.format("%.2f", ratio));
							
					game.setChampLevel(participant.getStats().getChampLevel());
					game.setTeamId(participant.getTeamId());
					
					game.setSpell1(SearchSpell(spellData,participant.getSpell1Id()));
					game.setSpell2(SearchSpell(spellData,participant.getSpell2Id()));
					
					
					
					game.setChamp(champ);
					
					
					game.setPrimaryRune(SearchRune(runeData,participant.getStats().getPerk0())); //int값
					game.setSubRune(SearchRune(runeData,participant.getStats().getPerkSubStyle()));
					
					Item[] items = new Item[7];
					items[0] = SearchItem(ItemData,participant.getStats().getItem0());
					items[1] = SearchItem(ItemData,participant.getStats().getItem1());
					items[2] = SearchItem(ItemData,participant.getStats().getItem2());
					items[3] = SearchItem(ItemData,participant.getStats().getItem6());
					items[4] = SearchItem(ItemData,participant.getStats().getItem3());
					items[5] = SearchItem(ItemData,participant.getStats().getItem4());
					items[6] = SearchItem(ItemData,participant.getStats().getItem5());
					
					
					
					
					game.setItems(items);
					
					
					int id = match.getTeams().get(0).getTeamId(); // value = 100,200 검색아이디 팀이 어디소속인지 알아야함.
					
					if(id == participant.getTeamId()) {
						
						game.setResult(isCheckedResult(match.getTeams().get(0).getWin()));
					}else {
						game.setResult(isCheckedResult(match.getTeams().get(1).getWin()));
						
						
					}
					
					game.setCs(participant.getStats().getTotalMinionsKilled()+participant.getStats().getNeutralMinionsKilled());
					game.setCsRatio(csRatio(match.getGameDuration(),game.getCs()));
					
					
					
				}
				
				pi.getParticipantId();
				Champ champ = SearchChamp(champData,participant.getChampionId());
				Players player = new Players();
				
				
	
				player.setId(champ.getId());
				player.setKey(champ.getKey());
				player.setName(champ.getName());
				player.setSummonername(pi.getPlayer().getSummonerName());
				player.setLine(participant.getTimeline().getLane());
				player.setTeamId(participant.getTeamId());
				
				if(participant.getTimeline().getLane().equals("BOTTOM")) {
					player.setLine(participant.getTimeline().getRole());
					
				}
				
				
				
				
				
				
				players[j] = player;
				
				
			}
			if(game.getTeamId() == 100) {
				double sum = (game.getKills()+game.getAssists())/(double)BlueKill;
				//System.out.println("Allkill"+sum);
				game.setKillRate((int)(sum*100));
			}else {
				double sum = (game.getKills()+game.getAssists())/(double)RedKill;
				game.setKillRate((int)(sum*100));
			}
			
			//라인별로 player들 정렬
			
			//Players[] sortplayer = sortPlayer(players);
		
			game.setPlayer(players);
			//System.out.print("count "+i);
			//System.out.println(game.getGameId());
			gamelist.add(game);
			
			
			game.getSpell1(); // 스펠명으로 뿌려주기.
			game.getPrimaryRune();
			game.getSubRune();
		}
	
		return gamelist;
		
		
		
	}
	
	
	
	
	public Players[] sortPlayer(Players[] players){
		
		//List<Players> sortplayer = new ArrayList<>();
		Players[] sortplayer = new Players[10];
		
		//System.out.println("check");
		for(int i=0; i<players.length; i++) {
			Players player = players[i];
			//System.out.print(player.getLine());
			//System.out.println(" "+player.getTeamId());
			// TOP,BOTTOM(ROLE:DUO_CARRY,DUO_SUPPORT),JUNGLE,MIDDLE,
			if(player.getLine().equals("TOP") && player.getTeamId() == 100) {
				
				sortplayer[0] = player;
				
			}else if(player.getLine().equals("JUNGLE") && player.getTeamId() == 100) {
				
				sortplayer[1] = player;
				
			}else if(player.getLine().equals("MIDDLE")&& player.getTeamId() == 100) {
			
				sortplayer[2] = player;
				
			}else if(player.getLine().equals("DUO_CARRY") && player.getTeamId() == 100) {
				
				sortplayer[3] = player;
				
			}else if(player.getLine().equals("DUO_SUPPORT") && player.getTeamId() == 100){
				
				sortplayer[4] = player;
				
				
			}else if(player.getLine().equals("TOP") && player.getTeamId() == 200) {
				
				sortplayer[5] = player;
				
			}else if(player.getLine().equals("JUNGLE") && player.getTeamId() == 200) {
				
				sortplayer[6] = player;
				
			}else if(player.getLine().equals("MIDDLE") && player.getTeamId() == 200) {
				
				sortplayer[7] = player;
				
			}else if(player.getLine().equals("DUO_CARRY") && player.getTeamId() == 200) {
				
				sortplayer[8] = player;
				
			}else {
				
				sortplayer[9] = player;
				
			}
			
			
			
			
			
			
		}
		
		
		/*for(int i=0; i<sortplayer.length; i++) {
			
			System.out.println(sortplayer[i].getSummonername());
			
		}
		*/
		
		
		
		
		return sortplayer;
		
		
	}
	
	
	//Ranking
	
	public List<Rank> ranking(int index){
		
		List<Rank> ranking = new ArrayList<>();
		
		String tier[] = {"DIAMOND","PLATINUM","GOLD","SILVER","BRONZE","IRON"};
		String division[] = {"I","II","III","IV"};
		String position[] = {"TOP","MIDDLE","BOTTOM","JUNGLE","UTILITY"};
		
		//LeagueList grandMaster = riot.GrandMaster();
		//LeagueList master = riot.Master();
		
		//랭킹을 db에 저장해야할지, 말아야할지
		
		//List<LeagueItem> grandMasterEntries = grandMaster.getEntries();
		//List<LeagueItem> masterEntries = master.getEntries();
		List<LeaguePosition> diamondEntries = riot.Ranking(tier[0],division[0],position[0],"0");
		//List<LeaguePosition> platinumEntries = riot.Ranking(tier[1]);
		//List<LeaguePosition> goldEntries = riot.Ranking(tier[2]);
		//List<LeaguePosition> silverEntries = riot.Ranking(tier[3]);
		//List<LeaguePosition> bronzeEntries = riot.Ranking(tier[4]);
		//List<LeaguePosition> ironEntries = riot.Ranking(tier[5]);
		
		
		
	
		/*for(int i=0; i<tier.length; i++) {
			for(int j=0; j<division.length; j++) {
				//List<LeaguePosition> Entries;
				for(int k=0; k<position.length; k++) {
					int p = 0;
					while(true) {
						String page = String.valueOf(p);
						List<LeaguePosition> leaguePosition = riot.Ranking(
								tier[i],division[j],position[k],page);
						if(leaguePosition ==null) {
							break;
						}else {
							if(i == 0) {
								diamondEntries.addAll(leaguePosition);
								
							}else if(i==1) {
								platinumEntries.addAll(leaguePosition);
								
							}else if(i==2) {
								goldEntries.addAll(leaguePosition);
			
							}else if(i==3) {
								silverEntries.addAll(leaguePosition);
								
							}else if(i==4) {
								bronzeEntries.addAll(leaguePosition);
								
							}else {
								ironEntries.addAll(leaguePosition);
								
							}
							
						}
						p++;
					}
					
					
				}
			}
		}
		*/
		
		
		/*for(int i=0; i<entries.size(); i++) {
			LeagueItem entry = entries.get(i);
			entry.getWins();
			entry.getLosses();
			entry.getSummonerName();
			entry.getLeaguePoints();
			
		}*/
		//System.out.println("master size" + masterEntries.size());
		System.out.println("diamond size" + diamondEntries.size());
		//System.out.println("platinum size" + platinumEntries.size());
		//System.out.println("gold size" + goldEntries.size());
		//System.out.println("silver size" + silverEntries.size());
		//System.out.println("bronze size" + bronzeEntries.size());
		//System.out.println("iron size" + ironEntries.size());
		
		
		
		
		return ranking;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//챔피언 정보 불러오기
	public List<Champ> championInfo() {
		String fileName = "C:\\Users\\aaa\\Downloads\\dragontail-9.2.1\\9.2.1\\data\\ko_KR\\champion.json";
		JSONParser parser = new JSONParser();
		List<Champ> champ = new ArrayList<>();
		
		try {
			Object obj = parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8")));
			JSONObject json = (JSONObject) obj;
			
			Map<String,Object>map = new HashMap<String,Object>();
			JSONObject jsonObj = (JSONObject)json.get("data");
			
			Iterator<String> keysItr = jsonObj.keySet().iterator();
			while (keysItr.hasNext()) { 
				String key = keysItr.next(); 
				JSONObject jsonkey = (JSONObject)jsonObj.get(key);
				Iterator<String> keys = jsonkey.keySet().iterator();
				Champ info = new Champ();
				
				while(keys.hasNext()) {
					String key1 = keys.next();
					Object value = jsonkey.get(key1);
					
					if(key1.equals("name")) {
						//System.out.print(value+" ");
						info.setName((String)value);
						
					}
					if(key1.equals("id")) {
						//System.out.print(value+" ");
						info.setId((String)value);
					}
					if(key1.equals("key")) {
						//System.out.println(value);
						info.setKey((String)value);
					}
					//+images file Name
					
				}
				champ.add(info);
				
					
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		return champ;
	}
	
	//챔피언정보찾기
	public Champ SearchChamp(List<Champ> data, int value) {
		String store = "/resources/img/champion/";
		Champ champ = new Champ();
		String a = String.valueOf(value);
		
		for(int i=0; i<data.size(); i++) {
			if(data.get(i).getKey().equals(a)) {
				champ.setId(store+data.get(i).getId()+".png");
				champ.setKey(data.get(i).getKey());
				champ.setName(data.get(i).getName());
				
				return champ;
				
			}
		}
		return champ;
	}
	
	
	
	public List<Spell> spellInfo(){
		
		String fileName = "C:\\Users\\aaa\\Downloads\\dragontail-9.2.1\\9.2.1\\data\\ko_KR\\summoner.json";
		JSONParser parser = new JSONParser();
		List<Spell> spell = new ArrayList<>();
		
		try {
			Object obj = parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8")));
			JSONObject json = (JSONObject) obj;
			
			Map<String,Object>map = new HashMap<String,Object>();
			JSONObject jsonObj = (JSONObject)json.get("data");
			
			Iterator<String> keysItr = jsonObj.keySet().iterator();
			while (keysItr.hasNext()) { 
				String key = keysItr.next(); 
				JSONObject jsonkey = (JSONObject)jsonObj.get(key);
				Iterator<String> keys = jsonkey.keySet().iterator();
				Spell info = new Spell();
				
				while(keys.hasNext()) {
					String key1 = keys.next();
					Object value = jsonkey.get(key1);
					
					if(key1.equals("name")) {
						//System.out.print(value+" ");
						info.setName((String)value);
						
					}
					if(key1.equals("id")) {
						//System.out.print(value+" ");
						info.setId((String)value);
					}
					if(key1.equals("key")) {
						//System.out.println(value);
						info.setKey((String)value);
					}
					
					if(key1.equals("description")) {
						info.setDescription((String)value);
						
					}
					
					//+images file Name
					
				}
				spell.add(info);
				
					
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return spell;
		
		
		
	}

	
	
	
	
	public Spell SearchSpell(List<Spell> data, int value) {
		
		String store = "/resources/img/spell/";
		Spell spell = new Spell();
		String a = String.valueOf(value);
		
		for(int i=0; i<data.size(); i++) {
			if(data.get(i).getKey().equals(a)) {
				spell.setId(store+data.get(i).getId()+".png");
				spell.setKey(data.get(i).getKey());
				spell.setName(data.get(i).getName());
				spell.setDescription(data.get(i).getDescription());
				return spell;
				
			}
		}
		return spell;
		
		
		
		
		
	}
	
	
	//아이템 정보 불러오기
	
	public List<Item> ItemInfo() {
		String fileName = "C:\\Users\\aaa\\Downloads\\dragontail-9.2.1\\9.2.1\\data\\ko_KR\\item.json";
		
		//name,description,plaintext,
		
		JSONParser parser = new JSONParser();
		List<Item> item = new ArrayList<>();
		
		try {
			Object obj = parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8")));
			JSONObject json = (JSONObject) obj;
			
			JSONObject jsonObj = (JSONObject)json.get("data");
			
			Iterator<String> keysItr = jsonObj.keySet().iterator();
			while (keysItr.hasNext()) { 
				String itemNumber = keysItr.next(); 
				
				
				JSONObject jsonkey = (JSONObject)jsonObj.get(itemNumber);
				Iterator<String> keys = jsonkey.keySet().iterator();
				Item info = new Item();
				
				//System.out.println(itemNumber);
				
				info.setId(itemNumber);
				while(keys.hasNext()) {
					String key1 = keys.next();
					Object value = jsonkey.get(key1);
					
					if(key1.equals("name")) {
						//System.out.print(value+" ");
						info.setName((String)value);
						
					}
					if(key1.equals("description")) {
						//System.out.print(value+" ");
						info.setDescription((String)value);
					}
					if(key1.equals("plaintext")) {
						//System.out.println(value);
						info.setPlaintext((String)value);
					}
					//+images file Name
					
				}
				item.add(info);
				
					
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		return item;
		
	}
	
	
	
	public Item SearchItem(List<Item> data, int value) {
		String store = "/resources/img/item/";
		String id = null;
		if(value == 0) {
			id = "3637";
		}else {
			
			id = String.valueOf(value);
		}
		
		
		Item item = new Item();
		
		
		for(int i=0; i<data.size(); i++) {
			if(data.get(i).getId().equals(id)) {
				item.setId(store+data.get(i).getId()+".png");
				item.setDescription(data.get(i).getDescription());
				item.setName(data.get(i).getName());
				item.setPlaintext(data.get(i).getPlaintext());
				
				return item;
			}
			
			
		}
		return item;
		
		
	}
	
	
	
	
	
	
	//룬 찾기
	public RuneValues SearchRune(List<RuneReforged> data,int value) {
		RuneValues data1 = new RuneValues();
		String store = "/resources/img/";
		
		for(int i=0; i<data.size(); i++) {
			
			if(value==data.get(i).getId()) {
				data1.setIcon(store+data.get(i).getIcon());
				data1.setName(data.get(i).getName());
				
				
				return data1;
			}
		
			
			
			
			//System.out.println(data.get(i).getName());
			List<Runes> slots = data.get(i).getSlots();
			for(int j=0; j<slots.size(); j++) {
				List<RuneValues> values = slots.get(j).getRunes();
				for(int k=0; k<values.size(); k++) {
					if(value == values.get(k).getId()) {
						data1.setIcon(store+values.get(k).getIcon());
						data1.setLongDesc(values.get(k).getLongDesc());
						data1.setName(values.get(k).getName());
						data1.setShortDesc(values.get(k).getShortDesc());
						data1.setId(values.get(k).getId());
						data1.setKey(values.get(k).getKey());
						
						return data1;
					}
					
				}
			}
		}
		return data1;
		
		
	}
	
	
	
	
	
	//runesInfo 불러오기
	public List<RuneReforged> runesReforged() {
		String fileName = "C:\\Users\\aaa\\Downloads\\dragontail-9.2.1\\9.2.1\\data\\ko_KR\\runesReforged.json";
		ObjectMapper objectMapper = new ObjectMapper();
		List<RuneReforged> data = null;
		
		try {
			//Object obj = parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8")));
			TypeFactory typeFactory = objectMapper.getTypeFactory();
			CollectionType collectionType = typeFactory.constructCollectionType(
					List.class, RuneReforged.class);
			
			
			data = objectMapper.readValue(new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8")),
					collectionType);
			
			
			//해쉬값으로 리스트 value를 쉽게 찾을수있는 방법.
			
			for(int i=0; i<data.size(); i++) {
				
				
				List<Runes> slots = data.get(i).getSlots();
				for(int j=0; j<slots.size(); j++) {
					List<RuneValues> values = slots.get(j).getRunes();
					for(int k=0; k<values.size(); k++) {
						
					}
				}
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return data;
	}



	public String isCheckedQueue(int QueueId) {
		
		if(QueueId == 420) {
			return "솔랭";
		}else if(QueueId == 430) {
			
			return "일반";
		}else {
			return "무엇";
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	public String isCheckedResult(String result) {
		
		if(result.equals("Win")) {
			return "승리";
		}else {
			return "패배";
		}
		
		
		
		
	}
	
	
	
	public String convertTime(long time) {
		
		int minute = (int)time/60;
		int seconds = (int)time%60;
		//int second = (int)seconds*60;
		
		String stringTime = minute+"분 "+seconds+"초";
		
		
		
		
		return stringTime;
		
		
	}
	
	
	public String TimeStamp(long time) {
		
		Date mDate = new Date(time);
		SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String current = mFormat.format(mDate);
		String timestamp = null;
		
		
		
		try {
			timestamp = Time.calculateTime(mFormat.parse(current));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return timestamp;
		
		
		
	}
	public String csRatio(long time,int cs) {
		
		int minute = (int)time/60;
		int seconds = (int)time%60;
		
		int sum = (minute*10)+(seconds/10);
		double ratio = (cs/(double)sum)*10;
		
		return String.format("%.1f", ratio);
		
		
	}
	
	
	
	public GamePlayer[] GameDetails(long gameId) {
		
		Match match = riot.match(gameId);
		GamePlayer[] gamePlayer = new GamePlayer[10];
		long damageTakenMax = 0L;
		long damageDealtMax = 0L;
		
		
		
		String BlueResult = match.getTeams().get(0).getWin(); // teamId = 100 value = Win,Fail
		String RedResult = match.getTeams().get(1).getWin();
		
		int blueKill = 0; // 100
		int redKill = 0; // 200
		
		
		
		
		for(int i=0; i<10; i++) {
			
			ParticipantIdentity identity = match.getParticipantIdentities().get(i);
			Participant participant = match.getParticipants().get(i);
			GamePlayer player = new GamePlayer();
			
			String summonerName = identity.getPlayer().getSummonerName();
			Champ champ = SearchChamp(champData,participant.getChampionId());
			int champLevel = participant.getStats().getChampLevel();
			
			int teamId = participant.getTeamId();
			String teamResult = null;
			if(teamId == 100) {
				teamResult = BlueResult;
			}else {
				teamResult = RedResult;
			}
			
			Spell spell1 = SearchSpell(spellData,participant.getSpell2Id());
			Spell spell2 = SearchSpell(spellData,participant.getSpell1Id());
			
			RuneValues primaryRune = SearchRune(runeData,participant.getStats().getPerk0());
			RuneValues subRune = SearchRune(runeData,participant.getStats().getPerkSubStyle());
			
			int kill = participant.getStats().getKills();
			int assist = participant.getStats().getAssists();
			int death = participant.getStats().getDeaths();
			String ratio = String.format("%.2f", ((double)(kill+assist))/death);
			
					
			
			int cs = participant.getStats().getTotalMinionsKilled()
					+participant.getStats().getNeutralMinionsKilled();
			String csRatio = csRatio(match.getGameDuration(),cs);
			
			Item[] items = new Item[7];
			items[0] = SearchItem(ItemData,participant.getStats().getItem0());
			items[1] = SearchItem(ItemData,participant.getStats().getItem1());
			items[2] = SearchItem(ItemData,participant.getStats().getItem2());
			items[6] = SearchItem(ItemData,participant.getStats().getItem6());
			items[3] = SearchItem(ItemData,participant.getStats().getItem3());
			items[4] = SearchItem(ItemData,participant.getStats().getItem4());
			items[5] = SearchItem(ItemData,participant.getStats().getItem5());
			
			long damageTaken = participant.getStats().getTotalDamageTaken();
			long damageDealt = participant.getStats().getTotalDamageDealtToChampions();
			
			if(damageTakenMax < damageTaken) {
				damageTakenMax = damageTaken;
				
			}
			
			if(damageDealtMax < damageDealt) {
				damageDealtMax = damageDealt;
			}
			
			
			int wardsPlaced = participant.getStats().getWardsPlaced();
			int wardsKilled = participant.getStats().getWardsKilled();
			int visionWardsBoughtInGame = participant.getStats().getVisionWardsBoughtInGame();
			
			
			
			
			
			
			
			
			
			List<LeaguePosition> p = riot.League(identity.getPlayer().getSummonerId());
			
			//라인에 따라 티어다름
			for(int j =0; j<p.size(); j++) {
				
				
				
				
			}
			
			if( teamId == 100) {
				blueKill = blueKill + kill;
			}else {
				redKill = redKill + kill;
			}
			
			
			
			
			
			player.setSummonerTier("gold");
			player.setSummonerName(summonerName); //소환사이름
			player.setChamp(champ);
			player.setChampLevel(champLevel);
			player.setTeamId(teamId);
			player.setTeamResult(teamResult);
			
			player.setSpell1(spell1);
			player.setSpell2(spell2);
			
			player.setPrimaryRune(primaryRune);
			player.setSubRune(subRune);
			
			player.setKills(kill);
			player.setAssists(assist);
			player.setDeaths(death);
			player.setRatio(ratio);
			
			player.setDamageDealt(damageDealt);
			player.setDamageTaken(damageTaken);
			
			player.setItems(items);
			
			
			player.setCs(cs);
			player.setCsRatio(csRatio);
			
			player.setWardsKilled(wardsKilled);
			player.setWardsPlaced(wardsPlaced);
			player.setVisionWardsBoughtInGame(visionWardsBoughtInGame);
			
			
			//System.out.println("damageDealt "+player.getDamageDealt());
			//System.out.println("damageTaken "+player.getDamageTaken());
			
			
			gamePlayer[i] = player;
		}
		
		for(int i =0; i<gamePlayer.length; i++) {
			GamePlayer player = gamePlayer[i];
			double sum = (double)(player.getKills()+player.getAssists());
			
			if(player.getTeamId() == 100) {
				player.setKillRate((int)((sum/blueKill)*100));
				
			}else {
				player.setKillRate((int)((sum/redKill)*100));
				
			}
			
			
			double a = (player.getDamageDealt()/(double)damageDealtMax)*100;
			double b = (player.getDamageTaken()/(double)damageTakenMax)*100;
			
			player.setDamageDealtPer((int)Math.round(a));
			player.setDamageTakenPer((int)Math.round(b));
		}
		
		return gamePlayer;
		
	}
	
	
	public CurrentGame currentgameInfo(String summonerId) {
		
		CurrentGame game = new CurrentGame();
		
		
		if(riot.currentgameInfo(summonerId) == null) {
			System.out.println("설마여기들어오나 null");
			return null;
		}
		
		CurrentGameInfo info = riot.currentgameInfo(summonerId);
		String queue_Type = "RANKED_SOLO_5x5";
		CurrentPlayer[] currentplayer = new CurrentPlayer[10];
		
		
		info.getGameQueueConfigId(); //솔랭인지파악
		
		
		long time = System.currentTimeMillis()-info.getGameStartTime();
		Date mDate = new Date(time);
		SimpleDateFormat mFormat = new SimpleDateFormat("mm:ss");
		String current = mFormat.format(mDate);
		System.out.println("현재게임시간 : "+ current);
		String[] times = current.split(":");
		
		game.setTime(times[0]+"분"+" "+times[1]+"초");
		
		List<CurrentGameParticipant> gamePlayer = info.getParticipants();
		
		//현재 게임중인 플레이어의 챔피언 정보
		/*CurrentGameParticipant player1 = gamePlayer.get(0);
		CurrentGameParticipant player2 =gamePlayer.get(1);
		CurrentGameParticipant player3 =gamePlayer.get(2);
		CurrentGameParticipant player4 =gamePlayer.get(3);
		CurrentGameParticipant player5 =gamePlayer.get(4);
		CurrentGameParticipant player6 =gamePlayer.get(5);
		CurrentGameParticipant player7 =gamePlayer.get(6);
		CurrentGameParticipant player8 =gamePlayer.get(7);
		
		mservice.ChampInfo(player1.getSummonerName(), player1.getChampionId());
		mservice.ChampInfo(player2.getSummonerName(), player2.getChampionId());
		mservice.ChampInfo(player3.getSummonerName(), player3.getChampionId());
		mservice.ChampInfo(player4.getSummonerName(), player4.getChampionId());
		mservice.ChampInfo(player5.getSummonerName(), player5.getChampionId());
		mservice.ChampInfo(player6.getSummonerName(), player6.getChampionId());
		mservice.ChampInfo(player7.getSummonerName(), player7.getChampionId());
		mservice.ChampInfo(player8.getSummonerName(), player8.getChampionId());
		*/
		
		
		/*
		for(int i=0; i<gamePlayer.size(); i++) {
			CurrentGameParticipant player = gamePlayer.get(i);
			
			
			mservice.ChampInfo(player.getSummonerName(), player.getChampionId());
			
			
			
			
		}
		*/
		for(int i=0; i<gamePlayer.size(); i++) {
			CurrentGameParticipant player = gamePlayer.get(i);
			
			CurrentPlayer participant = new CurrentPlayer();
			
			
			participant.setSpell1(SearchSpell(spellData,(int)player.getSpell1Id()));
			participant.setSpell2(SearchSpell(spellData,(int)player.getSpell2Id()));
			
			participant.setChamp(
			SearchChamp(champData,(int)player.getChampionId()));
			Perks rune = player.getPerks();
			
			participant.setPrimaryRune(
					SearchRune(runeData,(int)rune.getPerkStyle()));
			participant.setPr1(
					SearchRune(runeData,rune.getPerkIds().get(0).intValue()));
			participant.setPr2(SearchRune(runeData,rune.getPerkIds().get(1).intValue()));
			participant.setPr3(SearchRune(runeData,rune.getPerkIds().get(2).intValue()));
			participant.setPr4(SearchRune(runeData,rune.getPerkIds().get(3).intValue()));
			
			
			participant.setSubRune(
					SearchRune(runeData,(int)rune.getPerkSubStyle()));
			participant.setSr1(
					SearchRune(runeData,rune.getPerkIds().get(4).intValue()));
			participant.setSr2(
					SearchRune(runeData,rune.getPerkIds().get(5).intValue()));
			
			player.getSummonerId();
			
			List<LeaguePosition> Playerleague = riot.League(player.getSummonerId());
			for(int j=0; j<Playerleague.size(); j++) {
				
				if(Playerleague.get(j).getQueueType().isEmpty()) {
					
					
				}
				
				
				if(Playerleague.get(j).getQueueType().equals(queue_Type)) {
					
					if(Playerleague.get(j).getMiniSeries()!=null) {
						
					}
					String tier = getTierImgName(Playerleague.get(j).getTier());
					participant.setTier(tier);
					participant.setRank(Playerleague.get(j).getRank());
					participant.setLeaguePoints(Playerleague.get(j).getLeaguePoints());
					
				}	
			}
			
			
			
			participant.setSummonerName(player.getSummonerName());
			
			
			
			
			
			
			
			Map map = new HashMap();
			map.put("id", gamePlayer.get(i).getSummonerId());
			map.put("champid", (int)gamePlayer.get(i).getChampionId());
			ChampInfo PlayerChamp = dao.ReadChampInfo(map);
			
			
			if(PlayerChamp == null) {
				
				participant.setRatio("0");
				participant.setWinRatio("0");
				participant.setTotalGames(0);
				
				
			}else {
			
			
				int totalGames = PlayerChamp.getWins() + PlayerChamp.getFails();
				int kills = PlayerChamp.getKills();
				int deaths = PlayerChamp.getDeaths();
				int assists = PlayerChamp.getAssists();
				
				
				String ratio = String.format("%.2f", ((double)(kills+assists))/deaths);//평점
				String winRatio = String.format("%.2f", ((double)(PlayerChamp.getWins()))/totalGames); //승률
				
				participant.setRatio(ratio);
				participant.setWinRatio(winRatio);
				participant.setTotalGames(totalGames);
			}
			
			currentplayer[i] = participant;
			
		}
		List<BannedChampion> bannedChampions = info.getBannedChampions();
		Champ[] bannedChamps = new Champ[10];
		for(int i=0; i<10; i++) {
			Champ champ = new Champ();
			if((int)bannedChampions.get(i).getChampionId()==-1) {
				String image = "/resources/img/item/3637.png";
				System.out.println("null");
				champ.setId(image);
				
			}else {
				champ = SearchChamp(champData,(int)bannedChampions.get(i).getChampionId());
				
			}
			bannedChamps[i] = champ;
			
			
		}
		game.setChamps(bannedChamps);
		game.setPlayers(currentplayer);
		
		/*for(int i=0; i<currentplayer.length; i++) {
			System.out.println(currentplayer[i].getSummonerName());
			System.out.println("전체게임: "+currentplayer[i].getTotalGames());
			System.out.println("승률: " +currentplayer[i].getWinRatio()); 
			System.out.println("KDA: "+currentplayer[i].getRatio());
		}*/
		
		
		return game;
		
		
	}
	
	
	
	
	
}
