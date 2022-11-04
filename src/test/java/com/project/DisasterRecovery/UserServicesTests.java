package com.project.DisasterRecovery;
import com.project.DisasterRecovery.Entities.EndUser;
import com.project.DisasterRecovery.repositories.UserRepo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserServicesTests {

    @Autowired
    WebTestClient   WebTestClient;
    
    // user endpoint  
    @Test
    void test0() {
        this.WebTestClient.get().uri("/users/").exchange().expectStatus().isOk();
    }

    // user register 
    @Test
    void test1() {
        this.WebTestClient.post().uri("/users/").contentType(MediaType.APPLICATION_JSON).bodyValue(new EndUser("danhpham312@gmail.com","123456")).exchange().expectStatus().isOk();
    }
    // user login 
    @Test
    void test2() {
        this.WebTestClient.post().uri("/users/login").contentType(MediaType.APPLICATION_JSON).bodyValue(new EndUser("admin@gmail.com","123456")).exchange().expectStatus().isOk();
}
    
}
