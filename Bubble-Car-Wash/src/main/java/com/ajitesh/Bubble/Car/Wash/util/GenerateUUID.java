package com.ajitesh.Bubble.Car.Wash.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class GenerateUUID {

	public String genUUID() {
		return UUID.randomUUID().toString();
	}
}
