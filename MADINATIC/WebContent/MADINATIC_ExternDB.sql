drop database if exists People;
create database if not exists People;
use People;
create table People(
	id_card integer primary key,
    name_ varchar(20),
    first_name varchar(20),
    age smallint,
    date_birth date,
    gender enum ('Male','Female')
);