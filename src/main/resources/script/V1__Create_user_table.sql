drop table  if exists `auth_user`;
create table `auth_user`(
	`id` bigint(20) not null auto_increment,
	`user_name` varchar(255) not null,
	`password` varchar(255) not null,
	
)