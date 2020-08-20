drop database if exists case_study_furama;
create database case_study_furama;
use case_study_furama;

-- tao bang trinh do nhan vien.
create table level_employee(
	level_id int not null primary key,
    level_name varchar(70) not null
	);
    
-- tao bang vi tri nhan vien.
create table  position_employee(
   position_id int not null primary key,
   position_name  varchar(70) not null
   );
   
-- tao bang bo phan nhan vien
create table division(
	division_id int not null primary key,
    division_name  varchar(70) not null
    );
    
-- tao bang loai khach
create table type_customers(
	type_id int primary key,
    type_name varchar(50) not null
    );
-- tao bang employee.
create table employee(
	employee_id int primary key,
    employee_name varchar(50) not null,
    position_id int not null,
    level_id int not null,
    division_id int not null,
    birthday date not null,
    id_card varchar(50) not null,
    salary varchar(50) not null ,
    phone varchar(50) not null,
    email varchar(50) not null ,
    address varchar(50) not null,
    foreign key(position_id) references position_employee(position_id),
    foreign key(level_id) references level_employee(level_id),
    foreign key(division_id) references division(division_id)
    );
    
-- tao bang khach hang
create table customers(
	customer_id int primary key,
    type_id int,
    customer_name varchar(50) not null,
    birthday date not null,
    id_number varchar(50) not null,
    phone varchar(50) not null,
    email varchar(50) not null ,
    address varchar(50) not null,
    foreign key(type_id) references type_customers(type_id)
    );
    
    -- tao bang loai dich vu
create table type_services(
	service_type_id int primary key,
    service_type_name varchar(45) not null
    );
    
    -- tao bang kieu thue
    create table type_of_rent(
		 rent_type_id int primary key,
         rent_type_name varchar(45) not null
         );
    
-- tao bang dich vu
create table services(
	service_id int primary key,
    service_name varchar(45) not null,
    area int not null default 50,
    story_number int not null,
    max_people varchar(45) not null,
    rent_fee  varchar(45) not null,
    rent_type_id int,
    service_type_id int,
    service_status varchar(45) not null,
    foreign key(rent_type_id) references type_of_rent(rent_type_id),
    foreign key(service_type_id) references type_services(service_type_id)
    );
    
     -- tao bang dich vu di kem. 
create table accompanied_service(
	accompanied_service_id int primary key,
    accompanied_service_name varchar(45) not null,
    accompanied_price double not null,
    accompanied_unit varchar(50) not null,
    accompanied_status varchar(50) not null
    );
    
    -- tao bang hop dong.
create table contract(
	contract_id int primary key,
    employee_id int not null,
    customer_id int not null,
	service_id int not null,
    contract_date date not null ,
    finished_date date not null,
    prepaid_amount int not null ,
    total_amount int not null,
    foreign key(employee_id) references employee(employee_id),
    foreign key(customer_id) references customers(customer_id),
    foreign key(service_id) references services(service_id)
    );
    
-- tao bang hop dong chi tiet
    create table contract_details(
		contract_details_id int primary key,
        contract_id int not null,
		contract_details_name varchar(45) not null,
        accompanied_service_id int,
        amount int not null,
        foreign key(accompanied_service_id) references accompanied_service(accompanied_service_id),
        foreign key(contract_id) references contract(contract_id )
        );


    
		
		