drop database if exists my_database;
create database my_database;
use my_database;

create table student(
	id int not null,
    student_name varchar(50) not null,
    age int not null,
	course varchar(50) not null,
    money double not null
    );

insert into student values
	(1,'Hoang',21,'CNTT',400000),
	(2,'Viet',19,'DTVT',320000),
	(3,'Thanh',18,'KTDN',400000),
	(4,'Nhan',19,'CK',450000),
	(5,'Huong',20,'TCNH',500000),
	(5,'Huong',20,'TCNH',500000);
    
    select*
    from student
    where student_name='Huong';
    
    select
    sum(money)
    from student;
    
    select*
    from student
    group by student_name;