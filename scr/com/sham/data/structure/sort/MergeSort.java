package com.sham.data.structure.sort;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {3,2,7,9,4,1};
		mergeSort(arr, 0, arr.length -1);
		for(int i = 0; i < arr.length ; i ++){
			System.out.println(arr[i]);
		}
	}
	
	public static void mergeSort(int array[], int low, int high){
		if(low < high){
			int mid = (low + high) / 2;
			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);
			merge(array, low, mid, high);
		}
	}
	
	public static void merge(int array[], int low, int mid, int high){
		int tempArray[] = new int [array.length];
		int firstLow = low, secondLow = mid + 1, index;
		for(index = low; firstLow <= mid && secondLow <= high; index++){
			if(array[firstLow] <= array[secondLow]){
				tempArray[index] = array[firstLow++];
			}else{
				tempArray[index] = array[secondLow++];
			}
		}
		while(firstLow <= mid){
			tempArray[index++] = array[firstLow++];
		}
		while(secondLow <= high){
			tempArray[index++] = array[secondLow++];
		}
		for(index = low; index <= high; index++)
			array[index] = tempArray[index];
	}
}
