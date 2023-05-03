
create database QuanLyThuoc
go
use QuanLyThuoc
go

--Tài Khoản
create table TaiKhoan(
	maTK nvarchar(10) primary key not null,
	tenTK nvarchar(30),
	loaiTK nvarchar(30),
	matKhau nvarchar(50)
)
--Thêm data vào table Tài Khoản
INSERT INTO TaiKhoan (maTK, tenTK, loaiTK, matKhau) VALUES
('TK001', 'ThuyKieu', 'basic', 'password1'),
('TK002', 'ThanhNhan', 'basic', 'password2'),
('TK003', 'DuyKhang', 'basic', 'password3'),
('TK004', 'LePhu', 'basic', 'password4');



--Nhân Viên
create table NhanVien(
	maNV nvarchar(10) primary key not null,
	hoNV nvarchar(20),
	tenNV nvarchar(20),
	tuoiNV int,
	soDT char(12),
	gioiTinh bit,
	maTK nvarchar(10) REFERENCES TaiKhoan(maTK) on delete cascade on update cascade,
	diaChi nvarchar(100)
)
--Thêm data vào table Nhân Viên
INSERT INTO NhanVien (maNV, hoNV, tenNV, tuoiNV, soDT, gioiTinh, maTK, diaChi) VALUES
('NV001', N'Lê Thị Thúy', N'Kiều', 23, '0987654321', 0, 'TK001', N'Hà Nội'),
('NV002', N'Nguyễn Thành', N'Nhân', 29, '0981234567', 1, 'TK002', N'Hồ Chí Minh'),
('NV003', N'Lê Nguyễn Duy', N'Khang', 25, '0977123456', 1, 'TK003', N'Đà Nẵng'),
('NV004', N'Tạ Lê', N'Phú', 27, '0987123456', 1, 'TK004', N'Nghệ An');



--Khách Hàng
create table KhachHang(
	maKH nvarchar(10) primary key not null ,
	hoKH nvarchar(20),
	tenKH nvarchar(20),
	soDT char(12),
	ngaySinh date,
	gioiTinh bit,
	diaChi nvarchar(100)
)
--Thêm data vào table Khách Hàng
INSERT INTO KhachHang (maKH, hoKH, tenKH, soDT, ngaySinh, gioiTinh, diaChi) VALUES
('KH001', N'Nguyễn', N'Anh', '0123456789', '1998-05-20', 0, N'123 Đường ABC, Quận XYZ, TP. HCM'),
('KH002', N'Trần', N'Bình', '0987654321', '1991-12-02', 1, N'456 Đường DEF, Quận GHI, TP. HCM'),
('KH003', N'Lê', N'Cường', '0123456789', '1996-03-10', 1, N'789 Đường GHI, Quận JKL, TP. HCM'),
('KH004', N'Phạm', N'Dương', '0987654321', '2001-07-15', 0, N'012 Đường KLM, Quận NOP, TP. HCM'),
('KH005', N'Hoàng', N'Đức', '0123456789', '1988-09-01', 1, N'345 Đường PQR, Quận STU, TP. HCM'),
('KH006', N'Vũ', N'Hiếu', '0987654321', '1995-11-28', 0, N'678 Đường VWX, Quận YZ, TP. HCM'),
('KH007', N'Nguyễn', N'Khoa', '0123456789', '1994-02-12', 1, N'901 Đường XYZ, Quận ABC, TP. HCM'),
('KH008', N'Trần', N'Linh', '0987654321', '1993-06-07', 0, N'234 Đường DEF, Quận GHI, TP. HCM'),
('KH009', N'Lê', N'Minh', '0123456789', '1997-09-20', 1, N'567 Đường GHI, Quận JKL, TP. HCM'),
('KH010', N'Phạm', N'Nam', '0987654321', '1992-04-30', 0, N'890 Đường KLM, Quận NOP, TP. HCM');



--Nhà cung cấp
create table NhaCungCap(
	maNCC nvarchar(10) primary key not null,
	tenNCC nvarchar(100), 
	SDT char(12),
	email char(30),
	diaChi nvarchar(200)
)
--Thêm data vào table Nhà cung cấp
INSERT INTO NhaCungCap(maNCC, tenNCC, SDT, email, diaChi)
VALUES 
('NCC001', N'Công ty cổ phần dược phẩm OPC', '0123456789', 'ncc.a@gmail.com', N'Đường số 7, KCN Tân Bình, Phường Sơn Kỳ, Quận Tân Phú, TP. Hồ Chí Minh'),
('NCC002', N'Công ty cổ phần dược phẩm Pymepharco', '0987654321', 'ncc.b@gmail.com', N'đường số 5, KCN Đà Nẵng, Phường Hòa Khánh Bắc, Quận Liên Chiểu, TP. Đà Nẵng'),
('NCC003', N'Công ty cổ phần dược phẩm Hậu Giang', '0123456789', 'ncc.c@gmail.com', N'Số 01 Thân Nhân Trung, Phường 13, Quận Tân Bình, TP. Hồ Chí Minh'),
('NCC004', N'Công ty cổ phần dược phẩm Traphaco', '0987654321', 'ncc.d@gmail.com', N'Số 7 Huỳnh Thúc Kháng, Đống Đa, Hà Nội'),
('NCC005', N'Tập đoàn dược phẩm Sanofi', '0123456789', 'ncc.e@gmail.com', N'Tầng 5, Tòa nhà Flemington, 182 Lê Đại Hành, Phường 15, Quận 11, TP. Hồ Chí Minh'),
('NCC006', N'Tập đoàn dược phẩm Pfizer', '0987654321', 'ncc.f@gmail.com', N'Tầng 8, tòa nhà Hồ Gươm Plaza, số 5 Nguyễn Trãi, Quận Hoàn Kiếm, TP. Hà Nội')

--Thuốc
create table Thuoc(
	maThuoc nvarchar(10) primary key not null,
	tenThuoc nvarchar(50),
	phanLoai nvarchar(50),
	tacDung nvarchar(50),
	ngaySX date,
	ngayHetHan date,
	donViTinh nvarchar(15),
	donGia float,
	soLuong int,
	maNCC nvarchar(10) REFERENCES NhaCungCap(maNCC) on delete cascade on update cascade
)
--Thêm data vào table Thuốc 
INSERT INTO Thuoc (maThuoc, tenThuoc, phanLoai, tacDung, ngaySX, ngayHetHan, donViTinh, donGia, soLuong, maNCC)
VALUES 
    ('T001', N'Amoxicillin', N'Kê đơn', N'Kháng viêm', '2022-01-01', '2023-01-01', N'milligram', 10000, 100, 'NCC001'),
    ('T002', N'Amlodipine', N'Kê đơn', N'Tim mạch', '2022-02-01', '2023-02-01', N'milligram', 15000, 80, 'NCC002'),
    ('T003', N'Corticosteroids', N'Không kê đơn', N'Chống dị ứng', '2022-03-01', '2023-03-01', N'milligram', 8000, 120, 'NCC003'),
    ('T004', N'Morphine', N'Kê đơn', N'Giảm đau', '2022-04-01', '2023-04-01', N'milligram', 12000, 60, 'NCC004'),
    ('T005', N'Alprazolam ', N'Kê đơn', N'Thần kinh', '2022-05-01', '2023-05-01', N'milligram', 20000, 50, 'NCC005'),
    ('T006', N'Methadone', N'Kê đơn', N'Giảm đau', '2022-06-01', '2023-06-01', N'milligram', 5000, 200, 'NCC006'),
    ('T007', N'Laxatives', N'Không kê đơn', N'Hỗ trợ tiêu hóa', '2022-07-01', '2023-07-01', N'milligram', 10000, 150, 'NCC005'),
    ('T008', N'Diuretics', N'Không kê đơn', N'Tim mạch', '2022-08-01', '2023-08-01', N'milligram', 7000, 180, 'NCC001'),
    ('T009', N'Aspirin', N'Không kê đơn', N'Kháng viêm', '2022-09-01', '2023-09-01', N'milligram', 11000, 70, 'NCC006'),
    ('T010', N'Antihistamines', N'Không kê đơn', N'Chống dị ứng',  '2022-10-01', '2023-10-01', N'milligram', 18000, 60, 'NCC004'),
	('T011', N'Antidepressants', N'Kê đơn', N'Thần kinh', '2022-11-01', '2023-11-01', N'milligram', 9000, 90, 'NCC004'),
	('T012', N'Hydrochlorothiazide', N'Kê đơn', N'Tim mạch', '2022-12-01', '2023-12-01', N'milligram', 12000, 70, 'NCC003'),
	('T013', N'Sertraline', N'Kê đơn', N'Thần kinh', '2023-01-01', '2024-01-01', N'milligram', 18000, 50, 'NCC003'),	
	('T014', N'Omeprazole', N'Kê đơn', N'Hỗ trợ tiêu hóa', '2023-02-01', '2024-02-01', N'milligram', 15000, 80, 'NCC006'),
	('T015', N'Gabapentin', N'Kê đơn', N'Thần kinh', '2023-03-01', '2024-03-01', N'milligram', 16000, 70, 'NCC005'),	
	('T016', N'Furosemide', N'Không kê đơn', N'Tim mạch', '2023-04-01', '2024-04-01', N'milligram', 8000, 120, 'NCC004'),
	('T017', N'Tetracycline', N'Không kê đơn', N'Kháng sinh',  '2023-05-01', '2024-05-01', N'milligram', 10000, 100, 'NCC003'),
	('T018', N'Epinephrine', N'Không kê đơn', N'Chống dị ứng', '2023-06-01', '2024-06-01', N'milligram', 14000, 60, 'NCC002'),
	('T019', N'Ibuprofen', N'Không kê đơn', N'Kháng sinh', '2023-07-01', '2024-07-01', N'milligram', 17000, 50, 'NCC001'),
	('T020', N'Penicillin', N'Không kê đơn', N'Kháng sinh', '2023-08-01', '2024-08-01', N'milligram', 13000, 90, 'NCC001');




--Table Hóa Đơn
create table HoaDon(
	maHD nvarchar (20)primary key not null,
	ngayLapHD Date,
	maKH nvarchar(10) REFERENCES KhachHang(maKH) on delete cascade on update cascade,
	maNV nvarchar(10) REFERENCES NhanVien(maNV) on delete cascade on update cascade,
	thanhTien float
)
--Thêm data vào table Hóa Đơn
INSERT INTO HoaDon (maHD, ngayLapHD, maKH, maNV) VALUES
('HD001', '2022-01-01', 'KH001', 'NV001'),
('HD002', '2022-02-02', 'KH002', 'NV002'),
('HD003', '2022-03-03', 'KH003', 'NV003'),
('HD004', '2022-04-04', 'KH004', 'NV004'),
('HD005', '2022-05-05', 'KH005', 'NV003');



--Chi Tiết Hóa Đơn
create table ChiTietHoaDon(
	donGia float,
	soLuong int,
	donViTinh nvarchar(15),
	phiVAT float,
	maThuoc nvarchar(10) REFERENCES Thuoc(maThuoc) on delete cascade on update cascade,
	maHD nvarchar (20) REFERENCES HoaDon(maHD) on delete cascade on update cascade,
	ThanhTien FLOAT
)
--Thêm data vào table Chi Tiết Hóa Đơn
INSERT INTO ChiTietHoaDon(donGia, soLuong, donViTinh, phiVAT, maThuoc, maHD)
VALUES
(10000, 2, N'vỉ', 0.01 ,N'T001', N'HD001'),
(15000, 3, N'hộp', 0.01, N'T002', N'HD001'),
(8000, 1, N'vỉ', 0.01, N'T003', N'HD002'),
(12000, 2, N'tube', 0.01, N'T004', N'HD002'),
(20000, 4, N'hộp', 0.01, N'T005', N'HD003'),
(15000, 1, N'vỉ', 0.01, N'T002', N'HD003'),
(10000, 3, N'vỉ', 0.01, N'T001', N'HD004'),
(20000, 1, N'tube', 0.01,N'T005', N'HD004'),
(8000, 2, N'hộp', 0.01, N'T003', N'HD005'),
(10000, 1, N'vỉ', 0.01, N'T001', N'HD005');


--ALTER TABLE ChiTietHoaDon
--ADD ThanhTien FLOAT;

UPDATE ChiTietHoaDon
SET ThanhTien = SoLuong * DonGia + SoLuong * DonGia * PhiVAT;

UPDATE HoaDon
SET HoaDon.ThanhTien = (
  SELECT SUM(ChiTietHoaDon.ThanhTien)
  FROM ChiTietHoaDon
  WHERE ChiTietHoaDon.MaHD = HoaDon.MaHD
  GROUP BY ChiTietHoaDon.MaHD
)