
/*package com.project.DisasterRecovery.tdd.junitTestEndpoints;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.project.DisasterRecovery.Entities.EndUser;
import com.project.DisasterRecovery.Entities.Job;
import com.project.DisasterRecovery.repositories.JobRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class JobServicesTests {

	@Autowired
    WebTestClient   WebTestClient;
	
	@Test
	void testLogin()
	{
		this.WebTestClient.post().uri("/users/login").contentType(MediaType.APPLICATION_JSON).bodyValue(new EndUser("admin@gmail.com","123456")).exchange().expectStatus().isOk();
	}
	
	@Test
    void testGetJobList() {
        this.WebTestClient.get().uri("/jobs").exchange().expectStatus().isOk();
    }
	
	@Test
	void testGetOneJob()  {
		this.WebTestClient.get().uri("/jobs/1").exchange().expectStatus().isOk();
	}
	
	@Test
    void testCreateJob() {
        this.WebTestClient.post().uri("/jobs/").contentType(MediaType.APPLICATION_JSON).bodyValue(new Job("Plumber", "Fix the plumbing", 65.0, 6.0)).exchange().expectStatus().isCreated();
    }
	
	@Test
    void testUpdateJob() {
        this.WebTestClient.put().uri("/jobs/1").contentType(MediaType.APPLICATION_JSON).bodyValue(new Job("Plumber", "Fix the plumbing", 65.0, 6.0)).exchange().expectStatus().isAccepted();
    }
	
	@Test
    void testDeleteJob() {
        this.WebTestClient.delete().uri("/jobs/1").exchange().expectStatus().isAccepted();

    }

	
}
*/
