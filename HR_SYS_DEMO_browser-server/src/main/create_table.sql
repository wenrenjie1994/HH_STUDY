CREATE DATABASE if not exists `spdb_hr_sys` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE spdb_hr_sys;
CREATE TABLE if not exists `resume_list` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `school` varchar(45) NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume_list`
--

LOCK TABLES `resume_list` WRITE;
/*!40000 ALTER TABLE `resume_list` DISABLE KEYS */;
INSERT INTO `resume_list` VALUES (1,'张松','解放军信息工程大学',1),(2,'蒋芒','清华大学',0),(3,'王新宇','四川大学',0),(4,'黄超','四川大学',0),(5,'肖修卓','电子科技大学',0),(6,'卢臻','电子科技大学',1),(7,'夏琦','复旦大学',7),(8,'夏琦','复旦大学',7);
/*!40000 ALTER TABLE `resume_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-15 16:27:19
