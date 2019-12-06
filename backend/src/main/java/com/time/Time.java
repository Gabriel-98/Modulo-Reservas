package com.time;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
	
	public static String getLocalDateTimeNow() {
		return LocalDateTime.now(Clock.systemUTC()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
	}
}
