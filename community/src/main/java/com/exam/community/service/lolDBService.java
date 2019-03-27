package com.exam.community.service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.exam.Riot.ChampMastery;
import com.exam.Riot.Match;
import com.exam.Riot.MatchReference;
import com.exam.Riot.Matchlist;
import com.exam.Riot.Participant;
import com.exam.Riot.Summoner;
import com.exam.Riot.champ.ChampInfo;
import com.exam.community.RiotGames;
import com.exam.community.dao.lolDao;

@Service
public class lolDBService{
	
	@Autowired
	lolDao dao;
	
	
	@Async("asyncExecutor")
	public void asdf(String summonerName) {
		
		try {
			RiotGames riot = new RiotGames(summonerName);
			Summoner summoner = riot.summoner();
			
			Matchlist matchlist = riot.GameList(summoner.getAccountId());
			
			//�̹����� ��ũ �����.
			if(matchlist == null || matchlist.getMatches().isEmpty()) {
				System.out.println("null�̰ų� empty");
				return;
			}
			
			// �ش�è�Ǿ��� �ֱٿ� ���������� ������� keep;
			
			
			
			List<MatchReference> info = matchlist.getMatches();
			
			
			// ������ SummonerName�� ���� ������ ����Ǿ��ְ�, ���� ������ �����Ѵٴ��� �Ҷ�(������Ʈ)
			// DB�� ���� GAMEId���� ��������.
			// for���� ���� gameId���� ���� ���, return;
			
			
			/*
			long gameid = 123123;
			
			if(info.get(0).getGameId() == gameid) {
				return;
			}*/
			
			
			
			
			for(int j=info.size()-1; j>=0; j--) {
				long GameId = info.get(j).getGameId();
				
				/*if(gameid == GameId) {
					break;
				}*/
				
				int champId = info.get(j).getChampion();
				Match match = riot.match(GameId);
				List<Participant> participants = match.getParticipants();
				
				for(int k=0; k<participants.size(); k++) {
					if(champId == participants.get(k).getChampionId()) {
						
						int kill = participants.get(k).getStats().getKills();
						int death = participants.get(k).getStats().getDeaths();
						int assist = participants.get(k).getStats().getAssists();
						boolean result = participants.get(k).getStats().getWin();
						ChampInfo champinfo = new ChampInfo();
						
						champinfo.setAssists(assist);
						champinfo.setKills(kill);
						champinfo.setDeaths(death);
						champinfo.setChampId(champId);
						champinfo.setId(summoner.getId());
						
						
						System.out.println(champId + " ��� "+result);
						if(result == false) {
							champinfo.setWins(0);
							champinfo.setFails(1);
						}else {
							champinfo.setWins(1);
							champinfo.setFails(0);
							
						}
						
						
						champinfo.setDate(info.get(j).getTimestamp());
						
						/*System.out.println(champinfo.getId());
						System.out.println(champinfo.getChampId());
						System.out.println(champinfo.getAssists());
						System.out.println(champinfo.getKills());
						System.out.println(champinfo.getDeaths());
						System.out.println(champinfo.getWins());
						System.out.println(champinfo.getFails());*/
						
						dao.InsertChampInfo(champinfo);
						break;
					}
					
				}
			
			
			}
			
			info.get(0).getGameId();
			summoner.getId();
			summoner.getName();
			
			System.out.println("finish");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	@Async("asyncExecutor")
	public void champInfo(String summonerName) {
		// TODO Auto-generated method stub
		
		try {
			RiotGames riot = new RiotGames(summonerName);
			Summoner summoner = riot.summoner();
			
			
			
			System.out.println("��ȯ�� �̸� ���� "+summoner.getName());
			List<ChampMastery> champ = riot.Champ_Mastery(summoner.getId());
			List<ChampInfo> champlist = new ArrayList<>();
			
			
			for(int i=0; i<champ.size(); i++) {
				int champId = (int) champ.get(i).getChampionId();
				
				
				Matchlist matchlist = riot.GameList(champId,summoner.getAccountId());
				
				if(matchlist == null || matchlist.getMatches().isEmpty()) {
					System.out.println("null�̰ų� empty");
					continue;
				}
				
				
				List<MatchReference> info = matchlist.getMatches();
				
				Map map = new HashMap();
				map.put("id", summoner.getId());
				map.put("champid", champId);
				
				
				ChampInfo readChamp = dao.ReadChampInfo(map);
				if(readChamp !=null) {
					if(readChamp.getDate() >=info.get(0).getTimestamp()) {
						System.out.println("long type equals");
						continue;
					}
				}
				
				//�� è�Ǿ����� ���� ������ ����� ��������.(kill,assists �� ������ ��� ����)
				for(int j=info.size()-1; j>=0; j--) {
					long GameId = info.get(j).getGameId();
					Match match = riot.match(GameId);
					List<Participant> participants = match.getParticipants();
					
					for(int k=0; k<participants.size(); k++) {
						if(champId == participants.get(k).getChampionId()) {
							
							int kill = participants.get(k).getStats().getKills();
							int death = participants.get(k).getStats().getDeaths();
							int assist = participants.get(k).getStats().getAssists();
							boolean result = participants.get(k).getStats().getWin();
							ChampInfo champinfo = new ChampInfo();
							
							champinfo.setAssists(assist);
							champinfo.setKills(kill);
							champinfo.setDeaths(death);
							champinfo.setChampId(champId);
							champinfo.setId(summoner.getId());
							
							
							System.out.println(champId + " ��� "+result);
							if(result == false) {
								champinfo.setWins(0);
								champinfo.setFails(1);
							}else {
								champinfo.setWins(1);
								champinfo.setFails(0);
								
							}
							
							
							champinfo.setDate(info.get(j).getTimestamp());
							
							/*System.out.println(champinfo.getId());
							System.out.println(champinfo.getChampId());
							System.out.println(champinfo.getAssists());
							System.out.println(champinfo.getKills());
							System.out.println(champinfo.getDeaths());
							System.out.println(champinfo.getWins());
							System.out.println(champinfo.getFails());*/
							
							dao.InsertChampInfo(champinfo);
							break;
						}
						
					}
					
					
				}
				
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Async("asyncExecutor")
	public void ChampInfo(String summonerName,long championId) { // �����ε�
		
		System.out.println(summonerName + " "+ championId);
		try {
			int champId = (int)championId;
			RiotGames riot = new RiotGames(summonerName);
			Summoner summoner = riot.summoner();
			
			//���⼭ error�� ���ٴ� ����. �̹����� �ش� è�Ǿ� 0����.
			if(riot.GameList(champId,summoner.getAccountId())==null){
				return;
			}
			Matchlist matchlist = riot.GameList(champId,summoner.getAccountId());
			
			if(matchlist.getMatches().isEmpty()) { //13���� �ѹ��� ������ ����.
				System.out.println("null�̰ų� empty");
				return;
				
			}
			
			
			List<MatchReference> info = matchlist.getMatches();
			Map map = new HashMap();
			map.put("id", summoner.getId());
			map.put("champid", champId);
			
			ChampInfo readChamp = dao.ReadChampInfo(map);
			
			if(readChamp != null) {
				if(readChamp.getDate() >=info.get(0).getTimestamp()) {
					System.out.println("long type equals");
					return ;
				}
			}
			
			for(int j=info.size()-1; j>=0; j--) {
				long GameId = info.get(j).getGameId();
				Match match = riot.match(GameId);
				List<Participant> participants = match.getParticipants();
				Thread.sleep(1000);
				for(int k=0; k<participants.size(); k++) {
					if(champId == participants.get(k).getChampionId()) {
						
						int kill = participants.get(k).getStats().getKills();
						int death = participants.get(k).getStats().getDeaths();
						int assist = participants.get(k).getStats().getAssists();
						boolean result = participants.get(k).getStats().getWin();
						ChampInfo champinfo = new ChampInfo();
						
						champinfo.setAssists(assist);
						champinfo.setKills(kill);
						champinfo.setDeaths(death);
						champinfo.setChampId(champId);
						champinfo.setId(summoner.getId());
						
						
						System.out.println(champId + " ��� "+result);
						if(result == false) {
							champinfo.setWins(0);
							champinfo.setFails(1);
						}else {
							champinfo.setWins(1);
							champinfo.setFails(0);
							
						}
						
						
						champinfo.setDate(info.get(j).getTimestamp());
						
						/*System.out.println(champinfo.getId());
						System.out.println(champinfo.getChampId());
						System.out.println(champinfo.getAssists());
						System.out.println(champinfo.getKills());
						System.out.println(champinfo.getDeaths());
						System.out.println(champinfo.getWins());
						System.out.println(champinfo.getFails());*/
						
						dao.InsertChampInfo(champinfo);
						break;
					}
					
				}
				
			}
			Map map1 = new HashMap();
			map.put("id", summoner.getId());
			map.put("champid", champId);
			ChampInfo PlayerChamp = dao.ReadChampInfo(map);
			
			
			System.out.println("��ȯ����̵�: "+summoner.getName() +" ��ü�Ǽ�: "+ "Win: "+PlayerChamp.getWins()
			+"Lose: "+PlayerChamp.getFails());
			
		
	
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
