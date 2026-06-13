# Vehicle Data Management Desktop Application

A layered desktop application built with JavaFX for validating, managing, and persistently storing vehicle data.

## Technologies

* **Language:** Java
* **GUI Framework:** JavaFX
* **Database:** SQLite
* **Build Tool:** Maven

## Architecture and Design Patterns

The project focuses on implementing a clean and maintainable data access layer using industry-standard design patterns.

### DAO (Data Access Object)

An interface-based data access layer (`VehicleDAO`) separates business logic from database operations, improving modularity, maintainability, and testability.

### Singleton Pattern

Used to manage database connectivity efficiently by maintaining a single database connection instance throughout the application's lifecycle.

### MVC Architecture

The application follows the Model-View-Controller (MVC) pattern, ensuring a clear separation between the user interface, business logic, and data management layers.

## Features

### Vehicle Listing

Retrieve and display all stored vehicle records from the SQLite database.

### Vehicle Registration

Add new vehicle records with validated input data to ensure data integrity.

### Persistent Storage

Store vehicle information in a local SQLite database, allowing data to persist between application sessions.

## Project Goals

This project was developed to gain practical experience with:

* Desktop application development using JavaFX
* Layered software architecture
* Database integration with SQLite
* Design patterns such as DAO and Singleton
* Separation of concerns through MVC
* Input validation and persistent data management
