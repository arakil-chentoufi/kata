# Delivery API - Reactive Spring Boot Application

## 📌 Overview
This project is a **non-blocking, reactive REST API** for managing deliveries, built with **Spring WebFlux** and **R2DBC** for asynchronous database operations. It provides endpoints to create and retrieve delivery records efficiently.

## 🚀 Technologies Used
- **Spring Boot** (WebFlux)
- **Spring Data R2DBC**
- **PostgreSQL/MySQL** (with R2DBC driver)
- **Swagger OpenAPI 3**
- **Project Reactor**

## 📂 Project Structure
```
├── src/main/java/com/phoenix/api
│   ├── controller  # REST Controllers
│   ├── entities    # Domain Models
│   ├── repository  # R2DBC Repositories
│   ├── service     # Business Logic
│   ├── utils       # Helper Utilities
└── ...
```

## 🔧 Setup & Installation
### 1️⃣ Clone the Repository
```sh
git clone https://github.com/your-repo-url.git
cd your-project-folder
```

### 2️⃣ Configure Database (PostgreSQL Example)
Update `application.properties`:
```
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
#############
spring.datasource.url=jdbc:postgresql://localhost:5432/kata
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.hbm2dll.create_namespaces=true
#############
spring.datasource.username=postgres
spring.datasource.password=admin
spring.jpa.properties.hibernate.default_schema=phx_schema
#spring.jpa.properties.hibernate.format_sql=true
```

### 3️⃣ Build and Run
```sh
./gradlew build
./gradlew bootRun
```

## 📌 API Endpoints
| Method | Endpoint        | Description          |
|--------|---------------|----------------------|
| POST   | `/deliveries`  | Create a new delivery |
| GET    | `/deliveries`  | Get all deliveries   |
| GET    | `/deliveries/{id}` | Get delivery by ID |

### 📝 Swagger API Documentation
Once the application is running, access **Swagger UI** at:
```
localhost:8080/swagger-ui/index.html
```


