use classicmodels;
select*
from customers;

explain select* 
from customers
where customerNumber = 175;

ALTER TABLE customers 
ADD INDEX idx_customerNumber(customerNumber);

EXPLAIN SELECT*
FROM customers
WHERE customerNumber = 175;