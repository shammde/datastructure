package com.sham.data.structure.sort;

/**
 * Bubble sort is the simplest sorting algorithm. It works by iterating
 * the input array from the first element to the last, comparing each pair 
 * of elements and swapping them if needed. Bubble sort continues its 
 * iterations until no more swaps are needed. The algorithm gets its name 
 * from the way smaller elements “bubble” to the top of the list. 
 * Generally, insertion sort has better performance than bubble sort. 
 * Some researchers suggest that we should not teach bubble sort because 
 * of its simplicity and high time complexity.
 * 
 * The only significant advantage that bubble sort has over other 
 * implementations is that it can detect whether the input list is already 
 * sorted or not.
 * 
 * @author Ehtesham_M1
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,9,5,6,7,8};
		bubbleSort(arr);
		for(int i = 0; i < arr.length ; i ++){
			System.out.println(arr[i]);
		}
		
	}
	
	public static void bubbleSort(int array[]){
		for(int pass = array.length - 1; pass >=0 ; pass--){
			System.out.println("swapping in progress");
			for(int i = 0; i <= pass - 1; i++){
				if(array[i] > array[i+1]){
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}
	}
	
	public static void bubbleSortImproved(int array[]){
		boolean swapped = true;
		for(int pass = array.length - 1; pass >=0 && swapped ; pass--){
			swapped = false;
			System.out.println("swapping in progress");
			for(int i = 0; i <= pass - 1; i++){
				if(array[i] > array[i+1]){
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swapped = true;
				}
			}
		}
	}

}
