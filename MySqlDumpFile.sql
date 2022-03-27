DROP DATABASE IF EXISTS `six_nations`;
CREATE DATABASE `six_nations`;
USE `six_nations`;
DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
                          `PLAYER_ID` int(11) NOT NULL AUTO_INCREMENT,
                          `FULL_NAME` varchar(50) NOT NULL,
                          `POSITION` varchar(50) NOT NULL,
                          `CAPS` int(20) NOT NULL,
                          `TOTAL_TIME` decimal(20) NOT NULL,
                          PRIMARY KEY  (`PLAYER_ID`)
);

INSERT INTO player VALUES (null, "Bundee Aki","Centre",35,281.00),
                          (null, "Joey Carbery","Flyhalf",30,262.00),
                          (null, "Keith Earls","Fullback/Wing",96,36.00),
                          (null, "Tadhg Furlong","Prop",55,362.00),
                          (null, "Cian Healy","Prop",114,73.00),
                          (null, "Iain Henderson","Lock/Back Row",66,93.00),
                          (null, "Robbie Henshaw","Centre/Fullback",55,150.00),
                          (null, "Conor Murray","Scrumhalf",94,110.00),
                          (null, "Peter O'Mahony","Back Row",82,244.00),
                          (null, "Johnny Sexton","Flyhalf",103,216.00);