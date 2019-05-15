package com.sham.pattern.command;

public class Radio implements ElectronicDevice {

	@Override
	public void On() {
		System.out.println("Radio is on");
		
	}

	@Override
	public void Off() {
		System.out.println("Radio is off");
		
	}

}
