/*
SQLyog Community v8.82 
MySQL - 5.1.47-community : Database - billing
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`billing` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `billing`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `category` */

insert  into `category`(`ID`,`category`) values (1,'harddrink'),(2,'colddrink'),(3,'cocktail'),(4,'cocktai'),(5,'cocktail'),(6,'water'),(7,'tea'),(8,'juice');

/*Table structure for table `drinkmenu` */

DROP TABLE IF EXISTS `drinkmenu`;

CREATE TABLE `drinkmenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Drinkname` varchar(100) NOT NULL,
  `Price` varchar(40) NOT NULL,
  `category` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `drinkmenu` */

insert  into `drinkmenu`(`id`,`Drinkname`,`Price`,`category`) values (2,'vodk','55','tea'),(3,'vodk','55','cocktail'),(4,'vodka','550','juice'),(8,'coke','50','harddrink');

/*Table structure for table `foodmenu` */

DROP TABLE IF EXISTS `foodmenu`;

CREATE TABLE `foodmenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Itemname` varchar(100) NOT NULL,
  `Price` varchar(40) NOT NULL,
  `Category` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `foodmenu` */

insert  into `foodmenu`(`id`,`Itemname`,`Price`,`Category`) values (1,'pizza','350','food'),(2,'pizzas','3500','foods'),(3,'buff momo','110',NULL),(5,'pizzas','3500','water'),(6,'buff momo','115','colddrink'),(8,'burger','',''),(10,'sizzler','250','food');

/*Table structure for table `sales` */

DROP TABLE IF EXISTS `sales`;

CREATE TABLE `sales` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Item` varchar(200) DEFAULT NULL COMMENT '*****************',
  `Price` varchar(50) DEFAULT NULL COMMENT '*****************',
  `Quantity` varchar(50) DEFAULT NULL COMMENT '*****************',
  `Price_Total` varchar(50) DEFAULT NULL COMMENT '*****************',
  `Discount` varchar(50) DEFAULT NULL COMMENT '*****************',
  `Grand_Total` varchar(50) DEFAULT NULL COMMENT '*****************',
  `Date` timestamp NULL DEFAULT NULL COMMENT '*****************',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=latin1;

/*Data for the table `sales` */

insert  into `sales`(`ID`,`Item`,`Price`,`Quantity`,`Price_Total`,`Discount`,`Grand_Total`,`Date`) values (1,'vodk','55','2','110',NULL,NULL,'2018-01-05 00:29:57'),(2,'pizza','350','4','1400',NULL,NULL,'2018-01-05 00:29:57'),(3,'vodk','55','3','165',NULL,NULL,'2018-01-05 00:31:22'),(4,'buff momo','110','2','220',NULL,NULL,'2018-01-05 00:31:22'),(5,NULL,NULL,NULL,NULL,'6','362','2018-01-05 00:31:22'),(6,'coke','50','3','150',NULL,NULL,'2018-01-05 00:33:51'),(7,NULL,NULL,NULL,NULL,'6','141','2018-01-05 00:33:51'),(8,'buff momo','110','2','220',NULL,NULL,'2018-01-05 00:34:27'),(9,'wishky','4000','2','8000',NULL,NULL,'2018-01-05 00:34:27'),(10,NULL,NULL,NULL,NULL,'6','7727','2018-01-05 00:34:27'),(11,'vodk','55','3','165',NULL,NULL,'2018-01-05 00:48:21'),(12,'buff momo','110','2','220',NULL,NULL,'2018-01-05 00:48:21'),(13,NULL,NULL,NULL,NULL,'5','366','2018-01-05 00:48:21'),(14,NULL,NULL,NULL,NULL,NULL,NULL,'2018-01-05 00:48:46'),(15,'vodk','55','4','220',NULL,NULL,'2018-01-05 00:54:17'),(16,NULL,NULL,NULL,NULL,'7','205','2018-01-05 00:54:17'),(17,'vodk','55','3','165',NULL,NULL,'2018-01-05 01:00:55'),(18,'vodk','55','1','55',NULL,NULL,'2018-01-05 01:00:55'),(19,NULL,NULL,NULL,NULL,'7','205','2018-01-05 01:00:55'),(20,'vodk','55','2','110',NULL,NULL,'2018-01-05 01:06:42'),(21,NULL,NULL,NULL,NULL,'8','102','2018-01-05 01:06:42'),(22,'vodk','55','6','330',NULL,NULL,'2018-01-05 01:12:49'),(23,NULL,NULL,NULL,NULL,'9','301','2018-01-05 01:12:49'),(24,'vodk','55','5','275','7','256','2018-01-05 01:15:19'),(25,'vodk','55','5','275',NULL,NULL,'2018-01-05 01:16:21'),(26,'buff momo','110','8','880',NULL,NULL,'2018-01-05 01:16:21'),(27,NULL,NULL,NULL,NULL,'9','1052','2018-01-05 01:16:21'),(28,'pizza','350','3','1050','5','998','2018-01-06 12:57:44'),(29,'pizza','350','3','1050','','550','2018-01-06 22:21:59'),(30,'buff momo','110','2','220','','330','2018-01-07 00:12:22'),(31,'buff momo','110','1','110',NULL,NULL,'2018-01-07 00:16:04'),(32,'buff momo','110','3','330',NULL,NULL,'2018-01-07 00:16:04'),(33,'buff momo','110','3','330',NULL,NULL,'2018-01-07 00:16:04'),(34,NULL,NULL,NULL,NULL,'','765','2018-01-07 00:16:04'),(35,'pizzas','3500','6','21000','5','21000','2018-01-07 00:16:27'),(36,'pizza','350','3','1050','','1000','2018-01-07 16:47:32'),(37,'vodk','55','3','165',NULL,NULL,'2018-01-09 14:20:01'),(38,'coke','50','2','100',NULL,NULL,'2018-01-09 14:20:01'),(39,NULL,NULL,NULL,NULL,'','215','2018-01-09 14:20:01'),(40,'vodk','55','4','220','','220','2018-01-09 14:35:57'),(41,'vodka','550','6','3300','','3300','2018-01-09 14:41:07'),(42,'vodka','550','4','2200','5','2200','2018-01-09 14:41:41'),(43,'vodk','55','3','165','','165','2018-01-09 14:42:31'),(44,'vodk','55','5','275','6','275','2018-01-09 14:44:33'),(45,'vodk','55','1','55','','55','2018-01-09 14:57:54'),(46,'vodka','550','5','2750',NULL,NULL,'2018-01-09 14:58:59'),(47,'vodka','550','1','550',NULL,NULL,'2018-01-09 14:58:59'),(48,NULL,NULL,NULL,NULL,'','3300','2018-01-09 14:58:59'),(49,'pizza','350','3','1050',NULL,NULL,'2018-01-11 14:10:43'),(50,'pizza','350','5','1750',NULL,NULL,'2018-01-11 14:10:43'),(51,'vodk','55','6','330',NULL,NULL,'2018-01-11 14:10:43'),(52,NULL,NULL,NULL,NULL,'','3130','2018-01-11 14:10:43'),(53,'14','coke','50','6','','625','2018-01-11 15:03:36'),(54,'pizza','350','5','1750',NULL,NULL,'2018-01-11 15:08:44'),(55,'buff momo','110','6','660',NULL,NULL,'2018-01-11 15:08:44'),(56,'buff momo','110','4','440',NULL,NULL,'2018-01-11 15:08:44'),(57,'buff momo','110','7','770',NULL,NULL,'2018-01-11 15:08:44'),(58,NULL,NULL,NULL,NULL,'','3570','2018-01-11 15:08:44'),(59,'vodk','55','6','330','','330','2018-01-11 15:21:47'),(60,'1','pizza','350','5',NULL,NULL,'2018-01-11 16:29:28'),(61,'3','vodk','55','5',NULL,NULL,'2018-01-11 16:29:28'),(62,'5','vodk','55','6',NULL,NULL,'2018-01-11 16:29:28'),(63,'12','vodk','55','1',NULL,NULL,'2018-01-11 16:29:28'),(64,'13','vodk','55','6',NULL,NULL,'2018-01-11 16:29:28'),(65,'21','vodk','55','3',NULL,NULL,'2018-01-11 16:29:28'),(66,'24','vodk','55','4',NULL,NULL,'2018-01-11 16:29:28'),(67,'26','vodk','55','7',NULL,NULL,'2018-01-11 16:29:28'),(68,NULL,NULL,NULL,NULL,'6','3300','2018-01-11 16:29:28'),(69,'pizza','350','3','1050','7','977','2018-01-11 18:59:30'),(70,'buff momo','110','54','5940','6','5584','2018-01-11 19:02:59'),(71,'pizza','350','5','1750',NULL,NULL,'2018-01-11 21:13:31'),(72,'buff momo','110','6','660',NULL,NULL,'2018-01-11 21:13:31'),(73,'buff momo','110','4','440',NULL,NULL,'2018-01-11 21:13:31'),(74,NULL,NULL,NULL,NULL,'','2750','2018-01-11 21:13:31'),(75,'pizza','350','5','1750',NULL,NULL,'2018-01-11 21:21:51'),(76,'buff momo','110','6','660',NULL,NULL,'2018-01-11 21:21:51'),(77,'buff momo','110','4','440',NULL,NULL,'2018-01-11 21:21:51'),(78,NULL,NULL,NULL,NULL,'','2650','2018-01-11 21:21:51'),(79,'pizza','350','5','1750',NULL,NULL,'2018-01-11 21:27:26'),(80,'buff momo','110','6','660',NULL,NULL,'2018-01-11 21:27:26'),(81,'buff momo','110','4','440',NULL,NULL,'2018-01-11 21:27:26'),(82,NULL,NULL,NULL,NULL,'9','2594','2018-01-11 21:27:26'),(83,'pizza','350','5','1750',NULL,NULL,'2018-01-11 21:30:49'),(84,'buff momo','110','6','660',NULL,NULL,'2018-01-11 21:30:49'),(85,'buff momo','110','4','440',NULL,NULL,'2018-01-11 21:30:49'),(86,NULL,NULL,NULL,NULL,'10','2565','2018-01-11 21:30:49'),(87,'pizza','350','5','1750',NULL,NULL,'2018-01-11 21:34:39'),(88,'buff momo','110','6','660',NULL,NULL,'2018-01-11 21:34:39'),(89,'buff momo','110','4','440',NULL,NULL,'2018-01-11 21:34:39'),(90,NULL,NULL,NULL,NULL,'10','2565','2018-01-11 21:34:39'),(91,'pizza','350','5','1750',NULL,NULL,'2018-01-11 21:38:19'),(92,'buff momo','110','6','660',NULL,NULL,'2018-01-11 21:38:19'),(93,'buff momo','110','4','440',NULL,NULL,'2018-01-11 21:38:19'),(94,NULL,NULL,NULL,NULL,'10','2565','2018-01-11 21:38:19');

/*Table structure for table `tempbill` */

DROP TABLE IF EXISTS `tempbill`;

CREATE TABLE `tempbill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(100) DEFAULT NULL,
  `price` varchar(30) DEFAULT NULL,
  `qty` varchar(30) DEFAULT NULL,
  `qtytotal` varchar(40) DEFAULT NULL,
  `tablenum` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

/*Data for the table `tempbill` */

insert  into `tempbill`(`id`,`item`,`price`,`qty`,`qtytotal`,`tablenum`) values (1,'pizza','350','5','1750','21'),(3,'vodk','55','5','275','21'),(4,'buff momo','110','54','5940','23'),(5,'vodk','55','6','330','21'),(6,'vodka','550','7','3850','25'),(8,'pizza','350','5','1750','34'),(9,'sizzler','250','2','5750','37'),(10,'buff momo','110','5','550','37'),(11,'buff momo','110','6','660','36'),(12,'vodk','55','1','55','21'),(13,'vodk','55','6','330','21'),(14,'coke','50','6','300','28'),(18,'buff momo','110','7','770','33'),(21,'vodk','55','3','165','21'),(22,'vodk','55','7','385','29'),(23,'buff momo','110','6','660','29'),(24,'vodk','55','4','220','21'),(26,'vodk','55','7','385','21'),(27,'vodk','55','3','165','34'),(28,'vodk','55','1','55','39'),(29,'pizza','350','6','2100','39'),(35,'pizza','350','3','1050','21');

/*Table structure for table `tsales` */

DROP TABLE IF EXISTS `tsales`;

CREATE TABLE `tsales` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Item` varchar(100) DEFAULT NULL,
  `Price` varchar(50) DEFAULT NULL,
  `Quantity` varchar(30) DEFAULT NULL,
  `Tprice` varchar(30) DEFAULT NULL,
  `Discount` varchar(30) DEFAULT NULL,
  `Grand_Total` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tsales` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
