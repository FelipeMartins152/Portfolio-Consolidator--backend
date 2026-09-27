package com.github.felipemartins152.consolidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PortfolioConsolidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioConsolidatorApplication.class, args);
	}

}
