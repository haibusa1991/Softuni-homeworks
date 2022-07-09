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

CREATE TABLE notification_emails
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    recipient VARCHAR(50),
    subject   VARCHAR(255),
    body      TEXT
);

CREATE TRIGGER notification_email_on_log
    AFTER INSERT
    ON logs
    FOR EACH ROW
BEGIN
    INSERT INTO notification_emails (recipient, subject, body)
    VALUES (NEW.account_id,
            CONCAT('Balance change for account: ', NEW.account_id),
            CONCAT('On ',
                   DATE_FORMAT(NOW(), '%b %c %Y at %r'),
                   ' your balance was changed from ',
                   NEW.old_sum,
                   ' to ',
                   NEW.new_sum,
                   '.'));
END;
