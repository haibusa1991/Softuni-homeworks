CREATE TABLE Mountains
(
    `id`   INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE Peaks
(
    `id`          INT PRIMARY KEY AUTO_INCREMENT,
    `name`        VARCHAR(50),
    `mountain_id` INT,
    CONSTRAINT  fk_peaks_mountains
        FOREIGN KEY (`mountain_id`)
            REFERENCES `Mountains` (`id`)
);