drop database if exists module3_furama;
create database module3_furama;
use module3_furama;

create table `role` (
	role_id int primary key,
	role_name varchar(45) not null
);

create table `user` (
	username varchar(45) primary key,
	`password` varchar(45)
);

create table user_role (
	role_id int primary key,
	username varchar(45) not null,
	foreign key (role_id) references `role` (role_id) on update cascade on delete cascade,
	foreign key (username) references `user` (username) on update cascade on delete cascade
);

create table position (
	position_id int primary key,
	position_name varchar(45) not null
);

create table division (
	division_id int primary key,
	division_name varchar(45) not null
);	

create table education_degree (
	education_degree_id int primary key,
	education_degree_name varchar(45) not null
);


create table employee (
	employee_id int primary key,
	employee_name varchar(45) not null,
	employee_birthday date not null,
	employee_id_card varchar(45) not null,
	employee_salary double not null,
	employee_phone varchar(45) not null,
	employee_email varchar(45) not null,
	employee_adress varchar(45) not null,
	position_id int not null,
	division_id int not null,
	education_degree_id int not null,
	username varchar(255),
    foreign key (position_id)references position (position_id) on update cascade on delete cascade,
    foreign key (division_id)references division (division_id) on update cascade on delete cascade,
    foreign key (education_degree_id)references education_degree (education_degree_id) on update cascade on delete cascade,
    foreign key (username) references `user`(username) on update cascade on delete cascade
);

create table customer_type (
	customer_type_id int primary key,
	customer_type_name varchar(45) not null
);

create table customer (
	customer_id varchar(45) primary key,
	customer_type_id int not null,
	customer_name varchar(45) not null,
	customer_birthday date not null,
	customer_gender bit not null,
	customer_card varchar(45) not null,
	customer_phone varchar(45) not null,
	customer_email varchar(45) not null,
	customer_address varchar(45) not null,
	foreign key (customer_type_id) references customer_type (customer_type_id) on update cascade on delete cascade
);

create table rent_type (
	rent_type_id int primary key,
	rent_type_name varchar(45) not null,
	rent_type_cost double not null
);

create table service_type (
	service_type_id int primary key,
	service_type_name varchar(45) not null
);

create table service (
	service_id varchar(45) primary key,
	service_name varchar(45) not null,
	service_area int not null,
	service_cost  double not null,
	service_max_people int not null,
	rent_type_id int not null,
	service_type_id int not null,
	standard_room varchar(45) not null,
	description_other varchar(45) not null,
	pool_area double not null,
	number_floor int not null,
	foreign key (rent_type_id) references rent_type (rent_type_id) on update cascade on delete cascade,
	foreign key (service_type_id) references service_type (service_type_id) on update cascade on delete cascade
);

create table attach_service (
	attach_service_id int primary key,
	attach_service_name varchar(45) not null,
	attach_service_cost double not null,
	attach_service_unit int not null,
	attach_service_status varchar(45) not null
);

create table contract (
	contract_id int primary key,
	contract_star_date date not null,
	contract_end_date date not null,
	contract_deposit double not null,
	contract_total_money double not null,
	employee_id int not null,
	customer_id varchar(45) not null,
	service_id varchar(45) not null,
	foreign key (employee_id) references employee (employee_id) on update cascade on delete cascade,
	foreign key (customer_id) references customer (customer_id) on update cascade on delete cascade,
	foreign key (service_id) references service (service_id) on update cascade on delete cascade
);

create table contract_detail (
	contract_detail_id int not null,
	contract_id int,
	attach_service_id int,
	quantity int not null,
	foreign key (contract_id) references contract (contract_id) on update cascade on delete cascade,
	foreign key (attach_service_id) references attach_service (attach_service_id) on update cascade on delete cascade
);


