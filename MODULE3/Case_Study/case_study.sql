drop database if exists case_study_furama;
create database case_study_furama;
use case_study_furama;

-- tao bang trinh do nhan vien.
create table level_employee (
    level_id int not null primary key,
    level_name varchar(70) not null,
    check (level_name = 'Tung Cap'
        or level_name = 'Cao Dang'
        or level_name = 'Dai Hoc'
        or level_name = 'Sau Dai hoc')
);
    
-- tao bang vi tri nhan vien.
create table position_employee (
    position_id int not null primary key,
    position_name varchar(70) not null,
    check (position_name = 'Le Tan'
        or position_name = 'Phuc vu'
        or position_name = 'Chuyen vien'
        or position_name = 'Giam sat'
        or position_name = 'Quan ly'
        or position_name = 'Giam doc')
);
   
-- tao bang bo phan nhan vien
create table division (
    division_id int not null primary key,
    division_name varchar(70) not null,
    check (division_name = 'Sale – Marketing'
        or division_name = 'Hanh Chinh'
        or division_name = 'Phuc Vu'
        or division_name = 'Quan Li')
);
    
-- tao bang loai khach
create table type_customers (
    type_id int primary key,
    type_name varchar(50) not null,
    check (type_name = 'Diamond'
        or type_name = 'Platinium'
        or type_name = 'Gold'
        or type_name = 'Silver'
        or type_name = 'Member')
);
-- tao bang employee.
create table employee (
    employee_id int primary key,
    employee_name varchar(50) not null,
    position_id int not null,
    level_id int not null,
    division_id int not null,
    birthday date not null,
    id_card varchar(50) not null,
    salary varchar(50) not null,
    phone varchar(50) not null,
    email varchar(50) not null,
    address varchar(50) not null,
    foreign key (position_id) references position_employee (position_id),
    foreign key (level_id) references level_employee (level_id),
    foreign key (division_id) references division (division_id)
);
    
-- tao bang khach hang
create table customers (
    customer_id int primary key,
    type_id int,
    customer_name varchar(50) not null,
    birthday date not null,
    id_number varchar(50) not null,
    phone varchar(50) not null,
    email varchar(50) not null,
    address varchar(50) not null,
    foreign key (type_id) references type_customers (type_id)
);
    
    -- tao bang loai dich vu
create table type_services (
    service_type_id int primary key,
    service_type_name varchar(45) not null,
    check (service_type_name = 'Villa'
        or service_type_name = 'House'
        or service_type_name = 'Room')
);
    
    -- tao bang kieu thue
create table type_of_rent (
    rent_type_id int primary key,
    rent_type_name varchar(45) not null,
    rent_type_price double not null
);
    
-- tao bang dich vu
create table services (
    service_id varchar(50) primary key,
    service_name varchar(45) not null,
    area int not null default 50,
    story_number int not null,
    max_people varchar(45) not null,
    rent_fee double not null,
    rent_type_id int,
    service_type_id int,
    service_status varchar(45) not null,
    foreign key (rent_type_id) references type_of_rent (rent_type_id),
    foreign key (service_type_id) references type_services (service_type_id)
);

     -- tao bang dich vu di kem. 
create table accompanied_service (
    accompanied_service_id int primary key,
    accompanied_service_name varchar(45) not null,
    accompanied_price double not null,
    accompanied_unit int not null,
    check (accompanied_service_name = 'massage'
        or accompanied_service_name = 'karaoke'
        or accompanied_service_name = 'food'
        or accompanied_service_name = 'car rental')
);

    -- tao bang hop dong.
create table contract (
    contract_id int primary key,
    employee_id int not null,
    customer_id int not null,
    service_id varchar(50) not null,
    contract_date date not null,
    finished_date date not null,
    prepaid_amount int not null,
    total_amount int not null,
    foreign key (employee_id) references employee (employee_id) on delete cascade,
    foreign key (customer_id) references customers (customer_id) on delete cascade,
    foreign key (service_id) references services (service_id)
);

-- tao bang hop dong chi tiet
create table contract_details (
    contract_details_id int primary key,
    contract_id int not null,
    contract_details_name varchar(45) not null,
    accompanied_service_id int,
    amount int not null,
    foreign key (accompanied_service_id) references accompanied_service (accompanied_service_id),
    foreign key (contract_id) references contract (contract_id)
);

-- 1. Thêm dữ liệu cho tất cả các bảng
-- * Trình độ nhân viên.
insert into level_employee values 
	(1,'Tung Cap'),
	(2,'Cao Dang'),
	(3,'Dai Hoc'),
	(4,'Sau Dai hoc');
 
-- * Vị trí Nhân Viên.
insert into position_employee values
	(1,'Le Tan'),
	(2,'Phuc vu'),
	(3,'Chuyen vien'),
	(4,'Giam sat'),
	(5,'Quan ly'),
	(6,'Giam doc');

-- *Bộ phận làm việc.
insert into division values
	(1,'Sale – Marketing'),
	(2, 'Hanh Chinh'),
    (3,'Phuc Vu'),
    (4,'Quan Li');
	
-- *Loại Khách hàng.
insert into type_customers values
	(1,'Diamond'),
	(2,'Platinium'),
	(3,'Gold'),
	(4,'Silver'),
	(5,'Member');
    
-- * Nhân viên.
insert into employee values
	(1001,'David',1,2,3,'1995-12-03',225693564,6000,0987566354,'david@gmail.com','Da Nang'),
	(1003,'Thomas',2,3,4,'1993-07-16',225968564,5000,0569845631,'thomas@gmail.com','Ha Noi'),
	(1006,'Elena',3,3,2,'1998-03-21',221789464,4000,0985639847,'elena657@gmail.com','Quang Binh'),
	(1011,'Tom',2,4,3,'1988-05-13',221012394,7000,0968569536,'tom666@gmail.com','Da Nang'),
	(1002,'Jesmy',3,3,3,'1992-01-13',221995464,4000,0789563598,'jesmy090@gmail.com','Hue'),
	(1004,'Aladin',2,1,3,'1990-11-03',221954269,6000,0569325895,'bababa090@gmail.com','Quang Nam'),
	(1021,'Beecia',1,2,3,'1997-05-11',221978956,5000,0658954563,'cuccoc090@gmail.com','Hue'),
	(1020,'Maicon',2,2,2,'1993-02-23',221936256,5500,0563258956,'mimimi090@gmail.com','Quang Binh'),
	(1014,'Thor',1,2,2,'1989-12-13',221966958,4500,0958456324,'kuikids090@gmail.com','Da Nang'),
	(1023,'Jack',1,1,2,'1988-10-09',221933625,4000,0689547856,'uyuyuyu090@gmail.com','Quang Nam');

-- * Khách hàng.
insert into customers values
	(101,1,'Hien','1996-04-04',221451452,0326589536,'abcde@gmail.com','Phu Yen'),
	(102,2,'Tung','1993-04-21',221436259,0399685478,'112jkhd@gmail.com','Da Nang'),
	(104,3,'Toan','1992-07-08',221498458,0355895698,'76yujhf@gmail.com','Hue'),
	(106,1,'Chuong','1989-12-23',221499658,0366958451,'99oikl@gmail.com','Ha Noi'),
	(108,2,'Nhat','2000-04-16',221433362,0355262589,'87huhs@gmail.com','Hue'),
	(111,1,'Khanh','1991-12-04',221466695,0333695847,'76yujk@gmail.com','Da Nang'),
	(107,2,'Hai','1994-09-15',221488478,0364587956,'11hkskss@gmail.com','Quang Tri'),
	(105,4,'Hoang','1996-04-17',221466625,0312365968,'tttsasd@gmail.com','Hue'),
	(120,1,'Quang','1996-06-03',221488874,0365968563,'oipkuhyt@gmail.com','Nghe An'),
	(115,2,'Tra','1995-04-21',221499985,0364521562,'azxzxzxe@gmail.com','Phu Yen');
    
-- * Loại Dịch Vụ
insert into type_services values
		(1,'Villa'),
        (2,'House'),
        (3,'Room');
-- * Kiểu thuê.
insert into type_of_rent values
	(1,'Day',1000),
    (2,'week',5000),
    (3,'Month',20000),
    (4,'Year',50000),
    (5,'Hours',500);
    
-- * Dịch vụ.
insert into services values
	('SVVL-001','Villa City',1000,4,6,5000,1,1,'normal'),
	('SVVL-007','Villa Happy',900,4,6,4000,2,1,'normal'),
	('SVHO-011','Da House',500,3,3,1000,1,2,'normal'),
	('SVHO-010','House City',500,4,3,100,1,2,'normal'),
	('SVVL-111','Villa Home',1000,4,6,5000,1,1,'normal'),
	('SVRO-013','Bed Room',90,2,2,3000,1,3,'normal');
    
-- * Dịch vụ Đi kèm.
insert into accompanied_service values
	(1,'massage',50,10),
    (2,'karaoke',100,15),
    (3,'food',100,20),
    (4,'car rental',100,20); 
    
-- * Hợp đồng.
insert into contract values
	(11,1001,101,'SVVL-001','2019-08-11','2019-08-17',2000,15000),    
	(12,1002,105,'SVVL-001','2018-07-10','2018-07-13',2000,5000),    
	(21,1006,104,'SVHO-011','2019-04-11','2019-04-16',3000,8000),   
	(13,1006,104,'SVHO-011','2019-11-11','2019-11-16',3000,8000),   
	(14,1011,108,'SVRO-013','2019-03-11','2019-03-15',2000,15000),    
	(15,1021,106,'SVHO-010','2018-05-07','2018-08-10',4000,6000),    
	(16,1020,120,'SVVL-007','2016-09-01','2016-09-15',2000,6000),
	(17,1020,111,'SVVL-111','2019-06-10','2019-07-13',2000,16000),
	(18,1020,107,'SVHO-011','2017-07-14','2017-08-12',2000,6000),
	(19,1020,115,'SVVL-007','2020-03-15','2020-05-11',2000,6000),
	(20,1004,115,'SVRO-013','2019-10-15','2019-10-22',2000,11000),
	(22,1014,101,'SVVL-001','2018-07-15','2018-10-22',2000,6000),
	(23,1004,111,'SVRO-013','2017-01-15','2017-02-22',2000,11000),
    (24,1006,120,'SVVL-007','2016-09-01','2016-09-15',2000,6000);

-- * Hợp đồng chi tiết.
insert into contract_details values
	(1,11,'Cho thue p01',1, 1),
	(2,13,'Cho thue o03',2, 1),
	(3,14,'Cho thue k06',3, 1),
	(4,12,'Cho thue h11',4, 1),
	(5,15,'Cho thue g15',1, 1),
	(6,16,'Cho thue f77',1, 1),
	(7,17,'Cho thue s32',2, 1),
	(8,18,'Cho thue d55',1, 1),
	(9,21,'Cho thue a44',1, 1),
	(10,20,'Cho thue a33',1, 1),
	(11,19,'Cho thue y15',1, 1),
	(12,22,'Cho thue ZZ18',1, 1),
	(13,23,'Cho thue AB67',1, 1),
	(14,24,'Cho thue QE34',1, 1);
    
    