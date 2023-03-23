package com.charter.communication.rewards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class RewardsApplication {
	@Autowired
	private ResourceLoader resourceLoader;

	@PostConstruct
	public void loadData() throws IOException {
		Resource resource = resourceLoader.getResource("classpath:import.sql");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(RewardsApplication.class, args);
	}

}
