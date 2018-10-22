DROP TABLE IF EXISTS `product`;

CREATE TABLE `valorprofs`.`product` (
  `id` INT NOT NULL,
  `name` VARCHAR(25) NOT NULL,
  `available` INT NOT NULL,
  `price` INT NOT NULL,
  `description` VARCHAR(200) NULL,
  `datecreated` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));
