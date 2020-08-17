drop database if exists my_database;
create database my_database;
use my_database;

create table offices(
office_code varchar(10) not null primary key,
phone varchar(50) not null,
address_line1 varchar(50) not null,
address_line2 varchar(50),
city varchar(50) not null,
state varchar(50) not null,
postal_code varchar(15) not null,
country  varchar(50) not null
);

create table employees(
employee_number int not null primary key,
last_name varchar(50) not null,
first_name varchar(50) not null,
email varchar(100) not null,
job_title varchar(50) not null,
report_to int,
office_code varchar(10) not null,
foreign key(report_to)references employees(employee_number),
foreign key(office_code)references offices(office_code)
);

create table customers(
customer_number int primary key not null,
customer_name varchar(255) not null,
contact_last_name varchar(50) not null,
contact_first_name varchar(50) not null,
phone varchar(50) not null,
address_line1 varchar(50) not null,
address_line2 varchar(50),
city varchar(50) not null,
state varchar(50) not null,
postal_code varchar(15) not null,
country  varchar(50) not null,
credit_limit double,
sales_rep_Employee_number int  not null,
foreign key(sales_rep_Employee_number)references employees(employee_number)
);

create table products_line(
product_line varchar(50) not null primary key,
text_description varchar(255),
image varchar(255)
);

create table products(
product_code varchar(15) not null primary key,
product_name varchar(70) not null,
product_scale varchar(10) not null,
product_vendor varchar(50) not null,
product_description text not null,
quantity_inStock int not null,
buy_price double not null,
MSRP double not null,
product_line varchar(50) not null,
foreign key(product_line)references products_line(product_line)
);

create table orders(
order_number int primary key not null,
order_date date not null,
required_date date not null,
shipped_date date,
`status` varchar(15) not null,
comments text,
quantity_Ordered int not null,
price_Each double not null,
customer_number int not null,
foreign key(customer_number) references customers(customer_number)
);

create table payments(
customer_number int  not null,
check_number varchar(50) not null,
payment_Date date not null,
amount double not null,
foreign key(customer_number)references customers(customer_number)
);


create table order_Details(
order_number int not null ,
product_code varchar(15) not null,
foreign key(product_code)references products(product_code),
foreign key(order_number)references orders(order_number)
);

