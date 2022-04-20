package com.pakfortune.nobleSearchWS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.pakfortune.service"})
@ComponentScan({"com.pakfortune.api"})
public class NobleSearchWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NobleSearchWsApplication.class, args);
	}

}
