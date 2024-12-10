
-- SQL Script for Data Seeding
-- Inserts sample data into tables for demonstration purposes.


-- Insert records into the 'address' table
-- This table stores city and postal code details.
INSERT INTO address (city, zip_code)
VALUES
    ('New York', '10001'), -- Record 1
    ('Los Angeles', '90001'), -- Record 2
    ('Chicago', '60601'), -- Record 3
    ('Houston', '77001'), -- Record 4
    ('Phoenix', '85001'), -- Record 5
    ('Philadelphia', '19019'), -- Record 6
    ('San Antonio', '78201'), -- Record 7
    ('San Diego', '92101'), -- Record 8
    ('Dallas', '75201'), -- Record 9
    ('San Jose', '95101'); -- Record 10

-- Insert records into the 'person' table
-- Stores details of individuals, linking them to an address.
INSERT INTO person (first_name, last_name, email, birth_date, address_id)
VALUES
    ('Alice', 'Johnson', 'alice.johnson@example.com', '1990-02-15', 1), -- New York
    ('Bob', 'Smith', 'bob.smith@example.com', '1988-05-12', 2),         -- Los Angeles
    ('Charlie', 'Brown', 'charlie.brown@example.com', '1995-08-23', 3), -- Chicago
    ('Diana', 'Adams', 'diana.adams@example.com', '1992-10-08', 4),     -- Houston
    ('Edward', 'Lee', 'edward.lee@example.com', '1989-12-30', 5),       -- Phoenix
    ('Fiona', 'Clark', 'fiona.clark@example.com', '1993-04-14', 1),     -- New York
    ('George', 'Wright', 'george.wright@example.com', '1996-03-21', 2), -- Los Angeles
    ('Hannah', 'Davis', 'hannah.davis@example.com', '1991-09-07', 1),   -- New York
    ('Ian', 'Miller', 'ian.miller@example.com', '1990-01-19', 1),       -- New York
    ('Julia', 'Garcia', 'julia.garcia@example.com', '1994-11-11', 4),   -- Houston
    ('Kevin', 'Lopez', 'kevin.lopez@example.com', '1992-07-30', 5),     -- Phoenix
    ('Laura', 'Martinez', 'laura.martinez@example.com', '1987-05-03', 2), -- Los Angeles
    ('Mike', 'Roberts', 'mike.roberts@example.com', '1995-10-25', 1),   -- New York
    ('Nina', 'Evans', 'nina.evans@example.com', '1988-08-12', 4),       -- Houston
    ('Oscar', 'Thompson', 'oscar.thompson@example.com', '1991-02-05', 5); -- Phoenix

-- Insert records into the 'task' table
-- Assigns tasks to individuals (one-to-many relationship with 'person').
INSERT INTO task (title, _description, person_id)
VALUES
    -- Alice Johnson (Group: Introduction to Computer Science, Introduction to Psychology)
    ('Plan Study Schedule', 'Organize time for effective learning.', 1),
    ('Attend Coding Lectures', 'Participate in computer science sessions.', 1),
    ('Review Algorithms', 'Study fundamental algorithms for better understanding.', 1),
    ('Practice Mindfulness', 'Learn stress management techniques from psychology.', 1),

    -- Bob Smith (Group: Calculus I, Principles of Economics, World History)
    ('Solve Calculus Problems', 'Complete practice exercises for integration.', 2),
    ('Analyze Economic Trends', 'Research on global market trends.', 2),
    ('Study Historical Events', 'Read about significant world events.', 2),
    ('Create Economic Models', 'Use mathematics to simulate market behaviors.', 2),

    -- Charlie Brown (Group: General Chemistry, Physics for Engineers)
    ('Conduct Lab Experiments', 'Perform chemical reactions in a safe environment.', 3),
    ('Solve Physics Equations', 'Work on real-world engineering problems.', 3),
    ('Study Atomic Structures', 'Learn about the periodic table and atoms.', 3),
    ('Prepare for Lab Tests', 'Revise safety protocols and lab techniques.', 3),

    -- Diana Adams (Group: Calculus I, English Literature)
    ('Write Mathematical Proofs', 'Practice clear and logical reasoning.', 4),
    ('Read Classic Novels', 'Analyze literary works from the syllabus.', 4),
    ('Compose Essays', 'Write critical analyses on assigned topics.', 4),
    ('Study Poetic Forms', 'Explore different types of poetry.', 4),

    -- Edward Lee (Group: Introduction to Computer Science, General Chemistry, Foundations of Sociology)
    ('Code a Small Project', 'Develop a basic program using learned concepts.', 5),
    ('Research Chemical Compounds', 'Investigate the uses of everyday chemicals.', 5),
    ('Explore Social Theories', 'Learn about key sociological frameworks.', 5),
    ('Create a Study Guide', 'Summarize key points from multiple disciplines.', 5),

    -- Fiona Clark (Group: Introduction to Psychology, Business Management 101)
    ('Complete Personality Assessment', 'Apply psychological theories to practice.', 6),
    ('Plan a Marketing Strategy', 'Develop a proposal for a fictional product.', 6),
    ('Attend Management Seminars', 'Engage with guest speakers on business topics.', 6),
    ('Review Psychological Studies', 'Analyze case studies from assigned readings.', 6),

    -- George Wright (Group: Introduction to Computer Science, Calculus I, Physics for Engineers)
    ('Debug Programs', 'Fix errors in existing code.', 7),
    ('Study Calculus Theorems', 'Focus on series and limits.', 7),
    ('Design a Physics Simulation', 'Model real-world systems using programming.', 7),
    ('Prepare for Coding Challenges', 'Work on advanced algorithm problems.', 7),

    -- Hannah Davis (Group: Principles of Economics, World History)
    ('Draft an Economic Report', 'Summarize findings from research.', 8),
    ('Explore Historical Documents', 'Read primary sources for deeper insights.', 8),
    ('Participate in Group Discussions', 'Engage in debates about historical impacts.', 8),
    ('Analyze Market Data', 'Study current trends and interpret graphs.', 8),

    -- Ian Miller (Group: General Chemistry, Foundations of Sociology, Business Management 101)
    ('Study Chemical Reactions', 'Focus on exothermic and endothermic processes.', 9),
    ('Draft a Business Plan', 'Outline a proposal for a small business.', 9),
    ('Research Sociological Case Studies', 'Learn about societal patterns and behaviors.', 9),
    ('Conduct Chemistry Experiments', 'Perform tests to observe reactions.', 9),

    -- Julia Garcia (Group: Physics for Engineers, English Literature)
    ('Prepare for Physics Quiz', 'Review concepts of mechanics and thermodynamics.', 10),
    ('Read Shakespearean Plays', 'Analyze themes and characters in plays.', 10),
    ('Draft a Technical Report', 'Write findings from physics experiments.', 10),
    ('Write a Literary Analysis', 'Critique assigned novels or poems.', 10),

    -- Kevin Lopez (Group: Introduction to Computer Science, Principles of Economics, World History)
    ('Build a Small Website', 'Create a basic HTML and CSS site.', 11),
    ('Study Market Dynamics', 'Analyze supply and demand graphs.', 11),
    ('Write a Historical Essay', 'Discuss the impact of a major historical event.', 11),
    ('Learn Data Visualization', 'Present economic trends through graphs.', 11),

    -- Laura Martinez (Group: Calculus I, English Literature)
    ('Solve Calculus Problems', 'Focus on derivatives and integrals.', 12),
    ('Write a Research Paper', 'Critically analyze a literary theme.', 12),
    ('Study Narrative Techniques', 'Explore storytelling methods in novels.', 12),
    ('Complete Math Assignments', 'Submit homework for advanced calculus.', 12),

    -- Mike Roberts (Group: General Chemistry, Physics for Engineers, Foundations of Sociology)
    ('Balance Chemical Equations', 'Master stoichiometry and reaction balancing.', 13),
    ('Create a Physics Experiment', 'Develop a small-scale model for a problem.', 13),
    ('Study Group Dynamics', 'Learn about societal roles and norms.', 13),
    ('Conduct Physics Calculations', 'Apply concepts to solve engineering problems.', 13),

    -- Nina Evans (Group: Introduction to Psychology, Principles of Economics)
    ('Analyze Behavioral Data', 'Study patterns from psychological experiments.', 14),
    ('Draft an Economic Proposal', 'Plan strategies for economic growth.', 14),
    ('Read Psychology Texts', 'Explore foundational theories and experiments.', 14),

    -- Oscar Thompson (Group: World History, Business Management 101)
    ('Write a Historical Report', 'Summarize findings on an ancient civilization.', 15),
    ('Plan a Business Project', 'Develop a business outline with management strategies.', 15),
    ('Study Leadership Skills', 'Learn principles of effective leadership.', 15);


-- Insert records into the '_group' table
-- Represents different groups or courses available.
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

-- Insert records into the 'persons_groups' table
-- Establishes many-to-many relationships between persons and groups.
INSERT INTO persons_groups (person_id, group_id)
VALUES
    -- Alice Johnson
    (1, 1), -- Introduction to Computer Science
    (1, 5), -- Introduction to Psychology
    
    -- Bob Smith
    (2, 2), -- Calculus I
    (2, 6), -- Principles of Economics
    (2, 7), -- World History
    
    -- Charlie Brown
    (3, 3), -- General Chemistry
    (3, 4), -- Physics for Engineers
    
    -- Diana Adams
    (4, 8), -- English Literature
    
    -- Edward Lee
    (5, 1), -- Introduction to Computer Science
    (5, 3), -- General Chemistry
    (5, 9), -- Foundations of Sociology
    
    -- Fiona Clark
    (6, 5), -- Introduction to Psychology
    (6, 10), -- Business Management 101
    
    -- George Wright
    (7, 1), -- Introduction to Computer Science
    (7, 2), -- Calculus I
    (7, 4), -- Physics for Engineers
    
    -- Hannah Davis
    (8, 6), -- Principles of Economics
    (8, 7), -- World History
    
    -- Ian Miller
    (9, 3), -- General Chemistry
    (9, 9), -- Foundations of Sociology
    (9, 10), -- Business Management 101
    
    -- Julia Garcia
    (10, 4), -- Physics for Engineers
    (10, 8), -- English Literature
    
    -- Kevin Lopez
    (11, 1), -- Introduction to Computer Science
    (11, 6), -- Principles of Economics
    (11, 7), -- World History
    
    -- Laura Martinez
    (12, 2), -- Calculus I
    (12, 8), -- English Literature
    
    -- Mike Roberts
    (13, 3), -- General Chemistry
    (13, 4), -- Physics for Engineers
    (13, 9), -- Foundations of Sociology
    
    -- Nina Evans
    (14, 5), -- Introduction to Psychology
    (14, 6), -- Principles of Economics
    
    -- Oscar Thompson
    (15, 7), -- World History
    (15, 10); -- Business Management 101

