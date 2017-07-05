package com.sham.pattern.visitor;

public interface Visitor {

	public double visit(Necessity necessityItem);
	public double visit(Tobacco tobaccoItem);
	public double visit(Liquor liquorItem); 
}
