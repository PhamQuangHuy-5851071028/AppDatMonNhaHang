-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th7 20, 2020 lúc 03:58 AM
-- Phiên bản máy phục vụ: 10.3.16-MariaDB
-- Phiên bản PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `id14307267_nhahang`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ban`
--

CREATE TABLE `ban` (
  `IDBan` int(10) UNSIGNED NOT NULL,
  `TrangThai` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ban`
--

INSERT INTO `ban` (`IDBan`, `TrangThai`) VALUES
(1, 'Trống'),
(2, 'Trống'),
(3, 'Trống'),
(4, 'Trống'),
(5, 'Trống'),
(6, 'Trống'),
(7, 'Trống'),
(8, 'Trống'),
(9, 'Trống'),
(10, 'Trống');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `IDHoaDon` int(11) UNSIGNED NOT NULL,
  `ID` int(10) UNSIGNED NOT NULL,
  `SoLuong` int(10) NOT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`IDHoaDon`, `ID`, `SoLuong`, `ThanhTien`) VALUES
(1, 1, 2, 0),
(1, 15, 2, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `IDHoaDon` int(10) UNSIGNED NOT NULL,
  `IDBan` int(10) UNSIGNED NOT NULL,
  `TongTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`IDHoaDon`, `IDBan`, `TongTien`) VALUES
(1, 1, 0),
(2, 1, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaimonan`
--

CREATE TABLE `loaimonan` (
  `IDLoaiMonAn` int(10) UNSIGNED NOT NULL,
  `Loai` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `loaimonan`
--

INSERT INTO `loaimonan` (`IDLoaiMonAn`, `Loai`) VALUES
(1, 'Món chính'),
(2, 'Khai vị'),
(3, 'Đồ uống'),
(4, 'Lẩu');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monan`
--

CREATE TABLE `monan` (
  `ID` int(10) UNSIGNED NOT NULL,
  `TenMon` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `GiaBan` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `IDLoaiMonAn` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `monan`
--

INSERT INTO `monan` (`ID`, `TenMon`, `GiaBan`, `IDLoaiMonAn`) VALUES
(1, 'Gà Chiên', '50000', 1),
(2, 'Thịt kho hột vịt', '30000', 1),
(3, 'Cá chép kho tương', '70000', 1),
(5, 'Xương heo hầm măng', '75000', 1),
(6, 'Canh khổ qua nhồi thịt', '30000', 1),
(7, 'Canh chua cá chuối', '35000', 1),
(8, 'Cơm chiên dương châu', '60000', 1),
(9, 'Cơm chiên hải sản', '60000', 1),
(10, 'Cơm chiên bò băm', '60000', 1),
(11, 'Bò xào hành cần', '60000', 1),
(12, 'Tôm nướng', '60000', 1),
(13, 'Tôm rang me', '60000', 1),
(14, 'Mì xào bò', '65000', 1),
(15, 'Gà hấp lá chanh 1 con', '260000', 1),
(16, 'Đậu hũ chiên giòn', '30000', 2),
(17, 'Đậu hũ chiên nước mắm', '35000', 2),
(18, 'Bắp chiên bơ', '30000', 2),
(19, 'Khoai lang kén chiên', '35000', 2),
(20, 'Lạc rang', '15000', 2),
(21, 'Hến xúc bánh đa', '20000', 2),
(22, 'Bánh đa nướng', '20000', 2),
(31, 'Lẩu riêu cá chép', '525000', 4),
(32, 'Lẩu nấm hải sản', '595000', 4),
(33, 'Lẩu riêu cua gà', '595000', 4),
(34, 'Lẩu hải sản', '250000', 4),
(35, 'Lẩu gà tiềm', '350000', 4),
(36, 'Bia heniken', '21000', 3),
(37, 'Bia 333', '20000', 3),
(38, 'Tiger nâu', '17000', 3),
(39, 'Tiger bạc', '20000', 3),
(40, 'Sài Gòn special', '17000', 3),
(41, 'Nước ngọt', '15000', 3),
(42, 'Nước suối', '10000', 3),
(43, 'Khăn lạnh', '3000', 3);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ban`
--
ALTER TABLE `ban`
  ADD PRIMARY KEY (`IDBan`);

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`IDHoaDon`,`ID`),
  ADD KEY `IDHoaDon` (`IDHoaDon`),
  ADD KEY `ID` (`ID`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`IDHoaDon`),
  ADD KEY `IDBan` (`IDBan`);

--
-- Chỉ mục cho bảng `loaimonan`
--
ALTER TABLE `loaimonan`
  ADD PRIMARY KEY (`IDLoaiMonAn`);

--
-- Chỉ mục cho bảng `monan`
--
ALTER TABLE `monan`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IDLoaiMonAn` (`IDLoaiMonAn`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ban`
--
ALTER TABLE `ban`
  MODIFY `IDBan` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `IDHoaDon` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `loaimonan`
--
ALTER TABLE `loaimonan`
  MODIFY `IDLoaiMonAn` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `monan`
--
ALTER TABLE `monan`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`IDHoaDon`) REFERENCES `hoadon` (`IDHoaDon`),
  ADD CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`ID`) REFERENCES `monan` (`ID`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`IDBan`) REFERENCES `ban` (`IDBan`);

--
-- Các ràng buộc cho bảng `monan`
--
ALTER TABLE `monan`
  ADD CONSTRAINT `monan_ibfk_1` FOREIGN KEY (`IDLoaiMonAn`) REFERENCES `loaimonan` (`IDLoaiMonAn`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
