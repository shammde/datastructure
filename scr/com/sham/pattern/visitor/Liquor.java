package com.sham.pattern.visitor;

public class Liquor extends Item implements Visitable {

	public Liquor(double price){
		super(price);
	}
	@Override
	public double accept(Visitor visitor) {
		return visitor.visit(this);
		
	}

}
