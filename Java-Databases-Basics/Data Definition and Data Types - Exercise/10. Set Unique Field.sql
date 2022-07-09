ALTER TABLE `users`
    DROP PRIMARY KEY,
    ADD PRIMARY KEY (`id`),
    ADD CONSTRAINT `pk_unique`
        UNIQUE (`username`);

