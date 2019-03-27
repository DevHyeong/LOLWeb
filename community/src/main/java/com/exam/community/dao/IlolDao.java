package com.exam.community.dao;

import java.util.Map;

import com.exam.Riot.champ.ChampInfo;

public interface IlolDao {
	
	void InsertChampInfo(ChampInfo champ);
	ChampInfo ReadChampInfo(Map map);
	
	
}
