CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    START TRANSACTION;
    UPDATE accounts
    SET balance = balance - money_amount
    WHERE id = account_id;

    IF (money_amount < 0) OR (SELECT balance FROM accounts WHERE id = account_id) - money_amount < 0 THEN
        ROLLBACK;
    END IF;
END;