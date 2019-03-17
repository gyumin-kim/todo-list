package com.example.todolist.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Gyumin Kim
 * @since 2019-03-17
 */
@Entity
@Table(name = "TODO_ITEM")
@Getter
@Setter
public class TodoItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 제목
  @Column(nullable = false)
  private String title;

  // 완료 여부
  @Column(nullable = false)
  private boolean isCompleted;

  // 생성일
  @Column(nullable = false)
  private LocalDateTime createdDate;

  // 마감기한
  private LocalDateTime deadLine;

  // 우선순위
  private Integer priority;

  // 내용
  @OneToOne
  @JoinColumn(name = "todo_item_content_id")
  private TodoItemContent todoItemContent;
}