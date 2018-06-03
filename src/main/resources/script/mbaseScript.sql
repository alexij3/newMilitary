-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: military_base
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `army`
--

DROP TABLE IF EXISTS `army`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `army` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `army`
--

LOCK TABLES `army` WRITE;
/*!40000 ALTER TABLE `army` DISABLE KEYS */;
INSERT INTO `army` VALUES (1,'AB1','Армія №1'),(2,'AB2','Армія №2'),(3,'AB3','Армія №3'),(4,'AB4','Армія №4'),(5,'AB5','Армія №5'),(6,'AB6','Армія №6'),(7,'AB7','Армія №7'),(8,'AB8','Армія №8'),(9,'AB9','Армія №9'),(10,'AB10','Армія №10'),(11,'AB11','Армія №11'),(12,'AB12','Армія №12'),(13,'AB13','Армія №13'),(14,'AB14','Армія №14'),(15,'AB15','Армія №15');
/*!40000 ALTER TABLE `army` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brigade`
--

DROP TABLE IF EXISTS `brigade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brigade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brigade`
--

LOCK TABLES `brigade` WRITE;
/*!40000 ALTER TABLE `brigade` DISABLE KEYS */;
INSERT INTO `brigade` VALUES (1,'BG1','Бригада №1'),(2,'BG2','Бригада №2'),(3,'BG3','Бригада №3'),(4,'BG4','Бригада №4'),(5,'BG5','Бригада №5'),(6,'BG6','Бригада №6'),(7,'BG7','Бригада №7'),(8,'BG8','Бригада №8'),(9,'BG9','Бригада №9'),(10,'BG10','Бригада №10'),(11,'BG11','Бригада №11'),(12,'BG12','Бригада №12'),(13,'BG13','Бригада №13'),(14,'BG14','Бригада №14'),(15,'BG15','Бригада №15');
/*!40000 ALTER TABLE `brigade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buildings`
--

DROP TABLE IF EXISTS `buildings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buildings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buildings`
--

LOCK TABLES `buildings` WRITE;
/*!40000 ALTER TABLE `buildings` DISABLE KEYS */;
INSERT INTO `buildings` VALUES (1,'Будівля 1'),(2,'Будівля 2'),(3,'Будівля 3'),(4,'Будівля 4'),(5,'Будівля 5'),(6,'Будівля 6'),(7,'Будівля 7'),(8,'Будівля 9'),(9,'Будівля 10'),(10,'Будівля 11'),(11,'Будівля 12'),(12,'Будівля 13'),(13,'Будівля 14'),(14,'Будівля 15'),(15,'Будівля 16'),(16,'Будівля 17'),(17,'Будівля 18'),(18,'Будівля 19'),(19,'Будівля 20'),(20,'Будівля 21'),(21,'Будівля 22'),(22,'Будівля 23'),(23,'Будівля 24'),(24,'Будівля 25'),(25,'Будівля 26'),(26,'Будівля 27'),(27,'Будівля 28'),(28,'Будівля 29'),(29,'Будівля 30'),(30,'Будівля 31');
/*!40000 ALTER TABLE `buildings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corps`
--

DROP TABLE IF EXISTS `corps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corps` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corps`
--

LOCK TABLES `corps` WRITE;
/*!40000 ALTER TABLE `corps` DISABLE KEYS */;
INSERT INTO `corps` VALUES (1,'CPS1','Корпус №1'),(2,'CPS2','Корпус №2'),(3,'CPS3','Корпус №3'),(4,'CPS4','Корпус №4'),(5,'CPS5','Корпус №5'),(6,'CPS6','Корпус №6'),(7,'CPS7','Корпус №7'),(8,'CPS8','Корпус №8'),(9,'CPS9','Корпус №9'),(10,'CPS10','Корпус №10'),(11,'CPS11','Корпус №11'),(12,'CPS12','Корпус №12'),(13,'CPS13','Корпус №13'),(14,'CPS14','Корпус №14'),(15,'CPS15','Корпус №15');
/*!40000 ALTER TABLE `corps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_number` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `captain_id` int(11) NOT NULL,
  `platoon_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6r0strhxsk6ff83l7sjttkqha` (`captain_id`),
  KEY `FK2iblw5gjhs3e0w2l5eetsl7xh` (`platoon_id`),
  CONSTRAINT `FK2iblw5gjhs3e0w2l5eetsl7xh` FOREIGN KEY (`platoon_id`) REFERENCES `platoon` (`id`),
  CONSTRAINT `FK6r0strhxsk6ff83l7sjttkqha` FOREIGN KEY (`captain_id`) REFERENCES `soldier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `division` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `division`
--

LOCK TABLES `division` WRITE;
/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` VALUES (1,'DV1','Дивізія №1'),(2,'DV2','Дивізія №2'),(3,'DV3','Дивізія №3'),(4,'DV4','Дивізія №4'),(5,'DV5','Дивізія №5'),(6,'DV6','Дивізія №6'),(7,'DV7','Дивізія №7'),(8,'DV8','Дивізія №8'),(9,'DV9','Дивізія №9'),(10,'DV10','Дивізія №10'),(11,'DV11','Дивізія №11'),(12,'DV12','Дивізія №12'),(13,'DV13','Дивізія №13'),(14,'DV14','Дивізія №14'),(15,'DV15','Дивізія №15');
/*!40000 ALTER TABLE `division` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `military_base`
--

DROP TABLE IF EXISTS `military_base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `military_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `army_id` int(11) NOT NULL,
  `division_id` int(11) DEFAULT NULL,
  `brigade_id` int(11) DEFAULT NULL,
  `corps_id` int(11) DEFAULT NULL,
  `dislocation` int(11) NOT NULL,
  `captain_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnsge6759abkd4p0ndo4osxku2` (`army_id`),
  KEY `FKhuiprs4bt95rdgp75kfy29q6g` (`brigade_id`),
  KEY `FKg4dbu18ik2o1c3tqt8u4cjora` (`captain_id`),
  KEY `FKggwkbitk8ddqv6dwjbb4jukep` (`corps_id`),
  KEY `FK7qyw1gos432cf870pdhpv4sgj` (`dislocation`),
  KEY `FK6o63xbpqat7rwfqporeovm8as` (`division_id`),
  CONSTRAINT `FK6o63xbpqat7rwfqporeovm8as` FOREIGN KEY (`division_id`) REFERENCES `division` (`id`),
  CONSTRAINT `FK7qyw1gos432cf870pdhpv4sgj` FOREIGN KEY (`dislocation`) REFERENCES `buildings` (`id`),
  CONSTRAINT `FKg4dbu18ik2o1c3tqt8u4cjora` FOREIGN KEY (`captain_id`) REFERENCES `soldier` (`id`),
  CONSTRAINT `FKggwkbitk8ddqv6dwjbb4jukep` FOREIGN KEY (`corps_id`) REFERENCES `corps` (`id`),
  CONSTRAINT `FKhuiprs4bt95rdgp75kfy29q6g` FOREIGN KEY (`brigade_id`) REFERENCES `brigade` (`id`),
  CONSTRAINT `FKnsge6759abkd4p0ndo4osxku2` FOREIGN KEY (`army_id`) REFERENCES `army` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `military_base`
--

LOCK TABLES `military_base` WRITE;
/*!40000 ALTER TABLE `military_base` DISABLE KEYS */;
INSERT INTO `military_base` VALUES (1,'Частина 1',1,1,NULL,NULL,1,1),(2,'Частина 2',1,1,NULL,NULL,1,2),(3,'Частина 3',2,2,NULL,NULL,2,3),(4,'Частина 4',3,2,NULL,NULL,2,4),(5,'Частина 5',4,NULL,3,NULL,3,5),(6,'Частина 6',5,NULL,3,NULL,3,6),(7,'Частина 7',6,NULL,4,NULL,3,7),(8,'Частина 8',7,NULL,4,NULL,3,8),(9,'Частина 9',8,NULL,NULL,5,4,9),(10,'Частина 10',9,NULL,NULL,5,4,10),(11,'Частина 11',10,NULL,NULL,6,5,11),(12,'Частина 12',10,NULL,NULL,6,6,12),(13,'Частина 13',10,NULL,7,NULL,7,13),(14,'Частина 14',10,NULL,7,NULL,8,14),(15,'Частина 15',11,8,NULL,NULL,9,15);
/*!40000 ALTER TABLE `military_base` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `officers`
--

DROP TABLE IF EXISTS `officers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `officers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `academy_graduation` date DEFAULT NULL,
  `became_general` date DEFAULT NULL,
  `rang` varchar(255) NOT NULL,
  `soldier_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2fagh78fcs3c7regvq0n1s128` (`soldier_id`),
  CONSTRAINT `FK6e6clxtuctt0uodxv34dvsf7j` FOREIGN KEY (`soldier_id`) REFERENCES `soldier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `officers`
--

LOCK TABLES `officers` WRITE;
/*!40000 ALTER TABLE `officers` DISABLE KEYS */;
INSERT INTO `officers` VALUES (1,'2018-05-18','2018-05-18','Генерал',1),(2,'2018-05-18',NULL,'Полковник',2),(3,'2018-05-18',NULL,'Підполковник',3),(4,'2018-05-18',NULL,'Майор',4),(5,'2018-05-18',NULL,'Капітан',5),(6,'2018-05-18',NULL,'Лейтенант',6),(7,'2018-05-18',NULL,'Полковник',7),(8,'2018-05-18',NULL,'Підполковник',8),(9,'2018-05-18',NULL,'Майор',9),(10,'2018-05-18',NULL,'Капітан',10),(11,'2018-05-18',NULL,'Капітан',11),(12,'2018-05-18',NULL,'Капітан',12),(13,'2018-05-18',NULL,'Капітан',13),(14,'2018-05-18',NULL,'Капітан',14),(15,'2018-05-18',NULL,'Капітан',15),(16,'2018-05-18',NULL,'Капітан',16);
/*!40000 ALTER TABLE `officers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordinary`
--

DROP TABLE IF EXISTS `ordinary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordinary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rang` varchar(255) NOT NULL,
  `soldier_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_wj4p2l4t2tr8nji4malv1ydw` (`soldier_id`),
  CONSTRAINT `FK5fneqi178pt41ny9gmrunejww` FOREIGN KEY (`soldier_id`) REFERENCES `soldier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordinary`
--

LOCK TABLES `ordinary` WRITE;
/*!40000 ALTER TABLE `ordinary` DISABLE KEYS */;
INSERT INTO `ordinary` VALUES (1,'Старшина',17),(2,'Сержант',18),(3,'Прапорщик',19),(4,'Єфрейтор',20),(5,'Рядовий',21),(6,'Старшина',22),(7,'Сержант',23),(8,'Рядовий',24),(9,'Єфрейтор',25);
/*!40000 ALTER TABLE `ordinary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platoon`
--

DROP TABLE IF EXISTS `platoon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `platoon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `squadron_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt59vviwhhk5cngtycom91xg0d` (`squadron_id`),
  CONSTRAINT `FKt59vviwhhk5cngtycom91xg0d` FOREIGN KEY (`squadron_id`) REFERENCES `squadron` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platoon`
--

LOCK TABLES `platoon` WRITE;
/*!40000 ALTER TABLE `platoon` DISABLE KEYS */;
INSERT INTO `platoon` VALUES (1,'PLT1','Взвод 1',1),(2,'PLT2','Взвод 2',1),(3,'PLT3','Взвод 3',1),(4,'PLT4','Взвод 4',2),(5,'PLT5','Взвод 5',2),(6,'PLT6','Взвод 6',2),(7,'PLT7','Взвод 7',3),(8,'PLT8','Взвод 8',3),(9,'PLT9','Взвод 9',3),(10,'PLT10','Взвод 10',4),(11,'PLT11','Взвод 11',4),(12,'PLT12','Взвод 12',4),(13,'PLT13','Взвод 13',5),(14,'PLT14','Взвод 14',5),(15,'PLT15','Взвод 15',5);
/*!40000 ALTER TABLE `platoon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soldier`
--

DROP TABLE IF EXISTS `soldier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soldier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `military_base_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa5pwlotj4yikedppcku7rp0ps` (`military_base_id`),
  CONSTRAINT `FKa5pwlotj4yikedppcku7rp0ps` FOREIGN KEY (`military_base_id`) REFERENCES `military_base` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soldier`
--

LOCK TABLES `soldier` WRITE;
/*!40000 ALTER TABLE `soldier` DISABLE KEYS */;
INSERT INTO `soldier` VALUES (1,'Бузілов О.В.',30,1),(2,'Вишиван В. А.',31,1),(3,'Будько Б. Б.',32,1),(4,'Ступка Б. Б.',33,2),(5,'Максимович М. М.',34,2),(6,'Дудко Д. Д.',35,2),(7,'Мишко С. С.',36,3),(8,'Сергійко С. С.',37,3),(9,'Соловей С. С.',38,3),(10,'Диман Д. Д.',39,4),(11,'Туман О. П.',40,4),(12,'Шнапс Н. В.',41,4),(13,'Покемон В. В.',42,5),(14,'Стус В. В.',43,5),(15,'Щербанюк В. В.',44,5),(16,'Лук Л. Л.',45,6),(17,'Жук Ж. Ж.',34,6),(18,'Жубя М. А.',37,6),(19,'Коваль С. П.',41,6),(20,'Денько Д. Д.',25,7),(21,'Суп С. С.',26,7),(22,'Токар В. А.',33,7),(23,'Павлін П. О.',34,7),(24,'Блажчук М. О.',35,13),(25,'Блажчук П. О.',36,13);
/*!40000 ALTER TABLE `soldier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soldier_specialty`
--

DROP TABLE IF EXISTS `soldier_specialty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soldier_specialty` (
  `id_soldier` int(11) NOT NULL,
  `specialty` varchar(255) NOT NULL,
  PRIMARY KEY (`id_soldier`,`specialty`),
  CONSTRAINT `FK9fb2i84hge2yebyd9ff65wwnv` FOREIGN KEY (`id_soldier`) REFERENCES `soldier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soldier_specialty`
--

LOCK TABLES `soldier_specialty` WRITE;
/*!40000 ALTER TABLE `soldier_specialty` DISABLE KEYS */;
INSERT INTO `soldier_specialty` VALUES (1,'Стрілець'),(2,'Стрілець'),(3,'Розвідник'),(3,'Снайпер'),(3,'Стрілець'),(4,'Стрілець'),(5,'Стрілець'),(6,'Медик'),(6,'Снайпер'),(6,'Стрілець'),(7,'Стрілець'),(8,'Стрілець'),(9,'Стрілець'),(10,'Стрілець'),(11,'Стрілець'),(12,'Стрілець'),(13,'Стрілець'),(14,'Стрілець'),(15,'Стрілець'),(16,'Стрілець'),(17,'Стрілець'),(18,'Стрілець'),(19,'Стрілець'),(20,'Стрілець'),(21,'Стрілець'),(22,'Стрілець'),(23,'Стрілець'),(24,'Стрілець'),(25,'Стрілець');
/*!40000 ALTER TABLE `soldier_specialty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `squadron`
--

DROP TABLE IF EXISTS `squadron`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `squadron` (
  `id` int(11) NOT NULL,
  `code_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `military_base_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK37p0jd2dm7asws2g2vxmubgbu` (`military_base_id`),
  CONSTRAINT `FK37p0jd2dm7asws2g2vxmubgbu` FOREIGN KEY (`military_base_id`) REFERENCES `military_base` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `squadron`
--

LOCK TABLES `squadron` WRITE;
/*!40000 ALTER TABLE `squadron` DISABLE KEYS */;
INSERT INTO `squadron` VALUES (1,'SQD1','Рота 1',1),(2,'SQD2','Рота 2',1),(3,'SQD3','Рота 3',1),(4,'SQD4','Рота 4',2),(5,'SQD5','Рота 5',2),(6,'SQD6','Рота 6',2),(7,'SQD7','Рота 7',3),(8,'SQD8','Рота 8',3),(9,'SQD9','Рота 9',3),(10,'SQD10','Рота 10',4),(11,'SQD11','Рота 11',4),(12,'SQD12','Рота 12',4),(13,'SQD13','Рота 13',5),(14,'SQD14','Рота 14',5),(15,'SQD15','Рота 15',5);
/*!40000 ALTER TABLE `squadron` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport`
--

DROP TABLE IF EXISTS `transport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transport_type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `fightings_seats` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transport`
--

LOCK TABLES `transport` WRITE;
/*!40000 ALTER TABLE `transport` DISABLE KEYS */;
INSERT INTO `transport` VALUES (1,'БМП','Кул БМП',6,3),(2,'БМП','Еназа БМП',6,4),(3,'БМП','Супер БМП',6,4),(4,' Тягач','Файний тягач',1,0),(5,' Тягач','Топ тягач',2,0),(6,'Автотранспорт','Просто авто',4,0),(7,'Автотранспорт','Топ авто',8,2);
/*!40000 ALTER TABLE `transport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport_in_mbase`
--

DROP TABLE IF EXISTS `transport_in_mbase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transport_in_mbase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `military_base_id` int(11) NOT NULL,
  `transport_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKovwkgyv17b5t7oj5ehj7c2oun` (`military_base_id`),
  KEY `FKae76vbo8mg8rsacw34c3bmgg8` (`transport_id`),
  CONSTRAINT `FKae76vbo8mg8rsacw34c3bmgg8` FOREIGN KEY (`transport_id`) REFERENCES `transport` (`id`),
  CONSTRAINT `FKovwkgyv17b5t7oj5ehj7c2oun` FOREIGN KEY (`military_base_id`) REFERENCES `military_base` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transport_in_mbase`
--

LOCK TABLES `transport_in_mbase` WRITE;
/*!40000 ALTER TABLE `transport_in_mbase` DISABLE KEYS */;
INSERT INTO `transport_in_mbase` VALUES (1,1,1,3),(2,1,2,5),(3,1,4,1),(4,1,7,3),(5,2,1,1),(6,2,2,3),(7,3,1,3),(8,3,6,2),(9,3,7,4),(10,4,1,3),(11,4,7,5),(12,5,1,7),(13,5,3,2),(14,5,4,4),(15,5,7,3),(16,6,2,1),(17,6,3,1),(18,7,4,1),(19,8,5,1),(20,9,1,10),(21,10,2,10),(22,11,3,10),(23,12,1,5),(24,13,2,5),(25,14,3,5),(26,14,7,3),(27,15,1,4),(28,15,4,4),(29,15,7,4);
/*!40000 ALTER TABLE `transport_in_mbase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weaponry`
--

DROP TABLE IF EXISTS `weaponry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weaponry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `weaponry_type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `caliber` varchar(255) DEFAULT NULL,
  `silencer` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weaponry`
--

LOCK TABLES `weaponry` WRITE;
/*!40000 ALTER TABLE `weaponry` DISABLE KEYS */;
INSERT INTO `weaponry` VALUES (1,'Карабін','Карабінчик 1','7.62','n'),(2,'Карабін','Топ карабін','7.62','n'),(3,'Автомат','АК47','7.62','n'),(4,'Автомат','M4A1','5.56','n'),(5,'Автомат','M4A1-S','5.56','y'),(6,'Артилерія','Крута артилерія','','n'),(7,'Артилерія','Інша артилерія','','n'),(8,'Артилерія','Топова артилерія','','n'),(9,'Ракети','Анріл ракети','','n'),(10,'Ракети','Такі ракети','','n'),(11,'Ракети','Зовсім інші ракети','','n'),(12,'Ракети','Трохи інші ракети','','n');
/*!40000 ALTER TABLE `weaponry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weaponry_in_mbase`
--

DROP TABLE IF EXISTS `weaponry_in_mbase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weaponry_in_mbase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `military_base_id` int(11) NOT NULL,
  `weaponry_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK71hv1gfbfo4dcv13h43pq68rd` (`military_base_id`),
  KEY `FK66qmjhed7wg329mwhliwylo1b` (`weaponry_id`),
  CONSTRAINT `FK66qmjhed7wg329mwhliwylo1b` FOREIGN KEY (`weaponry_id`) REFERENCES `weaponry` (`id`),
  CONSTRAINT `FK71hv1gfbfo4dcv13h43pq68rd` FOREIGN KEY (`military_base_id`) REFERENCES `military_base` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weaponry_in_mbase`
--

LOCK TABLES `weaponry_in_mbase` WRITE;
/*!40000 ALTER TABLE `weaponry_in_mbase` DISABLE KEYS */;
INSERT INTO `weaponry_in_mbase` VALUES (1,1,1,300),(2,1,2,500),(3,1,3,1000),(4,1,6,100),(5,2,3,400),(6,2,6,200),(7,2,7,50),(8,3,1,100),(9,3,3,200),(10,4,4,100),(11,4,5,50),(12,4,6,30),(13,5,1,300),(14,5,2,300),(15,5,7,40),(16,5,8,80),(17,6,3,500),(18,7,4,150),(19,8,5,200),(20,9,6,70),(21,10,7,60),(22,11,8,90),(23,12,1,500),(24,13,2,400),(25,14,3,300),(26,15,4,200);
/*!40000 ALTER TABLE `weaponry_in_mbase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'military_base'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-22 10:16:02
