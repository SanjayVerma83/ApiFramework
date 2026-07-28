# API Automation Framework

A Hybrid API Automation Framework built using **Java, REST Assured, TestNG, Maven, Log4j2, Extent Reports, JSON Schema Validation, and Excel Data-Driven Testing**.

The framework automates CRUD operations using the Automation Exercise APIs and follows a clean, reusable, and maintainable design.

---

# Tech Stack

- Java 21
- REST Assured
- TestNG
- Maven
- Log4j2
- Extent Reports
- Jackson (POJO Serialization & Deserialization)
- JSON Schema Validation
- Apache POI (Excel Data-Driven)
- Git & GitHub
- Jenkins (Freestyle)

---

# Framework Features

- REST Assured API Automation
- Data-Driven Testing using Excel
- Dynamic Test Data Generation
- CRUD API Testing
- Centralized Configuration
- Reusable Request Specification
- POJO Serialization & Deserialization
- JSON Schema Validation
- Logging using Log4j2
- Extent HTML Reports
- TestNG Execution
- Jenkins Integration
- Maven Build Support

---

# Project Structure

```
ApiFramework
│
├── src
│   ├── main
│   │   ├── config
│   │   ├── payload
│   │   ├── pojo
│   │   └── utils
│   │
│   └── test
│       ├── base
│       ├── listeners
│       ├── reports
│       └── tests
│
├── testng.xml
├── pom.xml
├── .gitignore
└── README.md
```

---

# Framework Architecture

```
TestNG
   │
   ▼
BaseTest
   │
   ▼
RequestSpecification
   │
   ▼
PayloadBuilder
   │
   ▼
REST Assured
   │
   ▼
Automation Exercise APIs
   │
   ▼
Assertions
   │
   ▼
Extent Report
```

---

# API Coverage

### GET APIs

- Get Products List
- Get User Details

### POST APIs

- Search Product
- Verify Login
- Create Account

### PUT API

- Update Account

### DELETE API

- Delete Account

---

# Dynamic Test Data

The framework automatically generates a unique user name and email for every execution.

Example:

```
Name  : Sanjay1785219750088
Email : sanjay1785219750088@gmail.com
```

This avoids duplicate user issues and makes the framework suitable for repeated executions in Jenkins.

---

# Data-Driven Testing

Test data is maintained in:

```
src/test/resources/TestData.xlsx
```

The framework reads data using Apache POI while dynamically generating unique user names and email addresses.

---

# Reports

### TestNG Report

```
test-output/index.html
```

### Extent Report

Generated automatically after execution.

---

# Execute Using Maven

```
mvn clean test
```

---

# Execute Using TestNG

Run

```
testng.xml
```

as a TestNG Suite.

---

# Jenkins Integration

The framework supports Jenkins Freestyle Jobs.

Build Command

```
clean test
```

Source Code Management

```
Git
```

Repository

```
https://github.com/SanjayVerma83/ApiFramework.git
```

---

# Validations Performed

- HTTP Status Code Validation
- Response Time Validation
- Content-Type Validation
- Business Response Validation
- JSON Schema Validation
- POJO Serialization
- POJO Deserialization

---

# Design Highlights

- Page-like reusable framework structure
- Configurable Endpoints
- Centralized Configuration Manager
- Reusable Payload Builder
- Base Test Class
- Shared Test Data Store
- Modular Utility Classes
- Logging with Log4j2
- Clean Maven Project Structure

---

# Sample Execution

```
Tests Run : 7

Passed : 7

Failed : 0

Skipped : 0

BUILD SUCCESS
```

---

# Author

**Sanjay Verma**

Senior QA Automation Engineer

**GitHub**

https://github.com/SanjayVerma83
