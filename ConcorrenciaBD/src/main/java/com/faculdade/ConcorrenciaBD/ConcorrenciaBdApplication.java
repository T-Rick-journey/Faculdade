package com.faculdade.ConcorrenciaBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.faculdade.ConcorrenciaBD"})
public class ConcorrenciaBdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcorrenciaBdApplication.class, args);
	}

}
