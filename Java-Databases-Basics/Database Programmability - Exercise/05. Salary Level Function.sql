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