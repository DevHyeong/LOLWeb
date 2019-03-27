package com.exam.Riot;

import com.exam.Riot.champ.Champ;

public class CurrentGame {
	CurrentPlayer[] players;
	Champ[] champs;
	String time;
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public CurrentPlayer[] getPlayers() {
		return players;
	}
	public void setPlayers(CurrentPlayer[] players) {
		this.players = players;
	}
	public Champ[] getChamps() {
		return champs;
	}
	public void setChamps(Champ[] champs) {
		this.champs = champs;
	}
	
	
	
	
	
}
