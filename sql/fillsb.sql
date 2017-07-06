SET FOREIGN_KEY_CHECKS = 0; -- disable a foreign keys check
SET AUTOCOMMIT = 0; -- disable autocommit
START TRANSACTION;

TRUNCATE `subscriptions`;

INSERT INTO `library`.`subscriptions` (`sb_user`, `sb_book`, `sb_is_active`)
VALUES ('2', '1', '1');

INSERT INTO `library`.`subscriptions` (`sb_user`, `sb_book`, `sb_is_active`)
VALUES ('3', '5', '1');

INSERT INTO `library`.`subscriptions` (`sb_user`, `sb_book`, `sb_is_active`)
VALUES ('8', '2', '1');

INSERT INTO `library`.`subscriptions` (`sb_user`, `sb_book`, `sb_is_active`)
VALUES ('6', '7', '1');

INSERT INTO `library`.`subscriptions` (`sb_user`, `sb_book`, `sb_is_active`)
VALUES ('5', '4', '1');

INSERT INTO `library`.`subscriptions` (`sb_user`, `sb_book`, `sb_is_active`)
VALUES ('7', '9', '1');

SET FOREIGN_KEY_CHECKS = 1; -- enable a foreign keys check
COMMIT;  -- make a commit
SET AUTOCOMMIT = 1 ;
