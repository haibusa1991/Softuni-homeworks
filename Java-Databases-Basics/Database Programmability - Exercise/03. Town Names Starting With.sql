CREATE PROCEDURE usp_get_towns_starting_with(name VARCHAR(50))
BEGIN
    SELECT t.name
    FROM towns AS t
    WHERE t.name LIKE CONCAT(name, '%')
    ORDER BY t.name;
END;