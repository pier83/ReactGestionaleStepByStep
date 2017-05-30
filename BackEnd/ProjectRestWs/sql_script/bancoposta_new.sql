/*
SQLyog Ultimate v8.55 
MySQL - 5.6.11 : Database - bancoposta
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bancoposta` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bancoposta`;

/*Table structure for table `lista_movimenti` */

DROP TABLE IF EXISTS `lista_movimenti`;

CREATE TABLE `lista_movimenti` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_contabile` datetime DEFAULT NULL,
  `data_valuta` datetime DEFAULT NULL,
  `addebiti` double DEFAULT NULL,
  `accrediti` double DEFAULT NULL,
  `descrizione_operazioni` varchar(500) DEFAULT NULL,
  `codice_causale` varchar(50) DEFAULT NULL,
  `id_utente` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_lista_movimenti_utenti` (`id_utente`),
  CONSTRAINT `FK_lista_movimenti_utenti` FOREIGN KEY (`id_utente`) REFERENCES `utenti` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=843 DEFAULT CHARSET=latin1;

/*Data for the table `lista_movimenti` */



/*Table structure for table `tipologica_ruoli` */

DROP TABLE IF EXISTS `tipologica_ruoli`;

CREATE TABLE `tipologica_ruoli` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) DEFAULT NULL,
  `descrizione` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tipologica_ruoli` */

insert  into `tipologica_ruoli`(`id`,`nome`,`descrizione`) values (1,'ROLE_ADMIN','Amministratore'),(2,'ROLE_USER','Utente');

/*Table structure for table `tipologica_stato_utente` */

DROP TABLE IF EXISTS `tipologica_stato_utente`;

CREATE TABLE `tipologica_stato_utente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tipologica_stato_utente` */

insert  into `tipologica_stato_utente`(`id`,`descrizione`) values (1,'Attivo'),(2,'Disattivo');

/*Table structure for table `user_roles_ws` */

DROP TABLE IF EXISTS `user_roles_ws`;

CREATE TABLE `user_roles_ws` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `id_ruolo` bigint(20) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`id_ruolo`,`username`),
  KEY `fk_username_idx` (`username`),
  CONSTRAINT `FK_user_roles_ws` FOREIGN KEY (`id_ruolo`) REFERENCES `tipologica_ruoli` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `user_roles_ws` */

insert  into `user_roles_ws`(`user_role_id`,`username`,`id_ruolo`) values (1,'guest',1),(2,'test',1);

/*Table structure for table `utenti` */

DROP TABLE IF EXISTS `utenti`;

CREATE TABLE `utenti` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `id_stato_utente` bigint(20) DEFAULT NULL,
  `saldo_iniziale` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_utenti_stati_utente` (`id_stato_utente`),
  CONSTRAINT `FK_utenti_stati_utente` FOREIGN KEY (`id_stato_utente`) REFERENCES `tipologica_stato_utente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `utenti` */

insert  into `utenti`(`id`,`nome`,`password`,`id_stato_utente`,`saldo_iniziale`) values (5,'guest','123456',1,0),(6,'test','123456',2,100);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
