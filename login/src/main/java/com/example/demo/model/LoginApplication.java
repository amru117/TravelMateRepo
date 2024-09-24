package com.example.demo.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.controller.LoginController;

@SpringBootApplication
//@ComponentScan(basePackageClasses=LoginController.class)
@ComponentScan(basePackages = "com.example")
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

}
