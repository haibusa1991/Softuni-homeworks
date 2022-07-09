SELECT c.country_name,
       MAX(p.elevation) AS highest_peak_elevation,
       MAX(r.length)    AS longest_river_length
FROM countries AS c
         LEFT JOIN mountains_countries AS mc on c.country_code = mc.country_code
         LEFT JOIN mountains AS m on mc.mountain_id = m.id
         LEFT JOIN peaks AS p on m.id = p.mountain_id
         LEFT JOIN countries_rivers AS cr ON c.country_code = cr.country_code
         LEFT JOIN rivers AS r on cr.river_id = r.id
GROUP BY c.country_name
ORDER BY highest_peak_elevation DESC,
         longest_river_length DESC,
         country_name
LIMIT 5;