# Spring Boot Learning Journey 🚀

A repository documenting my journey of learning Spring Boot, Java Backend Development, JPA, Hibernate, and REST API development.

This project contains hands-on practice, code examples, and mini implementations created while exploring the Spring ecosystem and backend development concepts.

---

## 📖 About This Repository

The purpose of this repository is to:

- Learn Spring Boot fundamentals
- Understand REST API development
- Explore Spring Data JPA and Hibernate
- Work with H2 Database
- Learn Entity-Relationship mapping
- Practice backend development using Java
- Build a strong foundation for Java Full Stack Development

---

## 🛠 Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- H2 Database
- Maven
- Lombok
- REST APIs

---

## 📂 Project Structure

```text
src/main/java
│
├── Controllers
│   └── EmployeeController.java
│
├── DTO
│   └── EmployeeDTO.java
│
├── entities
│   └── EmployeeEntity.java
│
├── repository
│   └── EmployeeRepository.java
│
└── SpringbootwebApplication.java
```

---

## 📚 Concepts Covered

### Spring Boot Fundamentals

- Spring Boot Project Setup
- Maven Dependencies
- application.properties
- Dependency Injection
- Constructor Injection

### REST APIs

- @RestController
- @RequestMapping
- @GetMapping
- @PostMapping
- @PathVariable
- @RequestParam
- @RequestBody

### JPA & Hibernate

- @Entity
- @Id
- @GeneratedValue
- Entity Mapping
- ORM Concepts
- JPQL Basics
- Persistence Layer

### Spring Data JPA

- JpaRepository
- CRUD Operations
- save()
- findById()
- findAll()
- deleteById()
- existsById()

### Database

- H2 In-Memory Database
- Database Configuration
- Automatic Table Creation

### Lombok

- @Getter
- @Setter
- @NoArgsConstructor
- @AllArgsConstructor

---

## 🔄 Application Flow

```text
Client
   │
   ▼
Controller Layer
   │
   ▼
Repository Layer (JpaRepository)
   │
   ▼
JPA
   │
   ▼
Hibernate
   │
   ▼
Database (H2)
```

---

## 🚀 API Endpoints

### Get Employee By ID

```http
GET /employee/{employeeId}
```

### Get All Employees

```http
GET /employee
```

### Create Employee

```http
POST /employee/setEmp
```

Sample Request Body:

```json
{
  "name": "Aman",
  "email": "aman@example.com",
  "age": 22,
  "dateOfJoining": "2026-06-01"
}
```

---

## ⚙️ Running the Project

### Clone Repository

```bash
git clone <repository-url>
```

### Navigate to Project

```bash
cd springbootweb
```

### Run Application

```bash
mvn spring-boot:run
```

Application will start on:

```text
http://localhost:8080
```

---

## 🗄 H2 Database Console

After starting the application:

```text
http://localhost:8080/h2-console
```

Use the JDBC URL configured in:

```properties
application.properties
```

---

## 🎯 Learning Objectives

- Understand Spring Boot Architecture
- Learn Backend Development with Java
- Build REST APIs
- Master JPA and Hibernate
- Work with Databases
- Follow Layered Architecture
- Prepare for Backend Development Interviews

---

## 📈 Learning Progress

### Completed

- [x] Spring Boot Setup
- [x] REST Controllers
- [x] Request Mapping
- [x] Path Variables
- [x] Request Parameters
- [x] Request Body
- [x] JPA Basics
- [x] Hibernate Basics
- [x] Spring Data JPA
- [x] H2 Database
- [x] CRUD Operations

### Upcoming

- [ ] Service Layer
- [ ] DTO Mapping
- [ ] Validation
- [ ] Exception Handling
- [ ] MySQL Integration
- [ ] Spring Security
- [ ] JWT Authentication
- [ ] Docker
- [ ] Testing (JUnit & Mockito)
- [ ] Microservices

---

## 👨‍💻 Author

**Aman Rana**

B.Tech CSE Student | Java Backend Developer (Learning Phase)

Currently learning:

- Java Backend Development
- Spring Boot
- Data Structures & Algorithms
- Web Development

---

## ⭐ Note

This repository is part of my continuous learning journey in Java Backend Development. New concepts, projects, and best practices will be added as I progress further into the Spring ecosystem.
