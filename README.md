A Spring Boot-based RESTful API system designed for delivery slot booking and management. 
The application provides secure user registration and authentication using JWT and Spring Security, role-based access control for Admin and Customer accounts, and comprehensive user management features.

The system enables customers to view available delivery slots, create bookings, cancel bookings, and track booking history. 
Administrators can manage users, delivery slots, and booking records through dedicated management APIs.

The project leverages Bean Validation to ensure data integrity and input validation, MySQL as the relational database, and Spring Data JPA/Hibernate for efficient data persistence and entity relationship management. To address real-world booking challenges, concurrent booking handling and transaction management mechanisms are implemented to prevent overbooking and slot conflicts when multiple users attempt to reserve the same delivery slot simultaneously.

Additionally, the application follows a layered architecture (Controller-Service-Repository), incorporates global exception handling, DTO-based request/response design, and API testing with Postman, providing a scalable and maintainable backend solution.
