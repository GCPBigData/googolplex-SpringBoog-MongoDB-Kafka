package com.googolplex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.googolplex"})
@SpringBootApplication
public class GoogolplexApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogolplexApplication.class, args);
	}

}
