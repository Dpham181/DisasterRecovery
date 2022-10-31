package com.project.DisasterRecovery;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(value = SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DisasterRecoveryTest{

	@Autowired
	WebTestClient   WebTestClient;

	@Test
	void test0() {
		this.WebTestClient.get().uri("/").exchange().expectStatus().isOk();
	}

}
