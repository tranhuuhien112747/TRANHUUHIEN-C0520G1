drop database if exists my_database;
create database my_database;
use my_database;

create table customers(
   id int auto_increment,
   code_id int not null,
   `name` varchar(40),
   address varchar(255),
   email varchar(255),
   primary key (id)
);

create table orders(
   id int auto_increment,
   staff varchar(50),
   primary key(id),
   customer_id int,
   foreign key (customer_id) references customers(id)
);

alter table customers
add foreign key(code_id)references orders(id);