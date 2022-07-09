CREATE SCHEMA mini_orm;
USE mini_orm;

CREATE TABLE users
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    username     VARCHAR(100) NOT NULL,
    password     TEXT NOT NULL,
    age          INT,
    registration DATETIME
);


