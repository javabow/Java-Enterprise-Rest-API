-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versi server:                 10.1.13-MariaDB - mariadb.org binary distribution
-- OS Server:                    Win32
-- HeidiSQL Versi:               9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for je
DROP DATABASE IF EXISTS `je`;
CREATE DATABASE IF NOT EXISTS `je` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `je`;


-- Dumping structure for table je.division
DROP TABLE IF EXISTS `division`;
CREATE TABLE IF NOT EXISTS `division` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sub` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Dumping data for table je.division: 3 rows
/*!40000 ALTER TABLE `division` DISABLE KEYS */;
REPLACE INTO `division` (`Id`, `name`, `sub`) VALUES
	(1, 'IT', 'PROGRAMMER'),
	(2, 'IT', 'INFRASTUKTUR'),
	(8, 'IT', 'ANALYST');
/*!40000 ALTER TABLE `division` ENABLE KEYS */;


-- Dumping structure for table je.dosen
DROP TABLE IF EXISTS `dosen`;
CREATE TABLE IF NOT EXISTS `dosen` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `divisi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- Dumping data for table je.dosen: 18 rows
/*!40000 ALTER TABLE `dosen` DISABLE KEYS */;
REPLACE INTO `dosen` (`Id`, `NAME`, `ADDRESS`, `divisi`) VALUES
	(4, 'mepa', 'Tangerang Selatan', 'A9'),
	(5, 'Mepa', 'Kayu Gede', 'IT'),
	(6, 'mepa', 'serpong utara', 'OA'),
	(7, 'mepa', 'serpong utara', 'pA'),
	(8, 'mepa', 'serpong utara', 'CA'),
	(9, 'labib', 'Tangerang Selatan', NULL),
	(10, 'labib', 'Tangerang Selatan', 'AA'),
	(11, 'labib', 'Tangerang Selatan', 'AA'),
	(12, 'labib', 'Tangerang Selatan', 'A6'),
	(13, 'labib', 'Tangerang Selatan', 'A7'),
	(14, 'mepa', 'Tangerang Selatan', 'A7'),
	(15, 'mepa', 'Tangerang Selatan', 'A7'),
	(16, 'mepa', 'Tangerang Selatan', 'A7'),
	(17, 'mepa', 'Tangerang Selatan', 'A7'),
	(18, 'mepa', 'Tangerang Selatan', 'A7'),
	(19, 'mepa', 'Tangerang Selatan', 'A7'),
	(20, 'mepaku', 'Tangerang Selatan', 'A7'),
	(21, 'mepa', 'Tangerang Selatan', 'A7');
/*!40000 ALTER TABLE `dosen` ENABLE KEYS */;


-- Dumping structure for table je.employee
DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table je.employee: 3 rows
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
REPLACE INTO `employee` (`Id`, `name`, `address`, `gender`) VALUES
	(9, 'Mepa Kurniasih', 'Tangerang Selatan', 'Wanita'),
	(10, 'Labib Aflah', 'Jakarta Selatan - Tangerang Selatan', 'Pria'),
	(11, 'Achmad Ardiansyah', 'Jakarta Selatan', 'Pria');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


-- Dumping structure for table je.matakuliah
DROP TABLE IF EXISTS `matakuliah`;
CREATE TABLE IF NOT EXISTS `matakuliah` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `namamatakuliah` varchar(255) DEFAULT NULL,
  `namakelompok` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table je.matakuliah: 4 rows
/*!40000 ALTER TABLE `matakuliah` DISABLE KEYS */;
REPLACE INTO `matakuliah` (`Id`, `namamatakuliah`, `namakelompok`) VALUES
	(1, 'rekweb', 'AA'),
	(2, 'rekweb', 'AB'),
	(3, 'JE', 'AC'),
	(4, 'JE', 'AD');
/*!40000 ALTER TABLE `matakuliah` ENABLE KEYS */;


-- Dumping structure for table je.trdosenngajar
DROP TABLE IF EXISTS `trdosenngajar`;
CREATE TABLE IF NOT EXISTS `trdosenngajar` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `NGAJAR_ID` varchar(255) DEFAULT NULL,
  `DOSEN_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table je.trdosenngajar: 0 rows
/*!40000 ALTER TABLE `trdosenngajar` DISABLE KEYS */;
/*!40000 ALTER TABLE `trdosenngajar` ENABLE KEYS */;


-- Dumping structure for table je.trkaryawandivisi
DROP TABLE IF EXISTS `trkaryawandivisi`;
CREATE TABLE IF NOT EXISTS `trkaryawandivisi` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DIVISI_ID` int(11) NOT NULL,
  `EMPLOYEE_ID` int(11) NOT NULL,
  `NOTES` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `DIVISI_ID` (`DIVISI_ID`),
  KEY `EMPLOYEE_ID` (`EMPLOYEE_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

-- Dumping data for table je.trkaryawandivisi: 10 rows
/*!40000 ALTER TABLE `trkaryawandivisi` DISABLE KEYS */;
REPLACE INTO `trkaryawandivisi` (`ID`, `DIVISI_ID`, `EMPLOYEE_ID`, `NOTES`) VALUES
	(20, 2, 9, NULL),
	(21, 1, 10, NULL),
	(22, 1, 8, NULL),
	(23, 8, 8, NULL),
	(24, 1, 9, NULL),
	(25, 2, 9, NULL),
	(26, 2, 9, 'Karyawan'),
	(27, 2, 9, 'Karyawan Magang'),
	(28, 2, 9, 'Karyawan Magang 123'),
	(29, 2, 9, 'Karyawan Magang UBL');
/*!40000 ALTER TABLE `trkaryawandivisi` ENABLE KEYS */;


-- Dumping structure for table je.trngajar
DROP TABLE IF EXISTS `trngajar`;
CREATE TABLE IF NOT EXISTS `trngajar` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `matakuliah_id` varchar(255) DEFAULT NULL,
  `dosen_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `matakuliah_id` (`matakuliah_id`),
  KEY `dosen_id` (`dosen_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table je.trngajar: 2 rows
/*!40000 ALTER TABLE `trngajar` DISABLE KEYS */;
REPLACE INTO `trngajar` (`Id`, `matakuliah_id`, `dosen_id`) VALUES
	(1, '1', '4'),
	(2, '4', '11');
/*!40000 ALTER TABLE `trngajar` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
