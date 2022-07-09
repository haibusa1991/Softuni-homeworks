CREATE TABLE logs
(
    log_id     INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    old_sum    DECIMAL(19, 4),
    new_sum    DECIMAL(19, 4)
);

CREATE TRIGGER log_account_balance_change
    AFTER UPDATE
    ON accounts
    FOR EACH ROW
BEGIN
    INSERT INTO logs (account_id, old_sum, new_sum)
    VALUES (OLD.id, OLD.balance, NEW.balance);
END;