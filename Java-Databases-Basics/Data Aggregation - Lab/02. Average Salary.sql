SELECT `department_id`, ROUND(AVG(`salary`),2)
FROM `employees`
GROUP BY `department_id`
