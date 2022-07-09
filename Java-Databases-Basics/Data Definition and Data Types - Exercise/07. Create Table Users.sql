CREATE TABLE `users`
(
    `id`              BIGINT PRIMARY KEY AUTO_INCREMENT,
    `username`        VARCHAR(30) NOT NULL,
    `password`        VARCHAR(26) NOT NULL,
    `profile_picture` BLOB,
    `last_login_time` TIMESTAMP,
    `is_deleted`      BOOLEAN DEFAULT FALSE
);

INSERT INTO `users` (`username`, `password`)
VALUES ('USER1', 'PASS1'),
       ('USER2', 'PASS2'),
       ('USER3', 'PASS3'),
       ('USER4', 'PASS4'),
       ('USER5', 'PASS5');