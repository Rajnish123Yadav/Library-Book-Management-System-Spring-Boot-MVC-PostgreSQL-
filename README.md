
📘 Library Book Management System (Spring Boot MVC + PostgreSQL)
📖 Project Description

The Library Book Management System is a Spring Boot MVC web application designed for a University Library. It allows librarians to manage books through a browser-based interface with form inputs, validation, and persistence using Spring Data JPA.

This project demonstrates core CRUD operations (Create, Read, Update, Delete), form validation, and advanced features like search, sorting, availability toggling, and dropdown selections — all without using REST APIs.

🚀 Features
🧩 Core Functional Requirements

Add New Book

Form to add a book with fields: Title, Author, ISBN, Price, Genre.

Saves book details to PostgreSQL (or any DB supported by JPA).

Display All Books

Table view showing Title, Author, ISBN, Price, Genre.

Acts as the main dashboard after any action.

Validate Book Form Inputs

Validation rules:

Title/Author/ISBN → not blank.

ISBN → must be 10 or 13 characters.

Price → must be positive.

Delete a Book

Delete button to remove a book from DB.

Search Books by Title

Search bar to filter books by title (case-insensitive).

🛠 Advanced Functional Enhancements

Book Availability Toggle (Yes/No)

New field available (true/false).

Toggle availability with a button.

Dropdown for Genre

Predefined genres: Fiction, Science, History, Technology, Other.

View Only Available Books

Separate page to display only available books.

Sort Books by Title or Price

Dropdown to sort books:

By Title (A–Z).

By Price (Low → High).

Edit Existing Book

Edit button to update existing book details.

Pre-fills form with existing data.

🏗️ Tech Stack

Backend: Spring Boot (MVC, Spring Data JPA, Hibernate)

Frontend: JSP, JSTL, Bootstrap/CSS

Database: PostgreSQL (or MySQL/any JPA supported DB)

Build Tool: Maven

Packaging: JAR (standalone Spring Boot app)
