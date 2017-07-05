package com.sham.pattern.visitor;

public class Tobacco extends Item implements Visitable {

	public Tobacco(double price){
		super(price);
	}

	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
		
	}
}
