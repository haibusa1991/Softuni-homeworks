SELECT COUNT(`employee_id`) AS 'count'
FROM `employees`
WHERE `salary` > (SELECT AVG(`salary`) FROM `employees`)