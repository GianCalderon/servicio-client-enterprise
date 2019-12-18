package com.springboot.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootServicioClientEnterpriseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioClientEnterpriseApplication.class, args);
	}

}
