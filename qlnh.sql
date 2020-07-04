-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2015 at 02:20 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `qlnh`
--

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `so_ban` text COLLATE utf8_unicode_ci NOT NULL,
  `ten_mon1` text COLLATE utf8_unicode_ci,
  `sp_mon1` text COLLATE utf8_unicode_ci,
  `ten_mon2` text COLLATE utf8_unicode_ci,
  `sp_mon2` text COLLATE utf8_unicode_ci,
  `ten_mon3` text COLLATE utf8_unicode_ci,
  `sp_mon3` text COLLATE utf8_unicode_ci,
  `ten_mon4` text COLLATE utf8_unicode_ci,
  `sp_mon4` text COLLATE utf8_unicode_ci,
  `ten_mon5` text COLLATE utf8_unicode_ci,
  `sp_mon5` text COLLATE utf8_unicode_ci,
  `ten_mon6` text COLLATE utf8_unicode_ci,
  `sp_mon6` text COLLATE utf8_unicode_ci,
  `ten_mon7` text COLLATE utf8_unicode_ci,
  `sp_mon7` text COLLATE utf8_unicode_ci,
  `ten_mon8` text COLLATE utf8_unicode_ci,
  `sp_mon8` text COLLATE utf8_unicode_ci,
  `tong_cong` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `so_ban`, `ten_mon1`, `sp_mon1`, `ten_mon2`, `sp_mon2`, `ten_mon3`, `sp_mon3`, `ten_mon4`, `sp_mon4`, `ten_mon5`, `sp_mon5`, `ten_mon6`, `sp_mon6`, `ten_mon7`, `sp_mon7`, `ten_mon8`, `sp_mon8`, `tong_cong`) VALUES
(4, '2', 'Thịt kho hột vịt', '12', 'Xương heo hầm măng', '2', 'Cá chép kho tương', '3', 'Trứng ốp la', '5', 'Đậu hủ chiên', '5', '', '', '', '', '', '', '645'),
(5, '3', 'Thịt kho hột vịt', '1', 'Xương heo hầm măng', '2', '', '', '', '', '', '', '', '', '', '', '', '', '130'),
(6, '4', 'Thịt kho hột vịt', '1', 'Xương heo hầm măng', '2', 'Cá chép kho tương', '3', '', '', '', '', '', '', '', '', '', '', '310'),
(7, '4', 'Xương heo hầm măng', '1', 'Cá chép kho tương', '1', '', '', '', '', '', '', '', '', '', '', '', '', '115');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
