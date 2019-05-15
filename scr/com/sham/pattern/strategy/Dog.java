package com.sham.pattern.strategy;

public class Dog extends Animal {

	public Dog(){
		super();
		this.setSound("Bark");
		this.setFlyType(new CantFlys());
	}
}
