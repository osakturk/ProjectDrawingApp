create table IF NOT EXISTS Permissions(
id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_id bigint NOT NULL,
page_id bigint NOT NULL,
permission int NOT NULL,
FOREIGN KEY (user_id) REFERENCES Users(id),
FOREIGN KEY (page_id) REFERENCES Pages(id),
) ENGINE=MyISAM;