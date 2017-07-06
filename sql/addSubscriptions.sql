/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 12.0 		*/
/*  Created On : 08-Aug-2016 20:18:41 				*/
/*  DBMS       : MySql 						*/
/* ---------------------------------------------------- */

SET FOREIGN_KEY_CHECKS=0 ;

/* Drop Tables */

DROP TABLE IF EXISTS `subscriptions` CASCADE
;


CREATE TABLE `subscriptions`
(
	`sb_id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
	`sb_user` INTEGER UNSIGNED NOT NULL,
	`sb_book` INTEGER UNSIGNED NOT NULL,
	`sb_start` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`sb_finish` DATETIME NOT NULL,
	`sb_is_active` TINYINT(1) NOT NULL,
	CONSTRAINT `PK_subscriptions` PRIMARY KEY (`sb_id`)
)

;

/* Create Foreign Key Constraints */

ALTER TABLE `subscriptions` 
 ADD CONSTRAINT `FK_subscriptions_books`
	FOREIGN KEY (`sb_book`) REFERENCES `books` (`id`) ON DELETE Cascade ON UPDATE Cascade
;

ALTER TABLE `subscriptions` 
 ADD CONSTRAINT `FK_subscriptions_users`
	FOREIGN KEY (`sb_user`) REFERENCES `users` (`id`) ON DELETE Cascade ON UPDATE Cascade
;


SET FOREIGN_KEY_CHECKS=1 ;