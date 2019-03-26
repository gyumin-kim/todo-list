package com.example.todolist.service;

import com.example.todolist.domain.TodoItem;
import com.example.todolist.dto.PatchingDto;
import com.example.todolist.repository.TodoItemRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gyumin Kim
 * @since 2019-03-17
 */
@Service
public class TodoItemService {

  private TodoItemRepository todoItemRepository;

  public TodoItemService(TodoItemRepository todoItemRepository) {
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
  public TodoItem modifyTodoItem(Long id, PatchingDto patchingDto) {
    TodoItem todoItem = todoItemRepository.getOne(id);

    if (patchingDto.getTitle() != null && patchingDto.getContents() != null) {
      todoItem.setTitle(patchingDto.getTitle());
      todoItem.getTodoItemContent().setContents(patchingDto.getContents());
    }
    if (patchingDto.getIsChecked() != null) {
      boolean isCompletedBool = patchingDto.getIsChecked().equals("true");
      todoItem.setCompleted(isCompletedBool);
    }
    if (patchingDto.getPriority() != null) {
      todoItem.setPriority(patchingDto.getPriority());
    }

    return todoItemRepository.save(todoItem);
  }

  @Transactional
  public void removeTodoItem(Long id) {
    todoItemRepository.deleteById(id);
  }
}