package org.steinko.atm;

import java.io.IOException;


import org.apache.catalina.LifecycleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Domain {
	private final static Logger logger = LoggerFactory.getLogger(Domain.class);
	private static ConfigurableApplicationContext applicationContext;
	@Autowired
	
		public static void main(String[] args) {
			logger.info("Start domain main");
			applicationContext = SpringApplication.run(Domain.class, args);		
			logger.info("After SpringApplication run");
		}
		
		public static ApplicationContext getApplicationContext() {
			return applicationContext;
		}
		
	
	}

