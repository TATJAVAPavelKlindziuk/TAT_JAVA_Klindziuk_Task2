SET FOREIGN_KEY_CHECKS = 0; -- disable a foreign keys check
SET AUTOCOMMIT = 0; -- disable autocommit
START TRANSACTION;

TRUNCATE `users`;

INSERT INTO `library`.`users` (`login`, `password`, `name`, `isAdmin`,`isBanned`)
VALUES ('harrykane', 'spurs', 'Harry Kane', '0','0');

INSERT INTO `library`.`users` (`login`, `password`, `name`, `isAdmin`,`isBanned`)
VALUES ('smurf', '123', 'Fake Fake', '1','0');

INSERT INTO `library`.`users` (`login`, `password`, `name`, `isAdmin`,`isBanned`)
VALUES ('realman', 'qwerty', 'Andrew Sorkin', '0','0');

INSERT INTO `library`.`users` (`login`, `password`, `name`, `isAdmin`,`isBanned`)
VALUES ('crispy', 'chocolate', 'Sarah Connor', '0','1');

INSERT INTO `library`.`users` (`login`, `password`, `name`, `isAdmin`,`isBanned`)
VALUES ('test1', 'testtest', 'Test User1', '1','0');

INSERT INTO `library`.`users` (`login`, `password`, `name`, `isAdmin`,`isBanned`)
VALUES ('ann', 'pass', 'Ann Corfield', '0','1');

INSERT INTO `library`.`users` (`login`, `password`, `name`, `isAdmin`,`isBanned`)
VALUES ('jimmy', '123456', 'Johny Cage', '0','0');

INSERT INTO `library`.`users` (`login`, `password`, `name`, `isAdmin`,`isBanned`)
VALUES ('max', 'fire', 'Max Payne ', '0','0');

INSERT INTO `library`.`users` (`login`, `password`, `name`, `isAdmin`,`isBanned`)
VALUES ('ivan', 'dsf', 'Ivan Panasiuk', '0','0');

INSERT INTO `library`.`users` (`login`, `password`, `name`, `isAdmin`,`isBanned`)
VALUES ('silva', 'mci', 'David Silva', '1','0');

SET FOREIGN_KEY_CHECKS = 1; -- enable a foreign keys check
COMMIT;  -- make a commit
SET AUTOCOMMIT = 1 ;
