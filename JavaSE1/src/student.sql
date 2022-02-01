create database if not exists test;
use test;
drop table if exists `student`;
create table `student` (
    `id` int(11) not null auto_increment,
    `name` varchar(32) default NULL,
    `stuNo` varchar(32) default NULL,
    `department` varchar(32) default NULL,
    `totalMark` varchar(32) default NULL,
    `linuxPoint` varchar(32) default NULL,
    `cppPoint` varchar(32) default NULL,
    `javaPoint` varchar(32) default NULL,
    `GPA` varchar(32) default NULL,
    primary key (`id`)
) engine=InnoDB auto_increment=1 default charset=utf8;

insert into `student` (`name`,`stuNo`,`department`,`totalMark`,`linuxPoint`,`cppPoint`,`javaPoint`,`GPA`) values ('kobe','2001','软件学院','10','3.0','3.0','3.0','3.0');
insert into `student` (`name`,`stuNo`,`department`,`totalMark`,`linuxPoint`,`cppPoint`,`javaPoint`,`GPA`) values ('james','2002','软件学院','10','3.0','3.0','3.0','3.0');
insert into `student` (`name`,`stuNo`,`department`,`totalMark`,`linuxPoint`,`cppPoint`,`javaPoint`,`GPA`) values ('张三','2003','软件学院','10','3.0','3.0','3.0','3.0');
insert into `student` (`name`,`stuNo`,`department`,`totalMark`,`linuxPoint`,`cppPoint`,`javaPoint`,`GPA`) values ('李四','2004','软件学院','10','3.0','3.0','3.0','3.0');
insert into `student` (`name`,`stuNo`,`department`,`totalMark`,`linuxPoint`,`cppPoint`,`javaPoint`,`GPA`) values ('王五','2005','软件学院','10','3.0','3.0','3.0','3.0');
insert into `student` (`name`,`stuNo`,`department`,`totalMark`,`linuxPoint`,`cppPoint`,`javaPoint`,`GPA`) values ('姚六','2006','软件学院','10','3.0','3.0','3.0','3.0');
insert into `student` (`name`,`stuNo`,`department`,`totalMark`,`linuxPoint`,`cppPoint`,`javaPoint`,`GPA`) values ('aaa','2007','软件学院','10','3.0','3.0','3.0','3.0');
insert into `student` (`name`,`stuNo`,`department`,`totalMark`,`linuxPoint`,`cppPoint`,`javaPoint`,`GPA`) values ('bbb','2008','软件学院','10','3.0','3.0','3.0','3.0');
insert into `student` (`name`,`stuNo`,`department`,`totalMark`,`linuxPoint`,`cppPoint`,`javaPoint`,`GPA`) values ('Jayden','2009','软件学院','10','3.0','3.0','3.0','3.0');
insert into `student` (`name`,`stuNo`,`department`,`totalMark`,`linuxPoint`,`cppPoint`,`javaPoint`,`GPA`) values ('wade','2010','软件学院','10','3.0','3.0','3.0','3.0');
insert into `student` (`name`,`stuNo`,`department`,`totalMark`,`linuxPoint`,`cppPoint`,`javaPoint`,`GPA`) values ('curry','2011','软件学院','10','3.0','3.0','3.0','3.0');
