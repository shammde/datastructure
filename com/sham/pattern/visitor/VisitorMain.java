package com.sham.pattern.visitor;

/**
 * 
 *      --------------------                       ------------------------
 *      |<Interface>Visitor|					   | <Interface>Visitable |
 *      --------------------                       ------------------------
 *      | +flyingType:Fly  |                       |+accept (Visitor):long|
 *      --------------------                       |                      |
 *      |+visit(Plu) : long|                       ------------------------
 *      |+visit(Fuel): long|                            ^        ^
 *      --------------------                           /          \
 *           ^        ^                               /            \
 *          /          \                             /              \
 *         /            \                           /                \
 *        /              \                         /                  \
 *  -----------------  ----------------       ----------------  ----------------
 *  |  TaxVisitor   |  |  GSTVisitor  |       |    PLU       |  |     Fuel     |
 *  -----------------  ----------------       ----------------  ----------------
 * 
 * 
 * 
 * 
 * 
 * @author Ehtesham_M1
 *
 */
public class VisitorMain {
	
	TaxVisitor taxCalc = new TaxVisitor();
	GSTVisitor gstCalc = new GSTVisitor();
	
	Necessity milk = new Necessity(1.55);
	Liquor pouch = new Liquor(2.45);
	Tobacco bidi = new Tobacco(3.12);
	
	public static void main(String args[]){
		new VisitorMain().test();
	}
	
	public void test(){
		System.out.println("Milk with tax " + milk.accept(taxCalc));
		System.out.println("Pouch with tax " + pouch.accept(taxCalc));
		System.out.println("Bidi with tax " + bidi.accept(taxCalc));
		
		System.out.println("Milk with tax " + milk.accept(gstCalc));
		System.out.println("Pouch with tax " + pouch.accept(gstCalc));
		System.out.println("Bidi with tax " + bidi.accept(gstCalc));
	}
}
