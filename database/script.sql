DROP DATABASE IF EXISTS newswebsite;
CREATE DATABASE newswebsite CHARACTER SET utf8 COLLATE utf8_general_ci;
USE NewsWebsite;

create table role(
	id bigint not null primary key auto_increment,
    name varchar(255) not null,
    code varchar(255) not null,
    createdate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

create table user(
	id bigint not null primary key auto_increment,
    username varchar(255) not null,
    password varchar(150) not null,
    fullname varchar(150) not null,
    status int not null,
    roleid bigint not null,
    createdate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

alter table user add constraint fk_user_role foreign key (roleid) references role(id);

create table news(
	id bigint not null primary key auto_increment,
    title varchar(255) null,
    thumbnail varchar(150) null,
    shortdescription text not null,
    content text not null,	
    categoryid bigint not null,
    createdate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

create table category(
	id bigint not null primary key auto_increment,
    name varchar(255) null,
    code varchar(255) not null,
    createdate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
);

alter table news add constraint fk_news_category foreign key (categoryid) references category(id);

create table comment(
	id bigint not null primary key auto_increment,
    content text not null,
    userid bigint not null,
    newsid bigint not null,
    code varchar(255) not null,
    createdate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

alter table comment add constraint fk_comment_user foreign key (userid) references user(id);
alter table comment add constraint fk_comment_news foreign key (newsid) references news(id);

insert into category(code, name) values ('the-thao', 'Thể thao');
insert into category(code, name) values ('the-gioi', 'Thế giới');
insert into category(code, name) values ('chinh-tri', 'Chính trị');
insert into category(code, name) values ('thoi-su', 'Thời sự');
insert into category(code, name) values ('goc-nhin', 'Góc nhìn');

insert into news(title, shortdescription, content, categoryid) values ('Bai viet 1', "Day la mot bai viet" ,"Noi dung ne",1);
insert into news(title, shortdescription, content, categoryid) values ('Bai viet 2', "Day la mot bai viet" ,"Noi dung ne",1);
insert into news(title, shortdescription, content, categoryid) values ('Bai viet 3', "Day la mot bai viet" ,"Noi dung ne",2);
