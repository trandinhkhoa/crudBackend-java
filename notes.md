**Compile**
```
javac StaticServer.java
```

**Run**
```
java StaticServer
```

default place for compilation
/src/main/java
https://maven.apache.org/guides/mini/guide-using-one-source-directory.html
https://stackoverflow.com/questions/19140873/change-source-directory-in-profile-maven


It's mostly a set and subset relationship these days.

A web server serves webpages. In the long long ago, that'd be static data. But now, browsers and html are such a handy interface that webpages do a lot more.

An application server is just something that does some sort of high level task that someone needs done. A whole hell of a lot of that these days has an interface through a web page, so an application server is web server that also does some sort of math or whatnot in the backend.

But an application server doesn't necessarily serve pages. It could do other tasks through other channels. Liiiiike, uuuuuh.... the gimmePi.com webserver which handles traffic could sit next to the Pi crunching application server that sits all day spewing decimals of Pi. They talk over TCP or something, which isn't a webpage, so the Pi-cruncher isn't a webserver.

https://www.reddit.com/r/webdev/comments/oden6/im_trying_to_understand_how_web_servers_work_and/


- `@Produces`: only affect header `Content-Type`
- JBoss LogManager and supported logging frameworks
  - APIs for logging: .e.g
    - JDK JUL java.util.logging
    - JBoss Logging
    - SLF4J
    - Apache Commons Logging
    - Log4j 1.x
    - Log4j 2
  - Implementation (logging backend): .e.g org.jboss.logmanager.LogManager
- Quarkus Test
  - By default, tests will run on port 8081 so as not to conflict with the running application. We automatically configure **RestAssured** to use this port. If you want to use a different client you should use the `@TestHTTPResource` annotation to directly inject the URL of the tested application into a field on the test class. This field can be of the type String, URL or URI. This annotation can also be given a value for the test path. For example, if I want to test a Servlet mapped to `/myservlet` I would just add the following to my test:
  ```
    @TestHTTPResource("/myservlet")
    URL testUrl;
  ```
  The test port can be controlled via the `quarkus.http.test-port` config property. Quarkus also creates a system property called `test.url` that is set to the base test URL for situations where you cannot use injection.
- modules (maven):
  - specified in `pom.xml`
  - multi modules .e.g
    - https://stackoverflow.com/questions/66972941/what-are-the-best-practices-for-creating-a-quarkus-multi-module-project
    - https://stackoverflow.com/questions/66972941/what-are-the-best-practices-for-creating-a-quarkus-multi-module-project
- Packaging and run a Quarkus application
  ```
    mvn install
    java -jar target/quarkus-app/quarkus-run.jar
  ```


  https://stackoverflow.com/questions/43284028/in-maven-what-is-the-difference-between-an-extension-and-a-plugin

https://www.baeldung.com/quarkus-extension-java
  Quarkus is a framework composed of a core and a set of extensions. The core is based on Context and Dependency Injection (CDI) and extensions are usually meant to integrate a third-party framework by exposing their primary components as CDI beans.

In this tutorial, we'll focus on how to write a Quarkus extension assuming a basic understanding of Quarkus.

2. What's a Quakus Extension
A Quarkus extension is simply a module that can run on top of a Quarkus application. The Quarkus application itself is a core module with a set of other extensions.


- When using MongoDB (the issue does not have anything to do with mongodb, just mentioning it to remember when I did this): resteasy-reactive is not enough. Need jackson for json deserialization/se.
  - also, dont need to add extension, just add the dependency in pom.xml (which is what the quarkus extension does anyway)