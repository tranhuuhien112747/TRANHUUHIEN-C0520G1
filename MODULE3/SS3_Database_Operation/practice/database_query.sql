use classicmodels;
select productCode, productName, buyprice, quantityInStock
from products
where buyprice > 56.76 and quantityInStock > 10;

select productCode,productName, buyprice, textDescription
from products
inner join productlines
on products.productline = productlines.productline
where buyprice > 56.76 and buyprice < 95.59;

select*from products,productlines;

select*
from products
join productlines on productlines.productLine=products.productLine
where productVendor='Red Start Diecast';

select*
from products
join productlines on productlines.productLine=products.productLine
where productVendor='Red Start Diecast'and buyPrice > 40; 

select*
from products
join productlines on productlines.productLine=products.productLine
where productVendor='Red Start Diecast' or productVendor='Min Lin Diecast'; 