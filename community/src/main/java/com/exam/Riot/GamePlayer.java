package com.exam.Riot;

import com.exam.Riot.champ.Champ;
import com.exam.Riot.item.Item;
import com.exam.Riot.rune.RuneValues;
import com.exam.Riot.spell.Spell;

public class GamePlayer {
	
	private Champ champ;
	
	private String summonerName;
	private String summonerTier;
	
	private int kills;
	private int deaths;
	private int assists;
	private String ratio;
	private int killRate;
	
	private int cs;
	private String csRatio;
	
	private int teamId;
	private String teamResult;
	
	private int champLevel;
	
	private Spell spell1;
	private Spell spell2;
	
	private RuneValues primaryRune;
	private RuneValues subRune;
	
	private Item[] items;
	
	
	private long damageTaken;
	private long damageDealt;
	
	private int wardsPlaced;
	private int wardsKilled;
	private int visionWardsBoughtInGame;
	
	private int damageTakenPer;
	private int damageDealtPer;
	
	
	
	
	public String getTeamResult() {
		return teamResult;
	}
	public void setTeamResult(String teamResult) {
		this.teamResult = teamResult;
	}
	public int getDamageTakenPer() {
		return damageTakenPer;
	}
	public void setDamageTakenPer(int damageTakenPer) {
		this.damageTakenPer = damageTakenPer;
	}
	public int getDamageDealtPer() {
		return damageDealtPer;
	}
	public void setDamageDealtPer(int damageDealtPer) {
		this.damageDealtPer = damageDealtPer;
	}
	public Champ getChamp() {
		return champ;
	}
	public void setChamp(Champ champ) {
		this.champ = champ;
	}
	public String getSummonerName() {
		return summonerName;
	}
	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}
	public String getSummonerTier() {
		return summonerTier;
	}
	public void setSummonerTier(String summonerTier) {
		this.summonerTier = summonerTier;
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
	public String getRatio() {
		return ratio;
	}
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	public int getKillRate() {
		return killRate;
	}
	public void setKillRate(int killRate) {
		this.killRate = killRate;
	}
	public int getCs() {
		return cs;
	}
	public void setCs(int cs) {
		this.cs = cs;
	}
	public String getCsRatio() {
		return csRatio;
	}
	public void setCsRatio(String csRatio) {
		this.csRatio = csRatio;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getChampLevel() {
		return champLevel;
	}
	public void setChampLevel(int champLevel) {
		this.champLevel = champLevel;
	}
	public Spell getSpell1() {
		return spell1;
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
	public Item[] getItems() {
		return items;
	}
	public void setItems(Item[] items) {
		this.items = items;
	}
	public long getDamageTaken() {
		return damageTaken;
	}
	public void setDamageTaken(long damageTaken) {
		this.damageTaken = damageTaken;
	}
	public long getDamageDealt() {
		return damageDealt;
	}
	public void setDamageDealt(long damageDealt) {
		this.damageDealt = damageDealt;
	}
	public int getWardsPlaced() {
		return wardsPlaced;
	}
	public void setWardsPlaced(int wardsPlaced) {
		this.wardsPlaced = wardsPlaced;
	}
	public int getWardsKilled() {
		return wardsKilled;
	}
	public void setWardsKilled(int wardsKilled) {
		this.wardsKilled = wardsKilled;
	}
	public int getVisionWardsBoughtInGame() {
		return visionWardsBoughtInGame;
	}
	public void setVisionWardsBoughtInGame(int visionWardsBoughtInGame) {
		this.visionWardsBoughtInGame = visionWardsBoughtInGame;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
