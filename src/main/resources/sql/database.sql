CREATE SCHEMA IF NOT EXISTS valorprofs;

DROP TABLE IF EXISTS valorprofs.product;

CREATE TABLE valorprofs.product (
  `id` INT NOT NULL,
  `name` VARCHAR(25) NOT NULL,
  `available` INT NOT NULL,
  `price` INT NOT NULL,
  `description` VARCHAR(200) NULL,
  `datecreated` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));

INSERT INTO valorprofs.product
	VALUES (1,'Raul',1,10,'Expensive','2018-10-22 08:30:00'),
		(2,'Peter',0,3,'Poor','2018-10-22 09:30:00'),
		(3,'Ana',1,9,'Great','2018-10-22 09:45:00'),
		(4,'Antonio',1,7,'Normal','2018-10-22 11:00:00');
