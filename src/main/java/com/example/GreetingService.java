package com.example;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

  public String printHello(String name) {
    return "Hello " + name;
  }
}
