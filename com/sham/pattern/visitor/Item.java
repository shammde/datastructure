package com.sham.pattern.visitor;

public abstract class Item {
	
	double price;
	
	public Item(double price) {
		this.price = price;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
