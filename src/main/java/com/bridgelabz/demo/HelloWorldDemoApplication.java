package com.bridgelabz.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.bridgelabz.demo")
@EnableJpaRepositories("com.bridgelabz.demo.repository")
public class HelloWorldDemoApplication {

	public static final Logger loger=LoggerFactory.getLogger(HelloWorldDemoApplication.class);
	public static void main(String[] args) {
		loger.debug("hello");
		loger.info("demo");
		loger.error("error");
		loger.warn("warning");
		ApplicationContext context=SpringApplication.run(HelloWorldDemoApplication.class, args);
		System.out.println(context);
	}

}
