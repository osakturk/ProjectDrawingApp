create table IF NOT EXISTS Users(
id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
name varchar(255) not null,
group int not null,
email varchar(255) not null,
password varchar(255) not null,
phone_1 varchar(50) not null,
phone_2 varchar(50),
created_time datetime NOT NULL default NOW(),
last_online datetime NOT NULL DEFAULT NOW(),
status bool NOT NULL
parent_user bigint,
salt varchar(255) NOT NULL
) ENGINE=MyISAM;