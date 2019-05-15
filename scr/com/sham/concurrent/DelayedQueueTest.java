package com.sham.concurrent;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedQueueTest {

	public static void main(String[] args) {
		
        DelayQueue queue = new DelayQueue();
        Delayed element1 = new DelayedElement(new Date());
        queue.put(element1);
        try {
			Delayed element2 = queue.take();
			System.out.println(element2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
    }
}

class DelayedElement implements Delayed{

	Date date;
	
	public DelayedElement(Date date){
		this.date = date;
	}
	@Override
	public int compareTo(Delayed o) {
		return date.compareTo(((DelayedElement)o).date);
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return 0;
	}
	
}