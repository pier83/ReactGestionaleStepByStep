/*
SQLyog Ultimate v8.55 
MySQL - 5.6.11 : Database - rest_ws
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rest_ws` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `rest_ws`;

/*Table structure for table `audit_ws` */

DROP TABLE IF EXISTS `audit_ws`;

CREATE TABLE `audit_ws` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_chiamante` varchar(200) DEFAULT NULL,
  `metodo_ws_chiamato` varchar(200) DEFAULT NULL,
  `url_ws_chiamato` varchar(200) DEFAULT NULL,
  `data_ora_chiamata` datetime DEFAULT NULL,
  `request` varchar(200) DEFAULT NULL,
  `response` blob,
  `errore` varchar(200) DEFAULT NULL,
  `tipo_chiamata` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
