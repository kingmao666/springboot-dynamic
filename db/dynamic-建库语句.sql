-- 提前建好三个库模拟一主二从 3306（master），3307（slave1），3308（slave2）

CREATE DATABASE `dynamic_apple` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE DATABASE `dynamic_peach` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `dynamic_apple`.`apple`;
CREATE TABLE `dynamic_apple`.`apple` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `color` varchar(20) NOT NULL DEFAULT '',
  `weight` decimal(12,4) NOT NULL DEFAULT '0.0000',
  `name` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `dynamic_peach`.`peach`;
CREATE TABLE `dynamic_peach`.`peach` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `color` varchar(20) NOT NULL DEFAULT '',
  `weight` decimal(12,4) NOT NULL DEFAULT '0.0000',
  `name` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;