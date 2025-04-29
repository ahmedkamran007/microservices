# 🧠 Java Microservices Project - Quiz & Question Services

This project demonstrates a simple **microservices architecture** using **Spring Boot**, where two independent services interact:

- **QuestionService** – manages and serves quiz questions
- **QuizService** – composes quizzes using questions fetched from the QuestionService

---

## 🧩 Microservices Overview

### 📘 QuestionService
- REST API for managing quiz questions
- Supports fetching questions by category or ID
- Stores data in MySQLdatabase
- Sample endpoints:
  - `GET /questions/` – List all questions
  - `GET /questions/{category}` – List questions by category

### 🧪 QuizService
- Generates quizzes by calling QuestionService
- Uses **Spring Cloud OpenFeign** to communicate
- Sample endpoint:
  - `GET /quiz/{category}` – Returns a quiz of random questions for a category

---

## ⚙️ Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- Spring Cloud OpenFeign (for inter-service communication)
- Spring Data JPA 
- MySQL 
- Maven

---

## ▶️ How to Run the Services

### 1️⃣ Run QuestionService

```bash
cd QuestionService
mvn spring-boot:run


 Use Case
--------------
QuestionService provides questions like:
At Postman when hitting with the below address (GET Request)
http://localhost:8081/quiz/1
The Result would appear in JSON format

{
    "id": 1,
    "title": "java quiz",
    "questions": [
        {
            "questionId": 1,
            "question": "what is java",
            "quizId": 1
        },
        {
            "questionId": 2,
            "question": "what is spring boot",
            "quizId": 1
        },
        {
            "questionId": 3,
            "question": "what is Thread",
            "quizId": 1
        }
    ]
}

Another Example with Quiz 2

http://localhost:8081/quiz/2

Output:
{
    "id": 2,
    "title": "Phython quiz",
    "questions": [
        {
            "questionId": 4,
            "question": "what is phython",
            "quizId": 2
        },
        {
            "questionId": 5,
            "question": "what is data science",
            "quizId": 2
        }
    ]
}





