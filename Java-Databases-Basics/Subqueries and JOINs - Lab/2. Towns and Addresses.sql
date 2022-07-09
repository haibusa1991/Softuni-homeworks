SELECT `t`.`town_id`, `t`.`name`, `a`.`address_text`
FROM `towns` AS `t`
         LEFT JOIN `addresses` AS `a` ON `t`.`town_id` = `a`.`town_id`
WHERE `t`.`name` IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY `town_id`,`address_id`