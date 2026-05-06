# springboot-todo-api

Small SpringBoot REST API built to ramp on the Java/Spring stack. In-memory todo storage with REST endpoints for CRUD.

## Stack
- Java 21
- SpringBoot 3.x
- Maven

## Run
```
cd todo-api
mvn spring-boot:run
```
Then hit http://localhost:8080/api/todos

## Endpoints
- GET /api/todos - list all
- POST /api/todos with body {"text": "..."} - add
- DELETE /api/todos/{id} - remove

## Notes
First SpringBoot project. Used the time to internalize the annotation-driven configuration model, constructor-based dependency injection, and the layered architecture pattern (controller -> service -> model).
