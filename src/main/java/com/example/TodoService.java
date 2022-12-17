package com.example;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bson.Document;

@ApplicationScoped
public class TodoService {
  @Inject MongoClient mongoClient;

  public void createTask(Task task){
    Document document = new Document()
            .append("taskId", task.getTaskId())
            .append("done", task.isDone());
    getCollection().insertOne(document);
  }

  public List<Task> readAllTask(){
    List<Task> list = new ArrayList<>();
    MongoCursor<Document> cursor = getCollection().find().iterator();

    try {
      while (cursor.hasNext()) {
        Document document = cursor.next();
        Task task = new Task();
        task.setTaskId(document.getString("taskId"));
        task.setDone(document.getBoolean("done"));
        list.add(task);
      }
    } finally {
      cursor.close();
    }
    return list;
  }

  public void updateTask(String taskId, Task task) {
    Document updateDocument = new Document("taskId", taskId);
    Document setDocument = new Document("$set",
      new Document("done", task.isDone()));
    getCollection().updateOne(updateDocument, setDocument);
  }

  public void deleteTask(String taskId){
    Document document = new Document("taskId", taskId);
    getCollection().deleteOne(document);
  }

  public void deleteAllTask(){
    getCollection().deleteMany(new Document());
  }

  private MongoCollection getCollection(){
    return mongoClient.getDatabase("todoApp").getCollection("todos");
  }

}