# Host: localhost  (Version 5.5.5-10.4.10-MariaDB)
# Date: 2020-06-19 10:30:49
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "paket"
#

DROP TABLE IF EXISTS `paket`;
CREATE TABLE `paket` (
  `id_paket313339` int(11) NOT NULL AUTO_INCREMENT,
  `nomor_resi313339` varchar(10) NOT NULL,
  `order_id313339` int(10) NOT NULL,
  `alamatpaket313339` varchar(250) NOT NULL,
  `penerima313339` varchar(50) NOT NULL,
  `service313339` int(3) NOT NULL,
  `nip_pengirim313339` int(10) NOT NULL,
  `id_track313339` int(11) NOT NULL,
  PRIMARY KEY (`id_paket313339`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

#
# Data for table "paket"
#

INSERT INTO `paket` VALUES (7,'pYbOutL',80,'BSI 2 Blok G no.66 Sawangan, Depok Jawa Barat',' Hilmi Farhandika',1,171166,5),(9,'aRwfcuA',79,'Bekasi Perumahan Elok No. 71',' Budi Anduk',2,171166,7),(20,'tes11',90,'test22','test33',1,171166,7),(21,'AABBCCA',876,'Sawangan','Hilmi',9,172235,11),(22,'CCADD',234,'Depok','Hilmi',9,172235,12),(23,'AABBCCDD',92,'Sawangan','Hilmi',9,172235,7);

#
# Structure for table "pengirim"
#

DROP TABLE IF EXISTS `pengirim`;
CREATE TABLE `pengirim` (
  `nip_pengirim313339` int(11) NOT NULL AUTO_INCREMENT,
  `nama_pengirim313339` varchar(50) DEFAULT NULL,
  `telp_pengirim313339` varchar(14) DEFAULT NULL,
  `email_pengirim313339` varchar(255) DEFAULT NULL,
  `alamat_pengirim313339` varchar(255) DEFAULT NULL,
  `jenkel_pengirim313339` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nip_pengirim313339`)
) ENGINE=InnoDB AUTO_INCREMENT=172243 DEFAULT CHARSET=utf8mb4;

#
# Data for table "pengirim"
#

INSERT INTO `pengirim` VALUES (171166,'Bowo','087654','bowo@gmail.com','Jakarta Barat','Pria'),(171177,'Pras','089355','pras@gmail.com','Ciledug','Pria'),(171188,'Ari','021343','ari@gmail.com','Tangerang','Pria'),(171199,'Tyo','12345','tyo@gmail.com','Bandung','Pria'),(172235,'Ariwibowo','345678','ariwibowo123@gmail.com','Yogyakarta','Pria'),(172239,'Farhan','98765','farhan@gmail.com','Depok','Pria'),(172240,'hilmi','08765499','hilmi@gmail.com','jakarta','pria'),(172242,'setya','0947563899','setya@gmail.com','Cipulir','Wanita');

#
# Structure for table "receiver"
#

DROP TABLE IF EXISTS `receiver`;
CREATE TABLE `receiver` (
  `id_receiver313339` int(11) NOT NULL,
  `nama_receiver313339` varchar(255) DEFAULT NULL,
  `telp_receiver313339` varchar(255) DEFAULT NULL,
  `alamat_receiver313339` varchar(255) DEFAULT NULL,
  `email_receiver313339` varchar(255) DEFAULT NULL,
  `pos_receiver313339` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_receiver313339`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "receiver"
#

INSERT INTO `receiver` VALUES (789,'ari','0897462656','bandung','ari@gmail.com','15511'),(890,'setyo','0987654567','jakarta','setyo@gmail.com','40375'),(891,'santiudin','47566365','yogyakarta','santi@gmail.com','38587');

#
# Structure for table "sender"
#

DROP TABLE IF EXISTS `sender`;
CREATE TABLE `sender` (
  `id_sender313339` int(11) NOT NULL AUTO_INCREMENT,
  `nama_sender313339` varchar(255) DEFAULT NULL,
  `telp_sender313339` varchar(255) DEFAULT NULL,
  `alamat_sender313339` varchar(255) DEFAULT NULL,
  `email_sender313339` varchar(255) DEFAULT NULL,
  `partner_sender313339` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_sender313339`)
) ENGINE=InnoDB AUTO_INCREMENT=462 DEFAULT CHARSET=utf8mb4;

#
# Data for table "sender"
#

INSERT INTO `sender` VALUES (123,'praseto','089765499','Bandung','prasetyo@gmai.com','Umum'),(456,'wibowo','021567785','ciledug','wibowo@gmail.com','bukalapak'),(457,'pras','0897654','Bandung','pras@gmai.com','Tokopedia'),(458,'dika','857364685','Bekasi','dika@gmail.com','Shopee');

#
# Structure for table "service"
#

DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `id_kurir_service313339` int(11) NOT NULL AUTO_INCREMENT,
  `nama_service313339` varchar(20) DEFAULT NULL,
  `harga_service313339` int(8) DEFAULT NULL,
  `lama_hari313339` int(2) DEFAULT NULL,
  `berat_barang313339` int(11) DEFAULT NULL,
  `jenis_barang313339` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_kurir_service313339`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

#
# Data for table "service"
#

INSERT INTO `service` VALUES (1,'Express',12000,1,1,'elektronik'),(2,'Reguler',7000,2,1,'makanan'),(3,'Ekonomi',5000,5,1,'aksesoris'),(12,'Kargo',25000,3,10,'Big Box');

#
# Structure for table "status"
#

DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id_status313339` int(11) NOT NULL AUTO_INCREMENT,
  `jenis_status313339` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_status313339`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "status"
#

INSERT INTO `status` VALUES (101,'pick up'),(102,'shipping'),(103,'arrived');

#
# Structure for table "track_paket"
#

DROP TABLE IF EXISTS `track_paket`;
CREATE TABLE `track_paket` (
  `track_id313339` int(11) NOT NULL AUTO_INCREMENT,
  `id_paket313339` int(20) NOT NULL,
  `nomor_resi313339` varchar(20) NOT NULL,
  `keterangan313339` varchar(100) NOT NULL,
  `tujuan_kota313339` varchar(20) NOT NULL,
  PRIMARY KEY (`track_id313339`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4;

#
# Data for table "track_paket"
#

INSERT INTO `track_paket` VALUES (5,16,'pYbOutL','Paket telah dipick oleh kurir','Bandung'),(7,17,'aRwfcuA','Dalam pengiriman menuju kota tujuan','Jakarta'),(11,99,'AABBCCA','Dalam Transit Ke Laut','Aceh'),(12,22,'CCADD','Dalam Transit Bandara','Bali');

#
# Structure for table "tracking"
#

DROP TABLE IF EXISTS `tracking`;
CREATE TABLE `tracking` (
  `id_tracking313339` int(11) NOT NULL AUTO_INCREMENT,
  `nomor_resi313339` varchar(255) DEFAULT NULL,
  `id_sender313339` varchar(255) DEFAULT NULL,
  `id_receiver313339` varchar(255) DEFAULT NULL,
  `tujuan313339` varchar(255) DEFAULT NULL,
  `status313339` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_tracking313339`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4;

#
# Data for table "tracking"
#

INSERT INTO `tracking` VALUES (101,'1qazxsw2','123','789','bandung','shipping'),(102,'qwertyu43','456','890','jakarta','transit'),(103,'xswwqza12','457','891','yogyakarta','tiba'),(104,NULL,'456','891','yogyakarta','proses'),(105,NULL,'456','890','jakarta','tiba');
