package com.example;

import java.util.Objects;

public class Task {
  private String taskId;
  private boolean done;

  public Task() {}

  public Task(String taskId, boolean done) {
    this.taskId = taskId;
    this.done = done;
  }

  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  @Override
  public boolean equals(Object obj) {
      if (!(obj instanceof Task)) {
          return false;
      }

      Task other = (Task) obj;

      return Objects.equals(other.taskId, this.taskId);
  }

  @Override
  public int hashCode() {
      return Objects.hash(this.taskId);
  }

  public void setId(String id) {
      this.taskId = id;
  }

  public String getId() {
      return taskId;
  }
}
