package com.example.todolist.dto;

import java.time.LocalDateTime;

/**
 * @author Gyumin Kim
 * @since 2019-03-17
 */
public class InputDto {

  private String title;
  private String contents;
  private Integer priority;
  private LocalDateTime deadline;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public LocalDateTime getDeadline() {
    return deadline;
  }

  public void setDeadline(LocalDateTime deadline) {
    this.deadline = deadline;
  }
}
