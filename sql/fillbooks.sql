SET FOREIGN_KEY_CHECKS = 0; -- disable a foreign keys check
SET AUTOCOMMIT = 0; -- disable autocommit
START TRANSACTION;

TRUNCATE `books`;

INSERT INTO `library`.`books` (`name`, `author`, `year`, `isAvailable`,`isDeprecated`)
VALUES ('Thinking in Java', 'Bruce Ekkel', '2003', '1','0');

INSERT INTO `library`.`books` (`name`, `author`, `year`, `isAvailable`,`isDeprecated`)
VALUES ('Code Complete', 'Steve Mcconel', '2004', '1','0');

INSERT INTO `library`.`books` (`name`, `author`, `year`, `isAvailable`,`isDeprecated`)
VALUES ('War and Peace', 'Lev Tolstoi', '1983', '1','0');

INSERT INTO `library`.`books` (`name`, `author`, `year`, `isAvailable`,`isDeprecated`)
VALUES ('Atlas Shruggeled', 'Ann Reind', '2007', '1','0');

INSERT INTO `library`.`books` (`name`, `author`, `year`, `isAvailable`,`isDeprecated`)
VALUES ('Head First Java', 'O`reily', '2007', '1','0');

INSERT INTO `library`.`books` (`name`, `author`, `year`, `isAvailable`,`isDeprecated`)
VALUES ('Design Patterns', 'Martin Fowler', '2002', '1','0');

INSERT INTO `library`.`books` (`name`, `author`, `year`, `isAvailable`,`isDeprecated`)
VALUES ('Advanced Java', 'Josh Bloch', '2008', '1','0');

INSERT INTO `library`.`books` (`name`, `author`, `year`, `isAvailable`,`isDeprecated`)
VALUES ('The art of programming', 'Donald Knuth', '1990', '1','0');

INSERT INTO `library`.`books` (`name`, `author`, `year`, `isAvailable`,`isDeprecated`)
VALUES ('Java Foundation', 'Jame Horstmann', '2003', '1','0');

INSERT INTO `library`.`books` (`name`, `author`, `year`, `isAvailable`,`isDeprecated`)
VALUES ('Programming Languages', 'Ken Arnold', '2005', '1','0');

SET FOREIGN_KEY_CHECKS = 1; -- enable a foreign keys check
COMMIT;  -- make a commit
SET AUTOCOMMIT = 1 ;
