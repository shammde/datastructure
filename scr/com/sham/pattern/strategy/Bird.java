package com.sham.pattern.strategy;

public class Bird extends Animal {

	public Bird(){
		super();
		this.setSound("Tweet");
		this.setFlyType(new ItFlys());
	}
}
