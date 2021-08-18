package com.appsdeveloper.app.ws.eurekaservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MobileApiMsEurekaServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileApiMsEurekaServicesApplication.class, args);
	}

}
