select customers.customerNumber,city, customerName, phone, paymentDate, amount,country
from customers
inner join payments
on customers.customerNumber = payments.customerNumber
where city = 'Madrid'or city = 'Milan';

select*from orders;

select customers.customerNumber, customerName, phone, paymentDate, amount 
from customers
inner join payments
on customers.customerNumber = payments.customerNumber
where city = 'Las Vegas';

select customers.customerNumber, customerName, orderNumber, orders.status, orderDate, shippedDate
from customers
left join orders
on customers.customerNumber = orders.customerNumber ;

select customers.customerNumber, customers.customerName, orders.orderNumber, orders.status
from customers LEFT JOIN orders
on customers.customerNumber = orders.customerNumber
where orderNumber is null