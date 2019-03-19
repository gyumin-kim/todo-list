package com.example.todolist.dto;

/**
 * @author Gyumin Kim
 * @since 2019-03-19
 */
public class UpdateDto {

  private String title;
  private String contents;

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
}
