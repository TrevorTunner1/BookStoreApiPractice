
# BookStoreApiPractice

A simple CRUD Book API built with Spring Boot.

This project provides endpoints to create, read, update, and delete books, using **ISBN** as the unique identifier. Each book is associated with an **Author** entity, mapped using JPA and Hibernate. Integration tests are included to ensure API reliability.

## Features

- **Create Book** – Add new books to the store (identified by ISBN and mapped to an author)
- **Read Books** – Retrieve all books or details of a specific book by ISBN
- **Update Book** – Modify book information by ISBN
- **Delete Book** – Remove books by ISBN
- **Author Entity** – Books are linked to authors using JPA/Hibernate relationships
- **Integration Tests** – Automated tests to verify API functionality

## Tech Stack

- **Backend:** Spring Boot
- **Build Tool:** Maven
- **Database:** PostgreSQL
- **ORM:** JPA, Hibernate
- **DTO Mapping:** ModelMapper
- **Boilerplate Reduction:** Lombok
- **Testing:** JUnit, Spring Boot Test

## Getting Started

### Prerequisites

- Java 17+ (or your project’s Java version)
- Maven
- PostgreSQL

### Setup

Clone the repository:
```bash
git clone https://github.com/TrevorTunner1/BookStoreApiPractice.git
cd BookStoreApiPractice
```

Build and run the application:
```bash
mvn spring-boot:run
```

## API Endpoints

| Method | Endpoint                | Description                |
|--------|-------------------------|----------------------------|
| POST   | `/api/books`            | Create a new book          |
| GET    | `/api/books`            | Get all books              |
| GET    | `/api/books/{isbn}`     | Get book by ISBN           |
| PUT    | `/api/books/{isbn}`     | Update book by ISBN        |
| DELETE | `/api/books/{isbn}`     | Delete book by ISBN        |

### Example Book JSON

```json
{
  "isbn": "978-3-16-148410-0",
  "title": "Example Book Title",
  "author": {
    "id": 1,
    "name": "Author Name"
  },
  "publishedDate": "2022-05-01"
}
```

### Example Author JSON

```json
{
  "id": 1,
  "name": "Author Name"
}
```

## Entity Relationship

Books and Authors are mapped using JPA and Hibernate. Typically, a Book has a many-to-one relationship with Author.

```java
// Example JPA mapping in Book entity
@ManyToOne
@JoinColumn(name = "author_id")
private Author author;
```

## ModelMapper & Lombok

- **ModelMapper** is used to map DTOs to entities and vice versa, simplifying data transfer.
- **Lombok** is used to reduce boilerplate code for getters, setters, constructors, etc.

## Running Tests

To run integration tests:
```bash
mvn test
```

## Contributing

Feel free to fork this repository, make changes, and submit pull requests!

## License

Specify your license here (e.g., MIT, Apache 2.0).
```

---

Copy and paste the above into your README.md file. Let me know if you want more details or further customization!