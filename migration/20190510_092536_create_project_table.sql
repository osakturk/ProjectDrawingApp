create table IF NOT EXISTS Projects(
id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
name varchar(255) not null,
description varchar(255),
status bool not null,
created_time datetime NOT NULL default NOW(),
plan_image blob NOT NULL default empty_blob()
) ENGINE=MyISAM;