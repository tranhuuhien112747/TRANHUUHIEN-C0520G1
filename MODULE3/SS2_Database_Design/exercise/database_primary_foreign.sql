drop database if exists my_database;
create database my_database;
use my_database;

create table customers (
    customers_number int primary key,
    full_name varchar(255) not null,
    address varchar(255),
    email varchar(255) unique,
    phone varchar(255) unique
);

create table accounts (
    accounts_number int primary key,
    accounts_type varchar(255),
    check (accounts_type = 'Vip'
        or accounts_type = 'Normal'
        or accounts_type = 'Doanh nghiep'),
    date_open date,
    balance double,
    customers_number int,
    foreign key (customers_number)
        references customers (customers_number)
);

create table transactions (
    tran_number int primary key,
    `date` datetime,
    amounts double,
    descriptions varchar(255),
    accounts_number int,
    foreign key (accounts_number)
        references accounts (accounts_number)
);