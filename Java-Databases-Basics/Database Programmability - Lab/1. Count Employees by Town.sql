CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(50))
    RETURNS INT
    DETERMINISTIC
BEGIN
    RETURN (SELECT COUNT(*)
            FROM employees
                     JOIN addresses AS a on employees.address_id = a.address_id
                     JOIN towns AS t ON a.town_id = t.town_id
            WHERE t.name = town_name);
END