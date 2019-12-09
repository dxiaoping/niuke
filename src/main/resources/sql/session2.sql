
CREATE TABLE `test_myisam` (
    `id` INT (2) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR (20),
    `unique_id` INT (2),
    `normal_id` INT (2),
    PRIMARY KEY (`id`),
    UNIQUE(`unique_id`),
    INDEX(`normal_id`)
) ENGINE = MYISAM AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 ;

CREATE TABLE `test_innodb` (
    `id` INT (2) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR (20),
    `unique_id` INT (2),
    `normal_id` INT (2),
    PRIMARY KEY (`id`),
    UNIQUE(`unique_id`),
    INDEX(`normal_id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 ;
insert into test_innodb (name,unique_id,normal_id) values('a',1,1),('d',4,4),('h',8,8),('k',11,11);
insert into test_myisam (name,unique_id,normal_id) values('a',1,1),('d',4,4),('h',8,8),('k',11,11);


use sql_study_data;
alter table test add `name` varchar(10) not null ;
select @@tx_isolation;


set session transaction isolation level read uncommitted ;

