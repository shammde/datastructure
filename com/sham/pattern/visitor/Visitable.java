package com.sham.pattern.visitor;

public interface Visitable {

	public double accept(Visitor visitor);
}
