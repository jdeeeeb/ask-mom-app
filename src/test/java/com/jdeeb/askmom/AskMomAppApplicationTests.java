package com.jdeeb.askmom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AskMomAppApplicationTests {

	private static Logger logger = LoggerFactory.getLogger(AskMomAppApplicationTests.class);
	
	@Test
	void contextLoads() {
		logger.info("Test Unit started");
		assertEquals(true, true);
	}

}
