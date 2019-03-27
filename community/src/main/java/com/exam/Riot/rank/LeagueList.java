package com.exam.Riot.rank;

import java.util.List;

public class LeagueList {
	private String leagueId;
	private String tier;
	private List<LeagueItem> entries;
	private String queue;
	private String name;
	public String getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public List<LeagueItem> getEntries() {
		return entries;
	}
	public void setEntries(List<LeagueItem> entries) {
		this.entries = entries;
	}
	public String getQueue() {
		return queue;
	}
	public void setQueue(String queue) {
		this.queue = queue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	

}
