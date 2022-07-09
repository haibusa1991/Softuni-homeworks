SELECT AVG(`salary`) AS min_average_salary
FROM employees AS e
JOIN departments d on e.department_id = d.department_id
GROUP BY d.name
ORDER BY min_average_salary
LIMIT 1


