package com.weixin.note.serv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableFeignClients(basePackages= {"com.jia.weixin.feign"})
@EnableEurekaClient
@SpringBootApplication
//@EnableSwagger2
public class WeixinServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeixinServiceApplication.class, args);
	}
}
