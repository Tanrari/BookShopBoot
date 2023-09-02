create  TABLE  authors(
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(250) not null
);

CREATE TABLE books(
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      author_id INT NOT NULL,
                      title VARCHAR(250) NOT NULL,
                      price_Old VARCHAR(250) DEFAULT NULL,
                      price VARCHAR(250) DEFAULT NULL,
                      FOREIGN KEY (author_id) REFERENCES authors(id) on DELETE CASCADE
);

