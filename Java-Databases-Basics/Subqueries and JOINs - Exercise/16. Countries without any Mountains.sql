SELECT COUNT(*)
FROM countries AS c
LEFT JOIN mountains_countries AS mc on c.country_code = mc.country_code
WHERE mountain_id IS NULL
