-- Create Database
CREATE DATABASE IF NOT EXISTS meeting_calendar_db;

-- USE Database
USE meeting_calendar_db;

-- Create Table users
CREATE TABLE users
(
    username   VARCHAR(255) NOT NULL PRIMARY KEY,
    _password  VARCHAR(255) NOT NULL,
    is_expired TINYINT  DEFAULT FALSE,
    created_at DATETIME DEFAULT NOW()
);


-- Create Table meeting_calendar
Create TABLE meeting_calendars
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(100) NOT NULL,
    username   VARCHAR(255),
    created_at DATETIME     NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username)
);


-- Create Table meetings
CREATE TABLE meetings
(
    id           INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    start_at     DATETIME     NOT NULL,
    end_at       DATETIME     NOT NULL,
    _description TEXT,
    calendar_id  INT          NOT NULL,
    created_at   DATETIME DEFAULT NOW(),
    FOREIGN KEY (calendar_id) REFERENCES meeting_calendars (id)
);