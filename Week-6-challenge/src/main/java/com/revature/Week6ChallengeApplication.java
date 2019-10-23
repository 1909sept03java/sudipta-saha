package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.revature.client",
"com.revature.controller"})
@EnableEurekaClient
@SpringBootApplication
public class Week6ChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week6ChallengeApplication.class, args);
	}

}
