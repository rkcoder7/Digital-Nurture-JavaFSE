# spring-learn — JWT Authentication for RESTful Web Service using Spring Security

Spring Boot Web (Maven) project implementing the full hands-on document:

1. **Securing RESTful Web Services with Spring Security** — `spring-boot-starter-security`,
   `SecurityConfig` (`@Configuration @EnableWebSecurity`)
2. **Creating users and roles in Spring Security** — in-memory `admin`/`user` (both password `pwd`),
   `/countries` restricted to role `USER`
3. **Create authentication service that returns JWT** — `AuthenticationController`
   (`GET /authenticate`), decoding the Basic-auth header and generating a JWT with `jjwt`
4. **Authorize based on JWT** — `JwtAuthorizationFilter`, a `BasicAuthenticationFilter` subclass
   that validates a `Bearer` JWT on every request

## What's included

- `Country.java`, `country.xml`, `CountryService` — from the earlier hands-on, plus a new
  **`GET /countries`** (`CountryController.getAllCountries()`) endpoint, since this document's
  security tests specifically target `/countries`. (This wasn't built in the last session since it
  wasn't requested then — it's added back here because this hands-on needs it.)
- `HelloController` — `GET /hello`
- `security/SecurityConfig.java` — in-memory users/roles, `BCryptPasswordEncoder`, HTTP Basic +
  the JWT filter wired in
- `security/JwtAuthorizationFilter.java` — validates `Authorization: Bearer <token>` on every
  request
- `controller/AuthenticationController.java` — `GET /authenticate`, returns `{"token": "..."}`

## Notes / assumptions

- Package name: the document literally writes `com.cognizant.spring-learn.security`, but hyphens
  aren't legal in Java package names, so — consistent with earlier hands-ons — this is
  `com.cognizant.springlearn.security`.
- **`server.port=8090`** is set in `application.properties` to match this document's curl examples
  exactly (`http://localhost:8090/...`).
- **JDK 11+ compatibility note:** `jjwt 0.9.0` (the version this document specifies) relies on
  `javax.xml.bind.DatatypeConverter`, which was removed from the JDK starting with Java 11. I added
  `javax.xml.bind:jaxb-api` and `org.glassfish.jaxb:jaxb-runtime` (not mentioned in the document) so
  the project actually runs on modern JDKs — if you're running Java 8 in Eclipse you won't need
  these, but they're harmless either way.
- `WebSecurityConfigurerAdapter` is deprecated in the Spring Security version bundled with Spring
  Boot 2.7.x (still used here since that's what the document's code is written against) — it still
  compiles and works, just with a deprecation warning in Eclipse.
- The `/countries` role-restriction line is commented out in the final `SecurityConfig`
  (`// .antMatchers("/countries").hasRole("USER")`), exactly as the document's final code listing
  shows — by the JWT stage, `.anyRequest().authenticated()` covers it instead. Uncomment it if you
  want to work through the role-based-only stage first (see "Testing in stages" below).

## Import into Eclipse

1. Extract this zip into (or under) your Eclipse workspace folder.
2. **File > Import > Maven > Existing Maven Projects**, browse to the extracted `spring-learn`
   folder, **Finish**.
3. Right-click the project > **Maven > Update Project** after any pom.xml change.

## Run

```bash
mvn spring-boot:run
```
or right-click `SpringLearnApplication.java` > **Run As > Java Application** in Eclipse.

## Testing in stages (as the document walks through)

**1. Basic auth, no roles yet (only if you comment out the role-based lines and remove the JWT
filter temporarily):**
```bash
curl -s http://localhost:8090/countries
# 401 Unauthorized — then check the console log for the auto-generated password
```

**2. With named users/roles + JWT filter active (the final state in this zip):**
```bash
# Get a token (Basic auth still required here)
curl -s -u user:pwd http://localhost:8090/authenticate
# {"token":"eyJhbGciOiJIUzI1NiJ9...."}

# Use the token as a Bearer token for any other request
curl -s -H "Authorization: Bearer PASTE_TOKEN_HERE" http://localhost:8090/countries

# Tamper with the token slightly and confirm you get Unauthorized
curl -s -H "Authorization: Bearer PASTE_TOKEN_HERE_BUT_CHANGED" http://localhost:8090/countries
```

**3. Wrong role calling /authenticate:**
```bash
curl -s -u admin:pwd http://localhost:8090/authenticate
# admin has role ADMIN and /authenticate allows both ADMIN and USER, so this should succeed too
```

Watch the console log throughout — every controller/service/filter method logs START/END (and
relevant debug values) so you can trace exactly what ran for each request.
