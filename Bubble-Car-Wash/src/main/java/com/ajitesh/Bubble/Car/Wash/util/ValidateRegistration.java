package com.ajitesh.Bubble.Car.Wash.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class ValidateRegistration {

	public boolean isValidRegistration (String registration) {
		Pattern pattern = Pattern.compile("[A-Z]{2}[0-9]{2}[A-Z]{1,2}[0-9]{4}");
		Matcher matcher = pattern.matcher(registration);
		return matcher.matches();
	}
}
