package com.sham.command.pattern.singleton;

import java.lang.reflect.Constructor;

public class SingletonBreaker {


	public static void main(String args[]) {

		EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton instanceTwo = null;
		try {
			Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				//Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}
}

class EagerInitializedSingleton {

	private static EagerInitializedSingleton instance;

	private EagerInitializedSingleton(){}

	//static block initialization for exception handling
	static{
		try{
			instance = new EagerInitializedSingleton();
		}catch(Exception e){
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}
	public static EagerInitializedSingleton getInstance(){
		return instance;
	}
}