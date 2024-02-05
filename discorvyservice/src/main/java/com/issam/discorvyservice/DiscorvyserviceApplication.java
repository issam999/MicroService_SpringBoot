package com.issam.discorvyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscorvyserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscorvyserviceApplication.class, args);
	}

}
