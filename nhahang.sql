create database nhahang;
use nhahang;
CREATE TABLE IF NOT EXISTS `MonChinh` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `TenMon` text COLLATE utf8_unicode_ci NOT NULL,
  `GiaBan` text COLLATE utf8_unicode_ci NOT NULL,
   PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
  )ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

CREATE TABLE IF NOT EXISTS `KhaiVi` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `TenMon` text COLLATE utf8_unicode_ci NOT NULL,
  `GiaBan` text COLLATE utf8_unicode_ci NOT NULL,
   PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
  )ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;
  
  CREATE TABLE IF NOT EXISTS `Lau` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `TenMon` text COLLATE utf8_unicode_ci NOT NULL,
  `GiaBan` text COLLATE utf8_unicode_ci NOT NULL,
   PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
  )ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;
  
  CREATE TABLE IF NOT EXISTS `DoUong` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `TenMon` text COLLATE utf8_unicode_ci NOT NULL,
  `GiaBan` text COLLATE utf8_unicode_ci NOT NULL,
   PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
  )ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;
  
  CREATE TABLE IF NOT EXISTS `Ban` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `SoBan` text COLLATE utf8_unicode_ci NOT NULL,
   PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
  )ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;
  
INSERT into monchinh(ID, TenMon, GiaBan) values
(1, 'Gà Chiên', '50000'),
(2, 'Thịt kho hột vịt', '30000'),
(3, 'Cá chép kho tương', '70000'),
(4, 'Thịt kho hột vịt', '40000'),
(5, 'Xương heo hầm măng', '75000'),
(6, 'Canh khổ qua nhồi thịt', '30000'),
(7, 'Canh chua cá chuối', '35000'),
(8, 'Cơm chiên dương châu', '60000'),
(9, 'Cơm chiên hải sản', '60000'),
(10, 'Cơm chiên bò băm', '60000'),
(11, 'Bò xào hành cần', '60000'),
(12, 'Tôm nướng', '60000'),
(13, 'Tôm rang me', '60000'),
(14, 'Mì xào bò', '65000'),
(15, 'Gà hấp lá chanh 1 con', '260000');

INSERT into khaivi(ID, TenMon, GiaBan) values
(1, 'Đậu hũ chiên giòn', '30000'),
(2, 'Đậu hũ chiên nước mắm', '35000'),
(3, 'Bắp chiên bơ', '30000'),
(4, 'Khoai lang kén chiên', '35000'),
(5, 'Lạc rang', '15000'),
(6, 'Hến xúc bánh đa', '20000'),
(7, 'Bánh đa nướng', '20000');

insert into lau(ID, TenMon, GiaBan) values
(1, 'Lẩu riêu cá chép', '525000'),
(2, 'Lẩu nấm hải sản', '595000'),
(3, 'Lẩu riêu cua gà', '595000'),
(4, 'Lẩu hải sản', '250000'),
(5, 'Lẩu gà tiềm', '350000');

insert into douong(ID, TenMon, GiaBan) values
(1, 'Bia heniken', '21000'),
(2, 'Bia 333', '20000'),
(3, 'Tiger nâu', '17000'),
(4, 'Tiger bạc', '20000'),
(5, 'Sài Gòn special', '17000'),
(6, 'Nước ngọt', '15000'),
(7, 'Nước suối', '10000'),
(8, 'Khăn lạnh', '3000');

insert into ban(ID, SoBan) values
(1, '1'),
(2, '2'),(3, '3'),
(4, '4'),(5, '5'),(6, '6'),
(7, '7'),(8, '8'),(9, '9'),(10, '10');