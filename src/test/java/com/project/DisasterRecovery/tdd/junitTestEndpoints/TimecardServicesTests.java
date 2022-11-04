package com.project.DisasterRecovery.tdd.junitTestEndpoints;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.project.DisasterRecovery.Entities.Machine;
import com.project.DisasterRecovery.Entities.TimeCard;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TimecardServicesTests {

	@Autowired
    WebTestClient   WebTestClient;
	
	
	@Test
    void testGetTimecardList() {
        this.WebTestClient.get().uri("/timecards").exchange().expectStatus().isOk();
    }
	
	@Test
	void testGetOneTimeCard()  {
		this.WebTestClient.get().uri("/timecards/1").exchange().expectStatus().isOk();
	}
	
	@Test
    void testCreateTimeCard() {
        this.WebTestClient.post().uri("/timecards/").contentType(MediaType.APPLICATION_JSON).bodyValue(new TimeCard("PA-120", "Mike Fernandez", 80.0, 2400.0, "Open", new Date())).exchange().expectStatus().isCreated();
    }
	
	@Test
    void testUpdateTimeCard() {
        this.WebTestClient.put().uri("/timecards/1").contentType(MediaType.APPLICATION_JSON).bodyValue(new TimeCard("PA-120", "Mike Fernandez", 80.0, 2400.0, "Open", new Date())).exchange().expectStatus().isAccepted();
    }
	
	@Test
    void testDeleteTimeCard() {
        this.WebTestClient.delete().uri("/timecards/1").exchange().expectStatus().isAccepted();
    }
}
