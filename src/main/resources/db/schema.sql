CREATE TABLE IF NOT EXISTS `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `userName` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `phoneNumber` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `memorandum`(
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `userName` varchar(255) DEFAULT NULL,
    `foodList` varchar(4096) DEFAULT NULL,
    PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

