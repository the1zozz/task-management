Task Management System
A robust Spring Boot-based task management application with JWT authentication, role-based authorization, and comprehensive API documentation.

🚀 Features
---
User Authentication & Authorization

JWT-based secure authentication

Role-based access control (USER/ADMIN)

Secure password encoding

Task Management
---
Create, read, update, and delete tasks

User-specific task isolation

RESTful API endpoints

API Documentation
---
Swagger/OpenAPI integration

Comprehensive endpoint documentation

Interactive API explorer

Database
---
H2 in-memory database (development)

JPA with Hibernate ORM

Automatic schema generation

🛠️ Tech Stack
---
Backend Framework: Spring Boot 3.5.5

Security: Spring Security with JWT

Database: H2 (Development), JPA

API Documentation: Springdoc OpenAPI

Build Tool: Maven

Java Version: 21

Lombok: Reduced boilerplate code

MapStruct: Object mapping

📦 Installation & Setup
---
Clone the repository

bash
git clone <repository-url>
cd task-management
Build the project

bash
mvn clean install
Run the application

bash
mvn spring-boot:run
Access the application

Application: http://localhost:8080

H2 Console: http://localhost:8080/h2-console

Swagger UI: http://localhost:8080/swagger-ui.html

🔧 Configuration
---
Database Configuration (application-dev.properties)
properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=moaaz
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
JWT Configuration
properties
security.jwt.secret-key=your-secret-key-here
security.jwt.expiration-time=3600000

📚 API Endpoints
--
Authentication Endpoints
Method	Endpoint	Description
POST	/api/auth/signup	Register new user
POST	/api/auth/login	User login
Task Endpoints (Authenticated)
Method	Endpoint	Description
GET	/api/tasks	Get all user tasks
GET	/api/tasks/{id}	Get task by ID
POST	/api/tasks	Create new task
PUT	/api/tasks/{id}	Update task
DELETE	/api/tasks/{id}	Delete task

🔐 Security
---
White-listed Endpoints
--
The following endpoints are publicly accessible:

/api/auth/** - Authentication endpoints

/h2-console/** - H2 database console

/v3/api-docs/** - OpenAPI documentation

/swagger-ui/** - Swagger UI interface

Authentication Flow
-
User registers/login to get JWT token

Include token in Authorization header: Bearer <token>

Access protected endpoints with valid token

🧪 Testing
-
Run tests with:

bash
mvn test

📁 Project Structure
-
text
src/
├── main/
│   ├── java/com/example/task_management/
│   │   ├── configs/          # Configuration classes
│   │   ├── controller/       # REST controllers
│   │   ├── dto/             # Data Transfer Objects
│   │   ├── models/          # Entity models
│   │   ├── repository/      # Data access layer
│   │   ├── security/        # Security configuration
│   │   ├── services/        # Business logic
│   │   └── exception/       # Custom exceptions
│   │   ├── mapper/          # manage mapping
│   └── resources/
│       └── application.properties
│       └── application-dev.properties
│       └── application-aut.properties
│       └── application-pro.properties
│
└── test/                    # Test classes
└── postman/                 # postman collection

🗃️ Database Schema
-
Users Table
-
id (Primary Key)

name

email (Unique)

password (Encrypted)

roles

Tasks Table
-
id (Primary Key)

title

description

status

user_id (Foreign Key)


Roles Table
-
id (Primary Key)

name (USER/ADMIN)

🚀 Deployment
-
Production Setup
Update application.properties for production database

Set proper JWT secret key

Configure environment variables

Build with: mvn clean package -DskipTests

Deploy the generated JAR file

Environment Variables
-
bash
export PROFILE=prod
export DB_URL=your_production_db_url
export DB_USERNAME=your_db_username
export DB_PASSWORD=your_db_password
export JWT_SECRET=your_secure_jwt_secret

Author 
-
name : Moaaz Atef Ahmed
E-Mail : moazatef435@gmail.com