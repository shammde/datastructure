package com.sham.data.structure.stack;

import java.util.Arrays;

public class DoubleStack {
	
	int capacity1;
	int capacity2;
	int array[];
	
	int index1 = 0;
	int index2 = 0;
	
	public DoubleStack(int cap1, int cap2){
		capacity1 = cap1;
		capacity2 = cap2;
		array = new int[capacity1 + capacity2];
		index1 = 0;
		index2 = array.length - 1;
	}
	
	public void push1(int num){
		if(index1 >  index2 ){
			increaseSize();
		}
		array[index1++] = num;
		System.out.println("Index 1   " + index1);
	}
	public void push2(int num){
		if(index1+1 == index2){
			increaseSize();
		}
		array[index2--] = num;
		System.out.println("Index 2   " + index2);
	}
	
	public int pop1(){
		return array[--index1];
	}
	public int pop2(){
		return array[++index2];
	}
	private void increaseSize() {
		int temp[] = new int[array.length * 2];
		int tempIndex = temp.length - 1;
		for(int index = 0; index < index1; index++){
			temp[index] = array[index];
		}
		for(int index = array.length - 1; index > index2; index--, tempIndex--){
			temp[tempIndex] = array[index];
		}
		System.out.println("Index " + index2 + " New " + (tempIndex+1));
		index2 = tempIndex+1;
		array = temp;
	}
	public void print(){
		for(int index = 0; index < array.length; index++){
			System.out.print(array[index] + " ");
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		new DoubleStack(2,2).test();
	}
	public void test(){
		print();
		push1(1);
		push2(10);
		print();
		push1(2);
		push2(9);
		print();
		push1(3);
		push1(4);
		//push1(5);
		push2(8);
		pop2();
		push1(6);
		push1(7);
		push1(8);
		push1(9);
		push2(9);
//		
		print();
		
	}

}
