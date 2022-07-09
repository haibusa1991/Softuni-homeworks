
CREATE TABLE `passports`
(
    `passport_id`     INT PRIMARY KEY AUTO_INCREMENT UNIQUE NOT NULL,
    `passport_number` VARCHAR(10) UNIQUE
) AUTO_INCREMENT = 101;

CREATE TABLE `people`
(
    `person_id`   INT PRIMARY KEY AUTO_INCREMENT UNIQUE NOT NULL,
    `first_name`  VARCHAR(50)                           NOT NULL,
    `salary`      DECIMAL(10, 2)                        NOT NULL DEFAULT 0,
    `passport_id` INT                                   NOT NULL UNIQUE,
    CONSTRAINT
        FOREIGN KEY (passport_id)
            REFERENCES `passports` (`passport_id`)

);

INSERT INTO passports(passport_number)
VALUES ('N34FG21B'),
       ('K65LO4R7'),
       ('ZE657QP2');
INSERT INTO people (FIRST_NAME, SALARY, PASSPORT_ID)
VALUES ('Roberto', 43300.00, 102),
       ('Tom', 56100.00, 103),
       ('Yana', 60200.00, 101);
