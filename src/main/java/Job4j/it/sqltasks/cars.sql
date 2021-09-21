CREATE TABLE cars (
id serial primary key,
	name varchar(255) NOT NULL,
	year_of_production date NOT NULL,
	damaged boolean
);
INSERT INTO cars VALUES (1, 'bmw', '2016-10-19', TRUE);
INSERT INTO cars VALUES (2, 'audi', '2019-11-19', FALSE);

UPDATE cars SET name = 'cc';

DELETE FROM cars
WHERE name = 'bmw';