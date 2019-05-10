create table IF NOT EXISTS Sensors(
id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
name varchar(255) not null,
description varchar(255),
x_location float(7,4) NOT NULL,
y_location float(7,4) NOT NULL,
type int NOT NULL,
project_id NOT NULL,
FOREIGN KEY (project_id) REFERENCES Projects(id)
ON UPDATE CASCADE
ON DELETE RESTRICT
) ENGINE=MyISAM;