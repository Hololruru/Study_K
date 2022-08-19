-- 작업 데이터베이스 변경
USE market_db;

SELECT * FROM member;

-- 1. 전체 회원수 조회
SELECT COUNT(mem_id) -- COUNT(컬럼이름) : 갯수를 조회하는 집계함수
FROM member;

-- 2. 회원 키의 평균, 최대, 최소 값 조회
SELECT AVG(height) 평균키, MAX(height) 최대키, MIN(height) 최소키
FROM member;

-- 3. 전체 멤버수 조회
SELECT SUM(mem_number) 전체멤버수
FROM member;

SELECT * FROM buy;

-- 4. 회원별 구매액 합계, 구매액 평균, 구매 건수 조회
SELECT mem_id, 
	   SUM(price * amount) 총구매액, 
       AVG(price * amount) 평균구매액, 
       COUNT(price) 구매건수
FROM buy
GROUP BY mem_id;

-- 4. 제품별 판매액 합계, 판매액 평균, 판매 건수 조회
SELECT prod_name, 
	   SUM(price * amount) 총판매액, 
       AVG(price * amount) 평균판매액, 
       COUNT(price) 판매건수
FROM buy
GROUP BY prod_name;

-- 5. 총구매액이 1000이상인 회원 조회
SELECT mem_id, 
	   SUM(price * amount) 총구매액
FROM buy
-- WHERE SUM(price * amount) >= 1000 -- 오류 : group 집계함수 where절 사용 X
GROUP BY mem_id
HAVING SUM(price * amount) >= 1000 -- HAVING : GROUP BY 다음에 조건 검사
ORDER BY SUM(price * amount);




