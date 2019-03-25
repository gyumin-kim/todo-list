package com.example.todolist.fcm;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Gyumin Kim
 * @since 2019-03-20
 */
@Service
@Slf4j
public class PushService {

//  private final FcmClient fcmClient;
//  private final WebClient webClient;
//
//  private int seq = 0;
//
//  public PushService(FcmClient fcmClient, WebClient webClient) {
//    this.fcmClient = fcmClient;
//    this.webClient = webClient;
//  }
//
//  // 30초마다 API로부터 joke 데이터를 받아온다
//  @Scheduled(fixedDelay = 30_000)
//  public void sendChuckQuotes() {
//    IcndbJoke joke = this.webClient.get().uri("http://api.icndb.com/jokes/random")
//        .retrieve().bodyToMono(IcndbJoke.class).block();
//    try {
//      sendPushMessage(joke);
//    } catch (InterruptedException | ExecutionException e) {
//      log.error("send todo notification", e);
//    }
//  }
//
//  // API 데이터를 fcmClient에 전송 요청한다
//  public void sendPushMessage(IcndbJoke joke) throws InterruptedException, ExecutionException {
//    Map<String, String> data = new HashMap<>();
//
//    // Push 알림으로 보낼 데이터의 속성들을 지정
//    data.put("id", String.valueOf(joke.getValue().getId()));
//    data.put("joke", joke.getValue().getJoke());
//    data.put("seq", String.valueOf(this.seq++));
//    data.put("ts", String.valueOf(System.currentTimeMillis()));
//
//    log.info("Sending todo notification...");
//    this.fcmClient.send(data);
//  }
}
