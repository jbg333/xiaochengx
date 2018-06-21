package com.weixin.note.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WeixinApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeixinApiApplication.class, args);
	}
}
