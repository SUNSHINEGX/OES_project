-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.15


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema onlinexam
--

CREATE DATABASE IF NOT EXISTS onlinexam;
USE onlinexam;

--
-- Definition of table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adm_id` int(11) NOT NULL AUTO_INCREMENT,
  `admName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `admPass` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`adm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `admin`
--

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`adm_id`,`admName`,`admPass`) VALUES 
 (1,'admin','52itstyle');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


--
-- Definition of table `examtype`
--

DROP TABLE IF EXISTS `examtype`;
CREATE TABLE `examtype` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `testTitle` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `testTime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `examtype`
--

/*!40000 ALTER TABLE `examtype` DISABLE KEYS */;
INSERT INTO `examtype` (`type_id`,`testTitle`,`testTime`) VALUES 
 (1,'语文','6'),
 (2,'PHP','2011-10-26'),
 (3,'ORACLE','120');
/*!40000 ALTER TABLE `examtype` ENABLE KEYS */;


--
-- Definition of table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `qu_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL,
  `quTitle` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `quHard` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `quType` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `quScore` int(11) NOT NULL,
  `quAnswer` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `selectOption` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`qu_id`),
  KEY `FKBE5CA00621011593` (`type_id`),
  KEY `FKBE5CA006B04D67C1` (`type_id`),
  CONSTRAINT `FKBE5CA00621011593` FOREIGN KEY (`type_id`) REFERENCES `examtype` (`type_id`),
  CONSTRAINT `FKBE5CA006B04D67C1` FOREIGN KEY (`type_id`) REFERENCES `examtype` (`type_id`),
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `examtype` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `question`
--

/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` (`qu_id`,`type_id`,`quTitle`,`quHard`,`quType`,`quScore`,`quAnswer`,`selectOption`) VALUES 
 (1,1,'汉的拼音','简单','单选题',1,'han:ham:hak','1'),
 (2,1,'民的拼音','简单','单选题',1,'min:ming:mng','1'),
 (3,1,'王的拼音','简单','单选题',1,'wang:ang:wan','1'),
 (4,1,'哈的拼音','简单','单选题',1,'ha:hu:hua','1'),
 (5,1,'维的拼音','简单','单选题',1,'wei:ei:wi','1'),
 (6,1,'孟的拼音','简单','单选题',1,'meng:men:neng','1'),
 (7,1,'无的拼音','简单','单选题',1,'wu:w:u','1'),
 (8,1,'欧的拼音','简单','单选题',1,'ou:ow:you','1'),
 (9,1,'天的拼音','简单','单选题',1,'tian:tan:tyan','1'),
 (10,1,'化的拼音','简单','单选题',1,'hua:ham:hak','1'),
 (11,1,'就的拼音','简单','单选题',1,'jiu:jou:jyou','1'),
 (12,1,'年的拼音','简单','单选题',1,'nian:yan:nan','1'),
 (13,1,'欻的拼音','简单','单选题',1,'chua:chuan:yan','1'),
 (14,3,'SELECT * FROM emp是什么意思','简单','单选题',1,'不知道','不知道:查询全部员工');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;


--
-- Definition of table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `stuNumber` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `stuName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `className` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `stuMail` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `humanId` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `stuPhone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`stu_id`,`stuNumber`,`stuName`,`className`,`stuMail`,`humanId`,`address`,`stuPhone`) VALUES 
 (1,'123456789123456','张三','SVSE','zhang@21cn.com','2134234234','广州','3434344'),
 (2,'4535345435545345','李四','SVSE','zhang@21cn.com','2134234234','广州','3434344'),
 (3,'4535345435545345','王五','SVSE','zhang@21cn.com','2134234234','广州','3434344'),
 (4,'20100001','夏小山','20110822','abc#163.com','88888','武汉市东湖高新区','87654321'),
 (5,'20111101','李四','svse1','abc@111.com','12345','光谷','987544');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
