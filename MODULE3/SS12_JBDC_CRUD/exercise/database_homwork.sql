drop database if exists manager_user;
create database manager_user;
use manager_user;

CREATE TABLE users_information (
    id INT(3) NOT NULL PRIMARY KEY,
    fullname VARCHAR(120) NOT NULL,
    email VARCHAR(220) NOT NULL,
    country VARCHAR(120)
);
 
insert into users_information (id,fullname, email, country)
 values
	(1,'C.Ronaldo','fifa3@gmail.com','Viet Nam'),
	(2,'L.Messi','fifa3@gmail.com','Viet Nam'),
	(3,'Neymar','fifa3@gmail.com','Viet Nam'),
	(4,'W.Rooney','fifa3@gmail.com','Viet Nam'),
	(5,'L.Suaresz','fifa3@gmail.com','Viet Nam'),
	(6,'E,Hazard','fifa3@gmail.com','Viet Nam'),
	(7,'E.Casilas','fifa3@gmail.com','Viet Nam'),
	(8,'N.Vidid','fifa3@gmail.com','Viet Nam'),
	(9,'S.Ramos','fifa3@gmail.com','Viet Nam'),
	(10,'T.Macerlo','fifa3@gmail.com','Viet Nam'),
	(11,'Z.Ibramovic','fifa3@gmail.com','Viet Nam');

SELECT *
FROM users_information;
    