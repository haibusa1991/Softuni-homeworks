CREATE TABLE `directors`
(
    `id`            INT PRIMARY KEY AUTO_INCREMENT,
    `director_name` VARCHAR(50) NOT NULL,
    `notes`         TEXT
);

CREATE TABLE `genres`
(
    `id`         INT PRIMARY KEY AUTO_INCREMENT,
    `genre_name` VARCHAR(50) NOT NULL,
    `notes`      TEXT
);

CREATE TABLE `categories`
(
    `id`            INT PRIMARY KEY AUTO_INCREMENT,
    `category_name` VARCHAR(50) NOT NULL,
    `notes`         TEXT
);

CREATE TABLE `movies`
(
    `id`             INT PRIMARY KEY AUTO_INCREMENT,
    `title`          VARCHAR(50) NOT NULL,
    `director_id`    INT,
    `copyright_year` DATE,
    `length`         TIME,
    `genre_id`       INT,
    `category_id`    INT,
    `rating`         DOUBLE(2, 1),
    `notes`          TEXT
);

INSERT INTO `directors` (director_name)
VALUES ('director 1'),
       ('director 2'),
       ('director 3'),
       ('director 4'),
       ('director 5');

INSERT INTO `genres` (genre_name)
VALUES ('genre 1'),
       ('genre 2'),
       ('genre 3'),
       ('genre 4'),
       ('genre 5');

INSERT INTO `categories` (`category_name`)
VALUES ('category 1'),
       ('category 2'),
       ('category 3'),
       ('category 4'),
       ('category 5');


INSERT INTO `movies` (`title`)
VALUES ('title 1'),
       ('title 2'),
       ('title 3'),
       ('title 4'),
       ('title 5');