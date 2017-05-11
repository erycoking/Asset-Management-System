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
  `Userid` int(11) NOT NULL,
  `quantity` int(20) NOT NULL,
  `Fromdate_time` varchar(50) NOT NULL,
  `Todate_time` varchar(50) NOT NULL,
  `AllocatedbyID` int(15) DEFAULT NULL,
  `AllocationNumber` int(15) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`AllocationNumber`),
  UNIQUE KEY `AllocationNumber_UNIQUE` (`AllocationNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allocatedeqpmnts`
--

LOCK TABLES `allocatedeqpmnts` WRITE;
/*!40000 ALTER TABLE `allocatedeqpmnts` DISABLE KEYS */;
INSERT INTO `allocatedeqpmnts` VALUES (1,1,5,'April 7, 2017 3:49:pm','April 7, 2017 5:49:pm',NULL,1),(9,1,5,'noooope','2017-05-01 15:12:45',2,2),(9,1,5,'noooope','2017-05-01 15:58:50',2,3),(9,1,5,'noooope','2017-05-01 16:00:19',2,4),(10,2,2,'now','2017-05-01 18:21:12',2,5),(10,2,5,'dddddddddddd','2017-05-01 19:16:49',2,6),(1,1,5,'April 7, 2017 3:49:pm','2017-05-01 19:47:24',1,7),(1,1,5,'April 7, 2017 3:49:pm','2017-05-01 20:41:24',2,8),(9,1,5,'noooope','2017-05-02 16:03:05',2,9),(10,2,5,'time','2017-05-02 16:16:17',2,10);
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
  `Userid` int(20) NOT NULL,
  `date_time` varchar(50) NOT NULL,
  `Activity` text NOT NULL,
  PRIMARY KEY (`Auditid`),
  UNIQUE KEY `Auditid_UNIQUE` (`Auditid`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audittrail`
--

LOCK TABLES `audittrail` WRITE;
/*!40000 ALTER TABLE `audittrail` DISABLE KEYS */;
INSERT INTO `audittrail` VALUES (1,2,'April 7, 2017 3:49:pm','Logged in to LAMS'),(2,2,'April 7, 2017 3:49:pm','Logged in to LAMS'),(3,2,'April 7, 2017 3:49:pm','Logged in to LAMS'),(4,2,'April 7, 2017 3:49:pm','UserJohn DoeLogged in and booked1 Holders(Test tube/Beaker)in number'),(5,2,'April 7, 2017 3:49:pm','UserJohn DoeLogged in and booked2 Weighing Balancein number'),(6,2,'April 7, 2017 3:49:pm','Logged in to LAMS'),(7,1,'2017-05-01 09:40:32','Logged in to LAMS'),(8,1,'2017-05-01 11:27:55','Logged in to LAMS'),(9,2,'2017-05-01 12:07:59','Logged in to LAMS'),(10,2,'2017-05-01 12:39:57','Logged in to LAMS'),(11,2,'2017-05-01 13:11:47','Logged in to LAMS'),(12,2,'2017-05-01 13:17:16','Logged in to LAMS'),(13,2,'2017-05-01 14:29:59','Logged in to LAMS'),(14,2,'2017-05-01 14:38:55','Logged in to LAMS'),(15,2,'2017-05-01 14:45:01','Logged in to LAMS'),(16,2,'2017-05-01 14:52:22','Logged in to LAMS'),(17,2,'2017-05-01 14:54:40','Logged in to LAMS'),(18,2,'2017-05-01 14:56:03','Logged in to LAMS'),(19,2,'2017-05-01 15:00:42','Logged in to LAMS'),(20,2,'2017-05-01 15:05:01','Logged in to LAMS'),(21,2,'2017-05-01 15:12:29','Logged in to LAMS'),(22,2,'2017-05-01 15:17:10','User John Doe: Logged in and booked 2 Sulphuric Acid in number.'),(23,2,'2017-05-01 15:58:31','Logged in to LAMS'),(24,2,'2017-05-01 16:00:06','Logged in to LAMS'),(25,1,'2017-05-01 16:00:19','User John Doe: Logged in and booked 5 Tongs in number.'),(26,1,'2017-05-01 17:38:44','Logged in to LAMS'),(27,2,'2017-05-01 18:19:30','Logged in to LAMS'),(28,2,'2017-05-01 18:21:12','User John Doe: Logged in and allocated John Doe 2 Holders(Test tube/Beaker) in number.'),(29,1,'2017-05-01 18:22:46','Logged in to LAMS'),(30,2,'2017-05-01 18:28:00','Logged in to LAMS'),(31,1,'2017-05-01 18:37:12','Logged in to LAMS'),(32,2,'2017-05-01 18:41:07','Logged in to LAMS'),(33,1,'2017-05-01 18:42:38','Logged in to LAMS'),(34,2,'2017-05-01 18:45:45','Logged in to LAMS'),(35,1,'2017-05-01 18:48:10','Logged in to LAMS'),(36,2,'2017-05-01 19:00:18','Logged in to LAMS'),(37,2,'2017-05-01 19:11:58','Logged in to LAMS'),(38,2,'2017-05-01 19:16:49','User John Doe: Logged in and allocated John Doe 5 Holders(Test tube/Beaker) in number.'),(39,1,'2017-05-01 19:44:17','Logged in to LAMS'),(40,1,'2017-05-01 19:47:24','User matthew Thuo: Logged in and allocated matthew Thuo 5 Cathode RAy Oscilloscope in number.'),(41,2,'2017-05-01 20:34:14','Logged in to LAMS'),(42,1,'2017-05-01 20:41:24','User John Doe: Logged in and allocated matthew Thuo 5 Cathode RAy Oscilloscope in number.'),(43,2,'2017-05-02 16:01:50','Logged in to LAMS'),(44,1,'2017-05-02 16:03:05','User John Doe: Logged in and allocated matthew Thuo 5 Tongs in number.'),(45,2,'2017-05-02 16:15:21','User John Doe: Logged in and booked 5 Holders(Test tube/Beaker) in number.'),(46,2,'2017-05-02 16:16:18','User John Doe: Logged in and allocated John Doe 5 Holders(Test tube/Beaker) in number.'),(47,2,'2017-05-04 08:31:28','Logged in to LAMS'),(48,2,'2017-05-04 09:02:01','User John Doe: Logged in and booked 8 Clamp Stands in number.'),(49,2,'2017-05-04 09:02:02','User John Doe: Logged in and booked 8 Clamp Stands in number.'),(50,2,'2017-05-04 09:02:37','User John Doe: Logged in and booked 2 Clamp Stands in number.'),(51,2,'2017-05-04 09:02:40','User John Doe: Logged in and booked 2 Clamp Stands in number.'),(52,2,'2017-05-04 09:02:51','User John Doe: Logged in and booked 2 Clamp Stands in number.'),(53,2,'2017-05-04 09:02:55','User John Doe: Logged in and booked 2 Clamp Stands in number.');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookedeqpmnts`
--

LOCK TABLES `bookedeqpmnts` WRITE;
/*!40000 ALTER TABLE `bookedeqpmnts` DISABLE KEYS */;
INSERT INTO `bookedeqpmnts` VALUES (1,'',1,5,'April 7, 2017 3:49:pm','April 7, 2017 5:49:pm');
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipments`
--

LOCK TABLES `equipments` WRITE;
/*!40000 ALTER TABLE `equipments` DISABLE KEYS */;
INSERT INTO `equipments` VALUES (1,'Cathode RAy Oscilloscope',10000,'The eqpmentnt was from Britain imports',5,'Merchadise','September 7, 2015 3:49:pm'),(2,'X-Ray Machine',10000,'The eqpmentnt was from Britain imports',5,'Merchadise','September 7, 2015 3:49:pm'),(3,'Ammonia',10000,'The 20- twenty litres jerrican were supplied by Kenya chemicals Thika Branch',5,'Chemicals','2017-04-17 13:55:50'),(4,'Sodium Nitrate',10000,'The chemical was supplied and delivered by Keny chemicals ltd',5,'Chemicals','2017-04-18 09:56:55'),(5,'Sulphuric Acid',10000,'The chemical was supplied by Kenya chemicals Inc.',5,'Chemicals','2017-04-18 10:53:11'),(6,'Beakers',10000,'The  beakers were supplied by Kenafric Industries ltd Nakuru Branch',20,'Merchadise','2017-04-18 13:25:11'),(7,'Weighing Balance',10000,'The weighing balances were delivered by Amuz inc. Nakuru Branch .All wellpacked and compact',10,'Merchadise','2017-04-18 13:58:03'),(8,'Clamp Stands',10000,'The equipments were suppliedby Kasuku Ltd Nairobi branch.',8,'Merchadise','2017-04-18 13:59:44'),(9,'Tongs',10000,'The equipments were suppliedby Kasuku Ltd Nairobi branch.',50,'Merchadise','2017-04-18 14:00:33'),(10,'Holders(Test tube/Beaker)',10000,'The equipments were suppliedby Kasuku Ltd Nairobi branch.',50,'Merchadise','2017-04-18 14:01:19'),(11,'Holders(Test tube/Beaker)',10000,'The equipments were suppliedby Kasuku Ltd Nairobi branch.',50,'Merchadise','2017-04-18 14:01:46');
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unbookedeqpmnts`
--

LOCK TABLES `unbookedeqpmnts` WRITE;
/*!40000 ALTER TABLE `unbookedeqpmnts` DISABLE KEYS */;
INSERT INTO `unbookedeqpmnts` VALUES (1,'Cathode RAy Oscilloscope',10000,'The eqpmentnt was from Britain imports',7,'Merchadise','September 7, 2015 3:49:pm'),(2,'X- ray',10000,'The eqpmentnt was from Britain imports',0,'Merchadise','April 10, 2017 3:49:pm'),(3,'Ammonia',10000,'The 20- twenty litres jerrican were supplied by Kenya chemicals Thika Branch',3,'Chemicals','2017-04-17 13:55:50'),(4,'Sodium Nitrate',10000,'The chemical was supplied and delivered by Keny chemicals ltd',5,'Chemicals','2017-04-18 09:56:55'),(5,'Sulphuric Acid',10000,'The chemical was supplied by Kenya chemicals Inc.',0,'Chemicals','2017-04-18 10:53:11'),(6,'Beakers',10000,'The  beakers were supplied by Kenafric Industries ltd Nakuru Branch',0,'Merchadise','2017-04-18 13:25:12'),(7,'Weighing Balance',10000,'The weighing balances were delivered by Amuz inc. Nakuru Branch .All wellpacked and compact',4,'Merchadise','2017-04-18 13:58:03'),(8,'Clamp Stands',10000,'The equipments were suppliedby Kasuku Ltd Nairobi branch.',-16,'Merchadise','2017-04-18 13:59:45'),(9,'Tongs',10000,'The equipments were suppliedby Kasuku Ltd Nairobi branch.',16,'Merchadise','2017-04-18 14:00:33'),(10,'Holders(Test tube/Beaker)',10000,'The equipments were suppliedby Kasuku Ltd Nairobi branch.',14,'Merchadise','2017-04-18 14:01:20'),(11,'Holders(Test tube/Beaker)',10000,'The equipments were suppliedby Kasuku Ltd Nairobi branch.',45,'Merchadise','2017-04-18 14:01:46');
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
INSERT INTO `users` VALUES ('E13/13882/17','jogn mamam','','johnmalala','science','comp sci',756266624,'',''),('e13/27672/17','beverly nemayian','','mysister001','love','love you siz',745789546,'',''),('E13/48738/16','John Kinyanjui','','kinyanjui','Science','Biology',745123455,'',''),('E13/72387/12','Emmanuel Waganda','','emmanuel','Arts','Criminology',745421456,'',''),('e13/73546/14','mtu mzitosana','','mzitosana','science','biology',746521212,'',''),('e23/13737/16','erick loningo','','loningolomunyak','science','comp scie',746565455,'',''),('e23/18182/17','kevin lomunyak','','kevolomunyak','science','physics',701541789,'',''),('k13/36233/14','joy','','wanjiru72','science','physics',702554146,'',''),('S12/26871/25','Kelvin Ng\'ida','','iceheartphoenix','Arts','Psycology',702672127,'',''),('s13/20031/67','dennis kimani','','kimanidennis','science','physics',725166488,'',''),('S13/20045/12','Rodgers Tobiko','','bablets123','Science','Computer Science',714546721,'',''),('S13/20045/50','Beverly Nemayian','','nemayian','Science','Computer science',789456123,'',''),('S13/21221/44','Christine Wangare','','christine','Arts','Biology',746526564,'',''),('S13/38928/14','Philip nzau','','kenya2013','Science','Computer Science',702456478,'',''),('SP12/32780/61','joab muchiri','','joabmuchiri','science','comp sci',74564545,'',''),('SP13/20013/15','Manu Kerich','','emmanuel123','Science','Computer Science',702554236,'',''),('SP13/20031/14','Erick Loningo','','javaproject','Science','Computer Science',702554146,'',''),('SP13/20031/32','John Kimani','','kimanijohn','Science','Physics',724546475,'','');
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

-- Dump completed on 2017-05-04 10:50:39
