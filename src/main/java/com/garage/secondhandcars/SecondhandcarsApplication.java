package com.garage.secondhandcars;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecondhandcarsApplication {
	
	 private static final Logger LOGGER = LogManager.getLogger(SecondhandcarsApplication.class);

	public static void main(String[] args) {
		LOGGER.debug("Spring boot application started");
		SpringApplication.run(SecondhandcarsApplication.class, args);
	}

}
