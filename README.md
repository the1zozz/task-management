# task-management
springboot application handle authentication and task management

# 📝 Task Management API

A Spring Boot application that provides **user authentication (JWT)** and **task management APIs**.  
Built with **Spring Boot 3**, **Spring Security (JWT)**, and **H2 in-memory database** for easy testing.

---

## ⚙️ Tech Stack
- Java 21
- Spring Boot 3.5.5
- Spring Security (JWT)
- Spring Data JPA
- H2 Database (for testing)
- Maven
- Swagger / OpenAPI (API documentation)

---

## 🚀 Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/the1zozz/task-management.git
cd task-management
--- 

This project loads database configuration from environment variables.
If not set, defaults will be used.

Variable	    Description 	          Default Value
PROFILE          active profile               dev
DB_URL	      JDBC connection URL	    jdbc:h2:mem:testdb
DB_DRIVER	     JDBC driver         	      org.h2.Driver
DB_USERNAME	   Database username	              moaaz
DB_PASSWORD 	Database password	             (empty)
--- 
## 🔑 Authentication Flow
1-Sign Up → Register a new user
2-Sign In → Authenticate user & receive JWT token
3-Use JWT → Send token in Authorization: Bearer <token> header
---
## ⚙️ PostMan Coolection
collection is in postman folder

## 🔎 Swagger API Docs
Once the app is running, open:
👉 http://localhost:8080/swagger-ui.html
---
👨## ‍💻 Author
Moaaz Atef Ahmed – moazatef435@gmail.com