package com.izyacademy.MonitoreoAmbiental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.izyacademy.MonitoreoAmbiental.Repositories")
@SpringBootApplication
public class MonitoreoAmbientalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoreoAmbientalApplication.class, args);
	}

}
