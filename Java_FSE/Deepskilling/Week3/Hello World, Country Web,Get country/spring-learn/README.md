# spring-learn — Hello World, Country Web Service, Get Country by Code

Spring Boot Web (Maven) project implementing the three sections you asked for from the
hands-on document:

1. **Hello World RESTful Web Service**
2. **REST - Country Web Service**
3. **REST - Get country based on country code**

(The document's "Get all countries" / "/countries" endpoint, the "exceptional scenario" /
`CountryNotFoundException`, and the MockMVC test sections were **not** requested this time, so
they're intentionally left out. Ask if you'd like those added too — they build directly on this
project.)

## Endpoints

| Method | URL                    | Controller method                          | Behaviour |
|--------|------------------------|---------------------------------------------|-----------|
| GET    | `/hello`                | `HelloController.sayHello()`                | Returns the literal string `Hello World!!` |
| GET    | `/country`               | `CountryController.getCountryIndia()`       | Loads the `country` (India) bean from `country.xml` and returns it as JSON |
| GET    | `/countries/{code}`      | `CountryController.getCountry(String code)` | Delegates to `CountryService.getCountry(code)`, which loads the `countryList` bean from `country.xml` and does a case-insensitive match (via a lambda / `Stream.filter`) |

## Notes / assumptions

- The document names classes as `com.cognizant.spring-learn.controller.HelloController` etc. —
  hyphens aren't legal in Java package names, so (as with the earlier hands-on) these were
  written as `com.cognizant.springlearn.controller...` and `com.cognizant.springlearn.service...`.
- The **Method Annotation** given for country-by-code is explicitly `@GetMapping("/countries/{code}")`,
  so that's what's implemented, even though the doc's own sample request URL says
  `/country/in` (singular) — that looks like a typo in the source document.
- `server.port=8083` is set in `application.properties` to match the doc's sample request URLs
  (`http://localhost:8083/...`). Comment it out if you'd rather use the default 8080.
- `country.xml` keeps the original `country` bean (`IN` / `India`) used by `/country`, and adds
  three more countries (`US`, `JP`, `DE`) plus a `countryList` bean, since `/countries/{code}`
  needs a list to search through.
- If not found, `getCountry()` currently returns `null` (empty JSON body) — proper 404 handling
  via `CountryNotFoundException` is the next section in the doc and wasn't requested here.

## Import into Eclipse

1. Extract this zip into (or under) your Eclipse workspace folder.
2. **File > Import > Maven > Existing Maven Projects**, browse to the extracted `spring-learn`
   folder, **Finish**.

## Run

Right-click `SpringLearnApplication.java` > **Run As > Java Application** (or **Spring Boot App**),
or:

```bash
mvn spring-boot:run
```

## Test with Postman / browser / curl

```bash
curl http://localhost:8083/hello
curl http://localhost:8083/country
curl http://localhost:8083/countries/in
curl http://localhost:8083/countries/US
```

- `/hello` → `Hello World!!`
- `/country` → `{"code":"IN","name":"India"}`
- `/countries/in` and `/countries/US` → case-insensitive match, e.g. `{"code":"IN","name":"India"}`
  or `{"code":"US","name":"United States"}`

Open Chrome DevTools (F12) → Network tab, or Postman's **Headers** tab, to inspect the HTTP
response headers as the document's SME notes suggest.
