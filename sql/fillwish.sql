SET FOREIGN_KEY_CHECKS = 0; -- disable a foreign keys check
SET AUTOCOMMIT = 0; -- disable autocommit
START TRANSACTION;

TRUNCATE `wishes`;

INSERT INTO `library`.`wishes` (`w_user`, `w_book`)
VALUES ('2', '2');

INSERT INTO `library`.`wishes` (`w_user`, `w_book`)
VALUES ('2', '4');

INSERT INTO `library`.`wishes` (`w_user`, `w_book`)
VALUES ('4', '1');

INSERT INTO `library`.`wishes` (`w_user`, `w_book`)
VALUES ('4', '9');

INSERT INTO `library`.`wishes` (`w_user`, `w_book`)
VALUES ('8', '3');

INSERT INTO `library`.`wishes` (`w_user`, `w_book`)
VALUES ('6', '7');

SET FOREIGN_KEY_CHECKS = 1; -- enable a foreign keys check
COMMIT;  -- make a commit
SET AUTOCOMMIT = 1 ;
