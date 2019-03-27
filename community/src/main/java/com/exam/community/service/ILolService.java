package com.exam.community.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.exam.Riot.CurrentGame;
import com.exam.Riot.CurrentPlayer;
import com.exam.Riot.Game;
import com.exam.Riot.LeaguePosition;
import com.exam.Riot.Match;
import com.exam.Riot.Matchlist;
import com.exam.Riot.Summoner;

public interface ILolService {
	
	
	
	public void init(String name) throws UnsupportedEncodingException;
	public String getTierImgName(String tier);
	public LeaguePosition getTierInfo(String rank);
	public String getProfileImg();
	public Summoner getSummoner();
	public List<Game> getMethod();
	
	public CurrentGame currentgameInfo(String summonerId);
	
	
}
