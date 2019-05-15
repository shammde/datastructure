package com.sham.puzzle;

public class FilpArrayElement {

	private int countMaxSeq(int array[]){
		int maxSeq = 0;
		int tempMaxSeq = 0;
		for(int index = 0; index < array.length; index++){
			if(array[index] == 1){
				tempMaxSeq++;
			}else{
				maxSeq = maxSeq > tempMaxSeq ? maxSeq : tempMaxSeq;
				tempMaxSeq = 0;
			}
		}
		maxSeq = maxSeq > tempMaxSeq ? maxSeq : tempMaxSeq;
		return maxSeq;
	}

	private void fill(int array[], int count){
		for(int tempCount = 0; tempCount < count; tempCount++){
			int index = -1;
			int maxSeq = 0;
			for(int i = 0; i < array.length; i++){
				if(array[i] == 0){
					array[i] = 1;
					int tempMaxSeq = countMaxSeq(array);
					array[i] = 0;
					if(tempMaxSeq > maxSeq){
						maxSeq = tempMaxSeq;
						index = i;
					}
				}
			}
			System.out.println(index + " " + maxSeq);
			if(index > -1){
				array[index] = 1;
			}
		}
	}

	public static void main(String args[]){
		int array[] = {1,1,0,0,1,1,0,1,1,0,1,1,1};
		FilpArrayElement fae = new FilpArrayElement();
		fae.fill(array, 6);
	}
}
