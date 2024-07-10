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
-- Table structure for table `science`
--

DROP TABLE IF EXISTS `science`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `science` (
  `stRegId` varchar(10) NOT NULL,
  `ElectronicConScore` varchar(10) DEFAULT '0',
  `ElectronicConCoplete` varchar(10) DEFAULT '0',
  `ElectronicConLastQustion` varchar(10) DEFAULT '0',
  `ElectronicConCoundDown` varchar(45) DEFAULT '17',
  `HumanHeartScore` varchar(10) DEFAULT '0',
  `HumanHeartCoplete` varchar(10) DEFAULT '0',
  `DoublBloodCirculationScore` varchar(10) DEFAULT '0',
  `DoublBloodCirculationCoplete` varchar(10) DEFAULT '0',
  `bloodSecularofHumanComplete` varchar(10) DEFAULT '0',
  `bloodSecularofHumanScore` varchar(10) DEFAULT '0',
  `BaseOrAsidComplete` varchar(10) DEFAULT '0',
  `BaseOrAsidScore` varchar(10) DEFAULT '0',
  `electricHouseGridComplete` varchar(10) DEFAULT '0',
  `electricHouseGridScore` varchar(45) DEFAULT '0',
  PRIMARY KEY (`stRegId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `science`
--

LOCK TABLES `science` WRITE;
/*!40000 ALTER TABLE `science` DISABLE KEYS */;
INSERT INTO `science` VALUES ('1','0','0','0','17','0','14','0','42','14','0','20','10','18','9'),('10','0','0','0','17','0','0','0','0','0','0','0','0','0','0'),('11','0','10','2','15','0','21','0','0','0','0','10','10','18','9'),('12','10','15','3','14','7','42','0','28','14','0','60','50','54','18'),('2','25','30','6','11','14','35','0','84','100','7','0','0','0','0'),('3','15','100','17','0','7','100','14','100','100','35','0','0','0','0'),('4','0','0','0','17','0','0','0','0','0','0','0','0','0','0'),('5','0','0','0','17','0','0','0','0','0','0','0','0','0','0'),('6','25','25','5','12','7','14','28','42','28','7','60','50','54','36'),('7','0','0','0','17','0','0','0','0','0','0','0','0','0','0'),('8','10','10','2','15','0','21','0','28','21','0','10','10','0','0'),('9','0','0','0','17','0','0','0','0','0','0','0','0','0','0');
/*!40000 ALTER TABLE `science` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-10 13:45:04
