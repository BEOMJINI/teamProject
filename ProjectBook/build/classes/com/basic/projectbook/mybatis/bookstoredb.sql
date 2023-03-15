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


INSERT INTO member (name, id, pw, email, phone, genre, address) VALUES
('qwer', 1, 3, 'a@a.com','010-1111-1111', '추리', '경기도'),
('test', 2, 3, 'a@a.com','010-1111-1111', '추리', '경기도'),
('관리자', 'admin', 'admin', 'admin@admin.com','010-1111-1111', '관리자', '관리자');

select * from member;
delete from member;
drop table member;

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
/*
store1 int not null,	
store2 int not null,
store3 int not null,
*/
);

INSERT INTO book (name, price, genre, qty, country, sale, img, writer, info, publication, company, discount) VALUES
('test1', 1000, '추리', '3', 0, 10, '', '작가1'),
('test2', 2000, '로맨스', '3', 1, 20, '', '작가2');
INSERT INTO book (name, price, genre, qty, country, sale, img, writer, info, publication, company, discount)
VALUES
('The Great Gatsby', 20000, 'Fiction', 50, 1, 20, 'thegreatgatsby.jpg', 'F. Scott Fitzgerald', 'The Great Gatsby is a novel by American author F. Scott Fitzgerald. First published in 1925, it is set on Long Island\'s North Shore and in New York City from spring to autumn of 1922. The novel takes place following the First World War.', '1925-04-10', 'Scribner', 5),
('To Kill a Mockingbird', 15000, 'Fiction', 75, 1, 15, 'tokillamockingbird.jpg', 'Harper Lee', 'To Kill a Mockingbird is a novel by Harper Lee published in 1960. It was immediately successful, winning the Pulitzer Prize, and has become a classic of modern American literature. The plot and characters are loosely based on the author\'s observations of her family, her neighbors and an event that occurred near her hometown of Monroeville, Alabama, in 1936, when she was 10 years old.', '1960-07-11', 'J. B. Lippincott & Co.', 10),
('1984', 18000, 'Fiction', 100, 1, 25, '1984.jpg', 'George Orwell', '1984 is a dystopian novella by George Orwell published in 1949, which follows the life of Winston Smith, a low ranking member of "the Party", who is frustrated by the omnipresent eyes of the party, and its ominous ruler Big Brother.', '1949-06-08', 'Secker & Warburg', 15),
('The Catcher in the Rye', 17000, 'Fiction', 60, 0, 10, 'thecatcherintherye.jpg', 'J. D. Salinger', 'The Catcher in the Rye is a novel by J. D. Salinger, partially published in serial form in 1945–1946 and as a novel in 1951. It was originally intended for adults but is often read by adolescents for its themes of angst, alienation, and as a critique on superficiality in society.', '1951-07-16', 'Little, Brown and Company', 0),
('Pride and Prejudice', 12000, 'Fiction', 90, 0, 20, 'prideandprejudice.jpg', 'Jane Austen', 'Pride and Prejudice is a romantic novel of manners written by Jane Austen in 1813. The novel follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness.', '1813-01-28', 'T. Egerton, Whitehall', 20);



select * from book;
drop table book;