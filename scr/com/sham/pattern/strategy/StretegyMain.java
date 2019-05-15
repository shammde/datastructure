package com.sham.pattern.strategy;

/**
 * 
 *      --------------------                           ------------------
 *      |    Animal        |------------------------*> | <Interface>Fly |
 *      --------------------                           ------------------
 *      | +flyingType:Fly  |                           |   +fly()       |
 *      --------------------                           |                |
 *      | tryToFly : String|                           ------------------
 *      | setFlyType : void|                             ^        ^
 *      --------------------                            .          .
 *           ^      ^                                  .            .
 *          /        \                                .              .
 *         /          \                              .                .
 *        /            \                            .                  .
 *  ----------------  ----------------         ----------------  ----------------
 *  |      Dog     |  |     Bird     |         |    Itflys    |  |     CantFly  |
 *  ----------------  ----------------         ----------------  ----------------
 * 
 * 
 * 
 * 
 * 
 * @author Ehtesham_M1
 *
 */
public class StretegyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
