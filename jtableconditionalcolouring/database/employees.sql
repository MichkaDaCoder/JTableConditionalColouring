/* employee.sql: SQL Script for creating tables */

/* Script for creating employee table */
CREATE TABLE `employee` (
	`ID`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`FIRST_NAME`	TEXT NOT NULL,
	`LAST_NAME`	TEXT NOT NULL,
	`SALARY`	NUMERIC NOT NULL,
	`EMAIL`	TEXT UNIQUE,
	`ADDRESS`	TEXT,
	`HIREDATE`	TIMESTAMP
);

/* SQL Script for creating sequence table */
CREATE TABLE `sequence` (
	`seq_name`	text,
	`seq_count`	integer
);

/* SQL Script for creating sqlite_sequence */
CREATE TABLE `sqlite_sequence` (
	`name`	TEXT,
	`seq`	TEXT
);