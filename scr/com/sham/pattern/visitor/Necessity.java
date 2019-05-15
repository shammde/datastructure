package com.sham.pattern.visitor;

public class Necessity extends Item implements Visitable {

	public Necessity(double price){
		super(price);
	}

	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
		
	}
}
