package com.sham.data.structure.sort;

import java.lang.reflect.Array;

public class QuickSort {
	

	private void quickSort(int array[], int lowerIndex, int higherIndex) {

		int tempLowIndex = lowerIndex;
		int tempHighIndex = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		/*int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];*/
		int pivot = array[(higherIndex+lowerIndex)/2];
		// Divide into two arrays
		while (tempLowIndex <= tempHighIndex) {
			/**
			 * In each iteration, we will identify a number from left side which
			 * is greater then the pivot value, and also we will identify a number
			 * from right side which is less then the pivot value. Once the search
			 * is done, then we exchange both numbers.
			 */
			while (array[tempLowIndex] < pivot) {
				tempLowIndex++;
			}
			while (array[tempHighIndex] > pivot) {
				tempHighIndex--;
			}
			if (tempLowIndex <= tempHighIndex) {
				int temp = array[tempLowIndex];
				array[tempLowIndex] = array[tempHighIndex];
				array[tempHighIndex] = temp;
				//move index to next position on both sides
				tempLowIndex++;
				tempHighIndex--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < tempHighIndex){
			quickSort(array, lowerIndex, tempHighIndex);
		}
		if (tempLowIndex < higherIndex){
			quickSort(array, tempLowIndex, higherIndex);
		}
	}

	public static void main(String a[]){

		QuickSort sorter = new QuickSort();
		int[] input = {24,2,45,20,56,75,2,56,99,53,12};
		sorter.quickSort(input, 0, input.length - 1);
		for(int i:input){
			System.out.print(i);
			System.out.print(" ");
		}
	}
} 