-- -----------------------------------------------------
-- Schema bingo_game
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS bingo_game DEFAULT CHARACTER SET utf8 ;
USE bingo_game ;

-- -----------------------------------------------------
-- Table card_bingo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS card_bingo (
    card_id INT NOT NULL AUTO_INCREMENT,
    card_ballot INT NULL,
    PRIMARY KEY (card_id))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table game_bingo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS game_bingo (
    game_id INT NOT NULL AUTO_INCREMENT,
    game_status TINYINT NULL,
    game_created_at DATETIME NULL,
    game_winner VARCHAR(45) NULL,
    game_ballot INT NULL,
    PRIMARY KEY (game_id))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table player_bingo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS player_bingo (
    player_id INT NOT NULL AUTO_INCREMENT,
    game_bingo_game_id INT NOT NULL,
    card_bingo_card_id INT NOT NULL,
    player_name VARCHAR(45) NOT NULL,
    player_status TINYINT NULL,
    PRIMARY KEY (player_id),
    INDEX fk_player_bingo_card_bingo1_idx (card_bingo_card_id ASC) VISIBLE,
    INDEX fk_player_bingo_game_bingo1_idx (game_bingo_game_id ASC) VISIBLE,
    CONSTRAINT fk_player_bingo_card_bingo1
    FOREIGN KEY (card_bingo_card_id)
    REFERENCES card_bingo (card_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT fk_player_bingo_game_bingo1
    FOREIGN KEY (game_bingo_game_id)
    REFERENCES game_bingo (game_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

