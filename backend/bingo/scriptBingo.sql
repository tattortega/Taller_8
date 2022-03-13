-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bingo2` DEFAULT CHARACTER SET utf8 ;
USE `bingo2` ;

-- -----------------------------------------------------
-- Table `mydb`.`game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `game` (
                                      `game_id` INT NOT NULL AUTO_INCREMENT,
                                      `game_winner` VARCHAR(45) NULL,
                                      `game_status` TINYINT NOT NULL,
                                      `game_created_at` DATETIME NOT NULL,
                                      PRIMARY KEY (`game_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `card` (
                                      `card_id` INT NOT NULL AUTO_INCREMENT,
                                      `game_game_id` INT NOT NULL,
                                      `card_row` INT NOT NULL,
                                      `card_column` INT NOT NULL,
                                      PRIMARY KEY (`card_id`),
                                      INDEX `fk_card_game2_idx` (`game_game_id` ASC) VISIBLE,
                                      CONSTRAINT `fk_card_game2`
                                          FOREIGN KEY (`game_game_id`)
                                              REFERENCES `game` (`game_id`)
                                              ON DELETE NO ACTION
                                              ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ballot`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ballot` (
                                        `ballot_id` INT NOT NULL AUTO_INCREMENT,
                                        `ballot_number` INT NULL,
                                        PRIMARY KEY (`ballot_id`),
                                        UNIQUE INDEX `ballot_number_UNIQUE` (`ballot_number` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user` (
                                      `user_id` INT NOT NULL AUTO_INCREMENT,
                                      `user_name` VARCHAR(45) NOT NULL,
                                      PRIMARY KEY (`user_id`),
                                      UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`card_has_ballot`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `card_has_ballot` (
                                                 `card_card_id` INT NOT NULL,
                                                 `ballot_ballot_id` INT NOT NULL,
                                                 INDEX `fk_card_has_ballot_ballot1_idx` (`ballot_ballot_id` ASC) VISIBLE,
                                                 INDEX `fk_card_has_ballot_card1_idx` (`card_card_id` ASC) VISIBLE,
                                                 PRIMARY KEY (`card_card_id`, `ballot_ballot_id`),
                                                 CONSTRAINT `fk_card_has_ballot_card1`
                                                     FOREIGN KEY (`card_card_id`)
                                                         REFERENCES `card` (`card_id`)
                                                         ON DELETE NO ACTION
                                                         ON UPDATE NO ACTION,
                                                 CONSTRAINT `fk_card_has_ballot_ballot1`
                                                     FOREIGN KEY (`ballot_ballot_id`)
                                                         REFERENCES `ballot` (`ballot_id`)
                                                         ON DELETE NO ACTION
                                                         ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user_has_game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_has_game` (
                                               `user_user_id` INT NOT NULL,
                                               `game_game_id` INT NOT NULL,
                                               PRIMARY KEY (`user_user_id`, `game_game_id`),
                                               INDEX `fk_user_has_game_game1_idx` (`game_game_id` ASC) VISIBLE,
                                               INDEX `fk_user_has_game_user1_idx` (`user_user_id` ASC) VISIBLE,
                                               CONSTRAINT `fk_user_has_game_user1`
                                                   FOREIGN KEY (`user_user_id`)
                                                       REFERENCES `user` (`user_id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION,
                                               CONSTRAINT `fk_user_has_game_game1`
                                                   FOREIGN KEY (`game_game_id`)
                                                       REFERENCES `game` (`game_id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION)
    ENGINE = InnoDB;

