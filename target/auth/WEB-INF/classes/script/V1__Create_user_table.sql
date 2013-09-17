########################################
#                User table
########################################

DROP table if EXISTS `user`;

create table `user`(
	
`ID` BIGINT(22) auto_increment,
`USER_NAME` VARCHAR(255) NOT NULL,
`PASS_WORD` VARCHAR(255) NOT null,
`ENABLE` TINYINT(2) DEFAULT 1,
PRIMARY KEY (`ID`)
)ENGINE=INNODB DEFAULT CHARSET=utf8

########################################
#                Auth table
########################################

DROP TABLE IF EXISTS `auth`;

CREATE TABLE `auth`(
`ID` BIGINT(22) NOT NULL auto_increment,
`USER_NAME` VARCHAR(255) not NULL,
`ROLE` VARCHAR(512) NOT NULL,
PRIMARY KEY(`ID`)
)ENGINE=INNODB DEFAULT CHARSET = utf8

########################################
#                Resource table
########################################

DROP TABLE IF EXISTS `resource`;

CREATE TABLE `resource`(
`ID` BIGINT(22) NOT NULL auto_increment,
`RESOURCE` VARCHAR(512) not NULL,
`RESOURCE_TYPE` VARCHAR(64) NOT NULL,
`ROLE` VARCHAR(512) NOT NULL,
`DESC` VARCHAR(512) NOT NULL,
PRIMARY KEY(`ID`)
)ENGINE=INNODB DEFAULT CHARSET = utf8