package com.jbk.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jbk.springboot")
public class SpringbootRestWsCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestWsCrudApplication.class, args);
	}

}
