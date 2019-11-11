package com.kristal.ai.config;


import javax.annotation.PostConstruct;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.kristal.ai")
public class KristalConfig {
	
	@PostConstruct
	public void init() {
		System.out.println("######################## : Test config" );
	}
	
}