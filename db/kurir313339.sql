-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2020 at 02:03 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kurir313339`
--

-- --------------------------------------------------------

--
-- Table structure for table `paket`
--

CREATE TABLE `paket` (
  `id_paket313339` int(11) NOT NULL,
  `nomor_resi313339` varchar(10) NOT NULL,
  `order_id313339` int(10) NOT NULL,
  `alamatpaket313339` varchar(250) NOT NULL,
  `penerima313339` varchar(50) NOT NULL,
  `service313339` int(3) NOT NULL,
  `nip_pengirim313339` int(10) NOT NULL,
  `id_track313339` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paket`
--

INSERT INTO `paket` (`id_paket313339`, `nomor_resi313339`, `order_id313339`, `alamatpaket313339`, `penerima313339`, `service313339`, `nip_pengirim313339`, `id_track313339`) VALUES
(7, 'pYbOutL', 80, 'BSI 2 Blok G no.66 Sawangan, Depok Jawa Barat', ' Hilmi Farhandika', 1, 171166, 5),
(9, 'aRwfcuA', 79, 'Bekasi Perumahan Elok No. 71', ' Budi Anduk', 2, 171166, 7),
(20, 'tes11', 90, 'test22', 'test33', 1, 171166, 7),
(21, 'AABBCCA', 876, 'Sawangan', 'Hilmi', 9, 172235, 11),
(22, 'CCADD', 234, 'Depok', 'Hilmi', 9, 172235, 12),
(23, 'AABBCCDD', 92, 'Sawangan', 'Hilmi', 9, 172235, 7);

-- --------------------------------------------------------

--
-- Table structure for table `pengirim`
--

CREATE TABLE `pengirim` (
  `nip_pengirim313339` int(11) NOT NULL,
  `nama_pengirim313339` varchar(50) DEFAULT NULL,
  `telp_pengirim313339` varchar(14) DEFAULT NULL,
  `email_pengirim313339` varchar(255) DEFAULT NULL,
  `alamat_pengirim313339` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengirim`
--

INSERT INTO `pengirim` (`nip_pengirim313339`, `nama_pengirim313339`, `telp_pengirim313339`, `email_pengirim313339`, `alamat_pengirim313339`) VALUES
(171166, 'Bowo', '087654', 'bowo@gmail.com', 'Jakarta Barat'),
(171177, 'Pras', '089355', 'pras@gmail.com', 'Ciledug'),
(171188, 'Ari', '021343', 'ari@gmail.com', 'Tangerang'),
(171199, 'Tyo', '12345', 'tyo@gmail.com', 'Bandung'),
(172235, 'Ariwibowo', '345678', 'ariwibowo123@gmail.com', 'Yogyakarta');

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `id_kurir_service313339` int(11) NOT NULL,
  `nama_service313339` varchar(20) DEFAULT NULL,
  `harga_service313339` int(8) DEFAULT NULL,
  `lama_hari313339` int(2) DEFAULT NULL,
  `berat_barang313339` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`id_kurir_service313339`, `nama_service313339`, `harga_service313339`, `lama_hari313339`, `berat_barang313339`) VALUES
(1, 'Express', 12000, 1, 1),
(2, 'Reguler', 7000, 2, 1),
(3, 'Kargo', 25000, 5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `track_paket`
--

CREATE TABLE `track_paket` (
  `track_id313339` int(11) NOT NULL,
  `id_paket313339` int(20) NOT NULL,
  `nomor_resi313339` varchar(20) NOT NULL,
  `keterangan313339` varchar(100) NOT NULL,
  `tujuan_kota313339` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `track_paket`
--

INSERT INTO `track_paket` (`track_id313339`, `id_paket313339`, `nomor_resi313339`, `keterangan313339`, `tujuan_kota313339`) VALUES
(5, 16, 'pYbOutL', 'Paket telah dipick oleh kurir', 'Bandung'),
(7, 17, 'aRwfcuA', 'Dalam pengiriman menuju kota tujuan', 'Jakarta'),
(11, 99, 'AABBCCA', 'Dalam Transit Ke Laut', 'Aceh'),
(12, 22, 'CCADD', 'Dalam Transit Bandara', 'Bali');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `paket`
--
ALTER TABLE `paket`
  ADD PRIMARY KEY (`id_paket313339`);

--
-- Indexes for table `pengirim`
--
ALTER TABLE `pengirim`
  ADD PRIMARY KEY (`nip_pengirim313339`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`id_kurir_service313339`);

--
-- Indexes for table `track_paket`
--
ALTER TABLE `track_paket`
  ADD PRIMARY KEY (`track_id313339`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `paket`
--
ALTER TABLE `paket`
  MODIFY `id_paket313339` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `pengirim`
--
ALTER TABLE `pengirim`
  MODIFY `nip_pengirim313339` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=172236;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `id_kurir_service313339` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `track_paket`
--
ALTER TABLE `track_paket`
  MODIFY `track_id313339` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
