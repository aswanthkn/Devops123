package com.backend.devops;

import org.springframework.boot.SpringApplication;

public class TestDevopsApplication {

	public static void main(String[] args) {
		SpringApplication.from(DevopsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
