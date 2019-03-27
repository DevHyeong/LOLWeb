package com.exam.Riot.rank;

import com.exam.Riot.MiniSeries;

public class LeagueItem {
	
	private String summonerName;
	private boolean hotStreak;
	private MiniSeries miniSeries;
	private int wins;
	private Boolean veteran;
	private int losses;
	private Boolean freshBlood;
	private Boolean inactive;
	private String rank;
	private String summonerId;
	private int leaguePoints;
	public String getSummonerName() {
		return summonerName;
	}
	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}
	public boolean isHotStreak() {
		return hotStreak;
	}
	public void setHotStreak(boolean hotStreak) {
		this.hotStreak = hotStreak;
	}
	public MiniSeries getMiniSeries() {
		return miniSeries;
	}
	public void setMiniSeries(MiniSeries miniSeries) {
		this.miniSeries = miniSeries;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public Boolean getVeteran() {
		return veteran;
	}
	public void setVeteran(Boolean veteran) {
		this.veteran = veteran;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public Boolean getFreshBlood() {
		return freshBlood;
	}
	public void setFreshBlood(Boolean freshBlood) {
		this.freshBlood = freshBlood;
	}
	public Boolean getInactive() {
		return inactive;
	}
	public void setInactive(Boolean inactive) {
		this.inactive = inactive;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getSummonerId() {
		return summonerId;
	}
	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}
	public int getLeaguePoints() {
		return leaguePoints;
	}
	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
	}
	
	
	
	
	
	
}
