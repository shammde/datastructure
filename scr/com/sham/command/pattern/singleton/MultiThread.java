package com.sham.command.pattern.singleton;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiThread {

	public static int COUNT = 10;
	public static void main(String args[]){
		
		MultiThread multiThread = new MultiThread();
		multiThread.test();
	}
	
	public void test(){
		ExecutorService service = Executors.newFixedThreadPool(COUNT);
		Worker worker[] = new Worker[COUNT];
		for(int index = 0; index < COUNT; index++){
			worker[index] = new Worker();
		}
		for(int index = 0; index < COUNT; index++){
			if(index != COUNT - 1){
				worker[index].set(worker[index + 1], index+1);
			}else{
				worker[index].set(worker[0], index + 1);
			}
		}
		for(int index = 0; index < COUNT; index++){
			service.submit(worker[index]);
		}
		try {
			worker[0].queue.put(1);
		} catch (InterruptedException e) {
		}
	}
}


class Worker implements Callable<Integer>{

	BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);
	int threadNum = 0;
	Worker next = null;
	public Worker(){}
	public void set(Worker next, int threadNum){
		this.threadNum = threadNum;
		this.next = next;
	}
	@Override
	public Integer call() throws Exception {
		queue.take();
		System.out.println(Thread.currentThread().getName() + " - " + threadNum);
		Thread.sleep(1000);
		next.queue.add(threadNum);
		return null;
	}
}