package com.example.todolist.service;

import com.example.todolist.domain.TodoItem;
import com.example.todolist.repository.TodoItemRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gyumin Kim
 * @since 2019-03-17
 */
@Service
@Slf4j
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
  public List<TodoItem> getTodoItemsPriority(int priority) {
    return todoItemRepository.findAllByPriority(priority);
  }

  @Transactional(readOnly = true)
  public TodoItem getTodoItemId(Long id) {
    return todoItemRepository.getOne(id);
  }

  @Transactional
  public TodoItem modifyTitleContents(Long id, String title, String contents) {
    TodoItem todoItem = todoItemRepository.getOne(id);
    todoItem.setTitle(title);
    todoItem.getTodoItemContent().setContents(contents);

    return todoItemRepository.save(todoItem);
  }

  @Transactional
  public TodoItem modifyIsChecked(Long id, String isCompleted) {
    TodoItem todoItem = todoItemRepository.getOne(id);
    boolean isCompletedBool = isCompleted.equals("true");
    todoItem.setCompleted(isCompletedBool);

    return todoItemRepository.save(todoItem);
  }

  @Transactional
  public TodoItem modifyPriority(Long id, int newPriority) {
    TodoItem todoItem = todoItemRepository.getOne(id);
    todoItem.setPriority(newPriority);

    return todoItemRepository.save(todoItem);
  }

  @Transactional
  public void removeTodoItem(Long id) {
    todoItemRepository.deleteById(id);
  }
}