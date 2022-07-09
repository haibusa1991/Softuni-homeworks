CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
    SELECT CONCAT(first_name, ' ', last_name) AS 'full_name'
    FROM account_holders AS ah
    ORDER BY full_name, id;
END;