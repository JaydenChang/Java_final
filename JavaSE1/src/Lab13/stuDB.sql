/*
use test;
drop table if exists `stuDB`;
create table `stuDB` (
    `id` int(11) unsigned NOT NULL auto_increment,
    `name` varchar(50) default NULL,
    `sex` varchar(50) default NULL,
    `grade` int(11) default NULL,
    `term` int(11) default NULL,
    `math` int(11) default NULL,
    `cpp` int(11) default NULL,
    `js` int(11) default NULL,
    primary key (`id`)
) engine=InnoDB auto_increment=11 default charset=utf8;
*/
SELECT * FROM `stuDB`;
INSERT INTO `stuDB` (`name`,`sex`,`grade`,`term`,`math`,`cpp`,`js`) VALUES 
('James','male',20,1,80,80,80),
('Bryant','male',21,2,70,80,90),
('Swift','female',19,1,70,80,80);
