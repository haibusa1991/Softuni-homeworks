CREATE TABLE `people`
(
    `id`        INT PRIMARY KEY AUTO_INCREMENT,
    `name`      VARCHAR(200) NOT NULL ,
    `picture`   BLOB,
    `height`    DOUBLE(3, 2),
    `weight`    DOUBLE(5, 2),
    `gender`    VARCHAR(1) NOT NULL,
    `birthdate` DATE       NOT NULL,
    `biography` TEXT
);

INSERT INTO `people` (`name`, `gender`,birthdate) VALUES
('IVAN1','M',NOW()),
('IVAN2','M',NOW()),
('IVAN3','F',NOW()),
('IVAN4','F',NOW()),
('IVAN5','M',NOW());