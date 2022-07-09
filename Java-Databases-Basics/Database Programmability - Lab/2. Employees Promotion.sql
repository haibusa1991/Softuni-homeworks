CREATE PROCEDURE usp_raise_salaries(IN department_name varchar(100))
UPDATE employees
    JOIN departments AS d on employees.department_id = d.department_id
SET salary = salary * 1.05
WHERE d.name = department_name;

