-- 1. 작업 데이터베이스 선택

USE market_db; -- 이 명령 실행이후 모든 명령은 market_db를 대상으로 합니다.

-- 2. member 테이블의 mem_id, mem_name, member_number 데이터 조회
SELECT mem_id, mem_name, mem_number
FROM member;

-- 3. member 테이블의 모든 컬럼 데이터 조회
SELECT 
	mem_id, mem_name, mem_number, addr, phone1, phone2, height, debut_date
FROM member;

SELECT * -- * : 모든 컬럼
FROM member;

-- 4. 조회 컬럼을 별칭으로 조회
SELECT 
	mem_id AS '아이디', mem_name AS '이름', addr AS '주소', 
    phone1 AS '지역번호', phone2 AS '전화번호'
FROM member;

SELECT 
	mem_id '아이디', mem_name '이름', addr '주소', 
    phone1 '지역번호', phone2 '전화번호'
FROM member;

-- 4. member 테이블에서 addr 컬럼 조회 ( 회원 지역 분포 )
SELECT addr 
FROM member;

SELECT DISTINCT addr -- DISTINCT : 중복 제거
FROM member; 

-- 5. member 테이블에서 서울에 사는 회원 조회
SELECT * 
FROM member
WHERE addr = '서울';

-- 6. member 테이블에서 키가 165 이상인 회원 조회
SELECT *
FROM member
WHERE height >= 165;

