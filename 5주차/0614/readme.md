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
                  
    - 
      

2. 여러행 함수

