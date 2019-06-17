create database BBS;

use BBS;

create table USER(
     userID varchar(20),
     userPassword varchar(20),
     userName varchar(20),
     userGender varchar(20),
     userEmail varchar(50),
     primary key(userID)
     );

show tables;

desc user;

insert into user values('kim','1234','±è','³²ÀÚ','kim@kim.com');

select * from user;

use bbs;

create table bbs(
bbsID int,
bbsTitle varchar(50),
userID varchar(20),
bbsDate datetime,
bbsContent varchar(2048),
bbsAvailable int,
primary key (bbsID)
);

select * from bbs;