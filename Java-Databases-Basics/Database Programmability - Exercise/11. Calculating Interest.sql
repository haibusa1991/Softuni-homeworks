CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(19, 4),
                                           interest_rate DECIMAL(19, 4),
                                           number_of_years INT)
    RETURNS DECIMAL(19, 4)
    DETERMINISTIC
BEGIN
    RETURN POW((1 + interest_rate), number_of_years) * sum;
END;

CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT,
                                                        interest_rate DECIMAL(19, 4))
BEGIN
    SELECT a.id      AS 'account_id',
           ah.first_name,
           ah.last_name,
           a.balance AS 'current_balance',
           ufn_calculate_future_value(a.balance, interest_rate, 5)
    FROM accounts AS a
             JOIN account_holders ah on ah.id = a.account_holder_id
    WHERE a.id = account_id;
END;