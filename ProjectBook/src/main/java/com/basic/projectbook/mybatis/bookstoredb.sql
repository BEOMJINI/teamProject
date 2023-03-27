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

INSERT INTO member (name, id, pw, email, phone, interest, address) VALUES
('qwer', 1, 3, 'a@a.com','010-1111-1111', '추리', '경기도'),
('test', 2, 3, 'a@a.com','010-1111-1111', '추리', '경기도'),
('관리자', 'admin', 'admin', 'admin@admin.com','010-1111-1111', '관리자', '관리자');

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



create table cart(
no int auto_increment primary key,
isbn varchar(50),
cqty int not null,
status int not null default 1,
id varchar(50),
foreign key(id) references member (id) on update cascade on delete cascade,
foreign key(isbn) references book (isbn) on update cascade on delete cascade
);


create table orderlist(
no int,
receive int not null,
id varchar(50) not null,
isbn varchar(50) not null,
cqty int not null,
title varchar(500) not null,
discount int not null,
image varchar(500) not null,
orderdate varchar (100) not null
);


create table sale(
no int,
isbn varchar(50),
qty int
);


create table review(
no int auto_increment primary key,
isbn varchar(50),
id varchar(30),
rating int not null,
title varchar(50),
comment varchar(300),
foreign key(id) references member (id) on update cascade on delete cascade,
foreign key(isbn) references book (isbn) on update cascade on delete cascade
);



create table store(
 no int auto_increment primary key,
 storename varchar(50) unique,
 storeid int unique
);

INSERT INTO store(storename,storeid) VALUES
('책방 강남점(본점)',0),
('책방 잠실점',1),
('책방 목동점',2),
('책방 영등포점',3);

create table storemap(
no int auto_increment primary key,
storeid int,
storename varchar(50),
location1 double,
location2 double,
img varchar(500),
address varchar(100),
foreign key(storeid) references store (storeid) on update cascade on delete cascade,
foreign key(storename) references store (storename) on update cascade on delete cascade
);

insert into storemap(storeid,storename,location1,location2,img,address) values
(0,'책방 강남점(본점)',37.503715,127.024135,'https://lh3.googleusercontent.com/p/AF1QipOs80RMKkMbTOJhnm1XWgYXd5jjLOEeC5ILvIdP=s680-w680-h510','서울특별시 서초구 강남대로 465'),
(1,'책방 잠실점',37.514255,127.101273,'https://lh3.googleusercontent.com/p/AF1QipNDsHnEuwO-kzpkwGHphDIM5CJB8XOZI-S31gfy=s680-w680-h510','서울특별시 송파구 올림픽로 269 롯데캐슬골드 B1F'),
(2,'책방 목동점',37.528240,126.874982,'https://lh3.googleusercontent.com/p/AF1QipPJADbMLjnhjmTpQGs10W6_VA6MrNsVzAuB3Nv2=s680-w680-h510','서울특별시 양천구 목동서로 159-1'),
(3,'책방 영등포점',37.517014,126.904143,'https://lh3.googleusercontent.com/p/AF1QipPrfQJGDPn2ZbKihgFHd9Hpwajm6rO4v6cI3D8j=s680-w680-h510','서울특별시 영등포구 영중로 15');


create table bookstock(
no int auto_increment primary key,
storeid int,
qty int default 0,
isbn varchar(50),
foreign key(isbn) references book(isbn) on update cascade on delete cascade,
foreign key(storeid)references store(storeid) on delete cascade
);

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
);


select * from member;
select * from book;

select * from cart;
select * from orderlist;
select * from sale;
select * from review;
select * from store;

select * from storemap;
select * from bookstock;

select * from applyrestock;

drop table member;
drop table book;

drop table cart;
drop table orderlist;
drop table sale;
drop table review;
drop table store;
drop table storemap;
drop table bookstock;
drop table applyrestock;