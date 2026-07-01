# spring-learn — Display Employee List and Edit Employee form using RESTful Web Service

Spring Boot Web (Maven) project implementing the three activities from the hands-on document:

1. **Static employee list data via Spring XML configuration** — `employee.xml`
2. **REST service that returns all employees** — `/employees` (GET)
3. **REST service that returns all departments** — `/departments` (GET)

> **Note on assumptions:** this hands-on builds on an earlier Angular module and an
> earlier `EmployeeDao`/`EmployeeService`/`EmployeeController` that weren't included in the
> uploaded document, so their exact prior shape (Employee's fields, the original single
> department/employee, etc.) wasn't available. I implemented the **final state** the document
> describes, using a reasonable, self-consistent `Employee` shape (`id`, `name`, `gender`,
> `department`, `skills`) so the project is complete and runnable end to end. Swap in your
> actual prior `Employee` fields/data if they differ.

## Project contents

### Model classes
- `Skill.java` — `id`, `name`
- `Department.java` — `id`, `name`
- `Employee.java` — `id`, `name`, `gender`, `department` (a `Department`), `skills` (a `List<Skill>`)

### `src/main/resources/employee.xml`
- 5 reusable **skill** beans (Java, Spring, Angular, SQL, Python)
- 3 **department** beans (Engineering, Human Resources, Finance) + a `departmentList` bean
- 5 **employee** beans, each referencing a department and one or more skills via `<ref>`
  (skills are reused across employees, not re-created) + an `employeeList` bean

### Employee REST service
- `EmployeeDao` (`@Repository`) — static `EMPLOYEE_LIST`, populated in the constructor from
  `employee.xml`'s `employeeList` bean; `getAllEmployees()` returns it
- `EmployeeService` (`@Service`) — `getAllEmployees()` is `@Transactional`, delegates to the DAO
- `EmployeeController` (`@RestController`) — `GET /employees` delegates to the service

### Department REST service
- `DepartmentDao` (`@Repository`) — static `DEPARTMENT_LIST`, populated in the constructor from
  `employee.xml`'s `departmentList` bean; `getAllDepartments()` returns it
- `DepartmentService` (`@Service`) — `getAllDepartments()` delegates to the DAO
- `DepartmentController` (`@RestController`) — `GET /departments` delegates to the service and
  returns an array of departments

All DAO/service/controller methods log at INFO/DEBUG so you can confirm each service was called
by watching the console.

## Import into Eclipse

1. Extract this zip into (or under) your Eclipse workspace folder.
2. In Eclipse: **File > Import > Maven > Existing Maven Projects**.
3. Click **Browse**, select the extracted `spring-learn` folder, then **Finish**.

## Run

Right-click `SpringLearnApplication.java` > **Run As > Java Application** (or **Spring Boot App**),
or:

```bash
mvn spring-boot:run
```

The app starts on `http://localhost:8080` by default.

## Test with Postman (or a browser / curl)

```bash
curl http://localhost:8080/employees
curl http://localhost:8080/departments
```

- `GET /employees` returns a JSON array of 5 employees, each with a nested `department` object
  and a `skills` array.
- `GET /departments` returns a JSON array of 3 departments.
- Watch the console log while calling `/departments` — you should see the
  `DepartmentController`/`DepartmentService`/`DepartmentDao` START/END log lines confirming the
  service was invoked.
