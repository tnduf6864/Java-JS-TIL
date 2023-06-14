# 오라클 함수
1. 단일행 함수
  + 숫자형 함수
    - MOD(): 나머지  ex) MOD(employee_id, 2)
    - NVL(컬럼명, 변경값) ex NLV(commision_pct, 0.0)
    - LENGTH() -문자열의 길이
    - MONTHS_BETWEEN(), SYSDATE
    - TO_CHAR(변경대상, 변경형식) ex TO_CHAR(salary, 'L9,999,999.0')
    - ROUND(숫자, 소수자릿수) - 반올림
    - TRUNC(숫자, 소수자릿수) - 내림
  + 문자형 함수
    - UPPER(), LOWER(), INTICAP
    - 특정문자의 위치반환 INSTR(문자열, 찾을 문자), INSTR(문자열, 찾을 문자, 시작 할 인덱스), 결과를 못찾으면 0
    - 부분 문자열 반환 SUBSTR(문자열, 시작 인덱스), SUBSTR(문자열, 시작 인덱스, 문자열크기)
    - 문자열 제거: TRIM()
      EX) SELECT TRIM(LEADING 'a' FROM 'aaABCaDEFaGaa') -- LEDING 왼쪽 문자 a들 제거, TRAILING 오른쪽 문자 a들 제거, BOTH 양쪽 모두 제거
    - 문자열 늘리기: LPAD() RPAD()
      EX) SELECT LPAD('abc', 5, '*') FROM 테이블명 -> **abc
      EX) SELECT RPAD(LPAD('abc', 5, '*'), 7, '*') FROM employees;
    - 문자열 변환: REPLACE(),   EX) REPLACE(문자열, 찾을문자열, 바꿀문자열)
                  TRANSLATE()  EX) TRANSLATE(문자열, 찾을문자들, 바꿀문자들) - 문자하나하나 다 바꿈 
                  
                  +) REPLACE('JACK AND JUE', 'J', 'BL') -> BLACK AND BLUE
                  +) TRANSLATE('JACK AND JUE', 'J', 'BL') -> BACK AND BUE
                  0
0    -  이름에 'E', 'e'가 있는 사람들 조회
    
            SELECT employee_id, first_name FROM employees
            WHERE (INSTR(UPPER(first_name), 'E') <> 0);
            
    + LIKE연산자(느림) - WHERE LOWER(first_name) LIKE '%e%';
    EX) 이름이 J로 시작, n을 포함한 ...
      SELECT employee_id, first_name FROM employees
      WHERE first_name LIKE '%J%n' 
    EX) 11월 어쩌구..
     WHERE hire_date LIKE '__/11/__' 
      

        SELECT employee_id AS 사번, 
        salary AS 급여, 
        ROUND((salary + salary *NVL(commission_pct, 0.0)), -1) AS 실급여
        FROM employees 
        WHERE ROUND(salary + salary * NVL(commission_pct, 0.0), -1) < 10000 
        ORDER BY 실급여 DESC;
        
  + 날짜형 함수
     -  날짜용 연산자: 날짜±숫자, 날짜±날짜(일수 반환)
     -  SYSDATE, MONTHS_BEETWEEN(), ADD_MONTHS(), NEXT_DAY(SYSDATE, '월') -> 가장 가까운 월요일 날짜
       
  + 형변환함수
    - 문자형<->숫자형 TO_NUMBER(), TO_CHAR()
    - 문자형<->날짜형 TO_DATE(), TO_CHAR()
    - 자동 형변환 EX) SELECT '1' || 2 FROM DUAL; SELECT '1' + 2 FROM DUAL; WHERE hire_date >= '08/01/01'; (문자형->날짜형 자동 형변환)

          SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYYMMDD HH:MI:SS')FROM dual;
          SELECT 12345.678, TO_CHAR(12345.678, '9,999.0000') FROM dual; 뒤에게 더 작으면 ####으로뜸!
          SELECT 12345.678, TO_CHAR(12345.678, '9,999,999.0') FROM dual; -> 소숫점 반올림 12345.7
     
   + 조건함수
     -NULLIF
     -decode 삼항연산자 친구
     -CASE 
      EX) SELECT employee_id, manager_id, CASE manager_id
          WHEN IS NULL THEN '관리자없음' END
          FROM employees;
          
         SELECT employee_id, salary, 
         CASE 
            WHEN (salary >= 15000) THEN 'A'
            WHEN (salary >= 10000) THEN 'B'
            WHEN (salary >= 5000 ) THEN 'C'
            ELSE 'D'
         END AS 급여등급
         FROM employees;
         
2. 여러행 함수
  - sum(), count(), AVG(), MAX(), MIN()

        SELECT TO_CHAR(hire_date, 'YYYY') AS "입사년도", count(*)
        FROM employees
        GROUP BY TO_CHAR(hire_date, 'YYYY')
        ORDER BY 입사년도;

  - 
