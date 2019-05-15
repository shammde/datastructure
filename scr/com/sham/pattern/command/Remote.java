package com.sham.pattern.command;

/**  -------------------------------      -------------------------------    -------------------
 *  | <Interface> ElectronicDevice |      |   <Interface>Command         |   |     Button      |
 *   ------------------------------       -------------------------------    -------------------
 *  |   +on();                    | <---- |   +ElectronicDevice : device |<--| +Command: cmd   |
 *  |   +off();                   |       --------------------------------   -------------------
 *   ------------------------------       | +execute                     |   |   +press();     |
 *                                         -------------------------------   -------------------
 * 				^                                          ^
 *              *                                          *
 *           *     *                                    *     *
 *        Radio     Tv                              OnCommand  OffCommand
 * 
 * 
 * 
 * 
 * 
 * 
 * @author Ehtesham_M1
 *
 */
public class Remote {

	public static void main(String args[]){
		
		ElectronicDevice tv = new Television();
		Radio radio = new Radio();
		
		OnCommand onRadioCmd = new OnCommand(radio);
		OnCommand onCmd = new OnCommand(tv);
		
		DeviceButton onButton = new DeviceButton(onCmd);
		onButton.press();
	}
}
