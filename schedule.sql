-- user 테이블 생성
CREATE TABLE `user` (
  `userId` bigint NOT NULL COMMENT '유저 식별자',
  `name` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '이름',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '이메일',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '비밀번호',
  `createdDate` timestamp NOT NULL COMMENT '등록일',
  `modifiedDate` timestamp NOT NULL COMMENT '수정일',
  PRIMARY KEY (`userId`)
);

-- schedule 테이블 생성
CREATE TABLE `schedule` (
  `id` bigint NOT NULL COMMENT '일정 식별자',
  `userId` bigint NOT NULL COMMENT '유저 식별자',
  `title` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '할일 제목',
  `contents` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '할일 내용',
  `createdDate` timestamp NOT NULL COMMENT '작성일',
  `modifiedDate` timestamp NOT NULL COMMENT '수정일',
  PRIMARY KEY (`id`),
  KEY `schedule_user_FK` (`userId`),
  CONSTRAINT `schedule_user_FK` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE
);
