package com.met.cdac.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication

/*@Configuration
@ComponentScan("com.met.cdac.springbootweb.*")
@EnableAutoConfiguration*/

public class SpringbootwebApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringbootwebApplication.class, args);
	}

	
	
}
