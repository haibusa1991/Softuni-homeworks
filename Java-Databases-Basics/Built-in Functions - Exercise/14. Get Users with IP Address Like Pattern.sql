SELECT `user_name`,`ip_address`
FROM users
WHERE `ip_address` REGEXP '^[\\d]{3}\\.1[\\d]*\\..*\\.[\\d]{3}$'
ORDER BY `user_name`