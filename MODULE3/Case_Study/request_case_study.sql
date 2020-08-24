-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select*
from employee
where employee_name like ('h%') or employee_name like ('t%') or employee_name like ('k%') and length(employee_name) <= 15;
   
-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select*
from customers
where year(now())-year(birthday) between 18 and 50 and customers.address in('Da Nang','Quang Tri'); 

-- 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
-- 	  Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select customers.customer_id, customer_name ,type_customers.type_name, count(customers.customer_id) as amount
from contract
	inner join customers on customers.customer_id=contract.customer_id
    inner join type_customers on type_customers.type_id=customers.type_id
	where customers.type_id = 1
    group by customers.customer_name
    order by count(contract.customer_id) asc ;

/* 5. Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong * Gia, với SoLuong và Giá là từ bảng DichVuDiKem)
cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/
select customers.customer_id, customer_name, type_name, contract.contract_id, service_name, contract_date, finished_date,
 (rent_fee + accompanied_price*accompanied_unit) as Total
from customers
	left join contract on customers.customer_id = contract.customer_id
	left join type_customers on customers.type_id = type_customers.type_id
    left join services on services.service_id = contract.service_id
    left join contract_details on contract_details.contract_id = contract.contract_id
    left join accompanied_service on accompanied_service.accompanied_service_id = contract_details.accompanied_service_id;

/* 6. Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được 
	Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).*/
select services.service_id, services.service_name, services.area ,services.rent_fee,type_services.service_type_name
from services
	left join type_services on type_services.service_type_id=services.service_type_id
    left join contract on contract.service_id = services.service_id
    where not (month(contract_date) in (1,2,3) and year(contract_date) = 2019) or contract_date is null 
    group by services.service_name;

/* 7. Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã từng được
	Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019. */
select services.service_id, services.service_name, services.area ,services.max_people, services.rent_fee,type_services.service_type_name
from services
	left join type_services on type_services.service_type_id=services.service_type_id
    left join contract on contract.service_id = services.service_id
    where  year(contract_date) = 2018 and services.service_id not in (
		select service_id
        from contract
        where year(contract_date) = 2019
    )
    group by services.service_name;

/* 8. Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
	Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên */
-- cách 1 :    
select distinct customers.customer_name
from customers ;

-- cách 2:
select customers.customer_name
from customers
group by customer_name ;

/* 9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong 
	năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.*/


/* 10. Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
	 Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
	 (được tính dựa trên việc count các IDHopDongChiTiet). */

/* 11. Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang 
	là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.   */
select accompanied_service.accompanied_service_id, accompanied_service_name, accompanied_price, accompanied_unit, customers.customer_id,
customer_name, type_customers.type_name
from accompanied_service
	left join contract_details on contract_details.accompanied_service_id = accompanied_service.accompanied_service_id
	left join contract on contract.contract_id = contract_details.contract_id
	left join customers on contract.customer_id = customers.customer_id
	left join type_customers on type_customers.type_id = customers.type_id
	where customers.type_id = 1 and customers.address = 'Vinh' or customers.address = 'Quang Ngai';
    
/*12. Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
	(được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào
    3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.*/
select contract.contract_id, employee_name , customer_name, customers.phone, service_name,contract_details.amount,
prepaid_amount
from contract
	inner join employee on employee.employee_id = contract.employee_id
    inner join customers on customers.customer_id = contract.customer_id
    inner join contract_details on contract_details.contract_id = contract.contract_id
    inner join services on services.service_id = contract.service_id
    where (month(contract_date) in (10,11,12) and year(contract_date) = 2019) and services.service_id not in (
		select service_id
        from contract
        where month(contract_date) in (1,2,3,4,5,6)
    )
    group by services.service_name;
    
/*13. Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
	(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau). */
select accompanied_service.accompanied_service_id, accompanied_service_name ,accompanied_price,
		accompanied_unit,count(contract_details.amount) as count_amount
from accompanied_service
	left join contract_details on accompanied_service.accompanied_service_id = contract_details.accompanied_service_id
    inner join contract on contract.contract_id = contract_details.contract_id
    group by accompanied_service_name ;

/*14. Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
	Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.*/
select contract.contract_id ,type_services.service_type_name, accompanied_service.accompanied_service_name,
 count(contract_details.amount) as SoLanSuDung
from accompanied_service
	inner join contract_details on contract_details.accompanied_service_id = accompanied_service.accompanied_service_id
    inner join contract on contract.contract_id = contract_details.contract_id
    inner join services on services.service_id =contract.service_id
    inner join type_services on type_services.service_type_id = services.service_type_id
    group by accompanied_service.accompanied_service_name
    having SoLanSuDung = 1 ;

/*15. Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan,
	SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019. */

/*16. Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019. */

/*17. Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
	chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.*/     

/*18. Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng). */

/* 19. Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi. */

/* 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm ID 
(IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.*/  