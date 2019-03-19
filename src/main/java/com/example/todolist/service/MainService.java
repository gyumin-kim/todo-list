package com.example.todolist.service;

import com.example.todolist.domain.TodoItem;
import com.example.todolist.dto.UpdateDto;
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
  public List<TodoItem> getTodoItemsPriority(int priority) {
    return todoItemRepository.findAllByPriority(priority);
  }

  @Transactional(readOnly = true)
  public TodoItem getTodoItemId(Long id) {
    return todoItemRepository.getOne(id);
  }

  @Transactional
  public TodoItem modifyTodoItem(Long id, UpdateDto updateDto) {
    TodoItem todoItem = todoItemRepository.getOne(id);
    String updateTitle = updateDto.getTitle();
    String updateContents = updateDto.getContents();
    todoItem.setTitle(updateTitle);
    todoItem.getTodoItemContent().setContents(updateContents);

    return todoItemRepository.save(todoItem); //TODO: 최종적으로 update된 TodoItem 객체를 매개변수로 넣어주면 된다.
  }

  @Transactional
  public void removeTodoItem(Long id) {
    todoItemRepository.deleteById(id);
  }
}