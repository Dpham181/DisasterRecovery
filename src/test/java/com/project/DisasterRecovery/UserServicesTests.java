package com.project.DisasterRecovery;
import com.project.DisasterRecovery.Entities.EndUser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserServicesTests {

    @Autowired
    WebTestClient   WebTestClient;

    @Test
    void test0() {
        this.WebTestClient.get().uri("/users").exchange().expectStatus().isOk();
    }

    
    @Test
    void test1() {
        this.WebTestClient.post().uri("/users/").contentType(MediaType.APPLICATION_JSON).bodyValue(new EndUser("danhpham312@gmail.com","123456")).exchange().expectStatus().isCreated();
    }
    
}
