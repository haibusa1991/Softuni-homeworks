SELECT `name`,
       CASE
           WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN 'Morning'
           WHEN HOUR(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
           ELSE 'Evening'
           END AS 'Part of the Day',
       CASE
           WHEN `duration` <= 3 THEN 'Extra Short'
           WHEN `duration` <= 6 THEN 'Short'
           WHEN `duration` <= 10 THEN 'Long'
           ELSE 'Extra Long'
           END
FROM games