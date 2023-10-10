create table users(
    id int(10) not null auto_increment primary key,
    userid varchar(100) not null ,
    name varchar(100) not null ,
    gender varchar(10),
    city varchar(100)
);

alter table users add unique index users_userid_idx(userid);

show index from users;

insert into users(userid,name,gender,city) values ('gildong','홍길동','남','서울');
commit;

insert into users(userid,name,gender,city) values ('dooly','둘리','여','부산');
commit;

create table customer(
	id int(10) not null auto_increment primary key,
	name varchar(100) not null,
	email varchar(100) not null,
	age int(10),
	addr varchar(100),
	entryDate date DEFAULT NOW()
);

alter table customer add unique index custoemer_email_idx(email);

insert into customer(name,email,age,addr) values ('둘리','dooly111@gmail.com',28,'경기도 수원시');
commit;