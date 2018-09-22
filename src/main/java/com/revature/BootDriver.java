package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.revature")
public class BootDriver {

	public static void main(String[] args) {
		SpringApplication.run(BootDriver.class, args);
	}

}
