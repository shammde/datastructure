package com.sham.puzzle;

public class EggFloorPuzzle {

	int eggDrop(int n, int k){
		
		if(k ==0 || k ==0){
			return k;
		}
		if(n == 1){
			return k;
		}
		int min = Integer.MAX_VALUE, x, res;
		/*
		 * Consider all droppings from 1st floor to kth 
		 * floor and return the minimum of these values plus 1
		 */
		for(x = 1; x <= k; x++){
			res = Math.max(eggDrop(n - 1, x -1), eggDrop(n, k - x));
			if(res < min){
				min = res;
			}
		}
		return min + 1;
	}
	
	public static void main(String... strings){
		int n = 3, k = 10;
		//System.out.println("Min floor " + new EggFloorPuzzle().eggDrop(n, k));
	}
	
}
