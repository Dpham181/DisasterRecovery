package com.project.DisasterRecovery;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(value = SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DisasterRecoveryTest{

	@Autowired
	org.springframework.test.web.reactive.server.WebTestClient WebTestClient;

	@Test
	void test0() {
		this.WebTestClient.get().uri("/").exchange().expectStatus().isOk();
	}

}
