# restapp
Example of an RESTful architecture by a simple user repository including sqlite database. The relational database just contains a simply user table (id, name) and
is using the standard design patterns (repostory, DAOs) provided by JDBC or by JPA/Hibernate. The data is provided by the database through a RESTFul Spring Boot 2
RestController and should in the end presented by a React Webpage.

Technologies that should be included:
- maybe Kafka or RabbitMQ
- CI/CD Pipeline (by GitLab)
- Having Integration and Unittests
- GUI Testing with Selenium
- Data should be provided by ORMapper JPA/Hibernate
- Data should be also provided by JDBC
- SonarQube (SonarLite - for Code Quality)
