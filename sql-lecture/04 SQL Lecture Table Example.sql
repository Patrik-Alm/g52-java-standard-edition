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
    create_date DATETIME DEFAULT NOW(),
    _active TINYINT DEFAULT FALSE,
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