CREATE TABLE `categories`
(
    `id`           INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    `category`     VARCHAR(50)     NOT NULL,
    `daily_rate`   DOUBLE(6, 2),
    `weekly_rate`  DOUBLE(6, 2),
    `monthly_rate` DOUBLE(6, 2),
    `weekend_rate` DOUBLE(6, 2)
);

INSERT INTO categories(`category`)
VALUES ('catagory 1'),
       ('catagory 2'),
       ('catagory 3');

CREATE TABLE `cars`
(
    `id`            INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    `plate_number`  VARCHAR(20)     NOT NULL,
    `make`          VARCHAR(50)     NOT NULL,
    `model`         VARCHAR(50)     NOT NULL,
    `car_year`      INT,
    `category_id`   INT,
    `doors`         INT,
    `picture`       BLOB,
    `car_condition` VARCHAR(30),
    `available`     BOOLEAN         NOT NULL DEFAULT TRUE
);

INSERT INTO `cars` (`plate_number`, `make`, `model`)
VALUES ('PLATE 1', 'MAKE 1', 'MODEL 1'),
       ('PLATE 2', 'MAKE 2', 'MODEL 2'),
       ('PLATE 3', 'MAKE 3', 'MODEL 3');

CREATE TABLE `employees`
(
    `id`         INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    `first_name` VARCHAR(50)     NOT NULL,
    `last_name`  VARCHAR(50)     NOT NULL,
    `title`      VARCHAR(50),
    `notes`      TEXT
);

INSERT INTO `employees` (`first_name`, `last_name`)
VALUES ('NAME 1', 'LAST NAME 1'),
       ('NAME 2', 'LAST NAME 2'),
       ('NAME 3', 'LAST NAME 3');


CREATE TABLE `customers`
(
    `id`                    INT PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,
    `driver_licence_number` VARCHAR(20)                           NOT NULL,
    `full_name`             VARCHAR(100)                          NOT NULL,
    `address`               VARCHAR(100),
    `city`                  VARCHAR(50),
    `zip_code`              VARCHAR(6),
    `notes`                 TEXT
);

INSERT INTO `customers` (driver_licence_number, full_name)
VALUES ('1234567891', 'IVAN1 IVANOV IVANOV'),
       ('1234567892', 'IVAN2 IVANOV IVANOV'),
       ('1234567893', 'IVAN3 IVANOV IVANOV');

CREATE TABLE `rental_orders`
(
    `id`                INT PRIMARY KEY UNIQUE AUTO_INCREMENT NOT NULL,
    `employee_id`       INT                                   NOT NULL,
    `customer_id`       INT                                   NOT NULL,
    `car_id`            INT                                   NOT NULL,
    `car_condition`     VARCHAR(30),
    `tank_level`        VARCHAR(20),
    `kilometrage_start` INT(7)                                NOT NULL,
    `kilometrage_end`   INT(7)                                NOT NULL,
    `total_kilometrage` INT(7),
    `start_date`        DATE                                  NOT NULL,
    `end_date`          DATE                                  NOT NULL,
    `total_days`        INT,
    `rate_applied`      DOUBLE(6, 2)                          NOT NULL,
    `tax_rate`          DOUBLE(4, 2),
    `order_status`      VARCHAR(20),
    `notes`             TEXT
);

INSERT INTO `rental_orders`(employee_id,
                            customer_id,
                            car_id,
                            kilometrage_start,
                            kilometrage_end,
                            start_date,
                            end_date, rate_applied)
VALUES (1, 1, 1, '1234561', '234561', '2021-01-01', '2022-11-01', '21.55'),
       (2, 2, 2, '1234562', '234562', '2021-01-02', '2022-11-02', '22.55'),
       (3, 3, 3, '1234563', '234563', '2021-01-03', '2022-11-03', '23.55');

