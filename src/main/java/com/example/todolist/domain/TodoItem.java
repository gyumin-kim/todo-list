package com.example.todolist.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Gyumin Kim
 * @since 2019-03-17
 */
@Entity
@Table(name = "TODO_ITEM")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
  //TODO: @OneToOne 대신 @Embeddable로 바꾸는 것 고려
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "TODO_ITEM_CONTENT_ID")
  private TodoItemContent todoItemContent;
}