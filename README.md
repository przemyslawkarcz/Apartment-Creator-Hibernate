# Apartment-Creator-Hibernate

Apartment Creator (AC) is a junior-level database demo application written in Java (1.8).
As flats and houses are 'natural containers' that store various objects, the example
of creating a multi-room apartment was used. This made it possible to add to different rooms
different objects that played the role of furnishing the apartment.
AC is a database application based on Hibernate technology. As a consequence, the rooms
can be equipped with different objects that can be added in different amounts, modified
or removed from the database.

To run the application, you must install the H2 database and run the ApartmentCreatorApplication class.
The results are presented in the browser at: localhost:8080/h2-console/login.jsp

The object-relational mapping used in the project are:
- OneToOne which is common; 
- OneToMany-ManyToOne which one can find between 
    - Bathroom - Decorative accessories, 
    - Bedroom - Decorative accessories, 
    - Living room - Decorative accessories, 
    - Kitchen - Decorative accessories.

Technologies used in the project are:
- IDE - IntelliJ Idea Ultimate;
- Java - 1.8;
- Hibernate - 5.0;
- Maven;
- SpringBoot;
- TDD;
- H2;

H2
- database in-memory (named) - jdbc:h2:mem:testdb,
- H2 console - localhost:8080/h2-console/login.jsp
- basic information about the H2 database: http://www.h2database.com/html/main.html

Contact data:

E-mail: przemyslawkarcz@gmail.com

