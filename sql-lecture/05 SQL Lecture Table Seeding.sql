INSERT INTO address (city, zip_code)
VALUES
    ('New York', '10001'),
    ('Los Angeles', '90001'),
    ('Chicago', '60601'),
    ('Houston', '77001'),
    ('Phoenix', '85001'),
    ('Philadelphia', '19019'),
    ('San Antonio', '78201'),
    ('San Diego', '92101'),
    ('Dallas', '75201'),
    ('San Jose', '95101');
    
    
INSERT INTO person (first_name, last_name, email, birth_date, address_id)
VALUES
    ('John', 'Doe', 'johndoe@example.com', '1990-01-15', 1),
    ('Jane', 'Smith', 'janesmith@example.com', '1985-03-22', 2),
    ('Michael', 'Brown', 'michaelbrown@example.com', '1992-07-08', 3),
    ('Emily', 'Davis', 'emilydavis@example.com', '1988-11-19', 4),
    ('Chris', 'Wilson', 'chriswilson@example.com', '1995-02-14', 5),
    ('Sarah', 'Taylor', 'sarahtaylor@example.com', '1991-06-30', 6),
    ('David', 'Miller', 'davidmiller@example.com', '1987-09-23', 7),
    ('Jessica', 'Anderson', 'jessicaanderson@example.com', '1993-05-12', 8),
    ('Daniel', 'Thomas', 'danielthomas@example.com', '1986-08-03', 9),
    ('Laura', 'Martinez', 'lauramartinez@example.com', '1994-12-27', 10);
    
    
INSERT INTO TASK (title, _description, person_id) 
VALUES 
    ('Plan Study Schedule', 'Organize time for effective learning.',1),
    ('Attend Lectures', 'Engage in coding sessions.',1),
    ('Take Notes', 'Capture key information systematically.',1),
    ('Review Lecture Notes', 'Recap key points for retention.',1),
    ('Code Challenges', 'Solve coding exercises.',1),
    ('Research Topics', 'Explore and gather additional information.',2),
    ('Complete Assignments', 'Finish assigned tasks promptly.',1),
    ('Collaborate on Projects', 'Work with peers on coding projects.',2),
    ('Practice Problems', 'Apply concepts through problem-solving.',1),
    ('Study New Technologies', 'Explore emerging programming tools.',2),
    ('Build Portfolio', 'Create a showcase of projects.',1);
    
INSERT INTO _group (group_name)
VALUES
    ('Introduction to Computer Science'),
    ('Calculus I'),
    ('General Chemistry'),
    ('Physics for Engineers'),
    ('Introduction to Psychology'),
    ('Principles of Economics'),
    ('World History'),
    ('English Literature'),
    ('Foundations of Sociology'),
    ('Business Management 101');
    
    
INSERT INTO persons_groups (person_id, group_id)
VALUES
    (1, 1), -- John Doe -> Introduction to Computer Science
    (1, 3), -- John Doe -> General Chemistry
    (2, 2), -- Jane Smith -> Calculus I
    (2, 5), -- Jane Smith -> Introduction to Psychology
    (3, 4), -- Michael Brown -> Physics for Engineers
    (3, 7), -- Michael Brown -> World History
    (4, 6), -- Emily Davis -> Principles of Economics
    (4, 8), -- Emily Davis -> English Literature
    (5, 1), -- Chris Wilson -> Introduction to Computer Science
    (5, 9), -- Chris Wilson -> Foundations of Sociology
    (6, 2), -- Sarah Taylor -> Calculus I
    (6, 10), -- Sarah Taylor -> Business Management 101
    (7, 4), -- David Miller -> Physics for Engineers
    (8, 5), -- Jessica Anderson -> Introduction to Psychology
    (8, 7), -- Jessica Anderson -> World History
    (9, 3), -- Daniel Thomas -> General Chemistry
    (9, 6), -- Daniel Thomas -> Principles of Economics
    (9, 8), -- Daniel Thomas -> English Literature
    (10, 1), -- Laura Martinez -> Introduction to Computer Science
    (10, 9), -- Laura Martinez -> Foundations of Sociology
    (10, 10); -- Laura Martinez -> Business Management 101


    
    