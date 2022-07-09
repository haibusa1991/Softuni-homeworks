SELECT `first_name`, `last_name`, `department_id`
FROM employees AS `E1`
WHERE `salary` > (SELECT AVG(`salary`) AS 'AVERAGE'
                  FROM `employees` AS `E2`
                  WHERE E1.department_id = E2.department_id
                  GROUP BY `department_id`)
ORDER BY `department_id`, `employee_id`
LIMIT 10