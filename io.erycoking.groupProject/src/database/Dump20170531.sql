-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: asset_management
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `allocatedeqpmnts`
--

DROP TABLE IF EXISTS `allocatedeqpmnts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `allocatedeqpmnts` (
  `eqpID` int(11) NOT NULL,
  `Userid` varchar(15) NOT NULL,
  `quantity` int(20) NOT NULL,
  `Fromdate_time` varchar(50) NOT NULL,
  `Todate_time` varchar(50) NOT NULL,
  `AllocatedbyID` varchar(15) DEFAULT NULL,
  `AllocationNumber` int(15) NOT NULL AUTO_INCREMENT,
  `BookID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`AllocationNumber`),
  UNIQUE KEY `AllocationNumber_UNIQUE` (`AllocationNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allocatedeqpmnts`
--

LOCK TABLES `allocatedeqpmnts` WRITE;
/*!40000 ALTER TABLE `allocatedeqpmnts` DISABLE KEYS */;
INSERT INTO `allocatedeqpmnts` VALUES (1,'E13/48738/16',5,'April 7, 2017 3:49:pm','April 7, 2017 5:49:pm','S13/213777/14',1,NULL),(9,'1',5,'noooope','2017-05-01 15:12:45','2',2,NULL),(9,'1',5,'noooope','2017-05-01 15:58:50','2',3,NULL),(9,'1',5,'noooope','2017-05-01 16:00:19','2',4,NULL),(10,'2',2,'now','2017-05-01 18:21:12','2',5,NULL),(10,'2',5,'dddddddddddd','2017-05-01 19:16:49','2',6,NULL),(1,'1',5,'April 7, 2017 3:49:pm','2017-05-01 19:47:24','1',7,NULL),(1,'1',5,'April 7, 2017 3:49:pm','2017-05-01 20:41:24','2',8,NULL),(9,'1',5,'noooope','2017-05-02 16:03:05','2',9,NULL),(10,'2',5,'time','2017-05-02 16:16:17','2',10,NULL),(11,'S13/21221/44',45,'yea','yeaaasss','S13/213777/14',11,NULL),(3,'S13/21221/44',45,'11','2017-05-16 19:41:35','S13/213777/14',12,'3'),(4,'E13/48738/16',7,'11','2017-05-16 19:53:05','S13/213777/14',13,'4');
/*!40000 ALTER TABLE `allocatedeqpmnts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audittrail`
--

DROP TABLE IF EXISTS `audittrail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audittrail` (
  `Auditid` int(11) NOT NULL AUTO_INCREMENT,
  `Userid` varchar(20) NOT NULL,
  `date_time` varchar(50) NOT NULL,
  `Activity` text NOT NULL,
  PRIMARY KEY (`Auditid`),
  UNIQUE KEY `Auditid_UNIQUE` (`Auditid`)
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audittrail`
--

LOCK TABLES `audittrail` WRITE;
/*!40000 ALTER TABLE `audittrail` DISABLE KEYS */;
INSERT INTO `audittrail` VALUES (1,'2','April 7, 2017 3:49:pm','Logged in to LAMS'),(2,'2','April 7, 2017 3:49:pm','Logged in to LAMS'),(3,'2','April 7, 2017 3:49:pm','Logged in to LAMS'),(4,'2','April 7, 2017 3:49:pm','UserJohn DoeLogged in and booked1 Holders(Test tube/Beaker)in number'),(5,'2','April 7, 2017 3:49:pm','UserJohn DoeLogged in and booked2 Weighing Balancein number'),(6,'2','April 7, 2017 3:49:pm','Logged in to LAMS'),(7,'1','2017-05-01 09:40:32','Logged in to LAMS'),(8,'1','2017-05-01 11:27:55','Logged in to LAMS'),(9,'2','2017-05-01 12:07:59','Logged in to LAMS'),(10,'2','2017-05-01 12:39:57','Logged in to LAMS'),(11,'2','2017-05-01 13:11:47','Logged in to LAMS'),(12,'2','2017-05-01 13:17:16','Logged in to LAMS'),(13,'2','2017-05-01 14:29:59','Logged in to LAMS'),(14,'2','2017-05-01 14:38:55','Logged in to LAMS'),(15,'2','2017-05-01 14:45:01','Logged in to LAMS'),(16,'2','2017-05-01 14:52:22','Logged in to LAMS'),(17,'2','2017-05-01 14:54:40','Logged in to LAMS'),(18,'2','2017-05-01 14:56:03','Logged in to LAMS'),(19,'2','2017-05-01 15:00:42','Logged in to LAMS'),(20,'2','2017-05-01 15:05:01','Logged in to LAMS'),(21,'2','2017-05-01 15:12:29','Logged in to LAMS'),(22,'2','2017-05-01 15:17:10','User John Doe: Logged in and booked 2 Sulphuric Acid in number.'),(23,'2','2017-05-01 15:58:31','Logged in to LAMS'),(24,'2','2017-05-01 16:00:06','Logged in to LAMS'),(25,'1','2017-05-01 16:00:19','User John Doe: Logged in and booked 5 Tongs in number.'),(26,'1','2017-05-01 17:38:44','Logged in to LAMS'),(27,'2','2017-05-01 18:19:30','Logged in to LAMS'),(28,'2','2017-05-01 18:21:12','User John Doe: Logged in and allocated John Doe 2 Holders(Test tube/Beaker) in number.'),(29,'1','2017-05-01 18:22:46','Logged in to LAMS'),(30,'2','2017-05-01 18:28:00','Logged in to LAMS'),(31,'1','2017-05-01 18:37:12','Logged in to LAMS'),(32,'2','2017-05-01 18:41:07','Logged in to LAMS'),(33,'1','2017-05-01 18:42:38','Logged in to LAMS'),(34,'2','2017-05-01 18:45:45','Logged in to LAMS'),(35,'1','2017-05-01 18:48:10','Logged in to LAMS'),(36,'2','2017-05-01 19:00:18','Logged in to LAMS'),(37,'2','2017-05-01 19:11:58','Logged in to LAMS'),(38,'2','2017-05-01 19:16:49','User John Doe: Logged in and allocated John Doe 5 Holders(Test tube/Beaker) in number.'),(39,'1','2017-05-01 19:44:17','Logged in to LAMS'),(40,'1','2017-05-01 19:47:24','User matthew Thuo: Logged in and allocated matthew Thuo 5 Cathode RAy Oscilloscope in number.'),(41,'2','2017-05-01 20:34:14','Logged in to LAMS'),(42,'1','2017-05-01 20:41:24','User John Doe: Logged in and allocated matthew Thuo 5 Cathode RAy Oscilloscope in number.'),(43,'2','2017-05-02 16:01:50','Logged in to LAMS'),(44,'1','2017-05-02 16:03:05','User John Doe: Logged in and allocated matthew Thuo 5 Tongs in number.'),(45,'2','2017-05-02 16:15:21','User John Doe: Logged in and booked 5 Holders(Test tube/Beaker) in number.'),(46,'2','2017-05-02 16:16:18','User John Doe: Logged in and allocated John Doe 5 Holders(Test tube/Beaker) in number.'),(47,'2','2017-05-04 08:31:28','Logged in to LAMS'),(48,'2','2017-05-04 09:02:01','User John Doe: Logged in and booked 8 Clamp Stands in number.'),(49,'2','2017-05-04 09:02:02','User John Doe: Logged in and booked 8 Clamp Stands in number.'),(50,'2','2017-05-04 09:02:37','User John Doe: Logged in and booked 2 Clamp Stands in number.'),(51,'2','2017-05-04 09:02:40','User John Doe: Logged in and booked 2 Clamp Stands in number.'),(52,'2','2017-05-04 09:02:51','User John Doe: Logged in and booked 2 Clamp Stands in number.'),(53,'2','2017-05-04 09:02:55','User John Doe: Logged in and booked 2 Clamp Stands in number.'),(54,'S13/213777/14','2017-05-06 01:59:01','Logged in to LAMS'),(55,'S13/213777/14','2017-05-06 02:16:05','Logged in to LAMS'),(56,'E13/48738/16','2017-05-06 02:17:32','Logged in to LAMS'),(57,'E13/48738/16','2017-05-06 02:20:06','Logged in to LAMS'),(58,'E13/48738/16','2017-05-06 02:23:40','Logged in to LAMS'),(59,'S13/21221/44','2017-05-06 02:29:16','Logged in to LAMS'),(60,'S13/21221/44','2017-05-06 02:31:44','Logged in to LAMS'),(61,'E13/48738/16','2017-05-10 12:37:29','Logged in to LAMS'),(62,'E13/48738/16','2017-05-10 18:25:55','Logged in to LAMS'),(63,'E13/48738/16','2017-05-10 18:30:15','Logged in to LAMS'),(64,'E13/48738/16','2017-05-10 19:21:55','Logged in to LAMS'),(65,'S13/213777/14','2017-05-10 20:16:49','Logged in to LAMS'),(66,'S13/213777/14','2017-05-10 20:19:57','Logged in to LAMS'),(67,'S13/213777/14','2017-05-10 20:27:07','Logged in to LAMS'),(68,'S13/213777/14','2017-05-10 20:32:44','Logged in to LAMS'),(69,'E13/48738/16','2017-05-10 20:34:16','Logged in to LAMS'),(70,'S13/21379/14','2017-05-10 21:51:23','Logged in to LAMS'),(71,'E13/48738/16','2017-05-10 22:00:12','Logged in to LAMS'),(72,'S13/21379/14','2017-05-10 22:08:36','Logged in to LAMS'),(73,'E13/48738/16','2017-05-10 22:14:45','Logged in to LAMS'),(74,'S13/21379/14','2017-05-10 22:34:05','Logged in to LAMS'),(75,'E13/48738/16','2017-05-10 22:35:08','Logged in to LAMS'),(76,'S13/213777/14','2017-05-10 22:37:48','Logged in to LAMS'),(77,'E13/48738/16','2017-05-10 23:10:19','Logged in to LAMS'),(78,'E13/48738/16','2017-05-10 23:12:27','Logged in to LAMS'),(79,'E13/48738/16','2017-05-11 00:02:04','Logged in to LAMS'),(80,'E13/48738/16','2017-05-11 00:03:08','Logged in to LAMS'),(81,'E13/48738/16','2017-05-11 00:05:59','Logged in to LAMS'),(82,'E13/48738/16','2017-05-11 00:18:20','Logged in to LAMS'),(83,'E13/48738/16','2017-05-11 00:20:18','Logged in to LAMS'),(84,'E13/48738/16','2017-05-11 00:26:40','Logged in to LAMS'),(85,'E13/48738/16','2017-05-11 00:35:57','Logged in to LAMS'),(86,'E13/48738/16','2017-05-14 10:39:08','Logged in to LAMS'),(87,'S13/213777/14','2017-05-14 10:46:08','Logged in to LAMS'),(88,'S13/21379/14','2017-05-14 10:47:00','Logged in to LAMS'),(89,'S13/213777/14','2017-05-14 11:46:56','Logged in to LAMS'),(90,'S13/213777/14','2017-05-14 12:40:21','Logged in to LAMS'),(91,'S13/213777/14','2017-05-14 12:43:49','Logged in to LAMS'),(92,'S13/213777/14','2017-05-14 13:07:31','Logged in to LAMS'),(93,'S13/213777/14','2017-05-14 13:13:14','Logged in to LAMS'),(94,'S13/213777/14','2017-05-14 13:21:46','Logged in to LAMS'),(95,'S13/213777/14','2017-05-14 13:34:45','Logged in to LAMS'),(96,'S13/213777/14','2017-05-14 13:37:18','Logged in to LAMS'),(97,'S13/213777/14','2017-05-14 13:41:36','Logged in to LAMS'),(98,'S13/213777/14','2017-05-14 13:43:44','Logged in to LAMS'),(99,'S13/213777/14','2017-05-14 14:00:41','Logged in to LAMS'),(100,'S13/213777/14','2017-05-14 14:02:43','Logged in to LAMS'),(101,'S13/213777/14','2017-05-14 14:05:05','Logged in to LAMS'),(102,'E13/48738/16','2017-05-15 15:33:20','Logged in to LAMS'),(103,'E13/48738/16','2017-05-15 17:07:19','Logged in to LAMS'),(104,'S13/213777/14','2017-05-15 17:30:58','Logged in to LAMS'),(105,'S13/213777/14','2017-05-15 17:35:33','Logged in to LAMS'),(106,'E13/48738/16','2017-05-15 18:29:25','Logged in to LAMS'),(107,'E13/48738/16','2017-05-15 18:36:01','Logged in to LAMS'),(108,'E13/48738/16','2017-05-15 19:15:04','Logged in to LAMS'),(109,'S13/213777/14','2017-05-15 22:49:23','Logged in to LAMS'),(110,'E13/48738/16','2017-05-16 12:21:28','Logged in to LAMS'),(111,'E13/48738/16','2017-05-16 15:28:41','Logged in to LAMS'),(112,'E13/48738/16','2017-05-16 15:41:08','Logged in to LAMS'),(113,'S13/213777/14','2017-05-16 15:42:12','Logged in to LAMS'),(114,'S13/21379/14','2017-05-16 15:43:16','Logged in to LAMS'),(115,'E13/48738/16','2017-05-16 17:24:39','Logged in to LAMS'),(116,'E13/48738/16','2017-05-16 17:30:00','Logged in to LAMS'),(117,'S13/213777/14','2017-05-16 18:44:46','Logged in to LAMS'),(118,'S13/213777/14','2017-05-16 18:52:42','Logged in to LAMS'),(119,'S13/213777/14','2017-05-16 19:25:47','Logged in to LAMS'),(120,'S13/213777/14','2017-05-16 19:28:33','Logged in to LAMS'),(121,'S13/213777/14','2017-05-16 19:36:30','Logged in to LAMS'),(122,'S13/213777/14','2017-05-16 19:41:29','Logged in to LAMS'),(123,'E13/48738/16','2017-05-16 19:45:09','Logged in to LAMS'),(124,'E13/48738/16','2017-05-16 19:49:48','Logged in to LAMS'),(125,'S13/213777/14','2017-05-16 19:52:05','Logged in to LAMS'),(126,'E13/48738/16','2017-05-16 19:53:06','User franco: Logged in and allocated John Kinyanjui 0 null in number.'),(127,'E13/48738/16','2017-05-17 16:29:57','Logged in to LAMS'),(128,'S13/213777/14','2017-05-17 16:32:39','Logged in to LAMS'),(129,'S13/213777/14','2017-05-17 16:36:38','Logged in to LAMS'),(130,'E13/48738/16','2017-05-17 16:37:30','Logged in to LAMS'),(131,'E13/48738/16','2017-05-17 16:53:28','Logged in to LAMS'),(132,'E13/48738/16','2017-05-17 18:02:45','Logged in to LAMS'),(133,'E13/48738/16','2017-05-17 18:35:43','Logged in to LAMS'),(134,'E13/48738/16','2017-05-17 19:08:51','Logged in to LAMS'),(135,'E13/48738/16','2017-05-17 19:10:17','User james: Logged in and booked 4 Holders(Test tube/Beaker) in number.'),(136,'E13/48738/16','2017-05-17 19:20:09','User james: Logged in and booked 8 Holders(Test tube/Beaker) in number.'),(137,'E13/48738/16','2017-05-17 19:22:49','Logged in to LAMS'),(138,'E13/48738/16','2017-05-17 19:27:43','Logged in to LAMS'),(139,'E13/48738/16','2017-05-17 19:31:34','User james: Logged in and booked 2 Sodium Nitrate in number.'),(140,'E13/48738/16','2017-05-17 19:36:49','Logged in to LAMS'),(141,'S13/213777/14','2017-05-17 21:41:20','Logged in to LAMS'),(142,'E13/48738/16','2017-05-17 21:41:35','Logged in to LAMS'),(143,'E13/48738/16','2017-05-17 22:03:06','Logged in to LAMS'),(144,'E13/48738/16','2017-05-17 22:04:12','Logged in to LAMS'),(145,'E13/48738/16','2017-05-17 22:06:09','Unbooked the previous booking ofHolders(Test tube/Beaker): Book  reference Number6'),(146,'E13/48738/16','2017-05-17 22:10:19','Unbooked the previous booking of: Book  reference Number7'),(147,'E13/48738/16','2017-05-17 22:12:32','Unbooked the previous booking of: Book  reference Number8'),(148,'E13/48738/16','2017-05-17 22:12:39','Unbooked the previous booking ofAmmonia: Book  reference Number9'),(149,'E13/48738/16','2017-05-17 22:26:39','User james: Logged in and booked 0 Ammonia in number.'),(150,'E13/48738/16','2017-05-17 23:06:09','Logged in to LAMS'),(151,'E13/48738/16','2017-05-17 23:06:30','User james: Logged in and booked 4 CANS in number.'),(152,'E13/48738/16','2017-05-17 23:06:44','Unbooked the previous booking ofAmmonia: Book  reference Number13'),(153,'E13/48738/16','2017-05-17 23:11:15','Logged in to LAMS'),(154,'E13/48738/16','2017-05-17 23:11:51','Unbooked the previous booking of: Book  reference Number16'),(155,'E13/48738/16','2017-05-17 23:11:58','Unbooked the previous booking of: Book  reference Number16'),(156,'E13/48738/16','2017-05-17 23:12:03','Unbooked the previous booking of: Book  reference Number16'),(157,'E13/48738/16','2017-05-17 23:12:10','Unbooked the previous booking of: Book  reference Number16'),(158,'E13/48738/16','2017-05-17 23:12:16','Unbooked the previous booking of: Book  reference Number17'),(159,'E13/48738/16','2017-05-17 23:12:21','Unbooked the previous booking of: Book  reference Number17'),(160,'E13/48738/16','2017-05-17 23:12:28','Unbooked the previous booking of: Book  reference Number18'),(161,'E13/48738/16','2017-05-17 23:12:33','Unbooked the previous booking of: Book  reference Number18'),(162,'E13/48738/16','2017-05-17 23:12:40','Unbooked the previous booking of: Book  reference Number19'),(163,'E13/48738/16','2017-05-17 23:12:57','Unbooked the previous booking of: Book  reference Number10'),(164,'E13/48738/16','2017-05-17 23:13:02','Unbooked the previous booking of: Book  reference Number11'),(165,'E13/48738/16','2017-05-17 23:13:36','User james: Logged in and booked 10 Holders(Test tube/Beaker) in number.'),(166,'E13/48738/16','2017-05-17 23:33:00','Logged in to LAMS'),(167,'E13/48738/16','2017-05-17 23:34:01','Logged in to LAMS'),(168,'S13/213777/14','2017-05-18 08:53:54','Logged in to LAMS'),(169,'E13/48738/16','2017-05-18 11:08:10','Logged in to LAMS'),(170,'S13/213777/14','2017-05-18 18:36:05','Logged in to LAMS'),(171,'E13/48738/16','2017-05-18 18:37:02','Logged in to LAMS'),(172,'E13/48738/16','2017-05-18 18:53:12','Logged in to LAMS'),(173,'E13/48738/16','2017-05-18 18:55:20','Logged in to LAMS'),(174,'E13/48738/16','2017-05-18 19:14:22','Logged in to LAMS'),(175,'E13/48738/16','2017-05-18 19:18:39','Logged in to LAMS'),(176,'E13/48738/16','2017-05-18 19:21:54','Logged in to LAMS'),(177,'E13/48738/16','2017-05-18 19:26:08','Logged in to LAMS'),(178,'E13/48738/16','2017-05-18 19:31:23','Logged in to LAMS'),(179,'E13/48738/16','2017-05-18 19:49:41','Logged in to LAMS'),(180,'E13/48738/16','2017-05-18 19:51:47','Logged in to LAMS'),(181,'E13/48738/16','2017-05-18 19:52:13','User james: Logged in and booked 1 Holders(Test tube/Beaker) in number.'),(182,'E13/48738/16','2017-05-18 19:59:11','Logged in to LAMS'),(183,'E13/48738/16','2017-05-18 20:18:37','Logged in to LAMS'),(184,'E13/48738/16','2017-05-18 20:19:16','User james: Logged in and booked 1 Holders(Test tube/Beaker) in number.'),(185,'E13/48738/16','2017-05-18 20:58:37','Logged in to LAMS'),(186,'E13/48738/16','2017-05-18 21:00:33','Logged in to LAMS'),(187,'E13/48738/16','2017-05-18 21:01:58','Logged in to LAMS'),(188,'E13/48738/16','2017-05-18 22:12:53','Logged in to LAMS'),(189,'E13/48738/16','2017-05-18 22:24:16','Logged in to LAMS'),(190,'E13/48738/16','2017-05-18 22:26:10','User james: Logged in and booked 4 CANS in number.'),(191,'E13/48738/16','2017-05-20 12:00:39','Logged in to LAMS'),(192,'S13/213777/14','2017-05-20 12:01:39','Logged in to LAMS'),(193,'E13/48738/16','2017-05-20 12:04:18','User james: Logged in and booked 14 Holders(Test tube/Beaker) in number.'),(194,'E13/48738/16','2017-05-20 12:04:47','User james: Logged in and booked 0 Holders(Test tube/Beaker) in number.'),(195,'E13/48738/16','2017-05-20 12:04:55','User james: Logged in and booked 0 Holders(Test tube/Beaker) in number.'),(196,'E13/48738/16','2017-05-20 12:29:34','Logged in to LAMS'),(197,'E13/48738/16','2017-05-20 12:36:49','Logged in to LAMS'),(198,'E13/48738/16','2017-05-20 12:48:35','Logged in to LAMS'),(199,'E13/48738/16','2017-05-20 12:50:34','Logged in to LAMS'),(200,'S13/21379/14','2017-05-21 23:51:29','Logged in to LAMS'),(201,'S13/21379/14','2017-05-21 23:56:57','Logged in to LAMS'),(202,'S13/21379/14','2017-05-22 00:00:21','Logged in to LAMS'),(203,'S13/21379/14','2017-05-22 00:08:52','Logged in to LAMS'),(204,'S13/21379/14','2017-05-22 00:30:25','Logged in to LAMS'),(205,'S13/21379/14','2017-05-22 12:11:53','Logged in to LAMS'),(206,'S13/21379/14','2017-05-22 12:18:14','Logged in to LAMS'),(207,'S13/21379/14','2017-05-22 12:20:04','Logged in to LAMS'),(208,'S13/21379/14','2017-05-22 12:25:37','Logged in to LAMS'),(209,'S13/21379/14','2017-05-22 12:37:20','Logged in to LAMS'),(210,'S13/21379/14','2017-05-22 12:42:25','Logged in to LAMS'),(211,'S13/21379/14','2017-05-22 12:53:33','Logged in to LAMS'),(212,'S13/21379/14','2017-05-28 08:34:45','Logged in to LAMS'),(213,'S13/21379/14','2017-05-28 08:54:46','Logged in to LAMS'),(214,'S13/21379/14','2017-05-28 09:05:27','Logged in to LAMS'),(215,'S13/21379/14','2017-05-28 09:22:34','Logged in to LAMS'),(216,'S13/21379/14','2017-05-28 09:30:30','Logged in to LAMS'),(217,'S13/21379/14','2017-05-28 09:39:59','Logged in to LAMS'),(218,'S13/21379/14','2017-05-28 10:57:33','Logged in to LAMS'),(219,'S13/21379/14','2017-05-28 10:58:34','Logged in to LAMS'),(220,'S13/21379/14','2017-05-28 11:19:13','Logged in to LAMS'),(221,'S13/21379/14','2017-05-30 16:15:13','Logged in to LAMS'),(222,'S13/213777/14','2017-05-30 16:20:33','Logged in to LAMS'),(223,'E13/48738/16','2017-05-30 17:07:04','Logged in to LAMS'),(224,'E13/48738/16','2017-05-30 17:07:23','User james: Logged in and booked 3 Ammonia in number.'),(225,'E13/48738/16','2017-05-30 17:14:49','Logged in to LAMS'),(226,'S13/213777/14','2017-05-31 13:51:13','Logged in to LAMS'),(227,'E13/48738/16','2017-05-31 13:55:03','Logged in to LAMS'),(228,'S13/21379/14','2017-05-31 13:57:43','Logged in to LAMS'),(229,'S13/213777/14','2017-05-31 14:08:27','Logged in to LAMS'),(230,'E13/48738/16','2017-05-31 15:21:37','Logged in to LAMS'),(231,'S13/21379/14','2017-05-31 15:25:22','Logged in to LAMS'),(232,'S13/213777/14','2017-05-31 15:29:14','Logged in to LAMS');
/*!40000 ALTER TABLE `audittrail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookedeqpmnts`
--

DROP TABLE IF EXISTS `bookedeqpmnts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookedeqpmnts` (
  `bookId` int(50) NOT NULL AUTO_INCREMENT,
  `userId` varchar(45) NOT NULL,
  `eqpID` int(11) NOT NULL,
  `quantity` int(20) NOT NULL,
  `Fromdate_time` varchar(50) NOT NULL,
  `Todate_time` varchar(50) NOT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookedeqpmnts`
--

LOCK TABLES `bookedeqpmnts` WRITE;
/*!40000 ALTER TABLE `bookedeqpmnts` DISABLE KEYS */;
INSERT INTO `bookedeqpmnts` VALUES (2,'S13/21221/44',9,16,'2017-05-06','2017-05-06'),(5,'E13/48738/16',10,4,'2017-06-08','2017-06-09'),(14,'E13/48738/16',3,3,'null','i have changed'),(15,'E13/48738/16',12,4,'2017-05-18','2017-05-20'),(20,'E13/48738/16',11,10,'2017-05-18','2017-05-20'),(21,'null',10,10,'null','null'),(23,'E13/48738/16',11,2,'null','null'),(25,'E13/48738/16',11,1,'null','null');
/*!40000 ALTER TABLE `bookedeqpmnts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipments`
--

DROP TABLE IF EXISTS `equipments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipments` (
  `eqpID` int(11) NOT NULL AUTO_INCREMENT,
  `eqpname` varchar(50) NOT NULL,
  `eqpcost` int(20) NOT NULL,
  `eqpdetails` text NOT NULL,
  `quantity` int(20) NOT NULL,
  `eqpcategory` varchar(50) NOT NULL,
  `date_created` varchar(50) NOT NULL,
  PRIMARY KEY (`eqpID`),
  UNIQUE KEY `eqpID_UNIQUE` (`eqpID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipments`
--

LOCK TABLES `equipments` WRITE;
/*!40000 ALTER TABLE `equipments` DISABLE KEYS */;
INSERT INTO `equipments` VALUES (1,'Cathode RAy Oscilloscope',10000,'The eqpmentnt was from Britain imports',5,'Merchadise','September 7, 2015 3:49:pm'),(2,'X-Ray Machine',10000,'The eqpmentnt was from Britain imports',5,'Merchadise','September 7, 2015 3:49:pm'),(3,'Ammonia',10000,'The 20- twenty litres jerrican were supplied by Kenya chemicals Thika Branch',5,'Chemicals','2017-04-17 13:55:50'),(4,'Sodium Nitrate',10000,'The chemical was supplied and delivered by Keny chemicals ltd',5,'Chemicals','2017-04-18 09:56:55'),(5,'Sulphuric Acid',10000,'The chemical was supplied by Kenya chemicals Inc.',5,'Chemicals','2017-04-18 10:53:11'),(6,'Beakers',10000,'The  beakers were supplied by Kenafric Industries ltd Nakuru Branch',20,'Merchadise','2017-04-18 13:25:11'),(7,'Weighing Balance',10000,'The weighing balances were delivered by Amuz inc. Nakuru Branch .All wellpacked and compact',10,'Merchadise','2017-04-18 13:58:03'),(8,'Clamp Stands',10000,'The equipments were suppliedby Kasuku Ltd Nairobi branch.',8,'Merchadise','2017-04-18 13:59:44'),(9,'Tongs',10000,'The equipments were suppliedby Kasuku Ltd Nairobi branch.',50,'Merchadise','2017-04-18 14:00:33'),(10,'Holders(Test tube/Beaker)',10000,'The equipments were suppliedby Kasuku Ltd Nairobi branch.',50,'Merchadise','2017-04-18 14:01:19'),(11,'Holders(Test tube/Beaker)',10000,'The equipments were suppliedby Kasuku Ltd Nairobi branch.',50,'Merchadise','2017-04-18 14:01:46'),(12,'CANS',10000,'The equipment was supplied by kenya Industries ltd',12,'Merchadise','2017-05-14 12:47:11'),(13,'',3,'',2,'','2017-05-14 13:23:13'),(14,'',1,'',1,'','2017-05-14 13:36:15');
/*!40000 ALTER TABLE `equipments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `name` varchar(50) NOT NULL,
  `regno` varchar(45) NOT NULL,
  `rolel` varchar(45) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unbookedeqpmnts`
--

DROP TABLE IF EXISTS `unbookedeqpmnts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unbookedeqpmnts` (
  `eqpID` int(11) NOT NULL AUTO_INCREMENT,
  `eqpname` varchar(50) NOT NULL,
  `eqpcost` int(20) NOT NULL,
  `eqpdetails` text NOT NULL,
  `quantity` int(20) NOT NULL,
  `eqpcategory` varchar(50) NOT NULL,
  `date_created` varchar(50) NOT NULL,
  PRIMARY KEY (`eqpID`),
  UNIQUE KEY `eqpID_UNIQUE` (`eqpID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unbookedeqpmnts`
--

LOCK TABLES `unbookedeqpmnts` WRITE;
/*!40000 ALTER TABLE `unbookedeqpmnts` DISABLE KEYS */;
INSERT INTO `unbookedeqpmnts` VALUES (1,'Cathode RAy Oscilloscope',10000,'The eqpmentnt was from Britain imports',7,'Merchadise','September 7, 2015 3:49:pm'),(4,'Sodium Nitrate',10000,'The chemical was supplied and delivered by Keny chemicals ltd',3,'Chemicals','2017-04-18 09:56:55'),(7,'Weighing Balance',10000,'The weighing balances were delivered by Amuz inc. Nakuru Branch .All wellpacked and compact',4,'Merchadise','2017-04-18 13:58:03'),(8,'Clamp Stands',10000,'The equipments were suppliedby Kasuku Ltd Nairobi branch.',-16,'Merchadise','2017-04-18 13:59:45'),(9,'Tongs',10000,'The equipments were suppliedby Kasuku Ltd Nairobi branch.',10,'Merchadise','2017-04-18 14:00:33'),(10,'Holders(Test tube/Beaker)',10000,'The equipments were suppliedby Kasuku Ltd Nairobi branch.',10,'Merchadise','2017-04-18 14:01:20');
/*!40000 ALTER TABLE `unbookedeqpmnts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `staff_id` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `faculty` varchar(50) NOT NULL,
  `department` varchar(50) NOT NULL,
  `telephone_no` int(15) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('E13/48738/16','John Kinyanjui','james','kinyanjui','Science','Biology',745123455,'','normal'),('E13/72387/12','Emmanuel Waganda','','emmanuel','Arts','Criminology',745421456,'',''),('e13/73546/14','mtu mzitosana','','mzitosana','science','biology',746521212,'',''),('e23/13737/16','erick loningo','','loningolomunyak','science','comp scie',746565455,'',''),('e23/18182/17','kevin lomunyak','','kevolomunyak','science','physics',701541789,'',''),('Ep13/21453/14','John Kamau','calister','calister','Education','Education',715073168,'0715073168','admin'),('k13/36233/14','joy','','wanjiru72','science','physics',702554146,'',''),('S12/26871/25','Kelvin Ng\'ida','','iceheartphoenix','Arts','Psycology',702672127,'',''),('s13/20031/67','dennis kimani','','kimanidennis','science','physics',725166488,'',''),('S13/20045/12','Rodgers Tobiko','','bablets123','Science','Computer Science',714546721,'',''),('S13/20045/50','Beverly Nemayian','','nemayian','Science','Computer science',789456123,'',''),('S13/21221/44','Christine Wangare','chrisy','christine','Arts','Biology',746526564,'',''),('S13/213777/14','franco','franco','aj','love','love you siz',745789546,'thu@gmail.com','admin'),('S13/21379/14','Matthew Thuo','admin','th95matttt','science','comp sci',756266624,'thuomattthew95@gmail.com','superadmin'),('S13/38928/14','Philip nzau','','kenya2013','Science','Computer Science',702456478,'',''),('SP12/32780/61','joab muchiri','','joabmuchiri','science','comp sci',74564545,'',''),('SP13/20013/15','Manu Kerich','','emmanuel123','Science','Computer Science',702554236,'',''),('SP13/20031/14','Erick Loningo','','javaproject','Science','Computer Science',702554146,'',''),('SP13/20031/32','John Kimani','','kimanijohn','Science','Physics',724546475,'','');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-31 15:40:44
