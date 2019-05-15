package com.sham.hash;

public class SumOfThree {

	private void sum1(int array[], int sum){
		for(int i = 0; i < array.length - 2; i++){
			for(int j = i + 1; j < array.length - 1; j++){
				for(int k = i + 2; k < array.length ; k++){
					if(array[i] + array[j] + array[k] == sum){
						System.out.println(array[i] + " " + array[j] + " " + array[k]);
					}
				}
			}
		}
	}
	
	private void sum(int array[], int sum){
		for(int i = 0; i < array.length - 2; i++){
			int j = i + 1;
			int k = array.length - 1;
			while(j < k){
				if(array[i] + array[j] + array[k] == sum){
					System.out.println(array[i] + " " + array[j] + " " + array[k]);
					j++;
					k--;
				}
				if(array[i] + array[j] + array[k] < sum){
					j++;
				}else{
					k--;
				}
			}
		}
	}
	
	private void test(){
		int array[] = {1,1,2,2,2,3,3,4,4,5};
		sum1(array, 6);
	}
	public static void main(String[] args) {
		new SumOfThree().test();
	}

}
