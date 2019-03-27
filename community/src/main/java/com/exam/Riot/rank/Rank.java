package com.exam.Riot.rank;

import com.exam.Riot.champ.Champ;

public class Rank {
	
	private int rank;
	private String summonerName;
	private String tier;
	private int win;
	private int lose;
	private int ratio;
	private Champ[] champ;
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getSummonerName() {
		return summonerName;
	}
	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public int getRatio() {
		return ratio;
	}
	public void setRatio(int ratio) {
		this.ratio = ratio;
	}
	public Champ[] getChamp() {
		return champ;
	}
	public void setChamp(Champ[] champ) {
		this.champ = champ;
	}
	
	
	
	
	
	
}
