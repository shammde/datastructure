package com.sham.pattern.command;

public class OnCommand implements Command{

	ElectronicDevice theDevice;
	
	public OnCommand(ElectronicDevice newDevice){
		theDevice = newDevice;
	}
	
	@Override
	public void execute() {
		theDevice.On();
		
	}
}
