package com.exam.Riot;

public class LeaguePosition {
	private String queueType;
	private String summonerName;
	private boolean hotStreak;
	private MiniSeries miniSeries;
	private int wins;
	private boolean veteran;
	private int losses;
	private boolean freshBlood;
	private String leagueId;
	private boolean inactive;
	private String rank;
	private String leagueName;
	private String tier;
	private String summonerId;
	private int leaguePoints;
	private String position;
	private double average;
	private String tier_img;
	
	
	
	
	public String getTier_img() {
		return tier_img;
	}
	public void setTier_img(String tier_img) {
		this.tier_img = tier_img;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public MiniSeries getMiniSeries() {
		return miniSeries;
	}
	public void setMiniSeries(MiniSeries miniSeries) {
		this.miniSeries = miniSeries;
	}
	public String getQueueType() {
		return queueType;
	}
	public void setQueueType(String queueType) {
		this.queueType = queueType;
	}
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
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public boolean isVeteran() {
		return veteran;
	}
	public void setVeteran(boolean veteran) {
		this.veteran = veteran;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public boolean isFreshBlood() {
		return freshBlood;
	}
	public void setFreshBlood(boolean freshBlood) {
		this.freshBlood = freshBlood;
	}
	public String getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}
	public boolean isInactive() {
		return inactive;
	}
	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
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
