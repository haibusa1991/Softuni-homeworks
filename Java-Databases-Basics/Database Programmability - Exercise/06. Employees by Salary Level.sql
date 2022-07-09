CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19, 4))
    RETURNS VARCHAR(7)
    DETERMINISTIC
BEGIN
    DECLARE output VARCHAR(7);
    CASE
        WHEN salary < 30000 THEN SET output = 'Low';
        WHEN salary <= 50000 THEN SET output = 'Average';
        ELSE SET output = 'High';
        END CASE;
    RETURN output;
END;

CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(7))
BEGIN
    SELECT first_name, last_name
    FROM employees AS e
    WHERE salary_level = ufn_get_salary_level(e.salary)
    ORDER BY first_name DESC, last_name DESC;
END;