-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: tra
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `list_orders`
--

DROP TABLE IF EXISTS `list_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `list_orders` (
  `orderID` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_orders`
--

LOCK TABLES `list_orders` WRITE;
/*!40000 ALTER TABLE `list_orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `list_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `movieTitle` varchar(255) NOT NULL,
  `dateReleased` varchar(255) DEFAULT NULL,
  `movieLength` int DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`movieTitle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES ('Ghost Cat','2003',92,'Mystery, Thriller'),('Inception','July 16, 2010',148,'Thriller, Sci Fi, Action'),('Interstellar','November 7, 2014',165,'Adventure, Drama, Sci Fi'),('Knives Out','November 27, 2019',130,'Mystery, Thriller, Drama'),('The Cat That Came Back','2003',92,'Mystery, Thriller');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_ticket_list`
--

DROP TABLE IF EXISTS `order_ticket_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_ticket_list` (
  `orderID` int DEFAULT NULL,
  `ticketID` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_ticket_list`
--

LOCK TABLES `order_ticket_list` WRITE;
/*!40000 ALTER TABLE `order_ticket_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_ticket_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `seatNumber` int NOT NULL,
  `seatMapID` int NOT NULL,
  `vacant` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,1,'true'),(2,1,'true'),(3,1,'true'),(4,1,'true'),(5,1,'true'),(6,1,'true'),(7,1,'true'),(8,1,'true'),(9,1,'true'),(10,1,'true'),(11,1,'true'),(12,1,'true'),(13,1,'true'),(14,1,'true'),(15,1,'true'),(16,1,'true'),(17,1,'true'),(18,1,'true'),(19,1,'true'),(20,1,'true'),(21,1,'true'),(22,1,'true'),(23,1,'true'),(24,1,'true'),(25,1,'true'),(26,1,'true'),(27,1,'true'),(28,1,'true'),(29,1,'true'),(30,1,'true'),(31,1,'true'),(32,1,'true'),(33,1,'true'),(34,1,'true'),(35,1,'true'),(1,2,'true'),(2,2,'true'),(3,2,'true'),(4,2,'true'),(5,2,'true'),(6,2,'true'),(7,2,'true'),(8,2,'true'),(9,2,'true'),(10,2,'true'),(11,2,'true'),(12,2,'true'),(13,2,'true'),(14,2,'true'),(15,2,'true'),(16,2,'true'),(17,2,'true'),(18,2,'true'),(19,2,'true'),(20,2,'true'),(21,2,'true'),(22,2,'true'),(23,2,'true'),(24,2,'true'),(25,2,'true'),(26,2,'true'),(27,2,'true'),(28,2,'true'),(29,2,'true'),(30,2,'true'),(31,2,'true'),(32,2,'true'),(33,2,'true'),(34,2,'true'),(35,2,'true'),(1,3,'true'),(2,3,'true'),(3,3,'true'),(4,3,'true'),(5,3,'true'),(6,3,'true'),(7,3,'true'),(8,3,'true'),(9,3,'true'),(10,3,'true'),(11,3,'true'),(12,3,'true'),(13,3,'true'),(14,3,'true'),(15,3,'true'),(16,3,'true'),(17,3,'true'),(18,3,'true'),(19,3,'true'),(20,3,'true'),(21,3,'true'),(22,3,'true'),(23,3,'true'),(24,3,'true'),(25,3,'true'),(26,3,'true'),(27,3,'true'),(28,3,'true'),(29,3,'true'),(30,3,'true'),(31,3,'true'),(32,3,'true'),(33,3,'true'),(34,3,'true'),(35,3,'true'),(1,4,'true'),(2,4,'true'),(3,4,'true'),(4,4,'true'),(5,4,'true'),(6,4,'true'),(7,4,'true'),(8,4,'true'),(9,4,'true'),(10,4,'true'),(11,4,'true'),(12,4,'true'),(13,4,'true'),(14,4,'true'),(15,4,'true'),(16,4,'true'),(17,4,'true'),(18,4,'true'),(19,4,'true'),(20,4,'true'),(21,4,'true'),(22,4,'true'),(23,4,'true'),(24,4,'true'),(25,4,'true'),(26,4,'true'),(27,4,'true'),(28,4,'true'),(29,4,'true'),(30,4,'true'),(31,4,'true'),(32,4,'true'),(33,4,'true'),(34,4,'true'),(35,4,'true'),(1,5,'true'),(2,5,'true'),(3,5,'true'),(4,5,'true'),(5,5,'true'),(6,5,'true'),(7,5,'true'),(8,5,'true'),(9,5,'true'),(10,5,'true'),(11,5,'true'),(12,5,'true'),(13,5,'true'),(14,5,'true'),(15,5,'true'),(16,5,'true'),(17,5,'true'),(18,5,'true'),(19,5,'true'),(20,5,'true'),(21,5,'true'),(22,5,'true'),(23,5,'true'),(24,5,'true'),(25,5,'true'),(26,5,'true'),(27,5,'true'),(28,5,'true'),(29,5,'true'),(30,5,'true'),(31,5,'true'),(32,5,'true'),(33,5,'true'),(34,5,'true'),(35,5,'true'),(1,6,'true'),(2,6,'true'),(3,6,'true'),(4,6,'true'),(5,6,'true'),(6,6,'true'),(7,6,'true'),(8,6,'true'),(9,6,'true'),(10,6,'true'),(11,6,'true'),(12,6,'true'),(13,6,'true'),(14,6,'true'),(15,6,'true'),(16,6,'true'),(17,6,'true'),(18,6,'true'),(19,6,'true'),(20,6,'true'),(21,6,'true'),(22,6,'true'),(23,6,'true'),(24,6,'true'),(25,6,'true'),(26,6,'true'),(27,6,'true'),(28,6,'true'),(29,6,'true'),(30,6,'true'),(31,6,'true'),(32,6,'true'),(33,6,'true'),(34,6,'true'),(35,6,'true'),(1,7,'true'),(2,7,'true'),(3,7,'true'),(4,7,'true'),(5,7,'true'),(6,7,'true'),(7,7,'true'),(8,7,'true'),(9,7,'true'),(10,7,'true'),(11,7,'true'),(12,7,'true'),(13,7,'true'),(14,7,'true'),(15,7,'true'),(16,7,'true'),(17,7,'true'),(18,7,'true'),(19,7,'true'),(20,7,'true'),(21,7,'true'),(22,7,'true'),(23,7,'true'),(24,7,'true'),(25,7,'true'),(26,7,'true'),(27,7,'true'),(28,7,'true'),(29,7,'true'),(30,7,'true'),(31,7,'true'),(32,7,'true'),(33,7,'true'),(34,7,'true'),(35,7,'true'),(1,8,'true'),(2,8,'true'),(3,8,'true'),(4,8,'true'),(5,8,'true'),(6,8,'true'),(7,8,'true'),(8,8,'true'),(9,8,'true'),(10,8,'true'),(11,8,'true'),(12,8,'true'),(13,8,'true'),(14,8,'true'),(15,8,'true'),(16,8,'true'),(17,8,'true'),(18,8,'true'),(19,8,'true'),(20,8,'true'),(21,8,'true'),(22,8,'true'),(23,8,'true'),(24,8,'true'),(25,8,'true'),(26,8,'true'),(27,8,'true'),(28,8,'true'),(29,8,'true'),(30,8,'true'),(31,8,'true'),(32,8,'true'),(33,8,'true'),(34,8,'true'),(35,8,'true'),(1,9,'true'),(2,9,'true'),(3,9,'true'),(4,9,'true'),(5,9,'true'),(6,9,'true'),(7,9,'true'),(8,9,'true'),(9,9,'true'),(10,9,'true'),(11,9,'true'),(12,9,'true'),(13,9,'true'),(14,9,'true'),(15,9,'true'),(16,9,'true'),(17,9,'true'),(18,9,'true'),(19,9,'true'),(20,9,'true'),(21,9,'true'),(22,9,'true'),(23,9,'true'),(24,9,'true'),(25,9,'true'),(26,9,'true'),(27,9,'true'),(28,9,'true'),(29,9,'true'),(30,9,'true'),(31,9,'true'),(32,9,'true'),(33,9,'true'),(34,9,'true'),(35,9,'true'),(1,10,'true'),(2,10,'true'),(3,10,'true'),(4,10,'true'),(5,10,'true'),(6,10,'true'),(7,10,'true'),(8,10,'true'),(9,10,'true'),(10,10,'true'),(11,10,'true'),(12,10,'true'),(13,10,'true'),(14,10,'true'),(15,10,'true'),(16,10,'true'),(17,10,'true'),(18,10,'true'),(19,10,'true'),(20,10,'true'),(21,10,'true'),(22,10,'true'),(23,10,'true'),(24,10,'true'),(25,10,'true'),(26,10,'true'),(27,10,'true'),(28,10,'true'),(29,10,'true'),(30,10,'true'),(31,10,'true'),(32,10,'true'),(33,10,'true'),(34,10,'true'),(35,10,'true'),(1,11,'true'),(2,11,'true'),(3,11,'true'),(4,11,'true'),(5,11,'true'),(6,11,'true'),(7,11,'true'),(8,11,'true'),(9,11,'true'),(10,11,'true'),(11,11,'true'),(12,11,'true'),(13,11,'true'),(14,11,'true'),(15,11,'true'),(16,11,'true'),(17,11,'true'),(18,11,'true'),(19,11,'true'),(20,11,'true'),(21,11,'true'),(22,11,'true'),(23,11,'true'),(24,11,'true'),(25,11,'true'),(26,11,'true'),(27,11,'true'),(28,11,'true'),(29,11,'true'),(30,11,'true'),(31,11,'true'),(32,11,'true'),(33,11,'true'),(34,11,'true'),(35,11,'true'),(1,12,'true'),(2,12,'true'),(3,12,'true'),(4,12,'true'),(5,12,'true'),(6,12,'true'),(7,12,'true'),(8,12,'true'),(9,12,'true'),(10,12,'true'),(11,12,'true'),(12,12,'true'),(13,12,'true'),(14,12,'true'),(15,12,'true'),(16,12,'true'),(17,12,'true'),(18,12,'true'),(19,12,'true'),(20,12,'true'),(21,12,'true'),(22,12,'true'),(23,12,'true'),(24,12,'true'),(25,12,'true'),(26,12,'true'),(27,12,'true'),(28,12,'true'),(29,12,'true'),(30,12,'true'),(31,12,'true'),(32,12,'true'),(33,12,'true'),(34,12,'true'),(35,12,'true');
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seatmap`
--

DROP TABLE IF EXISTS `seatmap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seatmap` (
  `seatMapID` int NOT NULL,
  `reservedSeatCount` int DEFAULT NULL,
  `numberOfRows` int DEFAULT NULL,
  `numberOfAvailableSeats` int DEFAULT NULL,
  PRIMARY KEY (`seatMapID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seatmap`
--

LOCK TABLES `seatmap` WRITE;
/*!40000 ALTER TABLE `seatmap` DISABLE KEYS */;
INSERT INTO `seatmap` VALUES (1,5,5,35),(2,5,5,35),(3,5,5,35),(4,5,5,35),(5,5,5,35),(6,5,5,35),(7,5,5,35),(8,5,5,35),(9,5,5,35),(10,5,5,35),(11,5,5,35),(12,5,5,35);
/*!40000 ALTER TABLE `seatmap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showing`
--

DROP TABLE IF EXISTS `showing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showing` (
  `showingID` int NOT NULL,
  `movieTitle` varchar(255) DEFAULT NULL,
  `theatreName` varchar(255) NOT NULL,
  `seatMapID` int NOT NULL,
  `showtime` varchar(255) NOT NULL,
  PRIMARY KEY (`showingID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showing`
--

LOCK TABLES `showing` WRITE;
/*!40000 ALTER TABLE `showing` DISABLE KEYS */;
INSERT INTO `showing` VALUES (1,'Ghost Cat','Cineplex Odeon Crowfoot Crossing',1,'2020-11-30 10:00 AM'),(2,'Inception','Cineplex Odeon Crowfoot Crossing',2,'2020-11-30 10:30 AM'),(3,'Interstellar','Cineplex Odeon Crowfoot Crossing',3,'2020-11-30 10:00 AM'),(4,'The Cat That Came Back','Scotiabank Theatre Chinook',4,'2020-11-30 10:00 AM'),(5,'Knives Out','Scotiabank Theatre Chinook',5,'2020-11-30 11:00 AM'),(7,'Inception','Scotiabank Theatre Chinook',6,'2020-11-30 10:30 AM'),(8,'Interstellar','Scotiabank Theatre Chinook',7,'2020-11-30 11:00 AM'),(9,'Ghost Cat','Scotiabank Theatre Chinook',8,'2020-11-30 10:30 AM'),(10,'Interstellar','SilverCity CrossIron Mills Cinemas',9,'2020-11-30 10:00 AM'),(11,'Inception','SilverCity CrossIron Mills Cinemas',10,'2020-11-30 10:00 AM'),(12,'Knives Out','SilverCity CrossIron Mills Cinemas',11,'2020-11-30 10:30 AM'),(13,'The Cat That Came Back','SilverCity CrossIron Mills Cinemas',12,'2020-11-30 11:00 AM'),(14,'The Cat That Came Back','Cineplex Odeon Crowfoot Crossing',1,'2020-11-30 1:00 PM'),(15,'Knives Out','Cineplex Odeon Crowfoot Crossing',2,'2020-11-30 1:30 PM'),(16,'Interstellar','Cineplex Odeon Crowfoot Crossing',3,'2020-11-30 1:00 PM'),(17,'The Cat That Came Back','Scotiabank Theatre Chinook',4,'2020-11-30 1:00 PM'),(18,'Knives Out','Scotiabank Theatre Chinook',5,'2020-11-30 1:30 PM'),(19,'Inception','Scotiabank Theatre Chinook',6,'2020-11-30 2:00 PM'),(20,'InterStellar','Scotiabank Theatre Chinook',7,'2020-11-30 1:30 PM'),(21,'Ghost Cat','Scotiabank Theatre Chinook',8,'2020-11-30 2:30 PM'),(22,'Interstellar','SilverCity CrossIron Mills Cinemas',9,'2020-11-30 1:00 PM'),(23,'Inception','SilverCity CrossIron Mills Cinemas',10,'2020-11-30 1:30 PM'),(24,'Ghost Cat','SilverCity CrossIron Mills Cinemas',11,'2020-11-30 2:00 PM'),(25,'The Cat That Came Back','SilverCity CrossIron Mills Cinemas',12,'2020-11-30 1:00 PM');
/*!40000 ALTER TABLE `showing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theatre`
--

DROP TABLE IF EXISTS `theatre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theatre` (
  `theatreName` varchar(255) NOT NULL,
  PRIMARY KEY (`theatreName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theatre`
--

LOCK TABLES `theatre` WRITE;
/*!40000 ALTER TABLE `theatre` DISABLE KEYS */;
INSERT INTO `theatre` VALUES ('Cineplex Odeon Crowfoot Crossing'),('Scotiabank Theatre Chinook'),('SilverCity CrossIron Mills Cinemas');
/*!40000 ALTER TABLE `theatre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `ticketID` int NOT NULL,
  `showingID` int DEFAULT NULL,
  `seatNumber` int DEFAULT NULL,
  `cost` double DEFAULT NULL,
  PRIMARY KEY (`ticketID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `accountID` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `cardNumber` varchar(255) DEFAULT NULL,
  `expiryDate` varchar(255) DEFAULT NULL,
  `csv` int DEFAULT NULL,
  PRIMARY KEY (`accountID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'email1@gmail.com','Jayden','Bischoff','password1','1111111111111111','02/22',111),(2,'email2@gmail.com','Roland','Booth','password2','2222222222222222','03/22',222),(3,'email3@gmail.com','Nurullo','Boboev','password3','3333333333333333','01/22',333),(4,'email4@gmail.com','Logan','Boras','password4','4444444444444444','10/22',444);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-01 18:51:26
