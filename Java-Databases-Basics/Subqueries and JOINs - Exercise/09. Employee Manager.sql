SELECT e.employee_id, e.first_name, e.manager_id, m.first_name
FROM employees AS e
         JOIN employees AS m
WHERE e.manager_id IN (3, 7) AND e.manager_id=m.employee_id
ORDER BY e.first_name;


