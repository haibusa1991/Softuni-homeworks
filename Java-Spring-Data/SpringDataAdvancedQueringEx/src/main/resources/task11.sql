CREATE FUNCTION udf_get_book_count_by_author(first_name VARCHAR(255), last_name VARCHAR(255))
    RETURNS INT
    DETERMINISTIC
BEGIN
    RETURN (SELECT COUNT(*)
            FROM books b
                     JOIN authors a on a.id = b.author_id
            WHERE a.first_name = first_name
              AND a.last_name = last_name);
END;