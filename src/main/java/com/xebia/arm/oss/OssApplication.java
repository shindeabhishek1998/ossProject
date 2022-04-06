package com.xebia.arm.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfigurationPackage
public class OssApplication {

	public static void main(String[] args) {
		SpringApplication.run(OssApplication.class, args);
	}
}