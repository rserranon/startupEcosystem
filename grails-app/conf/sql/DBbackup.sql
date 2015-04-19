-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: localhost    Database: startu60_StartupEcosystemCanvas
-- ------------------------------------------------------
-- Server version	5.6.24

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
-- Current Database: `startu60_StartupEcosystemCanvas`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `startu60_StartupEcosystemCanvas` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `startu60_StartupEcosystemCanvas`;

--
-- Table structure for table `bar`
--

DROP TABLE IF EXISTS `bar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bar` (
  `m` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bar`
--

LOCK TABLES `bar` WRITE;
/*!40000 ALTER TABLE `bar` DISABLE KEYS */;
INSERT INTO `bar` VALUES (1);
/*!40000 ALTER TABLE `bar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meta_resource`
--

DROP TABLE IF EXISTS `meta_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meta_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `meta_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meta_resource`
--

LOCK TABLES `meta_resource` WRITE;
/*!40000 ALTER TABLE `meta_resource` DISABLE KEYS */;
INSERT INTO `meta_resource` VALUES (1,0,'Evangelists'),(3,0,'Government'),(4,0,'Talent');
/*!40000 ALTER TABLE `meta_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phase`
--

DROP TABLE IF EXISTS `phase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phase` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `phase_name` varchar(255) NOT NULL,
  `phase_number` varchar(255) NOT NULL,
  `projectstage_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pfstrbcgf1rsfx1jl9q456ksd` (`projectstage_id`),
  CONSTRAINT `FK_pfstrbcgf1rsfx1jl9q456ksd` FOREIGN KEY (`projectstage_id`) REFERENCES `project_stage` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phase`
--

LOCK TABLES `phase` WRITE;
/*!40000 ALTER TABLE `phase` DISABLE KEYS */;
INSERT INTO `phase` VALUES (1,0,'Inspire','1',1),(2,1,'Educate','2',1),(3,0,'Validate','3',1),(4,0,'Start','1',2),(5,0,'Develop','2',2),(6,0,'Launch','3',2),(7,0,'Recognition','1',5),(8,0,'Funding','2',5),(9,0,'Growth','3',5);
/*!40000 ALTER TABLE `phase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_stage`
--

DROP TABLE IF EXISTS `project_stage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_stage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `meta_resource_id` bigint(20) DEFAULT NULL,
  `project_stage` varchar(255) NOT NULL,
  `stage_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hpqg3u3utxjvooqfmcqqqn8td` (`meta_resource_id`),
  CONSTRAINT `FK_hpqg3u3utxjvooqfmcqqqn8td` FOREIGN KEY (`meta_resource_id`) REFERENCES `meta_resource` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_stage`
--

LOCK TABLES `project_stage` WRITE;
/*!40000 ALTER TABLE `project_stage` DISABLE KEYS */;
INSERT INTO `project_stage` VALUES (1,1,1,'Idea','1'),(2,1,3,'Launch','2'),(5,1,4,'Growth','3');
/*!40000 ALTER TABLE `project_stage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `resource_name` varchar(255) NOT NULL,
  `resourceurl` varchar(255) DEFAULT NULL,
  `taxonomy_id` bigint(20) NOT NULL,
  `twitter_acct` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_arrx7kk9lbvihya0inbpj5duf` (`taxonomy_id`),
  CONSTRAINT `FK_arrx7kk9lbvihya0inbpj5duf` FOREIGN KEY (`taxonomy_id`) REFERENCES `taxonomy` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES (1,1,'Roberto Serrano','http://www.startupspal.com',2,'@StartupsPal'),(2,0,'InventMx','http://www.invent.mx',1,'N/A'),(3,0,'Early Adopters','http://earlyadopters.mx/',1,NULL),(4,0,'World Innovation Expo','http://www.wie.mx',4,NULL),(5,0,'Tech Startups Nights','http://www.tsn.mx',5,NULL),(6,0,'Startup drinks','http://df.startupdrinks.mx/',5,NULL),(7,0,'Early Adopters','http://earlyadopters.mx/',6,'N/A'),(8,0,'Emprendela','http://emprende.la/',6,'N/A'),(9,0,'Invent','http://invent.mx/',6,'N/A'),(10,0,'Roberto Serrano','http://www.startupspal.com',7,'@StartupsPal'),(11,0,'Fernando Lelo de la Rea','http://www.startupspal.com',7,'@Ferlelo'),(12,0,'Cesar Salazar','http://www.startupspal.com',7,'@Cesarsalazar'),(13,0,'Claudio Cossio','http://www.startupspal.com',7,'@CCossio'),(14,0,'Roberto Serrano','http://www.startupspal.com',7,'@StartupsPal'),(15,0,'Fernando Lelo de la Rea','http://www.startupspal.com',7,'@Ferlelo'),(16,0,'Cesar Salazar','http://www.startupspal.com',7,'@Cesarsalazar'),(17,0,'Claudio Cossio','http://www.startupspal.com',7,'@CCossio'),(18,0,'Roberto Serrano','http://www.startupspal.com',7,'@StartupsPal'),(19,0,'Fernando Lelo de la Rea','http://www.startupspal.com',7,'@Ferlelo'),(20,0,'Cesar Salazar','http://www.startupspal.com',7,'@Cesarsalazar'),(21,0,'Claudio Cossio','http://www.startupspal.com',7,'@CCossio'),(22,1,'Centraal','http://www.centraal.com/',14,NULL),(23,0,'Venture Institute','http://www.institute.vc',15,NULL),(24,1,'Mexicanvc','http://www.mexican.vc',10,NULL),(25,0,'Angel Ventures','http://www.angelventures.co',12,NULL),(26,2,'INADEM','http://www.inadem.gob.mx',16,'@Inadem_se'),(27,0,'IBM','http://www.ibm.com/mx/es/',18,NULL),(28,0,'Microsoft','http://www.microsoft.com/es-mx/',18,NULL),(29,0,'Oracle','http://www.oracle.com/lad',18,NULL),(30,0,'Accenture','http://www.accenture.com',18,NULL),(31,0,'UNAM','http://www.unam.edu.mx',17,NULL),(32,0,'Eugenio Perea',NULL,2,'@Eperea'),(33,0,'Fernando Lelo de Larrea',NULL,2,'@Ferlelo'),(34,0,'Federico Antoni',NULL,2,'@federicoantoni'),(35,0,'Cesar Salazar',NULL,2,'@Cesarsalazar'),(36,0,'Santiago Zavala',NULL,2,'@dfect'),(37,0,'Arturo Garrido',NULL,2,'@arturogarrido'),(38,1,'Hugo Stevens',NULL,2,'@Hugostevens'),(39,0,'Jorge zavala',NULL,2,'@jzavala'),(40,0,'Victor Reyes',NULL,2,'@vmreyesp');
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxonomy`
--

DROP TABLE IF EXISTS `taxonomy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taxonomy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `metaresource_id` bigint(20) DEFAULT NULL,
  `phase_id` bigint(20) DEFAULT NULL,
  `taxonomy_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rurvregm7hcv2m34j6xncg628` (`metaresource_id`),
  KEY `FK_tj3f4as146x1cwm5a3tk71rqs` (`phase_id`),
  CONSTRAINT `FK_rurvregm7hcv2m34j6xncg628` FOREIGN KEY (`metaresource_id`) REFERENCES `meta_resource` (`id`),
  CONSTRAINT `FK_tj3f4as146x1cwm5a3tk71rqs` FOREIGN KEY (`phase_id`) REFERENCES `phase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxonomy`
--

LOCK TABLES `taxonomy` WRITE;
/*!40000 ALTER TABLE `taxonomy` DISABLE KEYS */;
INSERT INTO `taxonomy` VALUES (1,0,NULL,1,'Startup Media'),(2,0,1,NULL,'Active Entrepreneur Leaders'),(3,0,NULL,2,'Best Practices'),(4,0,NULL,2,'Training and Feedback'),(5,0,NULL,3,'Team Formation'),(6,0,NULL,NULL,'Startup Media'),(7,0,NULL,NULL,'Twitter Taxonomy'),(8,0,NULL,4,'Establish'),(9,0,NULL,5,'Formalize'),(10,0,NULL,6,'Seed Accelerators'),(11,0,NULL,7,'Investor Networking'),(12,0,NULL,8,'Angels / Micro VCs'),(13,0,NULL,9,'Infrastructure'),(14,0,NULL,4,'Workspace'),(15,0,NULL,5,'Prepare for Seed'),(16,0,3,NULL,'Public Economic Development'),(17,0,4,NULL,'Major Universities'),(18,0,4,NULL,'Major Employeers');
/*!40000 ALTER TABLE `taxonomy` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-18 21:26:21
