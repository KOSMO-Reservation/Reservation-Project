CREATE TABLE `users` (
	`userNo` INT NOT NULL AUTO_INCREMENT,
	`userName` VARCHAR(100) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	`userEmail` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	`userPw` VARCHAR(255) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	`userPhone` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	PRIMARY KEY (`userNo`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
AUTO_INCREMENT=4
;