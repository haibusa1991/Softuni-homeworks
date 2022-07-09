CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(19, 4),
                                           interest_rate DECIMAL(19,4),
                                           number_of_years INT)
    RETURNS DECIMAL(19, 4)
    DETERMINISTIC
BEGIN
    RETURN POW((1 + interest_rate), number_of_years)*sum;
END;