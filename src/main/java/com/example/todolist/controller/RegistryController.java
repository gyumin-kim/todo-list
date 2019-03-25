package com.example.todolist.controller;

import com.example.todolist.fcm.FcmClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gyumin Kim
 * @since 2019-03-21
 */
@RestController
@CrossOrigin
@Slf4j
public class RegistryController {

//  private final FcmClient fcmClient;
//
//  public RegistryController(FcmClient fcmClient) {
//    this.fcmClient = fcmClient;
//  }
//
//  @PostMapping(path = "/register")
//  @ResponseStatus(HttpStatus.NO_CONTENT)
//  public void register(@RequestBody String token) {
//
//    log.info("token: " + token);
////    return token.doOnNext(t -> this.fcmClient.subscribe("chuck", t.getToken())).then();
//    this.fcmClient.subscribe("chuck", token);
//  }
}
