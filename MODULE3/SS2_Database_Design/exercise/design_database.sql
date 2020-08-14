drop database if exists my_database;
create database my_database;
use my_database;

create table offices(
officeCode varchar(10) not null primary key,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50),
city varchar(50) not null,
state varchar(50) not null,
postalCode varchar(15) not null,
country  varchar(50) not null
);

create table employees(
employeeNumber int not null primary key,
lastName varchar(50) not null,
firstName varchar(50) not null,
email varchar(100) not null,
jobTitle varchar(50) not null,
reportTo int,
officeCode varchar(10) not null,
foreign key(reportTo)references employees(employeeNumber),
foreign key(officeCode)references offices(officeCode)
);

create table customers(
customerNumber int primary key not null,
customerName varchar(255) not null,
contactLastName varchar(50) not null,
contactFirstName varchar(50) not null,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50),
city varchar(50) not null,
state varchar(50) not null,
postalCode varchar(15) not null,
country  varchar(50) not null,
creditLimit double,
salesRepEmployeeNumber int  not null,
foreign key(salesRepEmployeeNumber)references employees(employeeNumber)
);

create table productsLine(
productLine varchar(50) not null primary key,
textDescription varchar(255),
image varchar(255)
);

create table products(
productCode varchar(15) not null primary key,
productName varchar(70) not null,
productScale varchar(10) not null,
productVendor varchar(50) not null,
productDescription text not null,
quantityInStock int not null,
buyPrice double not null,
MSRP double not null,
productLine varchar(50) not null,
foreign key(productLine)references productsLine(productLine)
);

create table orders(
orderNumber int primary key not null,
orderDate date not null,
requiredDate date not null,
shippedDate date,
`status` varchar(15) not null,
comments text,
quantityOrdered int not null,
priceEach double not null,
customerNumber int not null,
foreign key(customerNumber) references customers(customerNumber)
);

create table payments(
customerNumber int  not null,
checkNumber varchar(50) not null,
paymentDate date not null,
amount double not null,
foreign key(customerNumber)references customers(customerNumber)
);


create table orderDetails(
orderNumber int not null ,
productCode varchar(15) not null,
foreign key(productCode)references products(productCode),
foreign key(orderNumber)references orders(orderNumber)
);

