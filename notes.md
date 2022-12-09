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