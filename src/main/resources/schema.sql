DROP TABLE IF EXISTS books;

CREATE TABLE books(
id INT AUTO_INCREMENT PRIMARY KEY,
author_id VARCHAR(250) NOT NULL,
title VARCHAR(250) NOT NULL,
price_Old VARCHAR(250) DEFAULT NULL,
price VARCHAR(250) DEFAULT NULL
);


create  TABLE  authors(
 id INT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(250) not null
 )