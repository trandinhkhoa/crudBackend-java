package com.example;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class TodoResource {
  @Inject TodoService todoService;

  @POST
  @Path("/tasks")
  public List<Task> createTask(Task task){
    todoService.createTask(task);
    return readAllTask();
  }

  @GET
  @Path("/tasks")
  public List<Task> readAllTask(){
    return todoService.readAllTask();
  }

  @PUT
  @Path("/tasks/{taskId}")
  public List<Task> updateTask(@PathParam("taskId") String taskName,  Task task) {
    todoService.updateTask(taskName, task);
    return readAllTask();
  }

  @DELETE
  @Path("/tasks/{taskId}")
  public List<Task> deleteTask(String taskId){
    todoService.deleteTask(taskId);
    return readAllTask();
  }

  @DELETE
  @Path("/tasks")
  public List<Task> deleteAllTask(){
    todoService.deleteAllTask();
    return readAllTask();
  }
}