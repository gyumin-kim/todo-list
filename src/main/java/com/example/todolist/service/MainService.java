package com.example.todolist.service;

import com.example.todolist.domain.TodoItem;
import com.example.todolist.repository.TodoItemRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gyumin Kim
 * @since 2019-03-17
 */
@Service
public class MainService {

  private TodoItemRepository todoItemRepository;

  public MainService(TodoItemRepository todoItemRepository) {
    this.todoItemRepository = todoItemRepository;
  }

  @Transactional
  public TodoItem addTodoItem(TodoItem todoItem) {
    return todoItemRepository.save(todoItem);
  }

  @Transactional(readOnly = true)
  public List<TodoItem> getTodoItems() {
    return todoItemRepository.findAll();
  }
}
