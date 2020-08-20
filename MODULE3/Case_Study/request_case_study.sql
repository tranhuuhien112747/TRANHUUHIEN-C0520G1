-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select*
from employee
where employee_name like ('h%') or employee_name like ('t%') or employee_name like ('k%') and length(employee_name) <=15;
   
-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select*
from customers
where year(now())-year(birthday) between 18 and 50 and customers.address in('Da Nang','Quang Tri'); 

-- 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
-- 	  Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select count(customers.customer_id) as amount
from customers
	inner join contract on customers.customer_id=contract.customer_id
	where customers.type_id=1;

/* 5.Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong * Gia, với SoLuong và Giá là từ bảng DichVuDiKem)
cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/

select customers.customer_id, customer_name, type_name, contract.contract_id, service_name, contract_date, finished_date,
 (services.rent_fee +accompanied_price * accompanied_unit) as Total
from customers
	left join type_customers on customers.type_id = type_customers.type_id
    left join contract on customers.customer_id = contract.customer_id
    left join services on services.service_id = contract.service_id
    left join contract_details on contract_details_id = contract.contract_id
    left join accompanied_service on accompanied_service.accompanied_service_id = contract_details.accompanied_service_id
    