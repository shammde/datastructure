package com.sham.date.format;


import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.nio.charset.Charset;
class Labelframe extends Frame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Labelframe()
	{
		setLayout(new FlowLayout());
		Label lblText = new Label(new String("\u062E\u0648\u0628\u0635\u0648\u0631\u062A \u062F\u0646\u06CC\u0627".getBytes(Charset.forName("UTF-8"))));
		Label lblTextAlign = new Label("\u062E\u0648\u0628\u0635\u0648\u0631\u062A \u062F\u0646\u06CC\u0627",Label.RIGHT);
		//String str = new String("\u062E\u0648\u0628\u0635\u0648\u0631\u062A \u062F\u0646\u06CC\u0627".getBytes(Charset.forName("UTF-8")));
		//lblText.setText(str);
		add(lblText);
		add(lblTextAlign);
		System.out.println(new String("\u062E\u0648\u0628\u0635\u0648\u0631\u062A \u062F\u0646\u06CC\u0627".getBytes(Charset.forName("UTF-8"))));
		System.out.println(new String("\u062E\u0648\u0628\u0635\u0648\u0631\u062A \u062F\u0646\u06CC\u0627"));
		System.out.println("\u062E\u0648\u0628\u0635\u0648\u0631\u062A \u062F\u0646\u06CC\u0627");
	}
}
public class LabelJavaAwt
{    
	public static void main(String args[])
	{
		Labelframe frame = new Labelframe();
		frame.setTitle("Label Component");
		frame.setSize(150,150);
		frame.setVisible(true);
	}
} 