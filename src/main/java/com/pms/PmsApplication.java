package com.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Urvesh
 *
 */
@SpringBootApplication
public class PmsApplication {

	public static void main(String[] args) {
		System.out.println("Start");
		SpringApplication.run(PmsApplication.class, args);
		System.out.println("End");
	}

}
