# spring-learn — Hands on 1: Create a Spring Web Project using Maven

Basic Spring Boot web project generated the same way https://start.spring.io/ would
(Group: `com.cognizant`, Artifact: `spring-learn`, Dependencies: **Spring Web**, **Spring Boot DevTools**).

## Import into Eclipse

1. Extract this zip into (or under) your Eclipse workspace folder.
2. In Eclipse: **File > Import > Maven > Existing Maven Projects**.
3. Click **Browse**, select the extracted `spring-learn` folder, then **Finish**.
4. Eclipse will resolve the Maven dependencies (configure a proxy under
   **Window > Preferences > Maven** if your network requires one).

## Build from the command line

```bash
mvn clean package
```

## Run

Right-click `SpringLearnApplication.java` in Eclipse > **Run As > Java Application**
(or **Spring Boot App**), or from the command line:

```bash
mvn spring-boot:run
```

## What to look at

- `src/main/java/com/cognizant/springlearn/SpringLearnApplication.java` — the `main()` method,
  annotated with `@SpringBootApplication`, calls `SpringApplication.run()`. Start/end log
  messages confirm `main()` executed.
- `pom.xml` — Spring Boot starter parent, `spring-boot-starter-web`, `spring-boot-devtools`.
  Open **Dependency Hierarchy** in Eclipse's POM editor to see the full dependency tree.
- `src/main/resources/application.properties` — application configuration (logging setup).
- `src/test/java` — default Spring Boot test (`contextLoads()`).
