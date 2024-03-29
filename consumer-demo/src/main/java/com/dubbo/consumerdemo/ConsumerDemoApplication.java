package com.dubbo.consumerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = "classpath:consumer.xml")
public class ConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerDemoApplication.class, args);
	}

}
