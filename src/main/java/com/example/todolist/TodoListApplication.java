package com.example.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableScheduling
public class TodoListApplication {

  public static void main(String[] args) {
    SpringApplication.run(TodoListApplication.class, args);
  }

  @Bean
  public WebClient webClient() {
    return WebClient.create();
  }
}
