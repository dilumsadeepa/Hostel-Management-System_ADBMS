-- MySQL dump 10.13  Distrib 8.0.35, for Linux (x86_64)
--
-- Host: newhms.cg5qaw4gi36b.us-east-1.rds.amazonaws.com    Database: hms
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Temporary view structure for view `ViewMaintaince`
--

DROP TABLE IF EXISTS `ViewMaintaince`;
/*!50001 DROP VIEW IF EXISTS `ViewMaintaince`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `ViewMaintaince` AS SELECT 
 1 AS `maintenance_id`,
 1 AS `maintaince_complaint_id`,
 1 AS `maintaince_handler`,
 1 AS `maintaince_status`,
 1 AS `maintaince_inspection_note`,
 1 AS `maintaince_solution`,
 1 AS `maintaince_evidence_image`,
 1 AS `maintaince_date`,
 1 AS `complaint_complaint_id`,
 1 AS `complaint_user_id`,
 1 AS `complaint_res_id`,
 1 AS `users_id`,
 1 AS `users_username`,
 1 AS `users_email`,
 1 AS `resource_res_id`,
 1 AS `resource_res_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `complaint`
--

DROP TABLE IF EXISTS `complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaint` (
  `complaint_id` int NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `user_id` int NOT NULL,
  `user_index` varchar(255) NOT NULL,
  `complaint` text NOT NULL,
  `res_id` int NOT NULL,
  `complaint_date` date DEFAULT (curdate()),
  `evidence_image` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT 'pending',
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`complaint_id`),
  KEY `user_id` (`user_id`),
  KEY `user_index` (`user_index`),
  KEY `res_id` (`res_id`),
  CONSTRAINT `complaint_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `complaint_ibfk_2` FOREIGN KEY (`user_index`) REFERENCES `users` (`index_no`),
  CONSTRAINT `complaint_ibfk_3` FOREIGN KEY (`res_id`) REFERENCES `resource` (`res_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint`
--

LOCK TABLES `complaint` WRITE;
/*!40000 ALTER TABLE `complaint` DISABLE KEYS */;
INSERT INTO `complaint` VALUES (7,1,'TG006','Broken chair in room 204',16,'2023-11-01','https://images.squarespace-cdn.com/content/v1/55803cbbe4b0206c1dc1d585/1447412964043-BXC3RQCLUVWAGZRW9SKZ/IMG_1796.JPG','in-progress',0),(8,5,'TG005','Broken chair in room 107',15,'2023-10-28','https://as2.ftcdn.net/v2/jpg/01/10/54/07/1000_F_110540710_A5EuXFIdY6Itsmk2ehj5Wrj0DknpGYCH.jpg','pending',0),(9,6,'TG004','Broken chair in room 103',12,'2023-10-28','https://as2.ftcdn.net/v2/jpg/01/10/54/07/1000_F_110540710_A5EuXFIdY6Itsmk2ehj5Wrj0DknpGYCH.jpg','pending',1),(10,15,'DE001','Desk Broken',15,'2023-11-05','https://mvflaim.files.wordpress.com/2021/05/20210516_123229.jpg','Pending',0),(11,15,'DE001','desk broken in room 103',15,'2023-11-05','https://res.cloudinary.com/dddyemhaw/image/upload/v1699197761/dzsrdf39v6bw3slztph2.jpg','pending',0);
/*!40000 ALTER TABLE `complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaint_notification`
--

DROP TABLE IF EXISTS `complaint_notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaint_notification` (
  `complaint_id` int NOT NULL,
  `user_id` int NOT NULL,
  `user_index` varchar(255) NOT NULL,
  `complaint` text NOT NULL,
  `res_id` int NOT NULL,
  `complaint_date` date DEFAULT NULL,
  `evidence_image` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT 'pending',
  `to_whom` int DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`complaint_id`),
  KEY `user_id` (`user_id`),
  KEY `user_index` (`user_index`),
  KEY `res_id` (`res_id`),
  CONSTRAINT `complaint_notification_ibfk_1` FOREIGN KEY (`complaint_id`) REFERENCES `complaint` (`complaint_id`),
  CONSTRAINT `complaint_notification_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `complaint_notification_ibfk_3` FOREIGN KEY (`user_index`) REFERENCES `users` (`index_no`),
  CONSTRAINT `complaint_notification_ibfk_4` FOREIGN KEY (`res_id`) REFERENCES `resource` (`res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint_notification`
--

LOCK TABLES `complaint_notification` WRITE;
/*!40000 ALTER TABLE `complaint_notification` DISABLE KEYS */;
INSERT INTO `complaint_notification` VALUES (8,5,'TG005','Broken chair in room 107',15,'2023-10-28','https://as2.ftcdn.net/v2/jpg/01/10/54/07/1000_F_110540710_A5EuXFIdY6Itsmk2ehj5Wrj0DknpGYCH.jpg','pending',4,'2023-11-05 10:12:00'),(9,6,'TG004','Broken chair in room 103',12,'2023-10-28','https://as2.ftcdn.net/v2/jpg/01/10/54/07/1000_F_110540710_A5EuXFIdY6Itsmk2ehj5Wrj0DknpGYCH.jpg','pending',4,'2023-11-05 10:12:00'),(10,15,'DE001','Desk Broken',15,'2023-11-05','https://mvflaim.files.wordpress.com/2021/05/20210516_123229.jpg','pending',5,'2023-11-05 10:44:00');
/*!40000 ALTER TABLE `complaint_notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `complaint_view`
--

DROP TABLE IF EXISTS `complaint_view`;
/*!50001 DROP VIEW IF EXISTS `complaint_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `complaint_view` AS SELECT 
 1 AS `complaint_id`,
 1 AS `user_id`,
 1 AS `user_index`,
 1 AS `complaint`,
 1 AS `res_id`,
 1 AS `complaint_date`,
 1 AS `evidence_image`,
 1 AS `status`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `db_notifications`
--

DROP TABLE IF EXISTS `db_notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `db_notifications` (
  `notification_id` int NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `notification_category` varchar(100) NOT NULL,
  `notification_title` varchar(255) NOT NULL,
  `msg` text,
  `to_whom` int NOT NULL,
  `create_date` date DEFAULT (curdate()),
  `notify_date` date DEFAULT NULL,
  `key_id` int DEFAULT NULL,
  `notify_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`notification_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_notifications`
--

LOCK TABLES `db_notifications` WRITE;
/*!40000 ALTER TABLE `db_notifications` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deleted_resource`
--

DROP TABLE IF EXISTS `deleted_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deleted_resource` (
  `deleted_res_id` int NOT NULL AUTO_INCREMENT,
  `res_id` int NOT NULL,
  `room_no` int DEFAULT NULL,
  `res_name` varchar(255) DEFAULT NULL,
  `installation_date` date DEFAULT NULL,
  `last_maintenance_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `deletion_date` datetime NOT NULL,
  PRIMARY KEY (`deleted_res_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deleted_resource`
--

LOCK TABLES `deleted_resource` WRITE;
/*!40000 ALTER TABLE `deleted_resource` DISABLE KEYS */;
INSERT INTO `deleted_resource` VALUES (1,8,200,'desk','2023-11-13','2023-11-12','inactive','2023-11-05 03:51:21'),(2,9,400,'fan','2023-11-08','2023-11-11','active','2023-11-05 04:02:07'),(3,1,101,'Chair A','2023-10-27','2023-10-28','Active','2023-11-05 05:51:34'),(4,3,201,'Chair B','2023-10-29','2023-10-30','Active','2023-11-05 05:51:58'),(5,2,103,'Desk A','2023-10-28','2023-10-29','Inactive','2023-11-05 05:54:03'),(6,4,205,'Desk B','2023-10-30','2023-10-31','Active','2023-11-05 05:56:41'),(7,10,100,'chair','2023-11-05','2023-10-28','inactive','2023-11-05 05:57:26'),(8,13,100,'desk','2023-11-14','2023-11-14','active','2023-11-05 06:00:50'),(9,11,102,'lamp','2023-10-29','2023-11-12','active','2023-11-05 06:01:51'),(10,14,100,'chair','2023-11-06','2023-11-20','active','2023-11-05 06:04:03');
/*!40000 ALTER TABLE `deleted_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deletedusers`
--

DROP TABLE IF EXISTS `deletedusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deletedusers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `index_no` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile_no` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` int NOT NULL,
  `deletedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deletedusers`
--

LOCK TABLES `deletedusers` WRITE;
/*!40000 ALTER TABLE `deletedusers` DISABLE KEYS */;
INSERT INTO `deletedusers` VALUES (1,'TG0013','Sadeepa Ekanayaka','dilumhello1@gmail.com','0789843282','fotpwd15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225',6,'2023-10-28 17:18:14');
/*!40000 ALTER TABLE `deletedusers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maintaince`
--

DROP TABLE IF EXISTS `maintaince`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `maintaince` (
  `maintenance_id` int NOT NULL AUTO_INCREMENT,
  `complaint_id` int NOT NULL,
  `handler` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `inspection_note` text NOT NULL,
  `solution` text NOT NULL,
  `evidence_image` varchar(255) DEFAULT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`maintenance_id`),
  KEY `complaint_id` (`complaint_id`),
  CONSTRAINT `maintaince_ibfk_2` FOREIGN KEY (`complaint_id`) REFERENCES `complaint` (`complaint_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maintaince`
--

LOCK TABLES `maintaince` WRITE;
/*!40000 ALTER TABLE `maintaince` DISABLE KEYS */;
INSERT INTO `maintaince` VALUES (4,1,'John Doe','In Progress','Inspected the issue, needs further attention.','Repaired the faulty component.','image001.jpg','2023-10-28 09:00:00'),(5,3,'Emily Smith','Completed','Inspection completed, issue resolved.','Replaced damaged part.','image002.jpg','2023-10-27 11:30:00'),(6,4,'Michael Johnson','Pending','Scheduled for inspection.','To be inspected.',NULL,'2023-10-29 14:15:00'),(9,10,'Nisal harware','In Progress','broken','re build','image 1','2023-11-05 00:00:00'),(10,8,'Nisal Hardware','In Progress','need to rebuild','rebuild','image 2.jpg','2023-11-05 00:00:00'),(15,8,'Nisal Hardware 2','In Progress','need to rebuild','rebuild','image 2.jpg','2023-11-04 00:00:00'),(17,10,'Nisal Hardware 2','In Progress','ubvikb jk','nhk kijnhbjk','test1.jpg','2023-11-03 00:00:00'),(18,7,'Nisal Hardware ','','ubvikb jhjbj','nhk kijnhbjkihb  j','test1.jpg','2023-11-04 00:00:00'),(19,8,'Nisal Hardware 2','In Progress','trhtrdgnx tgsr ht','tsrgh tr','tersghyt','2023-11-05 00:00:00'),(21,8,'Nisal Hardware 2','In Progress','dfgtrfdsgzfg','rtfedsgrtfghfg','https://res.cloudinary.com/dddyemhaw/image/upload/v1699194245/wjbovmghrmfreefbqckw.jpg','2023-11-04 00:00:00');
/*!40000 ALTER TABLE `maintaince` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `maintenance_view`
--

DROP TABLE IF EXISTS `maintenance_view`;
/*!50001 DROP VIEW IF EXISTS `maintenance_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `maintenance_view` AS SELECT 
 1 AS `maintenance_id`,
 1 AS `complaint_id`,
 1 AS `handler`,
 1 AS `status`,
 1 AS `inspection_note`,
 1 AS `solution`,
 1 AS `evidence_image`,
 1 AS `date`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `report_logs`
--

DROP TABLE IF EXISTS `report_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report_logs` (
  `log_id` int NOT NULL AUTO_INCREMENT,
  `action` varchar(255) NOT NULL,
  `timestamp` timestamp NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_logs`
--

LOCK TABLES `report_logs` WRITE;
/*!40000 ALTER TABLE `report_logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `report_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resource` (
  `res_id` int NOT NULL AUTO_INCREMENT,
  `room_no` int DEFAULT NULL,
  `res_name` varchar(255) DEFAULT NULL,
  `installation_date` date DEFAULT NULL,
  `last_maintenance_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES (12,103,'fan','2023-11-06','2023-11-28','active'),(15,103,'desk','2023-11-05','2023-12-01','active'),(16,130,'ban','2023-10-31','2023-11-26','active'),(17,200,'chair','2023-10-29','2023-11-21','active');
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`admin`@`%`*/ /*!50003 TRIGGER `update_summary` AFTER INSERT ON `resource` FOR EACH ROW BEGIN
    IF NEW.res_name = 'chair' THEN
        UPDATE summary_table SET item_count = item_count + 1 WHERE item_name = 'chair';
    ELSEIF NEW.res_name = 'desk' THEN
        UPDATE summary_table SET item_count = item_count + 1 WHERE item_name = 'desk';
    ELSEIF NEW.res_name = 'lamp' THEN
        UPDATE summary_table SET item_count = item_count + 1 WHERE item_name = 'lamp';
    ELSEIF NEW.res_name = 'fan' THEN
        UPDATE summary_table SET item_count = item_count + 1 WHERE item_name = 'fan';
    ELSEIF NEW.res_name = 'bed' THEN
        UPDATE summary_table SET item_count = item_count + 1 WHERE item_name = 'bed';
    ELSEIF NEW.res_name = 'cloth rack' THEN
        UPDATE summary_table SET item_count = item_count + 1 WHERE item_name = 'cloth rack';
    ELSEIF NEW.res_name = 'cupboard' THEN
        UPDATE summary_table SET item_count = item_count + 1 WHERE item_name = 'cupboard';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`admin`@`%`*/ /*!50003 TRIGGER `after_delete_trigger` AFTER DELETE ON `resource` FOR EACH ROW BEGIN
  INSERT INTO deleted_resource (res_id, room_no, res_name, installation_date, last_maintenance_date, status, deletion_date)
  VALUES (OLD.res_id, OLD.room_no, OLD.res_name, OLD.installation_date, OLD.last_maintenance_date, OLD.status, NOW());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `resource_categories`
--

DROP TABLE IF EXISTS `resource_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resource_categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource_categories`
--

LOCK TABLES `resource_categories` WRITE;
/*!40000 ALTER TABLE `resource_categories` DISABLE KEYS */;
INSERT INTO `resource_categories` VALUES (1,'cupboard'),(2,'chair'),(3,'table'),(4,'bed'),(5,'mattress'),(6,'bulb'),(7,'fan'),(8,'towel rack'),(9,'toilet'),(10,'shower'),(11,'sink'),(12,'mirror'),(13,'tap'),(14,'towel');
/*!40000 ALTER TABLE `resource_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'admin'),(2,'dean'),(3,'student_counsellor'),(4,'warden'),(5,'sub_warden'),(6,'student');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `room_no` int NOT NULL AUTO_INCREMENT,
  `hostel_no` int NOT NULL,
  `floor_no` int NOT NULL,
  PRIMARY KEY (`room_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_table`
--

DROP TABLE IF EXISTS `summary_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `summary_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) NOT NULL,
  `item_count` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_table`
--

LOCK TABLES `summary_table` WRITE;
/*!40000 ALTER TABLE `summary_table` DISABLE KEYS */;
INSERT INTO `summary_table` VALUES (1,'chair',1),(2,'desk',0),(3,'lamp',0),(4,'fan',0),(5,'bed',0),(6,'cloth rack',0),(7,'cupboard',0);
/*!40000 ALTER TABLE `summary_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_report_logs`
--

DROP TABLE IF EXISTS `user_report_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_report_logs` (
  `log_id` int NOT NULL AUTO_INCREMENT,
  `action` varchar(255) NOT NULL,
  `timestamp` timestamp NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_report_logs`
--

LOCK TABLES `user_report_logs` WRITE;
/*!40000 ALTER TABLE `user_report_logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_report_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_report_logs_final`
--

DROP TABLE IF EXISTS `user_report_logs_final`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_report_logs_final` (
  `log_id` int NOT NULL AUTO_INCREMENT,
  `action` varchar(255) NOT NULL,
  `timestamp` timestamp NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_report_logs_final`
--

LOCK TABLES `user_report_logs_final` WRITE;
/*!40000 ALTER TABLE `user_report_logs_final` DISABLE KEYS */;
