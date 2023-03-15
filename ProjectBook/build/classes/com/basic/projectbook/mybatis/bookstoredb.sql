create database bookstoredb;

use bookstoredb;

create table member(
no int auto_increment primary key,
name varchar(30) not null,
id varchar(30) unique key not null,
pw varchar(30) not null,
email varchar(30) not null,
phone varchar(30) not null,
genre varchar(30) not null,
address varchar(50) not null,
mileage int not null default 0
);


select * from member;

create table book(
no int auto_increment primary key,
name varchar(50) not null,
price int not null,
genre varchar(30) not null,
qty int not null,
country int not null,
sale int not null,
img varchar(50) not null,
writer varchar(30) not null,
info varchar(1000) not null,
publication datetime not null,
company varchar(30) not null,
discount int not null
);


select * from book;