package com.example.L08_Logging_MVC_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L08LoggingMvcDemoApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(L08LoggingMvcDemoApplication.class);

	public static void main(String[] args) {
		LOGGER.trace("Logging Trace");
		LOGGER.debug("Logging Debug");
		LOGGER.info("Logging Info");
		LOGGER.warn("Logging warn");
		LOGGER.error("Logging error");
		SpringApplication.run(L08LoggingMvcDemoApplication.class, args);
//		LOGGER.trace("Logging Trace");
//		LOGGER.debug("Logging Debug");
//		LOGGER.info("Logging Info");
//		LOGGER.warn("Logging warn");
//		LOGGER.error("Logging error");
	}

}
