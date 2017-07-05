package com.sham.pattern.visitor;

public class TaxVisitor implements Visitor {

	@Override
	public double visit(Necessity necessityItem) {
		return necessityItem.getPrice() * 0 + necessityItem.getPrice();
	}

	@Override
	public double visit(Tobacco tobaccoItem) {
		return tobaccoItem.getPrice() * .25 + tobaccoItem.getPrice();
	}

	@Override
	public double visit(Liquor liquorItem) {
		return liquorItem.getPrice() * .20 + liquorItem.getPrice();
	}

}
