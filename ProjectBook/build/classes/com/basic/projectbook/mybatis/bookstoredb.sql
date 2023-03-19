create database bookstoredb;

use bookstoredb;

create table member(
no int auto_increment primary key,
name varchar(30) not null,
id varchar(30) unique key not null,
pw varchar(30) not null,
email varchar(30) not null,
phone varchar(30) not null,
interest varchar(30), 
address varchar(50) not null,
mileage int not null default 0
);

create table cart(
no int auto_increment primary key,
isbn varchar(50),
cqty int not null,
status int not null,
id varchar(50),
foreign key(id) references member (id) on update cascade on delete cascade,
foreign key(isbn) references book (isbn) on update cascade on delete cascade
)

<<<<<<< HEAD




=======
>>>>>>> kbj_dev
create table order(
no int primary key,
receive int not null,
id varchar(50) not null,
isbn varchar(50) not null,
cqty int not null

);

create table sale(
no int,
isbn varchar(50),
qty int

)


INSERT INTO member (name, id, pw, email, phone, interest, address) VALUES
('qwer', 1, 3, 'a@a.com','010-1111-1111', '추리', '경기도'),
('test', 2, 3, 'a@a.com','010-1111-1111', '추리', '경기도'),
('관리자', 'admin', 'admin', 'admin@admin.com','010-1111-1111', '관리자', '관리자');

select * from member;
delete from member;
drop table member;





create table book(
no int auto_increment primary key,
title varchar(500) not null,
image varchar(2000) not null,
author varchar(30) not null,
discount varchar(50) not null,
publisher varchar(30) not null,

pubdate varchar(50) not null,

isbn varchar(50) not null unique ,
description varchar(5000) not null,
genre varchar(30) not null,
country varchar(30) not null


);

select * from book;
delete from book;
drop table book;
drop table bookstock;




create table bookstock(
no int auto_increment primary key,
storeid varchar(50),
qty varchar(50),
isbn varchar(50),
foreign key(isbn) references book(isbn) on update cascade on delete cascade
)


create table store(
 no int auto_increment primary key,
 storename varchar(50),
 storeid int,

 foreign key(storeid)references bookstock(storeid) on delete cascade
)



INSERT INTO book(title,image,author,discount,publisher,pubdate,isbn,description,genre,country) VALUES
('호밀밭의 파수꾼', 'image1.jpg', 'J.D. 샐린저', 10000, '한국문학', '1951-07-16', '978-89-453-1254-4', '청춘의 아픔과 혼란을 그린 소설', '소설', '미국'),
('마토인', 'image2.jpg', '한강', 20000, '창비', '2021-02-22', '978-89-387-0145-9', '현대사회의 각종 문제들을 논하고 해결책 제시', '인문학', '한국'),
('파우스트', 'image3.jpg', '조한 월페', 15000, '세종서적', '1808-01-01', '978-89-7354-987-8', '인생의 목적을 찾아가는 과정을 그린 문학 작품', '소설', '독일'),
('어린왕자', 'image4.jpg', '생텍쥐페리', 5000, '민음사', '1943-04-06', '978-89-372-0895-5', '인간관계, 자아성찰 등을 다룬 소설', '소설', '프랑스'),
('책은 도끼다', 'image5.jpg', '박웅현', 10000, '북라이프', '2020-06-29', '979-11-970738-4-4', '책의 중요성과 책을 읽는 방법에 대한 고찰', '자기계발', '한국'),
('나미야 잡화점의 기적', 'image6.jpg', '히가시노 게이고', 10000, '재인', '2009-02-19', '978-89-7026-446-6', '인간관계와 우정에 대한 이야기를 그린 소설', '소설', '일본'),
('노르웨이의 숲', 'image7.jpg', '문학 도서관', 25000, '문학동네', '1987-08-28', '978-89-453-7256-1', '청춘의 삶과 사랑, 죽음을 그린 소설', '소설', '일본')




select * from book;
drop table book;
delete from book;