
# BookStoreApiPractice

A simple CRUD Book API built with Spring Boot.

This project provides endpoints to create, read, update, and delete books, using **ISBN** as the unique identifier. Integration tests are included to ensure API reliability.

## Features

- **Create Book** – Add new books to the store (identified by ISBN)
- **Read Books** – Retrieve all books or details of a specific book by ISBN
- **Update Book** – Modify book information by ISBN
- **Delete Book** – Remove books by ISBN
- **Integration Tests** – Automated tests to verify API functionality

## Tech Stack

- **Backend:** Spring Boot
- **Build Tool:** Maven
- **Database:** (e.g., H2, MySQL, PostgreSQL—specify here)
- **Testing:** JUnit, Spring Boot Test

## Getting Started

### Prerequisites

- Java 17+ (or your project’s Java version)
- Maven

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
  "author": "Author Name",
  "publishedDate": "2022-05-01"
}
```

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

**How to use:**  
Copy everything inside the code block above and paste it into your repository’s `README.md` file.  
You can add database details and license as you see fit!
