/*
MySQL Backup
Database: mall
Backup Time: 2021-08-01 16:25:37
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `mall`.`order`;
DROP TABLE IF EXISTS `mall`.`product`;
DROP TABLE IF EXISTS `mall`.`user`;
CREATE TABLE `order` (
  `orderid` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `userid` int NOT NULL,
  PRIMARY KEY (`orderid`),
  KEY `userid` (`userid`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `inventory` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `phone` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
BEGIN;
LOCK TABLES `mall`.`order` WRITE;
DELETE FROM `mall`.`order`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `mall`.`product` WRITE;
DELETE FROM `mall`.`product`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `mall`.`user` WRITE;
DELETE FROM `mall`.`user`;
UNLOCK TABLES;
COMMIT;
