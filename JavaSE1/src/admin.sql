create database if not exists test;
use test;
drop table if exists `admin`;
create table `admin` (
    `id` int(11) not null auto_increment,
    `username` varchar(32) default null,
    `password` varchar(32) default null,
    primary key (`id`)    
) engine=InnoDB auto_increment=1 default charset=utf8;

insert into `admin` (`username`,`password`) values ('root','admin');
