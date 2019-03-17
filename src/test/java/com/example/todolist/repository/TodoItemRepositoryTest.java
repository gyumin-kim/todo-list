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
    TodoItemContent content = new TodoItemContent();
    content.setContents("내용 테스트");

    TodoItem todoItem = TodoItem.builder()
        .id(1L)
        .title("제목 테스트")
        .isCompleted(false)
        .createdDate(LocalDateTime.now())
        .todoItemContent(content)
        .priority(1)
        .build();

    todoItemRepository.save(todoItem);

    assertThat(todoItemRepository.getOne(1L).getId())
        .isEqualTo(todoItem.getId());
  }

  @Test
  public void test_TodoItem생성_title로_찾기_동일여부() {
    TodoItemContent content = new TodoItemContent();
    content.setContents("내용 테스트");

    TodoItem todoItem = TodoItem.builder()
        .id(1L)
        .title("제목 테스트")
        .isCompleted(false)
        .createdDate(LocalDateTime.now())
        .todoItemContent(content)
        .priority(1)
        .build();

    todoItemRepository.save(todoItem);

    assertThat(todoItemRepository.findByTitle("제목 테스트").getId())
        .isEqualTo(todoItem.getId());
  }
}