package com.sham.data.structure.sort;
/**
 * Insertion sort is a simple and efficient comparison sort. 
 * In this algorithm, each iteration removes an element from
 * the input data and inserts it into the correct position 
 * in the list being sorted. The choice of the element being 
 * removed from the input is random and this process is repeated 
 * until all input elements have gone through.
 * 
 * @author Ehtesham_M1
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = {1,3,2};
		insertionSort(arr);
		for(int i = 0; i < arr.length ; i ++){
			System.out.println(arr[i]);
		}
	}

	public static void insertionSort(int array[]){
		int j, temp;
		for(int i = 1; i < array.length ; i++){
			temp = array[i];
			j = i;
			while(j >= 1 && array[j - 1] > temp ){
				array[j] = array[j - 1];
				j--;
			}
			array[j] = temp;
		}
	}
}
