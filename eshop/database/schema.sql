
CREATE SCHEMA IF NOT EXISTS `railway` DEFAULT CHARACTER SET latin1 ;


USE `railway` ;


CREATE TABLE IF NOT EXISTS `railway`.`customers` (

	`name` VARCHAR(32) NOT NULL UNIQUE,
    `address` VARCHAR(128) NOT NULL,
    `email` VARCHAR(128) NOT NULL,
    
    PRIMARY KEY (`name`))
    ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8;

 

	LOAD DATA INFILE '/Users/kokila/Documents/GitHub/PAFAssessment/railway/database'
	INTO TABLE `railway`.`customers`
	FIELDS TERMINATED BY ':'
	IGNORE 1 ROWS;
 
    

 CREATE TABLE IF NOT EXISTS `railway`.`order` (

	`order_id` INTEGER(8) NOT NULL UNIQUE AUTO_INCREMENT,
    `delivery_id` VARCHAR(128) NOT NULL,
    `name` VARCHAR(32) NOT NULL UNIQUE,
    `address` VARCHAR(128) NOT NULL,
    `email` VARCHAR(128) NOT NULL,
    `status` BOOLEAN,
    `orderDate` DATETIME NULL DEFAULT NULL,


    
    PRIMARY KEY (`order_id`),
    CONSTRAINT `fk_order_customers`
    FOREIGN KEY(`name`)
    REFERENCES `railway`.`customers` (`name`))
    ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8;
    
    
    
    CREATE TABLE IF NOT EXISTS `railway`.`order_status` (

	`order_id` INTEGER(8) NOT NULL UNIQUE AUTO_INCREMENT,
    `delivery_id` VARCHAR(128) NOT NULL,
    `status` BOOLEAN,
    `status_update` DATETIME NULL DEFAULT NULL,

    PRIMARY KEY (`order_id`),
    CONSTRAINT `fk_order_status_order`
    FOREIGN KEY(`delivery_id`)
    REFERENCES `railway`.`order` (`delivery_id`))
    ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8;
    
    
    

 
 
 CREATE TABLE IF NOT EXISTS `railway`.`line_item` (

    `item` VARCHAR(128) NOT NULL,
    `quantity` INTEGER(5) NOT NULL,
    
    PRIMARY KEY (`item`),
    CONSTRAINT `fk_order_customers`
    FOREIGN KEY(`name`)
    REFERENCES `railway`.`customers` (`name`))
    ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8;
    
 
