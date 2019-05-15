package com.sham.lamda.simplelamda;

import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

public class Greeter {

	public void greet(Greeting greeting){
		greeting.perform("Hello World");
		
	}
	
	public static void main(String[] args) {
	
		Greeter greeter = new Greeter();
		Greeting lamdaGreeting = (String str) -> System.out.println(str);
		Greeting innerClassGreeting = new Greeting() {
			@Override
			public void perform(String str) {
				System.out.println(str);
			}
		};
		
		greeter.greet(lamdaGreeting);
		greeter.greet(innerClassGreeting);
		greeter.greet((String str) -> System.out.println(str));
		greeter.greet((str) -> System.out.println(str));
		greeter.greet(str -> System.out.println(str));
	}

}
