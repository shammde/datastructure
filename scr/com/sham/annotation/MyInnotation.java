package com.sham.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD}) 
@interface MyAnnotation{  
	int value1() default 1;  
	String value2() default "";  
	String value3() default "xyz";  
}  