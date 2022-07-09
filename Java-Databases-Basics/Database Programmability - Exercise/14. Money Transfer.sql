CREATE PROCEDURE usp_transfer_money(from_account_id INT,
                                    to_account_id INT,
                                    amount DECIMAL(19, 4))
current_procedure:
BEGIN
    DECLARE is_from_account_null INT;
    DECLARE is_to_account_null INT;

    SET is_from_account_null = (SELECT id
                                FROM accounts
                                WHERE id = from_account_id);

    SET is_to_account_null = (SELECT id
                              FROM accounts
                              WHERE id = to_account_id);

    IF from_account_id = to_account_id
        OR amount < 0
        OR is_from_account_null IS NULL
        OR is_to_account_null IS NULL THEN
        LEAVE current_procedure;
    END IF;

    START TRANSACTION;
    UPDATE accounts
    SET balance = balance + amount
    WHERE id = to_account_id;

    UPDATE accounts
    SET balance=balance - amount
    WHERE id = from_account_id;

    IF (SELECT balance FROM accounts WHERE id = from_account_id) < 0 THEN
        ROLLBACK;
    END IF;
END;