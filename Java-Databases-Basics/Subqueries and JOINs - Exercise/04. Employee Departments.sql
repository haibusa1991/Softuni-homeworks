SELECT employee_id, first_name, salary, d.name
FROM employees AS e
         JOIN departments AS d ON e.department_id = d.department_id
WHERE e.salary > 15000
ORDER BY d.department_id DESC 
LIMIT 5