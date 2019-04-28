package br.com.jfassis.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {
	
	public String formatLocalDateTimeToDatebaseStyle(LocalDateTime localDateTime) {
		return DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss").format(localDateTime);
	}

}
