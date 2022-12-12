CREATE TABLE IF NOT EXISTS `Order` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `address_1` varchar(1024) NOT NULL,
    `address_2` varchar(1024) NOT NULL,
    `paymentStatus` varchar(64) NOT NULL,
    `platform` varchar(128) NOT NULL,
    `request` varchar(1024) NOT NULL,
    `price` decimal(19,2) NOT NULL,
    `status` varchar(64) NOT NULL,
    `issued` tinyint(1) NOT NULL,
    `editable` tinyint(1) NOT NULL,
    `phoneNumber` varchar(64) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;