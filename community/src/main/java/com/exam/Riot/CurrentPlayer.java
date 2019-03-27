package com.exam.Riot;

import com.exam.Riot.champ.Champ;
import com.exam.Riot.rune.RuneValues;
import com.exam.Riot.spell.Spell;

public class CurrentPlayer {
	
	private String summonerName;
	
	private Champ champ;
	
	private Spell spell1;
	private Spell spell2;
	private RuneValues primaryRune;
	private RuneValues pr1;
	private RuneValues pr2;
	private RuneValues pr3;
	private RuneValues pr4;
	
	private RuneValues subRune;
	private RuneValues sr1;
	private RuneValues sr2;
	
	private String winRatio;
	private String ratio;
	private int totalGames;
	
	private String tier;
	private String rank;
	private int leaguePoints;
	
	
	
	
	
	
	
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getLeaguePoints() {
		return leaguePoints;
	}
	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
	}
	public String getWinRatio() {
		return winRatio;
	}
	public void setWinRatio(String winRatio) {
		this.winRatio = winRatio;
	}
	public String getRatio() {
		return ratio;
	}
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	public int getTotalGames() {
		return totalGames;
	}
	public void setTotalGames(int totalGames) {
		this.totalGames = totalGames;
	}
	public String getSummonerName() {
		return summonerName;
	}
	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}
	public Champ getChamp() {
		return champ;
	}
	public void setChamp(Champ champ) {
		this.champ = champ;
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
	public RuneValues getPr1() {
		return pr1;
	}
	public void setPr1(RuneValues pr1) {
		this.pr1 = pr1;
	}
	public RuneValues getPr2() {
		return pr2;
	}
	public void setPr2(RuneValues pr2) {
		this.pr2 = pr2;
	}
	public RuneValues getPr3() {
		return pr3;
	}
	public void setPr3(RuneValues pr3) {
		this.pr3 = pr3;
	}
	public RuneValues getPr4() {
		return pr4;
	}
	public void setPr4(RuneValues pr4) {
		this.pr4 = pr4;
	}
	public RuneValues getSubRune() {
		return subRune;
	}
	public void setSubRune(RuneValues subRune) {
		this.subRune = subRune;
	}
	public RuneValues getSr1() {
		return sr1;
	}
	public void setSr1(RuneValues sr1) {
		this.sr1 = sr1;
	}
	public RuneValues getSr2() {
		return sr2;
	}
	public void setSr2(RuneValues sr2) {
		this.sr2 = sr2;
	}
	
	
	
	
}
