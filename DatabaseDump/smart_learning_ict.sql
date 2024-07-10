-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: smart_learning
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ict`
--

DROP TABLE IF EXISTS `ict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ict` (
  `stRegId` varchar(45) NOT NULL,
  `fillTheBlankComplete` varchar(45) DEFAULT '0',
  `fillTheBlankScore` varchar(45) DEFAULT '0',
  `MCQcomplete` varchar(45) DEFAULT '0',
  `MCQscore` varchar(45) DEFAULT '0',
  `computerPartsComplete` varchar(45) DEFAULT '0',
  `computerPartsScore` varchar(45) DEFAULT '0',
  `base2intoBase10Score` varchar(45) DEFAULT '0',
  `base2intoBase8Score` varchar(45) DEFAULT '0',
  `base2intoBase16Score` varchar(45) DEFAULT '0',
  `base2intoBase10Complete` varchar(45) DEFAULT '0',
  `base2intoBase8Complete` varchar(45) DEFAULT '0',
  `base2intoBase16Complete` varchar(45) DEFAULT '0',
  PRIMARY KEY (`stRegId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ict`
--

LOCK TABLES `ict` WRITE;
/*!40000 ALTER TABLE `ict` DISABLE KEYS */;
INSERT INTO `ict` VALUES ('1','20','10','20','10','42','14','1','2','2','6','12','12'),('10','0','0','0','0','0','0','0','0','0','0','0','0'),('11','20','0','20','10','42','28','1','2','0','6','12','0'),('12','20','10','20','10','100','42','6','6','0','12','6','0'),('2','40','0','90','50','100','100','0','0','0','0','0','0'),('3','10','0','0','0','84','0','0','0','0','0','0','0'),('4','0','0','20','0','0','0','0','0','0','0','0','0'),('5','0','0','0','0','0','0','0','0','0','0','0','0'),('6','0','0','10','0','0','0','0','0','0','0','0','0'),('7','0','0','0','0','0','0','0','0','0','1','0','0'),('8','20','0','40','0','0','0','2','0','0','6','0','0'),('9','0','0','0','0','0','0','0','0','0','0','0','0');
/*!40000 ALTER TABLE `ict` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-10 13:45:03
