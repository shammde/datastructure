package com.sham.data.structure.sort;

/**
 * 
 * Selection sort is an in-place sorting algorithm. Selection sort 
 * works well for small files. It is used for sorting the files with 
 * very large values and small keys. This is because selection is made
 * based on keys and swaps are made only when required.
 * 
 * @author Ehtesham_M1
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = {9,8,7,6,5,4,3,2,1};
		selectionSort(arr);
		for(int i = 0; i < arr.length ; i ++){
			System.out.println(arr[i]);
		}
	}

	public static void selectionSort(int array[]){
		for(int i = 0; i < array.length; i++){
			int minIndex = i;
			for(int j = i + 1; j < array.length; j++){
				if(array[minIndex] > array[j]){
					minIndex = j;
				}
			}
			if(array[i] > array[minIndex]){
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}
}
