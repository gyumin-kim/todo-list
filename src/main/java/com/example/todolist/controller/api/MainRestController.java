package com.example.todolist.controller.api;

import com.example.todolist.domain.TodoItem;
import com.example.todolist.domain.TodoItemContent;
import com.example.todolist.dto.InputDto;
import com.example.todolist.dto.PatchingDto;
import com.example.todolist.service.MainService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

  /**
   * {@param inputDto}의 내용을 새로운 TodoItem으로 등록(생성)
   *
   * @param inputDto 새로 등록할 내용이 담긴 input 데이터
   * @return 새로 등록한 TodoItem을 감싼 ResponseEntity
   */
  @PostMapping(path = "/item",
      produces = "application/json")
  public ResponseEntity<?> createTodoItem(@RequestBody InputDto inputDto) {

    TodoItemContent todoItemContent = TodoItemContent.builder()
        .contents(inputDto.getContents())
        .build();
    TodoItem todoItem = TodoItem.builder()
        .title(inputDto.getTitle())
        .todoItemContent(todoItemContent)
        .isCompleted(false)
        .createdDate(LocalDateTime.now())
        .priority(inputDto.getPriority())
        .build();

    return new ResponseEntity<>(mainService.addTodoItem(todoItem), HttpStatus.CREATED);
  }

  /**
   * 우선순위가 {@param priority}인 TodoItem들을 가져온다
   *
   * @param priority 우선순위(없음/3/2/1)
   * @return 해당 우선순위를 갖는 TodoItem의 List
   */
  @GetMapping("/items/{priority}")
  public ResponseEntity<?> loadTodoItemsPriority(@PathVariable String priority) {
    List<TodoItem> items = mainService.getTodoItemsPriority(Integer.parseInt(priority));

    if (items != null) {
      return new ResponseEntity<>(items, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  /**
   * {@param id}에 해당하는 TodoItem을 수정
   *
   * @param id 데이터를 수정할 TodoItem의 id
   * @param patchingDto 수정할 내용이 담긴 DTO
   * @return 수정한 TodoItem
   */
  @PatchMapping(path = "/item/{id}", consumes = "application/json")
  public ResponseEntity<?> patchTodoItemPriority(@PathVariable Long id,
      @RequestBody PatchingDto patchingDto) {

    TodoItem todoItem = mainService.getTodoItemId(id);
    if (todoItem == null) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    if (patchingDto.getTitle() != null && patchingDto.getContents() != null) {
      mainService.modifyTitleContents(id, patchingDto.getTitle(), patchingDto.getContents());
    }
    if (patchingDto.getIsChecked() != null) {
      mainService.modifyIsChecked(id, patchingDto.getIsChecked());
    }
    if (patchingDto.getPriority() != null) {
      mainService.modifyPriority(id, patchingDto.getPriority());
    }

    return new ResponseEntity<>(todoItem, HttpStatus.OK);
  }

  /**
   * {@param id}에 해당하는 TodoItem을 삭제
   *
   * @param id 삭제할 TodoItem의 id
   */
  @DeleteMapping("/item/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTodoItem(@PathVariable Long id) {

    try {
      mainService.removeTodoItem(id);
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
    }
  }
}
