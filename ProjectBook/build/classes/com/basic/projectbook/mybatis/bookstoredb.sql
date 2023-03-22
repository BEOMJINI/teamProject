create database bookstoredb;

use bookstoredb;

create table member(
no int auto_increment primary key,
name varchar(30) not null,
id varchar(30) unique  not null,
pw varchar(30) not null,
email varchar(30) not null,
phone varchar(30) not null,
interest varchar(30), 
address varchar(50) not null,
mileage int not null default 0
);

<<<<<<< HEAD
select * from member;
delete from member;
drop table member;
=======
>>>>>>> kbj_dev

INSERT INTO member (name, id, pw, email, phone, interest, address) VALUES
('qwer', 1, 3, 'a@a.com','010-1111-1111', '추리', '경기도'),
('test', 2, 3, 'a@a.com','010-1111-1111', '추리', '경기도'),
('관리자', 'admin', 'admin', 'admin@admin.com','010-1111-1111', '관리자', '관리자');

<<<<<<< HEAD
=======
select * from member;
delete from member;
drop table member;

>>>>>>> kbj_dev
create table cart(
no int auto_increment primary key,
isbn varchar(50),
cqty int not null,
status int not null default 1,
id varchar(50),
foreign key(id) references member (id) on update cascade on delete cascade,
foreign key(isbn) references book (isbn) on update cascade on delete cascade
);
select * from cart;
delete from cart;
drop table cart;


create table orderlist(
no int,
receive int not null,
id varchar(50) not null,
isbn varchar(50) not null,
cqty int not null

);

select * from orderlist;
delete from orderlist;
drop table orderlist;

create table sale(
no int,
isbn varchar(50),
qty int
);

select * from sale;
delete from sale;
drop table sale;

<<<<<<< HEAD

=======
>>>>>>> kbj_dev





create table book(
no int auto_increment primary key,
title varchar(500) not null,
image varchar(2000) not null,
author varchar(30) not null,
discount varchar(50) not null,
publisher varchar(30) not null,
pubdate varchar(50) not null,
isbn varchar(50) unique not null,
description varchar(5000) not null,
genre varchar(30) not null,
country varchar(30) not null


);

select * from book;
delete from book;
drop table book;


create table store(
 no int auto_increment primary key,
 storename varchar(50),
 storeid int unique

 
);

select * from store;
delete from store;
drop table store;

INSERT INTO store(storename,storeid) VALUES
('본점',0),
('강남',1),
('역삼',2),
('선릉',3)




create table bookstock(
no int auto_increment primary key,
storeid int,
qty int(50),
isbn varchar(50),
foreign key(isbn) references book(isbn) on update cascade on delete cascade,
foreign key(storeid)references store(storeid) on delete cascade
);

select * from bookstock;
delete from bookstock;
drop table bookstock;

create table applyrestock(
no int auto_increment primary key,
title varchar(500) not null,
isbn varchar(50) not null,
author varchar(30) not null,
publisher varchar(30) not null,
storename varchar(50) not null,
storeid int not null,
foreign key(isbn) references book(isbn) on update cascade on delete cascade,
foreign key(storeid) references store(storeid) on delete cascade
)

select * from applyrestock;
delete from applyrestock;
drop table applyrestock;






drop table member;
drop table cart;
drop table orderlist;
drop table sale;
drop table sale;
drop table book;
drop table store;
drop table bookstock;
drop table applyrestock;
