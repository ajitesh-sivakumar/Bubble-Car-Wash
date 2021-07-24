package com.ajitesh.Bubble.Car.Wash.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class FormatDate {

	public LocalDate formatRegularDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date1 = LocalDate.parse(date,formatter);
		return date1;
	}
	
	public LocalDate formatEpochDate(long date) {
		return Instant.ofEpochSecond(date).atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
