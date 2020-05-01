package com.osman.homeadmin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateUtils {
	
	//return  date in a localized format
	public static String getLocalizedDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);	
		LocalDate localDate = LocalDate.now();
		return localDate.format(formatter);
	}
}
