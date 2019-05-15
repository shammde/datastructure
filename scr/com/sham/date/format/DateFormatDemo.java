package com.sham.date.format;


import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateFormatDemo {

  static public void displayDate(Locale currentLocale) {

    Date today;
    String dateOut;
    DateFormat dateFormatter;

    dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT,
        currentLocale);
    today = new Date();
    dateOut = dateFormatter.format(today);

    System.out.println(dateOut + "   " + currentLocale.toString());
  }

  static public void showBothStyles(Locale currentLocale) {

    Date today;
    String result;
    DateFormat formatter;

    int[] styles = { DateFormat.DEFAULT, DateFormat.SHORT, DateFormat.MEDIUM,
        DateFormat.LONG, DateFormat.FULL };

    System.out.println();
    System.out.println("Locale: " + currentLocale.toString());
    System.out.println();

    today = new Date();

    for (int k = 0; k < styles.length; k++) {
      formatter = DateFormat.getDateTimeInstance(styles[k], styles[k],
          currentLocale);
      result = formatter.format(today);
      System.out.println(result);
    }
  }

  static public void showDateStyles(Locale currentLocale) {

    Date today = new Date();
    String result;
    DateFormat formatter;

    int[] styles = { DateFormat.DEFAULT, DateFormat.SHORT, DateFormat.MEDIUM,
        DateFormat.LONG, DateFormat.FULL };

    System.out.println();
    System.out.println("Locale: " + currentLocale.toString());
    System.out.println();

    for (int k = 0; k < styles.length; k++) {
      formatter = DateFormat.getDateInstance(styles[k], currentLocale);
      result = formatter.format(today);
      System.out.println(result);
    }
  }

  static public void showTimeStyles(Locale currentLocale) {

    Date today = new Date();
    String result;
    DateFormat formatter;

    int[] styles = { DateFormat.DEFAULT, DateFormat.SHORT, DateFormat.MEDIUM,
        DateFormat.LONG, DateFormat.FULL };

    System.out.println();
    System.out.println("Locale: " + currentLocale.toString());
    System.out.println();

    for (int k = 0; k < styles.length; k++) {
      formatter = DateFormat.getTimeInstance(styles[k], currentLocale);
      result = formatter.format(today);
      System.out.println(result);
    }
  }

  public static void dateTime(){
	  Calendar cal = Calendar.getInstance();
      String day, month, year, hour, min, sec;

      /*if (tclosedTime != null)
      cal.setTime(tclosedTime);*/
          
      day = leadZero(cal.get(Calendar.DAY_OF_MONTH), 2);
      month = leadZero(cal.get(Calendar.MONTH) + 1, 2);
      year = leadZero(cal.get(Calendar.YEAR) % 100, 2);
      String dstr = month + "/" + day + "/" + year;

      hour = leadZero(cal.get(Calendar.HOUR_OF_DAY), 2);
      min = leadZero(cal.get(Calendar.MINUTE), 2);
      sec = leadZero(cal.get(Calendar.SECOND), 2);
      String tstr = hour + ":" + min + ":" + sec;
      
      System.out.println(dstr + " " + tstr);
  }
  /**
   * Just fill with leading zeroes
   * 
   * @param in
   * @param width
   * @return String
   */

  public static String leadZero(int in, int width) {
      String out, ZEROES = new String("0000000000");

      out = Integer.toString(in);
      width -= out.length();
      if (width > 0) {
          return ZEROES.substring(0, width) + out;
      }
      return out;
  }
  
   public static void main(String[] args) {

    Locale[] locales = { new Locale("fr", "FR"), new Locale("de", "DE"),
        new Locale("en", "US") };

    for (int i = 0; i < locales.length; i++) {
      displayDate(locales[i]);
    }
    
    DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("hi", "IN"));
    DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.LONG, Locale.US);//new Locale("hi", "IN"));
    System.out.println(dateFormatter.format(new Date()));
    System.out.println(timeFormatter.format(new Date()));

    String dateStr = "2016-10-16T23:34:30-08:00";
    XMLGregorianCalendar cal;
	try {
		cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateStr);
		System.out.println(timeFormatter.format(cal.toGregorianCalendar().getTime()));
		timeFormatter.setTimeZone(TimeZone.getDefault());
				System.out.println(timeFormatter.format(cal.toGregorianCalendar().getTime()));
	} catch (DatatypeConfigurationException e) {
	}
	
    System.out.println(Currency.getInstance(new Locale("hi", "IN")).getSymbol(new Locale("hi", "IN")));
 
    NumberFormat	nf = NumberFormat.getCurrencyInstance(new Locale("hi", "IN"));
    System.out.println(nf.format(1234));
    System.out.println("\u062E\u0648\u0628\u0635\u0648\u0631\u062A \u062F\u0646\u06CC\u0627");
    
    
    
    /*showDateStyles(new Locale("en", "US"));
    showDateStyles(new Locale("fr", "FR"));
    showDateStyles(new Locale("hi", "IN"));
    showDateStyles(Locale.CHINA);
    showDateStyles(Locale.TAIWAN);*/

    /*showTimeStyles(new Locale("en", "US"));
    showTimeStyles(new Locale("de", "DE"));

    showBothStyles(new Locale("en", "US"));
    showBothStyles(new Locale("fr", "FR"));*/

  }
}
