use market_db;

desc member;

-- 1. MySQL Workbench 도구를 사용해서 테이블 만들기

show tables; -- 테이블 목록 보기
desc member2;

-- 2. SQL로 테이블 만들기
DROP TABLE IF EXISTS member3; -- 테이블 삭제

CREATE TABLE member3 (
  mem_id VARCHAR(8) NOT NULL,  -- PRIMARY KEY, -- PK 지정 방법 1
  mem_name VARCHAR(10) NOT NULL,
  mem_number INT NOT NULL,
  addr VARCHAR(10) NOT NULL,
  phone1 VARCHAR(3) NULL,
  phone2 VARCHAR(8) NULL,
  height INT NULL,
  debut_date DATE NULL,
  -- PRIMARY KEY (mem_id) -- 기본키 지정 -- PK 지정 방법 2
  CONSTRAINT pk_member3_memid PRIMARY KEY (mem_id)
);

