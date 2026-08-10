# 🐾 PetStore API Automation

A REST API automation testing project for the **PetStore API**, developed using **Java, Rest Assured, TestNG, Maven, and Faker**.

The project automates and validates API operations such as creating, retrieving, updating, and deleting users/pets, along with response validation, status-code verification, and test execution using TestNG.

---

## 🚀 Tech Stack

| Technology       | Purpose                         |
| ---------------- | ------------------------------- |
| **Java**         | Programming language            |
| **Rest Assured** | REST API automation             |
| **TestNG**       | Test execution and assertions   |
| **Maven**        | Dependency and build management |
| **Faker**        | Test data generation            |
| **JSON**         | Request/response data handling  |
| **Eclipse IDE**  | Development environment         |
| **Git & GitHub** | Version control                 |

---

## 📌 Project Features

* Automated REST API testing
* GET, POST, PUT and DELETE request automation
* Request and response validation
* Status code validation
* Response body validation
* JSON request payload handling
* Dynamic test data generation using Faker
* TestNG annotations and test execution
* Maven-based project structure
* Reusable API endpoint configuration
* Test suite execution using `testng.xml`

---

## 🧪 API Operations Covered

The automation framework covers the following API operations:

### ➕ Create

Creates a new resource using a POST request.

```http
POST /users
```

### 🔍 Get

Retrieves resource information using a GET request.

```http
GET /users/{id}
```

### ✏️ Update

Updates an existing resource using a PUT request.

```http
PUT /users/{id}
```

### 🗑️ Delete

Deletes an existing resource using a DELETE request.

```http
DELETE /users/{id}
```

---

## 📂 Project Structure

```text
PetStoreAutomation
│
├── src
│   ├── test
│   │   └── java
│   │       ├── api
│   │       │   └── test
│   │       │       ├── UserTest.java
│   │       │       ├── UserEndpoints.java
│   │       │       ├── User.java
│   │       │       └── Routes.java
│   │       │
│   │       └── day8
│   │           ├── CreateUser.java
│   │           ├── GetUser.java
│   │           ├── UpdateUser.java
│   │           └── DeleteUser.java
│   │
│   └── resources
│
├── testng.xml
├── pom.xml
└── README.md
```

> The exact package names may vary depending on the final version of the project.

---

## ⚙️ Prerequisites

Before running the project, make sure you have:

* Java JDK installed
* Eclipse or another Java IDE
* Maven installed
* Git installed
* Internet connection for API execution

Check Java:

```bash
java -version
```

Check Maven:

```bash
mvn -version
```

---

## 🔧 Maven Dependencies

The project uses Maven for dependency management.

Important dependencies include:

* Rest Assured
* TestNG
* JSON
* Java Faker

Example:

```xml
<dependencies>

    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>6.0.1</version>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.11.0</version>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>com.github.javafaker</groupId>
        <artifactId>javafaker</artifactId>
        <version>1.0.2</version>
    </dependency>

</dependencies>
```

---

## ▶️ How to Run the Project

### 1. Clone the repository

```bash
git clone <YOUR-GITHUB-REPOSITORY-URL>
```

### 2. Open the project

Open the project in **Eclipse** as a Maven project.

### 3. Update Maven dependencies

Right-click the project:

```text
Maven
 → Update Project
```

### 4. Run the TestNG suite

The tests can be executed using:

```text
testng.xml
```

Alternatively, run the complete Maven test suite:

```bash
mvn test
```

---

## 📊 Test Execution

The project uses TestNG to organize and execute test cases.

Example TestNG suite:

```xml
<suite name="PetStore API Automation">

    <test name="User API Tests">

        <classes>
            <class name="api.test.UserTest"/>
        </classes>

    </test>

</suite>
```

Tests can also be executed individually from Eclipse using:

```text
Run As → TestNG Test
```

---

## 🔄 Automation Flow

```text
Generate Test Data
        ↓
Create Request Payload
        ↓
Send API Request
        ↓
Receive API Response
        ↓
Validate Status Code
        ↓
Validate Response Body
        ↓
Extract Required Data
        ↓
Use Data in Subsequent Requests
        ↓
Generate TestNG Result
```

---

## 🧾 Sample Rest Assured Test

```java
@Test
public void createUser() {

    Faker faker = new Faker();

    User user = new User();

    user.setUsername(faker.name().username());
    user.setFirstName(faker.name().firstName());
    user.setLastName(faker.name().lastName());
    user.setEmail(faker.internet().emailAddress());
    user.setPassword(faker.internet().password());

    given()
        .contentType("application/json")
        .body(user)

    .when()
        .post(Routes.post_url)

    .then()
        .statusCode(200)
        .log().all();
}
```

---

## ✅ Validations

The framework validates:

* HTTP status codes
* Response body
* JSON fields
* Response headers
* API response structure
* CRUD operation results

Example:

```java
.then()
    .statusCode(200)
    .body("username", equalTo(user.getUsername()));
```

---

## 🎲 Dynamic Test Data

The project uses **Java Faker** to generate dynamic data instead of using the same static values for every test.

Example:

```java
Faker faker = new Faker();

String username = faker.name().username();
String firstName = faker.name().firstName();
String email = faker.internet().emailAddress();
```

This helps make the tests more realistic and reusable.

---

## 🏗️ Framework Design

The project follows a basic reusable API automation structure:

```text
Test Classes
     ↓
Endpoint / Routes
     ↓
Request Payload / POJO
     ↓
Rest Assured
     ↓
API
     ↓
Response Validation
```

Separating endpoints, test data, request models, and test cases makes the framework easier to maintain.

---

## 📈 Future Enhancements

The framework can be further improved by adding:

* [ ] Request/response logging
* [ ] Extent Reports
* [ ] Allure Reports
* [ ] Data-driven testing
* [ ] Excel-based test data
* [ ] JSON Schema validation
* [ ] Environment configuration
* [ ] Configuration properties file
* [ ] CI/CD integration using GitHub Actions
* [ ] Parallel test execution
* [ ] API authentication handling
* [ ] Database validation
* [ ] Docker integration

---

## 🎯 Learning Objectives

This project was created to practice and demonstrate:

* REST API testing
* API automation using Rest Assured
* Java programming
* TestNG framework
* Maven project management
* JSON handling
* POJO-based request payloads
* Dynamic test data generation
* API CRUD operations
* Assertions and response validation
* Automation framework design

---

## 👨‍💻 Author

**Jessil Thomas**

BE – Computer Science & Engineering
Diploma – Computer Science Engineering

Interested in:

* Software Testing
* API Testing
* Automation Testing
* Java
* Rest Assured
* Selenium
* TestNG

---

## ⭐ Support

If you find this project useful for learning API automation testing, consider giving the repository a ⭐ on GitHub.
