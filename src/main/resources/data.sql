SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE `Order`;
TRUNCATE `OrderProduct`;
TRUNCATE `User`;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `Order` (`id`, `address_1`, `address_2`, `paymentStatus`, `platform`, `request`, `price`, `status`, `issued`, `editable` ,`phoneNumber`,`createdAt`,`updatedAt`)
VALUES
    (1, '역삼동 709-11 한라아파트','302호', 'DONE', 'SELF', '문 앞에 놔주세요', 32000, 'PAID' , false, false,'010-8973-8872','2022-12-11 13:00:00','2022-12-11 13:00:00'),
    (2, '삼성동 62-1 신라호텔','웨딩홀 2층 302호', 'DONE', 'YOGIYO', '안전 운전해서 와주세요', 30000, 'PACKING' , false, true,'010-8973-8872','2022-12-12 13:00:00','2022-12-12 13:00:00'),
    (3, '삼성동 3-9','603호', 'CARD', 'BAEMIN', '수저,포크 가져다 주세요', 12000, 'ISSUED' , true, false,"010-8973-8872",'2022-12-13 13:00:00','2022-12-13 13:00:00'),
    (4, '역삼동 620-12 바로빌라','104동 302호', 'CASH', 'BAEMIN', '문앞에서 연락주세요', 15000, 'ISSUED' , true, true,'010-8973-8872','2022-12-14 13:00:00','2022-12-14 13:00:00'),
    (5, '삼성동 45-1','507호', 'CARD', 'YOGIYO', '', 45000, 'COMPLETED' , true, false,'010-8973-8872','2022-12-15 13:00:00','2022-12-15 13:00:00');
COMMIT;

INSERT INTO `OrderProduct` (`id`, `name`, `quantity`, `orderId`)
VALUES
    (1, '오징어 덮밥', 1, 1),
    (2, '탕수육 소', 1, 1),
    (3, '제육 덮밥', 1, 2),
    (4, '탕수육 소', 1, 2),
    (5, '유린기', 1, 3),
    (6, '짜장면', 1, 4),
    (7, '탕수육 대', 1, 5),
    (8, '볶음밥', 1, 5),
    (9, '짜장면', 1, 5);
COMMIT;
