package cn.sirbox.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelResources {
	
	 String title();
	 int order() default 999999;
}
