CREATE PROCEDURE usp_raise_salary_by_id(target_id INT)
BEGIN
    START TRANSACTION;
    IF ((SELECT employee_id FROM employees WHERE employee_id = target_id) IS NULL) THEN
        ROLLBACK;
    ELSE
        UPDATE employees
        SET salary = salary * 1.05
        WHERE employee_id = target_id;
    END IF;
END

