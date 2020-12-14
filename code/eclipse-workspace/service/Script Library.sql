-- MySQL Script generated by MySQL Workbench
-- Mon Jun  8 10:00:39 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema library
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema library
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `library` DEFAULT CHARACTER SET utf8 ;
USE `library` ;

-- -----------------------------------------------------
-- Table `library`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`category` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `library`.`copy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`copy` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `item_id` INT(11) NOT NULL,
  `barcode` INT(11) NULL DEFAULT NULL,
  `state` VARCHAR(255) NULL DEFAULT 'available',
  PRIMARY KEY (`id`),
  INDEX `fk_copy_item1_idx` (`item_id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `library`.`type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`type` (
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `library`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`item` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `category_id` INT(11) NOT NULL,
  `type_name` VARCHAR(255) NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `isbn` INT(11) NOT NULL,
  `author` VARCHAR(255) NOT NULL,
  `summary` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_item_category1_idx` (`category_id` ASC),
  INDEX `fk_item_type1_idx` (`type_name` ASC),
  CONSTRAINT `fk_item_category1_idx`
    FOREIGN KEY (`category_id`)
    REFERENCES `library`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_type1_idx`
    FOREIGN KEY (`type_name`)
    REFERENCES `library`.`type` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `library`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`role` (
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `library`.`state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`state` (
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `library`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(255) NOT NULL,
  `role` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `firstname` VARCHAR(255) NOT NULL,
  `lastname` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `tel` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_state_idx` (`state` ASC),
  INDEX `role_user_idx` (`role` ASC),
  CONSTRAINT `role_user`
    FOREIGN KEY (`role`)
    REFERENCES `library`.`role` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `state_user`
    FOREIGN KEY (`state`)
    REFERENCES `library`.`state` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `library`.`loan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`loan` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `copy_id` INT(11) NOT NULL,
  `date_loaned` DATE NOT NULL,
  `return_date` DATE NOT NULL,
  `date_returned` DATE NULL DEFAULT NULL,
  `penality` DECIMAL(10,0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_loan_user1_idx` (`user_id` ASC),
  INDEX `fk_loan_copy1_idx` (`copy_id` ASC),
  CONSTRAINT `fk_loan_copy1`
    FOREIGN KEY (`copy_id`)
    REFERENCES `library`.`copy` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_loan_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `library`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 81
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `library`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`reservation` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `item_id` INT(11) NOT NULL,
  `date_reservation` DATE NULL DEFAULT NULL,
  `state` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reservation_user1_idx` (`user_id` ASC, `item_id` ASC),
  INDEX `fk_reservation_item1_idx` (`item_id` ASC),
  CONSTRAINT `fk_reservation_item1_idx`
    FOREIGN KEY (`item_id`)
    REFERENCES `library`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservation_user1_idx`
    FOREIGN KEY (`user_id`)
    REFERENCES `library`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 40
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
