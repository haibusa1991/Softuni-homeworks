CREATE TABLE `employees`
(
    `id`         INT AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(50),
    `last_name`  VARCHAR(50)
);

CREATE TABLE `categories`
(
    `id`   INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `products`
(
    `id`          INT PRIMARY KEY AUTO_INCREMENT,
    `name`        VARCHAR(50) NOT NULL,
    `category_id` INT
);
