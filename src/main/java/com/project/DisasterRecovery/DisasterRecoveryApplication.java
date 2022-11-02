package com.project.DisasterRecovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DisasterRecoveryApplication extends SpringBootServletInitializer {
  public static void main(String[] args) {
      SpringApplication.run(DisasterRecoveryApplication.class, args);
  }

  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
      return builder.sources(DisasterRecoveryApplication.class);
  }
}