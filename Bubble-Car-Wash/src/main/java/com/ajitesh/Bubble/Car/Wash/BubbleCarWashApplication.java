package com.ajitesh.Bubble.Car.Wash;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BubbleCarWashApplication {
	
	static Logger logger = LogManager.getLogger(BubbleCarWashApplication.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(BubbleCarWashApplication.class, args);
		logger.info("Bubble Car Wash - Application Started");
	}
}
