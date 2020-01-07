package com.example.springboot;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class SpringbootApplicationTests {

	@Test
	void contextLoads() {
		final Logger logger = Logger.getLogger("TestErrOut");
		logger.debug("this is debug!!!");
		logger.info("this is info!!!");
		logger.warn("this is warn!!!");
		logger.error("this is error!!!");
		logger.fatal("this is fatal!!!");
	}

}
