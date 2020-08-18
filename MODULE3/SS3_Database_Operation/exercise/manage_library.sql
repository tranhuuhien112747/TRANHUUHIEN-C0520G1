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
	borrow_date Date not null,
    returned_date Date,
    foreign key (student_number) references student(student_number),
    foreign key (code_book) references book(code_book)
    );

insert into student values
	(1001,'Hien','Phu Yen','hien@gmail.com',null),
	(1002,'Toan','Da Nang','toan@gmail.com',null),
	(1003,'Chuong','Quang Tri','abc@gmail.com',null),
	(1004,'Tung','Quang Binh','xyzx@gmail.com',null),
	(1005,'Khanh','Nghe An','uiuouo@gmail.com',null),
	(1006,'Nhat','Quang Tri','blabla@gmail.com',null),
	(1007,'Hai','Quang Tri','sumosumo@gmail.com',null),
	(1008,'Hoang','Da Nang','okeokeoke@gmail.com',null);
    
select*
from student;

insert into category values
	(5001,'Actions'),
	(5033,'Romantic'),
	(5055,'Science'),
	(5011,'Life Science'),
	(5077,'Supernatural'),
	(5666,'Horror');

select*
from category;

insert into book values
	('AA103','SPY 007','Marvel','S.Alex','2015-12-11',1,50000,'',5001),
	('CH108','Titanit','Sony','F.Thomas','2013-06-04',0,60000,'',5033),
	('BC113','Ocean','Lumia','L.David','2018-05-12',2,70000,'',5055),
	('DD105','Animal','Samsumg','K.Elena','2016-02-10',3,30000,'',5011),
	('QE209','The world','Oppo','H.Agolia','2019-07-13',1,70000,'',5011),
	('FF301','Avenger','Banasonic','O.Benki','2001-04-21',2,80000,'',5077),
	('PK88','Ghost Ridger','GL','D.Tina','2020-08-12',4,150000,'',5666);

select*
from book;

insert into borrow_order values
	(1001,'AA103','2020-08-16',null),
	(1005,'PK88','2020-08-16','2020-08-19'),
	(1007,'DD105','2020-08-15',null),
	(1003,'AA103','2020-08-11','2020-08-15'),
	(1008,'DD105','2020-08-10','2020-08-14');

select student.student_number,student_name,student.address,student.email,borrow_order.code_book,
borrow_date,returned_date,book_name, produccer,author
from student
right join borrow_order on student.student_number = borrow_order.student_number
 inner join book on book.code_book = borrow_order.code_book ;
 
 select*
 from student
 left join borrow_order on student.student_number = borrow_order.student_number;