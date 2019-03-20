package com.example.todolist.dto;

/**
 * @author Gyumin Kim
 * @since 2019-03-20
 */
public class IsCheckedDto {

  private String isChecked;

  public String getIsChecked() {
    return isChecked;
  }

  public void setIsChecked(String isChecked) {
    this.isChecked = isChecked;
  }

  @Override
  public String toString() {
    return "IsCheckedDto{" +
        "isChecked='" + isChecked + '\'' +
        '}';
  }
}
