package com.example.todolist.fcm;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.TopicManagementResponse;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Gyumin Kim
 * @since 2019-03-20
 */
@Service
@Slf4j
public class FcmClient {

  public FcmClient(FcmSettings settings) {
    Path p = Paths.get(settings.getServiceAccountFile());
    try (InputStream serviceAccount = Files.newInputStream(p)) {
      FirebaseOptions options = new FirebaseOptions.Builder()
          .setCredentials(GoogleCredentials.fromStream(serviceAccount))
          .setDatabaseUrl("https://todo-list-99375.firebaseio.com")
          .build();

      FirebaseApp.initializeApp(options);
    } catch (IOException e) {
      log.error("init fcm", e);
    }
  }

  public void subscribe(String topic, String clientToken) {
    try {
      TopicManagementResponse response = FirebaseMessaging.getInstance()
          .subscribeToTopicAsync(Collections.singletonList(clientToken), topic).get();
      log.info(response.getSuccessCount() + " tokens were subscribed successfully");
    } catch (InterruptedException | ExecutionException e) {
      log.error("subscribe", e);
    }
  }

  public void send(Map<String, String> data) throws InterruptedException, ExecutionException {

    // TTL: Time To Live
    Message message = Message.builder().putAllData(data).setTopic("chuck")
        .setWebpushConfig(WebpushConfig.builder().putHeader("ttl", "300")
            .setNotification(new WebpushNotification("TODO list",
                "마감기한이 지난 할 일이 있습니다!", "mail2.png"))
            .build())
        .build();

    String response = FirebaseMessaging.getInstance().sendAsync(message).get();
    log.info("Sent message: " + response);
  }
}
