package com.microapp.microapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
@FlywayDataSource
class MicroappApplicationTests {

	@Test
	void contextLoads() {
	}

}
