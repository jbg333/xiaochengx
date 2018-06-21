package com.weixin.note.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@SpringBootApplication
@EnableEurekaServer
public class WeixinEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeixinEurekaApplication.class, args);
	}
}
