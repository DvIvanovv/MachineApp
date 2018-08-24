-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.25-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for machines_db
DROP DATABASE IF EXISTS `machines_db`;
CREATE DATABASE IF NOT EXISTS `machines_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `machines_db`;

-- Dumping structure for table machines_db.auth_user_group
DROP TABLE IF EXISTS `auth_user_group`;
CREATE TABLE IF NOT EXISTS `auth_user_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `auth_group` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table machines_db.auth_user_group: ~0 rows (approximately)
/*!40000 ALTER TABLE `auth_user_group` DISABLE KEYS */;
INSERT INTO `auth_user_group` (`id`, `auth_group`, `username`) VALUES
	(1, 'USER', 'Admin'),
	(2, 'ADMIN', 'Admin'),
	(3, 'USER', 'User'),
	(4, 'USER', 'rosi');
/*!40000 ALTER TABLE `auth_user_group` ENABLE KEYS */;

-- Dumping structure for table machines_db.consumables
DROP TABLE IF EXISTS `consumables`;
CREATE TABLE IF NOT EXISTS `consumables` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `consumable_type` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table machines_db.consumables: ~0 rows (approximately)
/*!40000 ALTER TABLE `consumables` DISABLE KEYS */;
INSERT INTO `consumables` (`id`, `consumable_type`, `name`) VALUES
	(1, 0, 'FAS-10'),
	(2, 0, 'Filter');
/*!40000 ALTER TABLE `consumables` ENABLE KEYS */;

-- Dumping structure for table machines_db.consumable_machine
DROP TABLE IF EXISTS `consumable_machine`;
CREATE TABLE IF NOT EXISTS `consumable_machine` (
  `consumables_id` bigint(20) NOT NULL,
  `machines_id` bigint(20) NOT NULL,
  KEY `FKngksnp3on2ns7bw84e9nqa3ee` (`machines_id`),
  KEY `FK29hcsul3jef0hemiqgbmdcbby` (`consumables_id`),
  CONSTRAINT `FK29hcsul3jef0hemiqgbmdcbby` FOREIGN KEY (`consumables_id`) REFERENCES `consumables` (`id`),
  CONSTRAINT `FKngksnp3on2ns7bw84e9nqa3ee` FOREIGN KEY (`machines_id`) REFERENCES `machines` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table machines_db.consumable_machine: ~0 rows (approximately)
/*!40000 ALTER TABLE `consumable_machine` DISABLE KEYS */;
INSERT INTO `consumable_machine` (`consumables_id`, `machines_id`) VALUES
	(1, 1),
	(2, 1);
/*!40000 ALTER TABLE `consumable_machine` ENABLE KEYS */;

-- Dumping structure for table machines_db.machines
DROP TABLE IF EXISTS `machines`;
CREATE TABLE IF NOT EXISTS `machines` (
  `machine_identifier` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dimension` varchar(255) DEFAULT NULL,
  `image` tinyblob,
  `machine_type` int(11) NOT NULL,
  `model` varchar(255) DEFAULT NULL,
  `power` double NOT NULL,
  `power_consumption` double NOT NULL,
  `weigth` double NOT NULL,
  `volume_at_10_bars` double DEFAULT NULL,
  `volume_at_13_bars` double DEFAULT NULL,
  `volume_at_8_bars` double DEFAULT NULL,
  `compressed_air_connection` varchar(255) DEFAULT NULL,
  `volumetric_flow_rate` double DEFAULT NULL,
  `number_of_pistons` smallint(6) DEFAULT NULL,
  `number_of_stages` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table machines_db.machines: ~0 rows (approximately)
/*!40000 ALTER TABLE `machines` DISABLE KEYS */;
INSERT INTO `machines` (`machine_identifier`, `id`, `dimension`, `image`, `machine_type`, `model`, `power`, `power_consumption`, `weigth`, `volume_at_10_bars`, `volume_at_13_bars`, `volume_at_8_bars`, `compressed_air_connection`, `volumetric_flow_rate`, `number_of_pistons`, `number_of_stages`) VALUES
	('Screw', 1, '11x111x11', NULL, 0, 'SCK-75', 12, 12, 100, 9, 10, 8, NULL, NULL, NULL, NULL),
	('Screw', 2, '10x100x10', NULL, 0, 'SCK-55', 10, 10, 75, 8, 9, 7, NULL, NULL, NULL, NULL),
	('Piston', 3, '50x20x30', NULL, 1, 'AKK-5', 5, 5, 35, NULL, NULL, NULL, NULL, NULL, 1, 0),
	('Piston', 4, '35x50x50', NULL, 1, 'AKK-15', 6, 6, 70, NULL, NULL, NULL, NULL, NULL, 2, 0),
	('Adsorbtion', 5, '10x30x30', NULL, 2, 'ADQ-10', 10, 10, 25, NULL, NULL, NULL, '1/2\'\'', 5, NULL, NULL),
	('Refrigeration', 6, '25x30x75', NULL, 3, 'RF-17', 17, 17, 100, NULL, NULL, NULL, '2"', 12, NULL, NULL),
	('Adsorbtion', 7, '10x10x10', NULL, 2, 'ADQ-10.1', 10, 10, 10, NULL, NULL, NULL, '10', 10, NULL, NULL);
/*!40000 ALTER TABLE `machines` ENABLE KEYS */;

-- Dumping structure for table machines_db.service_orders
DROP TABLE IF EXISTS `service_orders`;
CREATE TABLE IF NOT EXISTS `service_orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `service_date` date DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `machine_warranty_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmhertkwtt396qiwydf15kn1h7` (`user_id`),
  KEY `FKrm650q67hvjt90i1rqyqa4uga` (`machine_warranty_id`),
  CONSTRAINT `FKmhertkwtt396qiwydf15kn1h7` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKrm650q67hvjt90i1rqyqa4uga` FOREIGN KEY (`machine_warranty_id`) REFERENCES `waranties` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table machines_db.service_orders: ~0 rows (approximately)
/*!40000 ALTER TABLE `service_orders` DISABLE KEYS */;
INSERT INTO `service_orders` (`id`, `service_date`, `user_id`, `machine_warranty_id`) VALUES
	(1, '2018-08-29', 2, 2);
/*!40000 ALTER TABLE `service_orders` ENABLE KEYS */;

-- Dumping structure for table machines_db.service_order_consumables
DROP TABLE IF EXISTS `service_order_consumables`;
CREATE TABLE IF NOT EXISTS `service_order_consumables` (
  `service_order_id` bigint(20) NOT NULL,
  `consumables_id` bigint(20) NOT NULL,
  KEY `FKmas1pb4vgayfqvhli5w2py5hm` (`consumables_id`),
  KEY `FKcca743uyxlbl76afinrxarkdd` (`service_order_id`),
  CONSTRAINT `FKcca743uyxlbl76afinrxarkdd` FOREIGN KEY (`service_order_id`) REFERENCES `service_orders` (`id`),
  CONSTRAINT `FKmas1pb4vgayfqvhli5w2py5hm` FOREIGN KEY (`consumables_id`) REFERENCES `consumables` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table machines_db.service_order_consumables: ~0 rows (approximately)
/*!40000 ALTER TABLE `service_order_consumables` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_order_consumables` ENABLE KEYS */;

-- Dumping structure for table machines_db.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table machines_db.users: ~0 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `password`, `username`) VALUES
	(1, '$2a$11$qYV5wnmP8j/KRVtRtsybcuH17OWSgmEuhmQZCMMTLyIawpRvf9eyC', 'Admin'),
	(2, '$2a$11$PoAfkrMsO671x.VmHBNnWu3WgYple6KlMTrua3/PIDfYJEGa0ucYm', 'User'),
	(3, '$2a$11$1ml3xPzjf6ooXwEnjMwFpumoP/wOgT9qp.f.Uid7mxdEAjH1GcCWK', 'rosi');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table machines_db.waranties
DROP TABLE IF EXISTS `waranties`;
CREATE TABLE IF NOT EXISTS `waranties` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) DEFAULT NULL,
  `is_approved` bit(1) DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `serial_number` varchar(10) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `machine_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_fi6xpeef2mosb56wjhvme9a94` (`serial_number`),
  KEY `FK1s281b89qn5cyl0d05d2iupoy` (`machine_id`),
  CONSTRAINT `FK1s281b89qn5cyl0d05d2iupoy` FOREIGN KEY (`machine_id`) REFERENCES `machines` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table machines_db.waranties: ~0 rows (approximately)
/*!40000 ALTER TABLE `waranties` DISABLE KEYS */;
INSERT INTO `waranties` (`id`, `is_active`, `is_approved`, `order_date`, `serial_number`, `username`, `machine_id`) VALUES
	(1, b'1', b'0', '2018-08-21 00:00:00', '1234567890', 'Admin', 1),
	(2, b'1', b'0', '2018-08-14 00:00:00', '0987654321', 'User', 2);
/*!40000 ALTER TABLE `waranties` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
