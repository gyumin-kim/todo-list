package com.example.todolist.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Gyumin Kim
 * @since 2019-03-17
 */
@Entity
@Table(name = "TODO_ITEM_CONTENT")
@Getter
@Setter
public class TodoItemContent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TODO_ITEM_CONTENT_ID")
  private Long id;

  // 내용
  @Column(length = 1024)
  private String contents;
}