SELECT CONCAT_WS(' ',`first_name`,last_name) AS 'Full Name',
       (TO_DAYS(`died`) - TO_DAYS(`born`)) AS 'Days Lived'
FROM `authors`

