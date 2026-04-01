# JADEx Spring Boot Example

This example introduces the core features of JADEx (Java Advanced Development Extension) through a Spring Boot User CRUD project.

---

## Table of Contents

1. [Overview](#overview)
2. [Project Structure](#project-structure)
3. [Getting Started](#getting-started)
4. [Configuration](#configuration)
5. [Feature Guide](#feature-guide)
   - [Nullable Types](#1-nullable-types-type)
   - [Null-safe Access Operator](#2-null-safe-access-operator-)
   - [Elvis Operator](#3-elvis-operator-)
   - [readonly Modifier](#4-readonly-modifier)
   - [Lombok Integration](#5-lombok-integration)
   - [Optional Replacement Pattern](#6-optional-replacement-pattern)
6. [API Testing](#api-testing)

---

## Overview

This example demonstrates how JADEx's 6 core features work in a real Spring Boot project.

| Feature | Description |
|---|---|
| `Type?` | Nullable type declaration |
| `?.` | Null-safe access operator |
| `?:` | Elvis operator (null default value) |
| `apply readonly` | Final-by-default mode |
| Lombok Integration | Nullability analysis covers both hand-written and Lombok-generated code |

---

## Project Structure

```
example-spring-boot/
├── build.gradle
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── springboot/example/
│   │   │       └── ExampleApplication.java     ← Spring Boot main
│   │   ├── jadex/
│   │   │   └── springboot/example/
│   │   │       ├── entity/
│   │   │       │   ├── User.jadex
│   │   │       │   └── Address.jadex
│   │   │       ├── dto/
│   │   │       │   ├── UserRequest.jadex        ← readonly DTO
│   │   │       │   └── UserResponse.jadex       ← readonly DTO
│   │   │       ├── repository/
│   │   │       │   └── UserRepository.jadex
│   │   │       ├── service/
│   │   │       │   └── UserService.jadex
│   │   │       └── controller/
│   │   │           └── UserController.jadex
│   │   └── resources/
│   │       └── application.properties
│   └── requests.http                            ← HTTP test requests
```

> **`src/main/java/`** — Source Files that do not require JADEx syntax (e.g. main class)
> **`src/main/jadex/`** — Source files that use JADEx syntax

---

## Getting Started

### Prerequisites

| Requirement | Version |
|---|---|
| JDK | 21 or higher |
| IntelliJ IDEA | 2023.1 or higher |
| JADEx IntelliJ Plugin | 0.628 or higher |
| JADEx Gradle Plugin | 0.628 or higher |
---

### Step 1 — Install the JADEx IntelliJ Plugin

The JADEx IntelliJ plugin provides `.jadex` file syntax highlighting, code completion, and real-time nullability inspection inside IntelliJ IDEA.

1. Open IntelliJ IDEA
2. Go to **Settings** → **Plugins** → **Marketplace**
3. Search for **JADEx**
4. Click **Install** and restart IntelliJ IDEA

---

### Step 2 — Open the Project

1. Open IntelliJ IDEA
2. Select **File** → **New** → **Project from Version Control**
3. Enter the project URL: `https://github.com/nieuwmijnleven/jadex-springboot-example.git`
4. Click **Clone** and wait for Gradle sync to complete

> IntelliJ will automatically detect the JADEx Gradle plugin and configure the `src/main/jadex/` source set.

---

### Step 3 — Build the Project

**Via IntelliJ Gradle tool window**

1. Open the **Gradle** tool window on the right side of IntelliJ IDEA (**View** → **Tool Windows** → **Gradle**)
2. Expand **jadex-springboot-example** → **Tasks** → **build**
3. Double-click **build** to run

The JADEx Gradle plugin will automatically:
- Compile `.jadex` source files under `src/main/jadex/`
- Run the Delombok pipeline for Lombok integration
- Generate standard `.java` files and hand them off to the Java compiler

**Via terminal**

```bash
./gradlew build
```

To see the generated `.java` files after compilation:

```
build/
└── generated/
    └── sources/
        └── jadex/
            └── main/
                └── ...   ← JADEx-generated .java files
```

---

### Step 4 — Run the Application

**Via IntelliJ**

Open `ExampleApplication.java` and click the ▶ **Run** button next to the `main` method.

**Via Gradle**

```bash
./gradlew bootRun
```

Once started, the application is available at `http://localhost:8080`.

---

## Configuration

### build.gradle

```groovy
plugins {
    id 'org.springframework.boot' version '3.2.12'
    id 'io.spring.dependency-management' version '1.1.4'
    id 'java'
    id 'io.github.nieuwmijnleven.jadex' version '0.628'  // JADEx plugin
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
    runtimeOnly 'com.h2database:h2'
}

jadex {
    sourceDir = 'src/main/jadex'
}
```

Just add the JADEx plugin line and a `jadex { sourceDir }` block to your existing Spring Boot project.

### application.properties

```properties
spring.datasource.url=jdbc:h2:mem:jadex-springboot-example
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.hibernate.ddl-auto=create-drop

# H2 Console: http://localhost:8080/h2-console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

---

## Feature Guide

### 1. Nullable Types (`Type?`)

**`User.jadex`**

```java
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    private Long id;

    private String name;         // non-null

    private String? email;       // nullable — optional input

    @Embedded
    private Address? address;    // nullable — nested nullable
}
```

The distinction between `String?` and `String` makes nullability explicit at the type level. In plain Java, this intent could only be expressed through `@Nullable` annotations or comments — JADEx enforces it as syntax.

---

### 2. Null-safe Access Operator (`?.`)

**`UserService.jadex`**

```java
public UserResponse toResponse(User user) {
    return UserResponse.builder()
        .id(user.getId())
        .name(user.getName())
        .email(getDisplayEmail(user))
        .city(user.getAddress()?.getCity())     // returns null if address is null. no NPE, safe access.
        .build();
}
```

**Before (plain Java)**

```java
.city(user.getAddress() != null ? user.getAddress().getCity() : null)
// or
.city(Optional.ofNullable(user.getAddress()).map(Address::getCity).orElse(null))
```

**After (JADEx)**

```java
.city(user.getAddress()?.getCity())
```

---

### 3. Elvis Operator (`?:`)

**`UserService.jadex`**

```java
public String getDisplayEmail(User user) {
    return user.getEmail() ?: "No email";  // returns default value if null
}
```

**Before (plain Java)**

```java
return user.getEmail() != null ? user.getEmail() : "No email";
// or
return Optional.ofNullable(user.getEmail()).orElse("No email");
```

---

### 4. `apply readonly`

JADEx allows you to optionally make fields, local variables, and method parameters readonly (final-by-default).

The process is straightforward:
1. Mark your code with `apply readonly`.
2. JADEx analyzes your code and applies `final` modifiers where appropriate.
3. Standard Java code with readonly enforcement is generated, fully compatible with existing Java libraries and tooling.

**`UserResponse.jadex`**

```java
apply readonly

@Getter
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private String? email;
    private String? city;
}
```

**Generated Java**

```java
@Getter
@Builder
public class UserResponse {
    private final Long id;
    private final String name;
    @Nullable private final String email;
    @Nullable private final String city;
}
```

`apply readonly` is scoped — apply it per file where readonly (final-by-default) makes sense, and omit it where mutable state is intentional (e.g. `User` entity with setters for JPA). If you need finer control, use the `mutable` keyword to selectively mark specific fields, local variables, or method parameters as mutable within a `apply readonly` file.


**`UserResponse.jadex`**

```java
apply readonly

@Getter
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private mutable String? email;
    private mutable String? city;
}
```

**Generated Java**

```java
@Getter
@Builder
public class UserResponse {
    private final Long id;
    private final String name;
    @Nullable private String email;
    @Nullable private String city;
}
```

---

### 5. Lombok Integration

JADEx integrates fully with Lombok via a Delombok pipeline. The reason JADEx runs Delombok internally is not just for code generation — it is to ensure that **nullability analysis covers Lombok-generated code as well**.

Without Delombok, JADEx would only see the original source with Lombok annotations like `@Data` and `@Builder`, and would have no visibility into the getters, setters, constructors, and builder methods that Lombok generates at compile time. This means nullable fields could silently pass through generated methods without being caught.

By expanding Lombok annotations first via Delombok, JADEx can analyze the fully materialized code and propagate `@Nullable` precisely — including into generated builder parameters, getter return types, and constructor arguments.

```java
@Data           // getter + setter + equals + hashCode + toString
@Builder        // builder pattern
@Entity
public class User {
    private String? email;      // declared nullable in JADEx syntax
    private Address? address;   // declared nullable in JADEx syntax
}
```

After Delombok expansion, JADEx sees the generated methods and propagates `@Nullable` accordingly:

```java
// Lombok-generated code after Delombok — JADEx propagates @Nullable into these
@Nullable
public String getEmail() { return this.email; }

public User.UserBuilder email(@Nullable final String email) { ... }
public User.UserBuilder address(@Nullable final Address address) { ... }
```

This means nullability is consistently enforced across both hand-written and Lombok-generated code paths — no blind spots.

---

### 6. `Optional` Replacement Pattern

**`UserRepository.jadex`**

```java
public interface UserRepository extends JpaRepository<User, Long> {
    User? findByEmail(String email);   // instead of Optional<User>
}
```

**`UserController.jadex`**

```java
@GetMapping("/{id}")
public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
    User? user = userService.findById(id);          // no Optional wrapper
    return user != null
        ? ResponseEntity.ok(userService.toResponse(user))
        : ResponseEntity.notFound().build();
}
```

**Before (plain Java)**

```java
Optional<User> user = userService.findById(id);
return user.map(u -> ResponseEntity.ok(userService.toResponse(u)))
           .orElse(ResponseEntity.notFound().build());
```

The same intent is expressed with a nullable return type and a simple `!= null` check — no `Optional` wrapper needed, and instantly readable by any Java developer.

---

## API Testing

The `requests.http` file can be run directly in IntelliJ.

```http
### User Creation
POST http://localhost:8080/users
Content-Type: application/json

{
  "name": "Anouk",
  "email": "Anouk@example.com",
  "address": {
    "city": "Den Haag",
    "street": "Kerkstraat"
  }
}

### Creating User without email (nullable check)
POST http://localhost:8080/users
Content-Type: application/json

{
  "name": "Jeroen",
  "address": {
      "city": "Den Haag",
      "street": "Kerkstraat"
    }
}

### Search
GET http://localhost:8080/users/1

### Search
GET http://localhost:8080/users/2

### Unknown User (null return check)
GET http://localhost:8080/users/999

### patch (update fields)
PATCH http://localhost:8080/users/1
Content-Type: application/json

{
  "email": "new@example.com"
}

### Deletion
DELETE http://localhost:8080/users/1
```

You can inspect the database state directly via the H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

- JDBC URL: `jdbc:h2:mem:jadex-springboot-example`
- Username: `sa`
- Password: _(none)_
