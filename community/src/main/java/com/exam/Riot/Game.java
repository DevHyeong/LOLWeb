package com.exam.Riot;

import java.util.List;

import com.exam.Riot.champ.Champ;
import com.exam.Riot.item.Item;
import com.exam.Riot.rune.RuneValues;
import com.exam.Riot.spell.Spell;

public class Game {
	
	private long gameId;
	
	private String gameMode;
	private String gameTime;
	private String gameCreation;
	
	
	private Champ champ;
	private String result;
	
	private int kills;
	private int deaths;
	private int assists;
	private String ratio;
	private int killRate;
	
	private int cs;
	private String csRatio;
	
	private int teamId;
	private int champLevel;
	
	private Spell spell1;
	private Spell spell2;
	
	private RuneValues primaryRune;
	private RuneValues subRune;
	
	
	private Players[] player;
	/*private List<String> player;
	private List<String> line;
	private List<Champ> champ;*/
	
	
	private Item[] items;
	
	
	
	
	
	
	
	
	
	
	
	
	public String getCsRatio() {
		return csRatio;
	}
	public void setCsRatio(String csRatio) {
		this.csRatio = csRatio;
	}
	public int getCs() {
		return cs;
	}
	public void setCs(int cs) {
		this.cs = cs;
	}
	public int getChampLevel() {
		return champLevel;
	}
	public void setChampLevel(int champLevel) {
		this.champLevel = champLevel;
	}
	public String getGameCreation() {
		return gameCreation;
	}
	public void setGameCreation(String gameCreation) {
		this.gameCreation = gameCreation;
	}
	public String getGameTime() {
		return gameTime;
	}
	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}
	
	
	
	
	
	
	public RuneValues getPrimaryRune() {
		return primaryRune;
	}
	public void setPrimaryRune(RuneValues primaryRune) {
		this.primaryRune = primaryRune;
	}
	public RuneValues getSubRune() {
		return subRune;
	}
	public void setSubRune(RuneValues subRune) {
		this.subRune = subRune;
	}
	public Champ getChamp() {
		return champ;
	}
	public void setChamp(Champ champ) {
		this.champ = champ;
	}
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public String getGameMode() {
		return gameMode;
	}
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	public int getAssists() {
		return assists;
	}
	public void setAssists(int assists) {
		this.assists = assists;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public List<Integer> getChampionId() {
		return championId;
	}
	public void setChampionId(List<Integer> championId) {
		this.championId = championId;
	}*/
	
	
	
	
	
	
	
	
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public Spell getSpell1() {
		return spell1;
	}
	public String getRatio() {
		return ratio;
	}
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	public void setSpell1(Spell spell1) {
		this.spell1 = spell1;
	}
	public Spell getSpell2() {
		return spell2;
	}
	public void setSpell2(Spell spell2) {
		this.spell2 = spell2;
	}
	
	public Players[] getPlayer() {
		return player;
	}
	public void setPlayer(Players[] player) {
		this.player = player;
	}
	public Item[] getItems() {
		return items;
	}
	public void setItems(Item[] items) {
		this.items = items;
	}
	public int getKillRate() {
		return killRate;
	}
	public void setKillRate(int killRate) {
		this.killRate = killRate;
	}
	
	
	
	
	
	
	
	
	

}
