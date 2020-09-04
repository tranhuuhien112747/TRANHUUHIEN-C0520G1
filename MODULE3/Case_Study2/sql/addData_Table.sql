use module3_furama;

/* Thêm data cho bảng vị trí.*/
insert into position 
values
	(1,'Receptionist'),
	(2,'Serve'),
	(3,'Professional'),
	(4,'Monitoring'),
	(5,'Manager'),
	(6,'President');

-- Thêm data trình độ nhân viên.
insert into education_degree
values
	(1,'Intermediate'),
	(2,'Colleges'),
	(3,'University'),
	(4,'After university');
    
-- thêm data cho bộ phân nhân viên.
insert into division 
values
(1,'Sale – Marketing'),
(2,'Administration'),
(3,'Serve'),
(4,'Manager');   

-- thêm nhân viên.
insert into employee
values
	(1001,'David','1995-12-03',225693564,6000,0987566354,'david@gmail.com','Da Nang',1,2,3,null),
	(1002,'Thomas','1993-07-16',225968564,5000,0569845631,'thomas@gmail.com','Ha Noi',2,3,4,null),
	(1003,'Elena','1998-03-21',221789464,4000,0985639847,'elena657@gmail.com','Quang Binh',3,4,2,null),
	(1004,'Tom','1988-05-13',221012394,7000,0968569536,'tom666@gmail.com','Da Nang',2,4,3,null),
	(1005,'Jesmy','1992-01-13',221995464,4000,0789563598,'jesmy090@gmail.com','Hue',3,3,3,null),
	(1006,'Aladin','1990-11-03',221954269,6000,0569325895,'bababa090@gmail.com','Quang Nam',2,1,3,null),
	(1007,'Beecia','1997-05-11',221978956,5000,0658954563,'cuccoc090@gmail.com','Hue',1,2,3,null),
	(1008,'Maicon','1993-02-23',221936256,5500,0563258956,'mimimi090@gmail.com','Quang Binh',2,4,2,null),
	(1009,'Thor','1989-12-13',221966958,4500,0958456324,'kuikids090@gmail.com','Da Nang',1,2,2,null),
	(1010,'Jack','1988-10-09',221933625,4000,0689547856,'uyuyuyu090@gmail.com','Quang Nam',1,1,2,null); 

-- thêm loại khách hàng. 
insert into customer_type
values
	(1,'Diamond'),
	(2,'Platinium'),
	(3,'Gold'),
	(4,'Silver'),
	(5,'Member');

-- thêm khách hàng.
insert into customer
 values
	(101,1,'Hien','1996-04-04','male',221451452,0326589536,'abcde@gmail.com','Phu Yen'),
	(102,2,'Tung','1993-04-21','male',221436259,0399685478,'112jkhd@gmail.com','Da Nang'),
	(103,3,'Toan','1992-07-08','male',221498458,0355895698,'76yujhf@gmail.com','Hue'),
	(104,1,'Chuong','1989-12-23','male',221499658,0366958451,'99oikl@gmail.com','Ha Noi'),
	(105,2,'Nhat','2000-04-16','male',221433362,0355262589,'87huhs@gmail.com','Hue'),
	(106,1,'Khanh','1991-12-04','male',221466695,0333695847,'76yujk@gmail.com','Da Nang'),
	(107,2,'Hai','1994-09-15','male',221488478,0364587956,'11hkskss@gmail.com','Quang Tri'),
	(108,4,'Hoang','1996-04-17','male',221466625,0312365968,'tttsasd@gmail.com','Hue'),
	(109,1,'Quang','1996-06-03','male',221488874,0365968563,'oipkuhyt@gmail.com','Nghe An'),
	(110,2,'Tra','1995-04-21','male',221499985,0364521562,'azxzxzxe@gmail.com','Phu Yen'),   
	(111,3,'Quynh','1996-11-02','female',221477775,0364536259,'bnbnght@gmail.com','Quang Tri'),    
	(112,3,'Hoa','1994-12-06','female',221489569,0364536259,'bnbnght@gmail.com','Vinh');    
    
-- thêm kiểu thuê.
insert into rent_type 
values
	(1,'Day',1000),
    (2,'week',5000),
    (3,'Month',20000),
    (4,'Year',50000),
    (5,'Hours',500); 

-- thêm loại dịch vụ.
insert into service_type 
values
		(1,'Villa'),
        (2,'House'),
        (3,'Room'); 
 
 -- thêm dịch vụ
 insert into service
 values
	 (1,'Villa City',800,1500,10,2,1,'Vip','Not',100,3),
	 (2,'Da House',700,1000,10,3,1,'Normal','Not',90,2),
	 (3,'House City',700,1200,10,1,2,'Normal','Not',90,3),
	 (4,'Villa Home',650,900,10,4,2,'Vip','Not',70,2),
	 (5,'Villa Happy',1000,2000,10,1,2,'Vip','Not',120,4);
 
 -- thêm dịch vụ đi kèm.
 insert into attach_service
 values
	(1,'Massage', 200, 20, 'Available'),
	(2,'Karaoke', 150, 30, 'Available'),
	(3,'Food', 30, 10, 'Available'),
	(4,'Drink', 15, 10, 'Available'),
	(5,'Car', 200, 15, 'Available');
    
-- thêm hợp đồng.
insert into contract
values   
(1,'2019-03-02','2019-04-02',200,1000,1001,101,1), 
(2,'2019-06-11','2019-07-02',500,5000,1003,101,1) ,
(3,'2019-08-02','2019-09-02',400,6000,1004,104,2) ,
(4,'2019-11-11','2019-12-11',200,800,1002,106,1) ,
(5,'2018-03-02','2018-04-02',200,1000,1006,103,2) ,
(6,'2018-01-23','2019-02-02',200,8000,1009,101,1) ,
(7,'2016-07-02','2016-08-02',200,1000,1005,102,3) ,
(8,'2019-05-04','2019-07-04',1200,6000,1001,107,2) ,
(9,'2017-09-12','2017-10-02',200,1000,1008,103,1) ,
(10,'2019-01-02','2019-02-02',200,1000,1007,102,2) ,
(11,'2019-04-02','2019-05-02',200,1000,1001,105,2) ;

-- thêm hợp đồng chi tiết.
insert into contract_detail
values
	(1,1,1,3),
	(2,2,2,2),
	(3,3,1,3),
	(4,4,2,4),
	(5,5,3,2),
	(6,6,2,4),
	(7,7,4,2),
	(8,8,2,3),
	(10,10,1,4),
	(11,11,1,3);
    
 select*from contract_detail