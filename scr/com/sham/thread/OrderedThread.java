package com.sham.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderedThread {

	private static final int NUMBER_OF_THREAD = 10;
	public static void main(String[] args) {
		// Create the workers
		Worker workers[] = new Worker[NUMBER_OF_THREAD];
		for(int index = 0; index < NUMBER_OF_THREAD; index++){
			workers[index] = new Worker();
		}
		for(int index = 0; index < NUMBER_OF_THREAD; index++){
			if(index < NUMBER_OF_THREAD -1){
				workers[index].setNext(workers[index+1], index + 1);
			}else{
				workers[index].setNext(workers[0], 10);
			}
		}

		// Create named threads for the workers
		for(int index = 0; index < NUMBER_OF_THREAD; index++){
			new Thread(workers[index], "Thread-"+(index+1)+"- ").start();;
		}

		// Seed the first worker
		workers[0].accept(1);
		synchronized (workers[0].lock) {
			workers[0].lock.notify();
		}
		
	}
}
class Worker implements Runnable{

	BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>(); 
	Worker next = null; // next worker in the chain
	int nextNumber;
	public String lock = new String("");
	
	public void setNext(Worker t, int number) {
		this.nextNumber = number;
		this.next = t;
	}

	public void accept(int i) {
		q.add(i);
	}

	@Override
	public void run() {
		while (true){
			try {
				synchronized(lock){
					System.out.println(Thread.currentThread().getName() +" Locked lock" + lock);
					//int i = q.take(); // blocks till it receives a number
					lock.wait();
					System.out.println( Thread.currentThread().getName() +  nextNumber);
					Thread.sleep(1000); // delay to slow the printing
					if (next != null){
						//next.accept(nextNumber); // pass the next number to the next worker 
						synchronized (next.lock) {
							System.out.println(Thread.currentThread().getName() +" Locked next.lock to nofiy " + next.lock);
							next.lock.notify();
						}
						
					}
				}
			} catch (InterruptedException e) {
				System.err.println( Thread.currentThread().getName() + " interrrupted.");
			}
		}
	}
}