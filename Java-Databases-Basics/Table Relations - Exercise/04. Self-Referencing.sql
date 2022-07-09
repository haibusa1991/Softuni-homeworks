CREATE TABLE `teachers`
(
    `teacher_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name`       VARCHAR(50),
    `manager_id` INT
) AUTO_INCREMENT = 101;

INSERT INTO `teachers` (`name`, `manager_id`)
VALUES ('John', NULL),
       ('Maya', 106),
       ('Silvia', 106),
       ('Ted', 105),
       ('Mark', 101),
       ('Greta', 101);

ALTER TABLE `teachers`
    ADD CONSTRAINT
        FOREIGN KEY (`manager_id`)
            REFERENCES `teachers` (`teacher_id`);
