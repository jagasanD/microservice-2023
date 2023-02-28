package com.example.photoDiscoveryServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PhotoDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoDiscoveryServerApplication.class, args);
	}

}
