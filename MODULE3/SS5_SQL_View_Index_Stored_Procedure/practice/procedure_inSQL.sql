use classicmodels;

delimiter //
create procedure getCusByid
(in cusNum int(11))
begin
	select*
	from customers
	where customerNumber=cusNum;
end //
delimiter ;

call getCusByid(175);

delimiter //
create procedure getCuscountByCity
(in in_city varchar(50),out total int)
begin
	select count(customers.customerNumber)
    into total
    from customers
    where city=in_city;
    end //
    delimiter ;
    
    select customers.city
    from customers ;
    call getCuscountByCity('Madrid',@total);
    select@total