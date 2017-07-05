package com.sham.data.structure.sort;

public class MergeSort {

	public static void main(String[] args) {

		int arr[] = {3,2,4,1};
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
		int tempLow = low, tempLow2 = mid + 1, index;
		for(index = low; tempLow <= mid && tempLow2 <= high; index++){
			if(array[tempLow] <= array[tempLow2]){
				tempArray[index] = array[tempLow++];
			}else{
				tempArray[index] = array[tempLow2++];
			}
		}
		
		while(tempLow <= mid){
			tempArray[index++] = array[tempLow++];
		}
		
		while(tempLow2 <= high){
			tempArray[index++] = array[tempLow2++];
		}
		for(index = low; index <= high; index++)
			array[index] = tempArray[index];
	}
}
