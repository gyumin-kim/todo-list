package com.example.todolist.controller.api;

import com.example.todolist.domain.TodoItem;
import com.example.todolist.dto.InputDto;
import com.example.todolist.service.MainService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gyumin Kim
 * @since 2019-03-17
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Slf4j
public class MainRestController {

  private MainService mainService;

  public MainRestController(MainService mainService) {
    this.mainService = mainService;
  }

  @PostMapping(path = "/item",
              produces = "application/json")
  public ResponseEntity<?> createTodoItem(@RequestBody InputDto inputDto) {

    TodoItem todoItem = TodoItem.builder()
        .title(inputDto.getTitle())
        .isCompleted(false)
        .createdDate(LocalDateTime.now())
        .build();

    return new ResponseEntity<>(mainService.addTodoItem(todoItem), HttpStatus.CREATED);
  }

  @GetMapping("/items")
  public List<TodoItem> loadAllTodoItems() {
    log.info("SERVICE -- loadAllTodoItems() ...");
    List<TodoItem> items = mainService.getTodoItems();
    for (TodoItem item : items) {
      log.info(item.getId() + ": " + item.getTitle());
    }
    return items;
  }
}
