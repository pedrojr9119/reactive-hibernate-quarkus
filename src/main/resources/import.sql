create database if not exists mydb;
use mydb;

CREATE TABLE client (
    id binary(16) not null,
    first_name varchar(30) not null,
    age int,
	primary key (id)
);

INSERT INTO client value ('123', 'Jose', 20);
INSERT INTO client value ('456', 'Maria', 21);
