package com.revature;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.revature")
public class BootDriver {
	private static Logger log = Logger.getRootLogger();
	public static void main(String[] args) {
		SpringApplication.run(BootDriver.class, args);
	}

}
