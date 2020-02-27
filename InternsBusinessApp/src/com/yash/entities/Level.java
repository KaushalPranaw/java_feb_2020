package com.yash.entities;

public enum Level {

	BEGINNER(0), INTERMEDIATE(1), ADVANCE(2);
	private int level;

	private Level(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
}
