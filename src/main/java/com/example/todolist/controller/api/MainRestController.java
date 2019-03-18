package com.example.todolist.controller.api;

import com.example.todolist.domain.TodoItem;
import com.example.todolist.dto.InputDto;
import com.example.todolist.service.MainService;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gyumin Kim
 * @since 2019-03-17
 */
@RestController
@RequestMapping(path = "/api",
                produces = "application/json")
@CrossOrigin(origins = "*")
public class MainRestController {

  private MainService mainService;

  public MainRestController(MainService mainService) {
    this.mainService = mainService;
  }

  @PostMapping("/item")
  public ResponseEntity<?> createTodoItem(@RequestBody InputDto inputDto) {

    TodoItem todoItem = TodoItem.builder()
        .title(inputDto.getTitle())
        .isCompleted(false)
        .createdDate(LocalDateTime.now())
        .build();

    return new ResponseEntity<>(mainService.addTodoItem(todoItem), HttpStatus.CREATED);
  }
}
