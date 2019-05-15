package com.sham.pattern.command;

public class Television implements ElectronicDevice {

	@Override
	public void On() {
		System.out.println("TV is on");
		
	}

	@Override
	public void Off() {
		System.out.println("TV is off");
		
	}

}
