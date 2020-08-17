drop database if exists database_table;
create database database_table;
use database_table;

create table contacts( 
contact_id int not null,
id int not null,
last_name varchar(30) not null,
first_name varchar(25),
birthday date
);

create table suppliers
( supplier_id int(11) not null auto_increment,
  supplier_name varchar(50) not null,
  account_rep varchar(30) not null default 'TBD',
  primary key (supplier_id)
);
alter table contacts
add primary key(contact_id,id); 

