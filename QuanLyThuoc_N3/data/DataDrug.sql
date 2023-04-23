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
('TK001', 'user1', 'basic', 'password1'),
('TK002', 'user2', 'basic', 'password2'),
('TK003', 'user3', 'admin', 'password3'),
('TK004', 'user4', 'basic', 'password4'),
('TK005', 'user5', 'admin', 'password5'),
('TK006', 'user6', 'basic', 'password6'),
('TK007', 'user7', 'basic', 'password7'),
('TK008', 'user8', 'admin', 'password8'),
('TK009', 'user9', 'basic', 'password9'),
('TK010', 'user10', 'admin', 'password10');


--Nhân Viên
create table NhanVien(
	maNV nvarchar(10) primary key not null,
	hoNV nvarchar(20),
	tenNV nvarchar(20),
	tuoiNV int,
	soDT char(12),
	gioiTinh bit,
	maTK nvarchar(10) REFERENCES TaiKhoan(maTK),
	diaChi nvarchar(100)
)
--Thêm data vào table Nhân Viên
INSERT INTO NhanVien (maNV, hoNV, tenNV, tuoiNV, soDT, gioiTinh, maTK, diaChi) VALUES
('NV001', N'Nguyễn', N'An', 23, '0987654321', 0, 'TK001', N'Hà Nội'),
('NV002', N'Trần', N'Bình', 29, '0981234567', 1, 'TK002', N'Hồ Chí Minh'),
('NV003', N'Lê', N'Công', 25, '0977123456', 1, 'TK003', N'Đà Nẵng'),
('NV004', N'Phạm', N'Duy', 27, '0987123456', 1, 'TK004', N'Nghệ An'),
('NV005', N'Vũ', N'Hà', 28, '0967123456', 0, 'TK005', N'Hải Phòng'),
('NV006', N'Trần', N'Hoài', 26, '0981123456', 1, 'TK006', N'Hưng Yên'),
('NV007', N'Lê', N'Hồng', 30, '0977123456', 0, 'TK007', N'Hà Tĩnh'),
('NV008', N'Nguyễn', N'Huy', 32, '0961123456', 1, 'TK008', N'Nam Định'),
('NV009', N'Phạm', N'Long', 24, '0987123456', 1, 'TK009', N'Bình Dương'),
('NV010', N'Đặng', N'Minh', 31, '0977123456', 1, 'TK010', N'Thái Bình');



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
	tenNCC nvarchar(30), 
	SDT char(12),
	email char(30),
	diaChi nvarchar(100)
)
--Thêm data vào table Nhà cung cấp
INSERT INTO NhaCungCap(maNCC, tenNCC, SDT, email, diaChi)
VALUES ('NCC001', N'Công ty TNHH A', '0123456789', 'ncc.a@gmail.com', N'Đường A, Quận 1, TP.HCM');

INSERT INTO NhaCungCap(maNCC, tenNCC, SDT, email, diaChi)
VALUES ('NCC002', N'Công ty TNHH B', '0987654321', 'ncc.b@gmail.com', N'Đường B, Quận 2, TP.HCM');

INSERT INTO NhaCungCap(maNCC, tenNCC, SDT, email, diaChi)
VALUES ('NCC003', 'Công ty TNHH C', '0123456789', 'ncc.c@gmail.com', N'Đường C, Quận 3, TP.HCM');

INSERT INTO NhaCungCap(maNCC, tenNCC, SDT, email, diaChi)
VALUES ('NCC004', N'Công ty TNHH D', '0987654321', 'ncc.d@gmail.com', N'Đường D, Quận 4, TP.HCM');

INSERT INTO NhaCungCap(maNCC, tenNCC, SDT, email, diaChi)
VALUES ('NCC005', N'Công ty TNHH E', '0123456789', 'ncc.e@gmail.com', N'Đường E, Quận 5, TP.HCM');

INSERT INTO NhaCungCap(maNCC, tenNCC, SDT, email, diaChi)
VALUES ('NCC006', N'Công ty TNHH F', '0987654321', 'ncc.f@gmail.com', N'Đường F, Quận 6, TP.HCM');

INSERT INTO NhaCungCap(maNCC, tenNCC, SDT, email, diaChi)
VALUES ('NCC007', N'Công ty TNHH G', '0123456789', 'ncc.g@gmail.com', N'Đường G, Quận 7, TP.HCM');

INSERT INTO NhaCungCap(maNCC, tenNCC, SDT, email, diaChi)
VALUES ('NCC008', N'Công ty TNHH H', '0987654321', 'ncc.h@gmail.com', N'Đường H, Quận 8, TP.HCM');

INSERT INTO NhaCungCap(maNCC, tenNCC, SDT, email, diaChi)
VALUES ('NCC009', N'Công ty TNHH I', '0123456789', 'ncc.i@gmail.com', N'Đường I, Quận 9, TP.HCM');

INSERT INTO NhaCungCap(maNCC, tenNCC, SDT, email, diaChi)
VALUES ('NCC010', N'Công ty TNHH J', '0987654321', 'ncc.j@gmail.com', N'Đường J, Quận 10, TP.HCM');

--Thuốc
create table Thuoc(
	maThuoc nvarchar(10) primary key not null,
	tenThuoc nvarchar(50),
	phanLoai nvarchar(50),
	ngaySX date,
	ngayHetHan date,
	donViTinh nvarchar(15),
	donGia float,
	soLuong int,
	maNCC nvarchar(10) REFERENCES NhaCungCap(maNCC)
)
--Thêm data vào table Thuốc 
INSERT INTO Thuoc (maThuoc, tenThuoc, phanLoai, ngaySX, ngayHetHan, donViTinh, donGia, soLuong, maNCC)
VALUES 
    ('T001', N'Paracetamol', N'Kê đơn', '2022-01-01', '2023-01-01', N'Viên', 10000, 100, 'NCC001'),
    ('T002', N'Ibuprofen', N'Kê đơn', '2022-02-01', '2023-02-01', N'Viên', 15000, 80, 'NCC002'),
    ('T003', N'Aspirin', N'Kê đơn', '2022-03-01', '2023-03-01', N'Viên', 8000, 120, 'NCC003'),
    ('T004', N'Gliclazide', N'Kê đơn', '2022-04-01', '2023-04-01', N'Viên', 12000, 60, 'NCC004'),
    ('T005', N'Omeprazole', N'Kê đơn', '2022-05-01', '2023-05-01', N'Viên', 20000, 50, 'NCC005'),
    ('T006', N'Paracetamol', N'Không kê đơn', '2022-06-01', '2023-06-01', N'Viên', 5000, 200, 'NCC006'),
    ('T007', N'Ibuprofen', N'Không kê đơn', '2022-07-01', '2023-07-01', N'Viên', 10000, 150, 'NCC007'),
    ('T008', N'Aspirin', N'Không kê đơn', '2022-08-01', '2023-08-01', N'Viên', 7000, 180, 'NCC008'),
    ('T009', N'Gliclazide', N'Không kê đơn', '2022-09-01', '2023-09-01', N'Viên', 11000, 70, 'NCC009'),
    ('T010', N'Omeprazole', N'Không kê đơn', '2022-10-01', '2023-10-01', N'Viên', 18000, 60, 'NCC010');




--Table Hóa Đơn
create table HoaDon(
	maHD nvarchar (20)primary key not null,
	ngayLapHD Date,
	maKH nvarchar(10) REFERENCES KhachHang(maKH),
	maNV nvarchar(10) REFERENCES NhanVien(maNV)
)
--Thêm data vào table Hóa Đơn
INSERT INTO HoaDon (maHD, ngayLapHD, maKH, maNV) VALUES
('HD001', '2022-01-01', 'KH001', 'NV001'),
('HD002', '2022-02-02', 'KH002', 'NV002'),
('HD003', '2022-03-03', 'KH003', 'NV003'),
('HD004', '2022-04-04', 'KH004', 'NV004'),
('HD005', '2022-05-05', 'KH005', 'NV005'),
('HD006', '2022-06-06', 'KH006', 'NV006'),
('HD007', '2022-07-07', 'KH007', 'NV007'),
('HD008', '2022-08-08', 'KH008', 'NV008'),
('HD009', '2022-09-09', 'KH009', 'NV009'),
('HD010', '2022-10-10', 'KH010', 'NV010');



--Chi Tiết Hóa Đơn
create table ChiTietHoaDon(
	donGia float,
	soLuong int,
	donViTinh nvarchar(15),
	phiVAT float,
	mota nvarchar(100),
	maThuoc nvarchar(10) REFERENCES Thuoc(maThuoc),
	maHD nvarchar (20) REFERENCES HoaDon(maHD)
)
--Thêm data vào table Chi Tiết Hóa Đơn
INSERT INTO ChiTietHoaDon(donGia, soLuong, donViTinh, phiVAT, mota, maThuoc, maHD)
VALUES
(25.5, 2, N'vỉ', 0.1, N'Thuốc cảm cúm', N't001', N'HD001'),
(32.0, 3, N'hộp', 0.05, N'Thuốc giảm đau', N't002', N'HD001'),
(15.0, 1, N'vỉ', 0.1, N'Thuốc ho', N't003', N'HD002'),
(10.0, 2, N'tube', 0.0, N'Thuốc bôi trơn', N't004', N'HD002'),
(20.0, 4, N'hộp', 0.1, N'Thuốc trị mụn', N't005', N'HD003'),
(18.5, 1, N'vỉ', 0.05, N'Thuốc giảm đau', N't002', N'HD003'),
(13.0, 3, N'vỉ', 0.0, N'Thuốc cảm cúm', N't001', N'HD004'),
(8.5, 1, N'tube', 0.0, N'Thuốc trị mụn', N't005', N'HD004'),
(30.0, 2, N'hộp', 0.1, N'Thuốc ho', N't003', N'HD005'),
(22.0, 1, N'vỉ', 0.05, N'Thuốc cảm cúm', N't001', N'HD005');