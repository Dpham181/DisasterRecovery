package com.project.DisasterRecovery.tdd.junitTestEndpoints;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.project.DisasterRecovery.Entities.Machine;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MachineServicesTests {

	@Autowired
    WebTestClient   WebTestClient;
	
	@Test
    void testGetMachineList() {
        this.WebTestClient.get().uri("/machines").exchange().expectStatus().isOk();
    }
	
	@Test
	void testGetOneMachine()  {
		this.WebTestClient.get().uri("/machines/1").exchange().expectStatus().isOk();
	}
	
	@Test
    void testCreateMachine() {
        this.WebTestClient.post().uri("/machines/").contentType(MediaType.APPLICATION_JSON).bodyValue(new Machine("PA-120", "Mike Fernandez", 80.0, 2400.0)).exchange().expectStatus().isCreated();
    }
	
	@Test
    void testUpdateMachine() {
        this.WebTestClient.put().uri("/machines/1").contentType(MediaType.APPLICATION_JSON).bodyValue(new Machine("PA-120", "Mike Fernandez", 80.0, 2400.0)).exchange().expectStatus().isAccepted();
    }
	
	@Test
    void testDeleteMachine() {
        this.WebTestClient.delete().uri("/machines/1").exchange().expectStatus().isAccepted();
    }
}
