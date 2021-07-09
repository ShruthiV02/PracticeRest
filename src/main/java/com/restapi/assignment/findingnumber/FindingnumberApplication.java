package com.restapi.assignment.findingnumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.restapi.assignment.findingnumber.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class FindingnumberApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindingnumberApplication.class, args);
	}

}
