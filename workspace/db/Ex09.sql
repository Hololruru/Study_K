USE market_db;

-- 1. member 테이블에 데이터 삽입
SELECT * FROM member; -- 테이블 구조 및 데이터 확인
DESC member; -- 테이블 구조 확인

INSERT INTO member 
(mem_id,mem_name,mem_number,addr,phone1,phone2,height,debut_date) -- 생략가능
VALUES ('ASP', '에스파', 4, '서울', '010', '25439963', 170, '2020-11-17');
SELECT * FROM member;

INSERT INTO member
VALUES ('ASP2', '에스파2', 4, '서울', '010', '25439963', 170, '2020-11-17');
SELECT * FROM member;

INSERT INTO member
(mem_id,mem_name,mem_number,addr) -- 선택적 컬럼인 경우 생략 불가능
VALUES ('ASP3', '에스파3', 4, '서울');
SELECT * FROM member;