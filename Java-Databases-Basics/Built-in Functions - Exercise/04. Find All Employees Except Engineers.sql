SELECT `first_name`, `last_name`
FROM `employees`
WHERE LOCATE('ENGINEER', `job_title`) = 0
ORDER BY `employee_id`