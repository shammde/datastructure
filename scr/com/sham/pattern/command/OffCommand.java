package com.sham.pattern.command;

public class OffCommand implements Command{

	ElectronicDevice theDevice;
	
	public OffCommand(ElectronicDevice newDevice){
		theDevice = newDevice;
	}
	
	@Override
	public void execute() {
		theDevice.Off();
		
	}

}
