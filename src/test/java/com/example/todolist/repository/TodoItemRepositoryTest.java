package com.example.todolist.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.todolist.domain.TodoItem;
import com.example.todolist.domain.TodoItemContent;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TodoItemRepositoryTest {

  @Autowired
  private TodoItemRepository todoItemRepository;

  @Test
  public void test_TodoItem생성_Id로_찾기_동일여부() {
    TodoItem todoItem = new TodoItem();
    todoItem.setId(1L);
    todoItem.setTitle("제목 테스트");
    todoItem.setCompleted(false);
    todoItem.setCreatedDate(LocalDateTime.now());
    TodoItemContent content = new TodoItemContent();
    content.setContents("내용 테스트");
    todoItem.setTodoItemContent(content);
    todoItem.setPriority(1);
    todoItemRepository.save(todoItem);

    assertThat(todoItemRepository.getOne(1L).getId())
        .isEqualTo(todoItem.getId());
  }

  @Test
  public void test_TodoItem생성_title로_찾기_동일여부() {
    TodoItem todoItem = new TodoItem();
    todoItem.setId(1L);
    todoItem.setTitle("제목 테스트");
    todoItem.setCompleted(false);
    todoItem.setCreatedDate(LocalDateTime.now());
    TodoItemContent content = new TodoItemContent();
    content.setContents("내용 테스트");
    todoItem.setTodoItemContent(content);
    todoItem.setPriority(1);
    todoItemRepository.save(todoItem);

    assertThat(todoItemRepository.findByTitle("제목 테스트").getId())
        .isEqualTo(todoItem.getId());
  }
}