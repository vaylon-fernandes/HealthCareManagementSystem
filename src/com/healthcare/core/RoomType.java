package com.healthcare.core;

public enum RoomType {
	GENERAL(2000),SPECIAL(5000),SEMI_SPECIAL(3000),ICU(7000);
	// RoomTye Enum
	private double roomCost = 0;
	RoomType(double roomCost) {
		this.roomCost = roomCost;
	}
	
	@Override
	public String toString() {
		return "Room: "+this.name()+"Cost: "+this.roomCost;
	}
}
