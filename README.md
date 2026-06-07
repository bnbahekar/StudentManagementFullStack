# Student API – Subjects Module (Spring Boot + MySQL)

---

## *  Overview

This project is a **Spring Boot backend API** for managing the **Subjects table** from the `students_db` database.

It follows a **SOLID layered architecture**:

```id="flow1"
Controller* Service* Repository* Database
```

Additionally:

```id="flow2"
DTO* Service* Entity* Database
```

This design ensures:

* Clean separation of concerns
* High scalability
* Enterprise-ready structure

---

## *  Project Structure

```id="structure1"
student-api-springboot/
¦
+-- src/main/java/com/example/studentapi/
¦
¦   +-- StudentApiApplication.java      # *  ENTRY POINT
¦
¦   +-- controller/                    # REST APIs
¦   +-- service/                       # Business logic (interface)
¦   +-- service/impl/                  # Implementation
¦   +-- repository/                    # DB layer (JPA)
¦   +-- model/                         # Entity classes
¦   +-- dto/                           # API data transfer
¦   +-- validator/                     # Input validation (future use)
¦   +-- exception/                     # Global exception handling
¦   +-- util/                          # Common utilities
¦   +-- config/                        # Configurations
¦
+-- src/main/resources/
¦   +-- application.properties
¦
+-- pom.xml
+-- README.md
```

---

## *  ENTRY POINT

### `StudentApiApplication.java`

This is where the application starts.

### What happens:

1. Spring Boot initializes
2. Embedded Tomcat starts
3. Beans are loaded
4. Server runs on configured port

---

## *  Setup Instructions

---

###* 1. Prerequisites

Make sure you have:

* Java 17+ installed
* Maven installed
* MySQL running

---

###* 2. Database Setup

Use the same schema as defined earlier

```sql id="dbsetup"
CREATE DATABASE students_db;

CREATE USER 'app_user'@'%' IDENTIFIED BY 'AppPassword123';
GRANT SELECT, INSERT, UPDATE, DELETE ON students_db.* TO 'app_user'@'%';
FLUSH PRIVILEGES;
```

---

###* 3. Configure Application

Edit:

```id="appprops"
src/main/resources/application.properties
```

```properties id="propscontent"
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/students_db
spring.datasource.username=app_user
spring.datasource.password=AppPassword123

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
```

---

###* 4. Install Dependencies

```bash id="maveninstall"
mvn clean install
```

---

###* 5. Run Application

#### Option 1: Using Maven

```bash id="mavenrun"
mvn spring-boot:run
```

---

#### Option 2: Run JAR

```bash id="jarrun"
java -jar target/student-api-springboot-0.0.1-SNAPSHOT.jar
```

---

#### Option 3: Run from IDE

* Open project in IntelliJ / Eclipse
* Run `StudentApiApplication.java`

---

###* Server URL

```id="serverurl"
http://localhost:8080
```

---

## *  File-by-File Explanation

---

### *  `StudentApiApplication.java`

**Purpose:**

* Entry point
* Bootstraps Spring Boot

---

### *  `controller/SubjectController.java`

**Purpose:**

* Handles HTTP requests
* Defines REST endpoints

Example:

```id="controllerexample"
POST /subjects
GET /subjects
```

---

### *  `service/SubjectService.java`

**Purpose:**

* Defines business logic interface

---

### *  `service/impl/SubjectServiceImpl.java`

**Purpose:**

* Implements business logic
* Converts DTO* Entity

---

### *  `repository/SubjectRepository.java`

**Purpose:**

* Handles DB operations via JPA

---

### *  `model/Subject.java`

**Purpose:**

* Maps Java class to DB table

---

### *  `dto/SubjectDTO.java`

**Purpose:**

* Controls API request/response structure

---

### *  `exception/GlobalExceptionHandler.java`

**Purpose:**

* Handles all application errors

---

### *  `exception/ResourceNotFoundException.java`

**Purpose:**

* Custom exception for missing data

---

### *  `util/ApiResponse.java`

**Purpose:**

* Standard API response format

---

### *  `application.properties`

**Purpose:**

* Configuration file for:

  * DB
  * Port
  * JPA

---

## *  Request Flow (CORE LEARNING)

Example:

```id="flowexample"
POST /subjects
```

### Flow:

1. Controller receives request
2. DTO created
3. Service processes logic
4. Repository interacts with DB
5. Entity returned
6. Converted to DTO
7. Response sent

---

## *  API Testing (Same as Flask/Node)

### Create Subject

```id="test1"
curl -X POST http://localhost:8080/subjects \
-H "Content-Type: application/json" \
-d '{"subjectName": "Math", "subjectCode": "MTH101"}'
```

---

### Get All

```id="test2"
curl http://localhost:8080/subjects
```

---

### Get One

```id="test3"
curl http://localhost:8080/subjects/1
```

---

### Update

```id="test4"
curl -X PUT http://localhost:8080/subjects/1 \
-H "Content-Type: application/json" \
-d '{"subjectName": "Physics", "subjectCode": "PHY101"}'
```

---

### Delete

```id="test5"
curl -X DELETE http://localhost:8080/subjects/1
```