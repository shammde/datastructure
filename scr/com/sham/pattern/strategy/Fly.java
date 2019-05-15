package com.sham.pattern.strategy;

public interface Fly {

	public String tryToFly();
}

class ItFlys implements Fly{

	@Override
	public String tryToFly() {
		return "Fly High";
	}
	
}

class CantFlys implements Fly{

	@Override
	public String tryToFly() {
		return "Can't Fly";
	}
}