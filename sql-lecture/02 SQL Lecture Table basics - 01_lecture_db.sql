-- Create a new database
CREATE DATABASE 01_lecture_db;
USE 01_lecture_db;            -- Switches to the newly created database

-- List all tables in the database
SHOW TABLES;



-- [COLUMN_NAME] [COLUMN_TYPE] [ADD_MORE_PROPERTIES]
-- id is PK, not allowed to be null, and is generated (1,2,3,4....)
CREATE TABLE address(
    
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    city VARCHAR(255),
    zip_code VARCHAR(255) NOT NULL
);

-- List all columns for a table
DESCRIBE address;


-- CRUD operations
-- Insert records (CREATE)
-- INSERT INTO address VALUES (1,'växjö', '35252');
INSERT INTO address (city, zip_code) VALUES ('Vaxjö', '35252');
INSERT INTO address (city, zip_code) VALUES ('Vaxjö', '35246');

-- Retrieve data (READ)
SELECT * FROM address;
SELECT city, zip_code FROM address;
SELECT zip_code AS ZP FROM address;

-- Update records (UPDATE) - "WHERE" is important to limit scope
-- UPDATE address SET zip_code = '11111'; 
UPDATE address SET zip_code = '11111' WHERE id = 1;

UPDATE address SET city = '' WHERE id = 2;

-- Delete records (DELETE) - "WHERE" is important to limit scope
DELETE FROM address WHERE id = 2;

-- Remove all table rows, but keep table structure
TRUNCATE TABLE address;

-- Delete the entire table
DROP TABLE address;

-- Modify the the table field/types
ALTER TABLE address MODIFY city VARCHAR(50);
ALTER TABLE address ADD street VARCHAR(255) NOT NULL DEFAULT '-';
ALTER TABLE address DROP street;

--







