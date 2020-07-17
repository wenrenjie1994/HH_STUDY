create database hr_system default charset =utf8;
use hr_system;
create table resume (
    id bigint(20) not null auto_increment,
    name varchar(20) default '',
    jod varchar(20) default '',
    year int default 0,
    primary key (id)
) engine = InnoDB default charset =utf8;