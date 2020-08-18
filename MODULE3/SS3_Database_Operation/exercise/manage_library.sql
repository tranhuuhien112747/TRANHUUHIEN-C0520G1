drop database if exists my_database;
create database my_database;
use my_database;

create table student(
	student_number int primary key,
    student_name varchar(50) not null,
    address varchar(50) not null,
    email varchar(50) not null,
    image varchar(50)
    );

create table category(
	cate_number int not null primary key,
    category_name varchar(50) not null
    );
    
create table book(
	code_book varchar(50) not null primary key,
    book_name varchar(50) not null,
    produccer varchar(50) not null,
    author varchar(50) not null,
    publish_year date,
	number_of_publications int,
    book_price double not null,
    image varchar(50),
    cate_number int not null,
    foreign key (cate_number) references category(cate_number)
    );
    
create table borrow_order(
	student_number int,
    code_book varchar(50) not null,
	borrow_date Date,
    returned_date Date,
    foreign key (student_number) references student(student_number),
    foreign key (code_book) references book(code_book)
    );

insert into student values
	(1001,'Hien','Phu Yen','hien@gmail.com',''),
	(1002,'Toan','Da Nang','toan@gmail.com',''),
	(1003,'Chuong','Quang Tri','abc@gmail.com',''),
	(1004,'Tung','Quang Binh','xyzx@gmail.com',''),
	(1005,'Khanh','Nghe An','uiuouo@gmail.com',''),
	(1006,'Nhat','Quang Tri','blabla@gmail.com',''),
	(1007,'Hai','Quang Tri','sumosumo@gmail.com',''),
	(1008,'Hoang','Da Nang','okeokeoke@gmail.com','');
    
select*from student;

insert into book values
('AA103','SPY 007','Marvel','S.Alex',11/12/2015,1,50000,'',5001),
('CH108','Titanit','Sonic','S.Alex',11/12/2015,1,50000,'',5001),
('BC113','Ocean','Lumia','S.Alex',11/12/2015,1,50000,'',5001),
('DD105','Animal','Marvel','S.Alex',11/12/2015,1,50000,'',5001),
('QE209','The world','Marvel','S.Alex',11/12/2015,1,50000,'',5001),
('FF301','Avenger','Marvel','S.Alex',11/12/2015,1,50000,'',5001),
('PK88','Ghost Ridger','Marvel','S.Alex',11/12/2015,1,50000,'',5001);