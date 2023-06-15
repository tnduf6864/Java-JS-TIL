- HAVING - GROUP BY로 묶은 것들의 조건문,
- GROUP BY에서 사용한 컬럼만 여러행 함수로 SELECT에서 사용 가능
- ANSI JOIN

        SELECT ... FROM 테이블1 JOIN 테이블2 ON(테이블1.컬럼 = 테이블2.컬럼)
        SELECT ... FROM 테이블1 NATURAL JOIN 테이블2 (위험함, 별칭 못줘)
        SELECT ... FROM 테이블1 JOIN 테이블2 USING (컬럼)  (공통되는 컬럼으로 USING)

- 별칭 주는 법 (별칭을 줬으면 테이블명으로 쓰면 안돼요)

        SELECT 
            e.employee_id           AS 사번, 
            e.first_name            AS 이름,
            e.department_id         AS 부서번호, 
            d.department_name     AS 부서명,
            e.job_id                AS 직무번호, 
            j.job_title                  AS 직무명
        FROM employees e
        JOIN departments d ON (e.Department_id = d.department_id)
        JOIN jobs j        ON (e.job_id = j.job_id);

- 모든 국가의 정보 출력 (도시가 등록안된 국가도 출력한다)
  
                SELECT 
                    country_id AS 국가번호,
                    country_name AS 국가이름,
                    locations.city AS 도시명
                FROM countries LEFT JOIN locations USING (country_id);
(LEFT, RIGHT의 기준이 되는 것이 기준테이블. 위의 예제에선 countries)
  
