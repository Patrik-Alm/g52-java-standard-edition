
## UML ERD - Entity Relationship Diagram

![UML ER DIAGRAM](img/SQL%20Lecture%20UML%20ERD.png)

#### Explanation of the ER Diagram:
- Address table has a one-to-many relationship with the Person table.   
  (each person has one address).
  
- Person has a one-to-many relationship with the Task table.   
  (a person can be assigned multiple tasks).
  
- Person has a many-to-many relationship with Group table.   
  (Many people can be part of many courses)   
  *Actually it's not implemented like this.*

  Person and Group are connected through the 
  `persons_groups` junction table establishing two one-to-many relationships between them.   
  (a person is member of many courses)   
  (a group includes many people)   
  
---
### ER Diagram
*made with an alternative creation method (mermaid)*
```mermaid
erDiagram

    ADDRESS {
        INT id PK "NOT NULL AUTO_INCREMENT"
        VARCHAR(40) city
        VARCHAR(255) zip_code "NOT NULL"
    }

    PERSON {
        INT id PK "NOT NULL AUTO_INCREMENT"
        VARCHAR(100) first_name "NOT NULL"
        VARCHAR(100) last_name "NOT NULL"
        VARCHAR(150) email "NOT NULL UNIQUE"
        DATE birth_date
        DATETIME created_at "DEFAULT NOW()"
        TINYINT is_active "DEFAULT FALSE"
        INT address_id FK

    }

    TASK {
        INT id PK "NOT NULL AUTO_INCREMENT"
        VARCHAR(100) title "NOT NULL"
        VARCHAR(500) _description
        INT person_id FK
    }

    GROUP {
        INT id PK "NOT NULL AUTO_INCREMENT" 
        VARCHAR(100) group_name "NOT NULL"
    }

    PERSONS_GROUPS {
        INT id PK "NOT NULL AUTO_INCREMENT" 
        INT person_id FK "NOT NULL"
        INT group_id FK "NOT NULL"
    }

    ADDRESS }|--|| PERSON : "has"
    PERSON |o--o{ TASK : "assigned"
    PERSON }o--|| PERSONS_GROUPS : "member of"
    GROUP }o--|| PERSONS_GROUPS : "includes"
```

#### SQL for creating tables
```sql
CREATE TABLE address (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    city VARCHAR(40),
    zip_code VARCHAR(255) NOT NULL
);

CREATE TABLE person (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    birth_date DATE,
    created_at DATETIME DEFAULT NOW(),
    is_active TINYINT DEFAULT FALSE,
    address_id INT NOT NULL UNIQUE,
    FOREIGN KEY (address_id) REFERENCES address(id)
);

CREATE TABLE task (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    _description VARCHAR(500),
    person_id INT,
    FOREIGN KEY (person_id) REFERENCES person(id)
);

CREATE TABLE _group (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    group_name VARCHAR(100) NOT NULL
);

CREATE TABLE persons_groups (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    person_id INT NOT NULL,
    group_id INT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id),
    FOREIGN KEY (group_id) REFERENCES _group(id)
);
```