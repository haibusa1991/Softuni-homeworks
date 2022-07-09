CREATE PROCEDURE usp_get_employees_salary_above(salary DECIMAL(19, 4))
BEGIN
    SELECT first_name, last_name
    FROM employees AS e
    WHERE e.salary >= salary
    ORDER BY first_name, last_name, employee_id;
END;