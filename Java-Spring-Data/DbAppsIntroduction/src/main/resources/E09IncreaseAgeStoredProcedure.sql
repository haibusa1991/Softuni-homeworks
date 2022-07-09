use minions_db;
CREATE PROCEDURE usp_get_older(minion_id INT)
BEGIN
    UPDATE minions_db.minions AS m
    SET m.age = m.age + 1
    WHERE m.id = minion_id;
END;