drop database if  exists my_database;
create database my_database;
use my_database;

create table product(
	id int not null primary key,
    product_code int not null,
    product_name varchar(255),
    product_price double not null,
    product_amount int not null,
    product_description varchar(255),
    product_status varchar(255)
    );
    
    -- chen du lieu cho table product.
    insert into product values
    (1,112,'nokia',5000000,10,'black','99%'),
    (2,152,'sony',5000000,7,'black','99%'),
    (3,172,'samsumg',5000000,5,'black','99%'),
    (4,192,'iphone',5000000,4,'black','99%'),
    (5,102,'oppo',5000000,3,'black','99%');
    
   -- 1. tao chi muc cho cot product_code.
alter table product
add index index_code(product_code);
    
alter table product
add index name_price(product_name,product_price);

explain select*
from product;

-- 2. tao view.

create or replace view showinformation 
as
select id,product_code, product_name, product_price, product_amount, product_description,
 product_status 
 from product ;
 -- sua view
 create or replace view showinformation 
as
select id,product_code, product_name, product_price
 from product ;
 
 drop view showinformation;
 
 -- 3.tao procedure
 delimiter $$
 create procedure showinfor()
 begin
	select*
    from product;
end; $$
delimiter ;  

call showinfor();

-- tao moi san pham
delimiter $$
drop procedure if exists add_new_product;
 create procedure add_new_product()
 begin
	insert into my_database.product values
		(8,199,'samsumg',5000000,20,'red','99%');
end; $$
delimiter ;  

call add_new_product();

-- edit name product theo id
delimiter $$
drop procedure if exists edit_product;
create procedure edit_product(in id int ,in product_name varchar(255))
begin
	update my_database.product
    set product.product_name = product_name
    where product.id = id;
end; $$
delimiter $$

call edit_product(3,'maxbooks');
select*from product;

-- xoa product theo id
delimiter $$
drop procedure if exists delete_product;
create procedure delete_product(in id int)
begin
	delete
    from my_database.product
    where product.id = id;
end; $$
delimiter $$

call delete_product(3);
select*from product;
