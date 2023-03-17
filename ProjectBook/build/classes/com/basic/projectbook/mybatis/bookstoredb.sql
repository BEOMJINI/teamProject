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

create table cart{
no int auto_increment primary key,
isbn varchar(50),
cqty int not null,
status int not null,
id varchar(50),
foreign key(id) references member (id) on update cascade on delete cascade,
foreign key(isbn) references book (isbn) on update cascade on delete cascade
}

create table order{
no int,
receive int,
id varchar(50),
isbn varchar(50),
cqty int

}
create table sale{
no int,
isbn varchar(50),
qty int

}

INSERT INTO member (name, id, pw, email, phone, interest, address) VALUES
('qwer', 1, 3, 'a@a.com','010-1111-1111', '추리', '경기도'),
('test', 2, 3, 'a@a.com','010-1111-1111', '추리', '경기도'),
('관리자', 'admin', 'admin', 'admin@admin.com','010-1111-1111', '관리자', '관리자');

select * from member;
delete from member;
drop table member;
delete from book;


create table book(
no int auto_increment primary key,
title varchar(50) not null,
image varchar(50) not null,
author varchar(30) not null,
discount int not null,
publisher varchar(30) not null,
pubdate datetime not null,
isbn varchar(50) not null ,
description varchar(1000) not null,
genre varchar(30) not null,
country varchar(30) not null,






);
create table bookstock{
no int auto_increment primary key,
storeid varchar(50),
qty varchar(50),
isbn varchar(50),
foreign key(isbn) references book(isbn) on update cascade on delete cascade
}


create table store{
 no int auto_increment primary key,
 storename varchar(50),
 storeid int,
 foreign key(storeid)references bookstock(storeid) on update cascade on delete cascade
}


/*INSERT INTO book (name, price, genre, qty, country, sale, img, writer, info, publication, company, discount) VALUES
('test1', 1000, '추리', '3', 0, 10, '', '작가1'),
('test2', 2000, '로맨스', '3', 1, 20, '', '작가2');
INSERT INTO book (name, price, genre, qty, country, sale, img, writer, info, publication, company, discount)
VALUES
('The Great Gatsby', 20000, 'Fiction', 50, 1, 20, 'thegreatgatsby.jpg', 'F. Scott Fitzgerald', 'The Great Gatsby is a novel by American author F. Scott Fitzgerald. First published in 1925, it is set on Long Island\'s North Shore and in New York City from spring to autumn of 1922. The novel takes place following the First World War.', '1925-04-10', 'Scribner', 5),
('To Kill a Mockingbird', 15000, 'Fiction', 75, 1, 15, 'tokillamockingbird.jpg', 'Harper Lee', 'To Kill a Mockingbird is a novel by Harper Lee published in 1960. It was immediately successful, winning the Pulitzer Prize, and has become a classic of modern American literature. The plot and characters are loosely based on the author\'s observations of her family, her neighbors and an event that occurred near her hometown of Monroeville, Alabama, in 1936, when she was 10 years old.', '1960-07-11', 'J. B. Lippincott & Co.', 10),
('1984', 18000, 'Fiction', 100, 1, 25, '1984.jpg', 'George Orwell', '1984 is a dystopian novella by George Orwell published in 1949, which follows the life of Winston Smith, a low ranking member of "the Party", who is frustrated by the omnipresent eyes of the party, and its ominous ruler Big Brother.', '1949-06-08', 'Secker & Warburg', 15),
('The Catcher in the Rye', 17000, 'Fiction', 60, 0, 10, 'thecatcherintherye.jpg', 'J. D. Salinger', 'The Catcher in the Rye is a novel by J. D. Salinger, partially published in serial form in 1945–1946 and as a novel in 1951. It was originally intended for adults but is often read by adolescents for its themes of angst, alienation, and as a critique on superficiality in society.', '1951-07-16', 'Little, Brown and Company', 0),
('Pride and Prejudice', 12000, 'Fiction', 90, 0, 20, 'prideandprejudice.jpg', 'Jane Austen', 'Pride and Prejudice is a romantic novel of manners written by Jane Austen in 1813. The novel follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness.', '1813-01-28', 'T. Egerton, Whitehall', 20);
*/

INSERT INTO book (name, isbn,price, genre, storeId, country, img, author, info, publication, company, discount) VALUES
('코스모스', '0679735771',18000, '과학', 0, 1,  '1.jpg', '칼 세이건', '우주의 기원과 발전, 무한한 우주의 이론 등에 대한 내용을 다룬 과학서적입니다. 1980년도에 출간되어 인기를 얻었으며, 지금까지도 많은 사람들에게 사랑받고 있습니다.', '1980-01-01', '출판사A', 5),
('1984', '0747532699',13000, '소설', 1, 1, '2.jpg', '조지 오웰', '모든 것이 규제되고 감시당하는 미래사회를 묘사한 걸작 소설입니다. 절대권력, 인간의 본성 등에 대한 생각을 자아내며, 오늘날까지도 많은 이들에게 인기를 끌고 있습니다.', '1949-06-08', '출판사B', 10),
('죄와 벌','0671723650', 15000, '소설', 2, 1,  '3.jpg', '프레드리히 니체', '범죄와 그에 따른 죄책감을 다룬 소설입니다. 인간 본성, 도덕, 사회 등의 문제를 담고 있으며, 국내외에서 유명한 작품입니다.', '1866-01-01', '출판사C', 10),
('노인과 바다', '0061006629',12000, '소설', 3, 1, '4.jpg', '어니스트 헤밍웨이', '고독하고 가난한 어부와 그의 삶을 다룬 작품입니다. 인내, 희생, 성공 등을 테마로 하며, 단순한 문장과 깊은 의미로 많은 사랑을 받고 있습니다.', '1952-09-01', '출판사D', 15),
('미움받을 용기', '0345391802',16000, '자기계발', 0, 1, '5.jpg', '이치로 카시미', '자신의 가치와 소신을 지키며 도전하는 용기에 대한 이야기를 다룬 자기계발서입니다. 현재 일본을 비롯한 전 세계에서 사랑받고 있습니다.', '2013-01-01', '출판사C', 10),
('어린왕자', '0141439564',9000, '소설', 1, 1,  '6.jpg', '생텍쥐페리', '한 소년과 외계인 어린왕자가 만나 이야기를 나누는 고전적인 동화입니다. 이 책은 다양한 언어로 번역되어 전 세계적으로 사랑받고 있습니다.', '1943-04-06', '출판사B', 5),
('정의란 무엇인가', '0141185032',20000, '인문학', 2, 1,'7.jpg', '마이클 샌델', '공정한 사회를 구축하기 위해 노력하는 데 필요한 가치인 정의에 대해 탐구하는 책입니다. 이 책은 대학 강의의 교재로 사용되기도 합니다.', '2009-09-17', '출판사D', 0),
('수면의 과학', '0394800130',20000, '과학', 3, 1, '8.jpg', '매튜 워커', '잠에 대한 전반적인 내용과 수면의 장점 등에 대해 적은 책입니다. ', '2021-02-10', '한빛미디어', 5),
('호두까기 인형','9780679735770', 12000, '소설', 0, 1, '9.jpg', '에리히 카슨', '마리의 모험을 그린 이야기로, 고전 중의 고전입니다. ', '2020-11-20', '북트리', 10),
('리처드 파인만의 유혹', '9780747532699',18000, '추리소설', 1, 1, '10.jpg', '리처드 파인만', '물리학자 리처드 파인만의 노력과 고민을 그려낸 추리소설입니다.', '2022-01-05', '허브미디어', 0),
('프로그래머가 되는 법', '9780671723651',25000, '컴퓨터', 2, 1, '11.jpg', '폴 그레이엄', '프로그래밍의 기본 원리와 프로그래머가 되기까지의 과정을 설명한 책입니다. ', '2021-12-17', '한빛미디어', 15),
('우리 아이 언어교육', '9780345391803',22000, '육아', 3, 0,  '12.jpg', '이승희', '아이들의 언어 발달을 위한 방법과 효과적인 교육 방법을 제시하는 책입니다. ', '2022-02-28', '한국외국어대학교 출판부', 5),
('떡', '9780141439563',10000, '소설', 0,  0,  '13.jpg', '이석원', '서로를 지켜보며 성장해나가는 떡과 소년의 이야기입니다. 떡 하나로 소년이 겪는 여러가지 이야기를 통해 인간의 성장과 소통의 중요성을 그려냅니다.', '2021-03-15', '출판사A', 10),
('좋은 삶의 기록', '9780141185031',12000, '자기계발', 1,  0,  '14.jpg', '박소연', '작가의 경험과 인생의 지혜를 담은 삶의 기록집입니다. 책은 세 가지 파트로 나누어져 있으며, 각 파트마다 작가의 이야기와 경험, 그리고 그에 따른 지혜와 조언을 담고 있습니다.', '2022-01-05', '출판사B', 15),
('오직 나만을 위한 명상', '9780394800132',15000, '자기계발', 2, 0, '15.jpg', '김민정', '스트레스와 불안을 해소하고 자신을 돌아볼 수 있는 명상의 기술을 담은 책입니다. 명상 초보자도 쉽게 따라할 수 있는 내용으로 구성되어 있습니다.', '2022-02-10', '출판사C', 0),
('마음의 소리', '9780060935467',8000, '만화', 3, 0, '16.jpg', '조석', '10대 청소년들의 이야기를 그린 만화입니다. 현실과 꿈 사이에서 고민하며 성장하는 주인공들의 모습을 통해 진정한 자아를 발견하고 꿈을 향해 나아가는 메시지를 전달합니다.', '2012-03-01', '출판사D', 20)



select * from book;
drop table book;