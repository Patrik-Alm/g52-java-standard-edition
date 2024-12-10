-- SQL Script to Implement the ERD for Lecture

-- Table: Address
-- Stores address details.
CREATE TABLE address (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,     -- Unique identifier for each address
    city VARCHAR(40),                               -- Name of the city
    zip_code VARCHAR(255) NOT NULL                  -- Postal code
);

-- Table: Person
-- Stores information about individuals.
-- Represents the 'person' entity in the ERD.
-- Each person is linked to an address (one-to-many relationship).
CREATE TABLE person (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,     -- Unique identifier for each person
    first_name VARCHAR(100) NOT NULL,               -- First name of the person
    last_name VARCHAR(100) NOT NULL,                -- Last name of the person
    email VARCHAR(150) NOT NULL UNIQUE,             -- Email address, must be unique
    birth_date DATE,                                -- Date of birth
    create_date DATETIME DEFAULT NOW(),             -- Timestamp of record creation
    _active TINYINT DEFAULT FALSE,                  -- Boolean indicating if the person is active
    address_id INT NOT NULL,                        -- Foreign key referencing the address table
    FOREIGN KEY (address_id) REFERENCES address(id) -- Ensures referential integrity
);

-- Table: Task
-- Stores tasks assigned to persons.
-- Represents the 'task' entity in the ERD.
-- Each task is linked to a person (one-to-many relationship).
CREATE TABLE task (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,     -- Unique identifier for each task
    title VARCHAR(100) NOT NULL,                    -- Title of the task
    _description VARCHAR(500),                      -- Description of the task
    person_id INT,                                  -- Foreign key referencing the person table
    FOREIGN KEY (person_id) REFERENCES person(id)   -- Ensures referential integrity
);

-- Table: Group
-- Stores information about groups.
-- Represents the 'group' entity in the ERD.
CREATE TABLE _group (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,     -- Unique identifier for each group
    group_name VARCHAR(100) NOT NULL                -- Name of the group
);

-- Table: Persons_Groups
-- Junction table to establish a many-to-many relationship between people and groups.
-- Represents the 'persons_groups' junction entity in the ERD.
CREATE TABLE persons_groups (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,     -- Unique identifier for each record
    person_id INT NOT NULL,                         -- Foreign key referencing the person table
    group_id INT NOT NULL,                          -- Foreign key referencing the group table
    FOREIGN KEY (person_id) REFERENCES person(id),  -- Ensures referential integrity
    FOREIGN KEY (group_id) REFERENCES _group(id)    -- Ensures referential integrity
);
