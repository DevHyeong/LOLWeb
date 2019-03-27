package com.exam.Riot.rune;

import java.util.List;

public class RuneReforged {
	
	private int id;
	private String key;
	private String icon;
	private String name;
	private List<Runes> slots;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Runes> getSlots() {
		return slots;
	}
	public void setSlots(List<Runes> slots) {
		this.slots = slots;
	}
	
	

}
