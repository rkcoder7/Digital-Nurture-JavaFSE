# spring-learn — Spring Core: Load Country from Spring Configuration XML

Self-contained Spring Web Maven project (Group: `com.cognizant`, Artifact: `spring-learn`)
demonstrating loading a bean from a Spring XML configuration file.

## What this project does

- `Country.java` — POJO with `code` and `name` fields, a no-arg constructor, getters/setters,
  and a `toString()` method. Every constructor/getter/setter logs a debug message.
- `country.xml` (in `src/main/resources`) — Spring XML configuration defining a `country` bean
  (`id="country"`, `class="com.cognizant.springlearn.Country"`) with `code=IN`, `name=India`.
- `SpringLearnApplication.java` — Spring Boot application entry point. Its `displayCountry()`
  method loads `country.xml` via `ClassPathXmlApplicationContext`, retrieves the `country` bean
  with `context.getBean("country", Country.class)`, and logs the result. `displayCountry()` is
  invoked from `main()`.
- `application.properties` — configures log levels and console log pattern so the debug logs
  from `Country` and `SpringLearnApplication` are visible.

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

## Expected console output

You should see `INFO`/`DEBUG` log lines showing:
- `Inside Country Constructor.` (once — the bean is a singleton by default)
- Debug logs from the `setCode()`/`setName()` setters as Spring populates the bean's properties
- `Country : Country [code=IN, name=India]`
