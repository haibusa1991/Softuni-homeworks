CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
    RETURNS BIT
    DETERMINISTIC
BEGIN
    DECLARE iterator INT;
    DECLARE current_letter CHAR;
    SET iterator = 1;
    WHILE iterator <= CHAR_LENGTH(word)
        DO
            SET current_letter = SUBSTR(word, iterator,1);
            IF (INSTR(set_of_letters, current_letter)) = 0 THEN
                RETURN 0;
            END IF;
            SET iterator = iterator+1;
        END WHILE;
    RETURN 1;
END;