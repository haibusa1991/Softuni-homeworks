ALTER TABLE `minions`
ADD COLUMN `town_id` INT;

ALTER TABLE `minions`
ADD CONSTRAINT `fk_minions_towns`
FOREIGN KEY( `town_id`)
REFERENCES `towns` (`id`);


