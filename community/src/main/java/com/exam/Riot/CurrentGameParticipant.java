package com.exam.Riot;

import java.util.List;

public class CurrentGameParticipant {
	private long profileIconId;
	private long championId;
	private String summonerName;
	private List<GameCustomizationObject> gameCustomizationObjects;
	private boolean bot;
	private Perks perks;
	private long spell2Id;
	private long teamId;
	private long spell1Id;
	private String summonerId;
	public long getProfileIconId() {
		return profileIconId;
	}
	public void setProfileIconId(long profileIconId) {
		this.profileIconId = profileIconId;
	}
	public long getChampionId() {
		return championId;
	}
	public void setChampionId(long championId) {
		this.championId = championId;
	}
	public String getSummonerName() {
		return summonerName;
	}
	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}
	public List<GameCustomizationObject> getGameCustomizationObjects() {
		return gameCustomizationObjects;
	}
	public void setGameCustomizationObjects(List<GameCustomizationObject> gameCustomizationObjects) {
		this.gameCustomizationObjects = gameCustomizationObjects;
	}
	public boolean isBot() {
		return bot;
	}
	public void setBot(boolean bot) {
		this.bot = bot;
	}
	public Perks getPerks() {
		return perks;
	}
	public void setPerks(Perks perks) {
		this.perks = perks;
	}
	public long getSpell2Id() {
		return spell2Id;
	}
	public void setSpell2Id(long spell2Id) {
		this.spell2Id = spell2Id;
	}
	public long getTeamId() {
		return teamId;
	}
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	public long getSpell1Id() {
		return spell1Id;
	}
	public void setSpell1Id(long spell1Id) {
		this.spell1Id = spell1Id;
	}
	public String getSummonerId() {
		return summonerId;
	}
	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}
	
	
	
	
}
