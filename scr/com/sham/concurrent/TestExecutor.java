package com.sham.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TestExecutor {

	public static void main(String args[]){

		ScheduledExecutorService scheduledExecutorService =
				Executors.newScheduledThreadPool(1);
		ScheduledFuture<String> scheduledFuture =
				scheduledExecutorService.schedule(new Callable<String>() {
					public String call() throws Exception {
						System.out.println("Executed!");
						return "Called!";
					}
				},	5,	TimeUnit.SECONDS);
		try {
			System.out.println("result = " + scheduledFuture.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		scheduledExecutorService.shutdown();
	}
}