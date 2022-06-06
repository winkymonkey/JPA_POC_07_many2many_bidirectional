DROP database IF EXISTS `jpa_JBD`;
CREATE database IF NOT EXISTS `jpa_JBD`;
use `jpa_JBD`;


DROP TABLE IF EXISTS `jpa_JBD`.`BRANCH_SUBJECT`;
DROP TABLE IF EXISTS `jpa_JBD`.`SUBJECT`;
DROP TABLE IF EXISTS `jpa_JBD`.`BRANCH`;


CREATE TABLE `BRANCH` (
  `BRANCH_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BRANCH_SHORT_NAME` varchar(45) NOT NULL,
  `BRANCH_NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`BRANCH_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


CREATE TABLE `SUBJECT` (
  `SUBJECT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SUBJECT_NAME` varchar(100) NOT NULL,
  `SUBJECT_DESC` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SUBJECT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;


CREATE TABLE `BRANCH_SUBJECT` (
  `BRANCH_ID` int(11) NOT NULL,
  `SUBJECT_ID` int(11) NOT NULL,
  PRIMARY KEY (`BRANCH_ID`,`SUBJECT_ID`),
  KEY `SUBJECT_ID_FK_idx` (`SUBJECT_ID`),
  CONSTRAINT `BRANCH_SUB_ID_FK` 
  	FOREIGN KEY (`BRANCH_ID`) 
  	REFERENCES `BRANCH` (`BRANCH_ID`) 
  	ON DELETE NO ACTION 
  	ON UPDATE NO ACTION,
  CONSTRAINT `SUBJECT_SUB_ID_FK` 
  	FOREIGN KEY (`SUBJECT_ID`) 
  	REFERENCES `Subject` (`SUBJECT_ID`) 
  	ON DELETE NO ACTION 
  	ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;