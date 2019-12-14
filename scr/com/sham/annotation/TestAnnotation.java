package com.sham.annotation;

import java.lang.reflect.Method;

class TestAnnotation{  
	public static void main(String args[])throws Exception{  

		Hello h = new Hello();  
		Method m=h.getClass().getMethod("sayHello");  

		MyAnnotation manno=m.getAnnotation(MyAnnotation.class);  
		System.out.println("value is: "+manno.value1());
		System.out.println("First change");
		System.out.println("Second changes");
		System.out.println("Third changes");
	}
}
