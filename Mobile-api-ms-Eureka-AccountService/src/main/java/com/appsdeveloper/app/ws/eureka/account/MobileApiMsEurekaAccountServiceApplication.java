package com.appsdeveloper.app.ws.eureka.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MobileApiMsEurekaAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileApiMsEurekaAccountServiceApplication.class, args);
	}

}
