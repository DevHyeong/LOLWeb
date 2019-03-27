package com.exam.Riot.champ;

public class ChampInfo {
	
	
	private String id;
	private int champid;
	private int wins;
	private int fails;
	
	private int kills;
	private int assists;
	private int deaths;
	private long date;
	
	
	
	
	
	
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}

	
	public int getChampId() {
		return champid;
	}
	public void setChampId(int champid) {
		this.champid = champid;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getFails() {
		return fails;
	}
	public void setFails(int fails) {
		this.fails = fails;
	}
	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public int getAssists() {
		return assists;
	}
	public void setAssists(int assists) {
		this.assists = assists;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	
	
	
	
	
	
}
