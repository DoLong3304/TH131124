-- Create Database
CREATE DATABASE IF NOT EXISTS QLD_TC064;
USE QLD_TC064;

-- Create Table Sinhvien
CREATE TABLE Sinhvien (
    Masv VARCHAR(10) PRIMARY KEY,
    Hoten VARCHAR(100) NOT NULL,
    Ngaysinh DATE NOT NULL,
    Gioitinh CHAR(1) CHECK (Gioitinh IN ('M', 'F')),
    Malop VARCHAR(10) NOT NULL
);

-- Create Table Monhoc
CREATE TABLE Monhoc (
    Mamon VARCHAR(10) PRIMARY KEY,
    Tenmonhoc VARCHAR(100) NOT NULL,
    Sotinchi INT NOT NULL
);

-- Create Table Diemthi
CREATE TABLE Diemthi (
    Mamon VARCHAR(10),
    Masv VARCHAR(10),
    Diemlan1 DECIMAL(3,1),
    Diemlan2 DECIMAL(3,1),
    PRIMARY KEY (Mamon, Masv),
    FOREIGN KEY (Mamon) REFERENCES Monhoc(Mamon) ON DELETE CASCADE,
    FOREIGN KEY (Masv) REFERENCES Sinhvien(Masv) ON DELETE CASCADE
);

-- Insert Sample Data into Sinhvien
INSERT INTO Sinhvien (Masv, Hoten, Ngaysinh, Gioitinh, Malop) VALUES
('SV001', 'Nguyễn Văn A', '2001-01-01', 'M', 'L01'),
('SV002', 'Trần Thị B', '2001-02-02', 'F', 'L01'),
('SV003', 'Lê Văn C', '2002-03-03', 'M', 'L02'),
('SV004', 'Phạm Thị D', '2001-04-04', 'F', 'L02'),
('SV005', 'Đỗ Minh E', '2000-05-05', 'M', 'L03');

-- Insert Sample Data into Monhoc
INSERT INTO Monhoc (Mamon, Tenmonhoc, Sotinchi) VALUES
('TTNT', 'Trí tuệ nhân tạo', 3),
('CS', 'Cấu trúc dữ liệu và giải thuật', 3),
('HDH', 'Hệ điều hành', 3),
('CSDL', 'Cơ sở dữ liệu', 3),
('KTLT', 'Kỹ thuật lập trình', 3);

-- Insert Sample Data into Diemthi
INSERT INTO Diemthi (Mamon, Masv, Diemlan1, Diemlan2) VALUES
('TTNT', 'SV001', 8.5, 9.0),
('TTNT', 'SV002', 7.0, 8.5),
('CS', 'SV003', 7.5, 8.0),
('HDH', 'SV004', 8.0, 8.5),
('CSDL', 'SV005', 6.5, 7.0);
