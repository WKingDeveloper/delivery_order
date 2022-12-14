SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE `Order`;
TRUNCATE `User`;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `Order` (`id`, `address_1`, `address_2`, `paymentStatus`, `platform`, `request`, `price`, `status`, `issued`, `editable` ,`phoneNumber`)
VALUES
    (1, '역삼동 709-11 한라아파트','302호', 'DONE', 'SELF', '문 앞에 놔주세요', 32000, 'PAID' , false, false,'010-8973-8872'),
    (2, '삼성동 62-1 신라호텔','웨딩홀 2층 302호', 'DONE', 'YOGIYO', '안전 운전해서 와주세요', 30000, 'PACKING' , false, true,'010-8973-8872'),
    (3, '삼성동 3-9','603호', 'CARD', 'BAEMIN', '수저,포크 가져다 주세요', 12000, 'ISSUED' , true, false,"010-8973-8872"),
    (4, '역삼동 620-12 바로빌라','104동 302호', 'CASH', 'BAEMIN', '문앞에서 연락주세요', 15000, 'ISSUED' , true, true,'010-8973-8872'),
    (5, '삼성동 45-1','507호', 'CARD', 'YOGIYO', '', 45000, 'COMPLETED' , true, false,'010-8973-8872');

COMMIT;
