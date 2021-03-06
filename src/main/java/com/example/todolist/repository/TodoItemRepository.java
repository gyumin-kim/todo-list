package com.example.todolist.repository;

import com.example.todolist.domain.TodoItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

  TodoItem findByTitle(String title);

  List<TodoItem> findAllByPriority(int priority);
}
